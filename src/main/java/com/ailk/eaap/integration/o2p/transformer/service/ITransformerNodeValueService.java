/** 
 * Project Name:o2p-serviceAgent-transformer 
 * File Name:ITransformerNodeValueService.java 
 * Package Name:com.ailk.eaap.integration.o2p.transformer.service 
 * Date:2016年1月8日下午2:16:21 
 * Copyright (c) 2016, www.asiainfo.com All Rights Reserved. 
 * 
*/  
  
package com.ailk.eaap.integration.o2p.transformer.service;  


import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;

import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.ailk.eaap.op2.bo.NodeDesc;
import com.ailk.eaap.op2.bo.NodeDescMapper;
import com.ailk.eaap.op2.bo.TransformerRule;

/** 
 * ClassName:ITransformerNodeValueService  
 * Function: TODO ADD FUNCTION.  
 * Reason:   TODO ADD REASON.  
 * Date:     2016年1月8日 下午2:16:21  
 * @author   wuwz 
 * @version   
 * @since    JDK 1.6 
 *        
 */
public interface ITransformerNodeValueService {

	String getSrcNodeValue(String conType, TransformerRule transformerRule,MessageBO<?> messageBo, 
			NodeDescMapper ndm, Document srcArrayNodeDoc, JSONObject srcJson) throws DocumentException;

	MessageBO<?> getMessageBOBySrcNode(MessageBO<?> messageBo,
			TransformerRule transformerRule, NodeDesc srcNodeDesc);

	String getSrcConType(TransformerRule transformerRule, NodeDesc srcNodeDesc);

	void setTarContentType(MessageBO<?> messageBo, String type, String contentType);

	void setUrlHeadValue(MessageBO<?> messageBo,
			TransformerRule transformerRule, NodeDescMapper ndm,
			String conType, NodeDesc tarNodeDesc, MessageBO<?> tarMessageBo) throws DocumentException;

	void setXmlBodyValue(MessageBO<?> messageBo, Document tarDoc,
			NodeDesc tarNodeDesc, String nodeValue,
			MessageBO<Document> tarMessageBo) throws DocumentException;

	void setJsonBodyValue(JSONObject tarJson,
			NodeDesc tarNodeDesc, String tarPath, String subTarPath,
			String nodeValue);

	JSONArray getSrcJson(MessageBO<?> messageBo, JSONObject srcJson,
			NodeDesc srcNd);

	String getSubPath(String nodePath);

	List<Node> getSrcXml(MessageBO<?> messageBo, Document srcArrayNodeDoc,
			NodeDesc srcNodeDesc) throws DocumentException;

	String getSubPathXml(String srcPath);

	boolean isLeafXml(String nodeStr);
	
	Object getSrcJsonObj(MessageBO<?> messageBo, JSONObject srcJson,
			NodeDesc srcNd);
}
