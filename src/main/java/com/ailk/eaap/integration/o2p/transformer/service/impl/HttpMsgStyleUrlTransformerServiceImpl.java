/** 
 * Project Name:o2p-serviceAgent-transformer 
 * File Name:HttpMsgStyleUrlTransformerServiceImpl.java 
 * Package Name:com.ailk.eaap.integration.o2p.transformer.service.impl 
 * Date:2016年1月29日上午11:07:49 
 * Copyright (c) 2016, www.asiainfo.com All Rights Reserved. 
 * 
*/  
  
package com.ailk.eaap.integration.o2p.transformer.service.impl;  

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;

import com.ailk.eaap.integration.o2p.message.support.MessageMapperService;
import com.ailk.eaap.integration.o2p.process.Constant;
import com.ailk.eaap.integration.o2p.transformer.GeneralTransformer;
import com.ailk.eaap.integration.o2p.transformer.service.IHttpMsgStyleUrlTransformerService;
import com.ailk.eaap.integration.o2p.transformer.service.INodeReqParseService;
import com.ailk.eaap.integration.o2p.transformer.service.ITransformerNodeValueService;
import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.asiainfo.foundation.exception.BusinessException;
import com.asiainfo.foundation.log.Logger;
import com.ailk.eaap.op2.bo.NodeDesc;
import com.ailk.eaap.op2.bo.NodeDescMapper;
import com.ailk.eaap.op2.bo.TransformerRule;
import com.jayway.jsonpath.JsonPath;

/** 
 * ClassName:HttpMsgStyleUrlTransformerServiceImpl  
 * Function: TODO ADD FUNCTION.  
 * Reason:   TODO ADD REASON.  
 * Date:     2016年1月29日 上午11:07:49  
 * @author   wuwz 
 * @version   
 * @since    JDK 1.6 
 *        
 */
public class HttpMsgStyleUrlTransformerServiceImpl implements
		IHttpMsgStyleUrlTransformerService {

	private static final Logger LOG = Logger.getLog(GeneralTransformer.class);
	private ITransformerNodeValueService transformerNodeValueService;
	private INodeReqParseService nodeReqParseService;
	
	public void setTransformerNodeValueService(
			ITransformerNodeValueService transformerNodeValueService) {
		this.transformerNodeValueService = transformerNodeValueService;
	}

	public void setNodeReqParseService(INodeReqParseService nodeReqParseService) {
		this.nodeReqParseService = nodeReqParseService;
	}

	@Override
	public MessageBO<?> msgUrlDoTransform(MessageBO<?> messageBo,
			TransformerRule transformerRule) throws DocumentException {
		
		MessageBO<String> tarMessageBo = new MessageBO<String>();
		
		List<Object> rootNdList = transformerRule.getRootNodeDescList();
		
		StringBuffer sb = new StringBuffer();
		transforMsgUrl(messageBo, transformerRule, rootNdList, sb, tarMessageBo);
		
		if(sb.length()>1) {
			
			String result = sb.substring(0, sb.lastIndexOf("&"));
			tarMessageBo.setMsgBody(result);
		}
		
		if(LOG.isDebugEnabled()) {
			
			LOG.debug("transformer to msg url result :"+ tarMessageBo.toString());
		}
		
		return tarMessageBo;
	}

	private void transforMsgUrl(MessageBO<?> messageBo,
			TransformerRule transformerRule, List<Object> rootNdList, StringBuffer sb, MessageBO<String> tarMessageBo) throws DocumentException {

		for(Object obj : rootNdList) {
			
			Map<Object, Object> parentMap = (Map<Object, Object>)obj;
			Set<Entry<Object, Object>> set = parentMap.entrySet();
			for(Entry<Object, Object> entry : set){
				
				Object keyObj = entry.getKey();
				List<Object> ndList = (List<Object>)entry.getValue();
				if(LOG.isDebugEnabled()) {
					
					LOG.debug("transforMsgUrl key :{0}", keyObj);
				}
				if(keyObj instanceof NodeDescMapper) {
					
					NodeDescMapper ndm = (NodeDescMapper)keyObj;
					NodeDesc srcNodeDesc = ndm.getSrcNode();
					NodeDesc tarNodeDesc = ndm.getTarNode();
					MessageBO<?> hisMessageBo = transformerNodeValueService.getMessageBOBySrcNode(messageBo, transformerRule,srcNodeDesc);
					String conType = transformerNodeValueService.getSrcConType(transformerRule, srcNodeDesc);
					
					otherMapper(hisMessageBo, transformerRule, ndList,ndm, conType, srcNodeDesc, tarNodeDesc, sb, tarMessageBo);
				
				} else {
					
					transforMsgUrl(messageBo, transformerRule, ndList, sb, tarMessageBo);
				}
			}
		}
	}

	private void otherMapper(MessageBO<?> messageBo,
			TransformerRule transformerRule, List<Object> ndList,
			NodeDescMapper ndm, String srcConType, NodeDesc srcNodeDesc,
			NodeDesc tarNodeDesc, StringBuffer sb, MessageBO<String> tarMessageBo) throws DocumentException {

		//target is array
		if(Constant.NODE_NUMBER_CONS_0_N.equals(tarNodeDesc.getNodeNumberCons())
				|| Constant.NODE_NUMBER_CONS_1_N.equals(tarNodeDesc.getNodeNumberCons())) {
			
			//source
			if(srcNodeDesc != null) {
				
				if(MessageMapperService.CONST_MSG_CON_TYPE_XML.equals(srcConType)) {
					
					srcXml(messageBo, transformerRule, ndm, srcNodeDesc,
							tarNodeDesc, sb, tarMessageBo);
				} else if(MessageMapperService.CONST_MSG_CON_TYPE_JSON.equals(srcConType)) {
					
					srcJson(messageBo, transformerRule, ndm, srcConType,
							tarNodeDesc, sb, tarMessageBo);
						
				}
			}
		} else {
			
			String nodeValue = transformerNodeValueService.getSrcNodeValue(srcConType, transformerRule, messageBo, ndm, null, null);
			
			setValue(messageBo, tarNodeDesc, nodeValue, sb, tarMessageBo);
		}
	}

	private void srcXml(MessageBO<?> messageBo,
			TransformerRule transformerRule, NodeDescMapper ndm,
			NodeDesc srcNodeDesc, NodeDesc tarNodeDesc, StringBuffer sb,
			MessageBO<String> tarMessageBo) throws DocumentException {
		//source
		if(srcNodeDesc != null) {
			
			Document srcMsgBody = nodeReqParseService.getSrcMsgBodyXml(messageBo);
			List<Node> srcNodes = srcMsgBody.selectNodes(srcNodeDesc.getNodePath());
			
			boolean srcArrayIsLeaf = isLeaf(srcNodes.get(0).asXML());
			
			if(srcArrayIsLeaf) {
				
				for(Node srcNode : srcNodes) {
					//source
					Document srcArrayNodeDoc2 = null;
					String srcNodeValue = "";

					if(!Constant.NODE_NUMBER_CONS_0_N.equals(srcNodeDesc.getNodeNumberCons())
							&& !Constant.NODE_NUMBER_CONS_1_N.equals(srcNodeDesc.getNodeNumberCons())) {
						
						srcArrayNodeDoc2 = DocumentHelper.parseText(srcNode.getParent().asXML());
					}
					if(MessageMapperService.CONST_OPER_TYPE_MOVE.equals(ndm.getOperTypeCd())) {
						
						srcNodeValue = srcNode.getText();
					} else {
						
						srcNodeValue = transformerNodeValueService.getSrcNodeValue(MessageMapperService.CONST_MSG_CON_TYPE_XML, 
								transformerRule, messageBo, ndm, srcArrayNodeDoc2, null);
					}
					
					setValue(messageBo, tarNodeDesc, srcNodeValue, sb, tarMessageBo);
				}
				
			} else {
				
//				throw new BusinessException(9100, "The target node is url leaf,but the source node is not leaf,pls check the mapping config. The target node path:"+tarNodeDesc.getNodePath());
				for(Node srcNode : srcNodes) {
					//source
					Document srcArrayNodeDoc2 = DocumentHelper.parseText(srcNode.asXML());
					String srcNodeValue =  transformerNodeValueService.getSrcNodeValue(MessageMapperService.CONST_MSG_CON_TYPE_XML, 
								transformerRule, messageBo, ndm, srcArrayNodeDoc2, null);
				
					setValue(messageBo, tarNodeDesc, srcNodeValue, sb, tarMessageBo);
				}
			}
		
		} else {
			
			throw new BusinessException(9100, "The target node is array,but the source node is null,pls check the mapping config. The target node path:"+tarNodeDesc.getNodePath());
		}
	}
	
	private boolean isLeaf(String nodeStr) {

		if(!StringUtils.isEmpty(nodeStr)) {
			
			String[] strs = nodeStr.split("</");
			String[] strs2 = nodeStr.split("/>");
			if(strs.length > 2 || strs2.length > 2) {
				
				return false;
			}
		}
		return true;
	}

	private void srcJson(MessageBO<?> messageBo,
			TransformerRule transformerRule, NodeDescMapper ndm,
			String srcConType, NodeDesc tarNodeDesc, StringBuffer sb,
			MessageBO<String> tarMessageBo) throws DocumentException {
		//source
		NodeDesc srcNd = ndm.getSrcNode();
		if(srcNd != null) {
			
			JSONObject srcMsgBody = nodeReqParseService.getSrcMsgBodyJson(messageBo);
			JSONArray srcJsonArray = null;
			Object obj = JsonPath.read(srcMsgBody, srcNd.getNodePath());
			if(obj instanceof JSONArray) {
				
				srcJsonArray = (JSONArray)obj;
			} else {
				
				throw new BusinessException(9100, "The target node is array,but the source json path is not array,pls check the mapping config. srcource path:"+srcNd.getNodePath());
			}
			
			for(Object srcObj : srcJsonArray) {
				
				String nodeValue = "";
				if(srcObj instanceof String && MessageMapperService.CONST_OPER_TYPE_MOVE.equals(ndm.getOperTypeCd())) {
				
					nodeValue = srcObj.toString();
				} else {
					
					JSONObject srcJson = null;
					if(srcObj instanceof JSONObject) {
						
						srcJson = (JSONObject)srcObj;
					} else if(srcObj instanceof String) {
						String srcPath = srcNd.getNodePath().substring(srcNd.getNodePath().lastIndexOf(".")+1, srcNd.getNodePath().length());
						srcJson = JSONObject.fromObject("{\""+srcPath+"\":\""+srcObj.toString()+"\"}");
					}
					
					boolean arrayCondition = true;
					if(MessageMapperService.CONST_OPER_TYPE_UPDATE.equals(ndm.getOperTypeCd())) {
						
						arrayCondition = nodeReqParseService.parseJsonCondition(MessageMapperService.CONST_MSG_CON_TYPE_JSON, messageBo, ndm, null, srcJson,srcNd);
					}
					
					if(arrayCondition) {
						
						nodeValue = transformerNodeValueService.getSrcNodeValue(MessageMapperService.CONST_MSG_CON_TYPE_JSON, 
								transformerRule, messageBo, ndm, null, srcJson);
					}
				}
				
				
				setValue(messageBo, tarNodeDesc, nodeValue, sb, tarMessageBo);
			}
		}
	}

	private void setValue(MessageBO<?> messageBo, NodeDesc tarNodeDesc,
			String nodeValue, StringBuffer sb, MessageBO<String> tarMessageBo) {

		if(!StringUtils.isEmpty(nodeValue)) {
			
			String nodeType = tarNodeDesc.getNodeType();
			String tarNodeCode = tarNodeDesc.getNodeCode();
			if(!StringUtils.isEmpty(tarNodeCode)) {
				
				if(MessageMapperService.CONST_NODE_TYPE_HEAD.equals(nodeType)) {
					
					tarMessageBo.getMsgHead().put(tarNodeCode, nodeValue);
				} else if(MessageMapperService.CONST_NODE_TYPE_BODY.equals(nodeType)) {
					
					sb.append(tarNodeCode);
					sb.append("=");
					sb.append(nodeValue);
					sb.append("&");
				} else if(MessageMapperService.CONST_NODE_TYPE_URL.equals(nodeType)) {
					
					nodeReqParseService.setMsgUrlParam(tarMessageBo, tarNodeCode, nodeValue);
				}
			}
		}
	}
}