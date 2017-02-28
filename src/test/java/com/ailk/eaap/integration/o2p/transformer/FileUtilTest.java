package com.ailk.eaap.integration.o2p.transformer;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.ailk.eaap.op2.bo.EndpointAttr;
import com.ailk.eaap.op2.bo.TechImpl;

public class FileUtilTest {

	@Test
	public void message2Json(){
		TechImpl tech = new TechImpl();
		Map<String, String> attrMap = new HashMap<String, String>();
		attrMap.put(EndpointAttr.FILE_NAME, "Sales");
		attrMap.put(EndpointAttr.PRODUCT_LOCAL_PATH, "D:/");
		tech.setAttrMap(attrMap);
		
		String xmlStr = "<plan>" +
	"<element>"+
		"<name>Service Type</name>"+
		"<value>Plan Offering</value>"+
		"<Comparable></Comparable>"+
	"</element>"+
	"<element>"+
		"<name>Sub Type</name>"+
		"<value>FUP</value>"+
		"<Comparable></Comparable>"+
	"</element>"+
	"<element>"+
		"<name>Type</name>"+
		"<value>CUG</value>"+
		"<Comparable></Comparable>"+
	"</element>"+
	"<element>"+
		"<name>Billing Type</name>"+
		"<value>phonnumber pay</value>"+
		"<Comparable></Comparable>"+
	"</element>"+
	"<element>"+
		"<name>Lead Time</name>"+
		"<value>20130908</value>"+
		"<Comparable></Comparable>"+
	"</element>"+
	"<element>"+
		"<name>Volte Sim Price</name>"+
		"<value>100</value>"+
		"<Comparable>Yes</Comparable>"+
	"</element>"+
	"<element>"+
		"<name>Mifi Device</name>"+
		"<value>300</value>"+
		"<Comparable></Comparable>"+
	"</element>"+
	"<element>"+
		"<name>Price of PlanOffering  -  Mi-Fi starter plan</name>"+
		"<value>900</value>"+
		"<Comparable></Comparable>"+
	"</element>"+
	"<element>"+
		"<name>Validity</name>"+
		"<value>YES</value>"+
		"<Comparable></Comparable>"+
	"</element>"+
	"<element>"+
		"<name>Component price for  -  Mi-Fi Onnet and Offnet starter plan</name>"+
		"<value>500</value>"+
		"<Comparable></Comparable>"+
	"</element>"+
	"<element>"+
		"<name>Component price for  -  Mifi Onnet plan</name>"+
		"<value>500</value>"+
		"<Comparable></Comparable>"+
	"</element>"+
	"<element>"+
		"<name>Price of PlanOffering  -  Mi-Fi + Wifi Add-on</name>"+
		"<value>500</value>"+
		"<Comparable></Comparable>"+
	"</element>"+
	"<element>"+
		"<name>Component price for  -  Mi-Fi Onnet and Offnet recharge plan</name>"+
		"<value>500</value>"+
		"<Comparable></Comparable>"+
	"</element>"+
	"<element>"+
		"<name>Component price for  -  Wifi recharge plan</name>"+
		"<value>500</value>"+
		"<Comparable></Comparable>"+
	"</element>"+
	"<element>"+
		"<name>Price of PlanOffering  -  Mi-Fi</name>"+
		"<value>500</value>"+
		"<Comparable></Comparable>"+
	"</element>"+
	"<element>"+
		"<name>Component price for  -  Mifi Offpeak Onnet and Offnet</name>"+
		"<value>500</value>"+
		"<Comparable></Comparable>"+
	"</element>"+
	"<element>"+
		"<name>Component price for  -  Mi-Fi Peak Onnet and Offnet recharge plan</name>"+
		"<value>500</value>"+
		"<Comparable></Comparable>"+
	"</element>"+
	"<element>"+
		"<name>Price of PlanOffering  -  Night Plan</name>"+
		"<value>500</value>"+
		"<Comparable>Yes</Comparable>"+
	"</element>"+
	"<element>"+
		"<name>Component price for  -  Night Plan</name>"+
		"<value>500</value>"+
		"<Comparable></Comparable>"+
	"</element>"+
	"<element>"+
		"<name>Price of PlanOffering - Turbo</name>"+
		"<value>500</value>"+
		"<Comparable></Comparable>"+
	"</element>"+
	"<element>"+
		"<name>Component price for  -  Turbo Plan</name>"+
		"<value>500</value>"+
		"<Comparable></Comparable>"+
	"</element>"+
	"<element>"+
		"<name>Price of PlanOffering  -  Mi-Fi + Wifi starter plan</name>"+
		"<value>500</value>"+
		"<Comparable></Comparable>"+
	"</element>"+
	"<element>"+
		"<name>Component price for  -  Wifi Starter plan</name>"+
		"<value>500</value>"+
		"<Comparable></Comparable>"+
	"</element>"+
	"<element>"+
		"<name>Component price for  -  Mi-Fi Onnet and Offnet starter plan</name>"+
		"<value>500</value>"+
		"<Comparable></Comparable>"+
	"</element>"+
	"<element>"+
		"<name>Component price for  -  Mifi Onnet plan</name>"+
		"<value>500</value>"+
		"<Comparable></Comparable>"+
	"</element>"+
"</plan>";
//		FileUtils.message2File(tech, xmlStr, "json");
	}
}
