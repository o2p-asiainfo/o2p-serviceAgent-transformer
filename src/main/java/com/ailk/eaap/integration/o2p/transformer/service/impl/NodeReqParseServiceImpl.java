/** 
 * Project Name:o2p-serviceAgent-transformer 
 * File Name:NodeReqParseServiceImpl.java 
 * Package Name:com.ailk.eaap.integration.o2p.transformer.service.impl 
 * Date:2016年1月13日下午7:16:40 
 * Copyright (c) 2016, www.asiainfo.com All Rights Reserved. 
 * 
*/  
  
package com.ailk.eaap.integration.o2p.transformer.service.impl;  

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;

import com.ailk.eaap.integration.o2p.function.FelFunction;
import com.ailk.eaap.integration.o2p.message.support.MessageMapperService;
import com.ailk.eaap.integration.o2p.process.Constant;
import com.ailk.eaap.integration.o2p.transformer.service.INodeReqParseService;
import com.ailk.eaap.o2p.common.cache.ICache;
import com.ailk.eaap.o2p.common.cache.ICacheFactory;
import com.ailk.eaap.op2.common.O2pDocumentHelper;
import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.asiainfo.foundation.log.Logger;
import com.ailk.eaap.op2.bo.NodeDesc;
import com.ailk.eaap.op2.bo.NodeDescMapper;
import com.ailk.eaap.op2.bo.NodeValReq;
import com.greenpineyu.fel.FelEngine;
import com.greenpineyu.fel.context.FelContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.PathNotFoundException;

/** 
 * ClassName:NodeReqParseServiceImpl  
 * Function: TODO ADD FUNCTION.  
 * Reason:   TODO ADD REASON.  
 * Date:     2016年1月13日 下午7:16:40  
 * @author   wuwz 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public class NodeReqParseServiceImpl implements INodeReqParseService {

	private static final Logger LOG = Logger.getLog(NodeReqParseServiceImpl.class);
	private static final String NODE_NUM = "nodeNum";
	private static final String NEED_NODE_PATH = "needNodePath";
	private ICacheFactory<String, Object> cacheFactory;
	
	@Override
	public Document getSrcMsgBodyXml(MessageBO message) throws DocumentException {

		Document srcMsgDoc = null;
		
		Object obj = message.getMsgBody();
		if(obj instanceof Document) {
			
			srcMsgDoc = (Document)obj;
		} else if(obj instanceof String){
			
			srcMsgDoc = O2pDocumentHelper.parseText(obj.toString());
			message.setMsgBody(srcMsgDoc);
		}
		
		return srcMsgDoc;
	}
	
	@Override
	public JSONObject getSrcMsgBodyJson(MessageBO message) {

		JSONObject srcMsgJson = null;
		Object obj = message.getMsgBody();
		
		if(obj instanceof JSONObject) {
			
			srcMsgJson = (JSONObject)obj;
		} else if(obj instanceof String){
			
			try {
				
				srcMsgJson = JSONObject.fromObject(obj.toString());
			} catch(JSONException e) {
				
				LOG.warn("json format error ", e);
				srcMsgJson = JSONObject.fromObject("{}");
			}
			message.setMsgBody(srcMsgJson);
		}
		
		return srcMsgJson;
	}
	
	public String parseJson(String conType, MessageBO<?> messageBo, 
			String express, Document srcArrayNodeDoc, JSONObject srcJson, NodeDesc srcNode) throws DocumentException {

		JSONObject json = JSONObject.fromObject(express);
		JSONObject globalCondition = json.getJSONObject("globalCondition");
		if(parseCondition(conType, messageBo, globalCondition, srcArrayNodeDoc, srcJson, srcNode)) {
			
			FelFunction engine = getFelEngine();
			
			JSONArray logicGetValue = json.getJSONArray("logicGetValue");
			parseSegment(engine, conType, messageBo, logicGetValue, srcArrayNodeDoc, srcJson, srcNode);
			
			String finalAssign = json.getString("finalAssign");
			return parseFinalValue(engine, finalAssign);
		}
		
		return "";
	}

	private FelFunction getFelEngine() {
		FelFunction function = new FelFunction(cacheFactory);
		return function;
	}

	private String parseFinalValue(FelFunction engine, String finalAssign) {
		
		FelContext variableMap = engine.getContext();
		finalAssign = finalAssign.replace("fn:", "");

		finalAssign = finalAssign.replace("$", "");
		Object result = engine.eval(finalAssign);
		
		if(LOG.isDebugEnabled()) {
			
			LOG.debug("=====> the final express is:"+finalAssign+"====> variableMap:"+variableMap.toString()
					+ " ====> final value is:" + result+ " ====> variableValue is:" + variableMap.get(finalAssign));
		}
		return result == null ? "" : result.toString();
	}

	private void parseSegment(FelFunction engine, String conType, MessageBO messageBo,
			JSONArray logicGetValue, Document srcArrayNodeDoc, JSONObject srcJson, NodeDesc srcNode) throws DocumentException {

		FelContext variableMap = engine.getContext();
		
		for(Object segmentObj : logicGetValue) {
			
			JSONObject segment = (JSONObject)segmentObj;
			
			JSONObject condition = segment.getJSONObject("condition");
			
			JSONObject assign = segment.getJSONObject("assign");
			String variableName = assign.getString("variable");

			if(parseCondition(conType, messageBo, condition, srcArrayNodeDoc, srcJson, srcNode)) {
				
				JSONArray variables = assign.getJSONArray("variables");
				String valueExpress = assign.getString("valueExpress");
				
				FelFunction vEngine = getFelEngine();
				Object result = parseVariables(conType, messageBo, variables, valueExpress, vEngine, srcArrayNodeDoc, srcJson, srcNode);
				if(LOG.isDebugEnabled()) {
					
					LOG.debug("====>> the srcNode value is"+result);
					LOG.debug("====>> Set variableName:"+variableName+", variableValue:"+result);
					LOG.debug("====>> variableMap:"+variableMap.toString());
				}

				variableMap.set(variableName, result);
				
			} else if(variableMap.get(variableName) == null) {
					
					variableMap.set(variableName, "");
					if(LOG.isDebugEnabled()) {
						
						LOG.debug("====> the variable set null value, variable name is:"+variableName);
					}
			}
		}
	}

	private boolean parseCondition(String conType, MessageBO messageBo, JSONObject condition, 
			Document srcArrayNodeDoc, JSONObject srcJson, NodeDesc srcNode) throws DocumentException {

		if(condition == null ||  condition.isNullObject()) {
			
			return true;
		}
		String express = condition.getString("express");
		
		if(StringUtils.isEmpty(express)) {
			
			return true;
		}
		
		JSONArray variables = condition.getJSONArray("variables");
		
		FelFunction engine = getFelEngine();
	
		Object result = parseVariables(conType, messageBo, variables, express, engine, srcArrayNodeDoc, srcJson, srcNode);
		if(LOG.isDebugEnabled()) {
			
			LOG.debug("the condition result:"+result);
		}
		return Boolean.valueOf(result.toString());
	}


	public Object parseVariables(String conType, MessageBO<?> messageBo, JSONArray variables,
			String express, FelFunction engine, Document srcArrayNodeDoc, JSONObject srcJson, NodeDesc srcNode) throws DocumentException {
		
		FelContext variableMap = engine.getContext();
		
		if(StringUtils.isEmpty(express)) {
			
			if(LOG.isDebugEnabled()) {
				
				LOG.debug("====> The variables express is empty!");
			}
			
			return "";
		}
		
		if(variables != null) {
			
			for(Object variableObj : variables) {
				
				JSONObject variable = (JSONObject)variableObj;
				String srcNodePath = variable.getString("srcNodePath");
				String variableName = variable.getString("variable");
				String srcNodeType = variable.getString("srcNodeType");
				String nodeNum = "";
				String needNodePath = "";
				if(variable.containsKey(NODE_NUM)) {
					
					nodeNum = variable.getString(NODE_NUM);
				}
				if(variable.containsKey(NEED_NODE_PATH)) {
					
					needNodePath = variable.getString(NEED_NODE_PATH);
				}
				
				//特殊函数传path
				if("1-N".equals(nodeNum)) {
					
					Object obj = getNode(conType, messageBo, srcNodePath, srcNodeType, srcArrayNodeDoc, srcJson);
					variableMap.set(variableName, obj);
				} else if("Y".equals(needNodePath)) {
					
					variableMap.set(variableName, srcNodePath);
				} else {
					
					if(!MessageMapperService.BODY.equals(srcNodePath.trim())) {
						
						String nodeValue = getNodeValue(conType, messageBo, srcNodePath, srcNodeType, srcArrayNodeDoc, srcJson);
						
						Object obj = null;
						if(srcNode != null) {
							
							obj = changeValueObj(nodeValue, srcNode);
						}
						variableMap.set(variableName, obj == null ? nodeValue : obj);
						if(LOG.isDebugEnabled()) {
							
							LOG.debug("====> The variables name is:"+ variableName+", the nodeValue is:"+nodeValue);
						}
					} else {
						
						//path是$BODY
						variableMap.set(variableName, messageBo.toString());
					}
				} 
			}
		}
		
		express = express.replace("fn:", "");
		if(express.contains(MessageMapperService.BODY)) {
			
			variableMap.set(MessageMapperService.BODY, messageBo.toString());
		}
		if(LOG.isDebugEnabled()) {
			
			LOG.debug("====> The variables express is:"+ express);
		}
		Object result = engine.eval(express);
		if(LOG.isDebugEnabled()) {
			
			LOG.debug("====> The result is:"+ (result == null ? express : result.toString()));
		}
		return result == null ? express : result;
	}

	private Object getNode(String conType, MessageBO<?> messageBo,
			String srcNodePath, String srcNodeType, Document srcArrayNodeDoc,
			JSONObject srcJson) throws DocumentException {

		if(MessageMapperService.CONST_MSG_CON_TYPE_XML.equals(conType)) {
			
			return getXmlBody(messageBo, srcNodePath, srcArrayNodeDoc);
		} else if(MessageMapperService.CONST_MSG_CON_TYPE_JSON.equals(conType)) {
			
			return getJsonBody(messageBo, srcNodePath, srcJson);
		}
		
		return null;
	}

	private Object getJsonBody(MessageBO<?> messageBo, String srcNodePath,
			JSONObject srcJson) {
		if(LOG.isDebugEnabled()) {
			
			LOG.debug("====> the src message body is:{0} ===>the srcNodePath is:{1}", messageBo.toString(), srcNodePath);
		}
		try {
			if(srcJson != null) {
				
				srcNodePath = getInArrayJsonPath(srcNodePath);
					
				return JsonPath.read(srcJson, srcNodePath);
			} else {
				
				JSONObject json = getSrcMsgBodyJson(messageBo);
				return JsonPath.read(json, srcNodePath);
			}
		} catch(PathNotFoundException e) {
			
			LOG.info(" The json path is :"+srcNodePath+", the message is:"+e.getMessage());
		}
		
		return null;
	}

	private Object getXmlBody(MessageBO<?> messageBo, String nodePath,
			Document srcArrayNodeDoc) throws DocumentException {

		Document srcMsgBody = null;
		
		if(srcArrayNodeDoc != null) {
			
			srcMsgBody = srcArrayNodeDoc;
			nodePath = getInArrayNodePath(nodePath);
		} else {
			
			srcMsgBody = getSrcMsgBodyXml(messageBo);
		}
		
		List<Node> srcNodes = srcMsgBody.selectNodes(nodePath);
		return srcNodes;
	}


	@Override
	public String getNodeValue(String conType, MessageBO<?> messageBo, String srcNodePath, 
			String srcNodeType, Document srcArrayNodeDoc, JSONObject srcJson) throws DocumentException {
		
		if(LOG.isDebugEnabled()) {
			
			LOG.debug(" ==============>The srcNodeType is:{0} the srcNodePath is:{1}", srcNodeType, srcNodePath);
		}
		
		if(srcNodePath.contains(MessageMapperService.XML_PATH_SPLIT)) {
			
			String[] paths = srcNodePath.split(MessageMapperService.XML_PATH_SPLIT);
			String parentPath = paths[0];
			String path = paths[1];

			Map<String, Object> cdataMap = messageBo.getSubMsgBodyMap();
			
			Object cDataObj = cdataMap.get(parentPath);
			//如果是数组内部，则每次都要重新生成Cdata对象
			if(cDataObj == null || srcArrayNodeDoc != null) {
				
				cDataObj = getCdata(messageBo, srcArrayNodeDoc, parentPath);
			} 
			
			return getXmlBodyValue(messageBo, path, (Document)cDataObj);
			
		} else if(srcNodePath.contains(MessageMapperService.JSON_PATH_SPLIT)) {
			
			String[] paths = srcNodePath.split(MessageMapperService.JSON_PATH_SPLIT);
			String parentPath = paths[0];
			String path = paths[1];

			Map<String, Object> cdataMap = messageBo.getSubMsgBodyMap();
			
			Object jsonObj = cdataMap.get(parentPath);
			if(jsonObj == null || srcArrayNodeDoc != null) {
				//no finished
				jsonObj = getJsonObj();
			} 
			return getJsonBodyValue(messageBo, path, (JSONObject)jsonObj);
		} else if(MessageMapperService.CONST_NODE_TYPE_HEAD.equals(srcNodeType)) {
			
			Map<String, Object> msgHead = messageBo.getMsgHead();
			Object obj = msgHead.get(srcNodePath);
			
			return obj == null ? "" : obj.toString();
		} else if(MessageMapperService.CONST_NODE_TYPE_BODY.equals(srcNodeType)
				|| MessageMapperService.CONST_NODE_TYPE_ATTR.equals(srcNodeType)) {
			
			if(MessageMapperService.CONST_MSG_CON_TYPE_XML.equals(conType)) {
				
				return getXmlBodyValue(messageBo, srcNodePath, srcArrayNodeDoc);
			} else if(MessageMapperService.CONST_MSG_CON_TYPE_JSON.equals(conType)) {
				
				return getJsonBodyValue(messageBo, srcNodePath, srcJson);
			}
			
		} else if(MessageMapperService.CONST_NODE_TYPE_URL.equals(srcNodeType)) {
			
			Map<String, String> msgUrl = messageBo.getMessageMap();
			Object obj = msgUrl.get(srcNodePath);
			
			if(obj instanceof String[]) {
				
				StringBuffer sb = new StringBuffer();
				for(String str : (String[])obj) {
					
					sb.append(",");
					sb.append(str);
				}
				
				return sb.toString();
			} else {
				
				return obj == null ? "" : obj.toString();
			}
		} 
		
		return "";
	}

	private Object getJsonObj() {
		// TODO Auto-generated method stub
		return null;
	}

	private Document getCdata(MessageBO<?> messageBo, Document srcArrayNodeDoc,
			String parentPath) throws DocumentException {
		Document cDataDoc;
		String cdataContent = "";
		Document srcMsgBody = null;
		
		if(srcArrayNodeDoc != null) {
			
			srcMsgBody = srcArrayNodeDoc;
			String inArrayPath = getInArrayNodePath(parentPath);
			
			cdataContent = getNodeValue(inArrayPath, srcMsgBody);
			
		} else {
			
			srcMsgBody = getSrcMsgBodyXml(messageBo);
			cdataContent =  getNodeValue(parentPath, srcMsgBody);
		}
		if(cdataContent.startsWith("<![CDATA")) {
			
			cdataContent = cdataContent.substring(9, cdataContent.length()-3);
		}
		
		cDataDoc = O2pDocumentHelper.parseText(cdataContent.trim());
		
		messageBo.getSubMsgBodyMap().put(parentPath, cDataDoc);
		return cDataDoc;
	}

	private String getJsonBodyValue(MessageBO<?> messageBo, String srcNodePath, JSONObject srcJson) {

		if(LOG.isDebugEnabled()) {
			
			LOG.debug("====> the src message body is:{0} ===>the srcNodePath is:{1}", messageBo.toString(), srcNodePath);
		}
		
		if(srcJson != null) {
			
			srcNodePath = getInArrayJsonPath(srcNodePath);
			return readJson(srcNodePath, srcJson);
		} else {
			
			JSONObject json = getSrcMsgBodyJson(messageBo);
			return readJson(srcNodePath, json);
		}
	}


	private String getInArrayJsonPath(String srcNodePath) {

		return "$."+srcNodePath.substring(srcNodePath.lastIndexOf(".")+1, srcNodePath.length());
	}


	public String readJson(String srcNodePath, JSONObject json) {
		
		try {
			
			Object value = JsonPath.read(json, srcNodePath);
			
			if(value != null && !(value instanceof JSONObject) && !(value instanceof JSONArray) ) {
				
				return value.toString();
			} 
		} catch(PathNotFoundException e) {
			
			LOG.info(" The json path is :"+srcNodePath+", the message is:"+e.getMessage());
		}
		
		return "";
	}

	@Override
	public String getXmlBodyValue(MessageBO<?> messageBo, String nodePath, Document srcArrayNodeDoc) throws DocumentException {

		Document srcMsgBody = null;
		
		if(srcArrayNodeDoc != null) {
			
			srcMsgBody = srcArrayNodeDoc;
			nodePath = getInArrayNodePath(nodePath);
			
			return getNodeValue(nodePath, srcMsgBody);
		} else {
			
			srcMsgBody = getSrcMsgBodyXml(messageBo);
			return getNodeValue(nodePath, srcMsgBody);
		}
	}


	private String getNodeValue(String nodePath, Document srcMsgBody) {
		
		Node node = getNode(nodePath, srcMsgBody);
		if(node != null) {
			
			return node.getText();
		}
		
		return "";
	}

	private Node getNode(String nodePath, Document srcMsgBody) {
		if(srcMsgBody != null) {
			if(nodePath.endsWith("/")) {
				
				nodePath = nodePath.substring(0, nodePath.length()-1);
			}
			Node node = srcMsgBody.selectSingleNode(nodePath);
			
			if(LOG.isDebugEnabled()) {
				
				LOG.debug("======> The node path is:"+nodePath);
			}
			
			if(node != null) {
				
				if(LOG.isDebugEnabled()) {
					
					LOG.debug("======> The node value is:"+node.getText());
				}
				return node;
			}
		}
		
		return null;
	}


	private String getInArrayNodePath(String nodePath) {

		return "//"+nodePath.substring(nodePath.lastIndexOf("/")+1, nodePath.length());
	}
	
	@Override
	public Object changeValueObj(String nodeValue, NodeDesc tarNodeDesc) {

		String nodeTypeCons = tarNodeDesc.getNodeTypeCons();
		if(StringUtils.isEmpty(nodeTypeCons) ||
				Constant.NODE_TYPE_CONS_STRING.equals(nodeTypeCons)) {
			
			return nodeValue;
		}else if(Constant.NODE_TYPE_CONS_LONG.equals(nodeTypeCons)
				||Constant.NODE_TYPE_CONS_NUMBER.equals(nodeTypeCons)) {
			
			return Long.parseLong(nodeValue);
		} else if(Constant.NODE_TYPE_CONS_DOUBLE.equals(nodeTypeCons)) {
			
			return Double.parseDouble(nodeValue);
		} else if(Constant.NODE_TYPE_CONS_BOOLEAN.equals(nodeTypeCons)) {
			
			return Boolean.parseBoolean(nodeValue);
		}
		
		return nodeValue;
	}
	
	@Override
	public void setMsgUrlParam(MessageBO tarMessageBo,
			String tarNodeCode, String nodeValue) {

		Object nodeObj = tarMessageBo.getMessageMap().get(tarNodeCode);
		if(nodeObj != null) {
			
			tarMessageBo.getMessageMap().put(tarNodeCode, nodeValue+";"+nodeObj.toString());
		} else {
			
			tarMessageBo.getMessageMap().put(tarNodeCode, nodeValue);
		}
	}

	@Override
	public boolean parseJsonCondition(String conType, MessageBO<?> messageBo,
			NodeDescMapper ndm, Document srcArrayNodeDoc, JSONObject srcJson, NodeDesc srcNode) throws DocumentException {

		NodeValReq nvr = ndm.getTarNodeValReq();
		if(nvr != null) {
			
			String express = nvr.getValueExpress();
			String expressType = nvr.getNodeValSourceCd();
			
			if(MessageMapperService.CONST_NODE_VAL_TYPE_CONDITION.equals(expressType)) {
				
				JSONObject json = JSONObject.fromObject(express);
				JSONObject globalCondition = json.getJSONObject("globalCondition");
				if(parseCondition(conType, messageBo, globalCondition, srcArrayNodeDoc, srcJson, srcNode)) {
					
					FelFunction engine = getFelEngine();
					
					JSONArray logicGetValue = json.getJSONArray("logicGetValue");
					return parseInnerCondition(engine, conType, messageBo, logicGetValue, srcArrayNodeDoc, srcJson, srcNode);
				} else {
					
					return false;
				}
			}
		}
		
		return true;
	}
	
	private boolean parseInnerCondition(FelFunction engine, String conType, MessageBO messageBo,
			JSONArray logicGetValue, Document srcArrayNodeDoc, JSONObject srcJson, NodeDesc srcNode) throws DocumentException {
		
		for(Object segmentObj : logicGetValue) {
			
			JSONObject segment = (JSONObject)segmentObj;
			
			JSONObject condition = segment.getJSONObject("condition");

			return parseCondition(conType, messageBo, condition, srcArrayNodeDoc, srcJson, srcNode);
		}
		
		return true;
	}

	public void setCacheFactory(ICacheFactory<String, Object> cacheFactory) {
		this.cacheFactory = cacheFactory;
	}

}