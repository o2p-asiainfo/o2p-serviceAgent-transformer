package com.ailk.eaap.integration.o2p.transformer;


import java.io.IOException;

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

public class UamTransformerTest2 {
	ApplicationContext ctx;
	private CacheServiceImpl cacheService;
	@Before
	public void setUp(){
		String[] configLocations = new String[] {
				"classpath:o2p-transform-spring-all.xml",
				"classpath:eaap-op2-memCache-all.xml",
				"classpath:spring/eaap-op2-common-spring.xml" };
		ctx = new ClassPathXmlApplicationContext(configLocations);
		cacheService = (CacheServiceImpl) ctx.getBean("cacheService");
		
	}

	@Test
	public void test() {
		TransformerFactory transformerFactory = (TransformerFactory) ctx.getBean("transformerFactoryProxy");
		Transformer transformer = transformerFactory.getTransformer(1);
		Assert.assertNotNull(transformer);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void transformerUam() throws DocumentException{
		cacheService.addByModuleName(CacheKey.MODULE_TRANSFORMER_RULE, null);
		String xml = "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">"
						+"<soap:Body>"
						+"<ns1:authReqResponse xmlns:ns1=\"http://www.mbossuac.com.cn/ua\">"
						+"<response>"
						+"<CAPRoot>"
						+"<SessionHeader>"
						+"<ActionCode>1</ActionCode>"
						+"<TransactionID>?</TransactionID>"
						+"<RspTime>20130515104625</RspTime>"
						+"<Response>"
							+"<RspType>8</RspType>"
							+"<RspCode>8001</RspCode>"
							+"<RspDesc>认证失败</RspDesc>"
						+"</Response>"
						+"</SessionHeader>"
						+"</CAPRoot>"
						+"</response>"
						+"</ns1:authReqResponse>"
						+"</soap:Body>"
						+"</soap:Envelope>";
		
		MessageBO<Document> srcMsg = new MessageBO<Document>();
		Document playload = DocumentHelper.parseText(xml);
		
		srcMsg.setMsgBody(playload);
		TransformerRuleService transformerRuleService = (TransformerRuleService) ctx.getBean("transformerRuleService");
		MessageBO<Document> msg =(MessageBO<Document>) transformerRuleService.doTransform(srcMsg, 19);
		System.out.println(msg.getMsgBody().asXML());
		
	}
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void transformerUamReverse() throws DocumentException{
		cacheService.addByModuleName(CacheKey.MODULE_TRANSFORMER_RULE, null);
		String xml = "<ContractRoot>"
				 +"<TcpCont>"
				 +"<TransactionID/>"
				 +"<ActionCode>1</ActionCode>"
				 +"<RspTime>20130515104625</RspTime>"
				 +"<Response>"
				 +"<RspType>81</RspType>"
				 +"<RspCode>8001</RspCode>"
				 +"<RspDesc>认证失败</RspDesc>"
				 +"</Response>"
				 +"</TcpCont>"
   			 +"<SvcCont>"
   			 +"<AuthenticationQryResp>"
   			 +"<RspType>81</RspType>"
   			 +"<RspCode>8001</RspCode>"
   			 +"<RspDesc>认证失败</RspDesc>"
   			 +"</AuthenticationQryResp>"
 				 +"</SvcCont>"
 				 +"</ContractRoot>";
		MessageBO<Document> srcMsg = new MessageBO<Document>();
		Document playload = DocumentHelper.parseText(xml);
		
		srcMsg.setMsgBody(playload);
		TransformerRuleService transformerRuleService = (TransformerRuleService) ctx.getBean("transformerRuleService");
		MessageBO<Document> msg =(MessageBO<Document>) transformerRuleService.doTransform(srcMsg, 20);
		System.out.println(msg.getMsgBody().asXML());
	}
	
	@Test
	public void transformer54() throws DocumentException{
		String xml = "<host>"
						+"<PreMessage>"
						+"<OrderNbr>订单号</OrderNbr>"
						+"<SerialNum>服务号码</SerialNum>"
						+"<ActiveFlag>激活标志：000，激活；9999,未激活</ActiveFlag>"
						+"<ActiveDesc>激活说明：激活标志为未激活时填写未激活原因</ActiveDesc>"
						+"</PreMessage>"
						+"</host>";
		MessageBO<Document> srcMsg = new MessageBO<Document>();
		Document playload = DocumentHelper.parseText(xml);
		
		srcMsg.setMsgBody(playload);
		TransformerRuleService transformerRuleService = (TransformerRuleService) ctx.getBean("transformerRuleService");
		MessageBO<Document> msg =(MessageBO<Document>) transformerRuleService.doTransform(srcMsg, 1361);
		System.out.println(msg.getMsgBody().asXML());
	}
	
	@Test
	public void transformerLocal() throws DocumentException, IOException{

		Resource res = new ClassPathResource("com/ailk/eaap/integration/o2p/transformer/POS_Order_req.txt");
		String src = FileUtils.readFileToString(res.getFile());
//		Document doc = DocumentHelper.parseText(src);
		MessageBO<Document> srcMsg = new MessageBO<Document>();
		Document playload = DocumentHelper.parseText(src);
		
		srcMsg.setMsgBody(playload);
		TransformerRuleService transformerRuleService = (TransformerRuleService) ctx.getBean("transformerRuleService");
		MessageBO<Document> msg =(MessageBO<Document>) transformerRuleService.doTransform(srcMsg, 1398);
		System.out.println(msg.getMsgBody().asXML());
	}
	
}
