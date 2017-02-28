package com.ailk.eaap.integration.o2p.transformer;

import java.util.LinkedList;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;
import com.ailk.eaap.integration.o2p.contractbody.service.ContractAdapterEndpointServiceImpl;
import com.ailk.eaap.integration.o2p.contractbody.service.IContractAdapterEndpointService;
import com.ailk.eaap.integration.o2p.message.support.MessageMapperService;
import com.ailk.eaap.integration.o2p.message.support.MessageMapperServiceImpl;
import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.ailk.eaap.op2.bo.ContractFormat;
import com.ailk.eaap.op2.bo.ContractFormatEx;
import com.ailk.eaap.op2.bo.NodeDescMapper;
import com.ailk.eaap.op2.bo.TransformerRule;

/**
 * The class <code>DefaultTransformerTest</code> contains tests for the class <code>{@link DefaultTransformer}</code>.
 *
 * @generatedBy CodePro at 15-12-16 下午2:41
 * @author wuwz
 * @version $Revision: 1.0 $
 */
public class DefaultTransformerTest {
	/**
	 * Run the DefaultTransformer() constructor test.
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:41
	 */
	@Test
	public void testDefaultTransformer_1()
		throws Exception {
		DefaultTransformer result = new DefaultTransformer();
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
		DefaultTransformer fixture = new DefaultTransformer();
		fixture.setMessageMapperService(new MessageMapperServiceImpl());
		fixture.setContractAdapterEndpointSer(new ContractAdapterEndpointServiceImpl());
		fixture.setVerHorTransformer(new VerHorTransformer());
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
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testBeforeTransform_1()
		throws Exception {
		DefaultTransformer fixture = new DefaultTransformer();
		fixture.setMessageMapperService(new MessageMapperServiceImpl());
		fixture.setContractAdapterEndpointSer(new ContractAdapterEndpointServiceImpl());
		fixture.setVerHorTransformer(new VerHorTransformer());
		MessageBO<Object> message = new MessageBO();
		TransformerRule transformerRule = new TransformerRule();
		transformerRule.setNodeDescMappers(new LinkedList());
		transformerRule.setId(new Integer(1));
		transformerRule.setSrcContractFormat(new ContractFormat());
		transformerRule.setTarContractFormat(new ContractFormatEx());

		Object result = fixture.beforeTransform(message, transformerRule);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the Object beforeTransform(MessageBO<?>,TransformerRule) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:41
	 */
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testBeforeTransform_2()
		throws Exception {
		DefaultTransformer fixture = new DefaultTransformer();
		fixture.setMessageMapperService(new MessageMapperServiceImpl());
		fixture.setContractAdapterEndpointSer(new ContractAdapterEndpointServiceImpl());
		fixture.setVerHorTransformer(new VerHorTransformer());
		MessageBO<Object> message = new MessageBO();
		TransformerRule transformerRule = new TransformerRule();
		transformerRule.setNodeDescMappers(new LinkedList());
		transformerRule.setId(new Integer(1));
		transformerRule.setSrcContractFormat(new ContractFormat());
		transformerRule.setTarContractFormat(new ContractFormatEx());

		Object result = fixture.beforeTransform(message, transformerRule);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the Object beforeTransform(MessageBO<?>,TransformerRule) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:41
	 */
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testBeforeTransform_3()
		throws Exception {
		DefaultTransformer fixture = new DefaultTransformer();
		fixture.setMessageMapperService(new MessageMapperServiceImpl());
		fixture.setContractAdapterEndpointSer(new ContractAdapterEndpointServiceImpl());
		fixture.setVerHorTransformer(new VerHorTransformer());
		MessageBO<Object> message = new MessageBO();
		TransformerRule transformerRule = new TransformerRule();
		transformerRule.setNodeDescMappers(new LinkedList());
		transformerRule.setId(new Integer(1));
		transformerRule.setSrcContractFormat(new ContractFormat());
		transformerRule.setTarContractFormat(new ContractFormatEx());

		Object result = fixture.beforeTransform(message, transformerRule);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the Object beforeTransform(MessageBO<?>,TransformerRule) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:41
	 */
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testBeforeTransform_4()
		throws Exception {
		DefaultTransformer fixture = new DefaultTransformer();
		fixture.setMessageMapperService(new MessageMapperServiceImpl());
		fixture.setContractAdapterEndpointSer(new ContractAdapterEndpointServiceImpl());
		fixture.setVerHorTransformer(new VerHorTransformer());
		MessageBO<Object> message = new MessageBO();
		TransformerRule transformerRule = new TransformerRule();
		transformerRule.setNodeDescMappers(new LinkedList());
		transformerRule.setId(new Integer(1));
		transformerRule.setSrcContractFormat(new ContractFormat());
		transformerRule.setTarContractFormat(new ContractFormatEx());

		Object result = fixture.beforeTransform(message, transformerRule);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the Object beforeTransform(MessageBO<?>,TransformerRule) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:41
	 */
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testBeforeTransform_5()
		throws Exception {
		DefaultTransformer fixture = new DefaultTransformer();
		fixture.setMessageMapperService(new MessageMapperServiceImpl());
		fixture.setContractAdapterEndpointSer(new ContractAdapterEndpointServiceImpl());
		fixture.setVerHorTransformer(new VerHorTransformer());
		MessageBO<Object> message = new MessageBO();
		TransformerRule transformerRule = new TransformerRule();
		transformerRule.setNodeDescMappers(new LinkedList());
		transformerRule.setId(new Integer(1));
		transformerRule.setSrcContractFormat(new ContractFormat());
		transformerRule.setTarContractFormat(new ContractFormatEx());

		Object result = fixture.beforeTransform(message, transformerRule);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the Object beforeTransform(MessageBO<?>,TransformerRule) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:41
	 */
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testBeforeTransform_6()
		throws Exception {
		DefaultTransformer fixture = new DefaultTransformer();
		fixture.setMessageMapperService(new MessageMapperServiceImpl());
		fixture.setContractAdapterEndpointSer(new ContractAdapterEndpointServiceImpl());
		fixture.setVerHorTransformer(new VerHorTransformer());
		MessageBO<Object> message = new MessageBO();
		TransformerRule transformerRule = new TransformerRule();
		transformerRule.setNodeDescMappers(new LinkedList());
		transformerRule.setId(new Integer(1));
		transformerRule.setSrcContractFormat(new ContractFormat());
		transformerRule.setTarContractFormat(new ContractFormatEx());

		Object result = fixture.beforeTransform(message, transformerRule);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the Object beforeTransform(MessageBO<?>,TransformerRule) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:41
	 */
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testBeforeTransform_7()
		throws Exception {
		DefaultTransformer fixture = new DefaultTransformer();
		fixture.setMessageMapperService(new MessageMapperServiceImpl());
		fixture.setContractAdapterEndpointSer(new ContractAdapterEndpointServiceImpl());
		fixture.setVerHorTransformer(new VerHorTransformer());
		MessageBO<Object> message = new MessageBO();
		TransformerRule transformerRule = new TransformerRule();
		transformerRule.setNodeDescMappers(new LinkedList());
		transformerRule.setId(new Integer(1));
		transformerRule.setSrcContractFormat(new ContractFormat());
		transformerRule.setTarContractFormat(new ContractFormatEx());

		Object result = fixture.beforeTransform(message, transformerRule);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the Object beforeTransform(MessageBO<?>,TransformerRule) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:41
	 */
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testBeforeTransform_8()
		throws Exception {
		DefaultTransformer fixture = new DefaultTransformer();
		fixture.setMessageMapperService(new MessageMapperServiceImpl());
		fixture.setContractAdapterEndpointSer(new ContractAdapterEndpointServiceImpl());
		fixture.setVerHorTransformer(new VerHorTransformer());
		MessageBO<Object> message = new MessageBO();
		TransformerRule transformerRule = new TransformerRule();
		transformerRule.setNodeDescMappers(new LinkedList());
		transformerRule.setId(new Integer(1));
		transformerRule.setSrcContractFormat(new ContractFormat());
		transformerRule.setTarContractFormat(new ContractFormatEx());

		Object result = fixture.beforeTransform(message, transformerRule);

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
	public void testDoTransform_1()
		throws Exception {
		DefaultTransformer fixture = new DefaultTransformer();
		fixture.setMessageMapperService(new MessageMapperServiceImpl());
		fixture.setContractAdapterEndpointSer(new ContractAdapterEndpointServiceImpl());
		fixture.setVerHorTransformer(new VerHorTransformer());
		MessageBO<Object> message = new MessageBO();
		TransformerRule transformerRule = new TransformerRule();
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
	 * @generatedBy CodePro at 15-12-16 下午2:41
	 */
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testDoTransform_2()
		throws Exception {
		DefaultTransformer fixture = new DefaultTransformer();
		fixture.setMessageMapperService(new MessageMapperServiceImpl());
		fixture.setContractAdapterEndpointSer(new ContractAdapterEndpointServiceImpl());
		fixture.setVerHorTransformer(new VerHorTransformer());
		MessageBO<Object> message = new MessageBO();
		TransformerRule transformerRule = new TransformerRule();
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
	 * @generatedBy CodePro at 15-12-16 下午2:41
	 */
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testDoTransform_3()
		throws Exception {
		DefaultTransformer fixture = new DefaultTransformer();
		fixture.setMessageMapperService(new MessageMapperServiceImpl());
		fixture.setContractAdapterEndpointSer(new ContractAdapterEndpointServiceImpl());
		fixture.setVerHorTransformer(new VerHorTransformer());
		MessageBO<Object> message = new MessageBO();
		TransformerRule transformerRule = new TransformerRule();
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
	 * @generatedBy CodePro at 15-12-16 下午2:41
	 */
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testDoTransform_4()
		throws Exception {
		DefaultTransformer fixture = new DefaultTransformer();
		fixture.setMessageMapperService(new MessageMapperServiceImpl());
		fixture.setContractAdapterEndpointSer(new ContractAdapterEndpointServiceImpl());
		fixture.setVerHorTransformer(new VerHorTransformer());
		MessageBO<Object> message = new MessageBO();
		TransformerRule transformerRule = new TransformerRule();
		transformerRule.setTransformerType(new Integer(1));
		transformerRule.setTarContractFormat(new ContractFormatEx());

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
	public void testDoTransform_5()
		throws Exception {
		DefaultTransformer fixture = new DefaultTransformer();
		fixture.setMessageMapperService(new MessageMapperServiceImpl());
		fixture.setContractAdapterEndpointSer(new ContractAdapterEndpointServiceImpl());
		fixture.setVerHorTransformer(new VerHorTransformer());
		MessageBO<Object> message = new MessageBO();
		TransformerRule transformerRule = new TransformerRule();
		transformerRule.setTransformerType(new Integer(1));
		transformerRule.setTarContractFormat(new ContractFormatEx());

		Object result = fixture.doTransform(message, transformerRule);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the IContractAdapterEndpointService getContractAdapterEndpointSer() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:41
	 */
	@Test
	public void testGetContractAdapterEndpointSer_1()
		throws Exception {
		DefaultTransformer fixture = new DefaultTransformer();
		fixture.setMessageMapperService(new MessageMapperServiceImpl());
		fixture.setContractAdapterEndpointSer(new ContractAdapterEndpointServiceImpl());
		fixture.setVerHorTransformer(new VerHorTransformer());

		IContractAdapterEndpointService result = fixture.getContractAdapterEndpointSer();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the void setContractAdapterEndpointSer(IContractAdapterEndpointService) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:41
	 */
	@Test
	public void testSetContractAdapterEndpointSer_1()
		throws Exception {
		DefaultTransformer fixture = new DefaultTransformer();
		fixture.setMessageMapperService(new MessageMapperServiceImpl());
		fixture.setContractAdapterEndpointSer(new ContractAdapterEndpointServiceImpl());
		fixture.setVerHorTransformer(new VerHorTransformer());
		IContractAdapterEndpointService contractAdapterEndpointSer = new ContractAdapterEndpointServiceImpl();

		fixture.setContractAdapterEndpointSer(contractAdapterEndpointSer);

		// add additional test code here
	}

	/**
	 * Run the void setMessageMapperService(MessageMapperService) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:41
	 */
	@Test
	public void testSetMessageMapperService_1()
		throws Exception {
		DefaultTransformer fixture = new DefaultTransformer();
		fixture.setMessageMapperService(new MessageMapperServiceImpl());
		fixture.setContractAdapterEndpointSer(new ContractAdapterEndpointServiceImpl());
		fixture.setVerHorTransformer(new VerHorTransformer());
		MessageMapperService messageMapperService = new MessageMapperServiceImpl();

		fixture.setMessageMapperService(messageMapperService);

		// add additional test code here
	}

	/**
	 * Run the void setVerHorTransformer(VerHorTransformer) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:41
	 */
	@Test
	public void testSetVerHorTransformer_1()
		throws Exception {
		DefaultTransformer fixture = new DefaultTransformer();
		fixture.setMessageMapperService(new MessageMapperServiceImpl());
		fixture.setContractAdapterEndpointSer(new ContractAdapterEndpointServiceImpl());
		fixture.setVerHorTransformer(new VerHorTransformer());
		VerHorTransformer verHorTransformer = new VerHorTransformer();

		fixture.setVerHorTransformer(verHorTransformer);

		// add additional test code here
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
		new org.junit.runner.JUnitCore().run(DefaultTransformerTest.class);
	}
}