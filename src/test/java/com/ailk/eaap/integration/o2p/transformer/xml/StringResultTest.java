package com.ailk.eaap.integration.o2p.transformer.xml;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>StringResultTest</code> contains tests for the class <code>{@link StringResult}</code>.
 *
 * @generatedBy CodePro at 15-12-16 下午2:48
 * @author wuwz
 * @version $Revision: 1.0 $
 */
public class StringResultTest {
	/**
	 * Run the StringResult() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:48
	 */
	@Test
	public void testStringResult_1()
		throws Exception {

		StringResult result = new StringResult();

		// add additional test code here
		assertNotNull(result);
		assertEquals("", result.toString());
		assertEquals(null, result.getOutputStream());
		assertEquals(null, result.getSystemId());
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:48
	 */
	@Test
	public void testToString_1()
		throws Exception {
		StringResult fixture = new StringResult();

		String result = fixture.toString();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:48
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
	 * @generatedBy CodePro at 15-12-16 下午2:48
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
	 * @generatedBy CodePro at 15-12-16 下午2:48
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(StringResultTest.class);
	}
}