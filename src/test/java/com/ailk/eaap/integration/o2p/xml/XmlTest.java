//package com.ailk.eaap.integration.o2p.xml;
//
//import java.io.File;
//import java.io.IOException;
//
//import org.apache.commons.io.FileUtils;
//import org.dom4j.CDATA;
//import org.dom4j.Document;
//import org.dom4j.DocumentHelper;
//import org.dom4j.Element;
//import org.dom4j.dom.DOMCDATA;
//import org.junit.Test;
//
//import com.ailk.eaap.op2.serviceagent.common.EAAPAxisClient;
//
//public class XmlTest {
//
//	@Test
//	public void test() throws Exception{
//		String text = FileUtils.readFileToString(new File("d:/TEMP/testSoap.xml"));
//		Document doc = DocumentHelper.parseText(text);
//		Element elm = (Element) doc.selectSingleNode("/soapenv:Envelope/soapenv:Body/abc:person");
//		System.out.println(elm.getText());
//	}
//	@Test
//	public void test2() throws IOException{
//		Document doc = DocumentHelper.createDocument();
//		CDATA cdata = new DOMCDATA("select 1 from test where 2>1");
//		doc.addElement("root").add(cdata);
//		FileUtils.writeStringToFile(new File("d:/test/xmltest2.xml"), doc.asXML());
//	}
//	@Test
//	public void test3(){
//		String ret = buildSoap("http://www.chinatelecom.com","","offerBusinessSubmit","chin","inputParam","","true","hahaha");
//		System.out.println(ret);
//	}
//	@Test
//	public void test4(){
//		try{
//		String xml = FileUtils.readFileToString(new File("d:/test/xmltest.xml"));
//		String defaultInparamnamespace = "http://www.chinatelecom.com";
//		String defaultInparamname = "inputParam";
//		String url = "http://219.146.3.115/gd_service/services/OfferService";
//		String str ="#!";
//		String st[] = xml.split(str);
//		for (int i = 0; i < st.length; i++) {
//			System.out.println(st[i]);
//		}
//		String resp = EAAPAxisClient.sendWebServiceReq("offerBusinessSubmit",defaultInparamnamespace,defaultInparamname,"",xml,url,30,null,null,null,null);
//		System.out.println(resp);
//		}catch(Exception e){
//			
//			e.printStackTrace();
//		}
//	}
//	@Test
//	public void test5(){
//
//	}
//	public static String buildSoap(String namespace,String header,String methodName,String methodSpace,String paramName,String paramNameSpace,String needCDATA,String msg){
//		StringBuffer sb = new StringBuffer();
//		sb.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"");
//		
//		if(namespace!=null){
//			sb.append(" ");
//			sb.append(namespace);
//		}
//		sb.append(">");
//		sb.append("<soapenv:Header>");
//		if(header!=null){
//			sb.append(header);
//		}
//		sb.append("</soapenv:Header>");
//		sb.append("<soapenv:Body>");
//		
//		if(methodName!=null){
//			sb.append("<");
//			sb.append(methodName);
//			if(methodSpace!=null){
//				sb.append(" ");
//				sb.append(methodSpace);
//			}
//			sb.append(">");
//			
//		}
//		
//		if(paramName!=null){
//			sb.append("<");
//			sb.append(paramName);
//			if(paramNameSpace!=null){
//				sb.append(" ");
//				sb.append(paramNameSpace);
//			}
//			sb.append(">");
//		}
//		
//		
//		if(needCDATA==null || needCDATA.equalsIgnoreCase("FALSE") ){
//			sb.append("<![CDATA[");
//			
//		}
//		sb.append(msg);
//		if(needCDATA==null || needCDATA.equalsIgnoreCase("FALSE")){
//			sb.append("]]>");
//		}
//		
//		if(paramName!=null ){
//			sb.append("</");
//			sb.append(paramName);
//			sb.append(">");
//			
//		}
//		if(methodName!=null){
//			sb.append("</");
//			sb.append(methodName);
//			sb.append(">");
//		}
//		sb.append("</soapenv:Body>");
//		sb.append("</soapenv:Envelope>");
//		return sb.toString();
//	}
//}
