package com.ailk.eaap.integration.o2p.transformer;

import org.junit.*;
import static org.junit.Assert.*;
import com.ailk.eaap.op2.serviceagent.common.MessageBO;

/**
 * The class <code>MessageTransformationExceptionTest</code> contains tests for the class <code>{@link MessageTransformationException}</code>.
 *
 * @generatedBy CodePro at 15-12-16 下午2:42
 * @author wuwz
 * @version $Revision: 1.0 $
 */
public class MessageTransformationExceptionTest {
	/**
	 * Run the MessageTransformationException(String) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:42
	 */
	@Test
	public void testMessageTransformationException_1()
		throws Exception {
		String description = "";

		MessageTransformationException result = new MessageTransformationException(description);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getFailedMessage());
		assertEquals(null, result.getCause());
		assertEquals("com.ailk.eaap.integration.o2p.transformer.MessageTransformationException: ", result.toString());
		assertEquals("", result.getMessage());
		assertEquals("", result.getLocalizedMessage());
	}

	/**
	 * Run the MessageTransformationException(MessageBO<?>,String) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:42
	 */
	@Test
	public void testMessageTransformationException_2()
		throws Exception {
		MessageBO<Object> message = new MessageBO();
		String description = "";

		MessageTransformationException result = new MessageTransformationException(message, description);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getCause());
		assertEquals("com.ailk.eaap.integration.o2p.transformer.MessageTransformationException: ", result.toString());
		assertEquals("", result.getMessage());
		assertEquals("", result.getLocalizedMessage());
	}

	/**
	 * Run the MessageTransformationException(String,Throwable) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:42
	 */
	@Test
	public void testMessageTransformationException_3()
		throws Exception {
		String description = "";
		Throwable cause = new Throwable();

		MessageTransformationException result = new MessageTransformationException(description, cause);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getFailedMessage());
		assertEquals("com.ailk.eaap.integration.o2p.transformer.MessageTransformationException: ", result.toString());
		assertEquals("", result.getMessage());
		assertEquals("", result.getLocalizedMessage());
	}

	/**
	 * Run the MessageTransformationException(MessageBO<?>,int,String) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:42
	 */
	@Test
	public void testMessageTransformationException_4()
		throws Exception {
		MessageBO<Object> message = new MessageBO();
		int code = 1;
		String description = "";

		MessageTransformationException result = new MessageTransformationException(message, code, description);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getCause());
		assertEquals("com.ailk.eaap.integration.o2p.transformer.MessageTransformationException: ", result.toString());
		assertEquals("", result.getMessage());
		assertEquals("", result.getLocalizedMessage());
	}

	/**
	 * Run the MessageTransformationException(MessageBO<?>,String,Throwable) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:42
	 */
	@Test
	public void testMessageTransformationException_5()
		throws Exception {
		MessageBO<Object> message = new MessageBO();
		String description = "";
		Throwable cause = new Throwable();

		MessageTransformationException result = new MessageTransformationException(message, description, cause);

		// add additional test code here
		assertNotNull(result);
		assertEquals("com.ailk.eaap.integration.o2p.transformer.MessageTransformationException: ", result.toString());
		assertEquals("", result.getMessage());
		assertEquals("", result.getLocalizedMessage());
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:42
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
	 * @generatedBy CodePro at 15-12-16 下午2:42
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
	 * @generatedBy CodePro at 15-12-16 下午2:42
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(MessageTransformationExceptionTest.class);
	}
}