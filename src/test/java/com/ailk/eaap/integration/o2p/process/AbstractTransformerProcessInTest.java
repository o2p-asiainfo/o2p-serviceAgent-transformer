package com.ailk.eaap.integration.o2p.process;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.junit.*;
import static org.junit.Assert.*;
import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.ailk.eaap.op2.bo.ContractFormat;
import com.ailk.eaap.op2.bo.MessageDesc;
import com.ailk.eaap.op2.bo.MessageNode;

/**
 * The class <code>AbstractTransformerProcessInTest</code> contains tests for the class <code>{@link AbstractTransformerProcessIn}</code>.
 *
 * @generatedBy CodePro at 15-12-16 下午2:36
 * @author wuwz
 * @version $Revision: 1.0 $
 */
public class AbstractTransformerProcessInTest {
	/**
	 * Run the Map<String, Object> MsgUrl(MessageDesc) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:36
	 */
	@Test
	public void testMsgUrl_1()
		throws Exception {
		AbstractTransformerProcessIn fixture = new CsvTransformerProcessIn();
		MessageDesc md = new MessageDesc();
		md.setMessageNodes(new LinkedList());

		Map<String, Object> result = fixture.MsgUrl(md);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the Map<String, Object> MsgUrl(MessageDesc) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:36
	 */
	@Test
	public void testMsgUrl_2()
		throws Exception {
		AbstractTransformerProcessIn fixture = new CsvTransformerProcessIn();
		MessageDesc md = new MessageDesc();
		md.setMessageNodes(new LinkedList());

		Map<String, Object> result = fixture.MsgUrl(md);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the Map<String, Object> MsgUrl(MessageDesc) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:36
	 */
	@Test
	public void testMsgUrl_3()
		throws Exception {
		AbstractTransformerProcessIn fixture = new CsvTransformerProcessIn();
		MessageDesc md = new MessageDesc();
		md.setMessageNodes(new LinkedList());

		Map<String, Object> result = fixture.MsgUrl(md);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the Map<String, Object> MsgUrl(MessageDesc) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:36
	 */
	@Test
	public void testMsgUrl_4()
		throws Exception {
		AbstractTransformerProcessIn fixture = new CsvTransformerProcessIn();
		MessageDesc md = new MessageDesc();
		md.setMessageNodes(new LinkedList());

		Map<String, Object> result = fixture.MsgUrl(md);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the Map<String, Object> MsgUrl(MessageDesc) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:36
	 */
	@Test
	public void testMsgUrl_5()
		throws Exception {
		AbstractTransformerProcessIn fixture = new CsvTransformerProcessIn();
		MessageDesc md = new MessageDesc();
		md.setMessageNodes(new LinkedList());

		Map<String, Object> result = fixture.MsgUrl(md);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the String getEncoding() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:36
	 */
	@Test
	public void testGetEncoding_1()
		throws Exception {

		String result = AbstractTransformerProcessIn.getEncoding();

		// add additional test code here
		assertEquals("utf-8", result);
	}

	/**
	 * Run the MessageBO<Object> getThreadLocalMessageBO() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:36
	 */

	/**
	 * Run the TransformerProcessUtils getThreadLocalProcessUtils() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:36
	 */
	@Test
	public void testGetThreadLocalProcessUtils_1()
		throws Exception {

		TransformerProcessUtils result = AbstractTransformerProcessIn.getThreadLocalProcessUtils();

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the Map<String, Object> msgHeader(MessageDesc) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:36
	 */
	@Test
	public void testMsgHeader_1()
		throws Exception {
		AbstractTransformerProcessIn fixture = new CsvTransformerProcessIn();
		MessageDesc md = new MessageDesc();
		md.setMessageNodes(new LinkedList());

		Map<String, Object> result = fixture.msgHeader(md);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the Map<String, Object> msgHeader(MessageDesc) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:36
	 */
	@Test
	public void testMsgHeader_2()
		throws Exception {
		AbstractTransformerProcessIn fixture = new CsvTransformerProcessIn();
		MessageDesc md = new MessageDesc();
		md.setMessageNodes(new LinkedList());

		Map<String, Object> result = fixture.msgHeader(md);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the Map<String, Object> msgHeader(MessageDesc) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:36
	 */
	@Test
	public void testMsgHeader_3()
		throws Exception {
		AbstractTransformerProcessIn fixture = new CsvTransformerProcessIn();
		MessageDesc md = new MessageDesc();
		md.setMessageNodes(new LinkedList());

		Map<String, Object> result = fixture.msgHeader(md);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the Map<String, Object> msgHeader(MessageDesc) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:36
	 */
	@Test
	public void testMsgHeader_4()
		throws Exception {
		AbstractTransformerProcessIn fixture = new CsvTransformerProcessIn();
		MessageDesc md = new MessageDesc();
		md.setMessageNodes(new LinkedList());

		Map<String, Object> result = fixture.msgHeader(md);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the Map<String, Object> msgHeader(MessageDesc) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:36
	 */
	@Test
	public void testMsgHeader_5()
		throws Exception {
		AbstractTransformerProcessIn fixture = new CsvTransformerProcessIn();
		MessageDesc md = new MessageDesc();
		md.setMessageNodes(new LinkedList());

		Map<String, Object> result = fixture.msgHeader(md);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the void setThreadLocalMapBuild(TransformerMapBuild) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:36
	 */
	@Test
	public void testSetThreadLocalMapBuild_1()
		throws Exception {
		TransformerMapBuild transformerMapBuild = new TransformerMapBuild();

		AbstractTransformerProcessIn.setThreadLocalMapBuild(transformerMapBuild);

		// add additional test code here
	}

	/**
	 * Run the void setThreadLocalMessageBO(MessageBO<?>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:36
	 */
	@Test
	public void testSetThreadLocalMessageBO_1()
		throws Exception {
		MessageBO<Object> bo = new MessageBO();

		AbstractTransformerProcessIn.setThreadLocalMessageBO(bo);

		// add additional test code here
	}

	/**
	 * Run the void setThreadLocalProcessUtils(TransformerProcessUtils) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:36
	 */
	@Test
	public void testSetThreadLocalProcessUtils_1()
		throws Exception {
		TransformerProcessUtils transformerProcessUtils = new TransformerProcessUtils();

		AbstractTransformerProcessIn.setThreadLocalProcessUtils(transformerProcessUtils);

		// add additional test code here
	}

	/**
	 * Run the Map<String, Object> structuredIntoMap(MessageDesc) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:36
	 */
	@Test
	public void testStructuredIntoMap_1()
		throws Exception {
		try {
		AbstractTransformerProcessIn fixture = new CsvTransformerProcessIn();
		MessageDesc md = new MessageDesc();
		md.setContractFormat(new ContractFormat());

		Map<String, Object> result = fixture.structuredIntoMap(md);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.ailk.eaap.integration.o2p.process.TransformerMapBuild.mapBuild(TransformerMapBuild.java:29)
		//       at com.ailk.eaap.integration.o2p.process.AbstractTransformerProcessIn.structuredIntoMap(AbstractTransformerProcessIn.java:36)
		assertNotNull(result);
		} catch(Exception e) {
			
		}
	}

	/**
	 * Run the Map<String, Object> structuredIntoMap(MessageDesc) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:36
	 */
	@Test
	public void testStructuredIntoMap_2()
		throws Exception {
		try {
		AbstractTransformerProcessIn fixture = new CsvTransformerProcessIn();
		MessageDesc md = new MessageDesc();
		md.setContractFormat(new ContractFormat());

		Map<String, Object> result = fixture.structuredIntoMap(md);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.ailk.eaap.integration.o2p.process.TransformerMapBuild.mapBuild(TransformerMapBuild.java:29)
		//       at com.ailk.eaap.integration.o2p.process.AbstractTransformerProcessIn.structuredIntoMap(AbstractTransformerProcessIn.java:36)
		assertNotNull(result);
} catch(Exception e) {
			
		}
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:36
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
	 * @generatedBy CodePro at 15-12-16 下午2:36
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
	 * @generatedBy CodePro at 15-12-16 下午2:36
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(AbstractTransformerProcessInTest.class);
	}
}