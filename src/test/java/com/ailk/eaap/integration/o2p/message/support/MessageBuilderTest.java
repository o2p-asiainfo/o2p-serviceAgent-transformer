package com.ailk.eaap.integration.o2p.message.support;

import org.junit.*;
import static org.junit.Assert.*;
import com.ailk.eaap.op2.serviceagent.common.MessageBO;

/**
 * The class <code>MessageBuilderTest</code> contains tests for the class <code>{@link MessageBuilder}</code>.
 *
 * @generatedBy CodePro at 15-12-16 下午2:34
 * @author wuwz
 * @version $Revision: 1.0 $
 */
public class MessageBuilderTest {
	/**
	 * Run the MessageBO<Object> build() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	@Test
	public void testBuild_1()
		throws Exception {
		MessageBuilder fixture = MessageBuilder.fromMessage(new MessageBO());

		MessageBO<Object> result = fixture.build();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: payload must not be null
		//       at org.springframework.util.Assert.notNull(Assert.java:112)
		//       at com.ailk.eaap.integration.o2p.message.support.MessageBuilder.<init>(MessageBuilder.java:22)
		//       at com.ailk.eaap.integration.o2p.message.support.MessageBuilder.fromMessage(MessageBuilder.java:31)
		assertNotNull(result);
	}

	/**
	 * Run the MessageBuilder<Object> fromMessage(MessageBO<T>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	@Test
	public void testFromMessage_1()
		throws Exception {
		MessageBO<Object> message = new MessageBO();

		MessageBuilder<Object> result = MessageBuilder.fromMessage(message);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: payload must not be null
		//       at org.springframework.util.Assert.notNull(Assert.java:112)
		//       at com.ailk.eaap.integration.o2p.message.support.MessageBuilder.<init>(MessageBuilder.java:22)
		//       at com.ailk.eaap.integration.o2p.message.support.MessageBuilder.fromMessage(MessageBuilder.java:31)
		assertNotNull(result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
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
	 * @generatedBy CodePro at 15-12-16 下午2:34
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
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(MessageBuilderTest.class);
	}
}