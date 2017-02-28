package com.ailk.eaap.integration.o2p.process;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.ailk.eaap.integration.o2p.transformer.service.TransformerRuleService;
import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.ailk.eaap.op2.bo.MessageDesc;
import com.ailk.eaap.op2.bo.MessageNode;
import com.ailk.eaap.op2.bo.NodeDesc;

public class CsvTansformerProcessJunit {
	MessageDesc md = new MessageDesc();

	ApplicationContext ctx;
	
	Resource res = new ClassPathResource("com/ailk/eaap/integration/o2p/process/3.csv");

	@SuppressWarnings("unchecked")
	@Test
	public void test() throws Exception {
		MessageBO<File> srcMsg = new MessageBO<File>();
		File file = res.getFile();//new File("C:/Users/zhongming/Desktop/DI_10584_20140516_000001_20140516030051_CM_ACCOUNT.DAT");
		srcMsg.setMsgBody(file);
		TransformerRuleService transformerRuleService = (TransformerRuleService) ctx
				.getBean("transformerRuleService");
		MessageBO<File> msg = (MessageBO<File>) transformerRuleService
				.doTransform(srcMsg, 12);
		System.out.println("CSV new file : " + msg.getMsgBody().toString());
		
//		file = new File("C:/Users/zhongming/Desktop/3.csv");//Telenor_Mob_afregning_2013-11-27_Pos.DAT
//		FileUtils.writeStringToFile(file, "\r\n123\r\n", true);
//		String sss = FileUtils.readFileToString(file);
//		System.out.println("sss : " + sss);
//		String[] arrs = sss.split("\r\n");
//		System.out.println(Arrays.deepToString(arrs));
	}

	@Before
	public void setUp() throws Exception {
		String[] configLocations= new String[]{"classpath:springdev/o2p-transform-spring-db.xml",
				"classpath:o2p-transform-spring-all.xml",
				"classpath:spring/eaap-op2-memCache-base.xml"};
		ctx = new ClassPathXmlApplicationContext(configLocations);

		md.setMessageNodes(new ArrayList<MessageNode>());
		NodeDesc nd = new NodeDesc();
		nd.setNodeName("price");
		MessageNode mn = new MessageNode();
		List<String> list = new ArrayList<String>();
		list.add("12");
		list.add("中午");
		mn.setNodeDesc(nd);
		mn.setNodeVal(list);
		md.getMessageNodes().add(mn);

		nd = new NodeDesc();
		nd.setNodeName("price");

		mn = new MessageNode();
		list = new ArrayList<String>();
		list.add("22");
		list.add("晚上");
		mn.setNodeDesc(nd);
		mn.setNodeVal(list);
		md.getMessageNodes().add(mn);
	}

}
