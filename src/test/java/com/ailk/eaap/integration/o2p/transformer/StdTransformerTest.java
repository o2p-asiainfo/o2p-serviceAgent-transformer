///** 
// * Project Name:o2p-serviceAgent-transformer 
// * File Name:Xml2JsonTransformer.java 
// * Package Name:com.ailk.eaap.integration.o2p.transformer 
// * Date:2014年9月30日下午3:05:30 
// * Copyright (c) 2014, www.asiainfo.com All Rights Reserved. 
// * 
//*/  
//  
//package com.ailk.eaap.integration.o2p.transformer;  
//
//import java.io.IOException;
//
//import junit.framework.Assert;
//import net.sf.json.JSON;
//import net.sf.json.JSONSerializer;
//import net.sf.json.xml.XMLSerializer;
//
//import org.apache.commons.io.FileUtils;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.Resource;
//
//import com.ailk.eaap.o2p.common.cache.CacheKey;
//import com.ailk.eaap.o2p.common.util.StaxonUtils;
//import com.asiainfo.integretion.o2p.serviceagent.cache.CacheServiceImpl;
//
///** 
// * ClassName:Xml2JsonTransformer  
// * Function: TODO ADD FUNCTION.  
// * Reason:   TODO ADD REASON.  
// * Date:     2014年9月30日 下午3:05:30  
// * @author   颖勤 
// * @version   
// * @since    JDK 1.6 
// *        
// */
//public class StdTransformerTest {
//	private ApplicationContext ctx;
//	private CacheServiceImpl cacheService;
//	@Before
//	public void cacheInit(){
//		String[] configLocations = new String[]{"classpath:o2p-transform-spring-all.xml","classpath:eaap-op2-memCache-all.xml",
//				"classpath:spring/eaap-op2-common-spring.xml"};
//		ctx = new ClassPathXmlApplicationContext(configLocations);
//		cacheService = (CacheServiceImpl) ctx.getBean("cacheService");
//	}
//	@Test
//	public void testCache(){
//		cacheService.addByModuleName(CacheKey.MODULE_TRANSFORMER_RULE, null);
//	}
//	@Test
//	public void test() throws IOException{
//		String srcDataPath = "com/ailk/eaap/integration/o2p/transformer/xml2json.xml";
//		Resource srcDataResource = new ClassPathResource(srcDataPath);
//		String reqMsgBody = StaxonUtils.xml2json(FileUtils.readFileToString(srcDataResource.getFile()));
//		System.out.println(reqMsgBody);
//	}
//	@Test
//	public void test2() throws IOException{
//		String srcDataPath = "com/ailk/eaap/integration/o2p/transformer/json2xml.json";
//		Resource srcDataResource = new ClassPathResource(srcDataPath);
//		String reqMsgBody = StaxonUtils.jsontoXml(FileUtils.readFileToString(srcDataResource.getFile()));
//		System.out.println(reqMsgBody);
//	}	
//	@Test
//	public void testXml2Json(){
//		String xml1 = "<User><id>1</id><name>张三</name></User>";  
//        String json = xml2json(xml1);  
//        Assert.assertEquals("{\"id\":\"1\",\"name\":\"张三\"}", json);  
//        String xml2 = "<Response><CustID>1300000428</CustID><Items><Item><Sku_ProductNo>sku_0004</Sku_ProductNo></Item><Item><Sku_ProductNo>0005</Sku_ProductNo></Item></Items></Response>";  
//        String json2 = xml2json(xml2);  
//        System.out.println(json2);
//        //处理数组时expected是处理结果，但不是我们想要的格式  
//        System.out.println(json2xml(json2));
//        String expected = "{\"CustID\":\"1300000428\",\"Items\":[{\"Sku_ProductNo\":\"sku_0004\"},{\"Sku_ProductNo\":\"0005\"}]}";  
//        Assert.assertEquals(expected, json2);  
//        //实际上我们想要的是expected2这种格式,所以用json-lib来实现含有数组的xml to json是不行的  
//        String expected2 = "{\"CustID\":\"1300000428\",\"Items\":{\"Item\":[{\"Sku_ProductNo\":\"sku_0004\"},{\"Sku_ProductNo\":\"0005\"}]}}";  
//        
////        Assert.assertEquals(expected2, json2);
//	}
//	public static String xml2json(String xmlString){    
//        XMLSerializer xmlSerializer = new XMLSerializer();    
//        JSON json = xmlSerializer.read(xmlString);    
//        return json.toString();    
//    } 
//	 public static String json2xml(String jsonString){    
//	        XMLSerializer xmlSerializer = new XMLSerializer();    
//	        xmlSerializer.setTypeHintsEnabled(true);//是否保留元素类型标识，默认true  
////	        xmlSerializer.setElementName("e");//设置元素标签，默认e  
////	        xmlSerializer.setArrayName("a");//设置数组标签，默认a  
////	        xmlSerializer.setObjectName("o");//设置对象标签，默认o  
//	        return xmlSerializer.write(JSONSerializer.toJSON(jsonString));    
//	    }  
//}
