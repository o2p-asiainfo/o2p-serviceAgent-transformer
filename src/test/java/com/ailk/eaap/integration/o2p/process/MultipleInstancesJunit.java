package com.ailk.eaap.integration.o2p.process;


import net.sf.json.JSONObject;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ailk.eaap.integration.o2p.transformer.Transformer;
import com.ailk.eaap.integration.o2p.transformer.TransformerFactory;
import com.ailk.eaap.integration.o2p.transformer.service.TransformerRuleService;
import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.jayway.jsonpath.JsonPath;

public class MultipleInstancesJunit {
	ApplicationContext ctx;

	@Before
	public void setUp() throws Exception {
		String[] configLocations= new String[]{"classpath:springdev/o2p-transform-spring-db.xml",
				"classpath:o2p-transform-spring-all.xml",
				"classpath:spring/eaap-op2-memCache-base.xml"};
		ctx = new ClassPathXmlApplicationContext(configLocations);
	}

	@Test
	public void test() {
		TransformerFactory transformerFactory = (TransformerFactory) ctx
				.getBean("transformerFactoryProxy");
		Transformer transformer = transformerFactory.getTransformer(1);
		Assert.assertNotNull(transformer);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void multiplInstances() throws DocumentException {
		String xml = "<Customer>"
				+ "<user><name>adc</name><age>12</age></user>"
				+ "<user><name>Adc</name><age>21</age></user>" + "</Customer>";

		MessageBO<Document> srcMsg = new MessageBO<Document>();
		Document playload = DocumentHelper.parseText(xml);
		
//		List<Element> list = playload.selectNodes("//user");
//		for(Element e : list){
////			System.out.println(e.getStringValue() + " " + e.getName() + "-" + e.asXML() + " = " + e.detach());
//			for(Iterator i = e.elementIterator(); i.hasNext();){
//				Element employee = (Element) i.next();
//				System.out.println(employee.getName()+":"+employee.getText()+":");
//			}
//		}
		
		srcMsg.setMsgBody(playload);
		TransformerRuleService transformerRuleService = (TransformerRuleService) ctx
				.getBean("transformerRuleService");
		MessageBO<Document> msg = (MessageBO<Document>) transformerRuleService
				.doTransform(srcMsg, 21);
		System.out.println(msg.getMsgBody().asXML());

	}

	@SuppressWarnings("unchecked")
	@Test
	public void multiplInstances2() throws DocumentException {
		String xml = "<Customer>"
				+ "<user><name>adc</name><age>12</age></user>"
				+ "<user><name>Adc</name><age>21</age></user>" 
				+ "<a><c><f>Test</f></c></a>"
				+ "</Customer>";

		MessageBO<Document> srcMsg = new MessageBO<Document>();
		Document playload = DocumentHelper.parseText(xml);
		
		srcMsg.setMsgBody(playload);
		TransformerRuleService transformerRuleService = (TransformerRuleService) ctx
				.getBean("transformerRuleService");
		MessageBO<Document> msg = (MessageBO<Document>) transformerRuleService
				.doTransform(srcMsg, 22);
		System.out.println(msg.getMsgBody().asXML());

	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void multiplInstances3() throws DocumentException {
		String json = "{\"store\":"
						+"{\"bicycle\":"
						+"{\"price\":19.95, \"color\":\"red\"},"
						+"\"book\":["
						+"{\"price\":8.95, \"category\":\"reference\", \"title\":\"Sayings of the Century\", \"author\":\"Nigel Rees\"},"
						+"{\"price\":12.99, \"category\":\"fiction\", \"title\":\"Sword of Honour\", \"author\":\"Evelyn Waugh\"},"
//      {"price":8.99, "category":"fiction", "isbn":"0-553-21311-3", "title":"Moby Dick", "author":"Herman Melville","color":"blue"},
//      {"price":22.99, "category":"fiction", "isbn":"0-395-19395-8", "title":"The Lord of the Rings", "author":"Tolkien"}
						+"]"
						+"}"
						+"}";

//		JsonPath path = JsonPath.compile("$.store.book[*]");
//		List<Object> books = path.read(json);
//		for(Object str:books){
//			System.out.println(str);
//			JSONObject jo = JSONObject.fromObject(str);
//			System.out.println(jo.getString("price"));
//		}
		
//		System.out.println(JsonPath.read(json, "$..category"));
		
		MessageBO<JSONObject> srcMsg = new MessageBO<JSONObject>();
		srcMsg.setMsgBody(JSONObject.fromObject(json));
		TransformerRuleService transformerRuleService = (TransformerRuleService) ctx
				.getBean("transformerRuleService");
		MessageBO<Document> msg = (MessageBO<Document>) transformerRuleService
				.doTransform(srcMsg, 23);
		System.out.println(msg.getMsgBody().asXML());

	}
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void multiplInstances4() throws DocumentException {
		String xml = "<Acounts>"
				+ "<acount><ca>ca1</ca><ti>ti1</ti></acount>"
				+ "<acount><ca>ca2</ca><ti>ti2</ti></acount>"
				+ "</Acounts>";

		MessageBO<Document> srcMsg = new MessageBO<Document>();
		Document playload = DocumentHelper.parseText(xml);
		
		srcMsg.setMsgBody(playload);
		TransformerRuleService transformerRuleService = (TransformerRuleService) ctx
				.getBean("transformerRuleService");
		MessageBO<JSONObject> msg = (MessageBO<JSONObject>) transformerRuleService
				.doTransform(srcMsg, 24);
		System.out.println(msg.getMsgBody().toString());

	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void multiplInstances5() {
		JSONObject jn = JSONObject.fromObject(json);
		MessageBO<JSONObject> srcMsg = new MessageBO<JSONObject>();
		srcMsg.setMsgBody(jn);
		TransformerRuleService transformerRuleService = (TransformerRuleService) ctx
				.getBean("transformerRuleService");
		MessageBO<Document> msg = (MessageBO<Document>) transformerRuleService
				.doTransform(srcMsg, 800971);
		System.out.println(msg.getMsgBody().asXML());
		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testXml2Json(){
		MessageBO<Document> srcMsg = new MessageBO<Document>();
		
		try {
			srcMsg.setMsgBody(DocumentHelper.parseText(xmlData));
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
		TransformerRuleService transformerRuleService = (TransformerRuleService) ctx
				.getBean("transformerRuleService");
		MessageBO<JSONObject> msg = (MessageBO<JSONObject>) transformerRuleService
				.doTransform(srcMsg, 800970);
		System.out.println(msg.getMsgBody().toString());
		
	}

	
	String xmlData = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:test=\"http://test.bss.ailk.com/\">    <soapenv:Header/>    <soapenv:Body>       <test:queryAllUser>          <!--Optional:-->          <clientKey>USER-JSON-</clientKey>       </test:queryAllUser>    </soapenv:Body> </soapenv:Envelope>  ";
	
	String json = "{     'Response': [         { 'age': 0, 'birthday': '2014-12-02 11:34:09', 'createTime': 1417491249991, 'id': 0, 'name': 'User_JSON_0', 'password': '1417491249991', 'picture': []         },         { 'age': 1, 'birthday': '2014-12-02 11:34:09', 'createTime': 1417491249991, 'id': 1, 'name': 'User_JSON_1', 'password': '1417491249991', 'picture': []         },         { 'age': 2, 'birthday': '2014-12-02 11:34:09', 'createTime': 1417491249991, 'id': 2, 'name': 'User_JSON_2', 'password': '1417491249991', 'picture': []         },         { 'age': 3, 'birthday': '2014-12-02 11:34:09', 'createTime': 1417491249991, 'id': 3, 'name': 'User_JSON_3', 'password': '1417491249991', 'picture': []         },         { 'age': 4, 'birthday': '2014-12-02 11:34:09', 'createTime': 1417491249991, 'id': 4, 'name': 'User_JSON_4', 'password': '1417491249991', 'picture': []         }     ] }";
	
	
	@Test
	public void jsonPath() {
		System.out.println(JsonPath.read(json, "$.Response[*].age"));
	}
}
