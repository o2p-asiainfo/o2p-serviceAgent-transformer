//package com.ailk.eaap.integration.o2p.process;
//
//import java.util.IdentityHashMap;
//import java.util.Map;
//import org.dom4j.Document;
//import org.dom4j.DocumentException;
//import org.dom4j.Element;
//import org.dom4j.tree.BaseElement;
//import org.dom4j.tree.DefaultDocument;
//import org.junit.*;
//import static org.junit.Assert.*;
//import com.ailk.eaap.op2.serviceagent.common.MessageBO;
//import com.ailk.eaap.op2.bo.ContractFormat;
//import com.ailk.eaap.op2.bo.MessageDesc;
//import com.ailk.eaap.op2.bo.NodeDesc;
//
///**
// * The class <code>XmlTransformerProcessInTest</code> contains tests for the class <code>{@link XmlTransformerProcessIn}</code>.
// *
// * @generatedBy CodePro at 15-12-16 下午2:36
// * @author wuwz
// * @version $Revision: 1.0 $
// */
//public class XmlTransformerProcessInTest {
//	/**
//	 * Run the XmlTransformerProcessIn() constructor test.
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:36
//	 */
//	@Test
//	public void testXmlTransformerProcessIn_1()
//		throws Exception {
//		XmlTransformerProcessIn result = new XmlTransformerProcessIn();
//		assertNotNull(result);
//		// add additional test code here
//	}
//
//	/**
//	 * Run the Object parseNodeValBySrcMsg(MessageBO<?>,ContractFormat,NodeDesc) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:36
//	 */
//	@Test
//	public void testParseNodeValBySrcMsg_1()
//		throws Exception {
//		XmlTransformerProcessIn fixture = new XmlTransformerProcessIn();
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
//		//       at com.ailk.eaap.integration.o2p.process.XmlTransformerProcessIn.parseNodeValBySrcMsg(XmlTransformerProcessIn.java:104)
//		assertNotNull(result);
//	}
//
//	/**
//	 * Run the Object parseNodeValBySrcMsg(MessageBO<?>,ContractFormat,NodeDesc) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:36
//	 */
//	@Test
//	public void testParseNodeValBySrcMsg_2()
//		throws Exception {
//		XmlTransformerProcessIn fixture = new XmlTransformerProcessIn();
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
//		//       at com.ailk.eaap.integration.o2p.process.XmlTransformerProcessIn.parseNodeValBySrcMsg(XmlTransformerProcessIn.java:104)
//		assertNotNull(result);
//	}
//
//	/**
//	 * Run the Object parseNodeValBySrcMsg(MessageBO<?>,ContractFormat,NodeDesc) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:36
//	 */
//	@Test
//	public void testParseNodeValBySrcMsg_3()
//		throws Exception {
//		XmlTransformerProcessIn fixture = new XmlTransformerProcessIn();
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
//		//       at com.ailk.eaap.integration.o2p.process.XmlTransformerProcessIn.parseNodeValBySrcMsg(XmlTransformerProcessIn.java:104)
//		assertNotNull(result);
//	}
//
//	/**
//	 * Run the Object parseNodeValBySrcMsg(MessageBO<?>,ContractFormat,NodeDesc) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:36
//	 */
//	@Test
//	public void testParseNodeValBySrcMsg_4()
//		throws Exception {
//		XmlTransformerProcessIn fixture = new XmlTransformerProcessIn();
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
//	 * Run the void paseMap(Map<String,Object>,Document,Element,Map<String,String>) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:36
//	 */
//	@Test
//	public void testPaseMap_1()
//		throws Exception {
//		XmlTransformerProcessIn fixture = new XmlTransformerProcessIn();
//		Map<String, Object> map = new IdentityHashMap();
//		Document doc = new DefaultDocument();
//		Element e = new BaseElement("");
//		Map<String, String> nameSpaceMap = new IdentityHashMap();
//
//		fixture.paseMap(map, doc, e, nameSpaceMap);
//
//		// add additional test code here
//	}
//
//	/**
//	 * Run the void paseMap(Map<String,Object>,Document,Element,Map<String,String>) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:36
//	 */
//	@Test
//	public void testPaseMap_2()
//		throws Exception {
//		XmlTransformerProcessIn fixture = new XmlTransformerProcessIn();
//		Map<String, Object> map = new IdentityHashMap();
//		Document doc = new DefaultDocument();
//		Element e = new BaseElement("");
//		Map<String, String> nameSpaceMap = new IdentityHashMap();
//
//		fixture.paseMap(map, doc, e, nameSpaceMap);
//
//		// add additional test code here
//	}
//
//	/**
//	 * Run the void paseMap(Map<String,Object>,Document,Element,Map<String,String>) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:36
//	 */
//	@Test
//	public void testPaseMap_3()
//		throws Exception {
//		XmlTransformerProcessIn fixture = new XmlTransformerProcessIn();
//		Map<String, Object> map = new IdentityHashMap();
//		Document doc = new DefaultDocument();
//		Element e = new BaseElement("");
//		Map<String, String> nameSpaceMap = new IdentityHashMap();
//
//		fixture.paseMap(map, doc, e, nameSpaceMap);
//
//		// add additional test code here
//	}
//
//	/**
//	 * Run the void paseMap(Map<String,Object>,Document,Element,Map<String,String>) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:36
//	 */
//	@Test
//	public void testPaseMap_4()
//		throws Exception {
//		XmlTransformerProcessIn fixture = new XmlTransformerProcessIn();
//		Map<String, Object> map = new IdentityHashMap();
//		Document doc = new DefaultDocument();
//		Element e = new BaseElement("");
//		Map<String, String> nameSpaceMap = new IdentityHashMap();
//
//		fixture.paseMap(map, doc, e, nameSpaceMap);
//
//		// add additional test code here
//	}
//
//	/**
//	 * Run the void paseMap(Map<String,Object>,Document,Element,Map<String,String>) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:36
//	 */
//	@Test
//	public void testPaseMap_5()
//		throws Exception {
//		XmlTransformerProcessIn fixture = new XmlTransformerProcessIn();
//		Map<String, Object> map = new IdentityHashMap();
//		Document doc = new DefaultDocument();
//		Element e = new BaseElement("");
//		Map<String, String> nameSpaceMap = new IdentityHashMap();
//
//		fixture.paseMap(map, doc, e, nameSpaceMap);
//
//		// add additional test code here
//	}
//
//	/**
//	 * Run the void paseMap(Map<String,Object>,Document,Element,Map<String,String>) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:36
//	 */
//	@Test
//	public void testPaseMap_6()
//		throws Exception {
//		XmlTransformerProcessIn fixture = new XmlTransformerProcessIn();
//		Map<String, Object> map = new IdentityHashMap();
//		Document doc = new DefaultDocument();
//		Element e = new BaseElement("");
//		Map<String, String> nameSpaceMap = new IdentityHashMap();
//
//		fixture.paseMap(map, doc, e, nameSpaceMap);
//
//		// add additional test code here
//	}
//
//	/**
//	 * Run the void paseMap(Map<String,Object>,Document,Element,Map<String,String>) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:36
//	 */
//	@Test
//	public void testPaseMap_7()
//		throws Exception {
//		XmlTransformerProcessIn fixture = new XmlTransformerProcessIn();
//		Map<String, Object> map = new IdentityHashMap();
//		Document doc = new DefaultDocument();
//		Element e = new BaseElement("");
//		Map<String, String> nameSpaceMap = new IdentityHashMap();
//
//		fixture.paseMap(map, doc, e, nameSpaceMap);
//
//		// add additional test code here
//	}
//
//	/**
//	 * Run the void paseMap(Map<String,Object>,Document,Element,Map<String,String>) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:36
//	 */
//	@Test
//	public void testPaseMap_8()
//		throws Exception {
//		XmlTransformerProcessIn fixture = new XmlTransformerProcessIn();
//		Map<String, Object> map = new IdentityHashMap();
//		Document doc = new DefaultDocument();
//		Element e = new BaseElement("");
//		Map<String, String> nameSpaceMap = new IdentityHashMap();
//
//		fixture.paseMap(map, doc, e, nameSpaceMap);
//
//		// add additional test code here
//	}
//
//	/**
//	 * Run the void paseMap(Map<String,Object>,Document,Element,Map<String,String>) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:36
//	 */
//	@Test
//	public void testPaseMap_9()
//		throws Exception {
//		XmlTransformerProcessIn fixture = new XmlTransformerProcessIn();
//		Map<String, Object> map = new IdentityHashMap();
//		Document doc = new DefaultDocument();
//		Element e = new BaseElement("");
//		Map<String, String> nameSpaceMap = new IdentityHashMap();
//
//		fixture.paseMap(map, doc, e, nameSpaceMap);
//
//		// add additional test code here
//	}
//
//	/**
//	 * Run the Document paseMap2Xml(Map<String,Object>,Map<String,String>,Map<String,Object>,Map<String,Object>) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:36
//	 */
//	@Test(expected = org.dom4j.DocumentException.class)
//	public void testPaseMap2Xml_1()
//		throws Exception {
//		XmlTransformerProcessIn fixture = new XmlTransformerProcessIn();
//		Map<String, Object> map = new IdentityHashMap();
//		Map<String, String> nameSpaceMap = new IdentityHashMap();
//		Map<String, Object> mapAttr = new IdentityHashMap();
//		Map<String, Object> childNameSpaceMap = new IdentityHashMap();
//
//		Document result = fixture.paseMap2Xml(map, nameSpaceMap, mapAttr, childNameSpaceMap);
//
//		// add additional test code here
//		assertNotNull(result);
//	}
//
//	/**
//	 * Run the Document paseMap2Xml(Map<String,Object>,Map<String,String>,Map<String,Object>,Map<String,Object>) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:36
//	 */
//	@Test(expected = org.dom4j.DocumentException.class)
//	public void testPaseMap2Xml_2()
//		throws Exception {
//		XmlTransformerProcessIn fixture = new XmlTransformerProcessIn();
//		Map<String, Object> map = new IdentityHashMap();
//		Map<String, String> nameSpaceMap = new IdentityHashMap();
//		Map<String, Object> mapAttr = new IdentityHashMap();
//		Map<String, Object> childNameSpaceMap = new IdentityHashMap();
//
//		Document result = fixture.paseMap2Xml(map, nameSpaceMap, mapAttr, childNameSpaceMap);
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
//	 * @generatedBy CodePro at 15-12-16 下午2:36
//	 */
//	@Test(expected = java.lang.NullPointerException.class)
//	public void testProcessContent_1()
//		throws Exception {
//		XmlTransformerProcessIn fixture = new XmlTransformerProcessIn();
//		MessageDesc md = new MessageDesc();
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
//	 * @generatedBy CodePro at 15-12-16 下午2:36
//	 */
//	@Test(expected = java.lang.NullPointerException.class)
//	public void testProcessContent_2()
//		throws Exception {
//		XmlTransformerProcessIn fixture = new XmlTransformerProcessIn();
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
//	 * @generatedBy CodePro at 15-12-16 下午2:36
//	 */
//	@Test(expected = java.lang.NullPointerException.class)
//	public void testProcessContent_3()
//		throws Exception {
//		XmlTransformerProcessIn fixture = new XmlTransformerProcessIn();
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
//	 * @generatedBy CodePro at 15-12-16 下午2:36
//	 */
//	@Test(expected = java.lang.NullPointerException.class)
//	public void testProcessContent_4()
//		throws Exception {
//		XmlTransformerProcessIn fixture = new XmlTransformerProcessIn();
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
//	 * @generatedBy CodePro at 15-12-16 下午2:36
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
//	 * @generatedBy CodePro at 15-12-16 下午2:36
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
//	 * @generatedBy CodePro at 15-12-16 下午2:36
//	 */
//	public static void main(String[] args) {
//		new org.junit.runner.JUnitCore().run(XmlTransformerProcessInTest.class);
//	}
//}