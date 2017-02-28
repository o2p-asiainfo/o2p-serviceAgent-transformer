//package com.ailk.eaap.integration.o2p.process;
//
//import java.util.IdentityHashMap;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Map;
//import org.junit.*;
//import static org.junit.Assert.*;
//import com.ailk.eaap.op2.serviceagent.common.MessageBO;
//import com.ailk.eaap.op2.bo.ContractFormat;
//import com.ailk.eaap.op2.bo.MessageDesc;
//import com.ailk.eaap.op2.bo.MessageNode;
//import com.ailk.eaap.op2.bo.NodeDesc;
//
///**
// * The class <code>HttpMsgStyleUrlTransformerProcessInTest</code> contains tests for the class <code>{@link HttpMsgStyleUrlTransformerProcessIn}</code>.
// *
// * @generatedBy CodePro at 15-12-16 下午2:38
// * @author wuwz
// * @version $Revision: 1.0 $
// */
//public class HttpMsgStyleUrlTransformerProcessInTest {
//	/**
//	 * Run the HttpMsgStyleUrlTransformerProcessIn() constructor test.
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:38
//	 */
//	@Test
//	public void testHttpMsgStyleUrlTransformerProcessIn_1()
//		throws Exception {
//		HttpMsgStyleUrlTransformerProcessIn result = new HttpMsgStyleUrlTransformerProcessIn();
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
//		HttpMsgStyleUrlTransformerProcessIn fixture = new HttpMsgStyleUrlTransformerProcessIn();
//		MessageBO<Object> srcMsg = new MessageBO();
//		ContractFormat contractFormat = new ContractFormat();
//		NodeDesc nodeDesc = new NodeDesc();
//		nodeDesc.setNodeDescId(new Integer(1));
//
//		Object result = fixture.parseNodeValBySrcMsg(srcMsg, contractFormat, nodeDesc);
//
//		// add additional test code here
//		// An unexpected exception was thrown in user code while executing this test:
//		//    org.springframework.context.NoSuchMessageException: No message found under code 'o2p.serviceAgent.transformer.xmlPath' for locale 'zh_CN'.
//		//       at org.springframework.context.support.AbstractMessageSource.getMessage(AbstractMessageSource.java:159)
//		//       at com.asiainfo.foundation.util.MessageSourceUtils.getMessage(MessageSourceUtils.java:41)
//		//       at com.asiainfo.foundation.exception.BusinessException.getMessage(BusinessException.java:151)
//		//       at com.asiainfo.foundation.exception.BusinessException.<init>(BusinessException.java:105)
//		//       at com.ailk.eaap.integration.o2p.process.HttpMsgStyleUrlTransformerProcessIn.parseNodeValBySrcMsg(HttpMsgStyleUrlTransformerProcessIn.java:96)
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
//		HttpMsgStyleUrlTransformerProcessIn fixture = new HttpMsgStyleUrlTransformerProcessIn();
//		MessageBO<Object> srcMsg = new MessageBO();
//		ContractFormat contractFormat = new ContractFormat();
//		NodeDesc nodeDesc = new NodeDesc();
//		nodeDesc.setNodeDescId(new Integer(1));
//
//		Object result = fixture.parseNodeValBySrcMsg(srcMsg, contractFormat, nodeDesc);
//
//		// add additional test code here
//		// An unexpected exception was thrown in user code while executing this test:
//		//    org.springframework.context.NoSuchMessageException: No message found under code 'o2p.serviceAgent.transformer.xmlPath' for locale 'zh_CN'.
//		//       at org.springframework.context.support.AbstractMessageSource.getMessage(AbstractMessageSource.java:159)
//		//       at com.asiainfo.foundation.util.MessageSourceUtils.getMessage(MessageSourceUtils.java:41)
//		//       at com.asiainfo.foundation.exception.BusinessException.getMessage(BusinessException.java:151)
//		//       at com.asiainfo.foundation.exception.BusinessException.<init>(BusinessException.java:105)
//		//       at com.ailk.eaap.integration.o2p.process.HttpMsgStyleUrlTransformerProcessIn.parseNodeValBySrcMsg(HttpMsgStyleUrlTransformerProcessIn.java:96)
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
//		HttpMsgStyleUrlTransformerProcessIn fixture = new HttpMsgStyleUrlTransformerProcessIn();
//		MessageBO<Object> srcMsg = new MessageBO();
//		ContractFormat contractFormat = new ContractFormat();
//		NodeDesc nodeDesc = new NodeDesc();
//
//		Object result = fixture.parseNodeValBySrcMsg(srcMsg, contractFormat, nodeDesc);
//
//		// add additional test code here
//		// An unexpected exception was thrown in user code while executing this test:
//		//    org.springframework.context.NoSuchMessageException: No message found under code 'o2p.serviceAgent.transformer.xmlPath' for locale 'zh_CN'.
//		//       at org.springframework.context.support.AbstractMessageSource.getMessage(AbstractMessageSource.java:159)
//		//       at com.asiainfo.foundation.util.MessageSourceUtils.getMessage(MessageSourceUtils.java:41)
//		//       at com.asiainfo.foundation.exception.BusinessException.getMessage(BusinessException.java:151)
//		//       at com.asiainfo.foundation.exception.BusinessException.<init>(BusinessException.java:105)
//		//       at com.ailk.eaap.integration.o2p.process.HttpMsgStyleUrlTransformerProcessIn.parseNodeValBySrcMsg(HttpMsgStyleUrlTransformerProcessIn.java:96)
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
//	public void testParseNodeValBySrcMsg_4()
//		throws Exception {
//		HttpMsgStyleUrlTransformerProcessIn fixture = new HttpMsgStyleUrlTransformerProcessIn();
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
//	@Test
//	public void testProcessContent_1()
//		throws Exception {
//		HttpMsgStyleUrlTransformerProcessIn fixture = new HttpMsgStyleUrlTransformerProcessIn();
//		MessageDesc md = new MessageDesc();
//		md.setHeaders(new IdentityHashMap());
//		md.setMessageNodes(new LinkedList());
//		MessageBO<Object> bo = new MessageBO();
//
//		MessageBO<?> result = fixture.processContent(md, bo);
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
//		assertEquals(null, result.getSourceCode());
//		assertEquals(null, result.getMsgBody());
//		assertEquals(null, result.getTransactionID());
//		assertEquals(null, result.getReqTime());
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
//	 * Run the MessageBO<Object> processContent(MessageDesc,MessageBO<?>) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:38
//	 */
//	@Test
//	public void testProcessContent_2()
//		throws Exception {
//		HttpMsgStyleUrlTransformerProcessIn fixture = new HttpMsgStyleUrlTransformerProcessIn();
//		MessageDesc md = new MessageDesc();
//		md.setHeaders(new IdentityHashMap());
//		md.setMessageNodes(new LinkedList());
//		MessageBO<Object> bo = new MessageBO();
//
//		MessageBO<Object> result = fixture.processContent(md, bo);
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
//		assertEquals(null, result.getSourceCode());
//		assertEquals(null, result.getMsgBody());
//		assertEquals(null, result.getTransactionID());
//		assertEquals(null, result.getReqTime());
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
//	 * Run the MessageBO<Object> processContent(MessageDesc,MessageBO<?>) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:38
//	 */
//	@Test
//	public void testProcessContent_3()
//		throws Exception {
//		HttpMsgStyleUrlTransformerProcessIn fixture = new HttpMsgStyleUrlTransformerProcessIn();
//		MessageDesc md = new MessageDesc();
//		md.setHeaders(new IdentityHashMap());
//		md.setMessageNodes(new LinkedList());
//		MessageBO<Object> bo = new MessageBO();
//
//		MessageBO<Object> result = fixture.processContent(md, bo);
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
//		assertEquals(null, result.getSourceCode());
//		assertEquals(null, result.getMsgBody());
//		assertEquals(null, result.getTransactionID());
//		assertEquals(null, result.getReqTime());
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
//	 * Run the MessageBO<Object> processContent(MessageDesc,MessageBO<?>) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:38
//	 */
//	@Test
//	public void testProcessContent_4()
//		throws Exception {
//		HttpMsgStyleUrlTransformerProcessIn fixture = new HttpMsgStyleUrlTransformerProcessIn();
//		MessageDesc md = new MessageDesc();
//		md.setHeaders(new IdentityHashMap());
//		md.setMessageNodes(new LinkedList());
//		MessageBO<Object> bo = new MessageBO();
//
//		MessageBO<Object> result = fixture.processContent(md, bo);
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
//		assertEquals(null, result.getSourceCode());
//		assertEquals(null, result.getMsgBody());
//		assertEquals(null, result.getTransactionID());
//		assertEquals(null, result.getReqTime());
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
//		new org.junit.runner.JUnitCore().run(HttpMsgStyleUrlTransformerProcessInTest.class);
//	}
//}