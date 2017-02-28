/** 
 * Project Name:o2p-serviceAgent-transformer 
 * File Name:INodeReqParseService.java 
 * Package Name:com.ailk.eaap.integration.o2p.transformer.service 
 * Date:2016年1月13日下午7:16:05 
 * Copyright (c) 2016, www.asiainfo.com All Rights Reserved. 
 * 
*/  
  
package com.ailk.eaap.integration.o2p.transformer.service;  


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.dom4j.Document;
import org.dom4j.DocumentException;

import com.ailk.eaap.integration.o2p.function.FelFunction;
import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.ailk.eaap.op2.bo.NodeDesc;
import com.ailk.eaap.op2.bo.NodeDescMapper;
import com.greenpineyu.fel.FelEngine;

/** 
 * ClassName:INodeReqParseService  
 * Function: TODO ADD FUNCTION.  
 * Reason:   TODO ADD REASON.  
 * Date:     2016年1月13日 下午7:16:05  
 * @author   wuwz 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public interface INodeReqParseService {

	String parseJson(String conType, MessageBO<?> messageBo, String express, Document srcArrayNodeDoc, JSONObject srcJson, NodeDesc srcNode) throws DocumentException;

	Document getSrcMsgBodyXml(MessageBO message) throws DocumentException;

	JSONObject getSrcMsgBodyJson(MessageBO message);
	
	String getXmlBodyValue(MessageBO<?> messageBo, String nodePath, Document srcArrayNodeDoc) throws DocumentException;

	String getNodeValue(String conType, MessageBO<?> messageBo,
			String srcNodePath, String srcNodeType, Document srcArrayNodeDoc, JSONObject srcJson) throws DocumentException;

	Object parseVariables(String conType, MessageBO<?> messageBo, JSONArray variables,
			String express, FelFunction engine, Document srcArrayNodeDoc, JSONObject srcJson, NodeDesc srcNode) throws DocumentException;
	
	String readJson(String srcNodePath, JSONObject json);

	Object changeValueObj(String nodeValue, NodeDesc tarNodeDesc);
	
	void setMsgUrlParam(MessageBO tarMessageBo, String tarNodeCode,
			String nodeValue);

	boolean parseJsonCondition(String conType, MessageBO<?> messageBo,
			NodeDescMapper ndm, Document srcArrayNodeDoc, JSONObject srcJson, NodeDesc srcNode) throws DocumentException;
}
