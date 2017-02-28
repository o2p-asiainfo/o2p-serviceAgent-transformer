//package com.ailk.eaap.integration.o2p.process;
//
//import java.util.LinkedList;
//import java.util.List;
//import org.junit.*;
//import static org.junit.Assert.*;
//import com.ailk.eaap.op2.serviceagent.common.MessageBO;
//import com.ailk.eaap.op2.bo.ContractFormat;
//import com.ailk.eaap.op2.bo.MessageDesc;
//import com.ailk.eaap.op2.bo.MessageNode;
//import com.ailk.eaap.op2.bo.NodeDesc;
//
///**
// * The class <code>TlvTransformerProcessInTest</code> contains tests for the class <code>{@link TlvTransformerProcessIn}</code>.
// *
// * @generatedBy CodePro at 15-12-16 下午2:38
// * @author wuwz
// * @version $Revision: 1.0 $
// */
//public class TlvTransformerProcessInTest {
//	/**
//	 * Run the TlvTransformerProcessIn() constructor test.
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:38
//	 */
//	@Test
//	public void testTlvTransformerProcessIn_1()
//		throws Exception {
//		TlvTransformerProcessIn result = new TlvTransformerProcessIn();
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
//		TlvTransformerProcessIn fixture = new TlvTransformerProcessIn();
//		MessageBO<Object> srcMsg = new MessageBO();
//		ContractFormat contractFormat = new ContractFormat();
//		NodeDesc nodeDesc = new NodeDesc();
//		nodeDesc.setNodeType("1");
//		nodeDesc.setNodeCode("");
//
//		Object result = fixture.parseNodeValBySrcMsg(srcMsg, contractFormat, nodeDesc);
//
//		// add additional test code here
//		// An unexpected exception was thrown in user code while executing this test:
//		//    java.lang.IllegalArgumentException: The TLV MsgBody is null 
//		//       at org.springframework.util.Assert.notNull(Assert.java:112)
//		//       at com.ailk.eaap.integration.o2p.process.TlvTransformerProcessIn.parseNodeValBySrcMsg(TlvTransformerProcessIn.java:27)
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
//		TlvTransformerProcessIn fixture = new TlvTransformerProcessIn();
//		MessageBO<Object> srcMsg = new MessageBO();
//		ContractFormat contractFormat = new ContractFormat();
//		NodeDesc nodeDesc = new NodeDesc();
//		nodeDesc.setNodePath("");
//		nodeDesc.setNodeType("");
//
//		Object result = fixture.parseNodeValBySrcMsg(srcMsg, contractFormat, nodeDesc);
//
//		// add additional test code here
//		// An unexpected exception was thrown in user code while executing this test:
//		//    java.lang.IllegalArgumentException: The TLV MsgBody is null 
//		//       at org.springframework.util.Assert.notNull(Assert.java:112)
//		//       at com.ailk.eaap.integration.o2p.process.TlvTransformerProcessIn.parseNodeValBySrcMsg(TlvTransformerProcessIn.java:27)
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
//	@Test
//	public void testProcessContent_1()
//		throws Exception {
//		TlvTransformerProcessIn fixture = new TlvTransformerProcessIn();
//		MessageDesc md = new MessageDesc();
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
//		assertEquals("", result.getMsgBody());
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
//		assertEquals(null, result.getTransactionID());
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
//		TlvTransformerProcessIn fixture = new TlvTransformerProcessIn();
//		MessageDesc md = new MessageDesc();
//		md.setContractFormat(new ContractFormat());
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
//		assertEquals("", result.getMsgBody());
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
//		assertEquals(null, result.getTransactionID());
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
//		TlvTransformerProcessIn fixture = new TlvTransformerProcessIn();
//		MessageDesc md = new MessageDesc();
//		md.setContractFormat(new ContractFormat());
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
//		assertEquals("", result.getMsgBody());
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
//		assertEquals(null, result.getTransactionID());
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
//		TlvTransformerProcessIn fixture = new TlvTransformerProcessIn();
//		MessageDesc md = new MessageDesc();
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
//		assertEquals("", result.getMsgBody());
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
//		assertEquals(null, result.getTransactionID());
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
//		new org.junit.runner.JUnitCore().run(TlvTransformerProcessInTest.class);
//	}
//}