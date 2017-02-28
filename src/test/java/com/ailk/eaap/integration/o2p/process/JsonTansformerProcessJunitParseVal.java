package com.ailk.eaap.integration.o2p.process;


import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.ailk.eaap.op2.bo.NodeDesc;
import com.jayway.jsonpath.JsonPath;

public class JsonTansformerProcessJunitParseVal {
	String json = "{\"store\":"
			   +"{\"bicycle\":"
			   +"{\"prices\":19.95, \"color\":\"red\"},"
			   +"\"book\":["
			   +"{\"price\":8.95, \"category\":\"reference\", \"title\":\"Sayings of the Century\", \"author\":\"Nigel Rees\"},"
			   +"{\"price\":12.99, \"category\":\"fiction\", \"title\":\"Sword of Honour\", \"author\":\"Evelyn Waugh\"},"
			   +"{\"price\":8.99, \"category\":\"fiction\", \"isbn\":\"0-553-21311-3\", \"title\":\"Moby Dick\", \"author\":\"Herman Melville\",\"color\":\"blue\"},"
			   +"{\"price\":22.99, \"category\":\"fiction\", \"isbn\":\"0-395-19395-8\", \"title\":\"The Lord of the Rings\", \"author\":\"Tolkien\"}"
			   +"]"
			   +"}"
			   +"}";
	
	MessageBO<Object> bo = new MessageBO<Object>();
	NodeDesc nd = new NodeDesc();

	@Before
	public void setUp() throws Exception {
		bo.setMsgBody(json);
		nd.setNodePath("$..price");
	}

	@SuppressWarnings("rawtypes")
	@Test
	public void test() throws IOException {
//		JsonTransformerProcessIn jin = new JsonTransformerProcessIn();
//		Object o = jin.parseNodeValBySrcMsg(bo, null, nd);
//		System.out.println(o.toString());
		String customerId = JsonPath.read(json1, "$.customerId").toString();
		System.out.println();
		String newMsg = "{\"customerId\":" + customerId+ ",\"AppKey\":\"8000160001\"}";
		System.out.println("newMsg : " + newMsg);
		Object o = JsonPath.read(json, "$..price");
		List list = null;
		if (o instanceof List) {
			System.out.println("list");
			list = (List) o;
			System.out.println(list.size());
		}
	}

	
	static String json1= "{   \"customerId\": \"201503271200\",   \"serviceStatusList\": [     \"\",     \"\"   ],   \"accountId\": \"\",   \"identifiers\": [     {       \"value\": \"\",       \"subCategory\": \"\"     }   ],   \"filterKey\": \"\",   \"channel\": \"\" } ";
	
	
}
