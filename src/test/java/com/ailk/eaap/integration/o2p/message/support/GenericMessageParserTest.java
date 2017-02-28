package com.ailk.eaap.integration.o2p.message.support;

import org.apache.poi.hssf.record.formula.functions.T;
import org.junit.*;
import static org.junit.Assert.*;
import com.ailk.eaap.integration.o2p.message.GenericMessage;
import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.ailk.eaap.op2.bo.ContractVersion;

/**
 * The class <code>GenericMessageParserTest</code> contains tests for the class <code>{@link GenericMessageParser}</code>.
 *
 * @generatedBy CodePro at 15-12-16 下午2:34
 * @author wuwz
 * @version $Revision: 1.0 $
 */
public class GenericMessageParserTest {
	/**
	 * Run the GenericMessage<T> parse(ContractVersion,MessageBO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	@Test
	public void testParse_1()
		throws Exception {
		GenericMessageParser fixture = new GenericMessageParser();
		ContractVersion contractVersion = new ContractVersion();
		MessageBO originalMessage = new MessageBO();

		GenericMessage<T> result = fixture.parse(contractVersion, originalMessage);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
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
	 * @generatedBy CodePro at 15-12-16 下午2:34
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
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(GenericMessageParserTest.class);
	}
}