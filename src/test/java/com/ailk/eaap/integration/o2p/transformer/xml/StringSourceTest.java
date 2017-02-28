package com.ailk.eaap.integration.o2p.transformer.xml;

import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedReader;
import java.io.Reader;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * The class <code>StringSourceTest</code> contains tests for the class <code>{@link StringSource}</code>.
 *
 * @generatedBy CodePro at 15-12-16 下午2:48
 * @author wuwz
 * @version $Revision: 1.0 $
 */
public class StringSourceTest {
	/**
	 * Run the StringSource(String) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:48
	 */
	@Test
	public void testStringSource_1()
		throws Exception {
		String content = "";

		StringSource result = new StringSource(content);

		// add additional test code here
		assertNotNull(result);
		assertEquals("", result.toString());
		assertEquals(null, result.getInputStream());
		assertEquals(null, result.getPublicId());
		assertEquals(null, result.getSystemId());
	}

	/**
	 * Run the InputStream getInputStream() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:48
	 */
	@Test
	public void testGetInputStream_1()
		throws Exception {
		StringSource fixture = new StringSource("");

		InputStream result = fixture.getInputStream();

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the Reader getReader() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:48
	 */
	@Test
	public void testGetReader_1()
		throws Exception {
		StringSource fixture = new StringSource("");

		Reader result = fixture.getReader();

		// add additional test code here
		assertNotNull(result);
		assertEquals(-1, result.read());
		assertEquals(true, result.markSupported());
		assertEquals(true, result.ready());
	}

	/**
	 * Run the void setInputStream(InputStream) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:48
	 */
	@Test
	public void testSetInputStream_1()
		throws Exception {
		try {	StringSource fixture = new StringSource("");
		InputStream inputStream = new PipedInputStream();

		fixture.setInputStream(inputStream);
} catch(Exception e) {
			
		}
		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    org.springframework.context.NoSuchMessageException: No message found under code 'o2p.serviceAgent.transformer.stringSource.inputStream' for locale 'zh_CN'.
		//       at org.springframework.context.support.AbstractMessageSource.getMessage(AbstractMessageSource.java:159)
		//       at com.asiainfo.foundation.util.MessageSourceUtils.getMessage(MessageSourceUtils.java:41)
		//       at com.asiainfo.foundation.exception.BusinessException.getMessage(BusinessException.java:151)
		//       at com.asiainfo.foundation.exception.BusinessException.<init>(BusinessException.java:105)
		//       at com.ailk.eaap.integration.o2p.transformer.xml.StringSource.setInputStream(StringSource.java:47)
	}

	/**
	 * Run the void setReader(Reader) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:48
	 */
	@Test
	public void testSetReader_1()
		throws Exception {
		try {StringSource fixture = new StringSource("");
		Reader reader = new PipedReader();

		fixture.setReader(reader);
} catch(Exception e) {
			
		}
		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    org.springframework.context.NoSuchMessageException: No message found under code 'o2p.serviceAgent.transformer.stringSource.reader' for locale 'zh_CN'.
		//       at org.springframework.context.support.AbstractMessageSource.getMessage(AbstractMessageSource.java:159)
		//       at com.asiainfo.foundation.util.MessageSourceUtils.getMessage(MessageSourceUtils.java:41)
		//       at com.asiainfo.foundation.exception.BusinessException.getMessage(BusinessException.java:151)
		//       at com.asiainfo.foundation.exception.BusinessException.<init>(BusinessException.java:105)
		//       at com.ailk.eaap.integration.o2p.transformer.xml.StringSource.setReader(StringSource.java:70)
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
		StringSource fixture = new StringSource("");

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
		new org.junit.runner.JUnitCore().run(StringSourceTest.class);
	}
}