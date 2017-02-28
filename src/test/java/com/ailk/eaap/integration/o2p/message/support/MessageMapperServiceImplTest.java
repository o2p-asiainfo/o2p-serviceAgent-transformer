package com.ailk.eaap.integration.o2p.message.support;

import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import org.junit.*;
import static org.junit.Assert.*;
import com.ailk.eaap.integration.o2p.process.factory.TransformerProcessFactory;
import com.ailk.eaap.integration.o2p.script.jsr223.ScriptExecutorFactory;
import com.ailk.eaap.o2p.common.cache.EhCache;
import com.ailk.eaap.o2p.common.cache.ICache;
import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.ailk.eaap.op2.serviceagent.deal.service.IMessageBoHisService;
import com.ailk.eaap.op2.serviceagent.deal.service.MessageBoHisServiceImpl;
import com.ailk.eaap.op2.serviceagent.validate.service.IProtocolValidateServ;
import com.ailk.eaap.op2.serviceagent.validate.service.ProtocolValidateServ;
import com.ailk.eaap.op2.bo.ContractFormat;
import com.ailk.eaap.op2.bo.ContractFormatEx;
import com.ailk.eaap.op2.bo.NodeDesc;
import com.ailk.eaap.op2.bo.NodeDescMapper;
import com.ailk.eaap.op2.bo.NodeValReq;
import com.ailk.eaap.op2.bo.TransformerRule;

/**
 * The class <code>MessageMapperServiceImplTest</code> contains tests for the class <code>{@link MessageMapperServiceImpl}</code>.
 *
 * @generatedBy CodePro at 15-12-16 下午2:34
 * @author wuwz
 * @version $Revision: 1.0 $
 */
public class MessageMapperServiceImplTest {
	/**
	 * Run the MessageMapperServiceImpl() constructor test.
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	@Test
	public void testMessageMapperServiceImpl_1()
		throws Exception {
		MessageMapperServiceImpl result = new MessageMapperServiceImpl();
		assertNotNull(result);
		// add additional test code here
	}

	/**
	 * Run the void assertGetTarNodeValByMapper(MessageBO<?>,TransformerRule,NodeDescMapper) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	@Test
	public void testAssertGetTarNodeValByMapper_1()
		throws Exception {
		MessageMapperServiceImpl fixture = new MessageMapperServiceImpl();
		fixture.setMessageBoHisSer(new MessageBoHisServiceImpl());
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
		fixture.setProtocolValidateSer(new ProtocolValidateServ());
		fixture.setCache(new EhCache());
		MessageBO<Object> message = new MessageBO();
		TransformerRule transformerRule = new TransformerRule();
		transformerRule.setId(new Integer(1));
		NodeDescMapper nodeDescMapper = new NodeDescMapper();
		nodeDescMapper.setId(new Integer(1));
		nodeDescMapper.setTarNode(new NodeDesc());

		fixture.assertGetTarNodeValByMapper(message, transformerRule, nodeDescMapper);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.ailk.eaap.op2.serviceagent.validate.service.ProtocolValidateServ
	}

	/**
	 * Run the void debugMulti(int,ContractFormatEx) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	@Test
	public void testDebugMulti_1()
		throws Exception {
		MessageMapperServiceImpl fixture = new MessageMapperServiceImpl();
		fixture.setMessageBoHisSer(new MessageBoHisServiceImpl());
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
		fixture.setProtocolValidateSer(new ProtocolValidateServ());
		fixture.setCache(new EhCache());
		int endpointId = 1;
		ContractFormatEx contractFormat = new ContractFormatEx();

		fixture.debugMulti(endpointId, contractFormat);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.ailk.eaap.op2.serviceagent.validate.service.ProtocolValidateServ
	}

	/**
	 * Run the void debugMulti(int,ContractFormatEx) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	@Test
	public void testDebugMulti_2()
		throws Exception {
		MessageMapperServiceImpl fixture = new MessageMapperServiceImpl();
		fixture.setMessageBoHisSer(new MessageBoHisServiceImpl());
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
		fixture.setProtocolValidateSer(new ProtocolValidateServ());
		fixture.setCache(new EhCache());
		int endpointId = 1;
		ContractFormatEx contractFormat = new ContractFormatEx();

		fixture.debugMulti(endpointId, contractFormat);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.ailk.eaap.op2.serviceagent.validate.service.ProtocolValidateServ
	}

	/**
	 * Run the void debugMultiBody(MessageBO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	@Test
	public void testDebugMultiBody_1()
		throws Exception {
		MessageMapperServiceImpl fixture = new MessageMapperServiceImpl();
		fixture.setMessageBoHisSer(new MessageBoHisServiceImpl());
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
		fixture.setProtocolValidateSer(new ProtocolValidateServ());
		fixture.setCache(new EhCache());
		MessageBO hisMessageBo = new MessageBO();

		fixture.debugMultiBody(hisMessageBo);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.ailk.eaap.op2.serviceagent.validate.service.ProtocolValidateServ
	}

	/**
	 * Run the void debugMultiBody(MessageBO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	@Test
	public void testDebugMultiBody_2()
		throws Exception {
		MessageMapperServiceImpl fixture = new MessageMapperServiceImpl();
		fixture.setMessageBoHisSer(new MessageBoHisServiceImpl());
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
		fixture.setProtocolValidateSer(new ProtocolValidateServ());
		fixture.setCache(new EhCache());
		MessageBO hisMessageBo = new MessageBO();

		fixture.debugMultiBody(hisMessageBo);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.ailk.eaap.op2.serviceagent.validate.service.ProtocolValidateServ
	}

	/**
	 * Run the void debugSrcNodeDescId(NodeDesc) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	@Test
	public void testDebugSrcNodeDescId_1()
		throws Exception {
		MessageMapperServiceImpl fixture = new MessageMapperServiceImpl();
		fixture.setMessageBoHisSer(new MessageBoHisServiceImpl());
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
		fixture.setProtocolValidateSer(new ProtocolValidateServ());
		fixture.setCache(new EhCache());
		NodeDesc srcNodeDesc = new NodeDesc();
		srcNodeDesc.setNodeDescId(new Integer(1));

		fixture.debugSrcNodeDescId(srcNodeDesc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.ailk.eaap.op2.serviceagent.validate.service.ProtocolValidateServ
	}

	/**
	 * Run the void debugSrcNodeDescId(NodeDesc) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	@Test
	public void testDebugSrcNodeDescId_2()
		throws Exception {
		MessageMapperServiceImpl fixture = new MessageMapperServiceImpl();
		fixture.setMessageBoHisSer(new MessageBoHisServiceImpl());
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
		fixture.setProtocolValidateSer(new ProtocolValidateServ());
		fixture.setCache(new EhCache());
		NodeDesc srcNodeDesc = new NodeDesc();

		fixture.debugSrcNodeDescId(srcNodeDesc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.ailk.eaap.op2.serviceagent.validate.service.ProtocolValidateServ
	}

	/**
	 * Run the void debugTypeAndVal(Object,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	@Test
	public void testDebugTypeAndVal_1()
		throws Exception {
		MessageMapperServiceImpl fixture = new MessageMapperServiceImpl();
		fixture.setMessageBoHisSer(new MessageBoHisServiceImpl());
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
		fixture.setProtocolValidateSer(new ProtocolValidateServ());
		fixture.setCache(new EhCache());
		Object val = new Object();
		String conType = "";

		fixture.debugTypeAndVal(val, conType);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.ailk.eaap.op2.serviceagent.validate.service.ProtocolValidateServ
	}

	/**
	 * Run the void debugTypeAndVal(Object,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	@Test
	public void testDebugTypeAndVal_2()
		throws Exception {
		MessageMapperServiceImpl fixture = new MessageMapperServiceImpl();
		fixture.setMessageBoHisSer(new MessageBoHisServiceImpl());
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
		fixture.setProtocolValidateSer(new ProtocolValidateServ());
		fixture.setCache(new EhCache());
		Object val = new Object();
		String conType = "";

		fixture.debugTypeAndVal(val, conType);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.ailk.eaap.op2.serviceagent.validate.service.ProtocolValidateServ
	}

	/**
	 * Run the Object getAsignOrUpdate2Val(MessageBO<?>,NodeDescMapper,Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	@Test
	public void testGetAsignOrUpdate2Val_1()
		throws Exception {
		MessageMapperServiceImpl fixture = new MessageMapperServiceImpl();
		fixture.setMessageBoHisSer(new MessageBoHisServiceImpl());
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
		fixture.setProtocolValidateSer(new ProtocolValidateServ());
		fixture.setCache(new EhCache());
		MessageBO<Object> message = new MessageBO();
		NodeDescMapper nodeDescMapper = new NodeDescMapper();
		nodeDescMapper.setTarNodeValReq(new NodeValReq());
		Object val = new Object();

		Object result = fixture.getAsignOrUpdate2Val(message, nodeDescMapper, val);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.ailk.eaap.op2.serviceagent.validate.service.ProtocolValidateServ
		assertNotNull(result);
	}

	/**
	 * Run the ICache<String, Object> getCache() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	@Test
	public void testGetCache_1()
		throws Exception {
		MessageMapperServiceImpl fixture = new MessageMapperServiceImpl();
		fixture.setMessageBoHisSer(new MessageBoHisServiceImpl());
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
		fixture.setProtocolValidateSer(new ProtocolValidateServ());
		fixture.setCache(new EhCache());

		ICache<String, Object> result = fixture.getCache();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.ailk.eaap.op2.serviceagent.validate.service.ProtocolValidateServ
		assertNotNull(result);
	}

	/**
	 * Run the Object getExtractVal(NodeDescMapper,Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	@Test
	public void testGetExtractVal_1()
		throws Exception {
		MessageMapperServiceImpl fixture = new MessageMapperServiceImpl();
		fixture.setMessageBoHisSer(new MessageBoHisServiceImpl());
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
		fixture.setProtocolValidateSer(new ProtocolValidateServ());
		fixture.setCache(new EhCache());
		NodeDescMapper nodeDescMapper = new NodeDescMapper();
		nodeDescMapper.setTarNodeValReq(new NodeValReq());
		Object val = new Object();

		Object result = fixture.getExtractVal(nodeDescMapper, val);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.ailk.eaap.op2.serviceagent.validate.service.ProtocolValidateServ
		assertNotNull(result);
	}

	/**
	 * Run the Object getExtractVal(NodeDescMapper,Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	@Test
	public void testGetExtractVal_2()
		throws Exception {
		MessageMapperServiceImpl fixture = new MessageMapperServiceImpl();
		fixture.setMessageBoHisSer(new MessageBoHisServiceImpl());
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
		fixture.setProtocolValidateSer(new ProtocolValidateServ());
		fixture.setCache(new EhCache());
		NodeDescMapper nodeDescMapper = new NodeDescMapper();
		nodeDescMapper.setTarNodeValReq(new NodeValReq());
		Object val = new Object();

		Object result = fixture.getExtractVal(nodeDescMapper, val);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.ailk.eaap.op2.serviceagent.validate.service.ProtocolValidateServ
		assertNotNull(result);
	}

	/**
	 * Run the int getHisEndpointId(TransformerRule,NodeDesc,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	@Test
	public void testGetHisEndpointId_1()
		throws Exception {
		MessageMapperServiceImpl fixture = new MessageMapperServiceImpl();
		fixture.setMessageBoHisSer(new MessageBoHisServiceImpl());
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
		fixture.setProtocolValidateSer(new ProtocolValidateServ());
		fixture.setCache(new EhCache());
		TransformerRule transformerRule = new TransformerRule();
		transformerRule.setNodeDescToEndpointMap(new IdentityHashMap());
		NodeDesc srcNodeDesc = new NodeDesc();
		srcNodeDesc.setNodeDescId(new Integer(1));
		int endpointId = 1;

		int result = fixture.getHisEndpointId(transformerRule, srcNodeDesc, endpointId);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.ailk.eaap.op2.serviceagent.validate.service.ProtocolValidateServ
		assertEquals(0, result);
	}

	/**
	 * Run the int getHisEndpointId(TransformerRule,NodeDesc,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	@Test
	public void testGetHisEndpointId_2()
		throws Exception {
		MessageMapperServiceImpl fixture = new MessageMapperServiceImpl();
		fixture.setMessageBoHisSer(new MessageBoHisServiceImpl());
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
		fixture.setProtocolValidateSer(new ProtocolValidateServ());
		fixture.setCache(new EhCache());
		TransformerRule transformerRule = new TransformerRule();
		transformerRule.setNodeDescToEndpointMap(new IdentityHashMap());
		NodeDesc srcNodeDesc = new NodeDesc();
		srcNodeDesc.setNodeDescId(new Integer(1));
		int endpointId = 1;

		int result = fixture.getHisEndpointId(transformerRule, srcNodeDesc, endpointId);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.ailk.eaap.op2.serviceagent.validate.service.ProtocolValidateServ
		assertEquals(0, result);
	}

	/**
	 * Run the int getHisEndpointId(TransformerRule,NodeDesc,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	@Test
	public void testGetHisEndpointId_3()
		throws Exception {
		MessageMapperServiceImpl fixture = new MessageMapperServiceImpl();
		fixture.setMessageBoHisSer(new MessageBoHisServiceImpl());
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
		fixture.setProtocolValidateSer(new ProtocolValidateServ());
		fixture.setCache(new EhCache());
		TransformerRule transformerRule = new TransformerRule();
		transformerRule.setNodeDescToEndpointMap(new IdentityHashMap());
		NodeDesc srcNodeDesc = new NodeDesc();
		int endpointId = 1;

		int result = fixture.getHisEndpointId(transformerRule, srcNodeDesc, endpointId);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.ailk.eaap.op2.serviceagent.validate.service.ProtocolValidateServ
		assertEquals(0, result);
	}

	/**
	 * Run the IMessageBoHisService getMessageBoHisSer() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	@Test
	public void testGetMessageBoHisSer_1()
		throws Exception {
		MessageMapperServiceImpl fixture = new MessageMapperServiceImpl();
		fixture.setMessageBoHisSer(new MessageBoHisServiceImpl());
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
		fixture.setProtocolValidateSer(new ProtocolValidateServ());
		fixture.setCache(new EhCache());

		IMessageBoHisService result = fixture.getMessageBoHisSer();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.ailk.eaap.op2.serviceagent.validate.service.ProtocolValidateServ
		assertNotNull(result);
	}

	/**
	 * Run the Object getMessageBoHisVal(Object,NodeDesc,String,ContractFormatEx,MessageBO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	@Test
	public void testGetMessageBoHisVal_1()
		throws Exception {
		MessageMapperServiceImpl fixture = new MessageMapperServiceImpl();
		fixture.setMessageBoHisSer(new MessageBoHisServiceImpl());
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
		fixture.setProtocolValidateSer(new ProtocolValidateServ());
		fixture.setCache(new EhCache());
		Object val = new Object();
		NodeDesc srcNodeDesc = new NodeDesc();
		String conType = "";
		ContractFormatEx contractFormat = new ContractFormatEx();
		MessageBO hisMessageBo = new MessageBO();

		Object result = fixture.getMessageBoHisVal(val, srcNodeDesc, conType, contractFormat, hisMessageBo);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.ailk.eaap.op2.serviceagent.validate.service.ProtocolValidateServ
		assertNotNull(result);
	}

	/**
	 * Run the Object getMessageBoHisVal(Object,NodeDesc,String,ContractFormatEx,MessageBO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	@Test
	public void testGetMessageBoHisVal_2()
		throws Exception {
		MessageMapperServiceImpl fixture = new MessageMapperServiceImpl();
		fixture.setMessageBoHisSer(new MessageBoHisServiceImpl());
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
		fixture.setProtocolValidateSer(new ProtocolValidateServ());
		fixture.setCache(new EhCache());
		Object val = new Object();
		NodeDesc srcNodeDesc = new NodeDesc();
		String conType = "";
		ContractFormatEx contractFormat = new ContractFormatEx();
		MessageBO hisMessageBo = new MessageBO();

		Object result = fixture.getMessageBoHisVal(val, srcNodeDesc, conType, contractFormat, hisMessageBo);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.ailk.eaap.op2.serviceagent.validate.service.ProtocolValidateServ
		assertNotNull(result);
	}

	/**
	 * Run the Object getMessageBoHisVal(Object,NodeDesc,String,ContractFormatEx,MessageBO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	@Test
	public void testGetMessageBoHisVal_3()
		throws Exception {
		MessageMapperServiceImpl fixture = new MessageMapperServiceImpl();
		fixture.setMessageBoHisSer(new MessageBoHisServiceImpl());
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
		fixture.setProtocolValidateSer(new ProtocolValidateServ());
		fixture.setCache(new EhCache());
		Object val = new Object();
		NodeDesc srcNodeDesc = new NodeDesc();
		String conType = "";
		ContractFormatEx contractFormat = new ContractFormatEx();
		MessageBO hisMessageBo = new MessageBO();

		Object result = fixture.getMessageBoHisVal(val, srcNodeDesc, conType, contractFormat, hisMessageBo);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.ailk.eaap.op2.serviceagent.validate.service.ProtocolValidateServ
		assertNotNull(result);
	}

	/**
	 * Run the Object getMessageBoHisVal(Object,NodeDesc,String,ContractFormatEx,MessageBO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	@Test
	public void testGetMessageBoHisVal_4()
		throws Exception {
		MessageMapperServiceImpl fixture = new MessageMapperServiceImpl();
		fixture.setMessageBoHisSer(new MessageBoHisServiceImpl());
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
		fixture.setProtocolValidateSer(new ProtocolValidateServ());
		fixture.setCache(new EhCache());
		Object val = new Object();
		NodeDesc srcNodeDesc = new NodeDesc();
		String conType = "";
		ContractFormatEx contractFormat = new ContractFormatEx();
		MessageBO hisMessageBo = new MessageBO();

		Object result = fixture.getMessageBoHisVal(val, srcNodeDesc, conType, contractFormat, hisMessageBo);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.ailk.eaap.op2.serviceagent.validate.service.ProtocolValidateServ
		assertNotNull(result);
	}

	/**
	 * Run the Object getMessageBoHisVal(Object,NodeDesc,String,ContractFormatEx,MessageBO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	@Test
	public void testGetMessageBoHisVal_5()
		throws Exception {
		MessageMapperServiceImpl fixture = new MessageMapperServiceImpl();
		fixture.setMessageBoHisSer(new MessageBoHisServiceImpl());
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
		fixture.setProtocolValidateSer(new ProtocolValidateServ());
		fixture.setCache(new EhCache());
		Object val = new Object();
		NodeDesc srcNodeDesc = new NodeDesc();
		String conType = "";
		ContractFormatEx contractFormat = new ContractFormatEx();
		MessageBO hisMessageBo = new MessageBO();

		Object result = fixture.getMessageBoHisVal(val, srcNodeDesc, conType, contractFormat, hisMessageBo);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.ailk.eaap.op2.serviceagent.validate.service.ProtocolValidateServ
		assertNotNull(result);
	}

	/**
	 * Run the List<NodeDescMapper> getNodeDescMapperList(Integer) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	@Test
	public void testGetNodeDescMapperList_1()
		throws Exception {
		MessageMapperServiceImpl fixture = new MessageMapperServiceImpl();
		fixture.setMessageBoHisSer(new MessageBoHisServiceImpl());
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
		fixture.setProtocolValidateSer(new ProtocolValidateServ());
		fixture.setCache(new EhCache());
		Integer transformerRuleId = new Integer(1);

		List<NodeDescMapper> result = fixture.getNodeDescMapperList(transformerRuleId);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.ailk.eaap.op2.serviceagent.validate.service.ProtocolValidateServ
		assertNotNull(result);
	}

	/**
	 * Run the Object getNodeVal(NodeDesc) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	@Test
	public void testGetNodeVal_1()
		throws Exception {
		MessageMapperServiceImpl fixture = new MessageMapperServiceImpl();
		fixture.setMessageBoHisSer(new MessageBoHisServiceImpl());
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
		fixture.setProtocolValidateSer(new ProtocolValidateServ());
		fixture.setCache(new EhCache());
		NodeDesc tarNode = new NodeDesc();

		Object result = fixture.getNodeVal(tarNode);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.ailk.eaap.op2.serviceagent.validate.service.ProtocolValidateServ
		assertNotNull(result);
	}

	/**
	 * Run the NodeValReq getNodeValReq(NodeDesc) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	@Test
	public void testGetNodeValReq_1()
		throws Exception {
		MessageMapperServiceImpl fixture = new MessageMapperServiceImpl();
		fixture.setMessageBoHisSer(new MessageBoHisServiceImpl());
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
		fixture.setProtocolValidateSer(new ProtocolValidateServ());
		fixture.setCache(new EhCache());
		NodeDesc tarNode = new NodeDesc();

		NodeValReq result = fixture.getNodeValReq(tarNode);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.ailk.eaap.op2.serviceagent.validate.service.ProtocolValidateServ
		assertNotNull(result);
	}

	/**
	 * Run the String getOtherNodeValExpress(MessageBO<?>,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	@Test
	public void testGetOtherNodeValExpress_1()
		throws Exception {
		MessageMapperServiceImpl fixture = new MessageMapperServiceImpl();
		fixture.setMessageBoHisSer(new MessageBoHisServiceImpl());
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
		fixture.setProtocolValidateSer(new ProtocolValidateServ());
		fixture.setCache(new EhCache());
		MessageBO<Object> message = new MessageBO();
		String triggerExpress = "";

		String result = fixture.getOtherNodeValExpress(message, triggerExpress);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.ailk.eaap.op2.serviceagent.validate.service.ProtocolValidateServ
		assertNotNull(result);
	}

	/**
	 * Run the String getOtherNodeValExpress(MessageBO<?>,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	@Test
	public void testGetOtherNodeValExpress_2()
		throws Exception {
		MessageMapperServiceImpl fixture = new MessageMapperServiceImpl();
		fixture.setMessageBoHisSer(new MessageBoHisServiceImpl());
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
		fixture.setProtocolValidateSer(new ProtocolValidateServ());
		fixture.setCache(new EhCache());
		MessageBO<Object> message = new MessageBO();
		String triggerExpress = "";

		String result = fixture.getOtherNodeValExpress(message, triggerExpress);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.ailk.eaap.op2.serviceagent.validate.service.ProtocolValidateServ
		assertNotNull(result);
	}

	/**
	 * Run the String getOtherNodeValExpress(MessageBO<?>,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	@Test
	public void testGetOtherNodeValExpress_3()
		throws Exception {
		MessageMapperServiceImpl fixture = new MessageMapperServiceImpl();
		fixture.setMessageBoHisSer(new MessageBoHisServiceImpl());
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
		fixture.setProtocolValidateSer(new ProtocolValidateServ());
		fixture.setCache(new EhCache());
		MessageBO<Object> message = new MessageBO();
		String triggerExpress = "";

		String result = fixture.getOtherNodeValExpress(message, triggerExpress);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.ailk.eaap.op2.serviceagent.validate.service.ProtocolValidateServ
		assertNotNull(result);
	}

	/**
	 * Run the String getOtherNodeValExpress(MessageBO<?>,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	@Test
	public void testGetOtherNodeValExpress_4()
		throws Exception {
		MessageMapperServiceImpl fixture = new MessageMapperServiceImpl();
		fixture.setMessageBoHisSer(new MessageBoHisServiceImpl());
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
		fixture.setProtocolValidateSer(new ProtocolValidateServ());
		fixture.setCache(new EhCache());
		MessageBO<Object> message = new MessageBO();
		String triggerExpress = "";

		String result = fixture.getOtherNodeValExpress(message, triggerExpress);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.ailk.eaap.op2.serviceagent.validate.service.ProtocolValidateServ
		assertNotNull(result);
	}

	/**
	 * Run the String getOtherNodeValExpress(MessageBO<?>,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	@Test
	public void testGetOtherNodeValExpress_5()
		throws Exception {
		MessageMapperServiceImpl fixture = new MessageMapperServiceImpl();
		fixture.setMessageBoHisSer(new MessageBoHisServiceImpl());
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
		fixture.setProtocolValidateSer(new ProtocolValidateServ());
		fixture.setCache(new EhCache());
		MessageBO<Object> message = new MessageBO();
		String triggerExpress = "";

		String result = fixture.getOtherNodeValExpress(message, triggerExpress);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.ailk.eaap.op2.serviceagent.validate.service.ProtocolValidateServ
		assertNotNull(result);
	}

	/**
	 * Run the String getOtherNodeValExpress(MessageBO<?>,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	@Test
	public void testGetOtherNodeValExpress_6()
		throws Exception {
		MessageMapperServiceImpl fixture = new MessageMapperServiceImpl();
		fixture.setMessageBoHisSer(new MessageBoHisServiceImpl());
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
		fixture.setProtocolValidateSer(new ProtocolValidateServ());
		fixture.setCache(new EhCache());
		MessageBO<Object> message = new MessageBO();
		String triggerExpress = "";

		String result = fixture.getOtherNodeValExpress(message, triggerExpress);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.ailk.eaap.op2.serviceagent.validate.service.ProtocolValidateServ
		assertNotNull(result);
	}

	/**
	 * Run the String getOtherNodeValExpress(MessageBO<?>,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	@Test
	public void testGetOtherNodeValExpress_7()
		throws Exception {
		MessageMapperServiceImpl fixture = new MessageMapperServiceImpl();
		fixture.setMessageBoHisSer(new MessageBoHisServiceImpl());
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
		fixture.setProtocolValidateSer(new ProtocolValidateServ());
		fixture.setCache(new EhCache());
		MessageBO<Object> message = new MessageBO();
		String triggerExpress = "";

		String result = fixture.getOtherNodeValExpress(message, triggerExpress);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.ailk.eaap.op2.serviceagent.validate.service.ProtocolValidateServ
		assertNotNull(result);
	}

	/**
	 * Run the String getOtherNodeValExpress(MessageBO<?>,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	@Test
	public void testGetOtherNodeValExpress_8()
		throws Exception {
		MessageMapperServiceImpl fixture = new MessageMapperServiceImpl();
		fixture.setMessageBoHisSer(new MessageBoHisServiceImpl());
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
		fixture.setProtocolValidateSer(new ProtocolValidateServ());
		fixture.setCache(new EhCache());
		MessageBO<Object> message = new MessageBO();
		String triggerExpress = "";

		String result = fixture.getOtherNodeValExpress(message, triggerExpress);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.ailk.eaap.op2.serviceagent.validate.service.ProtocolValidateServ
		assertNotNull(result);
	}

	/**
	 * Run the IProtocolValidateServ getProtocolValidateSer() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	@Test
	public void testGetProtocolValidateSer_1()
		throws Exception {
		MessageMapperServiceImpl fixture = new MessageMapperServiceImpl();
		fixture.setMessageBoHisSer(new MessageBoHisServiceImpl());
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
		fixture.setProtocolValidateSer(new ProtocolValidateServ());
		fixture.setCache(new EhCache());

		IProtocolValidateServ result = fixture.getProtocolValidateSer();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ExceptionInInitializerError
		//       at org.apache.log4j.Logger.getLogger(Logger.java:107)
		//       at com.ailk.eaap.op2.serviceagent.validate.service.ProtocolValidateServ.<clinit>(ProtocolValidateServ.java:35)
		assertNotNull(result);
	}

	/**
	 * Run the ScriptExecutorFactory getScriptExecutorFactory() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	@Test
	public void testGetScriptExecutorFactory_1()
		throws Exception {
		MessageMapperServiceImpl fixture = new MessageMapperServiceImpl();
		fixture.setMessageBoHisSer(new MessageBoHisServiceImpl());
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
		fixture.setProtocolValidateSer(new ProtocolValidateServ());
		fixture.setCache(new EhCache());

		ScriptExecutorFactory result = fixture.getScriptExecutorFactory();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.ailk.eaap.op2.serviceagent.validate.service.ProtocolValidateServ
		assertNotNull(result);
	}

	/**
	 * Run the Object getTarNodeValByMapper(MessageBO<?>,TransformerRule,NodeDescMapper) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	@Test
	public void testGetTarNodeValByMapper_1()
		throws Exception {
		MessageMapperServiceImpl fixture = new MessageMapperServiceImpl();
		fixture.setMessageBoHisSer(new MessageBoHisServiceImpl());
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
		fixture.setProtocolValidateSer(new ProtocolValidateServ());
		fixture.setCache(new EhCache());
		MessageBO<Object> message = new MessageBO();
		TransformerRule transformerRule = new TransformerRule();
		transformerRule.setSrcContractFormat(new ContractFormat());
		NodeDescMapper nodeDescMapper = new NodeDescMapper();
		nodeDescMapper.setSrcNode(new NodeDesc());
		nodeDescMapper.setOperTypeCd("");

		Object result = fixture.getTarNodeValByMapper(message, transformerRule, nodeDescMapper);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.ailk.eaap.op2.serviceagent.validate.service.ProtocolValidateServ
		assertNotNull(result);
	}

	/**
	 * Run the Object getTarNodeValByMapper(MessageBO<?>,TransformerRule,NodeDescMapper) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	@Test
	public void testGetTarNodeValByMapper_2()
		throws Exception {
		MessageMapperServiceImpl fixture = new MessageMapperServiceImpl();
		fixture.setMessageBoHisSer(new MessageBoHisServiceImpl());
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
		fixture.setProtocolValidateSer(new ProtocolValidateServ());
		fixture.setCache(new EhCache());
		MessageBO<Object> message = new MessageBO();
		TransformerRule transformerRule = new TransformerRule();
		transformerRule.setSrcContractFormat(new ContractFormat());
		NodeDescMapper nodeDescMapper = new NodeDescMapper();
		nodeDescMapper.setSrcNode(new NodeDesc());
		nodeDescMapper.setOperTypeCd("");

		Object result = fixture.getTarNodeValByMapper(message, transformerRule, nodeDescMapper);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.ailk.eaap.op2.serviceagent.validate.service.ProtocolValidateServ
		assertNotNull(result);
	}

	/**
	 * Run the TransformerProcessFactory getTransformerProcessFactory() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	@Test
	public void testGetTransformerProcessFactory_1()
		throws Exception {
		MessageMapperServiceImpl fixture = new MessageMapperServiceImpl();
		fixture.setMessageBoHisSer(new MessageBoHisServiceImpl());
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
		fixture.setProtocolValidateSer(new ProtocolValidateServ());
		fixture.setCache(new EhCache());

		TransformerProcessFactory result = fixture.getTransformerProcessFactory();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.ailk.eaap.op2.serviceagent.validate.service.ProtocolValidateServ
		assertNotNull(result);
	}

	/**
	 * Run the ContractFormatEx judgeContractFormat(TransformerRule,NodeDesc,ContractFormatEx) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	@Test
	public void testJudgeContractFormat_1()
		throws Exception {
		MessageMapperServiceImpl fixture = new MessageMapperServiceImpl();
		fixture.setMessageBoHisSer(new MessageBoHisServiceImpl());
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
		fixture.setProtocolValidateSer(new ProtocolValidateServ());
		fixture.setCache(new EhCache());
		TransformerRule transformerRule = new TransformerRule();
		transformerRule.setNodeDescToContractFormatMap(new IdentityHashMap());
		NodeDesc srcNodeDesc = new NodeDesc();
		srcNodeDesc.setNodeDescId(new Integer(1));
		ContractFormatEx contractFormat = new ContractFormatEx();

		ContractFormatEx result = fixture.judgeContractFormat(transformerRule, srcNodeDesc, contractFormat);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.ailk.eaap.op2.serviceagent.validate.service.ProtocolValidateServ
		assertNotNull(result);
	}

	/**
	 * Run the ContractFormatEx judgeContractFormat(TransformerRule,NodeDesc,ContractFormatEx) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	@Test
	public void testJudgeContractFormat_2()
		throws Exception {
		MessageMapperServiceImpl fixture = new MessageMapperServiceImpl();
		fixture.setMessageBoHisSer(new MessageBoHisServiceImpl());
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
		fixture.setProtocolValidateSer(new ProtocolValidateServ());
		fixture.setCache(new EhCache());
		TransformerRule transformerRule = new TransformerRule();
		transformerRule.setNodeDescToContractFormatMap(new IdentityHashMap());
		NodeDesc srcNodeDesc = new NodeDesc();
		ContractFormatEx contractFormat = new ContractFormatEx();

		ContractFormatEx result = fixture.judgeContractFormat(transformerRule, srcNodeDesc, contractFormat);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.ailk.eaap.op2.serviceagent.validate.service.ProtocolValidateServ
		assertNotNull(result);
	}

	/**
	 * Run the void judgeMessageNodes() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	@Test
	public void testJudgeMessageNodes_1()
		throws Exception {
		MessageMapperServiceImpl fixture = new MessageMapperServiceImpl();
		fixture.setMessageBoHisSer(new MessageBoHisServiceImpl());
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
		fixture.setProtocolValidateSer(new ProtocolValidateServ());
		fixture.setCache(new EhCache());

		fixture.judgeMessageNodes();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.ailk.eaap.op2.serviceagent.validate.service.ProtocolValidateServ
	}

	/**
	 * Run the void judgeMessageNodes() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	@Test
	public void testJudgeMessageNodes_2()
		throws Exception {
		MessageMapperServiceImpl fixture = new MessageMapperServiceImpl();
		fixture.setMessageBoHisSer(new MessageBoHisServiceImpl());
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
		fixture.setProtocolValidateSer(new ProtocolValidateServ());
		fixture.setCache(new EhCache());

		fixture.judgeMessageNodes();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.ailk.eaap.op2.serviceagent.validate.service.ProtocolValidateServ
	}

	/**
	 * Run the Object ognlParse(MessageBO<?>,NodeValReq,Object,Object,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	@Test
	public void testOgnlParse_1()
		throws Exception {
		MessageMapperServiceImpl fixture = new MessageMapperServiceImpl();
		fixture.setMessageBoHisSer(new MessageBoHisServiceImpl());
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
		fixture.setProtocolValidateSer(new ProtocolValidateServ());
		fixture.setCache(new EhCache());
		MessageBO<Object> message = new MessageBO();
		NodeValReq nodeValReq = new NodeValReq();
		nodeValReq.setScript("");
		Object srcNodeVal = new Object();
		Object val = new Object();
		String express = "";

		Object result = fixture.ognlParse(message, nodeValReq, srcNodeVal, val, express);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.ailk.eaap.op2.serviceagent.validate.service.ProtocolValidateServ
		assertNotNull(result);
	}

	/**
	 * Run the Object ognlParse(MessageBO<?>,NodeValReq,Object,Object,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	@Test
	public void testOgnlParse_2()
		throws Exception {
		MessageMapperServiceImpl fixture = new MessageMapperServiceImpl();
		fixture.setMessageBoHisSer(new MessageBoHisServiceImpl());
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
		fixture.setProtocolValidateSer(new ProtocolValidateServ());
		fixture.setCache(new EhCache());
		MessageBO<Object> message = new MessageBO();
		NodeValReq nodeValReq = new NodeValReq();
		nodeValReq.setScript("");
		Object srcNodeVal = new Object();
		Object val = new Object();
		String express = "";

		Object result = fixture.ognlParse(message, nodeValReq, srcNodeVal, val, express);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.ailk.eaap.op2.serviceagent.validate.service.ProtocolValidateServ
		assertNotNull(result);
	}

	/**
	 * Run the Object ognlParse(MessageBO<?>,NodeValReq,Object,Object,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	@Test
	public void testOgnlParse_3()
		throws Exception {
		MessageMapperServiceImpl fixture = new MessageMapperServiceImpl();
		fixture.setMessageBoHisSer(new MessageBoHisServiceImpl());
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
		fixture.setProtocolValidateSer(new ProtocolValidateServ());
		fixture.setCache(new EhCache());
		MessageBO<Object> message = new MessageBO();
		NodeValReq nodeValReq = new NodeValReq();
		Object srcNodeVal = new Object();
		Object val = new Object();
		String express = "";

		Object result = fixture.ognlParse(message, nodeValReq, srcNodeVal, val, express);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.ailk.eaap.op2.serviceagent.validate.service.ProtocolValidateServ
		assertNotNull(result);
	}

	/**
	 * Run the Object ognlParse(MessageBO<?>,NodeValReq,Object,Object,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	@Test
	public void testOgnlParse_4()
		throws Exception {
		MessageMapperServiceImpl fixture = new MessageMapperServiceImpl();
		fixture.setMessageBoHisSer(new MessageBoHisServiceImpl());
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
		fixture.setProtocolValidateSer(new ProtocolValidateServ());
		fixture.setCache(new EhCache());
		MessageBO<Object> message = new MessageBO();
		NodeValReq nodeValReq = new NodeValReq();
		nodeValReq.setValueExpress("");
		Object srcNodeVal = new Object();
		Object val = new Object();
		String express = "";

		Object result = fixture.ognlParse(message, nodeValReq, srcNodeVal, val, express);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.ailk.eaap.op2.serviceagent.validate.service.ProtocolValidateServ
		assertNotNull(result);
	}

	/**
	 * Run the Object ognlParse(MessageBO<?>,NodeValReq,Object,Object,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	@Test
	public void testOgnlParse_5()
		throws Exception {
		MessageMapperServiceImpl fixture = new MessageMapperServiceImpl();
		fixture.setMessageBoHisSer(new MessageBoHisServiceImpl());
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
		fixture.setProtocolValidateSer(new ProtocolValidateServ());
		fixture.setCache(new EhCache());
		MessageBO<Object> message = new MessageBO();
		NodeValReq nodeValReq = new NodeValReq();
		nodeValReq.setNodeDescId(new Integer(1));
		nodeValReq.setScript("");
		Object srcNodeVal = new Object();
		Object val = new Object();
		String express = "";

		Object result = fixture.ognlParse(message, nodeValReq, srcNodeVal, val, express);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.ailk.eaap.op2.serviceagent.validate.service.ProtocolValidateServ
		assertNotNull(result);
	}

	/**
	 * Run the Object ognlParse(MessageBO<?>,NodeValReq,Object,Object,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	@Test
	public void testOgnlParse_6()
		throws Exception {
		MessageMapperServiceImpl fixture = new MessageMapperServiceImpl();
		fixture.setMessageBoHisSer(new MessageBoHisServiceImpl());
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
		fixture.setProtocolValidateSer(new ProtocolValidateServ());
		fixture.setCache(new EhCache());
		MessageBO<Object> message = new MessageBO();
		NodeValReq nodeValReq = new NodeValReq();
		nodeValReq.setNodeDescId(new Integer(1));
		Object srcNodeVal = new Object();
		Object val = new Object();
		String express = "";

		Object result = fixture.ognlParse(message, nodeValReq, srcNodeVal, val, express);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.ailk.eaap.op2.serviceagent.validate.service.ProtocolValidateServ
		assertNotNull(result);
	}

	/**
	 * Run the Object ognlParse(MessageBO<?>,NodeValReq,Object,Object,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	@Test
	public void testOgnlParse_7()
		throws Exception {
		MessageMapperServiceImpl fixture = new MessageMapperServiceImpl();
		fixture.setMessageBoHisSer(new MessageBoHisServiceImpl());
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
		fixture.setProtocolValidateSer(new ProtocolValidateServ());
		fixture.setCache(new EhCache());
		MessageBO<Object> message = new MessageBO();
		NodeValReq nodeValReq = new NodeValReq();
		nodeValReq.setScript("");
		Object srcNodeVal = new Object();
		Object val = new Object();
		String express = "";

		Object result = fixture.ognlParse(message, nodeValReq, srcNodeVal, val, express);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.ailk.eaap.op2.serviceagent.validate.service.ProtocolValidateServ
		assertNotNull(result);
	}

	/**
	 * Run the Object ognlParse(MessageBO<?>,NodeValReq,Object,Object,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	@Test
	public void testOgnlParse_8()
		throws Exception {
		MessageMapperServiceImpl fixture = new MessageMapperServiceImpl();
		fixture.setMessageBoHisSer(new MessageBoHisServiceImpl());
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
		fixture.setProtocolValidateSer(new ProtocolValidateServ());
		fixture.setCache(new EhCache());
		MessageBO<Object> message = new MessageBO();
		NodeValReq nodeValReq = new NodeValReq();
		nodeValReq.setNodeDescId(new Integer(1));
		nodeValReq.setScript("");
		Object srcNodeVal = new Object();
		Object val = new Object();
		String express = "";

		Object result = fixture.ognlParse(message, nodeValReq, srcNodeVal, val, express);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.ailk.eaap.op2.serviceagent.validate.service.ProtocolValidateServ
		assertNotNull(result);
	}

	/**
	 * Run the Object ognlParse(MessageBO<?>,NodeValReq,Object,Object,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	@Test
	public void testOgnlParse_9()
		throws Exception {
		MessageMapperServiceImpl fixture = new MessageMapperServiceImpl();
		fixture.setMessageBoHisSer(new MessageBoHisServiceImpl());
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
		fixture.setProtocolValidateSer(new ProtocolValidateServ());
		fixture.setCache(new EhCache());
		MessageBO<Object> message = new MessageBO();
		NodeValReq nodeValReq = new NodeValReq();
		nodeValReq.setNodeDescId(new Integer(1));
		nodeValReq.setScript("");
		Object srcNodeVal = new Object();
		Object val = new Object();
		String express = "";

		Object result = fixture.ognlParse(message, nodeValReq, srcNodeVal, val, express);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.ailk.eaap.op2.serviceagent.validate.service.ProtocolValidateServ
		assertNotNull(result);
	}

	/**
	 * Run the MessageBO reqOrRspMessageBoHis(int,String,MessageBO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	@Test
	public void testReqOrRspMessageBoHis_1()
		throws Exception {
		MessageMapperServiceImpl fixture = new MessageMapperServiceImpl();
		fixture.setMessageBoHisSer(new MessageBoHisServiceImpl());
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
		fixture.setProtocolValidateSer(new ProtocolValidateServ());
		fixture.setCache(new EhCache());
		int endpointId = 1;
		String reqRsp = "RSP";
		MessageBO hisMessageBo = new MessageBO();

		MessageBO result = fixture.reqOrRspMessageBoHis(endpointId, reqRsp, hisMessageBo);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.ailk.eaap.op2.serviceagent.validate.service.ProtocolValidateServ
		assertNotNull(result);
	}

	/**
	 * Run the MessageBO reqOrRspMessageBoHis(int,String,MessageBO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	@Test
	public void testReqOrRspMessageBoHis_2()
		throws Exception {
		MessageMapperServiceImpl fixture = new MessageMapperServiceImpl();
		fixture.setMessageBoHisSer(new MessageBoHisServiceImpl());
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
		fixture.setProtocolValidateSer(new ProtocolValidateServ());
		fixture.setCache(new EhCache());
		int endpointId = 1;
		String reqRsp = "";
		MessageBO hisMessageBo = new MessageBO();

		MessageBO result = fixture.reqOrRspMessageBoHis(endpointId, reqRsp, hisMessageBo);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.ailk.eaap.op2.serviceagent.validate.service.ProtocolValidateServ
		assertNotNull(result);
	}

	/**
	 * Run the MessageBO reqOrRspMessageBoHis(int,String,MessageBO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	@Test
	public void testReqOrRspMessageBoHis_3()
		throws Exception {
		MessageMapperServiceImpl fixture = new MessageMapperServiceImpl();
		fixture.setMessageBoHisSer(new MessageBoHisServiceImpl());
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
		fixture.setProtocolValidateSer(new ProtocolValidateServ());
		fixture.setCache(new EhCache());
		int endpointId = 1;
		String reqRsp = "REQ";
		MessageBO hisMessageBo = new MessageBO();

		MessageBO result = fixture.reqOrRspMessageBoHis(endpointId, reqRsp, hisMessageBo);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.ailk.eaap.op2.serviceagent.validate.service.ProtocolValidateServ
		assertNotNull(result);
	}

	/**
	 * Run the void setCache(ICache<String,Object>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	@Test
	public void testSetCache_1()
		throws Exception {
		MessageMapperServiceImpl fixture = new MessageMapperServiceImpl();
		fixture.setMessageBoHisSer(new MessageBoHisServiceImpl());
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
		fixture.setProtocolValidateSer(new ProtocolValidateServ());
		fixture.setCache(new EhCache());
		ICache<String, Object> cache = new EhCache();

		fixture.setCache(cache);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.ailk.eaap.op2.serviceagent.validate.service.ProtocolValidateServ
	}

	/**
	 * Run the void setMessageBoHisSer(IMessageBoHisService) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	@Test
	public void testSetMessageBoHisSer_1()
		throws Exception {
		MessageMapperServiceImpl fixture = new MessageMapperServiceImpl();
		fixture.setMessageBoHisSer(new MessageBoHisServiceImpl());
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
		fixture.setProtocolValidateSer(new ProtocolValidateServ());
		fixture.setCache(new EhCache());
		IMessageBoHisService messageBoHisSer = new MessageBoHisServiceImpl();

		fixture.setMessageBoHisSer(messageBoHisSer);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.ailk.eaap.op2.serviceagent.validate.service.ProtocolValidateServ
	}

	/**
	 * Run the void setProtocolValidateSer(IProtocolValidateServ) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	@Test
	public void testSetProtocolValidateSer_1()
		throws Exception {
		MessageMapperServiceImpl fixture = new MessageMapperServiceImpl();
		fixture.setMessageBoHisSer(new MessageBoHisServiceImpl());
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
		fixture.setProtocolValidateSer(new ProtocolValidateServ());
		fixture.setCache(new EhCache());
		IProtocolValidateServ protocolValidateSer = new ProtocolValidateServ();

		fixture.setProtocolValidateSer(protocolValidateSer);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.ailk.eaap.op2.serviceagent.validate.service.ProtocolValidateServ
	}

	/**
	 * Run the void setScriptExecutorFactory(ScriptExecutorFactory) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:34
	 */
	@Test
	public void testSetScriptExecutorFactory_1()
		throws Exception {
		MessageMapperServiceImpl fixture = new MessageMapperServiceImpl();
		fixture.setMessageBoHisSer(new MessageBoHisServiceImpl());
		fixture.setScriptExecutorFactory(new ScriptExecutorFactory());
		fixture.setProtocolValidateSer(new ProtocolValidateServ());
		fixture.setCache(new EhCache());
		ScriptExecutorFactory scriptExecutorFactory = new ScriptExecutorFactory();

		fixture.setScriptExecutorFactory(scriptExecutorFactory);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.ailk.eaap.op2.serviceagent.validate.service.ProtocolValidateServ
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
		new org.junit.runner.JUnitCore().run(MessageMapperServiceImplTest.class);
	}
}