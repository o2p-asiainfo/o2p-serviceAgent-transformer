package com.ailk.eaap.integration.o2p.transformer;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>TransformerFactoryImplTest</code> contains tests for the class <code>{@link TransformerFactoryImpl}</code>.
 *
 * @generatedBy CodePro at 15-12-16 下午2:40
 * @author wuwz
 * @version $Revision: 1.0 $
 */
public class TransformerFactoryImplTest {
	/**
	 * Run the void destory() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:40
	 */
	@Test
	public void testDestory_1()
		throws Exception {
		TransformerFactoryImpl fixture = new TransformerFactoryImpl();

		fixture.destory();

		// add additional test code here
	}

	/**
	 * Run the Class<Transformer> getObjectType() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:40
	 */
	@Test
	public void testGetObjectType_1()
		throws Exception {
		TransformerFactoryImpl fixture = new TransformerFactoryImpl();

		Class<Transformer> result = fixture.getObjectType();

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the Transformer getTransformer(Integer) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:40
	 */
	@Test
	public void testGetTransformer_1()
		throws Exception {
		TransformerFactoryImpl fixture = new TransformerFactoryImpl();
		Integer transformType = new Integer(1);

		Transformer result = fixture.getTransformer(transformType);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the void init() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:40
	 */
	@Test
	public void testInit_1()
		throws Exception {
		TransformerFactoryImpl fixture = new TransformerFactoryImpl();

		fixture.init();

		// add additional test code here
	}

	/**
	 * Run the boolean isSingleton() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:40
	 */
	@Test
	public void testIsSingleton_1()
		throws Exception {
		TransformerFactoryImpl fixture = new TransformerFactoryImpl();

		boolean result = fixture.isSingleton();

		// add additional test code here
		assertEquals(true, result);
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
		new org.junit.runner.JUnitCore().run(TransformerFactoryImplTest.class);
	}
}