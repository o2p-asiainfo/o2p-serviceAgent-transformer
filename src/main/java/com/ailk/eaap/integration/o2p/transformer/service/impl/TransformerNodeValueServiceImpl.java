/** 
 * Project Name:o2p-serviceAgent-transformer 
 * File Name:TransformerNodeValueServiceImpl.java 
 * Package Name:com.ailk.eaap.integration.o2p.transformer.service.impl 
 * Date:2016年1月8日下午2:17:08 
 * Copyright (c) 2016, www.asiainfo.com All Rights Reserved. 
 * 
*/  
  
package com.ailk.eaap.integration.o2p.transformer.service.impl;  



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.springframework.scripting.ScriptSource;
import org.springframework.scripting.support.StaticScriptSource;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;

import com.ailk.eaap.integration.o2p.contractbody.util.ContractBodyUtil;
import com.ailk.eaap.integration.o2p.message.support.MessageMapperService;
import com.ailk.eaap.integration.o2p.script.ScriptExecutor;
import com.ailk.eaap.integration.o2p.script.jsr223.ScriptExecutorFactory;
import com.ailk.eaap.integration.o2p.transformer.service.INodeReqParseService;
import com.ailk.eaap.integration.o2p.transformer.service.ITransformerNodeValueService;
import com.ailk.eaap.o2p.common.cache.CacheKey;
import com.ailk.eaap.o2p.common.cache.ICache;
import com.ailk.eaap.op2.bo.ContractFormat;
import com.ailk.eaap.op2.bo.NodeDesc;
import com.ailk.eaap.op2.bo.NodeDescMapper;
import com.ailk.eaap.op2.bo.NodeValReq;
import com.ailk.eaap.op2.bo.ParamVarMap;
import com.ailk.eaap.op2.bo.TransformerRule;
import com.ailk.eaap.op2.common.O2pDocumentHelper;
import com.ailk.eaap.op2.serviceagent.common.EOPDomain;
import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.ailk.eaap.op2.serviceagent.deal.service.IMessageBoHisService;
import com.ailk.eaap.op2.serviceagent.deal.service.MessageBoHisServiceImpl;
import com.asiainfo.foundation.exception.BusinessException;
import com.asiainfo.foundation.log.Logger;
import com.jayway.jsonpath.JsonPath;

/** 
 * ClassName:TransformerNodeValueServiceImpl  
 * Function: TODO ADD FUNCTION.  
 * Reason:   TODO ADD REASON.  
 * Date:     2016年1月8日 下午2:17:08  
 * @author   wuwz 
 * @version   
 * @since    JDK 1.6 
 *        
 */
public class TransformerNodeValueServiceImpl implements
		ITransformerNodeValueService {

	private static final Logger LOG = Logger.getLog(TransformerNodeValueServiceImpl.class);
	
	private INodeReqParseService nodeReqParseService;
	private IMessageBoHisService messageBoHisSer;
	private ICache<String, Object> cache;
	private ScriptExecutorFactory scriptExecutorFactory;
	
	public void setNodeReqParseService(INodeReqParseService nodeReqParseService) {
		this.nodeReqParseService = nodeReqParseService;
	}


	public void setMessageBoHisSer(IMessageBoHisService messageBoHisSer) {
		this.messageBoHisSer = messageBoHisSer;
	}

	public void setCache(ICache<String, Object> cache) {
		this.cache = cache;
	}

	public void setScriptExecutorFactory(ScriptExecutorFactory scriptExecutorFactory) {
		this.scriptExecutorFactory = scriptExecutorFactory;
	}


	private String getValueByExpress(String conType, MessageBO<?> messageBo, 
			NodeDescMapper ndm, Document srcArrayNodeDoc, JSONObject srcJson) throws DocumentException {

		NodeValReq nvr = ndm.getTarNodeValReq();
		NodeDesc srcNode = ndm.getSrcNode();
		if(nvr != null) {
			
			String express = nvr.getValueExpress();
			String expressType = nvr.getNodeValSourceCd();
			
			if(LOG.isDebugEnabled()) {
				
				LOG.debug("====the get value express is:"+ express);
			}

			if(MessageMapperService.CONST_NODE_VAL_TYPE_FIX.equals(expressType)) {
				
				return express;
			} else if(MessageMapperService.CONST_NODE_VAL_TYPE_MAP.equals(expressType)) {
				
				String nodeValue = getSrcNodeValueMove(conType, messageBo, ndm, srcArrayNodeDoc, srcJson);
				
				String preKey = CacheKey.PARAM_VAR_MAP + express;
				
				ParamVarMap paramVarMap = (ParamVarMap) cache.getByTenantId(preKey + nodeValue,messageBo.getTenant().getTenantId());
				if(paramVarMap == null) {
					
					paramVarMap = (ParamVarMap) cache.getByTenantId(preKey + "_OTHER_VALUE_",messageBo.getTenant().getTenantId());
				}
				Assert.notNull(paramVarMap,
						"check your configure,table NODE_VAL_ADAPTER_REQ.VALUE_EXPRESS and table VARIABLE_MAP,the key:"+ messageBo.getTenant().getTenantId()+preKey + nodeValue);
				return paramVarMap.getVal();
				
			} else if(MessageMapperService.CONST_NODE_VAL_TYPE_SCRIPT.equals(expressType)) {
				
				ScriptExecutor scriptExecutor = scriptExecutorFactory.getScriptExecutor("bsh");
	            Assert.notNull(nvr.getScript());
	            Map<String, Object> variables = new HashMap<String, Object>();
	            variables.put("srcNodeVal", this.getSrcNodeValueMove(conType, messageBo, ndm, srcArrayNodeDoc, srcJson));
	            variables.put("message", messageBo);
	            ScriptSource scriptSource = new StaticScriptSource(nvr.getScript());
	            Object ret = scriptExecutor.executeScript(scriptSource, variables);
	            return ObjectUtils.nullSafeToString(ret);
			} else if(MessageMapperService.CONST_NODE_VAL_TYPE_MERGE.equals(expressType)) {
				
			} else if(MessageMapperService.CONST_NODE_VAL_TYPE_OGNL.equals(expressType)) {
				
				Object obj = ContractBodyUtil.getExprVal(messageBo, express.trim());
				
		        return obj == null? "" : obj.toString();
			} else if(MessageMapperService.CONST_NODE_VAL_TYPE_CONDITION.equals(expressType)) {
				
				return nodeReqParseService.parseJson(conType, messageBo, express, srcArrayNodeDoc, srcJson, srcNode);
			}
		}
		
		return "";
	}



	@Override
	public String getSrcNodeValue(String conType,
			TransformerRule transformerRule, MessageBO<?> messageBo,
			NodeDescMapper ndm, Document srcArrayNodeDoc, JSONObject srcJson) throws DocumentException {

		String oType = ndm.getOperTypeCd();
		
		if(MessageMapperService.CONST_OPER_TYPE_MOVE.equals(oType)) {
			
			return getSrcNodeValueMove(conType, messageBo, ndm, srcArrayNodeDoc, srcJson);
		} else {
			
			return getValueByExpress(conType, messageBo, ndm, srcArrayNodeDoc, srcJson);
		}
	}

	private String getSrcNodeValueMove(String conType, MessageBO<?> messageBo, NodeDescMapper ndm, Document srcArrayNodeDoc, JSONObject srcJson) throws DocumentException {

		NodeDesc srcNodeDesc = ndm.getSrcNode();
		if(srcNodeDesc != null) {
			
			String srcNodeType = srcNodeDesc.getNodeType();
			String srcNodePath = srcNodeDesc.getNodePath();
			
			return nodeReqParseService.getNodeValue(conType, messageBo, srcNodePath, srcNodeType, srcArrayNodeDoc, srcJson);
		}
		
		return "";
	}

	public MessageBO getMessageBOBySrcNode(MessageBO<?> messageBo,
			TransformerRule transformerRule, NodeDesc srcNodeDesc) {
		
		MessageBO hisMessageBo = MultiSource(transformerRule, srcNodeDesc, messageBo);
		if(hisMessageBo == null) {
			
			hisMessageBo = messageBo;
			if(LOG.isDebugEnabled()) {
				
				LOG.debug("=====> hisMessageBo is null");
			}
		}
		
		if(LOG.isDebugEnabled()) {
			
			LOG.debug("=====> the MessageBo is {0}:", messageBo.toString());
		}
		
		return hisMessageBo;
	}

	private MessageBO<?> MultiSource(TransformerRule transformerRule, NodeDesc srcNodeDesc, MessageBO<?> messageBo) {

		if(srcNodeDesc != null) {
			
			ContractFormat srcCf = getSrcContractFormat(transformerRule, srcNodeDesc);
			if(srcCf != null) {
				
				if(transformerRule.getNodeDescToEndpointMap() != null) {
					
					Integer endpointId = transformerRule.getNodeDescToEndpointMap().get(
			                 srcNodeDesc.getNodeDescId());
					
					if(LOG.isDebugEnabled()) {
						
						LOG.debug("====> endpointId: {0}, nodeDescEndpointId:{1}", endpointId, transformerRule.getNodeDescToEndpointMap().toString());
					}
					
					if(endpointId != null) {
						
						String reqOrRsp = srcCf.getReqRsp();
						if (MessageBoHisServiceImpl.REQ.equals(reqOrRsp)) {
							
							return messageBoHisSer.getReqMessageBoByEpId(endpointId, messageBo);
						} else if (MessageBoHisServiceImpl.RSP.equals(reqOrRsp)) {
							
							return messageBoHisSer.getRspMessageBoByEpId(endpointId, messageBo);
				        }
					}
				}
			}
		}
		
		return null;
	}
	
	private ContractFormat getSrcContractFormat(TransformerRule transformerRule, NodeDesc srcNodeDesc) {

		if(transformerRule.getNodeDescToContractFormatMap() != null && srcNodeDesc != null) {
			
			if(LOG.isDebugEnabled()) {
				
				LOG.debug("====> srcNodeDescId: {0} contractMap: {1}",srcNodeDesc.getNodeDescId(), transformerRule.getNodeDescToContractFormatMap().toString());
			}
			return transformerRule.getNodeDescToContractFormatMap().get(
	                        srcNodeDesc.getNodeDescId());
		}
		return null;
	}

	public String getSrcConType(TransformerRule transformerRule, NodeDesc srcNodeDesc) {
		
		ContractFormat cf = getSrcContractFormat(transformerRule, srcNodeDesc);
		if(cf == null) {
			
			cf = transformerRule.getSrcContractFormat();
		}
		
		return cf.getConType();
	}


	@Override
	public void setTarContentType(MessageBO<?> messageBo, String type, String contentType) {

		Object tarContentType = messageBo.getMsgHead().get(EOPDomain.CONTENT_TYPE);
		Object tarConType = messageBo.getMsgHead().get(EOPDomain.CONTENT_TYPE.toLowerCase());
		
		if(tarContentType == null) {
			
			tarContentType = tarConType;
		}
		
		boolean isNeedSetConT = true;
		
		if(tarContentType != null && tarContentType.toString().toLowerCase().contains(type)) {
			
			isNeedSetConT = false;
		}
		
		if(isNeedSetConT) {
			
			messageBo.getMsgHead().put(EOPDomain.CONTENT_TYPE, contentType);
			
			if(LOG.isDebugEnabled()) {
				
				LOG.debug("====>set default content type {0}", contentType);
			}
		}
		
	}

	@Override
	public void setUrlHeadValue(MessageBO<?> messageBo,
			TransformerRule transformerRule, NodeDescMapper ndm,
			String conType, NodeDesc tarNodeDesc, MessageBO<?> tarMessageBo) throws DocumentException {

		String nodeValue = getSrcNodeValue(conType, transformerRule, messageBo, ndm, null, null);
		
		if(LOG.isDebugEnabled()) {
			
			LOG.debug("The node value is: {0}", nodeValue);
		}
		
		if(!StringUtils.isEmpty(nodeValue)) {
			
			String nodeType = tarNodeDesc.getNodeType();
			String tarNodeCode = tarNodeDesc.getNodeCode();
			if(!StringUtils.isEmpty(tarNodeCode)) {
				
				if(MessageMapperService.CONST_NODE_TYPE_HEAD.equals(nodeType)) {
					
					tarMessageBo.getMsgHead().put(tarNodeCode, nodeValue);
				}  else if(MessageMapperService.CONST_NODE_TYPE_URL.equals(nodeType)) {
					
					nodeReqParseService.setMsgUrlParam(tarMessageBo, tarNodeCode, nodeValue);
				}
			}
		}
	}
	
	public void setXmlBodyValue(MessageBO<?> messageBo, Document tarDoc,
			NodeDesc tarNodeDesc, String nodeValue, MessageBO<Document> tarMessageBo) throws DocumentException {
		
		if(!StringUtils.isEmpty(nodeValue) && !StringUtils.isEmpty(nodeValue.trim())) {
			
			String tarPath = tarNodeDesc.getNodePath();
			if(tarPath.contains(MessageMapperService.XML_PATH_SPLIT)) {
				
				String[] paths = tarPath.split(MessageMapperService.XML_PATH_SPLIT);
				String parentPath = paths[0];
				String path = paths[1];

				if(parentPath.endsWith("/")) {
					
					parentPath = parentPath.substring(0, parentPath.length()-1);
				}
				Map<String, Object> cdataMap = tarMessageBo.getSubMsgBodyMap();
				Object cDataObj = cdataMap.get(parentPath);
				
				if(cDataObj == null) {
					
					cDataObj = getCdata(tarMessageBo, tarDoc, parentPath);
				}
				
				if(cDataObj instanceof Document) {
					
					setXmlNodeValue((Document)cDataObj, nodeValue, path);
				} else if(cDataObj instanceof JSONObject) {
					
					String subTarPath = tarPath.substring(tarPath.lastIndexOf(".")+1, tarPath.length());
					setJsonBodyValue((JSONObject)cDataObj, tarNodeDesc, tarPath, subTarPath, nodeValue);
				}
				
			} else {
				
				setXmlNodeValue(tarDoc, nodeValue, tarPath);
			}
		}
	}
	
	private void setXmlNodeValue(Document tarDoc, String nodeValue, String tarPath) {

		Node node = tarDoc.selectSingleNode(tarPath);
		if(node != null) {
				
			node.setText(nodeValue);
			
		} else {
			
			if(LOG.isDebugEnabled()) {
				
				LOG.debug(" ======> Get target node fail, node is null, the target path is:"+tarPath);
			}
		}
	}
	
	private Document getCdata(MessageBO<Document> tarMessageBo, Document tarDoc,
			String parentPath) throws DocumentException {

		Node node = tarDoc.selectSingleNode(parentPath);
		if(LOG.isDebugEnabled()) {
			
			LOG.debug(" ======> tarDoc:"+tarDoc.asXML()+"/t/n node:"+node.asXML());
		}
		String cdataContent = node.getText();
		node.setText("");
		if(cdataContent.trim().startsWith("<![CDATA")) {
			
			cdataContent = cdataContent.substring(9, cdataContent.length()-3);
		}
		
		Document cDataDoc = O2pDocumentHelper.parseText(cdataContent.trim());
		
		tarMessageBo.getSubMsgBodyMap().put(parentPath, cDataDoc);
		return cDataDoc;
	}
	
	public void setJsonBodyValue(JSONObject tarJson,
			NodeDesc tarNodeDesc, String tarPath, String subTarPath, String nodeValue) {
		
		if(!StringUtils.isEmpty(nodeValue) && !StringUtils.isEmpty(tarPath)) {
				
				String parentTarPath = tarPath.substring(0, tarPath.lastIndexOf("."));
				JSONObject parentObj = JsonPath.read(tarJson, parentTarPath);
				
				Object valueObj = nodeReqParseService.changeValueObj(nodeValue, tarNodeDesc);

				Object tarObj = JsonPath.read(tarJson, tarPath);
				if(tarObj instanceof JSONArray) {
					
					((JSONArray)tarObj).add(valueObj);
				} else {
					
					parentObj.put(subTarPath, valueObj);
				}
		}
	}
	
	@Override
	public JSONArray getSrcJson(MessageBO<?> messageBo, JSONObject srcJson,
			NodeDesc srcNd) {

		Object obj = getSrcJsonObj(messageBo, srcJson, srcNd);
		JSONArray srcJsonArray = null;
		if(obj instanceof JSONArray) {
			
			srcJsonArray = (JSONArray)obj;
		} else {
			
			throw new BusinessException(9100, "The target node is array,but the source json path is not array,pls check the mapping config. srcource path:"+srcNd.getNodePath());
		}
		return srcJsonArray;
	}


	public Object getSrcJsonObj(MessageBO<?> messageBo, JSONObject srcJson,
			NodeDesc srcNd) {
		JSONObject srcMsgBody = null;
		String srcArrPath = srcNd.getNodePath();
		if(srcJson != null) {
			srcArrPath =  getSubPath(srcArrPath);
			srcMsgBody = srcJson;
		} else {
			
			srcMsgBody = nodeReqParseService.getSrcMsgBodyJson(messageBo);
		}
		
		Object obj = JsonPath.read(srcMsgBody, srcArrPath);
		return obj;
	}
	
	public String getSubPath(String srcPath) {
		String subSrcPath = srcPath.substring(srcPath.lastIndexOf(".")+1, srcPath.length());
		return subSrcPath;
	}


	@Override
	public List<Node> getSrcXml(MessageBO<?> messageBo,
			Document srcArrayNodeDoc, NodeDesc srcNodeDesc) throws DocumentException {

		Document srcMsgBody = null;
		String srcNodePath = srcNodeDesc.getNodePath();
		if(srcArrayNodeDoc != null) {
			
			srcMsgBody = srcArrayNodeDoc;
			srcNodePath = getSubPathXml(srcNodePath);
		} else {
			
			srcMsgBody = nodeReqParseService.getSrcMsgBodyXml(messageBo);
		}
		
		List<Node> srcNodes = srcMsgBody.selectNodes(srcNodePath);
		return srcNodes;
	}
	
	public String getSubPathXml(String srcNodePath) {
		srcNodePath = "//"+srcNodePath.substring(srcNodePath.lastIndexOf("/")+1, srcNodePath.length());
		return srcNodePath;
	}
	
	@Override
	public boolean isLeafXml(String nodeStr) {

		if(!StringUtils.isEmpty(nodeStr)) {
			
			String[] strs = nodeStr.split("</");
			String[] strs2 = nodeStr.split("/>");
			if(strs.length > 2 || strs2.length > 2) {
				
				return false;
			}
		}
		return true;
	}
}
