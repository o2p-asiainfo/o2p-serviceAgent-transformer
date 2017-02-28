package com.ailk.eaap.integration.o2p.process;


import net.sf.json.JSONObject;

//import org.dom4j.Document;
//import org.dom4j.DocumentHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ailk.eaap.integration.o2p.transformer.Transformer;
import com.ailk.eaap.integration.o2p.transformer.TransformerFactory;
import com.ailk.eaap.integration.o2p.transformer.service.TransformerRuleService;
//import com.ailk.eaap.op2.bo.NodeDesc;
import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.ailk.eaap.op2.bo.MessageDesc;

public class JsonTransformerProcessJunit {
	ApplicationContext ctx;
	MessageDesc md = new MessageDesc();
	
	@Test
	public void test() throws Exception {
		TransformerFactory transformerFactory = (TransformerFactory) ctx.getBean("transformerFactoryProxy");
		Transformer transformer = transformerFactory.getTransformer(1);
		Assert.assertNotNull(transformer);
		
//		XmlTransformerProcessIn xtp = new XmlTransformerProcessIn();
//		MessageBO<Document> bo = new MessageBO<Document>();
//		bo.setMsgBody(DocumentHelper.parseText(json));
//		NodeDesc nd = new NodeDesc();
////		nd.setNodePath("//store/bicycle/category");
////		nd.setNodePath("//store/books/book/author");
//		nd.setNodePath("//store/books/book/price");
//		Object o = xtp.parseNodeValBySrcMsg(bo, null, nd);
//		System.out.println(" Test : " + o);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testJson(){
		String msg = "{"
				+"\"tenantId\":\"100\","
				+"\"loginName\":\"awarx\","
				+"\"validateType\":\"1\","
				+"\"validateScene\":\"2\","
				+"\"sendTo\":\"13620003456\","
				+"\"accType\":99"
				+"}";
		MessageBO<JSONObject> srcMsg = new MessageBO<JSONObject>();
		JSONObject playload = JSONObject.fromObject(msg);
		srcMsg.setMsgBody(playload);
		TransformerRuleService transformerRuleService = (TransformerRuleService) ctx.getBean("transformerRuleService");
		MessageBO<JSONObject> retmsg =(MessageBO<JSONObject>) transformerRuleService.doTransform(srcMsg, 27);
		System.out.println(retmsg.getMsgBody().toString());
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testJson2(){
		String msg = "{"
					+"\"tenantId\":\"100\","
					+"\"password\":\"111111\","
					+"\"user\":"
					+"{"
					+"\"userBase\":{" 
					+"\"loginName\":\"awarx\","
					+"\"email\":\" awarx @qq.com\","
					+"\"mobile\":\"\","
					+"\"accType\":\"99\""
					+"},"
					+"\"userProfile\":{}"
					+"}"
					+"}";
		MessageBO<JSONObject> srcMsg = new MessageBO<JSONObject>();
		JSONObject playload = JSONObject.fromObject(msg);
		srcMsg.setMsgBody(playload);
		TransformerRuleService transformerRuleService = (TransformerRuleService) ctx.getBean("transformerRuleService");
		MessageBO<JSONObject> retmsg =(MessageBO<JSONObject>) transformerRuleService.doTransform(srcMsg, 28);
		System.out.println(retmsg.getMsgBody().toString());
	}
	
	@Before
	public void setUp() throws Exception {
		String[] configLocations= new String[]{"classpath:springdev/o2p-transform-spring-db.xml",
				"classpath:o2p-transform-spring-all.xml",
				"classpath:spring/eaap-op2-memCache-base.xml"};
		ctx = new ClassPathXmlApplicationContext(configLocations);
	}

	String json = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
			+"<store>"
			+"<bicycle>"
			+"<price>19.95</price>"
			+"<category>red</category>"
			+"</bicycle>"
			+"<books>"
			+"<book>"
			+"<author>Nigel Rees</author>"
			+"<category>reference</category>"
			+"<title>Sayings of the Century</title>"
			+"<price>8.95</price>"
			+"</book>"
			+"</books>"
			+"</store>";

}
