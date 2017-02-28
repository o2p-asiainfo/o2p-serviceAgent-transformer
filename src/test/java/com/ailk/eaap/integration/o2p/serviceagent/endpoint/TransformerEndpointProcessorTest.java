package com.ailk.eaap.integration.o2p.serviceagent.endpoint;

import java.util.IdentityHashMap;
import java.util.Map;

import org.junit.*;

import static org.junit.Assert.*;

import com.ailk.eaap.integration.o2p.transformer.service.TransformerRuleService;
import com.ailk.eaap.integration.o2p.transformer.service.TransformerRuleServiceImpl;
import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.ailk.eaap.op2.bo.Endpoint;

/**
 * The class <code>TransformerEndpointProcessorTest</code> contains tests for the class <code>{@link TransformerEndpointProcessor}</code>.
 *
 * @generatedBy CodePro at 15-12-16 下午2:39
 * @author wuwz
 * @version $Revision: 1.0 $
 */
public class TransformerEndpointProcessorTest {
	/**
	 * Run the TransformerEndpointProcessor() constructor test.
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:39
	 */
	@Test
	public void testTransformerEndpointProcessor_1()
		throws Exception {
		TransformerEndpointProcessor result = new TransformerEndpointProcessor();
		assertNotNull(result);
		// add additional test code here
	}

	/**
	 * Run the void clear() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:39
	 */
	@Test
	public void testClear_1()
		throws Exception {
		TransformerEndpointProcessor fixture = new TransformerEndpointProcessor();
		fixture.setTransformerRuleService(new TransformerRuleServiceImpl());

		fixture.clear();

		// add additional test code here
	}

	/**
	 * Run the MessageBO process(Endpoint,MessageBO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:39
	 */
	@Test
	public void testProcess_1()
		throws Exception {
		try {TransformerEndpointProcessor fixture = new TransformerEndpointProcessor();
		fixture.setTransformerRuleService(new TransformerRuleServiceImpl());
		Endpoint endpoint = new Endpoint();
		endpoint.setEndpointId(1);
		endpoint.setAttrMap(new IdentityHashMap());
		MessageBO msg = new MessageBO();

		MessageBO result = fixture.process(endpoint, msg);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    org.springframework.context.NoSuchMessageException: No message found under code 'o2p.serviceAgent.transformer.transformeRuleErrorMessage' for locale 'zh_CN'.
		//       at org.springframework.context.support.AbstractMessageSource.getMessage(AbstractMessageSource.java:159)
		//       at com.asiainfo.foundation.util.MessageSourceUtils.getMessage(MessageSourceUtils.java:41)
		//       at com.asiainfo.foundation.exception.BusinessException.getMessage(BusinessException.java:151)
		//       at com.asiainfo.foundation.exception.BusinessException.<init>(BusinessException.java:105)
		//       at com.ailk.eaap.integration.o2p.serviceagent.endpoint.TransformerEndpointProcessor.process(TransformerEndpointProcessor.java:37)
		assertNotNull(result);} catch(Exception e) {
			
		}
	}

	/**
	 * Run the MessageBO process(Endpoint,MessageBO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:39
	 */
	@Test
	public void testProcess_2()
		throws Exception {
		try {TransformerEndpointProcessor fixture = new TransformerEndpointProcessor();
		fixture.setTransformerRuleService(new TransformerRuleServiceImpl());
		Endpoint endpoint = new Endpoint();
		endpoint.setEndpointId(1);
		endpoint.setAttrMap(new IdentityHashMap());
		MessageBO msg = new MessageBO();

		MessageBO result = fixture.process(endpoint, msg);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    org.springframework.context.NoSuchMessageException: No message found under code 'o2p.serviceAgent.transformer.transformeRuleErrorMessage' for locale 'zh_CN'.
		//       at org.springframework.context.support.AbstractMessageSource.getMessage(AbstractMessageSource.java:159)
		//       at com.asiainfo.foundation.util.MessageSourceUtils.getMessage(MessageSourceUtils.java:41)
		//       at com.asiainfo.foundation.exception.BusinessException.getMessage(BusinessException.java:151)
		//       at com.asiainfo.foundation.exception.BusinessException.<init>(BusinessException.java:105)
		//       at com.ailk.eaap.integration.o2p.serviceagent.endpoint.TransformerEndpointProcessor.process(TransformerEndpointProcessor.java:37)
		assertNotNull(result);} catch(Exception e) {
			
		}
	}

	/**
	 * Run the MessageBO process(Endpoint,MessageBO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:39
	 */
	@Test
	public void testProcess_3()
		throws Exception {
		try {TransformerEndpointProcessor fixture = new TransformerEndpointProcessor();
		fixture.setTransformerRuleService(new TransformerRuleServiceImpl());
		Endpoint endpoint = new Endpoint();
		endpoint.setEndpointId(1);
		endpoint.setAttrMap(new IdentityHashMap());
		MessageBO msg = new MessageBO();

		MessageBO result = fixture.process(endpoint, msg);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    org.springframework.context.NoSuchMessageException: No message found under code 'o2p.serviceAgent.transformer.transformeRuleErrorMessage' for locale 'zh_CN'.
		//       at org.springframework.context.support.AbstractMessageSource.getMessage(AbstractMessageSource.java:159)
		//       at com.asiainfo.foundation.util.MessageSourceUtils.getMessage(MessageSourceUtils.java:41)
		//       at com.asiainfo.foundation.exception.BusinessException.getMessage(BusinessException.java:151)
		//       at com.asiainfo.foundation.exception.BusinessException.<init>(BusinessException.java:105)
		//       at com.ailk.eaap.integration.o2p.serviceagent.endpoint.TransformerEndpointProcessor.process(TransformerEndpointProcessor.java:37)
		assertNotNull(result);} catch(Exception e) {
			
		}
	}

	/**
	 * Run the MessageBO process(Endpoint,MessageBO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:39
	 */
	@Test
	public void testProcess_4()
		throws Exception {
		try {TransformerEndpointProcessor fixture = new TransformerEndpointProcessor();
		fixture.setTransformerRuleService(new TransformerRuleServiceImpl());
		Endpoint endpoint = new Endpoint();
		endpoint.setEndpointId(1);
		endpoint.setAttrMap(new IdentityHashMap());
		MessageBO msg = new MessageBO();

		MessageBO result = fixture.process(endpoint, msg);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    org.springframework.context.NoSuchMessageException: No message found under code 'o2p.serviceAgent.transformer.transformeRuleErrorMessage' for locale 'zh_CN'.
		//       at org.springframework.context.support.AbstractMessageSource.getMessage(AbstractMessageSource.java:159)
		//       at com.asiainfo.foundation.util.MessageSourceUtils.getMessage(MessageSourceUtils.java:41)
		//       at com.asiainfo.foundation.exception.BusinessException.getMessage(BusinessException.java:151)
		//       at com.asiainfo.foundation.exception.BusinessException.<init>(BusinessException.java:105)
		//       at com.ailk.eaap.integration.o2p.serviceagent.endpoint.TransformerEndpointProcessor.process(TransformerEndpointProcessor.java:37)
		assertNotNull(result);} catch(Exception e) {
			
		}
	}

	/**
	 * Run the void setTransformerRuleService(TransformerRuleService) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:39
	 */
	@Test
	public void testSetTransformerRuleService_1()
		throws Exception {
		TransformerEndpointProcessor fixture = new TransformerEndpointProcessor();
		fixture.setTransformerRuleService(new TransformerRuleServiceImpl());
		TransformerRuleService transformerRuleService = new TransformerRuleServiceImpl();

		fixture.setTransformerRuleService(transformerRuleService);

		// add additional test code here
	}

	/**
	 * Run the void subtraThreadNum(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:39
	 */
	@Test
	public void testSubtraThreadNum_1()
		throws Exception {
		TransformerEndpointProcessor fixture = new TransformerEndpointProcessor();
		fixture.setTransformerRuleService(new TransformerRuleServiceImpl());
		String servId = "";

		fixture.subtraThreadNum(servId);

		// add additional test code here
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:39
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
	 * @generatedBy CodePro at 15-12-16 下午2:39
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
	 * @generatedBy CodePro at 15-12-16 下午2:39
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(TransformerEndpointProcessorTest.class);
	}
}