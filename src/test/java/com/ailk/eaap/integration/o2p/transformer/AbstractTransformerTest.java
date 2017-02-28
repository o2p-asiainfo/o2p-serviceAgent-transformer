//package com.ailk.eaap.integration.o2p.transformer;
//
//import org.junit.*;
//import static org.junit.Assert.*;
//import com.ailk.eaap.o2p.common.cache.CacheFactory;
//import com.ailk.eaap.o2p.common.cache.ICacheFactory;
//import com.ailk.eaap.op2.serviceagent.common.FileMessageBO;
//import com.ailk.eaap.op2.serviceagent.common.MessageBO;
//import com.ailk.eaap.op2.bo.TransformerRule;
//
///**
// * The class <code>AbstractTransformerTest</code> contains tests for the class <code>{@link AbstractTransformer}</code>.
// *
// * @generatedBy CodePro at 15-12-16 下午2:41
// * @author wuwz
// * @version $Revision: 1.0 $
// */
//public class AbstractTransformerTest {
//	/**
//	 * Run the ICacheFactory<String, Object> getCacheFactory() method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:41
//	 */
//	@Test
//	public void testGetCacheFactory_1()
//		throws Exception {
//		AbstractTransformer fixture = new Byte2StringTransformer();
//
//		ICacheFactory<String, Object> result = fixture.getCacheFactory();
//
//		// add additional test code here
//		assertEquals(null, result);
//	}
//
//	/**
//	 * Run the TransformerRule getTransformerRule() method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:41
//	 */
//	@Test
//	public void testGetTransformerRule_1()
//		throws Exception {
//		AbstractTransformer fixture = new Byte2StringTransformer();
//
//		TransformerRule result = fixture.getTransformerRule();
//
//		// add additional test code here
//		assertEquals(null, result);
//	}
//
//	/**
//	 * Run the void setCacheFactory(ICacheFactory<String,Object>) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:41
//	 */
//	@Test
//	public void testSetCacheFactory_1()
//		throws Exception {
//		AbstractTransformer fixture = new Byte2StringTransformer();
//		ICacheFactory<String, Object> cacheFactory = new CacheFactory();
//
//		fixture.setCacheFactory(cacheFactory);
//
//		// add additional test code here
//	}
//
//	/**
//	 * Run the void setTransformerRule(TransformerRule) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:41
//	 */
//	@Test
//	public void testSetTransformerRule_1()
//		throws Exception {
//		AbstractTransformer fixture = new Byte2StringTransformer();
//		TransformerRule transformerRule = new TransformerRule();
//
//		fixture.setTransformerRule(transformerRule);
//
//		// add additional test code here
//	}
//
//	/**
//	 * Run the MessageBO<Object> transform(MessageBO) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:41
//	 */
//	@Test
//	public void testTransform_1()
//		throws Exception {
//		AbstractTransformer fixture = new Byte2StringTransformer();
//		MessageBO message = new MessageBO();
//
//		MessageBO<Object> result = fixture.transform(message);
//
//		// add additional test code here
//		// An unexpected exception was thrown in user code while executing this test:
//		//    org.springframework.context.NoSuchMessageException: No message found under code 'o2p.serviceAgent.transformer.abstractTransformer' for locale 'zh_CN'.
//		//       at org.springframework.context.support.AbstractMessageSource.getMessage(AbstractMessageSource.java:159)
//		//       at com.asiainfo.foundation.util.MessageSourceUtils.getMessage(MessageSourceUtils.java:41)
//		//       at com.asiainfo.foundation.exception.BusinessException.getMessage(BusinessException.java:151)
//		//       at com.asiainfo.foundation.exception.BusinessException.<init>(BusinessException.java:105)
//		//       at com.ailk.eaap.integration.o2p.transformer.AbstractTransformer.transform(AbstractTransformer.java:169)
//		assertNotNull(result);
//	}
//
//	/**
//	 * Run the MessageBO<Object> transform(MessageBO) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:41
//	 */
//	@Test
//	public void testTransform_2()
//		throws Exception {
//		AbstractTransformer fixture = new Byte2StringTransformer();
//		MessageBO message = new MessageBO();
//
//		MessageBO<Object> result = fixture.transform(message);
//
//		// add additional test code here
//		// An unexpected exception was thrown in user code while executing this test:
//		//    org.springframework.context.NoSuchMessageException: No message found under code 'o2p.serviceAgent.transformer.abstractTransformer' for locale 'zh_CN'.
//		//       at org.springframework.context.support.AbstractMessageSource.getMessage(AbstractMessageSource.java:159)
//		//       at com.asiainfo.foundation.util.MessageSourceUtils.getMessage(MessageSourceUtils.java:41)
//		//       at com.asiainfo.foundation.exception.BusinessException.getMessage(BusinessException.java:151)
//		//       at com.asiainfo.foundation.exception.BusinessException.<init>(BusinessException.java:105)
//		//       at com.ailk.eaap.integration.o2p.transformer.AbstractTransformer.transform(AbstractTransformer.java:169)
//		assertNotNull(result);
//	}
//
//	/**
//	 * Run the MessageBO<Object> transform(MessageBO) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:41
//	 */
//	@Test
//	public void testTransform_3()
//		throws Exception {
//		AbstractTransformer fixture = new Byte2StringTransformer();
//		MessageBO message = new MessageBO();
//
//		MessageBO<Object> result = fixture.transform(message);
//
//		// add additional test code here
//		// An unexpected exception was thrown in user code while executing this test:
//		//    org.springframework.context.NoSuchMessageException: No message found under code 'o2p.serviceAgent.transformer.abstractTransformer' for locale 'zh_CN'.
//		//       at org.springframework.context.support.AbstractMessageSource.getMessage(AbstractMessageSource.java:159)
//		//       at com.asiainfo.foundation.util.MessageSourceUtils.getMessage(MessageSourceUtils.java:41)
//		//       at com.asiainfo.foundation.exception.BusinessException.getMessage(BusinessException.java:151)
//		//       at com.asiainfo.foundation.exception.BusinessException.<init>(BusinessException.java:105)
//		//       at com.ailk.eaap.integration.o2p.transformer.AbstractTransformer.transform(AbstractTransformer.java:169)
//		assertNotNull(result);
//	}
//
//	/**
//	 * Run the MessageBO<Object> transform(MessageBO) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:41
//	 */
//	@Test
//	public void testTransform_4()
//		throws Exception {
//		AbstractTransformer fixture = new Byte2StringTransformer();
//		MessageBO message = new MessageBO();
//
//		MessageBO<Object> result = fixture.transform(message);
//
//		// add additional test code here
//		// An unexpected exception was thrown in user code while executing this test:
//		//    org.springframework.context.NoSuchMessageException: No message found under code 'o2p.serviceAgent.transformer.abstractTransformer' for locale 'zh_CN'.
//		//       at org.springframework.context.support.AbstractMessageSource.getMessage(AbstractMessageSource.java:159)
//		//       at com.asiainfo.foundation.util.MessageSourceUtils.getMessage(MessageSourceUtils.java:41)
//		//       at com.asiainfo.foundation.exception.BusinessException.getMessage(BusinessException.java:151)
//		//       at com.asiainfo.foundation.exception.BusinessException.<init>(BusinessException.java:105)
//		//       at com.ailk.eaap.integration.o2p.transformer.AbstractTransformer.transform(AbstractTransformer.java:169)
//		assertNotNull(result);
//	}
//
//	/**
//	 * Run the MessageBO<Object> transform(MessageBO) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:41
//	 */
//	@Test
//	public void testTransform_5()
//		throws Exception {
//		AbstractTransformer fixture = new Byte2StringTransformer();
//		MessageBO message = new FileMessageBO();
//
//		MessageBO<Object> result = fixture.transform(message);
//
//		// add additional test code here
//		// An unexpected exception was thrown in user code while executing this test:
//		//    org.springframework.context.NoSuchMessageException: No message found under code 'o2p.serviceAgent.transformer.abstractTransformer' for locale 'zh_CN'.
//		//       at org.springframework.context.support.AbstractMessageSource.getMessage(AbstractMessageSource.java:159)
//		//       at com.asiainfo.foundation.util.MessageSourceUtils.getMessage(MessageSourceUtils.java:41)
//		//       at com.asiainfo.foundation.exception.BusinessException.getMessage(BusinessException.java:151)
//		//       at com.asiainfo.foundation.exception.BusinessException.<init>(BusinessException.java:105)
//		//       at com.ailk.eaap.integration.o2p.transformer.AbstractTransformer.transform(AbstractTransformer.java:169)
//		assertNotNull(result);
//	}
//
//	/**
//	 * Run the MessageBO<Object> transform(MessageBO) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:41
//	 */
//	@Test
//	public void testTransform_6()
//		throws Exception {
//		AbstractTransformer fixture = new Byte2StringTransformer();
//		MessageBO message = new MessageBO();
//
//		MessageBO<Object> result = fixture.transform(message);
//
//		// add additional test code here
//		// An unexpected exception was thrown in user code while executing this test:
//		//    org.springframework.context.NoSuchMessageException: No message found under code 'o2p.serviceAgent.transformer.abstractTransformer' for locale 'zh_CN'.
//		//       at org.springframework.context.support.AbstractMessageSource.getMessage(AbstractMessageSource.java:159)
//		//       at com.asiainfo.foundation.util.MessageSourceUtils.getMessage(MessageSourceUtils.java:41)
//		//       at com.asiainfo.foundation.exception.BusinessException.getMessage(BusinessException.java:151)
//		//       at com.asiainfo.foundation.exception.BusinessException.<init>(BusinessException.java:105)
//		//       at com.ailk.eaap.integration.o2p.transformer.AbstractTransformer.transform(AbstractTransformer.java:169)
//		assertNotNull(result);
//	}
//
//	/**
//	 * Run the MessageBO<Object> transform(MessageBO) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:41
//	 */
//	@Test
//	public void testTransform_7()
//		throws Exception {
//		AbstractTransformer fixture = new Byte2StringTransformer();
//		MessageBO message = new MessageBO();
//
//		MessageBO<Object> result = fixture.transform(message);
//
//		// add additional test code here
//		// An unexpected exception was thrown in user code while executing this test:
//		//    org.springframework.context.NoSuchMessageException: No message found under code 'o2p.serviceAgent.transformer.abstractTransformer' for locale 'zh_CN'.
//		//       at org.springframework.context.support.AbstractMessageSource.getMessage(AbstractMessageSource.java:159)
//		//       at com.asiainfo.foundation.util.MessageSourceUtils.getMessage(MessageSourceUtils.java:41)
//		//       at com.asiainfo.foundation.exception.BusinessException.getMessage(BusinessException.java:151)
//		//       at com.asiainfo.foundation.exception.BusinessException.<init>(BusinessException.java:105)
//		//       at com.ailk.eaap.integration.o2p.transformer.AbstractTransformer.transform(AbstractTransformer.java:169)
//		assertNotNull(result);
//	}
//
//	/**
//	 * Run the MessageBO<Object> transform(MessageBO) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:41
//	 */
//	@Test
//	public void testTransform_8()
//		throws Exception {
//		AbstractTransformer fixture = new Byte2StringTransformer();
//		MessageBO message = new MessageBO();
//
//		MessageBO<Object> result = fixture.transform(message);
//
//		// add additional test code here
//		// An unexpected exception was thrown in user code while executing this test:
//		//    org.springframework.context.NoSuchMessageException: No message found under code 'o2p.serviceAgent.transformer.abstractTransformer' for locale 'zh_CN'.
//		//       at org.springframework.context.support.AbstractMessageSource.getMessage(AbstractMessageSource.java:159)
//		//       at com.asiainfo.foundation.util.MessageSourceUtils.getMessage(MessageSourceUtils.java:41)
//		//       at com.asiainfo.foundation.exception.BusinessException.getMessage(BusinessException.java:151)
//		//       at com.asiainfo.foundation.exception.BusinessException.<init>(BusinessException.java:105)
//		//       at com.ailk.eaap.integration.o2p.transformer.AbstractTransformer.transform(AbstractTransformer.java:169)
//		assertNotNull(result);
//	}
//
//	/**
//	 * Run the MessageBO<Object> transform(MessageBO) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:41
//	 */
//	@Test
//	public void testTransform_9()
//		throws Exception {
//		AbstractTransformer fixture = new Byte2StringTransformer();
//		MessageBO message = new MessageBO();
//
//		MessageBO<Object> result = fixture.transform(message);
//
//		// add additional test code here
//		// An unexpected exception was thrown in user code while executing this test:
//		//    org.springframework.context.NoSuchMessageException: No message found under code 'o2p.serviceAgent.transformer.abstractTransformer' for locale 'zh_CN'.
//		//       at org.springframework.context.support.AbstractMessageSource.getMessage(AbstractMessageSource.java:159)
//		//       at com.asiainfo.foundation.util.MessageSourceUtils.getMessage(MessageSourceUtils.java:41)
//		//       at com.asiainfo.foundation.exception.BusinessException.getMessage(BusinessException.java:151)
//		//       at com.asiainfo.foundation.exception.BusinessException.<init>(BusinessException.java:105)
//		//       at com.ailk.eaap.integration.o2p.transformer.AbstractTransformer.transform(AbstractTransformer.java:169)
//		assertNotNull(result);
//	}
//
//	/**
//	 * Run the MessageBO<Object> transform(MessageBO,TransformerRule) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:41
//	 */
//	@Test
//	public void testTransform_10()
//		throws Exception {
//		AbstractTransformer fixture = new Byte2StringTransformer();
//		MessageBO message = new MessageBO();
//		TransformerRule _transformerRule = new TransformerRule();
//
//		MessageBO<Object> result = fixture.transform(message, _transformerRule);
//
//		// add additional test code here
//		// An unexpected exception was thrown in user code while executing this test:
//		//    org.springframework.context.NoSuchMessageException: No message found under code 'o2p.serviceAgent.transformer.abstractTransformer' for locale 'zh_CN'.
//		//       at org.springframework.context.support.AbstractMessageSource.getMessage(AbstractMessageSource.java:159)
//		//       at com.asiainfo.foundation.util.MessageSourceUtils.getMessage(MessageSourceUtils.java:41)
//		//       at com.asiainfo.foundation.exception.BusinessException.getMessage(BusinessException.java:151)
//		//       at com.asiainfo.foundation.exception.BusinessException.<init>(BusinessException.java:105)
//		//       at com.ailk.eaap.integration.o2p.transformer.AbstractTransformer.transform(AbstractTransformer.java:107)
//		assertNotNull(result);
//	}
//
//	/**
//	 * Run the MessageBO<Object> transform(MessageBO,TransformerRule) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:41
//	 */
//	@Test
//	public void testTransform_11()
//		throws Exception {
//		AbstractTransformer fixture = new Byte2StringTransformer();
//		MessageBO message = new MessageBO();
//		TransformerRule _transformerRule = new TransformerRule();
//
//		MessageBO<Object> result = fixture.transform(message, _transformerRule);
//
//		// add additional test code here
//		// An unexpected exception was thrown in user code while executing this test:
//		//    org.springframework.context.NoSuchMessageException: No message found under code 'o2p.serviceAgent.transformer.abstractTransformer' for locale 'zh_CN'.
//		//       at org.springframework.context.support.AbstractMessageSource.getMessage(AbstractMessageSource.java:159)
//		//       at com.asiainfo.foundation.util.MessageSourceUtils.getMessage(MessageSourceUtils.java:41)
//		//       at com.asiainfo.foundation.exception.BusinessException.getMessage(BusinessException.java:151)
//		//       at com.asiainfo.foundation.exception.BusinessException.<init>(BusinessException.java:105)
//		//       at com.ailk.eaap.integration.o2p.transformer.AbstractTransformer.transform(AbstractTransformer.java:107)
//		assertNotNull(result);
//	}
//
//	/**
//	 * Run the MessageBO<Object> transform(MessageBO,TransformerRule) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:41
//	 */
//	@Test
//	public void testTransform_12()
//		throws Exception {
//		AbstractTransformer fixture = new Byte2StringTransformer();
//		MessageBO message = new MessageBO();
//		TransformerRule _transformerRule = new TransformerRule();
//
//		MessageBO<Object> result = fixture.transform(message, _transformerRule);
//
//		// add additional test code here
//		// An unexpected exception was thrown in user code while executing this test:
//		//    org.springframework.context.NoSuchMessageException: No message found under code 'o2p.serviceAgent.transformer.abstractTransformer' for locale 'zh_CN'.
//		//       at org.springframework.context.support.AbstractMessageSource.getMessage(AbstractMessageSource.java:159)
//		//       at com.asiainfo.foundation.util.MessageSourceUtils.getMessage(MessageSourceUtils.java:41)
//		//       at com.asiainfo.foundation.exception.BusinessException.getMessage(BusinessException.java:151)
//		//       at com.asiainfo.foundation.exception.BusinessException.<init>(BusinessException.java:105)
//		//       at com.ailk.eaap.integration.o2p.transformer.AbstractTransformer.transform(AbstractTransformer.java:107)
//		assertNotNull(result);
//	}
//
//	/**
//	 * Run the MessageBO<Object> transform(MessageBO,TransformerRule) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:41
//	 */
//	@Test
//	public void testTransform_13()
//		throws Exception {
//		AbstractTransformer fixture = new Byte2StringTransformer();
//		MessageBO message = new MessageBO();
//		TransformerRule _transformerRule = new TransformerRule();
//
//		MessageBO<Object> result = fixture.transform(message, _transformerRule);
//
//		// add additional test code here
//		// An unexpected exception was thrown in user code while executing this test:
//		//    org.springframework.context.NoSuchMessageException: No message found under code 'o2p.serviceAgent.transformer.abstractTransformer' for locale 'zh_CN'.
//		//       at org.springframework.context.support.AbstractMessageSource.getMessage(AbstractMessageSource.java:159)
//		//       at com.asiainfo.foundation.util.MessageSourceUtils.getMessage(MessageSourceUtils.java:41)
//		//       at com.asiainfo.foundation.exception.BusinessException.getMessage(BusinessException.java:151)
//		//       at com.asiainfo.foundation.exception.BusinessException.<init>(BusinessException.java:105)
//		//       at com.ailk.eaap.integration.o2p.transformer.AbstractTransformer.transform(AbstractTransformer.java:107)
//		assertNotNull(result);
//	}
//
//	/**
//	 * Run the MessageBO<Object> transform(MessageBO,TransformerRule) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:41
//	 */
//	@Test
//	public void testTransform_14()
//		throws Exception {
//		AbstractTransformer fixture = new Byte2StringTransformer();
//		MessageBO message = new FileMessageBO();
//		TransformerRule _transformerRule = new TransformerRule();
//
//		MessageBO<Object> result = fixture.transform(message, _transformerRule);
//
//		// add additional test code here
//		// An unexpected exception was thrown in user code while executing this test:
//		//    org.springframework.context.NoSuchMessageException: No message found under code 'o2p.serviceAgent.transformer.abstractTransformer' for locale 'zh_CN'.
//		//       at org.springframework.context.support.AbstractMessageSource.getMessage(AbstractMessageSource.java:159)
//		//       at com.asiainfo.foundation.util.MessageSourceUtils.getMessage(MessageSourceUtils.java:41)
//		//       at com.asiainfo.foundation.exception.BusinessException.getMessage(BusinessException.java:151)
//		//       at com.asiainfo.foundation.exception.BusinessException.<init>(BusinessException.java:105)
//		//       at com.ailk.eaap.integration.o2p.transformer.AbstractTransformer.transform(AbstractTransformer.java:107)
//		assertNotNull(result);
//	}
//
//	/**
//	 * Run the MessageBO<Object> transform(MessageBO,TransformerRule) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:41
//	 */
//	@Test
//	public void testTransform_15()
//		throws Exception {
//		AbstractTransformer fixture = new Byte2StringTransformer();
//		MessageBO message = new MessageBO();
//		TransformerRule _transformerRule = new TransformerRule();
//
//		MessageBO<Object> result = fixture.transform(message, _transformerRule);
//
//		// add additional test code here
//		// An unexpected exception was thrown in user code while executing this test:
//		//    org.springframework.context.NoSuchMessageException: No message found under code 'o2p.serviceAgent.transformer.abstractTransformer' for locale 'zh_CN'.
//		//       at org.springframework.context.support.AbstractMessageSource.getMessage(AbstractMessageSource.java:159)
//		//       at com.asiainfo.foundation.util.MessageSourceUtils.getMessage(MessageSourceUtils.java:41)
//		//       at com.asiainfo.foundation.exception.BusinessException.getMessage(BusinessException.java:151)
//		//       at com.asiainfo.foundation.exception.BusinessException.<init>(BusinessException.java:105)
//		//       at com.ailk.eaap.integration.o2p.transformer.AbstractTransformer.transform(AbstractTransformer.java:107)
//		assertNotNull(result);
//	}
//
//	/**
//	 * Run the MessageBO<Object> transform(MessageBO,TransformerRule) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:41
//	 */
//	@Test
//	public void testTransform_16()
//		throws Exception {
//		AbstractTransformer fixture = new Byte2StringTransformer();
//		MessageBO message = new MessageBO();
//		TransformerRule _transformerRule = new TransformerRule();
//
//		MessageBO<Object> result = fixture.transform(message, _transformerRule);
//
//		// add additional test code here
//		// An unexpected exception was thrown in user code while executing this test:
//		//    org.springframework.context.NoSuchMessageException: No message found under code 'o2p.serviceAgent.transformer.abstractTransformer' for locale 'zh_CN'.
//		//       at org.springframework.context.support.AbstractMessageSource.getMessage(AbstractMessageSource.java:159)
//		//       at com.asiainfo.foundation.util.MessageSourceUtils.getMessage(MessageSourceUtils.java:41)
//		//       at com.asiainfo.foundation.exception.BusinessException.getMessage(BusinessException.java:151)
//		//       at com.asiainfo.foundation.exception.BusinessException.<init>(BusinessException.java:105)
//		//       at com.ailk.eaap.integration.o2p.transformer.AbstractTransformer.transform(AbstractTransformer.java:107)
//		assertNotNull(result);
//	}
//
//	/**
//	 * Run the MessageBO<Object> transform(MessageBO,TransformerRule) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:41
//	 */
//	@Test
//	public void testTransform_17()
//		throws Exception {
//		AbstractTransformer fixture = new Byte2StringTransformer();
//		MessageBO message = new MessageBO();
//		TransformerRule _transformerRule = new TransformerRule();
//
//		MessageBO<Object> result = fixture.transform(message, _transformerRule);
//
//		// add additional test code here
//		// An unexpected exception was thrown in user code while executing this test:
//		//    org.springframework.context.NoSuchMessageException: No message found under code 'o2p.serviceAgent.transformer.abstractTransformer' for locale 'zh_CN'.
//		//       at org.springframework.context.support.AbstractMessageSource.getMessage(AbstractMessageSource.java:159)
//		//       at com.asiainfo.foundation.util.MessageSourceUtils.getMessage(MessageSourceUtils.java:41)
//		//       at com.asiainfo.foundation.exception.BusinessException.getMessage(BusinessException.java:151)
//		//       at com.asiainfo.foundation.exception.BusinessException.<init>(BusinessException.java:105)
//		//       at com.ailk.eaap.integration.o2p.transformer.AbstractTransformer.transform(AbstractTransformer.java:107)
//		assertNotNull(result);
//	}
//
//	/**
//	 * Run the MessageBO<Object> transform(MessageBO,TransformerRule) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:41
//	 */
//	@Test
//	public void testTransform_18()
//		throws Exception {
//		AbstractTransformer fixture = new Byte2StringTransformer();
//		MessageBO message = new MessageBO();
//		TransformerRule _transformerRule = new TransformerRule();
//
//		MessageBO<Object> result = fixture.transform(message, _transformerRule);
//
//		// add additional test code here
//		// An unexpected exception was thrown in user code while executing this test:
//		//    org.springframework.context.NoSuchMessageException: No message found under code 'o2p.serviceAgent.transformer.abstractTransformer' for locale 'zh_CN'.
//		//       at org.springframework.context.support.AbstractMessageSource.getMessage(AbstractMessageSource.java:159)
//		//       at com.asiainfo.foundation.util.MessageSourceUtils.getMessage(MessageSourceUtils.java:41)
//		//       at com.asiainfo.foundation.exception.BusinessException.getMessage(BusinessException.java:151)
//		//       at com.asiainfo.foundation.exception.BusinessException.<init>(BusinessException.java:105)
//		//       at com.ailk.eaap.integration.o2p.transformer.AbstractTransformer.transform(AbstractTransformer.java:107)
//		assertNotNull(result);
//	}
//
//	/**
//	 * Perform pre-test initialization.
//	 *
//	 * @throws Exception
//	 *         if the initialization fails for some reason
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:41
//	 */
//	@Before
//	public void setUp()
//		throws Exception {
//		// add additional set up code here
//	}
//
//	/**
//	 * Perform post-test clean-up.
//	 *
//	 * @throws Exception
//	 *         if the clean-up fails for some reason
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:41
//	 */
//	@After
//	public void tearDown()
//		throws Exception {
//		// Add additional tear down code here
//	}
//
//	/**
//	 * Launch the test.
//	 *
//	 * @param args the command line arguments
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:41
//	 */
//	public static void main(String[] args) {
//		new org.junit.runner.JUnitCore().run(AbstractTransformerTest.class);
//	}
//}