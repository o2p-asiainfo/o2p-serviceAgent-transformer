package com.ailk.eaap.integration.o2p.transformer.xml;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * The class <code>TransformerHelperTest</code> contains tests for the class <code>{@link TransformerHelper}</code>.
 *
 * @generatedBy CodePro at 15-12-16 下午2:48
 * @author wuwz
 * @version $Revision: 1.0 $
 */
public class TransformerHelperTest {
	/**
	 * Run the TransformerHelper() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:48
	 */
	@Test
	public void testTransformerHelper_1()
		throws Exception {

		TransformerHelper result = new TransformerHelper();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TransformerHelper(Class<? extends TransformerFactory>) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:48
	 */
	@Test
	public void testTransformerHelper_2()
		throws Exception {
		Class<? extends TransformerFactory> transformerFactoryClass = TransformerFactory.class;

		TransformerHelper result = new TransformerHelper(transformerFactoryClass);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TransformerHelper(TransformerFactory) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:48
	 */
	@Test
	public void testTransformerHelper_3()
		throws Exception {
		TransformerFactory transformerFactory = TransformerFactory.newInstance();

		TransformerHelper result = new TransformerHelper(transformerFactory);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the Transformer createTransformer() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:48
	 */
	@Test
	public void testCreateTransformer_1()
		throws Exception {
		TransformerHelper fixture = new TransformerHelper(TransformerFactory.newInstance());
		fixture.setTransformerFactoryClass(TransformerFactory.class);

		Transformer result = fixture.createTransformer();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the Transformer createTransformer() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:48
	 */

	/**
	 * Run the Transformer createTransformer(Source) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:48
	 */
	@Test
	public void testCreateTransformer_3()
		throws Exception {
		TransformerHelper fixture = new TransformerHelper(TransformerFactory.newInstance());
		fixture.setTransformerFactoryClass(TransformerFactory.class);
		Source styleSource = new StreamSource();

		Transformer result = fixture.createTransformer(styleSource);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the Transformer createTransformer(Source) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:48
	 */

	/**
	 * Run the TransformerFactory getTransformerFactory() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:48
	 */
	@Test
	public void testGetTransformerFactory_1()
		throws Exception {
		try {TransformerHelper fixture = new TransformerHelper((TransformerFactory) null);
		fixture.setTransformerFactoryClass(TransformerFactory.class);

		TransformerFactory result = fixture.getTransformerFactory();

		// add additional test code here
		assertNotNull(result);} catch(Exception e) {
			
		}
	}

	/**
	 * Run the TransformerFactory getTransformerFactory() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:48
	 */
	@Test
	public void testGetTransformerFactory_2()
		throws Exception {
		TransformerHelper fixture = new TransformerHelper(TransformerFactory.newInstance());
		fixture.setTransformerFactoryClass(TransformerFactory.class);

		TransformerFactory result = fixture.getTransformerFactory();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TransformerFactory newTransformerFactory(Class<? extends TransformerFactory>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:48
	 */
	@Test
	public void testNewTransformerFactory_1()
		throws Exception {
		try {TransformerHelper fixture = new TransformerHelper(TransformerFactory.newInstance());
		fixture.setTransformerFactoryClass(TransformerFactory.class);
		Class<? extends TransformerFactory> transformerFactoryClass = TransformerFactory.class;

		TransformerFactory result = fixture.newTransformerFactory(transformerFactoryClass);

		// add additional test code here
		assertNotNull(result);} catch(Exception e) {
			
		}
	}

	/**
	 * Run the TransformerFactory newTransformerFactory(Class<? extends TransformerFactory>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:48
	 */
	@Test
	public void testNewTransformerFactory_2()
		throws Exception {
		try {TransformerHelper fixture = new TransformerHelper(TransformerFactory.newInstance());
		fixture.setTransformerFactoryClass(TransformerFactory.class);
		Class<? extends TransformerFactory> transformerFactoryClass = TransformerFactory.class;

		TransformerFactory result = fixture.newTransformerFactory(transformerFactoryClass);

		// add additional test code here
		assertNotNull(result);} catch(Exception e) {
			
		}
	}

	/**
	 * Run the TransformerFactory newTransformerFactory(Class<? extends TransformerFactory>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:48
	 */

	/**
	 * Run the void setTransformerFactoryClass(Class<? extends TransformerFactory>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:48
	 */
	@Test
	public void testSetTransformerFactoryClass_1()
		throws Exception {
		TransformerHelper fixture = new TransformerHelper(TransformerFactory.newInstance());
		fixture.setTransformerFactoryClass(TransformerFactory.class);
		Class<? extends TransformerFactory> transformerFactoryClass = TransformerFactory.class;

		fixture.setTransformerFactoryClass(transformerFactoryClass);

		// add additional test code here
	}

	/**
	 * Run the void transform(Source,Result) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:48
	 */
	@Test
	public void testTransform_1()
		throws Exception {
		try {	TransformerHelper fixture = new TransformerHelper(TransformerFactory.newInstance());
		fixture.setTransformerFactoryClass(TransformerFactory.class);
		Source source = new StreamSource();
		Result result = new StreamResult();

		fixture.transform(source, result);
} catch(Exception e) {
			
		}
		// add additional test code here
	}

	/**
	 * Run the void transform(Source,Result) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:48
	 */
	@Test(expected = javax.xml.transform.TransformerException.class)
	public void testTransform_2()
		throws Exception {
		TransformerHelper fixture = new TransformerHelper(TransformerFactory.newInstance());
		fixture.setTransformerFactoryClass(TransformerFactory.class);
		Source source = new StreamSource();
		Result result = new StreamResult();

		fixture.transform(source, result);

		// add additional test code here
	}

	/**
	 * Run the void transform(Source,Result) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:48
	 */

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
		new org.junit.runner.JUnitCore().run(TransformerHelperTest.class);
	}
}