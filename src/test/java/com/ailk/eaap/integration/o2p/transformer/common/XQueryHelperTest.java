package com.ailk.eaap.integration.o2p.transformer.common;

import java.util.IdentityHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.dom4j.dom.DOMDocument;
import org.junit.*;
import static org.junit.Assert.*;
import org.w3c.dom.Document;
import com.ailk.eaap.op2.bo.ParamVarMap;
import com.ailk.eaap.op2.bo.TransformerRule;

/**
 * The class <code>XQueryHelperTest</code> contains tests for the class <code>{@link XQueryHelper}</code>.
 *
 * @generatedBy CodePro at 15-12-16 下午2:45
 * @author wuwz
 * @version $Revision: 1.0 $
 */
public class XQueryHelperTest {
	/**
	 * Run the XQueryHelper() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:45
	 */
	@Test
	public void testXQueryHelper_1()
		throws Exception {

		XQueryHelper result = new XQueryHelper();

		// add additional test code here
		assertNotNull(result);
		assertEquals("", result.getNamespace());
		assertEquals(null, result.getNamespaces());
		assertEquals(null, result.getDocument());
	}

	/**
	 * Run the Document getDocument() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:45
	 */
	@Test
	public void testGetDocument_1()
		throws Exception {
		XQueryHelper fixture = new XQueryHelper();
		fixture.setNamespaces(new IdentityHashMap());
		fixture.setDocument(new DOMDocument());

		Document result = fixture.getDocument();

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getDoctype());
		assertEquals(null, result.getDocumentElement());
		assertEquals(null, result.getAttributes());
		assertEquals(null, result.getPrefix());
		assertEquals(null, result.getLocalName());
		assertEquals(null, result.getNamespaceURI());
		assertEquals(null, result.getNextSibling());
		assertEquals("#document", result.getNodeName());
		assertEquals((short) 9, result.getNodeType());
		assertEquals(null, result.getNodeValue());
		assertEquals(null, result.getOwnerDocument());
		assertEquals(null, result.getParentNode());
		assertEquals(null, result.getPreviousSibling());
		assertEquals(false, result.hasAttributes());
		assertEquals(false, result.hasChildNodes());
	}

	/**
	 * Run the String getNamespace() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:45
	 */
	@Test
	public void testGetNamespace_1()
		throws Exception {
		XQueryHelper fixture = new XQueryHelper();
		fixture.setNamespaces(new IdentityHashMap());
		fixture.setDocument(new DOMDocument());

		String result = fixture.getNamespace();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the Map<String, String> getNamespaces() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:45
	 */
	@Test
	public void testGetNamespaces_1()
		throws Exception {
		XQueryHelper fixture = new XQueryHelper();
		fixture.setNamespaces(new IdentityHashMap());
		fixture.setDocument(new DOMDocument());

		Map<String, String> result = fixture.getNamespaces();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the Map<String, Object> getVariables() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:45
	 */
	@Test
	public void testGetVariables_1()
		throws Exception {
		XQueryHelper fixture = new XQueryHelper();
		fixture.setNamespaces(new IdentityHashMap());
		fixture.setDocument(new DOMDocument());

		Map<String, Object> result = fixture.getVariables();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the void init() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:45
	 */
	@Test
	public void testInit_1()
		throws Exception {
		XQueryHelper fixture = new XQueryHelper();
		fixture.setNamespaces(new IdentityHashMap());
		fixture.setDocument(new DOMDocument());

		fixture.init();

		// add additional test code here
	}

	/**
	 * Run the void setDocument(Document) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:45
	 */
	@Test
	public void testSetDocument_1()
		throws Exception {
		XQueryHelper fixture = new XQueryHelper();
		fixture.setNamespaces(new IdentityHashMap());
		fixture.setDocument(new DOMDocument());
		Document document = new DOMDocument();

		fixture.setDocument(document);

		// add additional test code here
	}

	/**
	 * Run the void setNamespace(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:45
	 */
	@Test
	public void testSetNamespace_1()
		throws Exception {
		XQueryHelper fixture = new XQueryHelper();
		fixture.setNamespaces(new IdentityHashMap());
		fixture.setDocument(new DOMDocument());
		String namespace = "";

		fixture.setNamespace(namespace);

		// add additional test code here
	}

	/**
	 * Run the void setNamespaces(Map<String,String>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:45
	 */
	@Test
	public void testSetNamespaces_1()
		throws Exception {
		XQueryHelper fixture = new XQueryHelper();
		fixture.setNamespaces(new IdentityHashMap());
		fixture.setDocument(new DOMDocument());
		Map<String, String> namespaces = new IdentityHashMap();

		fixture.setNamespaces(namespaces);

		// add additional test code here
	}

	/**
	 * Run the Object xQueryExecuteByMethod(XQueryHelper,TransformerRule) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:45
	 */
	@Test
	public void testXQueryExecuteByMethod_1()
		throws Exception {
		XQueryHelper fixture = new XQueryHelper();
		fixture.setNamespaces(new IdentityHashMap());
		fixture.setDocument(new DOMDocument());
		XQueryHelper xquery = new XQueryHelper();
		TransformerRule rule = new TransformerRule();
		rule.setScriptContent("");
		rule.setParamVarMaps(new LinkedList());

		Object result = fixture.xQueryExecuteByMethod(xquery, rule);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the Object xQueryExecuteByMethod(XQueryHelper,TransformerRule) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:45
	 */
	@Test
	public void testXQueryExecuteByMethod_2()
		throws Exception {
		XQueryHelper fixture = new XQueryHelper();
		fixture.setNamespaces(new IdentityHashMap());
		fixture.setDocument(new DOMDocument());
		XQueryHelper xquery = new XQueryHelper();
		TransformerRule rule = new TransformerRule();
		rule.setScriptContent("");
		rule.setParamVarMaps(new LinkedList());

		Object result = fixture.xQueryExecuteByMethod(xquery, rule);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the Object xQueryExecuteByMethod(XQueryHelper,TransformerRule) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:45
	 */
	@Test
	public void testXQueryExecuteByMethod_3()
		throws Exception {
		XQueryHelper fixture = new XQueryHelper();
		fixture.setNamespaces(new IdentityHashMap());
		fixture.setDocument(new DOMDocument());
		XQueryHelper xquery = new XQueryHelper();
		TransformerRule rule = new TransformerRule();
		rule.setScriptContent("");
		rule.setParamVarMaps(new LinkedList());

		Object result = fixture.xQueryExecuteByMethod(xquery, rule);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the Object xQueryExecuteByMethod(XQueryHelper,TransformerRule) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:45
	 */
	@Test
	public void testXQueryExecuteByMethod_4()
		throws Exception {
		XQueryHelper fixture = new XQueryHelper();
		fixture.setNamespaces(new IdentityHashMap());
		fixture.setDocument(new DOMDocument());
		XQueryHelper xquery = new XQueryHelper();
		TransformerRule rule = new TransformerRule();
		rule.setScriptContent("");
		rule.setParamVarMaps(new LinkedList());

		Object result = fixture.xQueryExecuteByMethod(xquery, rule);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the Object xQueryExecuteByMethod(XQueryHelper,TransformerRule) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:45
	 */
	@Test
	public void testXQueryExecuteByMethod_5()
		throws Exception {
		XQueryHelper fixture = new XQueryHelper();
		fixture.setNamespaces(new IdentityHashMap());
		fixture.setDocument(new DOMDocument());
		XQueryHelper xquery = new XQueryHelper();
		TransformerRule rule = new TransformerRule();
		rule.setScriptContent("");
		rule.setParamVarMaps(new LinkedList());

		Object result = fixture.xQueryExecuteByMethod(xquery, rule);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the Object xQueryExecuteByMethod(XQueryHelper,TransformerRule) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:45
	 */
	@Test
	public void testXQueryExecuteByMethod_6()
		throws Exception {
		XQueryHelper fixture = new XQueryHelper();
		fixture.setNamespaces(new IdentityHashMap());
		fixture.setDocument(new DOMDocument());
		XQueryHelper xquery = new XQueryHelper();
		TransformerRule rule = new TransformerRule();
		rule.setScriptContent("");
		rule.setParamVarMaps(new LinkedList());

		Object result = fixture.xQueryExecuteByMethod(xquery, rule);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the Object xQueryExecuteByMethod(XQueryHelper,TransformerRule) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:45
	 */
	@Test
	public void testXQueryExecuteByMethod_7()
		throws Exception {
		XQueryHelper fixture = new XQueryHelper();
		fixture.setNamespaces(new IdentityHashMap());
		fixture.setDocument(new DOMDocument());
		XQueryHelper xquery = new XQueryHelper();
		TransformerRule rule = new TransformerRule();
		rule.setScriptContent("");
		rule.setParamVarMaps(new LinkedList());

		Object result = fixture.xQueryExecuteByMethod(xquery, rule);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the Object xQueryExecuteByMethod(XQueryHelper,TransformerRule) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:45
	 */
	@Test
	public void testXQueryExecuteByMethod_8()
		throws Exception {
		XQueryHelper fixture = new XQueryHelper();
		fixture.setNamespaces(new IdentityHashMap());
		fixture.setDocument(new DOMDocument());
		XQueryHelper xquery = new XQueryHelper();
		TransformerRule rule = new TransformerRule();
		rule.setScriptContent("");
		rule.setParamVarMaps(new LinkedList());

		Object result = fixture.xQueryExecuteByMethod(xquery, rule);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the Object xQueryExecuteByMethod(XQueryHelper,TransformerRule) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:45
	 */
	@Test
	public void testXQueryExecuteByMethod_9()
		throws Exception {
		XQueryHelper fixture = new XQueryHelper();
		fixture.setNamespaces(new IdentityHashMap());
		fixture.setDocument(new DOMDocument());
		XQueryHelper xquery = new XQueryHelper();
		TransformerRule rule = new TransformerRule();
		rule.setScriptContent("");
		rule.setParamVarMaps(new LinkedList());

		Object result = fixture.xQueryExecuteByMethod(xquery, rule);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the Object xQueryExecuteByMethod(XQueryHelper,TransformerRule) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:45
	 */
	@Test
	public void testXQueryExecuteByMethod_10()
		throws Exception {
		XQueryHelper fixture = new XQueryHelper();
		fixture.setNamespaces(new IdentityHashMap());
		fixture.setDocument(new DOMDocument());
		XQueryHelper xquery = new XQueryHelper();
		TransformerRule rule = new TransformerRule();
		rule.setScriptContent("");
		rule.setParamVarMaps(new LinkedList());

		Object result = fixture.xQueryExecuteByMethod(xquery, rule);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the Object xQueryExecuteByMethod(XQueryHelper,TransformerRule) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:45
	 */
	@Test
	public void testXQueryExecuteByMethod_11()
		throws Exception {
		XQueryHelper fixture = new XQueryHelper();
		fixture.setNamespaces(new IdentityHashMap());
		fixture.setDocument(new DOMDocument());
		XQueryHelper xquery = new XQueryHelper();
		TransformerRule rule = new TransformerRule();
		rule.setScriptContent("");
		rule.setParamVarMaps(new LinkedList());

		Object result = fixture.xQueryExecuteByMethod(xquery, rule);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the Object xQueryExecuteByMethod(XQueryHelper,TransformerRule) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:45
	 */
	@Test
	public void testXQueryExecuteByMethod_12()
		throws Exception {
		XQueryHelper fixture = new XQueryHelper();
		fixture.setNamespaces(new IdentityHashMap());
		fixture.setDocument(new DOMDocument());
		XQueryHelper xquery = new XQueryHelper();
		TransformerRule rule = new TransformerRule();
		rule.setScriptContent("");
		rule.setParamVarMaps(new LinkedList());

		Object result = fixture.xQueryExecuteByMethod(xquery, rule);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the Object xQueryExecuteByMethod(XQueryHelper,TransformerRule) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:45
	 */
	@Test
	public void testXQueryExecuteByMethod_13()
		throws Exception {
		XQueryHelper fixture = new XQueryHelper();
		fixture.setNamespaces(new IdentityHashMap());
		fixture.setDocument(new DOMDocument());
		XQueryHelper xquery = new XQueryHelper();
		TransformerRule rule = new TransformerRule();
		rule.setScriptContent("");
		rule.setParamVarMaps(new LinkedList());

		Object result = fixture.xQueryExecuteByMethod(xquery, rule);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the Object xQueryExecuteByMethod(XQueryHelper,TransformerRule) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:45
	 */
	@Test
	public void testXQueryExecuteByMethod_14()
		throws Exception {
		XQueryHelper fixture = new XQueryHelper();
		fixture.setNamespaces(new IdentityHashMap());
		fixture.setDocument(new DOMDocument());
		XQueryHelper xquery = new XQueryHelper();
		TransformerRule rule = new TransformerRule();
		rule.setScriptContent("");
		rule.setParamVarMaps(new LinkedList());

		Object result = fixture.xQueryExecuteByMethod(xquery, rule);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the Object xQueryExecuteByMethod(XQueryHelper,TransformerRule) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:45
	 */
	@Test
	public void testXQueryExecuteByMethod_15()
		throws Exception {
		XQueryHelper fixture = new XQueryHelper();
		fixture.setNamespaces(new IdentityHashMap());
		fixture.setDocument(new DOMDocument());
		XQueryHelper xquery = new XQueryHelper();
		TransformerRule rule = new TransformerRule();
		rule.setScriptContent("");
		rule.setParamVarMaps(new LinkedList());

		Object result = fixture.xQueryExecuteByMethod(xquery, rule);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:45
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
	 * @generatedBy CodePro at 15-12-16 下午2:45
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
	 * @generatedBy CodePro at 15-12-16 下午2:45
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(XQueryHelperTest.class);
	}
}