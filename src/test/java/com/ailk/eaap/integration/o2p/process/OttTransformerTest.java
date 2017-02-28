//package com.ailk.eaap.integration.o2p.process;
//
//import org.dom4j.Document;
//import org.dom4j.DocumentException;
//import org.dom4j.DocumentHelper;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import com.ailk.eaap.integration.o2p.transformer.Transformer;
//import com.ailk.eaap.integration.o2p.transformer.TransformerFactory;
//import com.ailk.eaap.integration.o2p.transformer.service.TransformerRuleService;
//import com.ailk.eaap.op2.serviceagent.common.MessageBO;
//
//public class OttTransformerTest {
//	ApplicationContext ctx;
//
//	@Before
//	public void setUp() {
//		String[] configLocations= new String[]{"classpath:springdev/o2p-transform-spring-db.xml",
//				"classpath:o2p-transform-spring-all.xml",
//				"classpath:spring/eaap-op2-memCache-base.xml"};
//		ctx = new ClassPathXmlApplicationContext(configLocations);
//	}
//
//	@Test
//	public void test() {
//		TransformerFactory transformerFactory = (TransformerFactory) ctx
//				.getBean("transformerFactoryProxy");
//		Transformer transformer = transformerFactory.getTransformer(1);
//		Assert.assertNotNull(transformer);
//	}
//
//	@SuppressWarnings("unchecked")
//	@Test
//	public void transformer1() throws DocumentException {
//		String xml = "<req>"
//					 +"<content>"
//					 +"<userId>5570756977534963712</userId>"
//					 +"<type>TNN</type>"
//					 +"<companyUserId>123456789</companyUserId>"
//					 +"</content>"
//					 +"</req>";
//
//		 MessageBO<Document> srcMsg = new MessageBO<Document>();
//		 Document playload = DocumentHelper.parseText(xml);
//		 srcMsg.setMsgBody(playload);
//		 TransformerRuleService transformerRuleService =
//		 (TransformerRuleService) ctx.getBean("transformerRuleService");
//		 MessageBO<Document> msg =(MessageBO<Document>)
//		 transformerRuleService.doTransform(srcMsg, 30);
//		 System.out.println(msg.getMsgBody().asXML());
//		 System.out.println(msg.getMsgHead().toString());
//	}
//
//	@SuppressWarnings("unchecked")
//	@Test
//	public void transformer2() throws DocumentException {
//		String webservice = "<req>"
//							+"<content>"
//							+"<msisdn>5570756977534963712</msisdn>"
//							+"<hashedPassword>123qwe</hashedPassword>"
//							+"<customerId>123456789</customerId>"
//							+"<email>test@163.com</email>"
//							+"<subscriptionProductType>BUDDLE</subscriptionProductType>"
//							+"<partnerKey>123456789</partnerKey>"
//							+"</content>"
//							+"</req>";
//		MessageBO<Document> srcMsg = new MessageBO<Document>();
//		Document playload = DocumentHelper.parseText(webservice);
//		srcMsg.setMsgBody(playload);
//		TransformerRuleService transformerRuleService = (TransformerRuleService) ctx
//				.getBean("transformerRuleService");
//		MessageBO<Document> msg = (MessageBO<Document>) transformerRuleService
//				.doTransform(srcMsg, 31);
//		System.out.println(msg.getMsgHead().toString());
//
//	}
//
//}
