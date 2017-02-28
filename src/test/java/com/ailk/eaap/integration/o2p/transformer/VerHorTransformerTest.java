package com.ailk.eaap.integration.o2p.transformer;

import java.util.LinkedList;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;
import com.ailk.eaap.integration.o2p.message.support.MessageMapperService;
import com.ailk.eaap.integration.o2p.message.support.MessageMapperServiceImpl;
import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.ailk.eaap.op2.bo.MessageDesc;
import com.ailk.eaap.op2.bo.MessageNode;
import com.ailk.eaap.op2.bo.NodeDesc;
import com.ailk.eaap.op2.bo.NodeDescMapper;
import com.ailk.eaap.op2.bo.TransformerRule;

/**
 * The class <code>VerHorTransformerTest</code> contains tests for the class <code>{@link VerHorTransformer}</code>.
 *
 * @generatedBy CodePro at 15-12-16 下午2:40
 * @author wuwz
 * @version $Revision: 1.0 $
 */
public class VerHorTransformerTest {
	/**
	 * Run the VerHorTransformer() constructor test.
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:40
	 */
	@Test
	public void testVerHorTransformer_1()
		throws Exception {
		VerHorTransformer result = new VerHorTransformer();
		assertNotNull(result);
		// add additional test code here
	}

	/**
	 * Run the boolean isHor2Ver(String,List<MessageNode>,MessageBO<?>,List<NodeDescMapper>,MessageDesc,TransformerRule,NodeDescMapper) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:40
	 */
	@Test
	public void testIsHor2Ver_1()
		throws Exception {
		VerHorTransformer fixture = new VerHorTransformer();
		fixture.setMessageMapperService(new MessageMapperServiceImpl());
		String actionTypeCd = "H";
		List<MessageNode> list = new LinkedList();
		MessageBO<Object> message = new MessageBO();
		List<NodeDescMapper> nodeMappers = new LinkedList();
		MessageDesc messageDesc = new MessageDesc();
		TransformerRule transformerRule = new TransformerRule();
		NodeDescMapper nodeMapper = new NodeDescMapper();
		nodeMapper.setSrcNode(new NodeDesc());

		boolean result = fixture.isHor2Ver(actionTypeCd, list, message, nodeMappers, messageDesc, transformerRule, nodeMapper);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean isHor2Ver(String,List<MessageNode>,MessageBO<?>,List<NodeDescMapper>,MessageDesc,TransformerRule,NodeDescMapper) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:40
	 */
	@Test
	public void testIsHor2Ver_2()
		throws Exception {
		VerHorTransformer fixture = new VerHorTransformer();
		fixture.setMessageMapperService(new MessageMapperServiceImpl());
		String actionTypeCd = "H";
		List<MessageNode> list = new LinkedList();
		MessageBO<Object> message = new MessageBO();
		List<NodeDescMapper> nodeMappers = new LinkedList();
		MessageDesc messageDesc = new MessageDesc();
		TransformerRule transformerRule = new TransformerRule();
		NodeDescMapper nodeMapper = new NodeDescMapper();
		nodeMapper.setSrcNode(new NodeDesc());

		boolean result = fixture.isHor2Ver(actionTypeCd, list, message, nodeMappers, messageDesc, transformerRule, nodeMapper);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean isHor2Ver(String,List<MessageNode>,MessageBO<?>,List<NodeDescMapper>,MessageDesc,TransformerRule,NodeDescMapper) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:40
	 */
	@Test
	public void testIsHor2Ver_3()
		throws Exception {
		VerHorTransformer fixture = new VerHorTransformer();
		fixture.setMessageMapperService(new MessageMapperServiceImpl());
		String actionTypeCd = "";
		List<MessageNode> list = new LinkedList();
		MessageBO<Object> message = new MessageBO();
		List<NodeDescMapper> nodeMappers = new LinkedList();
		MessageDesc messageDesc = new MessageDesc();
		TransformerRule transformerRule = new TransformerRule();
		NodeDescMapper nodeMapper = new NodeDescMapper();

		boolean result = fixture.isHor2Ver(actionTypeCd, list, message, nodeMappers, messageDesc, transformerRule, nodeMapper);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean isVer2Hor(String,List<MessageNode>,MessageBO<?>,List<NodeDescMapper>,MessageDesc,TransformerRule,NodeDescMapper) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:40
	 */
	@Test
	public void testIsVer2Hor_1()
		throws Exception {
		VerHorTransformer fixture = new VerHorTransformer();
		fixture.setMessageMapperService(new MessageMapperServiceImpl());
		String actionTypeCd = "Z";
		List<MessageNode> list = new LinkedList();
		MessageBO<Object> message = new MessageBO();
		List<NodeDescMapper> nodeMappers = new LinkedList();
		MessageDesc messageDesc = new MessageDesc();
		TransformerRule transformerRule = new TransformerRule();
		NodeDescMapper nodeMapper = new NodeDescMapper();
		nodeMapper.setSrcNode(new NodeDesc());

		boolean result = fixture.isVer2Hor(actionTypeCd, list, message, nodeMappers, messageDesc, transformerRule, nodeMapper);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean isVer2Hor(String,List<MessageNode>,MessageBO<?>,List<NodeDescMapper>,MessageDesc,TransformerRule,NodeDescMapper) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:40
	 */
	@Test
	public void testIsVer2Hor_2()
		throws Exception {
		VerHorTransformer fixture = new VerHorTransformer();
		fixture.setMessageMapperService(new MessageMapperServiceImpl());
		String actionTypeCd = "Z";
		List<MessageNode> list = new LinkedList();
		MessageBO<Object> message = new MessageBO();
		List<NodeDescMapper> nodeMappers = new LinkedList();
		MessageDesc messageDesc = new MessageDesc();
		TransformerRule transformerRule = new TransformerRule();
		NodeDescMapper nodeMapper = new NodeDescMapper();
		nodeMapper.setSrcNode(new NodeDesc());

		boolean result = fixture.isVer2Hor(actionTypeCd, list, message, nodeMappers, messageDesc, transformerRule, nodeMapper);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean isVer2Hor(String,List<MessageNode>,MessageBO<?>,List<NodeDescMapper>,MessageDesc,TransformerRule,NodeDescMapper) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:40
	 */
	@Test
	public void testIsVer2Hor_3()
		throws Exception {
		VerHorTransformer fixture = new VerHorTransformer();
		fixture.setMessageMapperService(new MessageMapperServiceImpl());
		String actionTypeCd = "";
		List<MessageNode> list = new LinkedList();
		MessageBO<Object> message = new MessageBO();
		List<NodeDescMapper> nodeMappers = new LinkedList();
		MessageDesc messageDesc = new MessageDesc();
		TransformerRule transformerRule = new TransformerRule();
		NodeDescMapper nodeMapper = new NodeDescMapper();

		boolean result = fixture.isVer2Hor(actionTypeCd, list, message, nodeMappers, messageDesc, transformerRule, nodeMapper);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the void setMessageMapperService(MessageMapperService) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:40
	 */
	@Test
	public void testSetMessageMapperService_1()
		throws Exception {
		VerHorTransformer fixture = new VerHorTransformer();
		fixture.setMessageMapperService(new MessageMapperServiceImpl());
		MessageMapperService messageMapperService = new MessageMapperServiceImpl();

		fixture.setMessageMapperService(messageMapperService);

		// add additional test code here
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
		new org.junit.runner.JUnitCore().run(VerHorTransformerTest.class);
	}
}