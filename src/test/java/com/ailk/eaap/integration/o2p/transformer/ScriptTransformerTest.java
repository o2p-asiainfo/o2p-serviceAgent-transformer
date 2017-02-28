//package com.ailk.eaap.integration.o2p.transformer;
//
//import java.io.File;
//import java.io.IOException;
//import java.lang.reflect.InvocationTargetException;
//
//import org.apache.commons.io.FileUtils;
//import org.dom4j.Document;
//import org.dom4j.DocumentHelper;
//import org.dom4j.Element;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import com.ailk.eaap.op2.serviceagent.common.MessageBO;
//import com.ailk.eaap.op2.bo.TransformerRule;
//import com.ailk.eaap.op2.bo.ContractInteraction;
//import com.asiainfo.integretion.o2p.serviceagent.cache.CacheServiceImpl;
//
//public class ScriptTransformerTest {
//	ApplicationContext ctx;
//	private CacheServiceImpl cacheService;
//	@Before
//	public void setUp(){
//		String[] configLocations = new String[] {
//				"classpath:o2p-transform-spring-all.xml",
//				"classpath:eaap-op2-memCache-all.xml",
//				"classpath:spring/eaap-op2-common-spring.xml" };
//		ctx = new ClassPathXmlApplicationContext(configLocations);
////		cacheService = (CacheServiceImpl) ctx.getBean("cacheService");
//	}
//	@Test
//	public void test() throws Exception{
//		
//		AbstractTransformer transformer =(AbstractTransformer) ctx.getBean("scriptExecutorTransformer");
//		TransformerRule transformerRule = new TransformerRule();
//		
//		String scriptContent = FileUtils.readFileToString(new File("D:" + File.separator + "TEMP" + File.separator + "bshTest.txt"));
//		transformerRule.setScriptContent(scriptContent);
//		transformerRule.setTransformerType(3);
//		transformer.setTransformerRule(transformerRule );
//		MessageBO<Document> messageBO = new MessageBO<Document>();
//		StringBuffer xml = new StringBuffer();
//		xml.append("<usertoken>");
//		xml.append("absdfj111111111111");
//		xml.append("</usertoken>");
//		Document doc = DocumentHelper.parseText(xml.toString());
//		messageBO.setMsgBody(doc);
//		MessageBO<File> retMsg = (MessageBO<File>) transformer.doTransform(messageBO, transformerRule);
//		System.out.println(FileUtils.readFileToString(retMsg.getMsgBody()));
//		
//	}
//	
//	public void test2() throws Exception{
//		//bsh script content
///*		Document doc = messageBO.getMsgBody();
//		MessageBO retMessage=new MessageBO();
//		String content = doc.selectSingleNode("//usertoken").getText();
//		
//		File file = new File("d:/111.txt");
//		FileUtils.writeStringToFile(file, content);
//		System.out.println(retMessage.getMsgBody());
//		retMessage.setMsgBody(file);
//		return retMessage;*/
//	}
//	@Test
//	public void testCopyProp() throws IllegalAccessException, InvocationTargetException{
//		MessageBO<String> srcMsg = new MessageBO<String>();
//		srcMsg.setTransactionID("11111111111111");
//		ContractInteraction contractInteraction = new ContractInteraction();
//		contractInteraction.setBizFuncCode("BUI1111");
////		contractInteraction.setCreateTime(createTime);
//		MessageBO<String> tarMsg = (MessageBO<String>) org.apache.commons.lang.ObjectUtils.clone(srcMsg);
//		
//		Assert.assertNotNull(tarMsg.getTransactionID());
//	}
//	@Test
//	public void test3() throws IllegalAccessException, InvocationTargetException, IOException, Exception{
//		MessageBO<Document> srcMsg = new MessageBO<Document>();
//		String srcxml = FileUtils.readFileToString(new File("d:/test/xmltest.xml"));
//		Document srcdoc = DocumentHelper.parseText(srcxml);
//		srcdoc.selectSingleNode("/ContractRoot/TcpCont/TransactionID");
//	}
//	@Test
//	public void test4() throws IllegalAccessException, InvocationTargetException, IOException, Exception{
//		MessageBO<Document> srcMsg = new MessageBO<Document>();
//		String srcxml = FileUtils.readFileToString(new File("d:/test/xmltest.xml"));
//		Document srcdoc = DocumentHelper.parseText(srcxml);
//		Element params = (Element) srcdoc.selectSingleNode("/ContractRoot/SvcCont/PARAMETERS");
//		params.remove(params.selectSingleNode("//PACKAGENAME"));
//		params.remove(params.selectSingleNode("//CUSTNAME"));
//		params.remove(params.selectSingleNode("//OFFERSPECID"));
//		params.addElement("AMOUNT").setText("200");
//		System.out.println(srcdoc.asXML());
//	}	
//}
