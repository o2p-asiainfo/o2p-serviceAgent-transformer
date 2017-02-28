package com.ailk.eaap.integration.o2p.transformer;

import java.io.IOException;

import net.sf.json.JSONObject;

import org.apache.commons.io.FileUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.ailk.eaap.integration.o2p.transformer.service.TransformerRuleService;
import com.ailk.eaap.o2p.common.cache.CacheKey;
import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.asiainfo.integretion.o2p.serviceagent.cache.CacheServiceImpl;

public class TransformerServiceTest {
	ApplicationContext ctx;
	private CacheServiceImpl cacheService;

	@Before
	public void setUp() throws Exception{
		String[] configLocations = new String[] {
				"classpath:o2p-transform-spring-all.xml",
				"classpath:eaap-op2-memCache-all.xml",
				"classpath:spring/eaap-op2-common-spring.xml" };
		ctx = new ClassPathXmlApplicationContext(configLocations);
	}
	
	@Test
	public void generalTransTest() throws DocumentException, IOException {
		
		MessageBO<Document> srcMsg = new MessageBO<Document>();
		String srcDataPath = "com/ailk/eaap/integration/o2p/transformer/generalTransfor.xml";
		Resource srcDataResource = new ClassPathResource(srcDataPath);
		String src = FileUtils.readFileToString(srcDataResource.getFile());
		Document doc = DocumentHelper.parseText(src);
		srcMsg.setMsgBody(doc);
		TransformerRuleService transformerRuleService = (TransformerRuleService) ctx.getBean("transformerRuleService");
		MessageBO<Document> tarMsg =(MessageBO<Document>) transformerRuleService.doTransform(srcMsg, 16);
		System.out.println(tarMsg.getMsgBody().asXML());
	}
	
	@Test
	public void reflectTransTestXml2Xml() throws DocumentException, IOException {
		
		MessageBO<Document> srcMsg = new MessageBO<Document>();
		String srcDataPath = "com/ailk/eaap/integration/o2p/transformer/reflectTransfor.xml";
		Resource srcDataResource = new ClassPathResource(srcDataPath);
		String src = FileUtils.readFileToString(srcDataResource.getFile());
		Document doc = DocumentHelper.parseText(src);
		srcMsg.setMsgBody(doc);
		TransformerRuleService transformerRuleService = (TransformerRuleService) ctx.getBean("transformerRuleService");
		MessageBO<Document> tarMsg =(MessageBO<Document>) transformerRuleService.doTransform(srcMsg, 17);
		System.out.println(tarMsg.getMsgBody().asXML());
	}
	
	@Test
	public void reflectTransTestJson2Xml() throws DocumentException, IOException {
		
		MessageBO<JSONObject> srcMsg = new MessageBO<JSONObject>();
		String srcDataPath = "com/ailk/eaap/integration/o2p/transformer/reflectTransforJson.xml";
		Resource srcDataResource = new ClassPathResource(srcDataPath);
		String src = FileUtils.readFileToString(srcDataResource.getFile());
		JSONObject doc = JSONObject.fromObject(src);
		srcMsg.setMsgBody(doc);
		TransformerRuleService transformerRuleService = (TransformerRuleService) ctx.getBean("transformerRuleService");
		MessageBO<Document> tarMsg =(MessageBO<Document>) transformerRuleService.doTransform(srcMsg, 18);
		System.out.println(tarMsg.getMsgBody().asXML());
	}
	
	@Test
	public void reflectTransTestJson2Json() throws DocumentException, IOException {
		
		MessageBO<JSONObject> srcMsg = new MessageBO<JSONObject>();
		String srcDataPath = "com/ailk/eaap/integration/o2p/transformer/reflectTransforJson.xml";
		Resource srcDataResource = new ClassPathResource(srcDataPath);
		String src = FileUtils.readFileToString(srcDataResource.getFile());
		JSONObject doc = JSONObject.fromObject(src);
		srcMsg.setMsgBody(doc);
		TransformerRuleService transformerRuleService = (TransformerRuleService) ctx.getBean("transformerRuleService");
		MessageBO<Document> tarMsg =(MessageBO<Document>) transformerRuleService.doTransform(srcMsg, 23);
		System.out.println(tarMsg.getMsgBody().asXML());
	}

	@Test
	public void reflectTransTestXml2Json() throws DocumentException, IOException {
		
		MessageBO<Document> srcMsg = new MessageBO<Document>();
		String srcDataPath = "com/ailk/eaap/integration/o2p/transformer/reflectTransfor.xml";
		Resource srcDataResource = new ClassPathResource(srcDataPath);
		String src = FileUtils.readFileToString(srcDataResource.getFile());
		Document doc = DocumentHelper.parseText(src);
		srcMsg.setMsgBody(doc);
		TransformerRuleService transformerRuleService = (TransformerRuleService) ctx.getBean("transformerRuleService");
		MessageBO<Document> tarMsg =(MessageBO<Document>) transformerRuleService.doTransform(srcMsg, 24);
		System.out.println(tarMsg.getMsgBody().asXML());
	}

	@Test
	public void A2ATestJson2Xml() throws DocumentException, IOException {
		
		MessageBO<JSONObject> srcMsg = new MessageBO<JSONObject>();
		String srcDataPath = "com/ailk/eaap/integration/o2p/transformer/A2ATransforJson.xml";
		Resource srcDataResource = new ClassPathResource(srcDataPath);
		String src = FileUtils.readFileToString(srcDataResource.getFile());
		JSONObject doc = JSONObject.fromObject(src);
		srcMsg.setMsgBody(doc);
		TransformerRuleService transformerRuleService = (TransformerRuleService) ctx.getBean("transformerRuleService");
		MessageBO<Document> tarMsg =(MessageBO<Document>) transformerRuleService.doTransform(srcMsg, 19);
		System.out.println(tarMsg.getMsgBody().asXML());
	}

	@Test
	public void A2ATestXml2Json() throws DocumentException, IOException {
		
		MessageBO<Document> srcMsg = new MessageBO<Document>();
		String srcDataPath = "com/ailk/eaap/integration/o2p/transformer/A2ATransforXml2Json.xml";
		Resource srcDataResource = new ClassPathResource(srcDataPath);
		String src = FileUtils.readFileToString(srcDataResource.getFile());
		Document doc =  DocumentHelper.parseText(src);
		srcMsg.setMsgBody(doc);
		TransformerRuleService transformerRuleService = (TransformerRuleService) ctx.getBean("transformerRuleService");
		MessageBO<Document> tarMsg =(MessageBO<Document>) transformerRuleService.doTransform(srcMsg, 20);
		System.out.println(tarMsg.getMsgBody().asXML());
	}
	@Test
	public void A2ATestXml2Xml() throws DocumentException, IOException {
		
		MessageBO<Document> srcMsg = new MessageBO<Document>();
		String srcDataPath = "com/ailk/eaap/integration/o2p/transformer/A2ATransforXml2Json.xml";
		Resource srcDataResource = new ClassPathResource(srcDataPath);
		String src = FileUtils.readFileToString(srcDataResource.getFile());
		Document doc =  DocumentHelper.parseText(src);
		srcMsg.setMsgBody(doc);
		TransformerRuleService transformerRuleService = (TransformerRuleService) ctx.getBean("transformerRuleService");
		MessageBO<Document> tarMsg =(MessageBO<Document>) transformerRuleService.doTransform(srcMsg, 22);
		System.out.println(tarMsg.getMsgBody().asXML());
	}
	
	@Test
	public void A2ATestJson2Json() throws DocumentException, IOException {
		
		MessageBO<JSONObject> srcMsg = new MessageBO<JSONObject>();
		String srcDataPath = "com/ailk/eaap/integration/o2p/transformer/A2ATransforJson2Json.xml";
		Resource srcDataResource = new ClassPathResource(srcDataPath);
		String src = FileUtils.readFileToString(srcDataResource.getFile());
		JSONObject doc =  JSONObject.fromObject(src);
		srcMsg.setMsgBody(doc);
		TransformerRuleService transformerRuleService = (TransformerRuleService) ctx.getBean("transformerRuleService");
		MessageBO<Document> tarMsg =(MessageBO<Document>) transformerRuleService.doTransform(srcMsg, 21);
		System.out.println(tarMsg.getMsgBody().asXML());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void xmlToXmlByBase() throws DocumentException {
		cacheService.addByModuleName(CacheKey.MODULE_TRANSFORMER_RULE, null);
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
				+"<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:soa=\"http://soa.ailk.telenor.com/wsdl/soa\">"
				+"<soapenv:Body>"
				+"<request>"
				+"<taxNumber>闽越</taxNumber>"
				+"<dateOfBirth>20140101</dateOfBirth>"
				+"<name>福大</name>"
				+"<username>99999</username>"
				+"<placeOfBirth>66612312321343435</placeOfBirth>"
				+"</request>"
				+"</soapenv:Body>"
				+"</soapenv:Envelope>";
		
		MessageBO<Document> srcMsg = new MessageBO<Document>();
		Document playload = DocumentHelper.parseText(xml);
		srcMsg.setMsgBody(playload);
		TransformerRuleService transformerRuleService = (TransformerRuleService) ctx.getBean("transformerRuleService");
		MessageBO<Document> msg =(MessageBO<Document>) transformerRuleService.doTransform(srcMsg, 2301);
		System.out.println(msg.getMsgBody().asXML());
		
	}
	
	@Test
	public void test() throws Exception{
		TransformerFactory transformerFactory = (TransformerFactory) ctx.getBean("transformerFactoryProxy");
		Transformer transformer = transformerFactory.getTransformer(1);
		Assert.assertNotNull(transformer);
	}
	@SuppressWarnings("unchecked")
	@Test
	public void testXmlMsgTransformer() throws Exception{
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
					+"<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:soa=\"http://soa.ailk.telenor.com/wsdl/soa\">"
					+"<soapenv:Body>"
					+"<soa:checkCustomerStatusRequest>"
					+"<request>"
					+"<taxNumber>闽越</taxNumber>"
					+"<dateOfBirth>20140101</dateOfBirth>"
					+"<name>福大</name>"
					+"<documents>"
						+"<item>"
							+"<documentType>AAA</documentType>"
							+"<documentNumber>33333</documentNumber>"
						+"</item>"
					+"</documents>"
					+"<username>99999</username>"
					+"<tradeRegisterNumber>88888</tradeRegisterNumber>"
					+"<motherName>鼓励</motherName>"
					+"<operatorsGeneratedID>20130000</operatorsGeneratedID>"
					+"<birthName>20011015</birthName>"
					+"<callbackAddress>福建福州鼓楼区</callbackAddress>"
					+"<placeOfBirth>66612312321343435</placeOfBirth>"
					+"</request>"
					+"</soa:checkCustomerStatusRequest>"
					+"</soapenv:Body>"
					+"</soapenv:Envelope>";
		MessageBO<Document> srcMsg = new MessageBO<Document>();
		Document playload = DocumentHelper.parseText(xml);
		srcMsg.setMsgBody(playload);
		TransformerRuleService transformerRuleService = (TransformerRuleService) ctx.getBean("transformerRuleService");
		MessageBO<JSONObject> msg =(MessageBO<JSONObject>) transformerRuleService.doTransform(srcMsg, 1);
		System.out.println(msg.getMsgBody().toString());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testJson(){
		String msg = "{\"customer\":{\"birthName\":\"20011015\",\"callbackAddress\":\"福建福州鼓楼区\","
				+ "\"dateOfBirth\":\"20140101\",\"motherName\":\"鼓励\",\"name\":\"福大\","
				+ "\"operatorsGeneratedID\":\"66612312321343435\",\"placeOfBirth\":\"20130000\","
				+ "\"taxNumber\":\"99999\",\"tradeRegisterNumber\":\"88888\",\"username\":\"闽越\","
				+ "\"document\":{\"documentNumber\":\"123123213213\",\"documentType\":\"A\"}}}";
		MessageBO<JSONObject> srcMsg = new MessageBO<JSONObject>();
		JSONObject playload = JSONObject.fromObject(msg);
		srcMsg.setMsgBody(playload);
		TransformerRuleService transformerRuleService = (TransformerRuleService) ctx.getBean("transformerRuleService");
		MessageBO<Document> retmsg =(MessageBO<Document>) transformerRuleService.doTransform(srcMsg, 16);
		System.out.println(retmsg.getMsgBody().asXML());
	}
	@Test
	public void testXsl() throws Exception{
		MessageBO<Document> srcMsg = new MessageBO<Document>();
		String srcDataPath = "com/ailk/eaap/integration/o2p/transformer/xsl/staff.xml";
		Resource srcDataResource = new ClassPathResource(srcDataPath);
		Document xml = DocumentHelper.parseText(FileUtils.readFileToString(srcDataResource.getFile()));
		srcMsg.setMsgBody(xml);
		TransformerRuleService transformerRuleService = (TransformerRuleService) ctx.getBean("transformerRuleService");
		MessageBO<Document> retmsg =(MessageBO<Document>) transformerRuleService.doTransform(srcMsg, 26);
	}
	@Test
	public void testJSON2JSON() throws Exception{
		MessageBO<JSONObject> srcMsg = new MessageBO<JSONObject>();
		String srcDataPath = "com/ailk/eaap/integration/o2p/transformer/haiertest.json";
		
		Resource srcDataResource = new ClassPathResource(srcDataPath);
		String jsonStr = FileUtils.readFileToString(srcDataResource.getFile());
		JSONObject playload = JSONObject.fromObject(jsonStr);
		srcMsg.setMsgBody(playload);
		TransformerRuleService transformerRuleService = (TransformerRuleService) ctx.getBean("transformerRuleService");
		MessageBO<JSONObject> retmsg =(MessageBO<JSONObject>) transformerRuleService.doTransform(srcMsg, 27);
		System.out.println(retmsg.getMsgBody().toString());
	}
	@Test
	public void testXmdel2XMl() throws Exception{
		MessageBO<Document> srcMsg = new MessageBO<Document>();
		String srcDataPath = "com/ailk/eaap/integration/o2p/transformer/orderpackage.xml";
		Resource srcDataResource = new ClassPathResource(srcDataPath);
		String src = FileUtils.readFileToString(srcDataResource.getFile());
		Document doc = DocumentHelper.parseText(src);
		srcMsg.setMsgBody(doc);
		TransformerRuleService transformerRuleService = (TransformerRuleService) ctx.getBean("transformerRuleService");
		MessageBO<Document> tarMsg =(MessageBO<Document>) transformerRuleService.doTransform(srcMsg, 29);
		System.out.println(tarMsg.getMsgBody().asXML());
	}
	@Test
	public void testXmdel2XMl2() throws Exception{
		MessageBO<Document> srcMsg = new MessageBO<Document>();
		String srcDataPath = "com/ailk/eaap/integration/o2p/transformer/orderpackagesrc.xml";
		Resource srcDataResource = new ClassPathResource(srcDataPath);
		String src = FileUtils.readFileToString(srcDataResource.getFile());
		Document doc = DocumentHelper.parseText(src);
		srcMsg.setMsgBody(doc);
		TransformerRuleService transformerRuleService = (TransformerRuleService) ctx.getBean("transformerRuleService");
		MessageBO<Document> tarMsg =(MessageBO<Document>) transformerRuleService.doTransform(srcMsg, 32);
		System.out.println(tarMsg.toString());
	}
	@Test
	public void xml2xml()throws Exception{
		MessageBO<Document> srcMsg = new MessageBO<Document>();
		String srcDataPath = "com/ailk/eaap/integration/o2p/transformer/orderpackagesrc.xml";
		Resource srcDataResource = new ClassPathResource(srcDataPath);
		String src = FileUtils.readFileToString(srcDataResource.getFile());
		Document doc = DocumentHelper.parseText(src);
		srcMsg.setMsgBody(doc);
		TransformerRuleService transformerRuleService = (TransformerRuleService) ctx.getBean("transformerRuleService");
		MessageBO<Document> tarMsg =(MessageBO<Document>) transformerRuleService.doTransform(srcMsg, 32);
		System.out.println(tarMsg.toString());
	}
	@Test
	public void xml2xml2() throws Exception{
		MessageBO<Document> srcMsg = new MessageBO<Document>();
		String srcDataPath = "com/ailk/eaap/integration/o2p/transformer/aws.xml";
		Resource srcDataResource = new ClassPathResource(srcDataPath);
		String src = FileUtils.readFileToString(srcDataResource.getFile());
		Document doc = DocumentHelper.parseText(src);
		srcMsg.setMsgBody(doc);
		TransformerRuleService transformerRuleService = (TransformerRuleService) ctx.getBean("transformerRuleService");
		MessageBO<Document> tarMsg =(MessageBO<Document>) transformerRuleService.doTransform(srcMsg, 228);
		System.out.println(tarMsg.toString());

	}
	@Test
	public void xml2xml3() throws Exception{
		MessageBO<Document> srcMsg = new MessageBO<Document>();
		String srcDataPath = "com/ailk/eaap/integration/o2p/transformer/soap2.xml";
		Resource srcDataResource = new ClassPathResource(srcDataPath);
		String src = FileUtils.readFileToString(srcDataResource.getFile());
		Document doc = DocumentHelper.parseText(src);
		srcMsg.setMsgBody(doc);
		TransformerRuleService transformerRuleService = (TransformerRuleService) ctx.getBean("transformerRuleService");
		MessageBO<Document> tarMsg =(MessageBO<Document>) transformerRuleService.doTransform(srcMsg, 1202);

	}	
}
