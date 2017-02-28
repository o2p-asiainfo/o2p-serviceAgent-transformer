//package com.ailk.eaap.integration.o2p.process;
//
//import java.util.IdentityHashMap;
//import java.util.Map;
//import org.junit.*;
//import static org.junit.Assert.*;
//import com.ailk.eaap.op2.serviceagent.common.MessageBO;
//import com.ailk.eaap.op2.bo.ContractFormat;
//import com.ailk.eaap.op2.bo.MessageDesc;
//import com.ailk.eaap.op2.bo.NodeDesc;
//
///**
// * The class <code>JsonTransformerProcessInTest</code> contains tests for the class <code>{@link JsonTransformerProcessIn}</code>.
// *
// * @generatedBy CodePro at 15-12-16 下午2:38
// * @author wuwz
// * @version $Revision: 1.0 $
// */
//public class JsonTransformerProcessInTest {
//	/**
//	 * Run the JsonTransformerProcessIn() constructor test.
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:38
//	 */
//	@Test
//	public void testJsonTransformerProcessIn_1()
//		throws Exception {
//		JsonTransformerProcessIn result = new JsonTransformerProcessIn();
//		assertNotNull(result);
//		// add additional test code here
//	}
//
//	/**
//	 * Run the Object parseNodeValBySrcMsg(MessageBO<?>,ContractFormat,NodeDesc) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:38
//	 */
//	@Test
//	public void testParseNodeValBySrcMsg_1()
//		throws Exception {
//		JsonTransformerProcessIn fixture = new JsonTransformerProcessIn();
//		MessageBO<Object> srcMsg = new MessageBO();
//		ContractFormat contractFormat = new ContractFormat();
//		NodeDesc nodeDesc = new NodeDesc();
//
//		Object result = fixture.parseNodeValBySrcMsg(srcMsg, contractFormat, nodeDesc);
//
//		// add additional test code here
//		// An unexpected exception was thrown in user code while executing this test:
//		//    org.springframework.context.NoSuchMessageException: No message found under code 'o2p.serviceAgent.transformer.jsonPath' for locale 'zh_CN'.
//		//       at org.springframework.context.support.AbstractMessageSource.getMessage(AbstractMessageSource.java:159)
//		//       at com.asiainfo.foundation.util.MessageSourceUtils.getMessage(MessageSourceUtils.java:41)
//		//       at com.asiainfo.foundation.exception.BusinessException.getMessage(BusinessException.java:151)
//		//       at com.asiainfo.foundation.exception.BusinessException.<init>(BusinessException.java:105)
//		//       at com.ailk.eaap.integration.o2p.process.JsonTransformerProcessIn.parseNodeValBySrcMsg(JsonTransformerProcessIn.java:95)
//		assertNotNull(result);
//	}
//
//	/**
//	 * Run the Object parseNodeValBySrcMsg(MessageBO<?>,ContractFormat,NodeDesc) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:38
//	 */
//	@Test
//	public void testParseNodeValBySrcMsg_2()
//		throws Exception {
//		JsonTransformerProcessIn fixture = new JsonTransformerProcessIn();
//		MessageBO<Object> srcMsg = new MessageBO();
//		ContractFormat contractFormat = new ContractFormat();
//		NodeDesc nodeDesc = new NodeDesc();
//
//		Object result = fixture.parseNodeValBySrcMsg(srcMsg, contractFormat, nodeDesc);
//
//		// add additional test code here
//		// An unexpected exception was thrown in user code while executing this test:
//		//    org.springframework.context.NoSuchMessageException: No message found under code 'o2p.serviceAgent.transformer.jsonPath' for locale 'zh_CN'.
//		//       at org.springframework.context.support.AbstractMessageSource.getMessage(AbstractMessageSource.java:159)
//		//       at com.asiainfo.foundation.util.MessageSourceUtils.getMessage(MessageSourceUtils.java:41)
//		//       at com.asiainfo.foundation.exception.BusinessException.getMessage(BusinessException.java:151)
//		//       at com.asiainfo.foundation.exception.BusinessException.<init>(BusinessException.java:105)
//		//       at com.ailk.eaap.integration.o2p.process.JsonTransformerProcessIn.parseNodeValBySrcMsg(JsonTransformerProcessIn.java:95)
//		assertNotNull(result);
//	}
//
//	/**
//	 * Run the Object parseNodeValBySrcMsg(MessageBO<?>,ContractFormat,NodeDesc) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:38
//	 */
//	@Test
//	public void testParseNodeValBySrcMsg_3()
//		throws Exception {
//		JsonTransformerProcessIn fixture = new JsonTransformerProcessIn();
//		MessageBO<Object> srcMsg = new MessageBO();
//		ContractFormat contractFormat = new ContractFormat();
//		NodeDesc nodeDesc = null;
//
//		Object result = fixture.parseNodeValBySrcMsg(srcMsg, contractFormat, nodeDesc);
//
//		// add additional test code here
//		assertEquals(null, result);
//	}
//
//	/**
//	 * Run the MessageBO<Object> processContent(MessageDesc,MessageBO<?>) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:38
//	 */
//	@Test(expected = java.lang.NullPointerException.class)
//	public void testProcessContent_1()
//		throws Exception {
//		JsonTransformerProcessIn fixture = new JsonTransformerProcessIn();
//		MessageDesc md = new MessageDesc();
//		md.setHeaders(new IdentityHashMap());
//		MessageBO<Object> bo = new MessageBO();
//
//		MessageBO<Object> result = fixture.processContent(md, bo);
//
//		// add additional test code here
//		assertNotNull(result);
//	}
//
//	/**
//	 * Run the MessageBO<Object> processContent(MessageDesc,MessageBO<?>) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:38
//	 */
//	@Test(expected = java.lang.NullPointerException.class)
//	public void testProcessContent_2()
//		throws Exception {
//		JsonTransformerProcessIn fixture = new JsonTransformerProcessIn();
//		MessageDesc md = new MessageDesc();
//		md.setHeaders(new IdentityHashMap());
//		MessageBO<Object> bo = new MessageBO();
//
//		MessageBO<Object> result = fixture.processContent(md, bo);
//
//		// add additional test code here
//		assertNotNull(result);
//	}
//
//	/**
//	 * Run the MessageBO<Object> processContent(MessageDesc,MessageBO<?>) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:38
//	 */
//	@Test(expected = java.lang.NullPointerException.class)
//	public void testProcessContent_3()
//		throws Exception {
//		JsonTransformerProcessIn fixture = new JsonTransformerProcessIn();
//		MessageDesc md = new MessageDesc();
//		md.setHeaders(new IdentityHashMap());
//		MessageBO<Object> bo = new MessageBO();
//
//		MessageBO<Object> result = fixture.processContent(md, bo);
//
//		// add additional test code here
//		assertNotNull(result);
//	}
//
//	/**
//	 * Perform pre-test initialization.
//	 *
//	 * @throws Exception
//	 *         if the initialization fails for some reason
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:38
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
//	 * @generatedBy CodePro at 15-12-16 下午2:38
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
//	 * @generatedBy CodePro at 15-12-16 下午2:38
//	 */
//	public static void main(String[] args) {
//		new org.junit.runner.JUnitCore().run(JsonTransformerProcessInTest.class);
//	}
//}