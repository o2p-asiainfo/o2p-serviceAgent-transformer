/** 
 * Project Name:o2p-serviceAgent-transformer 
 * File Name:XmlTest.java 
 * Package Name:com.ailk.eaap.integration.o2p.transformer 
 * Date:2016年1月7日下午5:55:31 
 * Copyright (c) 2016, www.asiainfo.com All Rights Reserved. 
 * 
*/  
  
package com.ailk.eaap.integration.o2p.transformer;  

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.junit.Test;
import org.xml.sax.SAXException;

import com.jayway.jsonpath.JsonPath;

/** 
 * ClassName:XmlTest  
 * Function: TODO ADD FUNCTION.  
 * Reason:   TODO ADD REASON.  
 * Date:     2016年1月7日 下午5:55:31  
 * @author   wuwz 
 * @version   
 * @since    JDK 1.6 
 *        
 */
public class XmlTest {

	public static void main(String[] args) throws DocumentException {
		// TODO Auto-generated method stub
		Document doc = getDoc2();
		//1查找数组节点
		List<Node> itemList = doc.selectNodes("/ItemData/item");
		//2查找数组节点的父节点
		Element itemEP = (Element)doc.selectSingleNode("/ItemData");
		//删除数组节点
		for(Node itemNode : itemList) {
			
			itemEP.remove(itemNode);
		}
		System.out.println("doc :"+doc.asXML());
		Node itemNode = itemList.get(0);
		Document itemDoc = DocumentHelper.parseText(itemNode.asXML());
		//子节点
		Node node = itemDoc.selectSingleNode("/item/ItmNumber");
		//赋值
		node.setText("新值");
		//添加节点
		itemEP.add(itemDoc.getRootElement());
		
	
		listTest();
		System.out.println("after doc:"+doc.asXML());
	}
	
	private static void listTest() {

//		List<String> list = new ArrayList<String>();
//		list.add("1");
//		list.add("2");
//		
//		List<String> newlist = new ArrayList<String>();
//		newlist.addAll(list);
//		newlist.remove("2");
//		
//		System.out.println("list:"+list.toString());
//		System.out.println("newList:"+newlist.toString());
		
//		List<String> list = new ArrayList<String>();
//		for(String a : list) {
//			
//			System.out.println("newList:");
//		}
		
	}

	private static Document getDoc1() throws DocumentException {

		String str = "<ItemData>          "+
				"  <item>            "+
				"    <ItmNumber>1</ItmNumber>    "+
				"    <Material>2</Material>     "+
				"  </item>           "+
				"</ItemData>         ";
		Document doc = DocumentHelper.parseText(str);
		return doc;
	}

	private static Document getDoc2() throws DocumentException {

		String str = "<ItemData>          "+
				"  <item>            "+
				"    <ItmNumber>1</ItmNumber>    "+
				"    <Material>2</Material>     "+
				"  </item>           "+
				"  <item>            "+
				"    <ItmNumber>3</ItmNumber>    "+
				"    <Material>4</Material>     "+
				"  </item>           "+
				"</ItemData>         ";
		Document doc = DocumentHelper.parseText(str);
		return doc;
	}
	
	@Test
	public void testXmlLead() throws DocumentException{
		
		Document doc = getDoc2();
		
		Node node = doc.selectSingleNode("//ItemData");
		Node node3 = doc.selectSingleNode("//ItemData");
		Node node2 = doc.selectSingleNode("//ItemData/item/ItmNumber");
		node.hasContent();
		node2.hasContent();
		System.out.println("==============="+node.getText());
	}
	
	@Test
	public void testXml1() throws DocumentException, SAXException{
		
		Document doc = getDoc3();
		
		Node node = doc.selectSingleNode("/*[local-name()='provisionSubscriberResponse']/*[local-name()='detail']/*[local-name()='errorMessage']");
		System.out.println("==============="+node.getText());
	}

	private static Document getDoc3() throws DocumentException, SAXException {

		String str = "<provisionSubscriberResponse xmlns:i=\"http://www.w3.org/2001/XMLSchemainstance\" xmlns=\"http://schemas.datacontract.org/2004/07/OTTProvision.Models\">    "+
				"<message>FAIL</message>                                                                                                                                     "+
				"<responseCode>111111111</responseCode>                                                                                                                      "+
				"<detail>                                                                                                                                                    "+
				"	<errorCode>130</errorCode>                                                                                                                                 "+
				"	<errorMessage>A felhaszn谩l贸 m谩r l茅tezik!</errorMessage>                                                                                                "+
				"</detail>                                                                                                                                                   "+
				"</provisionSubscriberResponse>                                                                                                                              ";
		Document doc = MyDocumentHelper.parseText(str);
		return doc;
	}
	
	@Test
	public  void getDoc4() throws DocumentException, SAXException {

		String str = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>                                                                                            "+
				"<!--ProvisioningRequest.xml-->                                                                                                        "+
				"<!DOCTYPE ProvisioningRequest SYSTEM \"ProvisioningRequest.dtd\">                                                                     "+
				"<ProvisioningRequest TransactionId=\"20160310756001\" Version=\"1.2\" TransactionType=\"Activate\" ProductType=\"BlackBerry\">        "+
				"    <Header>                                                                                                                          "+
				"        <Sender>                                                                                                                      "+
				"            <Login>belaba</Login>                                                                                                     "+
				"            <Password>dxaeU4Vq4x</Password>                                                                                           "+
				"        </Sender>                                                                                                                     "+
				"        <TimeStamp>2016-02-22T10:08:08-08:00</TimeStamp>                                                                              "+
				"    </Header>                                                                                                                         "+
				"    <Body>                                                                                                                            "+
				"        <ProvisioningEntity name=\"subscriber\">                                                                                      "+
				"            <ProvisioningDataItem name=\"IMSI\">216012495033271</ProvisioningDataItem>                                                "+
				"            <ProvisioningEntity name=\"service\">                                                                                     "+
				"                <ProvisioningDataItem name=\"ServiceName\">Enterprise B</ProvisioningDataItem>                                        "+
				"            </ProvisioningEntity>                                                                                                     "+
				"        </ProvisioningEntity>                                                                                                         "+
				"    </Body>                                                                                                                           "+
				"</ProvisioningRequest>                                                                                                                ";

		Document doc = MyDocumentHelper.parseText(str);
		System.out.println(doc.asXML());
	}
}
