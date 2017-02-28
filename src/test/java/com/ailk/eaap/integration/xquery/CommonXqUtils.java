//package com.ailk.eaap.integration.xquery;
//
//import java.io.IOException;
//import java.io.StringReader;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;
//
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.parsers.ParserConfigurationException;
//
//import org.dom4j.Attribute;
//import org.dom4j.Document;
//import org.dom4j.DocumentException;
//import org.dom4j.DocumentHelper;
//import org.dom4j.Element;
//import org.dom4j.QName;
//import org.dom4j.io.DOMReader;
//import org.dom4j.io.SAXReader;
//import org.w3c.dom.Node;
//import org.w3c.dom.NodeList;
//import org.xml.sax.InputSource;
//import org.xml.sax.SAXException;
//
//import com.ailk.eaap.integration.o2p.transformer.XQueryTransformerTest;
//
///**
// * Created by david on 14-7-18.
// */
//public class CommonXqUtils {
//
//    private static DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//
//    public final static String XPATH_BODY = "//soap:Body";
//    public final static String XPATH_HEADER = "//soap:Header";
//
//    public final static String XPATH_BODY_NAME = "body";
//    public final static String XPATH_HEADER_NAME = "header";
//
//    public static String xq_namespace =
//            "declare namespace soap = \"http://schemas.xmlsoap.org/soap/envelope/\";" +
//            "declare namespace soapenv = \"http://schemas.xmlsoap.org/soap/envelope/\";" +
//            "declare namespace xsd = \"http://www.w3.org/2000/10/XMLSchema\";" +
//            "declare namespace xsl = \"http://www.w3.org/1999/XSL/Transform\";" +
//            "declare namespace xsi = \"http://www.w3.org/2000/10/XMLSchema-instance\";" +
//            "declare namespace fn = \"http://www.w3.org/2004/07/xpath-functions\";";
//
//    /**
//     *
//     * @param path 路径
//     * @return org.dom4j.Document
//     */
//    public static Document copyDom4jDocument(String path) {
//        if(path == "" || path == null) {
//            return null;
//        }
//        SAXReader saxReader = new SAXReader();
//        try {
//            org.dom4j.Document doc = saxReader.read(path);
//            org.dom4j.Document newDoc = DocumentHelper.createDocument();
//            copyElementByDom4j(doc.getRootElement(), newDoc.addElement("Envelope"));
//            return newDoc;
//        } catch (DocumentException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    /**
//     *
//     * @param xml 报文内容
//     * @return org.dom4j.Document
//     */
//    public static Document parseXmlToDom4jDocument(String xml) {
//        try {
//            return DocumentHelper.parseText(xml);
//        } catch (DocumentException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    /**
//     * 此处存在一个bug! 必须约定
//     * 如果传入的 报文 本身打算传值, 但是使用了 (此处为空格),无法成功
//     * 不能传递以空格为表示的值
//     * @param element
//     * @param newElement
//     */
//    @SuppressWarnings("rawtypes")
//	private static void copyElementByDom4j(Element element,Element newElement){
//        //递归方法
//        if(element.elementIterator().hasNext() == false) return;
//        for(Iterator its =  element.elementIterator();its.hasNext();) {
//            Element chileEle = (Element)its.next();
//            Element newElementChild = newElement.addElement(chileEle.getName());
//            // 枚举属性
//            for (Iterator ia = chileEle.attributeIterator(); ia.hasNext();) {
//                Attribute attribute = (Attribute) ia.next();
//                newElementChild.addAttribute(new QName(attribute.getName()), attribute.getValue());
//            }
//            if(!chileEle.getTextTrim().equals("") && !chileEle.getTextTrim().equals(null)) {
//                newElementChild.setText(chileEle.getText());
//            }
//            copyElementByDom4j(chileEle, newElementChild);
//        }
//    }
//
//    /**
//     * @param path 文件路径
//     * @return org.w3c.dom.Document
//     */
//    public static org.w3c.dom.Document getW3cDocumentByPath(String path) {
//        if(path == "" || path == null) {
//            return null;
//        }
//        DocumentBuilder builder;
//        org.w3c.dom.Document document = null;
//        try {
//            factory.setNamespaceAware(true);
//            builder = factory.newDocumentBuilder();
//            document = builder.parse(path);
//        } catch (ParserConfigurationException e) {
//            e.printStackTrace();
//        } catch (SAXException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        if (null != document) {
//        	document.normalize(); // 去掉XML文档中空白部分
//        }
//        
//        return document;
//    }
//
//    /**
//     * 将 org.dom4j.Document 转换为 org.w3c.dom.Document
//     * @param doc org.dom4j.Document
//     * @return org.w3c.dom.Document
//     */
//    public static org.w3c.dom.Document getW3cDocumentByDom4j(org.dom4j.Document doc) {
//        if(doc == null ) {
//            return null;
//        }
//        DocumentBuilder builder = null;
//        try {
//            factory.setNamespaceAware(true);
//            builder = factory.newDocumentBuilder();
//            return builder.parse(
//                    new InputSource(new StringReader(doc.asXML())));
//        } catch (Exception e) {
//            throw new RuntimeException(e.getMessage());
//        }
//    }
//
//    /**
//     * 将 xml 转为org.w3c.dom.Document
//     * @param xml 传入符合xml格式内容
//     * @return org.w3c.dom.Document
//     */
//    public static org.w3c.dom.Document parseXMLToW3cDocument(String xml) {
//        if(xml == "" || xml == null) {
//            return null;
//        }
//        factory.setNamespaceAware(true);
//        DocumentBuilder builder = null;
//        try {
//            builder = factory.newDocumentBuilder();
//            return builder.parse(
//                    new InputSource(new StringReader(xml)));
//        } catch (Exception e) {
//            throw new RuntimeException(e.getMessage());
//        }
//    }
//
//    /**
//     * @param doc org.w3c.dom.Document
//     * @return org.dom4j.Document
//     */
//    public static org.dom4j.Document getDom4jDocumentByW3c(org.w3c.dom.Document doc) {
//        if(doc == null)   {
//            return null;
//        }
//        DOMReader xmlReader = new DOMReader();
//        return xmlReader.read(doc);
//    }
//
//    /**
//     * 插入调用
//     * @param element org.dom4j.Element 源元素
//     * @param srcNode 目标节点
//     * @param newElement 遍历新元素
//     */
//    @SuppressWarnings("rawtypes")
//	public static org.w3c.dom.Element getW3cElementByDom4jElement(org.dom4j.Element element, org.w3c.dom.Node srcNode,
//                                                                  org.w3c.dom.Element newElement, String type,
//                                                                  String location){
//        if(element == null) return null;
//        org.w3c.dom.Element element1 = (newElement == null ?
//                srcNode.getOwnerDocument().createElement(element.getName()) :
//                newElement.getOwnerDocument().createElement(element.getName()));
//        element1.setTextContent(element.getText());
//        for (Iterator ia = element.attributeIterator(); ia.hasNext();) {
//            Attribute attribute = (Attribute) ia.next();
//            element1.setAttribute(attribute.getName(), attribute.getValue());
//        }
//        if(!element.getTextTrim().equals("") && !element.getTextTrim().equals(null)) {
//            element1.setTextContent(element.getText());
//        }
//        for(Iterator its =  element.elementIterator();its.hasNext();) {
//            org.dom4j.Element chileEle = (org.dom4j.Element)its.next();
//            getW3cElementByDom4jElement(chileEle, srcNode, element1, type , location);
//        }
//        if(newElement == null) {
//            if(type.equals(XQueryTransformerTest.O2PProperty.Insert)) {
//                insertByLocationWithDOM(srcNode, element1, location);
//            } else if(type.equals(XQueryTransformerTest.O2PProperty.Replace)) {
//                replaceByLocationWithDOM(srcNode, element1, location);
//            }
////            srcNode.appendChild(element1);
//        } else {
//            newElement.appendChild(element1);
//        }
//        return element1;
//    }
//
//    /**
//     *
//     * @param node 原节点
//     * @param elem 插入元素
//     * @param location 位置
//     */
//    public static void insertByLocationWithDOM(Node node, org.w3c.dom.Element elem, String location) {
//        if(location.equals(XQueryTransformerTest.XqueryInsertLocation.BEFORE)) {
//            node.getParentNode().insertBefore(elem, node);
//        } else if(location.equals(XQueryTransformerTest.XqueryInsertLocation.AFTER)) {
//            node.getParentNode().appendChild(elem);
//        } else if(location.equals(XQueryTransformerTest.XqueryInsertLocation.AS_FIRST_CHILD_OF)) {
//            node.appendChild(elem);
//        } else if(location.equals(XQueryTransformerTest.XqueryInsertLocation.AS_LAST_CHILD_OF)) {
//            node.appendChild(elem);
//        } else {
//            // ... throws exception
//        }
//    }
//
//    /**
//     *
//     * @param node 原节点
//     * @param elem 取代元素
//     * @param location 位置
//     */
//    public static void replaceByLocationWithDOM(Node node, org.w3c.dom.Element elem, String location) {
//        if(location.equals(XQueryTransformerTest.XqueryReplaceLocation.OWN_NODE)) {
//            node.getParentNode().replaceChild(elem, node);
//        } else if(location.equals(XQueryTransformerTest.XqueryReplaceLocation.NODE_CONTENT)) {
//            node.removeChild(node.getFirstChild());
//            NodeList nodeList = node.getChildNodes();
//            for(int i=0; i<nodeList.getLength(); i++) {
//                node.removeChild(nodeList.item(i));
//            }
//            node.appendChild(elem);
//        } else {
//            // ... throws exception
//        }
//    }
//
//    public static boolean isFixedParameter(String name) {
//        if(name.equals(CommonXqUtils.XPATH_BODY_NAME) || name.equals(CommonXqUtils.XPATH_HEADER_NAME)) {
//            return true;
//        }
//        return false;
//    }
//
//    /**
//     * @param obj 对象
//     * @return org.w3c.dom.Document
//     */
//    public static org.w3c.dom.Document getDocumentByObject(Object obj) {
//        if(obj instanceof org.w3c.dom.Document) {
//            return (org.w3c.dom.Document) obj;
//        } else if(obj instanceof org.w3c.dom.Element) {
//            return ((org.w3c.dom.Element) obj).getOwnerDocument();
//        } else if(obj instanceof Node) {
//            return ((Node) obj).getOwnerDocument();
//        } else {
//            return null;
//        }
//    }
//
//    public static String parseXpath(String xPath, String name) {
//        if(name.equals(CommonXqUtils.XPATH_HEADER_NAME)) {
//            if(xPath.startsWith(".")) {
//                xPath = CommonXqUtils.XPATH_HEADER;
//            } else if(xPath.startsWith("..")) {
//                xPath = CommonXqUtils.XPATH_HEADER + "/" + xPath;
//            }
//        } else if(name.equals(CommonXqUtils.XPATH_BODY_NAME)) {
//            if(xPath.startsWith(".")) {
//                xPath = CommonXqUtils.XPATH_BODY;
//            } else if(xPath.startsWith("..")) {
//                xPath = CommonXqUtils.XPATH_BODY + "/" + xPath;
//            }
//        }
//        return xPath;
//    }
//
//    public static Map<String, String> getDefaultNamespace() {
//        Map<String, String> maps = new HashMap<String, String>();
//        maps.put("soap", "http://schemas.xmlsoap.org/soap/envelope/");
//        maps.put("soapenv", "http://schemas.xmlsoap.org/soap/envelope/");
//        maps.put("xsd", "http://www.w3.org/2000/10/XMLSchema");
//        maps.put("xsl", "http://www.w3.org/1999/XSL/Transform");
//        maps.put("xsi", "http://www.w3.org/2000/10/XMLSchema-instance");
//        maps.put("fn", "http://www.w3.org/2004/07/xpath-functions");
//        return maps;
//    }
//}
