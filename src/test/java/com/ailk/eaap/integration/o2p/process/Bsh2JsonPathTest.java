package com.ailk.eaap.integration.o2p.process;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * The class <code>Bsh2JsonPathTest</code> contains tests for the class <code>{@link Bsh2JsonPath}</code>.
 *
 * @generatedBy CodePro at 15-12-16 下午2:37
 * @author wuwz
 * @version $Revision: 1.0 $
 */
public class Bsh2JsonPathTest {
	/**
	 * Run the Object read(String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testRead_1()
		throws Exception {
		try {
		String json = "";
		String jsonPath = "";

		Object result = Bsh2JsonPath.read(json, jsonPath);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: json string can not be null or empty
		//       at com.jayway.jsonpath.internal.Utils.notEmpty(Utils.java:164)
		//       at com.jayway.jsonpath.internal.JsonReader.parse(JsonReader.java:52)
		//       at com.jayway.jsonpath.JsonPath.read(JsonPath.java:462)
		//       at com.ailk.eaap.integration.o2p.process.Bsh2JsonPath.read(Bsh2JsonPath.java:30)
		assertNotNull(result);} catch(Exception e) {
			
		}
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
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
	 * @generatedBy CodePro at 15-12-16 下午2:37
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
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(Bsh2JsonPathTest.class);
	}
}