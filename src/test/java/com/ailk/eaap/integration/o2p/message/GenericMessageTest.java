package com.ailk.eaap.integration.o2p.message;

import java.util.IdentityHashMap;
import java.util.Map;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>GenericMessageTest</code> contains tests for the class <code>{@link GenericMessage}</code>.
 *
 * @generatedBy CodePro at 15-12-16 下午2:33
 * @author wuwz
 * @version $Revision: 1.0 $
 */
public class GenericMessageTest {
	/**
	 * Run the GenericMessage(T,Map<String,Object>) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:33
	 */
	@Test
	public void testGenericMessage_1()
		throws Exception {
		Map<String, Object> headers = null;

		GenericMessage result = new GenericMessage(null, headers);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: payload must not be null
		//       at org.springframework.util.Assert.notNull(Assert.java:112)
		//       at com.ailk.eaap.integration.o2p.message.GenericMessage.<init>(GenericMessage.java:24)
		assertNotNull(result);
	}

	/**
	 * Run the GenericMessage(T,Map<String,Object>) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:33
	 */
	@Test
	public void testGenericMessage_2()
		throws Exception {
		Map<String, Object> headers = new IdentityHashMap();

		GenericMessage result = new GenericMessage(null, headers);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: payload must not be null
		//       at org.springframework.util.Assert.notNull(Assert.java:112)
		//       at com.ailk.eaap.integration.o2p.message.GenericMessage.<init>(GenericMessage.java:24)
		assertNotNull(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:33
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		GenericMessage fixture = new GenericMessage((Object) null, new IdentityHashMap());
		Object obj = new GenericMessage((Object) null, new IdentityHashMap());

		boolean result = fixture.equals(obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: payload must not be null
		//       at org.springframework.util.Assert.notNull(Assert.java:112)
		//       at com.ailk.eaap.integration.o2p.message.GenericMessage.<init>(GenericMessage.java:24)
		assertTrue(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:33
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		GenericMessage fixture = new GenericMessage((Object) null, new IdentityHashMap());
		Object obj = new GenericMessage((Object) null, new IdentityHashMap());

		boolean result = fixture.equals(obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: payload must not be null
		//       at org.springframework.util.Assert.notNull(Assert.java:112)
		//       at com.ailk.eaap.integration.o2p.message.GenericMessage.<init>(GenericMessage.java:24)
		assertTrue(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:33
	 */
	@Test
	public void testEquals_3()
		throws Exception {
		GenericMessage fixture = new GenericMessage((Object) null, new IdentityHashMap());
		Object obj = new GenericMessage((Object) null, new IdentityHashMap());

		boolean result = fixture.equals(obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: payload must not be null
		//       at org.springframework.util.Assert.notNull(Assert.java:112)
		//       at com.ailk.eaap.integration.o2p.message.GenericMessage.<init>(GenericMessage.java:24)
		assertTrue(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:33
	 */
	@Test
	public void testEquals_4()
		throws Exception {
		GenericMessage fixture = new GenericMessage((Object) null, new IdentityHashMap());
		Object obj = new GenericMessage((Object) null, new IdentityHashMap());

		boolean result = fixture.equals(obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: payload must not be null
		//       at org.springframework.util.Assert.notNull(Assert.java:112)
		//       at com.ailk.eaap.integration.o2p.message.GenericMessage.<init>(GenericMessage.java:24)
		assertTrue(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:33
	 */
	@Test
	public void testEquals_5()
		throws Exception {
		GenericMessage fixture = new GenericMessage((Object) null, new IdentityHashMap());
		Object obj = new GenericMessage((Object) null, new IdentityHashMap());

		boolean result = fixture.equals(obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: payload must not be null
		//       at org.springframework.util.Assert.notNull(Assert.java:112)
		//       at com.ailk.eaap.integration.o2p.message.GenericMessage.<init>(GenericMessage.java:24)
		assertTrue(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:33
	 */
	@Test
	public void testEquals_6()
		throws Exception {
		GenericMessage fixture = new GenericMessage((Object) null, new IdentityHashMap());
		Object obj = new Object();

		boolean result = fixture.equals(obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: payload must not be null
		//       at org.springframework.util.Assert.notNull(Assert.java:112)
		//       at com.ailk.eaap.integration.o2p.message.GenericMessage.<init>(GenericMessage.java:24)
		assertTrue(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:33
	 */
	@Test
	public void testEquals_7()
		throws Exception {
		GenericMessage fixture = new GenericMessage((Object) null, new IdentityHashMap());
		Object obj = null;

		boolean result = fixture.equals(obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: payload must not be null
		//       at org.springframework.util.Assert.notNull(Assert.java:112)
		//       at com.ailk.eaap.integration.o2p.message.GenericMessage.<init>(GenericMessage.java:24)
		assertTrue(result);
	}

	/**
	 * Run the Map<String, Object> getHeaders() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:33
	 */
	@Test
	public void testGetHeaders_1()
		throws Exception {
		GenericMessage fixture = new GenericMessage((Object) null, new IdentityHashMap());

		Map<String, Object> result = fixture.getHeaders();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: payload must not be null
		//       at org.springframework.util.Assert.notNull(Assert.java:112)
		//       at com.ailk.eaap.integration.o2p.message.GenericMessage.<init>(GenericMessage.java:24)
		assertNotNull(result);
	}

	/**
	 * Run the Object getPayload() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:33
	 */
	@Test
	public void testGetPayload_1()
		throws Exception {
		GenericMessage fixture = new GenericMessage((Object) null, new IdentityHashMap());

		Object result = fixture.getPayload();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: payload must not be null
		//       at org.springframework.util.Assert.notNull(Assert.java:112)
		//       at com.ailk.eaap.integration.o2p.message.GenericMessage.<init>(GenericMessage.java:24)
		assertNotNull(result);
	}

	/**
	 * Run the int hashcode(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:33
	 */
	@Test
	public void testHashcode_1()
		throws Exception {
		GenericMessage fixture = new GenericMessage((Object) null, new IdentityHashMap());
		Object obj = null;

		int result = fixture.hashcode(obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: payload must not be null
		//       at org.springframework.util.Assert.notNull(Assert.java:112)
		//       at com.ailk.eaap.integration.o2p.message.GenericMessage.<init>(GenericMessage.java:24)
		assertEquals(0, result);
	}

	/**
	 * Run the int hashcode(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:33
	 */
	@Test
	public void testHashcode_2()
		throws Exception {
		GenericMessage fixture = new GenericMessage((Object) null, new IdentityHashMap());
		Object obj = new Object();

		int result = fixture.hashcode(obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: payload must not be null
		//       at org.springframework.util.Assert.notNull(Assert.java:112)
		//       at com.ailk.eaap.integration.o2p.message.GenericMessage.<init>(GenericMessage.java:24)
		assertEquals(0, result);
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:33
	 */
	@Test
	public void testToString_1()
		throws Exception {
		GenericMessage fixture = new GenericMessage((Object) null, new IdentityHashMap());

		String result = fixture.toString();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: payload must not be null
		//       at org.springframework.util.Assert.notNull(Assert.java:112)
		//       at com.ailk.eaap.integration.o2p.message.GenericMessage.<init>(GenericMessage.java:24)
		assertNotNull(result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:33
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
	 * @generatedBy CodePro at 15-12-16 下午2:33
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
	 * @generatedBy CodePro at 15-12-16 下午2:33
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(GenericMessageTest.class);
	}
}