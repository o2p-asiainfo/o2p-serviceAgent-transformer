package com.ailk.eaap.integration.o2p.process;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.ailk.eaap.integration.o2p.transformer.service.TransformerRuleService;
import com.ailk.eaap.o2p.common.cache.CacheKey;
import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.ailk.eaap.op2.bo.MessageDesc;
import com.asiainfo.integretion.o2p.serviceagent.cache.CacheServiceImpl;

public class TxtTransformerProcessJunit {
	MessageDesc md = new MessageDesc();

	ApplicationContext ctx;
	private CacheServiceImpl cacheService;
	
	Resource res = new ClassPathResource("com/ailk/eaap/integration/o2p/process/Telenor_Mob_afregning_2013-11-27_Pos.DAT");
	
	@SuppressWarnings("unchecked")
	@Test
	public void test() throws IOException {
		cacheService.addByModuleName(CacheKey.MODULE_TRANSFORMER_RULE, null);
		MessageBO<File> srcMsg = new MessageBO<File>();
		File file = res.getFile();// new File("C:/Users/zhongming/Desktop/3.csv");
		srcMsg.setMsgBody(file);
		TransformerRuleService transformerRuleService = (TransformerRuleService) ctx
				.getBean("transformerRuleService");
		MessageBO<File[]> msg = (MessageBO<File[]>) transformerRuleService
				.doTransform(srcMsg, 13);
		System.out.println("TXT new file : " + msg.getMsgBody().toString());
	}
	
	@Before
	public void setUp() throws Exception {
//		String[] configLocations= new String[]{"classpath:springdev/o2p-transform-spring-db.xml",
//				"classpath:o2p-transform-spring-all.xml",
//				"classpath:spring/eaap-op2-memCache-base.xml"};
//		ctx = new ClassPathXmlApplicationContext(configLocations);
		String[] configLocations = new String[] {
				"classpath:o2p-transform-spring-all.xml",
				"classpath:eaap-op2-memCache-all.xml",
				"classpath:spring/eaap-op2-common-spring.xml" };
		ctx = new ClassPathXmlApplicationContext(configLocations);
		cacheService = (CacheServiceImpl) ctx.getBean("cacheService");
	}

}
