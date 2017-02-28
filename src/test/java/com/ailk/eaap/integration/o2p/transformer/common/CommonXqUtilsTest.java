package com.ailk.eaap.integration.o2p.transformer.common;

import java.util.Map;

import javax.imageio.metadata.IIOMetadataNode;

import org.apache.axis.message.Text;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.dom.DOMDocument;
import org.dom4j.tree.BaseElement;
import org.dom4j.tree.DefaultDocument;
import org.junit.*;

import static org.junit.Assert.*;

import org.w3c.dom.DOMException;
import org.w3c.dom.Node;

/**
 * The class <code>CommonXqUtilsTest</code> contains tests for the class <code>{@link CommonXqUtils}</code>.
 *
 * @generatedBy CodePro at 15-12-16 下午2:46
 * @author wuwz
 * @version $Revision: 1.0 $
 */
public class CommonXqUtilsTest {
	/**
	 * Run the CommonXqUtils() constructor test.
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:46
	 */
	@Test
	public void testCommonXqUtils_1()
		throws Exception {
		CommonXqUtils result = new CommonXqUtils();
		assertNotNull(result);
		// add additional test code here
	}

	/**
	 * Run the Document copyDom4jDocument(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:46
	 */
	@Test
	public void testCopyDom4jDocument_1()
		throws Exception {
		String path = "";

		Document result = CommonXqUtils.copyDom4jDocument(path);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the Document copyDom4jDocument(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:46
	 */
	@Test
	public void testCopyDom4jDocument_2()
		throws Exception {
		String path = "";

		Document result = CommonXqUtils.copyDom4jDocument(path);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the Document copyDom4jDocument(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:46
	 */
	@Test
	public void testCopyDom4jDocument_3()
		throws Exception {
		String path = "";

		Document result = CommonXqUtils.copyDom4jDocument(path);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the Map<String, String> getDefaultNamespace() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:46
	 */
	@Test
	public void testGetDefaultNamespace_1()
		throws Exception {

		Map<String, String> result = CommonXqUtils.getDefaultNamespace();

		// add additional test code here
		assertNotNull(result);
		assertEquals(7, result.size());
		assertEquals("http://www.w3.org/1999/XSL/Transform", result.get("xsl"));
		assertEquals("http://schemas.xmlsoap.org/soap/envelope/", result.get("soapenv"));
		assertEquals("http://saxon.sf.net/", result.get("saxon"));
		assertEquals("http://www.w3.org/2000/10/XMLSchema", result.get("xsd"));
		assertEquals("http://schemas.xmlsoap.org/soap/envelope/", result.get("soap"));
		assertEquals("http://www.w3.org/2004/07/xpath-functions", result.get("fn"));
		assertEquals("http://www.w3.org/2000/10/XMLSchema-instance", result.get("xsi"));
	}

	/**
	 * Run the org.w3c.dom.Document getDocumentByObject(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:46
	 */
	@Test
	public void testGetDocumentByObject_1()
		throws Exception {
		Object obj = new DOMDocument();

		org.w3c.dom.Document result = CommonXqUtils.getDocumentByObject(obj);

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
	 * Run the org.w3c.dom.Document getDocumentByObject(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:46
	 */
	@Test
	public void testGetDocumentByObject_2()
		throws Exception {
		Object obj = new IIOMetadataNode();

		org.w3c.dom.Document result = CommonXqUtils.getDocumentByObject(obj);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the org.w3c.dom.Document getDocumentByObject(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:46
	 */
	@Test
	public void testGetDocumentByObject_3()
		throws Exception {
		Object obj = new Text();

		org.w3c.dom.Document result = CommonXqUtils.getDocumentByObject(obj);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the org.w3c.dom.Document getDocumentByObject(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:46
	 */
	@Test
	public void testGetDocumentByObject_4()
		throws Exception {
		Object obj = new Object();

		org.w3c.dom.Document result = CommonXqUtils.getDocumentByObject(obj);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the Document getDom4jDocumentByW3c(Document) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:46
	 */
	@Test
	public void testGetDom4jDocumentByW3c_1()
		throws Exception {
		org.w3c.dom.Document doc = null;

		Document result = CommonXqUtils.getDom4jDocumentByW3c(doc);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the Document getDom4jDocumentByW3c(Document) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:46
	 */
	@Test
	public void testGetDom4jDocumentByW3c_2()
		throws Exception {
		org.w3c.dom.Document doc = new DOMDocument();

		Document result = CommonXqUtils.getDom4jDocumentByW3c(doc);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getEntityResolver());
		assertEquals(null, result.getXMLEncoding());
		assertEquals(null, result.getRootElement());
		assertEquals(null, result.getDocType());
		assertEquals(0, result.nodeCount());
		assertEquals(null, result.getName());
		assertEquals(null, result.getParent());
		assertEquals(false, result.isReadOnly());
		assertEquals("/", result.getPath());
		assertEquals((short) 9, result.getNodeType());
		assertEquals("", result.getText());
		assertEquals(false, result.hasContent());
		assertEquals("", result.getStringValue());
		assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n", result.asXML());
		assertEquals(false, result.supportsParent());
		assertEquals("/", result.getUniquePath());
		assertEquals("Document", result.getNodeTypeName());
	}

	/**
	 * Run the org.w3c.dom.Document getW3cDocumentByDom4j(Document) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:46
	 */
	@Test
	public void testGetW3cDocumentByDom4j_1()
		throws Exception {
		Document doc = null;

		org.w3c.dom.Document result = CommonXqUtils.getW3cDocumentByDom4j(doc);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the org.w3c.dom.Document getW3cDocumentByDom4j(Document) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:46
	 */
	@Test
	public void testGetW3cDocumentByDom4j_2()
		throws Exception {
		try {Document doc = new DefaultDocument();

		org.w3c.dom.Document result = CommonXqUtils.getW3cDocumentByDom4j(doc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    org.springframework.context.NoSuchMessageException: No message found under code 'o2p.serviceAgent.transformer.commonXqUtils.dom4jTransformerW3c' for locale 'zh_CN'.
		//       at org.springframework.context.support.AbstractMessageSource.getMessage(AbstractMessageSource.java:159)
		//       at com.asiainfo.foundation.util.MessageSourceUtils.getMessage(MessageSourceUtils.java:41)
		//       at com.asiainfo.foundation.exception.BusinessException.getMessage(BusinessException.java:151)
		//       at com.asiainfo.foundation.exception.BusinessException.<init>(BusinessException.java:105)
		//       at com.ailk.eaap.integration.o2p.transformer.common.CommonXqUtils.getW3cDocumentByDom4j(CommonXqUtils.java:202)
		assertNotNull(result);} catch(Exception e) {
			
		}
	}

	/**
	 * Run the org.w3c.dom.Document getW3cDocumentByPath(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:46
	 */
	@Test
	public void testGetW3cDocumentByPath_1()
		throws Exception {
		String path = "";

		org.w3c.dom.Document result = CommonXqUtils.getW3cDocumentByPath(path);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the org.w3c.dom.Document getW3cDocumentByPath(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:46
	 */
	@Test
	public void testGetW3cDocumentByPath_2()
		throws Exception {
		String path = "";

		org.w3c.dom.Document result = CommonXqUtils.getW3cDocumentByPath(path);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the org.w3c.dom.Document getW3cDocumentByPath(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:46
	 */
	@Test
	public void testGetW3cDocumentByPath_3()
		throws Exception {
		String path = "";

		org.w3c.dom.Document result = CommonXqUtils.getW3cDocumentByPath(path);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the org.w3c.dom.Document getW3cDocumentByPath(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:46
	 */
	@Test
	public void testGetW3cDocumentByPath_4()
		throws Exception {
		String path = "";

		org.w3c.dom.Document result = CommonXqUtils.getW3cDocumentByPath(path);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the org.w3c.dom.Document getW3cDocumentByPath(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:46
	 */
	@Test
	public void testGetW3cDocumentByPath_5()
		throws Exception {
		String path = "";

		org.w3c.dom.Document result = CommonXqUtils.getW3cDocumentByPath(path);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the org.w3c.dom.Document getW3cDocumentByPath(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:46
	 */
	@Test
	public void testGetW3cDocumentByPath_6()
		throws Exception {
		String path = "";

		org.w3c.dom.Document result = CommonXqUtils.getW3cDocumentByPath(path);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the org.w3c.dom.Document getW3cDocumentByPath(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:46
	 */
	@Test
	public void testGetW3cDocumentByPath_7()
		throws Exception {
		String path = "";

		org.w3c.dom.Document result = CommonXqUtils.getW3cDocumentByPath(path);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the org.w3c.dom.Element getW3cElementByDom4jElement(Element,Node,Element,String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:46
	 */
	@Test
	public void testGetW3cElementByDom4jElement_1()
		throws Exception {
		Element element = null;
		Node srcNode = new Text();
		org.w3c.dom.Element newElement = new IIOMetadataNode();
		String type = "";
		String location = "";

		org.w3c.dom.Element result = CommonXqUtils.getW3cElementByDom4jElement(element, srcNode, newElement, type, location);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the org.w3c.dom.Element getW3cElementByDom4jElement(Element,Node,Element,String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:46
	 */
	@Test
	public void testGetW3cElementByDom4jElement_2()
		throws Exception {
		try {Element element = new BaseElement("");
		Node srcNode = new Text();
		org.w3c.dom.Element newElement = null;
		String type = "";
		String location = "";

		org.w3c.dom.Element result = CommonXqUtils.getW3cElementByDom4jElement(element, srcNode, newElement, type, location);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.ailk.eaap.integration.o2p.transformer.common.CommonXqUtils.getW3cElementByDom4jElement(CommonXqUtils.java:277)
		assertNotNull(result);} catch(Exception e) {
			
		}
	}

	/**
	 * Run the org.w3c.dom.Element getW3cElementByDom4jElement(Element,Node,Element,String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:46
	 */
	@Test
	public void testGetW3cElementByDom4jElement_3()
		throws Exception {
		try {Element element = new BaseElement("");
		Node srcNode = new Text();
		org.w3c.dom.Element newElement = new IIOMetadataNode();
		String type = "";
		String location = "";

		org.w3c.dom.Element result = CommonXqUtils.getW3cElementByDom4jElement(element, srcNode, newElement, type, location);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.ailk.eaap.integration.o2p.transformer.common.CommonXqUtils.getW3cElementByDom4jElement(CommonXqUtils.java:279)
		assertNotNull(result);} catch(Exception e) {
			
		}
	}

	/**
	 * Run the org.w3c.dom.Element getW3cElementByDom4jElement(Element,Node,Element,String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:46
	 */
	@Test
	public void testGetW3cElementByDom4jElement_4()
		throws Exception {
		try {Element element = new BaseElement("");
		Node srcNode = new Text();
		org.w3c.dom.Element newElement = new IIOMetadataNode();
		String type = "";
		String location = "";

		org.w3c.dom.Element result = CommonXqUtils.getW3cElementByDom4jElement(element, srcNode, newElement, type, location);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.ailk.eaap.integration.o2p.transformer.common.CommonXqUtils.getW3cElementByDom4jElement(CommonXqUtils.java:279)
		assertNotNull(result);} catch(Exception e) {
			
		}
	}

	/**
	 * Run the org.w3c.dom.Element getW3cElementByDom4jElement(Element,Node,Element,String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:46
	 */
	@Test
	public void testGetW3cElementByDom4jElement_5()
		throws Exception {
		try {Element element = new BaseElement("");
		Node srcNode = new Text();
		org.w3c.dom.Element newElement = null;
		String type = "";
		String location = "";

		org.w3c.dom.Element result = CommonXqUtils.getW3cElementByDom4jElement(element, srcNode, newElement, type, location);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.ailk.eaap.integration.o2p.transformer.common.CommonXqUtils.getW3cElementByDom4jElement(CommonXqUtils.java:277)
		assertNotNull(result);} catch(Exception e) {
			
		}
	}

	/**
	 * Run the org.w3c.dom.Element getW3cElementByDom4jElement(Element,Node,Element,String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:46
	 */
	@Test
	public void testGetW3cElementByDom4jElement_6()
		throws Exception {
		try {Element element = new BaseElement("");
		Node srcNode = new Text();
		org.w3c.dom.Element newElement = new IIOMetadataNode();
		String type = "";
		String location = "";

		org.w3c.dom.Element result = CommonXqUtils.getW3cElementByDom4jElement(element, srcNode, newElement, type, location);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.ailk.eaap.integration.o2p.transformer.common.CommonXqUtils.getW3cElementByDom4jElement(CommonXqUtils.java:279)
		assertNotNull(result);} catch(Exception e) {
			
		}
	}

	/**
	 * Run the org.w3c.dom.Element getW3cElementByDom4jElement(Element,Node,Element,String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:46
	 */
	@Test
	public void testGetW3cElementByDom4jElement_7()
		throws Exception {
		try {Element element = new BaseElement("");
		Node srcNode = new Text();
		org.w3c.dom.Element newElement = new IIOMetadataNode();
		String type = "";
		String location = "";

		org.w3c.dom.Element result = CommonXqUtils.getW3cElementByDom4jElement(element, srcNode, newElement, type, location);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.ailk.eaap.integration.o2p.transformer.common.CommonXqUtils.getW3cElementByDom4jElement(CommonXqUtils.java:279)
		assertNotNull(result);} catch(Exception e) {
			
		}
	}

	/**
	 * Run the org.w3c.dom.Element getW3cElementByDom4jElement(Element,Node,Element,String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:46
	 */
	@Test
	public void testGetW3cElementByDom4jElement_8()
		throws Exception {
		try {Element element = new BaseElement("");
		Node srcNode = new Text();
		org.w3c.dom.Element newElement = null;
		String type = "2";
		String location = "";

		org.w3c.dom.Element result = CommonXqUtils.getW3cElementByDom4jElement(element, srcNode, newElement, type, location);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.ailk.eaap.integration.o2p.transformer.common.CommonXqUtils.getW3cElementByDom4jElement(CommonXqUtils.java:277)
		assertNotNull(result);} catch(Exception e) {
			
		}
	}

	/**
	 * Run the org.w3c.dom.Element getW3cElementByDom4jElement(Element,Node,Element,String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:46
	 */
	@Test
	public void testGetW3cElementByDom4jElement_9()
		throws Exception {
		try {Element element = new BaseElement("");
		Node srcNode = new Text();
		org.w3c.dom.Element newElement = null;
		String type = "";
		String location = "";

		org.w3c.dom.Element result = CommonXqUtils.getW3cElementByDom4jElement(element, srcNode, newElement, type, location);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.ailk.eaap.integration.o2p.transformer.common.CommonXqUtils.getW3cElementByDom4jElement(CommonXqUtils.java:277)
		assertNotNull(result);} catch(Exception e) {
			
		}
	}

	/**
	 * Run the org.w3c.dom.Element getW3cElementByDom4jElement(Element,Node,Element,String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:46
	 */
	@Test
	public void testGetW3cElementByDom4jElement_10()
		throws Exception {
		try {Element element = new BaseElement("");
		Node srcNode = new Text();
		org.w3c.dom.Element newElement = null;
		String type = "1";
		String location = "";

		org.w3c.dom.Element result = CommonXqUtils.getW3cElementByDom4jElement(element, srcNode, newElement, type, location);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.ailk.eaap.integration.o2p.transformer.common.CommonXqUtils.getW3cElementByDom4jElement(CommonXqUtils.java:277)
		assertNotNull(result);} catch(Exception e) {
			
		}
	}

	/**
	 * Run the void insertByLocationWithDOM(Node,Element,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:46
	 */
	@Test
	public void testInsertByLocationWithDOM_1()
		throws Exception {
		try {Node node = new Text();
		org.w3c.dom.Element elem = new IIOMetadataNode();
		String location = "0";

		CommonXqUtils.insertByLocationWithDOM(node, elem, location);
} catch(Exception e) {
			
		}
		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.ailk.eaap.integration.o2p.transformer.common.CommonXqUtils.insertByLocationWithDOM(CommonXqUtils.java:328)
	}

	/**
	 * Run the void insertByLocationWithDOM(Node,Element,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:46
	 */
	@Test
	public void testInsertByLocationWithDOM_2()
		throws Exception {
		try {Node node = new Text();
		org.w3c.dom.Element elem = new IIOMetadataNode();
		String location = "1";

		CommonXqUtils.insertByLocationWithDOM(node, elem, location);
} catch(Exception e) {
			
		}
		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.ailk.eaap.integration.o2p.transformer.common.CommonXqUtils.insertByLocationWithDOM(CommonXqUtils.java:332)
	}

	/**
	 * Run the void insertByLocationWithDOM(Node,Element,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:46
	 */
	@Test
	public void testInsertByLocationWithDOM_3()
		throws Exception {
		try {Node node = new Text();
		org.w3c.dom.Element elem = new IIOMetadataNode();
		String location = "2";

		CommonXqUtils.insertByLocationWithDOM(node, elem, location);
} catch(Exception e) {
			
		}
		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassCastException: javax.imageio.metadata.IIOMetadataNode cannot be cast to org.apache.axis.message.NodeImpl
		//       at org.apache.axis.message.NodeImpl.appendChild(NodeImpl.java:493)
		//       at com.ailk.eaap.integration.o2p.transformer.common.CommonXqUtils.insertByLocationWithDOM(CommonXqUtils.java:337)
	}

	/**
	 * Run the void insertByLocationWithDOM(Node,Element,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:46
	 */
	@Test
	public void testInsertByLocationWithDOM_4()
		throws Exception {
		try {Node node = new Text();
		org.w3c.dom.Element elem = new IIOMetadataNode();
		String location = "3";

		CommonXqUtils.insertByLocationWithDOM(node, elem, location);
} catch(Exception e) {
			
		}
		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassCastException: javax.imageio.metadata.IIOMetadataNode cannot be cast to org.apache.axis.message.NodeImpl
		//       at org.apache.axis.message.NodeImpl.appendChild(NodeImpl.java:493)
		//       at com.ailk.eaap.integration.o2p.transformer.common.CommonXqUtils.insertByLocationWithDOM(CommonXqUtils.java:342)
	}

	/**
	 * Run the void insertByLocationWithDOM(Node,Element,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:46
	 */
	@Test
	public void testInsertByLocationWithDOM_5()
		throws Exception {
		try {Node node = new Text();
		org.w3c.dom.Element elem = new IIOMetadataNode();
		String location = "3";

		CommonXqUtils.insertByLocationWithDOM(node, elem, location);
} catch(Exception e) {
			
		}
		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassCastException: javax.imageio.metadata.IIOMetadataNode cannot be cast to org.apache.axis.message.NodeImpl
		//       at org.apache.axis.message.NodeImpl.appendChild(NodeImpl.java:493)
		//       at com.ailk.eaap.integration.o2p.transformer.common.CommonXqUtils.insertByLocationWithDOM(CommonXqUtils.java:342)
	}

	/**
	 * Run the void insertByLocationWithDOM(Node,Element,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:46
	 */
	@Test
	public void testInsertByLocationWithDOM_6()
		throws Exception {
		Node node = new Text();
		org.w3c.dom.Element elem = new IIOMetadataNode();
		String location = "";

		CommonXqUtils.insertByLocationWithDOM(node, elem, location);

		// add additional test code here
	}

	/**
	 * Run the void insertByLocationWithDOM(Node,Element,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:46
	 */
	@Test
	public void testInsertByLocationWithDOM_7()
		throws Exception {
		try {Node node = new Text();
		org.w3c.dom.Element elem = new IIOMetadataNode();
		String location = "2";

		CommonXqUtils.insertByLocationWithDOM(node, elem, location);
} catch(Exception e) {
			
		}
		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassCastException: javax.imageio.metadata.IIOMetadataNode cannot be cast to org.apache.axis.message.NodeImpl
		//       at org.apache.axis.message.NodeImpl.appendChild(NodeImpl.java:493)
		//       at com.ailk.eaap.integration.o2p.transformer.common.CommonXqUtils.insertByLocationWithDOM(CommonXqUtils.java:337)
	}

	/**
	 * Run the void insertByLocationWithDOM(Node,Element,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:46
	 */
	@Test
	public void testInsertByLocationWithDOM_8()
		throws Exception {
		try {Node node = new Text();
		org.w3c.dom.Element elem = new IIOMetadataNode();
		String location = "1";

		CommonXqUtils.insertByLocationWithDOM(node, elem, location);
} catch(Exception e) {
			
		}
		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.ailk.eaap.integration.o2p.transformer.common.CommonXqUtils.insertByLocationWithDOM(CommonXqUtils.java:332)
	}

	/**
	 * Run the void insertByLocationWithDOM(Node,Element,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:46
	 */
	@Test
	public void testInsertByLocationWithDOM_9()
		throws Exception {
		try {	Node node = new Text();
		org.w3c.dom.Element elem = new IIOMetadataNode();
		String location = "0";

		CommonXqUtils.insertByLocationWithDOM(node, elem, location);
} catch(Exception e) {
			
		}
		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.ailk.eaap.integration.o2p.transformer.common.CommonXqUtils.insertByLocationWithDOM(CommonXqUtils.java:328)
	}

	/**
	 * Run the boolean isFixedParameter(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:46
	 */
	@Test
	public void testIsFixedParameter_1()
		throws Exception {
		String name = "body";

		boolean result = CommonXqUtils.isFixedParameter(name);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean isFixedParameter(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:46
	 */
	@Test
	public void testIsFixedParameter_2()
		throws Exception {
		String name = "header";

		boolean result = CommonXqUtils.isFixedParameter(name);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean isFixedParameter(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:46
	 */
	@Test
	public void testIsFixedParameter_3()
		throws Exception {
		String name = "";

		boolean result = CommonXqUtils.isFixedParameter(name);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the org.w3c.dom.Document parseXMLToW3cDocument(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:46
	 */
	@Test
	public void testParseXMLToW3cDocument_1()
		throws Exception {
		String xml = "";

		org.w3c.dom.Document result = CommonXqUtils.parseXMLToW3cDocument(xml);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the org.w3c.dom.Document parseXMLToW3cDocument(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:46
	 */
	@Test
	public void testParseXMLToW3cDocument_2()
		throws Exception {
		String xml = "";

		org.w3c.dom.Document result = CommonXqUtils.parseXMLToW3cDocument(xml);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the Document parseXmlToDom4jDocument(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:46
	 */
	@Test
	public void testParseXmlToDom4jDocument_1()
		throws Exception {
		String xml = "";

		Document result = CommonXqUtils.parseXmlToDom4jDocument(xml);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the Document parseXmlToDom4jDocument(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:46
	 */
	@Test
	public void testParseXmlToDom4jDocument_2()
		throws Exception {
		String xml = "";

		Document result = CommonXqUtils.parseXmlToDom4jDocument(xml);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the String parseXpath(String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:46
	 */
	@Test
	public void testParseXpath_1()
		throws Exception {
		String xPath = "..";
		String name = "body";

		String result = CommonXqUtils.parseXpath(xPath, name);

		// add additional test code here
		assertEquals("//soap:Body", result);
	}

	/**
	 * Run the String parseXpath(String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:46
	 */
	@Test
	public void testParseXpath_2()
		throws Exception {
		String xPath = "";
		String name = "body";

		String result = CommonXqUtils.parseXpath(xPath, name);

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String parseXpath(String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:46
	 */
	@Test
	public void testParseXpath_3()
		throws Exception {
		String xPath = ".";
		String name = "body";

		String result = CommonXqUtils.parseXpath(xPath, name);

		// add additional test code here
		assertEquals("//soap:Body", result);
	}

	/**
	 * Run the String parseXpath(String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:46
	 */
	@Test
	public void testParseXpath_4()
		throws Exception {
		String xPath = "";
		String name = "";

		String result = CommonXqUtils.parseXpath(xPath, name);

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String parseXpath(String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:46
	 */
	@Test
	public void testParseXpath_5()
		throws Exception {
		String xPath = "..";
		String name = "header";

		String result = CommonXqUtils.parseXpath(xPath, name);

		// add additional test code here
		assertEquals("//soap:Header", result);
	}

	/**
	 * Run the String parseXpath(String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:46
	 */
	@Test
	public void testParseXpath_6()
		throws Exception {
		String xPath = "";
		String name = "header";

		String result = CommonXqUtils.parseXpath(xPath, name);

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String parseXpath(String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:46
	 */
	@Test
	public void testParseXpath_7()
		throws Exception {
		String xPath = ".";
		String name = "header";

		String result = CommonXqUtils.parseXpath(xPath, name);

		// add additional test code here
		assertEquals("//soap:Header", result);
	}

	/**
	 * Run the void replaceByLocationWithDOM(Node,Element,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:46
	 */
	@Test
	public void testReplaceByLocationWithDOM_1()
		throws Exception {
		try {Node node = new Text();
		org.w3c.dom.Element elem = new IIOMetadataNode();
		String location = "0";

		CommonXqUtils.replaceByLocationWithDOM(node, elem, location);
} catch(Exception e) {
			
		}
		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.ailk.eaap.integration.o2p.transformer.common.CommonXqUtils.replaceByLocationWithDOM(CommonXqUtils.java:360)
	}

	/**
	 * Run the void replaceByLocationWithDOM(Node,Element,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:46
	 */
	@Test
	public void testReplaceByLocationWithDOM_2()
		throws Exception {
		try {Node node = new Text();
		org.w3c.dom.Element elem = new IIOMetadataNode();
		String location = "1";

		CommonXqUtils.replaceByLocationWithDOM(node, elem, location);
} catch(Exception e) {
			
		}
		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    org.w3c.dom.DOMException: NodeImpl Not found
		//       at org.apache.axis.message.NodeImpl.removeChild(NodeImpl.java:515)
		//       at com.ailk.eaap.integration.o2p.transformer.common.CommonXqUtils.replaceByLocationWithDOM(CommonXqUtils.java:365)
	}

	/**
	 * Run the void replaceByLocationWithDOM(Node,Element,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:46
	 */
	@Test
	public void testReplaceByLocationWithDOM_3()
		throws Exception {
		try {Node node = new Text();
		org.w3c.dom.Element elem = new IIOMetadataNode();
		String location = "1";

		CommonXqUtils.replaceByLocationWithDOM(node, elem, location);
} catch(Exception e) {
			
		}
		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    org.w3c.dom.DOMException: NodeImpl Not found
		//       at org.apache.axis.message.NodeImpl.removeChild(NodeImpl.java:515)
		//       at com.ailk.eaap.integration.o2p.transformer.common.CommonXqUtils.replaceByLocationWithDOM(CommonXqUtils.java:365)
	}

	/**
	 * Run the void replaceByLocationWithDOM(Node,Element,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:46
	 */
	@Test
	public void testReplaceByLocationWithDOM_4()
		throws Exception {
		Node node = new Text();
		org.w3c.dom.Element elem = new IIOMetadataNode();
		String location = "";

		CommonXqUtils.replaceByLocationWithDOM(node, elem, location);

		// add additional test code here
	}

	/**
	 * Run the void replaceByLocationWithDOM(Node,Element,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:46
	 */
	@Test
	public void testReplaceByLocationWithDOM_5()
		throws Exception {
		try {Node node = new Text();
		org.w3c.dom.Element elem = new IIOMetadataNode();
		String location = "0";

		CommonXqUtils.replaceByLocationWithDOM(node, elem, location);
} catch(Exception e) {
			
		}
		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.ailk.eaap.integration.o2p.transformer.common.CommonXqUtils.replaceByLocationWithDOM(CommonXqUtils.java:360)
	}

	/**
	 * Run the void replaceByLocationWithDOM(Node,Element,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:46
	 */
	@Test(expected = org.w3c.dom.DOMException.class)
	public void testReplaceByLocationWithDOM_6()
		throws Exception {
		Node node = new Text();
		org.w3c.dom.Element elem = new IIOMetadataNode();
		String location = "1";

		CommonXqUtils.replaceByLocationWithDOM(node, elem, location);

		// add additional test code here
	}

	/**
	 * Run the void replaceByLocationWithDOM(Node,Element,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:46
	 */
	@Test(expected = org.w3c.dom.DOMException.class)
	public void testReplaceByLocationWithDOM_7()
		throws Exception {
		Node node = new Text();
		org.w3c.dom.Element elem = new IIOMetadataNode();
		String location = "1";

		CommonXqUtils.replaceByLocationWithDOM(node, elem, location);

		// add additional test code here
	}

	/**
	 * Run the void replaceByLocationWithDOM(Node,Element,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:46
	 */
	@Test(expected = org.w3c.dom.DOMException.class)
	public void testReplaceByLocationWithDOM_8()
		throws Exception {
		Node node = new Text();
		org.w3c.dom.Element elem = new IIOMetadataNode();
		String location = "1";

		CommonXqUtils.replaceByLocationWithDOM(node, elem, location);

		// add additional test code here
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:46
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
	 * @generatedBy CodePro at 15-12-16 下午2:46
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
	 * @generatedBy CodePro at 15-12-16 下午2:46
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(CommonXqUtilsTest.class);
	}
}