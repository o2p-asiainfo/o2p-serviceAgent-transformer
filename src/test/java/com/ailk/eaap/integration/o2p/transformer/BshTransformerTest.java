///** 
// * Project Name:o2p-serviceAgent-transformer 
// * File Name:BshTransformerTest.java 
// * Package Name:com.ailk.eaap.integration.o2p.transformer 
// * Date:2014年12月23日上午9:57:47 
// * Copyright (c) 2014, www.asiainfo.com All Rights Reserved. 
// * 
//*/  
//  
//package com.ailk.eaap.integration.o2p.transformer;  
//
//import java.io.File;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.apache.commons.io.FileUtils;
//import org.dom4j.Document;
//import org.dom4j.DocumentHelper;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.scripting.ScriptSource;
//import org.springframework.scripting.support.StaticScriptSource;
//
//import com.ailk.eaap.integration.o2p.script.ScriptExecutor;
//import com.ailk.eaap.integration.o2p.script.jsr223.ScriptExecutorFactory;
//import com.ailk.eaap.op2.serviceagent.common.MessageBO;
//import com.ailk.eaap.op2.bo.TransformerRule;
//
///** 
// * ClassName:BshTransformerTest  
// * Function: TODO ADD FUNCTION.  
// * Reason:   TODO ADD REASON.  
// * Date:     2014年12月23日 上午9:57:47  
// * @author   颖勤 
// * @version   
// * @since    JDK 1.6 
// *        
// */
//public class BshTransformerTest {
//	ApplicationContext ctx;
//	@Before
//	public void setUp(){
//		String[] configLocations = new String[] {
//				"classpath:o2p-transform-spring-all.xml" };
//		ctx = new ClassPathXmlApplicationContext(configLocations);
//	}
//	
//	@Test
//	public void bshJunit() throws Exception {
//		TransformerFactory transformerFactory = (TransformerFactory) ctx.getBean("transformerFactoryProxy");
//		AbstractTransformer transformer = (AbstractTransformer)transformerFactory.getTransformer(3);
//		MessageBO<Document> messageBO = new MessageBO<Document>();
//		StringBuffer xml = new StringBuffer();
//		xml.append("<usertoken>");
//		xml.append("absdfj111111111111");
//		xml.append("</usertoken>");
//		Document doc = DocumentHelper.parseText(xml.toString());
//		messageBO.setMsgBody(doc);
//		
//		
//		TransformerRule transformerRule = new TransformerRule();
//		
//		String scriptContent = FileUtils.readFileToString(new File("D:/sa.xml"));
//		transformerRule.setScriptContent(scriptContent);
//		transformerRule.setTransformerType(3);
//		transformer.setTransformerRule(transformerRule );
//
//		
//		transformer.transform(messageBO);
//		System.out.println("11");
//		
//	}
//	
//	@SuppressWarnings({ "rawtypes", "unchecked" })
//	@Test
//	public void test() throws Exception{
//		MessageBO messageBO = new MessageBO();
//		String script = FileUtils.readFileToString(new File("D:/filetmp/bshtest/filetrans.txt"));
//		String xml = FileUtils.readFileToString(new File("D:/filetmp/bshtest/xml1.txt"));
//		messageBO.setMsgBody(xml);
//		ScriptExecutorFactory scriptExec = new ScriptExecutorFactory();
//		ScriptExecutor exec = scriptExec.getScriptExecutor("bsh");
//		Map<String, Object> variables = new HashMap<String,Object>();
//		variables.put("messageBO", messageBO);
//		ScriptSource scriptSource = new StaticScriptSource(script);
//		MessageBO<?> _newMsg = (MessageBO<?>) exec.executeScript(scriptSource,variables);
//		System.out.println(_newMsg.toString());
//	}
//	
//	
//	
//	
//}
