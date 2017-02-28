package com.ailk.eaap.integration.o2p.process;

import java.util.IdentityHashMap;
import java.util.Map;
import org.junit.*;
import static org.junit.Assert.*;
import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.ailk.eaap.op2.bo.ContractFormat;
import com.ailk.eaap.op2.bo.MessageDesc;
import com.ailk.eaap.op2.bo.NodeDesc;

/**
 * The class <code>DefaultTransformerProcessInTest</code> contains tests for the class <code>{@link DefaultTransformerProcessIn}</code>.
 *
 * @generatedBy CodePro at 15-12-16 下午2:38
 * @author wuwz
 * @version $Revision: 1.0 $
 */
public class DefaultTransformerProcessInTest {
	/**
	 * Run the Object parseNodeValBySrcMsg(MessageBO<?>,ContractFormat,NodeDesc) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testParseNodeValBySrcMsg_1()
		throws Exception {
		DefaultTransformerProcessIn fixture = new DefaultTransformerProcessIn();
		MessageBO<Object> srcMsg = new MessageBO();
		ContractFormat contractFormat = new ContractFormat();
		NodeDesc nodeDesc = new NodeDesc();

		Object result = fixture.parseNodeValBySrcMsg(srcMsg, contractFormat, nodeDesc);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the MessageBO<Object> processContent(MessageDesc,MessageBO<?>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
//	@Test(expected = java.lang.IllegalArgumentException.class)
//	public void testProcessContent_1()
//		throws Exception {
//		DefaultTransformerProcessIn fixture = new DefaultTransformerProcessIn();
//		MessageDesc md = new MessageDesc();
//		md.setHeaders(new IdentityHashMap());
//		MessageBO<Object> bo = new MessageBO();
//
//		MessageBO<Object> result = fixture.processContent(md, bo);
//
//		// add additional test code here
//		assertNotNull(result);
//	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
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
	 * @generatedBy CodePro at 15-12-16 下午2:38
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
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(DefaultTransformerProcessInTest.class);
	}
}