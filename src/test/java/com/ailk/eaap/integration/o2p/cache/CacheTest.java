//package com.ailk.eaap.integration.o2p.cache;
//
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import com.ailk.eaap.o2p.common.cache.ICache;
//
//public class CacheTest {
//	ApplicationContext ctx;
//	@Before
//	public void setUp(){
//		String[] configLocations= new String[]{"classpath:o2p-transform-spring-db.xml",
//				"classpath:o2p-transform-spring-dao.xml",
//				"classpath:spring/eaap-op2-memCache-base.xml"};
//		ctx = new ClassPathXmlApplicationContext(configLocations);
//	}
//	@Test
//	public void test(){
//		ICache cache = (ICache) ctx.getBean("transformer.cache");
//		cache.put("hello", "mike");
//		Assert.assertEquals("mike", cache.get("hello"));
//	}
//}
