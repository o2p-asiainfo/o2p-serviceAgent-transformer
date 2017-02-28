/** 
 * Project Name:o2p-serviceAgent-transformer 
 * File Name:NodeReflectServiceImpl.java 
 * Package Name:com.ailk.eaap.integration.o2p.transformer.service.impl 
 * Date:2016年1月22日下午5:05:19 
 * Copyright (c) 2016, www.asiainfo.com All Rights Reserved. 
 * 
*/  
  
package com.ailk.eaap.integration.o2p.transformer.service.impl;  

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.springframework.util.Assert;
import org.wltea.expression.datameta.Variable;

import com.ailk.eaap.integration.o2p.function.FelFunction;
import com.ailk.eaap.integration.o2p.message.support.MessageMapperService;
import com.ailk.eaap.integration.o2p.transformer.service.INodeReflectService;
import com.ailk.eaap.integration.o2p.transformer.service.INodeReqParseService;
import com.ailk.eaap.o2p.common.cache.ICacheFactory;
import com.ailk.eaap.op2.common.O2pDocumentHelper;
import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.asiainfo.foundation.exception.BusinessException;
import com.asiainfo.foundation.log.Logger;
import com.ailk.eaap.op2.bo.NodeDesc;
import com.ailk.eaap.op2.bo.NodeDescMapper;
import com.ailk.eaap.op2.bo.NodeValReq;
import com.ailk.eaap.op2.bo.TransformerRule;
import com.greenpineyu.fel.context.FelContext;
import com.jayway.jsonpath.JsonPath;

/** 
 * ClassName:NodeReflectServiceImpl  
 * Function: TODO ADD FUNCTION.  
 * Reason:   TODO ADD REASON.  
 * Date:     2016年1月22日 下午5:05:19  
 * @author   wuwz 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public class NodeReflectServiceImpl implements INodeReflectService {

	private static final Logger LOG = Logger.getLog(NodeReflectServiceImpl.class);
	private ICacheFactory<String, Object> cacheFactory;
	private INodeReqParseService nodeReqParseService;
	private static final String FIELD_NAME = "FieldName";
	private static final String FIELD_VALUE = "FieldValue";
	
	public void setNodeReqParseService(INodeReqParseService nodeReqParseService) {
		this.nodeReqParseService = nodeReqParseService;
	}

	private void reflect(MessageBO messageBo, Document tarDoc, JSONObject tarJson,
			TransformerRule transformerRule, String srcConType, String express,
			String parentNodePath, String tarParentNodePath, NodeDesc tarNodeDesc) throws DocumentException {

		JSONObject reflect = JSONObject.fromObject(express);
		
		JSONObject sourceNodes = reflect.getJSONObject("sourceNodes");
		Document srcParentNodeDoc = null;
		JSONObject srcParentJson = null;
		if(MessageMapperService.CONST_MSG_CON_TYPE_XML.equals(srcConType)) {
			
			Document doc = nodeReqParseService.getSrcMsgBodyXml(messageBo);
			Node parentNode = doc.selectSingleNode(parentNodePath);
			srcParentNodeDoc= O2pDocumentHelper.parseText(parentNode.asXML());
		} else if(MessageMapperService.CONST_MSG_CON_TYPE_JSON.equals(srcConType)) {
			
			JSONObject jsonObj = nodeReqParseService.getSrcMsgBodyJson(messageBo);
			srcParentJson = JsonPath.read(jsonObj, parentNodePath);
		}
		
		JSONObject targetNodes = reflect.getJSONObject("targetNodes");
		
		if(tarDoc != null) {
			
			parseReflectXml(messageBo, tarDoc, sourceNodes, srcParentNodeDoc,
					srcParentJson, targetNodes, tarParentNodePath, srcConType, tarNodeDesc);
		} else if(tarJson != null) {
			
			parseReflectJson(messageBo, tarJson, sourceNodes, srcParentNodeDoc,
					srcParentJson, targetNodes, tarParentNodePath, srcConType, tarNodeDesc);
		}
	}

	private void parseReflectXml(MessageBO messageBo, Document tarDoc,
			JSONObject sourceNodes, Node srcParentNodeDoc,
			JSONObject srcParentJson, JSONObject targetNodes,
			String tarParentNodePath, String srcConType, NodeDesc tarNodeDesc) throws DocumentException {
		
		List<Node> tarParentNodes = tarDoc.selectNodes(tarParentNodePath);
		if(tarParentNodes.size()<1) {
			
			throw new BusinessException(9100, "Can not find target parent node, tarParentNodePath:"+tarParentNodePath);
		}
		Node tarParentNode = tarParentNodes.get(0);
		Document tarParentNodeDoc= O2pDocumentHelper.parseText(tarParentNode.asXML());
		Element highTarPNode = tarParentNode.getParent();
		
		deleteArrayNode(highTarPNode, tarParentNodes);
		
		JSONArray subNodes = sourceNodes.getJSONArray("subNodes");
		
		for(Object obj : subNodes) {
			
			JSONObject subNode = (JSONObject)obj;
			String node = subNode.getString("node");
			Document tarParentNodeDocClone = (Document)tarParentNodeDoc.clone();
			parseTargetNodes(messageBo, srcParentNodeDoc, srcParentJson, node, targetNodes, tarParentNodeDocClone, null, srcConType, tarNodeDesc);
			
			if(LOG.isDebugEnabled()) {
				
				LOG.debug("tarParentNodeDoc is:{0}", tarParentNodeDocClone.asXML());
			}
			highTarPNode.add(tarParentNodeDocClone.getRootElement());
		}
	}
	
	private void parseReflectJson(MessageBO messageBo, JSONObject tarJson,
			JSONObject sourceNodes, Node srcParentNodeDoc,
			JSONObject srcParentJson, JSONObject targetNodes,
			String tarParentNodePath, String srcConType, NodeDesc tarNodeDesc) throws DocumentException {
		
		JSONArray tarJsonArray = (JSONArray)JsonPath.read(tarJson, tarParentNodePath);
		//第一个数组节点
		JSONObject tarArray0 = (JSONObject)tarJsonArray.get(0);
		//清除多余数组节点
		tarJsonArray.clear();
		
		JSONArray subNodes = sourceNodes.getJSONArray("subNodes");
		
		for(Object obj : subNodes) {
			
			JSONObject subNode = (JSONObject)obj;
			String node = subNode.getString("node");
			
			parseTargetNodes(messageBo, srcParentNodeDoc, srcParentJson, node, targetNodes, null, tarArray0, srcConType, tarNodeDesc);
			
			if(LOG.isDebugEnabled()) {
				
				LOG.debug("tarParentNodeJson is:{0}", tarArray0.toString());
			}

			tarJsonArray.add(tarArray0);
		}
	}


	private void parseTargetNodes(MessageBO messageBo, Node srcParentNode, JSONObject srcParentJson, String srcNodePath,
			JSONObject targetNodes, Document tarDoc, JSONObject tarJson, String srcConType, NodeDesc tarNodeDesc) throws DocumentException {
		
		Node srcNode = null;
		if(srcParentNode != null) {
			
			srcNode = srcParentNode.selectSingleNode("//"+srcNodePath);
		}
		
		Object srcJson = null;
		if(srcParentJson != null) {
			
			srcJson = JsonPath.read(srcParentJson, srcNodePath);
		}
		if(srcNode != null || srcJson != null) {
			
			String nodeName = "";
			String nodeValue = "";
			if(srcNode != null) {
				
				 nodeName = srcNode.getName();
				 nodeValue = srcNode.getText();
			}
			if(srcJson != null) {
				
				if(srcJson instanceof JSONObject) {
					JSONObject srcJsonObj = (JSONObject)srcJson;
					if(!srcJsonObj.isNullObject()) {
						
						Iterator it = srcJsonObj.keys();
						while(it.hasNext()) {
							
							String key = (String)it.next();
							nodeName = key;
							nodeValue = srcJsonObj.getString(key);
						}
					}
				} else if(srcJson instanceof String) {
					
					 nodeName = srcNodePath;
					 nodeValue = srcJson.toString();
				}
				
			}
			
			JSONArray tarSubNodes = targetNodes.getJSONArray("subNodes");
			for(Object obj : tarSubNodes) {
				
				List<Variable> variableList = new ArrayList<Variable>();
				
				JSONObject tarSubNode = (JSONObject)obj;
				String tarNodePath = tarSubNode.getString("node");
				
				FelFunction engine = new FelFunction(cacheFactory);
				
				String value = getNodeValue(messageBo, nodeName, nodeValue,
						engine, tarSubNode, srcConType);
				
				Node tarNode = null;
				if(tarDoc != null) {
					
					tarNode = tarDoc.selectSingleNode("//"+tarNodePath);
					
					tarNode.setText(value);
				} else if(tarJson != null){
					
					Object valueObj = nodeReqParseService.changeValueObj(value, tarNodeDesc);
					tarJson.put(tarNodePath, valueObj);
				}
			}
		} else {
			
			LOG.info("====>The source node is null, the path is {0}", srcNodePath);
		}
	}

	private String getNodeValue(MessageBO messageBo, String nodeName,
			String nodeValue, FelFunction engine, JSONObject tarSubNode, String srcConType)
			throws DocumentException {
		
		FelContext variableMap = engine.getContext();
		
		String valueExpress = tarSubNode.getString("valueExpress");
		valueExpress = valueExpress.replace("Field.Name", FIELD_NAME);
		valueExpress = valueExpress.replace("Field.Value", FIELD_VALUE);
		
		if(valueExpress.contains(FIELD_NAME)) {
			
//			variableList.add(Variable.createVariable(FIELD_NAME, nodeName));
			variableMap.set(FIELD_NAME, nodeName);
		}
		if(valueExpress.contains(FIELD_VALUE)) {
			
//			variableList.add(Variable.createVariable(FIELD_VALUE, nodeValue));
			variableMap.set(FIELD_VALUE, nodeValue);
		}
		
		JSONArray variables = null;
		if(tarSubNode.containsKey("variables")) {
			
			variables = tarSubNode.getJSONArray("variables");
		}
		
		return nodeReqParseService.parseVariables(srcConType, messageBo, variables, valueExpress, engine, null, null, null).toString();
	}
	
	public void deleteArrayNode(Element arrayParentNode, List<Node> tarNode) {

		//删除数组节点
		for(Node arrayNode1 : tarNode) {
			
			arrayParentNode.remove(arrayNode1);
		}
	}

	@Override
	public void parseReflect(MessageBO messageBo, Document tarDoc,
			JSONObject tarJson, TransformerRule transformerRule,
			NodeDescMapper ndm, String conType, NodeDesc srcNodeDesc,
			NodeDesc tarNodeDesc) throws DocumentException {

		NodeValReq nvr = ndm.getTarNodeValReq();
		Assert.notNull(nvr,"====>  Transformer error, mapper type is reflect, the node get value config is null !");
		
		String express = nvr.getValueExpress();
		Assert.notNull(express,"====>  Transformer error, mapper type is reflect, the value express is null  !");
		
		Assert.notNull(srcNodeDesc,"====>  Transformer error, mapper type is reflect, the source NodeDesc is null  !");
		Assert.notNull(tarNodeDesc,"====>  Transformer error, mapper type is reflect, the target NodeDesc is null  !");
		
		String srcParentPath = srcNodeDesc.getNodePath();
		String tarParentPath = tarNodeDesc.getNodePath();
		
		reflect(messageBo, tarDoc, tarJson, transformerRule, conType, express, srcParentPath, tarParentPath, tarNodeDesc);
		
	}

	public void setCacheFactory(ICacheFactory<String, Object> cacheFactory) {
		this.cacheFactory = cacheFactory;
	}
	
}
