package com.ailk.eaap.integration.o2p.process.factory;

import org.junit.*;
import static org.junit.Assert.*;
import com.ailk.eaap.integration.o2p.process.AbstractTransformerProcessIn;

/**
 * The class <code>TransformerProcessFactoryTest</code> contains tests for the class <code>{@link TransformerProcessFactory}</code>.
 *
 * @generatedBy CodePro at 15-12-16 下午2:39
 * @author wuwz
 * @version $Revision: 1.0 $
 */
public class TransformerProcessFactoryTest {
	/**
	 * Run the TransformerProcessFactory getInstance() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:39
	 */
	@Test
	public void testGetInstance_1()
		throws Exception {

		TransformerProcessFactory result = TransformerProcessFactory.getInstance();

		// add additional test code here
		assertNotNull(result);
		assertEquals(true, result.isSingleton());
	}

	/**
	 * Run the AbstractTransformerProcessIn getProcess(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:39
	 */
	@Test
	public void testGetProcess_1()
		throws Exception {
		TransformerProcessFactory fixture = TransformerProcessFactory.getInstance();
		int processType = 1;

		AbstractTransformerProcessIn result = fixture.getProcess(processType);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the AbstractTransformerProcessIn getProcess(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:39
	 */
	@Test
	public void testGetProcess_2()
		throws Exception {
		TransformerProcessFactory fixture = TransformerProcessFactory.getInstance();
		int processType = 1;

		AbstractTransformerProcessIn result = fixture.getProcess(processType);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the boolean isSingleton() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:39
	 */
	@Test
	public void testIsSingleton_1()
		throws Exception {
		TransformerProcessFactory fixture = TransformerProcessFactory.getInstance();

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
	 * @generatedBy CodePro at 15-12-16 下午2:39
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
	 * @generatedBy CodePro at 15-12-16 下午2:39
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
	 * @generatedBy CodePro at 15-12-16 下午2:39
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(TransformerProcessFactoryTest.class);
	}
}