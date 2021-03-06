package com.ailk.eaap.integration.o2p.transformer;

import org.junit.*;
import static org.junit.Assert.*;
import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.ailk.eaap.op2.bo.TransformerRule;

/**
 * The class <code>Xml2JsonTransformerTest</code> contains tests for the class <code>{@link Xml2JsonTransformer}</code>.
 *
 * @generatedBy CodePro at 15-12-16 下午2:41
 * @author wuwz
 * @version $Revision: 1.0 $
 */
public class Xml2JsonTransformerTest {
	/**
	 * Run the Xml2JsonTransformer() constructor test.
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:41
	 */
	@Test
	public void testXml2JsonTransformer_1()
		throws Exception {
		Xml2JsonTransformer result = new Xml2JsonTransformer();
		assertNotNull(result);
		// add additional test code here
	}

	/**
	 * Run the Object afterTransform(MessageBO<?>,TransformerRule) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:41
	 */
	@Test
	public void testAfterTransform_1()
		throws Exception {
		Xml2JsonTransformer fixture = new Xml2JsonTransformer();
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
	 * @generatedBy CodePro at 15-12-16 下午2:41
	 */
	@Test
	public void testBeforeTransform_1()
		throws Exception {
		Xml2JsonTransformer fixture = new Xml2JsonTransformer();
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
	 * @generatedBy CodePro at 15-12-16 下午2:41
	 */
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testDoTransform_1()
		throws Exception {
		Xml2JsonTransformer fixture = new Xml2JsonTransformer();
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
	 * @generatedBy CodePro at 15-12-16 下午2:41
	 */
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testDoTransform_2()
		throws Exception {
		Xml2JsonTransformer fixture = new Xml2JsonTransformer();
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
	 * @generatedBy CodePro at 15-12-16 下午2:41
	 */
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testDoTransform_3()
		throws Exception {
		Xml2JsonTransformer fixture = new Xml2JsonTransformer();
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
	 * @generatedBy CodePro at 15-12-16 下午2:41
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
	 * @generatedBy CodePro at 15-12-16 下午2:41
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
	 * @generatedBy CodePro at 15-12-16 下午2:41
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(Xml2JsonTransformerTest.class);
	}
}