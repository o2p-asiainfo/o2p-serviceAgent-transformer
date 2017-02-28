/** 
 * Project Name:o2p-serviceAgent-transformer 
 * File Name:INodeReflectService.java 
 * Package Name:com.ailk.eaap.integration.o2p.transformer.service.impl 
 * Date:2016年1月22日下午5:03:28 
 * Copyright (c) 2016, www.asiainfo.com All Rights Reserved. 
 * 
*/  
  
package com.ailk.eaap.integration.o2p.transformer.service;  

import java.util.List;

import net.sf.json.JSONObject;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;

import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.ailk.eaap.op2.bo.NodeDesc;
import com.ailk.eaap.op2.bo.NodeDescMapper;
import com.ailk.eaap.op2.bo.TransformerRule;

/** 
 * ClassName:INodeReflectService  
 * Function: TODO ADD FUNCTION.  
 * Reason:   TODO ADD REASON.  
 * Date:     2016年1月22日 下午5:03:28  
 * @author   wuwz 
 * @version   
 * @since    JDK 1.6 
 *        
 */
public interface INodeReflectService {

	void deleteArrayNode(Element arrayParentNode, List<Node> tarNode);

	void parseReflect(MessageBO messageBo, Document tarDoc, JSONObject tarJson,
			TransformerRule transformerRule, NodeDescMapper ndm,
			String conType, NodeDesc srcNodeDesc, NodeDesc tarNodeDesc) throws DocumentException;

}
