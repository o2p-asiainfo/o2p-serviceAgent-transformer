package com.ailk.eaap.integration.o2p.transformer;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ailk.eaap.integration.o2p.transformer.service.TransformerRuleService;
import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.asiainfo.integretion.o2p.serviceagent.cache.CacheServiceImpl;

public class UamTransformerTest1 {
	ApplicationContext ctx;
	private CacheServiceImpl cacheService;

	@Before
	public void setUp() {
		String[] configLocations = new String[] {
				"classpath:o2p-transform-spring-all.xml",
				"classpath:eaap-op2-memCache-all.xml",
				"classpath:spring/eaap-op2-common-spring.xml" };
		ctx = new ClassPathXmlApplicationContext(configLocations);
		cacheService = (CacheServiceImpl) ctx.getBean("cacheService");
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
	public void transformerUam() throws DocumentException {
		String xml = "<ContractRoot>" + "<TcpCont>"
				+ "<TransactionID>1000000098201308158565286859</TransactionID>"
				+ "<BusCode>BUS37059</BusCode>"
				+ "<ServiceCode>SVC33051</ServiceCode>"
				+ "<ServiceContractVer>SVC3305120130509</ServiceContractVer>"
				+ "<ActionCode>0</ActionCode>"
				+ "<ServiceLevel>1</ServiceLevel>"
				+ "<SrcOrgID>100000</SrcOrgID>"
				+ "<SrcSysID>1000000098</SrcSysID>"
				+ "<SrcSysSign>service0522654</SrcSysSign>"
				+ "<DstOrgID>100000</DstOrgID>"
				+ "<DstSysID>1000000031</DstSysID>"
				+ "<ReqTime>20130815153142</ReqTime>" + "</TcpCont>"
				+ "<SvcCont>" + "<AuthenticationQryReq>"
				+ "<AccountType>c2000004</AccountType>"
				+ "<AccountID>18901612166</AccountID>"
				+ "<PWDType>01</PWDType>" + "<Password>212233</Password>"
				+ "<ProvinceID>02</ProvinceID>" + "<CustIpAddress/>"
				+ "</AuthenticationQryReq>" + "</SvcCont>" + "</ContractRoot>";

		 MessageBO<Document> srcMsg = new MessageBO<Document>();
		 Document playload = DocumentHelper.parseText(xml);
		 srcMsg.setMsgBody(playload);
		 TransformerRuleService transformerRuleService =
		 (TransformerRuleService) ctx.getBean("transformerRuleService");
		 MessageBO<Document> msg =(MessageBO<Document>)
		 transformerRuleService.doTransform(srcMsg, 1522);// \\SPV环境ID：1
		 System.out.println(msg.getMsgBody().asXML());

	}

	@SuppressWarnings("unchecked")
	@Test
	public void transformerUamReverse() throws DocumentException {
		String webservice = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ua=\"http://www.mbossuac.com.cn/ua\">"
				+ "<soapenv:Header/>"
				+ "<soapenv:Body>"
				+ "<ua:authReq>"
				+ "<request>"
				+ "<CAPRoot>"
				+ "<SessionHeader>"
				+ "<ServiceCode>CAP01001</ServiceCode>"
				+ "<Version>CAP01001</Version>"
				+ "<ActionCode>0</ActionCode>"
				+ "<TransactionID>1000000098201308158565286859</TransactionID>"
				+ "<SrcSysID>35445</SrcSysID>"
				+ "<SrcSysSign/>"
				+ "<DstSysID>35999</DstSysID>"
				+ "<ReqTime>20130815153142</ReqTime>"
				+ "<Request>"
				+ "<ReqType/>"
				+ "<ReqCode/>"
				+ "<ReqDesc/>"
				+ "</Request>"
				+ "<DigitalSign/>"
				+ "</SessionHeader>"
				+ "<SessionBody>"
				+ "<AuthReq>"
				+ "<AuthInfo>"
				+ "<AccountType>c2000004</AccountType>"
				+ "<AccountID>18901612166</AccountID>"
				+ "<PWDType>01</PWDType>"
				+ "<Password>212233</Password>"
				+ "<ProvinceID>02</ProvinceID>"
				+ "</AuthInfo>"
				+ "</AuthReq>"
				+ "</SessionBody>"
				+ "</CAPRoot>"
				+ "</request>"
				+ "</ua:authReq>" + "</soapenv:Body>" + "</soapenv:Envelope>";
		MessageBO<Document> srcMsg = new MessageBO<Document>();
		Document playload = DocumentHelper.parseText(webservice);
		srcMsg.setMsgBody(playload);
		TransformerRuleService transformerRuleService = (TransformerRuleService) ctx
				.getBean("transformerRuleService");
		MessageBO<Document> msg = (MessageBO<Document>) transformerRuleService
				.doTransform(srcMsg, 14);
		System.out.println(msg.getMsgBody().asXML());

	}

}
