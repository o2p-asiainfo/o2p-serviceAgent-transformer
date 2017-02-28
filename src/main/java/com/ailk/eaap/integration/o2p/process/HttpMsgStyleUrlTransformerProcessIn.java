package com.ailk.eaap.integration.o2p.process;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.Assert;

import com.ailk.eaap.integration.o2p.contractbody.util.ContractBodyUtil;
import com.ailk.eaap.integration.o2p.transformer.MessageTransformationException;
import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.asiainfo.foundation.exception.BusinessException;
import com.asiainfo.foundation.log.LogModel;
import com.asiainfo.foundation.log.Logger;
import com.ailk.eaap.op2.bo.ContractFormat;
import com.ailk.eaap.op2.bo.MessageDesc;
import com.ailk.eaap.op2.bo.MessageNode;
import com.ailk.eaap.op2.bo.NodeDesc;
import com.linkage.rainbow.util.StringUtil;

public class HttpMsgStyleUrlTransformerProcessIn extends AbstractTransformerProcessIn {

	private static final Logger LOG = Logger
			.getLog(HttpMsgStyleUrlTransformerProcessIn.class);

	@SuppressWarnings("rawtypes")
	@Override
	public MessageBO<?> processContent(MessageDesc md, MessageBO<?> bo) throws Exception {
		Assert.notNull(md, "The HttpMsgStyleUrl md is null");
		MessageBO<String> tarBO = new MessageBO<String>();
		StringBuffer sb = new StringBuffer();
		for (MessageNode mn : md.getMessageNodes()) {
			NodeDesc nd = mn.getNodeDesc();
			if (Constant.NODETYPE_BODY.equals(nd.getNodeType())) {
				if (mn.getNodeVal() instanceof List) {
					List list = (List) mn.getNodeVal();
					sb.append(nd.getNodeCode() + "=" + list.get(0));
					sb.append("&");
				} else {
					sb.append(nd.getNodeCode() + "=" + mn.getNodeVal());
					sb.append("&");
				}
			}
		}
		if(sb.length() > 1) {
			tarBO.setMsgBody(sb.substring(0,sb.length()-1));
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("Msg Style Body process : {0}",tarBO.getMsgBody());
		}
		Map<String, Object> msgHeadMap = new HashMap<String, Object>();
		msgHeadMap.putAll(md.getHeaders());
		msgHeadMap.putAll(super.msgHeader(md));
		Map<String, Object> msgUrlMap = super.MsgUrl(md);
		if (LOG.isDebugEnabled()) {
			LOG.debug("Msg Style Header process : {0}", msgHeadMap.toString());
			LOG.debug("Msg Style Url process : {0}", msgUrlMap.toString());
		}
		tarBO.setMsgHead(msgHeadMap);
		tarBO.setMessageMap(msgUrlMap);
		tarBO.setTransactionID(bo.getTransactionID());

		return tarBO;
	}

	@Override
	public Object parseNodeValBySrcMsg(MessageBO<?> srcMsg,
			ContractFormat contractFormat, NodeDesc nodeDesc) {
		if(StringUtil.isEmpty(srcMsg.toString())) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("The Http Msg Style URL MsgBody is null");
			}
		}
		
		if (nodeDesc != null) {
			try {
				Object obj = ContractBodyUtil.getNodeValByNodeDesc(srcMsg, nodeDesc);
				
				if (LOG.isDebugEnabled()) {
					if (obj != null) {
						LOG.debug("nodeDesc id :{0} value : {1}", nodeDesc.getNodeDescId(), obj.toString());
					}
					else {
						LOG.debug("nodeDesc id :{0} value is null", nodeDesc.getNodeDescId());
					}
					
				}
				return obj;
			} catch (MessageTransformationException e) {
				throw new BusinessException(9141,
						"o2p.serviceAgent.transformer.xmlPath", null, e);
			} catch (Exception e) {
				LOG.error(LogModel.EVENT_APP_EXCPT,
						"Parsing XPATH error id : {0}, node_path : {1}",
						nodeDesc.getNodeDescId(), nodeDesc.getNodePath());
				throw new BusinessException(9141,
						"o2p.serviceAgent.transformer.xmlPath", null, e);
			}
		}
		return null;
	}
}
