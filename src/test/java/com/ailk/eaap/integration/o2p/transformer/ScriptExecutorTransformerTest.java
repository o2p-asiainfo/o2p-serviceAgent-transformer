package com.ailk.eaap.integration.o2p.transformer;

import org.junit.*;
import static org.junit.Assert.*;
import com.ailk.eaap.integration.o2p.script.jsr223.ScriptExecutorFactory;
import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.ailk.eaap.op2.bo.TransformerRule;

/**
 * The class <code>ScriptExecutorTransformerTest</code> contains tests for the class <code>{@link ScriptExecutorTransformer}</code>.
 *
 * @generatedBy CodePro at 15-12-16 下午2:43
 * @author wuwz
 * @version $Revision: 1.0 $
 */
public class ScriptExecutorTransformerTest {
	/**
	 * Run the ScriptExecutorTransformer() constructor test.
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:43
	 */
	@Test
	public void testScriptExecutorTransformer_1()
		throws Exception {
		ScriptExecutorTransformer result = new ScriptExecutorTransformer();
		assertNotNull(result);
		// add additional test code here
	}

	/**
	 * Run the Object afterTransform(MessageBO<?>,TransformerRule) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:43
	 */
	@Test
	public void testAfterTransform_1()
		throws Exception {
		ScriptExecutorTransformer fixture = new ScriptExecutorTransformer();
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
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
	 * @generatedBy CodePro at 15-12-16 下午2:43
	 */
	@Test
	public void testBeforeTransform_1()
		throws Exception {
		ScriptExecutorTransformer fixture = new ScriptExecutorTransformer();
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
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
	 * @generatedBy CodePro at 15-12-16 下午2:43
	 */
	@Test(expected = java.lang.IllegalStateException.class)
	public void testDoTransform_1()
		throws Exception {
		ScriptExecutorTransformer fixture = new ScriptExecutorTransformer();
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
		MessageBO<Object> message = new MessageBO();
		TransformerRule transformerRule = new TransformerRule();
		transformerRule.setScriptContent("");
		transformerRule.setTransformerType(new Integer(1));

		Object result = fixture.doTransform(message, transformerRule);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the Object doTransform(MessageBO<?>,TransformerRule) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:43
	 */
	@Test(expected = java.lang.IllegalStateException.class)
	public void testDoTransform_2()
		throws Exception {
		ScriptExecutorTransformer fixture = new ScriptExecutorTransformer();
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
		MessageBO<Object> message = new MessageBO();
		TransformerRule transformerRule = new TransformerRule();
		transformerRule.setScriptContent("");
		transformerRule.setTransformerType(new Integer(1));

		Object result = fixture.doTransform(message, transformerRule);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the Object doTransform(MessageBO<?>,TransformerRule) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:43
	 */
	@Test(expected = java.lang.IllegalStateException.class)
	public void testDoTransform_3()
		throws Exception {
		ScriptExecutorTransformer fixture = new ScriptExecutorTransformer();
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
		MessageBO<Object> message = new MessageBO();
		TransformerRule transformerRule = new TransformerRule();
		transformerRule.setScriptContent("");
		transformerRule.setTransformerType(new Integer(1));

		Object result = fixture.doTransform(message, transformerRule);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the ScriptExecutorFactory getScriptExecutorFactory() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:43
	 */
	@Test
	public void testGetScriptExecutorFactory_1()
		throws Exception {
		ScriptExecutorTransformer fixture = new ScriptExecutorTransformer();
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());

		ScriptExecutorFactory result = fixture.getScriptExecutorFactory();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the void setScriptExecutorFactory(ScriptExecutorFactory) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:43
	 */
	@Test
	public void testSetScriptExecutorFactory_1()
		throws Exception {
		ScriptExecutorTransformer fixture = new ScriptExecutorTransformer();
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
		ScriptExecutorFactory scriptExecutorFactory = new ScriptExecutorFactory();

		fixture.setScriptExecutorFactory(scriptExecutorFactory);

		// add additional test code here
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:43
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
	 * @generatedBy CodePro at 15-12-16 下午2:43
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
	 * @generatedBy CodePro at 15-12-16 下午2:43
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(ScriptExecutorTransformerTest.class);
	}
}