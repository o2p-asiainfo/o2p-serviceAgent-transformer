/** 
 * Project Name:o2p-serviceAgent-transformer 
 * File Name:TestNodeExpress.java 
 * Package Name:com.ailk.eaap.integration.o2p.expression 
 * Date:2015年9月22日下午8:06:05 
 * Copyright (c) 2015, www.asiainfo.com All Rights Reserved. 
 * 
*/  
  
package com.ailk.eaap.integration.o2p.expression;  
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.junit.Test;
import org.wltea.expression.ExpressionEvaluator;
import org.wltea.expression.datameta.Variable;

import com.ailk.eaap.integration.o2p.message.support.MessageMapperServiceImpl;
import com.ailk.eaap.integration.o2p.model.ContractBody;
import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.ailk.eaap.op2.bo.NodeDesc;

/** 
 * ClassName:TestNodeExpress  
 * Function: TODO ADD FUNCTION.  
 * Reason:   TODO ADD REASON.  
 * Date:     2015年9月22日 下午8:06:05  
 * @author   wuwz 
 * @version   
 * @since    JDK 1.6 
 *        
 */
public class MockTestNodeExpress {
	@Test
	public void verify_behaviour(){

		MessageMapperServiceImpl service = new MessageMapperServiceImpl();
		MessageBO message = new MessageBO();
		String msgBody = "<contract><appkey>123456789</appkey></contract>";
		message.setMsgBody(getDoc(msgBody));
		message.getMsgHead().put("accept", "1000");
		
		setNodeDesc(message);
		
//		String triggerExpress = "('msgHead['accept']') == xml";
//		String triggerExpress = "(('msgHead['accept1']') == 1000 || ('msgHead['accept']') == 1000) && (('msgHead['accept']') > 1000 || ('msgHead['accept']') == 1000)";
//		String triggerExpress = "('/contract/appkey')==12345";
//		String triggerExpress = "('contractBody.srcMapVals[1]')==12345";
		String triggerExpress = "src_node_val==12345";
		String resultExp = service.getOtherNodeValExpress(message, triggerExpress);
		List<Variable> variables = new ArrayList<Variable>();
		variables.add(Variable.createVariable("src_node_val", 12345));
		Object result = ExpressionEvaluator.evaluate(resultExp,
              variables);
		Boolean flag = Boolean.valueOf(String.valueOf(result));
		System.out.println(flag);
	}

	private void setNodeDesc(MessageBO message) {
		Map<Integer, Object> map = new HashMap<Integer, Object>();
		NodeDesc nd = new NodeDesc();
		nd.setNodeDescId(1);
		map.put(nd.getNodeDescId(), "12345");
		ContractBody contractBody = new ContractBody();
		contractBody.setSrcMapVals(map);
		message.setContractBody(contractBody);
	}

	private Object getDoc(String msgBody) {
		Document xmldoc = null;
		
		try {
			xmldoc = DocumentHelper.parseText(msgBody);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return xmldoc;
	}
}
