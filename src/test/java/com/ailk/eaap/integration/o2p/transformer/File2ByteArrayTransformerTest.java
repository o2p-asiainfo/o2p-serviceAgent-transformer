package com.ailk.eaap.integration.o2p.transformer;

import org.junit.*;
import static org.junit.Assert.*;
import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.ailk.eaap.op2.bo.TransformerRule;

/**
 * The class <code>File2ByteArrayTransformerTest</code> contains tests for the class <code>{@link File2ByteArrayTransformer}</code>.
 *
 * @generatedBy CodePro at 15-12-16 下午2:40
 * @author wuwz
 * @version $Revision: 1.0 $
 */
public class File2ByteArrayTransformerTest {
	/**
	 * Run the Object afterTransform(MessageBO<?>,TransformerRule) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:40
	 */
	@Test
	public void testAfterTransform_1()
		throws Exception {
		File2ByteArrayTransformer fixture = new File2ByteArrayTransformer();
		MessageBO<Object> message = new MessageBO();
		TransformerRule transformerRule = new TransformerRule();

		Object result = fixture.afterTransform(message, transformerRule);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the Object beforeTransform(MessageBO<?>,TransformerRule) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:40
	 */
	@Test
	public void testBeforeTransform_1()
		throws Exception {
		File2ByteArrayTransformer fixture = new File2ByteArrayTransformer();
		MessageBO<Object> message = new MessageBO();
		TransformerRule transformerRule = new TransformerRule();

		Object result = fixture.beforeTransform(message, transformerRule);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the Object doTransform(MessageBO<?>,TransformerRule) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:40
	 */
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testDoTransform_1()
		throws Exception {
		File2ByteArrayTransformer fixture = new File2ByteArrayTransformer();
		MessageBO<Object> message = new MessageBO();
		TransformerRule transformerRule = new TransformerRule();

		Object result = fixture.doTransform(message, transformerRule);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the Object doTransform(MessageBO<?>,TransformerRule) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:40
	 */
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testDoTransform_2()
		throws Exception {
		File2ByteArrayTransformer fixture = new File2ByteArrayTransformer();
		MessageBO<Object> message = new MessageBO();
		TransformerRule transformerRule = new TransformerRule();

		Object result = fixture.doTransform(message, transformerRule);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:40
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
	 * @generatedBy CodePro at 15-12-16 下午2:40
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
	 * @generatedBy CodePro at 15-12-16 下午2:40
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(File2ByteArrayTransformerTest.class);
	}
}