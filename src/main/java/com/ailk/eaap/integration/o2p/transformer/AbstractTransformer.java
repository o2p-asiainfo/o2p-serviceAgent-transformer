package com.ailk.eaap.integration.o2p.transformer;


import java.io.File;
import java.sql.Timestamp;

import net.sf.json.JSONObject;

import org.apache.axis.utils.StringUtils;
import org.dom4j.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.ailk.eaap.integration.o2p.contractbody.util.TranIdSeqIncre;
import com.ailk.eaap.o2p.common.cache.ICacheFactory;
import com.ailk.eaap.o2p.common.util.DateUtils;
import com.ailk.eaap.o2p.common.util.date.UTCTimeUtil;
import com.ailk.eaap.op2.serviceagent.common.FileMessageBO;
import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.asiainfo.foundation.exception.BusinessException;
import com.asiainfo.foundation.log.Logger;
import com.ailk.eaap.integration.o2p.contractbody.util.LocalService;
import com.ailk.eaap.op2.bo.TransformerRule;

public abstract class AbstractTransformer implements Transformer{
	private ICacheFactory<String, Object> cacheFactory;
	private static final Logger logger = Logger.getLog(AbstractTransformer.class);
	@Autowired
	private LocalService localService;
	
	public void setCacheFactory(ICacheFactory<String, Object> cacheFactory) {
		this.cacheFactory = cacheFactory;
	}
	
	public ICacheFactory<String, Object> getCacheFactory() {
		return cacheFactory;
	}

	private TransformerRule transformerRule;
	
	public void setTransformerRule(TransformerRule transformerRule) {
		this.transformerRule = transformerRule;
	}
	
	public TransformerRule getTransformerRule() {
		return transformerRule;
	}
	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public final MessageBO<?> transform(MessageBO message,TransformerRule _transformerRule) {
		try {
			Assert.notNull(_transformerRule, "transformerRule must not be null");
			Assert.notNull(message, "message must not be null");
			//判断如果为空，生成校验流水
			if(StringUtils.isEmpty(message.getTransactionID())) {
				getTransactionId(message);
			}
			
			String reqRspFlag = "0";
			reqRspFlag = message.getReqorrsp();
			MessageBO<?> result = (MessageBO<?>) this.doTransform(message,_transformerRule);
			this.afterTransform(message,_transformerRule);
			if (result == null) {
				return null;
			}else{
				//clone some attribute
				result.setContractVersion(message.getContractVersion());
				result.setDstOrgID(message.getDstOrgID());
				result.setSrcorgcode(message.getSrcorgcode());
				result.setTransactionID(message.getTransactionID());
				result.setSrcReqTime(message.getSrcReqTime());
				result.setService(message.getService());
				result.setServiceLevel(message.getServiceLevel());
				result.setDstSyscode(message.getDstSyscode());
				result.setReqorrsp(message.getReqorrsp());
				Object msgBody = result.getMsgBody();
				
				//针对调用端点做的特殊处理
				if(msgBody instanceof Document){
					Document reqXml = (Document)msgBody;
					message.setMsgBody(reqXml);
				}else if(msgBody instanceof JSONObject){
					JSONObject reqJs = (JSONObject)msgBody;
					message.setMsgBody(reqJs.toString());
				}else if(msgBody instanceof String){
					message.setMsgBody(msgBody);
				}else if(result instanceof FileMessageBO) {
					File[] srcFiles = ((FileMessageBO)result).getFile();
					if(srcFiles != null) {
						((FileMessageBO)message).setFile(srcFiles);
					}
				}else if(msgBody instanceof File) {
					message.setMsgBody((File)msgBody);
				}else if(msgBody!=null) {
					message.setMsgBody(msgBody);
				}
				//给原来的messageBo添加msgHead
				message.setMsgHead(result.getMsgHead());
				//给原来的messageBo添加url参数
				message.setMessageMap(result.getMessageMap());
			}
			return result;
		}
		catch (BusinessException e) {
			throw new BusinessException(9101, "o2p.serviceAgent.transformer.abstractTransformer", null, e);
		}
		catch (Exception e) {
			throw new BusinessException(9100, "o2p.serviceAgent.transformer.abstractTransformer", null, e);
		}
	}
	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public final MessageBO<?> transform(MessageBO message) {
		try {
			Assert.notNull(transformerRule, "transformerRule must not be null");
			Assert.notNull(message, "message must not be null");
			//判断如果为空，生成校验流水
			if(StringUtils.isEmpty(message.getTransactionID())) {
				getTransactionId(message);
			}
			
			String reqRspFlag = "0";
			reqRspFlag = message.getReqorrsp();
			MessageBO<?> result = (MessageBO<?>) this.doTransform(message,transformerRule);
			this.afterTransform(message,transformerRule);
			if (result == null) {
				return null;
			}else{
				//clone some attribute
				result.setContractVersion(message.getContractVersion());
				result.setDstOrgID(message.getDstOrgID());
				result.setSrcorgcode(message.getSrcorgcode());
				result.setTransactionID(message.getTransactionID());
				result.setSrcReqTime(message.getSrcReqTime());
				result.setService(message.getService());
				result.setServiceLevel(message.getServiceLevel());
				result.setDstSyscode(message.getDstSyscode());
				result.setReqorrsp(message.getReqorrsp());
				Object msgBody = result.getMsgBody();
				
				//针对调用端点做的特殊处理
				if(msgBody instanceof Document){
					Document reqXml = (Document)msgBody;
					message.setMsgBody(reqXml);
				}else if(msgBody instanceof JSONObject){
					JSONObject reqJs = (JSONObject)msgBody;
					message.setMsgBody(reqJs.toString());
				}else if(msgBody instanceof String){
					message.setMsgBody(msgBody);
				}else if(result instanceof FileMessageBO) {
					File[] srcFiles = ((FileMessageBO)result).getFile();
					if(srcFiles != null) {
						((FileMessageBO)message).setFile(srcFiles);
					}
				}else if(msgBody instanceof File) {
					message.setMsgBody((File)msgBody);
				}else if(msgBody!=null) {
					message.setMsgBody(msgBody);
				}
				//给原来的messageBo添加msgHead
				message.setMsgHead(result.getMsgHead());
				//给原来的messageBo添加url参数
				message.setMessageMap(result.getMessageMap());
			}
			return result;
		}
		catch (BusinessException e) {
			throw new BusinessException(9101, "o2p.serviceAgent.transformer.abstractTransformer", null, e);
		}
		catch (Exception e) {
			throw new BusinessException(9100, "o2p.serviceAgent.transformer.abstractTransformer", null, e);
		}
	}

	private void getTransactionId(MessageBO<?> message) {
		//获取本地ipport
		String ipPort = localService.getIpPort();
		if (StringUtils.isEmpty(ipPort)) {
			logger.debug("AbstractTransformer ipport is null");
			return;
		}
		//获取本地标识
		if (null == cacheFactory.getLocalCacheClient().get(ipPort) || "".equals(cacheFactory.getLocalCacheClient().get(ipPort))) {
			logger.debug("AbstractTransformer get(ipport) is null {0}", ipPort);
			return;
		}
		String logo = cacheFactory.getLocalCacheClient().get(ipPort).toString();

		//本地标识
		if ("".equals(logo)) {
			//读取序列号
			TranIdSeqIncre.getInstance().getLogo(ipPort);
		}
		logo = cacheFactory.getLocalCacheClient().get(ipPort).toString();
		String serialNumber = "";
		try {
			//获取本地组件流水号
			serialNumber = TranIdSeqIncre.getInstance().getNum(logo, message.getSerInvokeIns().getComponentCode());
			
		}catch(Exception e) {
			throw new BusinessException(9150, "o2p.serviceAgent.transformer.SerialNumber", null, e);
		}
		if (logger.isDebugEnabled()) {
			logger.debug("transformer serialNumber {0}", serialNumber);
		}
		//获取UTC时间
		Timestamp time = UTCTimeUtil.getUTCTimestamp();
		String utc = DateUtils.getTimestampFormat("yyyyMMdd", time);
		
		String code = TranIdSeqIncre.getSIzeString(message.getSerInvokeIns().getComponentCode(), 10);
		message.setTransactionID(code + utc + logo + serialNumber);
	}
	protected abstract Object beforeTransform(MessageBO<?> message,TransformerRule transformerRule) throws Exception;
	protected abstract Object doTransform(MessageBO<?> message,TransformerRule transformerRule) throws Exception;
	protected abstract Object afterTransform(MessageBO<?> message,TransformerRule transformerRule) throws Exception;
}
