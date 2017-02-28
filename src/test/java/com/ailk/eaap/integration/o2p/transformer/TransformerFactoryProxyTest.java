//package com.ailk.eaap.integration.o2p.transformer;
//
//import java.util.IdentityHashMap;
//import java.util.Map;
//import org.junit.*;
//import static org.junit.Assert.*;
//
///**
// * The class <code>TransformerFactoryProxyTest</code> contains tests for the class <code>{@link TransformerFactoryProxy}</code>.
// *
// * @generatedBy CodePro at 15-12-16 下午2:39
// * @author wuwz
// * @version $Revision: 1.0 $
// */
//public class TransformerFactoryProxyTest {
//	/**
//	 * Run the TransformerFactoryProxy() constructor test.
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:39
//	 */
//	@Test
//	public void testTransformerFactoryProxy_1()
//		throws Exception {
//		TransformerFactoryProxy result = new TransformerFactoryProxy();
//		assertNotNull(result);
//		// add additional test code here
//	}
//
//	/**
//	 * Run the void destory() method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:39
//	 */
//	@Test
//	public void testDestory_1()
//		throws Exception {
//		TransformerFactoryProxy fixture = new TransformerFactoryProxy();
//		fixture.setTransformerHolder(new IdentityHashMap());
//
//		fixture.destory();
//
//		// add additional test code here
//	}
//
//	/**
//	 * Run the Class<Object> getObjectType() method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:39
//	 */
//	@Test
//	public void testGetObjectType_1()
//		throws Exception {
//		TransformerFactoryProxy fixture = new TransformerFactoryProxy();
//		fixture.setTransformerHolder(new IdentityHashMap());
//
//		Class<Object> result = fixture.getObjectType();
//
//		// add additional test code here
//		assertNotNull(result);
//		assertEquals("class com.ailk.eaap.integration.o2p.transformer.DefaultTransformer", result.toString());
//		assertEquals(1, result.getModifiers());
//		assertEquals(false, result.isInterface());
//		assertEquals(false, result.isArray());
//		assertEquals(false, result.isPrimitive());
//		assertEquals(null, result.getComponentType());
//		assertEquals("com.ailk.eaap.integration.o2p.transformer.DefaultTransformer", result.getName());
//		assertEquals(false, result.desiredAssertionStatus());
//		assertEquals("com.ailk.eaap.integration.o2p.transformer.DefaultTransformer", result.getCanonicalName());
//		assertEquals(null, result.getDeclaringClass());
//		assertEquals(null, result.getEnclosingClass());
//		assertEquals(null, result.getEnclosingConstructor());
//		assertEquals(null, result.getEnclosingMethod());
//		assertEquals(null, result.getEnumConstants());
//		assertEquals(null, result.getSigners());
//		assertEquals("DefaultTransformer", result.getSimpleName());
//		assertEquals(false, result.isAnnotation());
//		assertEquals(false, result.isAnonymousClass());
//		assertEquals(false, result.isEnum());
//		assertEquals(false, result.isLocalClass());
//		assertEquals(false, result.isMemberClass());
//		assertEquals(false, result.isSynthetic());
//	}
//
//	/**
//	 * Run the Transformer getTransformer(Integer) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:39
//	 */
//	@Test
//	public void testGetTransformer_1()
//		throws Exception {
//		TransformerFactoryProxy fixture = new TransformerFactoryProxy();
//		fixture.setTransformerHolder(new IdentityHashMap());
//		Integer transformType = new Integer(1);
//
//		Transformer result = fixture.getTransformer(transformType);
//
//		// add additional test code here
//		// An unexpected exception was thrown in user code while executing this test:
//		//    java.lang.NullPointerException
//		//       at com.ailk.eaap.integration.o2p.transformer.TransformerFactoryProxy.getTransformer(TransformerFactoryProxy.java:38)
//		assertNotNull(result);
//	}
//
//	/**
//	 * Run the void init() method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:39
//	 */
//	@Test
//	public void testInit_1()
//		throws Exception {
//		TransformerFactoryProxy fixture = new TransformerFactoryProxy();
//		fixture.setTransformerHolder(new IdentityHashMap());
//
//		fixture.init();
//
//		// add additional test code here
//	}
//
//	/**
//	 * Run the boolean isSingleton() method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:39
//	 */
//	@Test
//	public void testIsSingleton_1()
//		throws Exception {
//		TransformerFactoryProxy fixture = new TransformerFactoryProxy();
//		fixture.setTransformerHolder(new IdentityHashMap());
//
//		boolean result = fixture.isSingleton();
//
//		// add additional test code here
//		assertEquals(true, result);
//	}
//
//	/**
//	 * Run the void setTransformerHolder(Map<Integer,Transformer>) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:39
//	 */
//	@Test
//	public void testSetTransformerHolder_1()
//		throws Exception {
//		TransformerFactoryProxy fixture = new TransformerFactoryProxy();
//		fixture.setTransformerHolder(new IdentityHashMap());
//		Map<Integer, Transformer> transformerHolder = new IdentityHashMap();
//
//		fixture.setTransformerHolder(transformerHolder);
//
//		// add additional test code here
//	}
//
//	/**
//	 * Perform pre-test initialization.
//	 *
//	 * @throws Exception
//	 *         if the initialization fails for some reason
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:39
//	 */
//	@Before
//	public void setUp()
//		throws Exception {
//		// add additional set up code here
//	}
//
//	/**
//	 * Perform post-test clean-up.
//	 *
//	 * @throws Exception
//	 *         if the clean-up fails for some reason
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:39
//	 */
//	@After
//	public void tearDown()
//		throws Exception {
//		// Add additional tear down code here
//	}
//
//	/**
//	 * Launch the test.
//	 *
//	 * @param args the command line arguments
//	 *
//	 * @generatedBy CodePro at 15-12-16 下午2:39
//	 */
//	public static void main(String[] args) {
//		new org.junit.runner.JUnitCore().run(TransformerFactoryProxyTest.class);
//	}
//}