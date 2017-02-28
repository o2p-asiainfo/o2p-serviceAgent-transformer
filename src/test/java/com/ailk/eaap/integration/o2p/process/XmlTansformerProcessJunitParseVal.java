package com.ailk.eaap.integration.o2p.process;


import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Namespace;
import org.junit.Before;
import org.junit.Test;

import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.ailk.eaap.op2.bo.NodeDesc;

public class XmlTansformerProcessJunitParseVal {
	String str = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
			  +"<?xml-stylesheet type=\"text/xsl\" href=\"2.xsl\"?>"
			  +"<soapenv:Envelope " 
//			  +"xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" " 
			  +"xmlns:soa=\"http://soa.ailk.telenor.com/wsdl/soa/\" "
			  +"xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope\">"
			  +"<soapenv:Header a=\"b\" c=\"c\">"
			  +"<soa:RequestHead>"
			  +"<AppKey>?</AppKey>"
			  +"<TransactionID>?111</TransactionID>"
			  +"<ReqTime>?</ReqTime>"
			  +"<!--Optional:-->"
			  +"<Sign>?</Sign>"
			  +"<!--Optional:-->"
			  +"<AccessToken>?</AccessToken>"
			  +"<Version>?</Version>"
			  +"<!--Optional:-->"
			  +"<TenantId>?</TenantId>"
			  +"<!--Optional:-->"
			  +"<DstSysID>?</DstSysID>"
			  +"<!--Optional:-->"
			  +"<AcceptRegionCode>?</AcceptRegionCode>"
			  +"<!--Optional:-->"
			  +"<AcceptChannelType>?</AcceptChannelType>"
			  +"<!--Optional:-->"
			  +"<AcceptChannelCode>?</AcceptChannelCode>"
			  +"<!--Optional:-->"
			  +"<AcceptStaffId>?</AcceptStaffId>"
			  +"<!--Optional:-->"
			  +"<ChargeFlag>?</ChargeFlag>"
			  +"<!--Optional:-->"
			  +"<NotifyFlag>?</NotifyFlag>"
			  +"</soa:RequestHead>"
			  +"</soapenv:Header>"
			  +"<soapenv:Body>"
			  +"<soa:checkCustomerStatusRequest>"
			  +"<request>"
			  +"<birthName>20011015</birthName>"
			  +"<callbackAddress> com.asiainfo.integretion.o2p.serviceagent.cache.IMemcacheManageServ���ݹ�¥�� </callbackAddress>"
			  +"<dateOfBirth>20140101</dateOfBirth>"
			  +"<documents>"
				 +"<item>"
					 +"<documentNumber>123123213213</documentNumber>"
					 +"<documentType>A</documentType>"
				 +"</item>"
			 +"</documents>"
			 +"<motherName>com.asiainfo.integretion.o2p.serviceagent.cache.IMemcacheManageServ</motherName>"
			 +"<name>com.asiainfo.integretion.o2p.serviceagent.cache.IMemcacheManageServ</name>"
			 +"<operatorsGeneratedID>66612312321343435</operatorsGeneratedID>"
			 +"<placeOfBirth>20130000</placeOfBirth>"
			 +"<taxNumber>99999</taxNumber>"
			 +"<tradeRegisterNumber>88888</tradeRegisterNumber>"
			 +"<username>��Խ</username>"
			 +"</request>"
			 +"</soa:checkCustomerStatusRequest>"
			 +"</soapenv:Body>"
			 +"</soapenv:Envelope>";
	
	String stu = "<root>"
					+"<student>"
					+"<age>1</age>"
					+"<name></name>"
					+"<dd>66</dd>"
					+"</student>"
					+"<student>"
					+"<age>5</age>"
					+"<name></name>"
					+"</student>"
					+"</root>";
	
	MessageBO<Object> bo = new MessageBO<Object>();
	NodeDesc nd = new NodeDesc();
	@Before
	public void setUp() throws Exception {
		bo.setMsgBody(DocumentHelper.parseText(str));
//		nd.setNodePath("//soapenv:Envelope/soapenv:Body/soa:checkCustomerStatusRequest/request/username");
//		nd.setNodePath("//soapenv:Envelope/soapenv:Body/soa:checkCustomerStatusRequest/request/name");
//		nd.setNodePath("//soapenv:Header[@a]");
		nd.setNodePath("//soa:TransactionID");
		
		bo.setMsgBody(DocumentHelper.parseText(stu));
		nd.setNodePath("//age");
		nd.setNodeType("2");
		nd.setNodeNumberCons("1");
	}

	@SuppressWarnings("unchecked")
	@Test
	public void test() {
		XmlTransformerProcessIn xmlTP = new XmlTransformerProcessIn();
		Object o = xmlTP.parseNodeValBySrcMsg(bo, null, nd);
		System.out.println(o);
		Element e = (Element) o;
		Namespace n = e.getNamespace();
		System.out.println(n.getPrefix());
		System.out.println(n.getURI());
		List<Attribute> list = e.attributes();
		for( Attribute a : list ){
			System.out.println(a.getText());
		}
		System.out.println(o.toString());
	}

}
