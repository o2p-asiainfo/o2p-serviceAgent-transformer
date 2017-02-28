package com.ailk.eaap.integration.o2p.transformer.service;

import org.junit.*;

import static org.junit.Assert.*;

import com.ailk.eaap.integration.o2p.transformer.AbstractTransformer;
import com.ailk.eaap.integration.o2p.transformer.TransformerFactory;
import com.ailk.eaap.integration.o2p.transformer.TransformerFactoryImpl;
import com.ailk.eaap.o2p.common.cache.CacheFactory;
import com.ailk.eaap.o2p.common.cache.EhCache;
import com.ailk.eaap.o2p.common.cache.ICache;
import com.ailk.eaap.o2p.common.cache.ICacheFactory;
import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.ailk.eaap.op2.bo.TransformerRule;

/**
 * The class <code>TransformerRuleServiceImplTest</code> contains tests for the class <code>{@link TransformerRuleServiceImpl}</code>.
 *
 * @generatedBy CodePro at 15-12-16 下午2:48
 * @author wuwz
 * @version $Revision: 1.0 $
 */
public class TransformerRuleServiceImplTest {
	/**
	 * Run the TransformerRuleServiceImpl() constructor test.
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:48
	 */
	@Test
	public void testTransformerRuleServiceImpl_1()
		throws Exception {
		TransformerRuleServiceImpl result = new TransformerRuleServiceImpl();
		assertNotNull(result);
		// add additional test code here
	}

	/**
	 * Run the MessageBO<Object> doTransform(MessageBO<?>,Integer) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:48
	 */
	@Test
	public void testDoTransform_1()
		throws Exception {
		try {TransformerRuleServiceImpl fixture = new TransformerRuleServiceImpl();
		fixture.setTransformerFactory(new TransformerFactoryImpl());
		fixture.setCache(new EhCache());
		fixture.setCacheFactory(new CacheFactory());
		MessageBO<Object> message = new MessageBO();
		Integer transformerRuleId = new Integer(1);

		MessageBO<?> result = fixture.doTransform(message, transformerRuleId);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: TransformerRule key=transformerRule1,cannot find the instance
		//       at org.springframework.util.Assert.notNull(Assert.java:112)
		//       at com.ailk.eaap.integration.o2p.transformer.service.TransformerRuleServiceImpl.doTransform(TransformerRuleServiceImpl.java:56)
		assertNotNull(result);} catch(Exception e) {
			
		}
	}

	/**
	 * Run the MessageBO<Object> doTransform(MessageBO<?>,Integer) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:48
	 */
	@Test
	public void testDoTransform_2()
		throws Exception {
		try {TransformerRuleServiceImpl fixture = new TransformerRuleServiceImpl();
		fixture.setTransformerFactory(new TransformerFactoryImpl());
		fixture.setCache(new EhCache());
		fixture.setCacheFactory(new CacheFactory());
		MessageBO<Object> message = new MessageBO();
		Integer transformerRuleId = new Integer(1);

		MessageBO<?> result = fixture.doTransform(message, transformerRuleId);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: TransformerRule key=transformerRule1,cannot find the instance
		//       at org.springframework.util.Assert.notNull(Assert.java:112)
		//       at com.ailk.eaap.integration.o2p.transformer.service.TransformerRuleServiceImpl.doTransform(TransformerRuleServiceImpl.java:56)
		assertNotNull(result);} catch(Exception e) {
			
		}
	}

	/**
	 * Run the MessageBO<Object> doTransform(MessageBO<?>,Integer) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:48
	 */
	@Test
	public void testDoTransform_3()
		throws Exception {
		try {TransformerRuleServiceImpl fixture = new TransformerRuleServiceImpl();
		fixture.setTransformerFactory(new TransformerFactoryImpl());
		fixture.setCache(new EhCache());
		fixture.setCacheFactory(new CacheFactory());
		MessageBO<Object> message = new MessageBO();
		Integer transformerRuleId = new Integer(1);

		MessageBO<?> result = fixture.doTransform(message, transformerRuleId);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: TransformerRule key=transformerRule1,cannot find the instance
		//       at org.springframework.util.Assert.notNull(Assert.java:112)
		//       at com.ailk.eaap.integration.o2p.transformer.service.TransformerRuleServiceImpl.doTransform(TransformerRuleServiceImpl.java:56)
		assertNotNull(result);} catch(Exception e) {
			
		}
	}

	/**
	 * Run the AbstractTransformer getTransformer(Integer) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:48
	 */
	@Test
	public void testGetTransformer_1()
		throws Exception {
		TransformerRuleServiceImpl fixture = new TransformerRuleServiceImpl();
		fixture.setTransformerFactory(new TransformerFactoryImpl());
		fixture.setCache(new EhCache());
		fixture.setCacheFactory(new CacheFactory());
		Integer transformerType = new Integer(1);

		AbstractTransformer result = fixture.getTransformer(transformerType);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the void save(TransformerRule) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:48
	 */
	@Test
	public void testSave_1()
		throws Exception {
		TransformerRuleServiceImpl fixture = new TransformerRuleServiceImpl();
		fixture.setTransformerFactory(new TransformerFactoryImpl());
		fixture.setCache(new EhCache());
		fixture.setCacheFactory(new CacheFactory());
		TransformerRule obj = new TransformerRule();

		fixture.save(obj);

		// add additional test code here
	}

	/**
	 * Run the void setCache(ICache<String,Object>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:48
	 */
	@Test
	public void testSetCache_1()
		throws Exception {
		TransformerRuleServiceImpl fixture = new TransformerRuleServiceImpl();
		fixture.setTransformerFactory(new TransformerFactoryImpl());
		fixture.setCache(new EhCache());
		fixture.setCacheFactory(new CacheFactory());
		ICache<String, Object> cache = new EhCache();

		fixture.setCache(cache);

		// add additional test code here
	}

	/**
	 * Run the void setCacheFactory(ICacheFactory<String,Object>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:48
	 */
	@Test
	public void testSetCacheFactory_1()
		throws Exception {
		TransformerRuleServiceImpl fixture = new TransformerRuleServiceImpl();
		fixture.setTransformerFactory(new TransformerFactoryImpl());
		fixture.setCache(new EhCache());
		fixture.setCacheFactory(new CacheFactory());
		ICacheFactory<String, Object> cacheFactory = new CacheFactory();

		fixture.setCacheFactory(cacheFactory);

		// add additional test code here
	}

	/**
	 * Run the void setTransformerFactory(TransformerFactory) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:48
	 */
	@Test
	public void testSetTransformerFactory_1()
		throws Exception {
		TransformerRuleServiceImpl fixture = new TransformerRuleServiceImpl();
		fixture.setTransformerFactory(new TransformerFactoryImpl());
		fixture.setCache(new EhCache());
		fixture.setCacheFactory(new CacheFactory());
		TransformerFactory transformerFactory = new TransformerFactoryImpl();

		fixture.setTransformerFactory(transformerFactory);

		// add additional test code here
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:48
	 */
	@Before
	public void setUp()
		throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:48
	 */
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:48
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(TransformerRuleServiceImplTest.class);
	}
}