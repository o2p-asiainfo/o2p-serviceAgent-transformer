package com.ailk.eaap.integration.o2p.process;


import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ailk.eaap.integration.o2p.transformer.service.TransformerRuleService;
import com.ailk.eaap.op2.serviceagent.common.MessageBO;

public class TlvTransformerProcessJunit {
	ApplicationContext ctx;
	@Before
	public void setUp() throws Exception {
		String[] configLocations= new String[]{"classpath:springdev/o2p-transform-spring-db.xml",
				"classpath:o2p-transform-spring-all.xml",
				"classpath:spring/eaap-op2-memCache-base.xml"};
		ctx = new ClassPathXmlApplicationContext(configLocations);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void test() throws DocumentException {
		String xml = "<ContractRoot>" + "<TcpCont>"
				+ "<TransactionID>1000000098201308158565286859</TransactionID>"
				+ "<BusCode>BUS37059</BusCode>"
				+ "<ServiceCode>SVC33051</ServiceCode>"
				+ "<ReqTime>20130815153142</ReqTime>" 
				+ "</TcpCont>"
				+ "</ContractRoot>";
		
		MessageBO<Document> srcMsg = new MessageBO<Document>();
		srcMsg.setMsgBody(DocumentHelper.parseText(xml));
		TransformerRuleService transformerRuleService = (TransformerRuleService) ctx
				.getBean("transformerRuleService");
		MessageBO<String> msg = (MessageBO<String>) transformerRuleService
				.doTransform(srcMsg, 25);
		System.out.println("TLV : " + msg.getMsgBody().toString());
	}

}
