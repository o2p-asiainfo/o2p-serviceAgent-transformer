//package com.ailk.eaap.integration.o2p.message;
//
//import org.junit.*;
//import static org.junit.Assert.*;
//import com.ailk.eaap.op2.serviceagent.common.MessageBO;
//
///**
// * The class <code>MessagingExceptionTest</code> contains tests for the class <code>{@link MessagingException}</code>.
// *
// * @generatedBy CodePro at 15-12-16 下午2:33
// * @author wuwz
// * @version $Revision: 1.0 $
// */
//public class MessagingExceptionTest {
//	/**
//	 * Run the MessagingException(MessageBO<?>) constructor test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:33
//	 */
//	@Test
//	public void testMessagingException_1()
//		throws Exception {
//		MessageBO<Object> message = new MessageBO();
//
//		MessagingException result = new MessagingException(message);
//
//		// add additional test code here
//		assertNotNull(result);
//		assertEquals(null, result.getCause());
//		assertEquals("com.ailk.eaap.integration.o2p.message.MessagingException", result.toString());
//		assertEquals(null, result.getMessage());
//		assertEquals(null, result.getLocalizedMessage());
//	}
//
//	/**
//	 * Run the MessagingException(String) constructor test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:33
//	 */
//	@Test
//	public void testMessagingException_2()
//		throws Exception {
//		String description = "";
//
//		MessagingException result = new MessagingException(description);
//
//		// add additional test code here
//		assertNotNull(result);
//		assertEquals(null, result.getFailedMessage());
//		assertEquals(null, result.getCause());
//		assertEquals("com.ailk.eaap.integration.o2p.message.MessagingException: ", result.toString());
//		assertEquals("", result.getMessage());
//		assertEquals("", result.getLocalizedMessage());
//	}
//
//	/**
//	 * Run the MessagingException(MessageBO<?>,String) constructor test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:33
//	 */
//	@Test
//	public void testMessagingException_3()
//		throws Exception {
//		MessageBO<Object> message = new MessageBO();
//		String description = "";
//
//		MessagingException result = new MessagingException(message, description);
//
//		// add additional test code here
//		assertNotNull(result);
//		assertEquals(null, result.getCause());
//		assertEquals("com.ailk.eaap.integration.o2p.message.MessagingException: ", result.toString());
//		assertEquals("", result.getMessage());
//		assertEquals("", result.getLocalizedMessage());
//	}
//
//	/**
//	 * Run the MessagingException(String,Throwable) constructor test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:33
//	 */
//	@Test
//	public void testMessagingException_4()
//		throws Exception {
//		String description = "";
//		Throwable cause = new Throwable();
//
//		MessagingException result = new MessagingException(description, cause);
//
//		// add additional test code here
//		assertNotNull(result);
//		assertEquals(null, result.getFailedMessage());
//		assertEquals("com.ailk.eaap.integration.o2p.message.MessagingException: ", result.toString());
//		assertEquals("", result.getMessage());
//		assertEquals("", result.getLocalizedMessage());
//	}
//
//	/**
//	 * Run the MessagingException(MessageBO<?>,int,String) constructor test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:33
//	 */
//	@Test
//	public void testMessagingException_5()
//		throws Exception {
//		MessageBO<Object> message = new MessageBO();
//		int code = 1;
//		String description = "";
//
//		MessagingException result = new MessagingException(message, code, description);
//
//		// add additional test code here
//		assertNotNull(result);
//		assertEquals(null, result.getCause());
//		assertEquals("com.ailk.eaap.integration.o2p.message.MessagingException: ", result.toString());
//		assertEquals("", result.getMessage());
//		assertEquals("", result.getLocalizedMessage());
//	}
//
//	/**
//	 * Run the MessagingException(MessageBO<?>,String,Throwable) constructor test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:33
//	 */
//	@Test
//	public void testMessagingException_6()
//		throws Exception {
//		MessageBO<Object> message = new MessageBO();
//		String description = "";
//		Throwable cause = new Throwable();
//
//		MessagingException result = new MessagingException(message, description, cause);
//
//		// add additional test code here
//		assertNotNull(result);
//		assertEquals("com.ailk.eaap.integration.o2p.message.MessagingException: ", result.toString());
//		assertEquals("", result.getMessage());
//		assertEquals("", result.getLocalizedMessage());
//	}
//
//	/**
//	 * Run the MessageBO<Object> getFailedMessage() method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:33
//	 */
//	@Test
//	public void testGetFailedMessage_1()
//		throws Exception {
//		MessagingException fixture = new MessagingException(new MessageBO(), 1, "");
//
//		MessageBO<Object> result = fixture.getFailedMessage();
//
//		// add additional test code here
//		assertNotNull(result);
//		assertEquals("", result.toString());
//		assertEquals(null, result.getService());
//		assertEquals(null, result.getFormat());
//		assertEquals(null, result.getScopeId());
//		assertEquals(null, result.getExecutionContext());
//		assertEquals(null, result.getSign());
//		assertEquals(null, result.getServiceLevel());
//		assertEquals(null, result.getHttpMethod());
//		assertEquals("XML", result.getDataType());
//		assertEquals(null, result.getTransactionID());
//		assertEquals(null, result.getReqTime());
//		assertEquals(null, result.getSourceCode());
//		assertEquals(false, result.isNeedBreak());
//		assertEquals(null, result.getServiceAgentMode());
//		assertEquals(null, result.getAuthCode());
//		assertEquals(null, result.getServiceAgentServerAddress());
//		assertEquals(null, result.getReqorrsp());
//		assertEquals(null, result.getRegServiceCode());
//		assertEquals(null, result.getAccessToken());
//		assertEquals(null, result.getSrcPlayload());
//		assertEquals(null, result.getRegServiceVersion());
//		assertEquals(null, result.getActionCode());
//		assertEquals(null, result.getSrcorgcode());
//		assertEquals(null, result.getRestFormString());
//		assertEquals(null, result.getBusCode());
//		assertEquals(null, result.getMsgBody());
//		assertEquals(null, result.getEAAPException());
//		assertEquals(null, result.getDstSyscode());
//		assertEquals(null, result.getContractVer());
//		assertEquals(null, result.getSrcsyscode());
//		assertEquals(null, result.getSrcComponent());
//		assertEquals(null, result.getDstComponent());
//		assertEquals(null, result.getIp());
//		assertEquals(null, result.getApiname());
//		assertEquals(null, result.getInType());
//		assertEquals(null, result.getDstOrgID());
//		assertEquals(null, result.getContractVersion());
//		assertEquals(null, result.getSerInvokeIns());
//		assertEquals(null, result.getDefaultTime());
//		assertEquals(null, result.getSrcReqTime());
//		assertEquals(null, result.getApp());
//		assertEquals(null, result.getAppKey());
//		assertEquals(null, result.getRestReqTime());
//		assertEquals(null, result.getServiceCode());
//		assertEquals(null, result.getCurrryRouteEndpoint());
//		assertEquals(null, result.getRspType());
//		assertEquals(null, result.getExceptionCode());
//		assertEquals("", result.getOrgReqMsg());
//		assertEquals("\r\n", result.toAllString());
//		assertEquals(null, result.getRequestURL());
//		assertEquals(new Integer(0), result.getFailNum());
//		assertEquals(null, result.getContractBody());
//		assertEquals("R", result.getRemoteFlag());
//		assertEquals(null, result.getTempFileDirName());
//		assertEquals(new Integer(1), result.getExceptionTryNum());
//		assertEquals(false, result.isTaskFlag());
//		assertEquals(null, result.getTaskCacheFlag());
//		assertEquals(null, result.getTaskStyle());
//		assertEquals(null, result.getRealIpAddress());
//		assertEquals(null, result.getResponseDes());
//		assertEquals(null, result.getEndPointSpec());
//		assertEquals(null, result.getFailMsg());
//		assertEquals(new Integer(0), result.getSuccessNum());
//		assertEquals(new Integer(0), result.getInputFileNum());
//		assertEquals(new Integer(0), result.getOutputSuccessFileNum());
//		assertEquals(new Integer(0), result.getOutputErrFileNum());
//		assertEquals(null, result.getDstTranId());
//		assertEquals(null, result.getRspTime());
//		assertEquals(null, result.getServiceStyle());
//		assertEquals(null, result.getQueueName());
//	}
//
//	/**
//	 * Run the void setFailedMessage(MessageBO<?>) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:33
//	 */
//	@Test
//	public void testSetFailedMessage_1()
//		throws Exception {
//		MessagingException fixture = new MessagingException(new MessageBO(), 1, "");
//		MessageBO<Object> message = new MessageBO();
//
//		fixture.setFailedMessage(message);
//
//		// add additional test code here
//	}
//
//	/**
//	 * Perform pre-test initialization.
//	 *
//	 * @throws Exception
//	 *         if the initialization fails for some reason
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:33
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
//	 * @generatedBy CodePro at 15-12-16 下午2:33
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
//	 * @generatedBy CodePro at 15-12-16 下午2:33
//	 */
//	public static void main(String[] args) {
//		new org.junit.runner.JUnitCore().run(MessagingExceptionTest.class);
//	}
//}