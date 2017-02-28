package com.ailk.eaap.integration.o2p.transformer.common;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.QName;
import org.dom4j.io.DOMReader;
import org.dom4j.io.SAXReader;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.asiainfo.foundation.exception.BusinessException;
import com.asiainfo.foundation.log.LogModel;
import com.asiainfo.foundation.log.Logger;

/**
 * Created by david on 14-7-18.
 */
public final class CommonXqUtils
{
    private static final Logger LOG = Logger.getLog(CommonXqUtils.class);

    public  static final String XPATH_BODY = "//soap:Body";
    public  static final String XPATH_HEADER = "//soap:Header";

    public  static final String XPATH_BODY_NAME = "body";
    public  static final String XPATH_HEADER_NAME = "header";

    public static String xq_namespace = "declare namespace soap = \"http://schemas.xmlsoap.org/soap/envelope/\";"
            + "declare namespace soapenv = \"http://schemas.xmlsoap.org/soap/envelope/\";"
            + "declare namespace xsd = \"http://www.w3.org/2000/10/XMLSchema\";"
            + "declare namespace xsl = \"http://www.w3.org/1999/XSL/Transform\";"
            + "declare namespace xsi = \"http://www.w3.org/2000/10/XMLSchema-instance\";"
            + "declare namespace fn = \"http://www.w3.org/2004/07/xpath-functions\";"
            + "declare namespace saxon = \"http://saxon.sf.net/\";";

    /**
     * 
     * @param path
     *            路径
     * @return org.dom4j.Document
     */
    public static Document copyDom4jDocument(String path)
    {
        if (org.apache.commons.lang.StringUtils.isEmpty(path))
        {
            return null;
        }
        SAXReader saxReader = new SAXReader();
        try
        {
            Document doc = saxReader.read(path);
            Document newDoc = DocumentHelper.createDocument();
            copyElementByDom4j(doc.getRootElement(),
                    newDoc.addElement("Envelope"));
            return newDoc;
        }
        catch (DocumentException e)
        {
            LOG.error(LogModel.EVENT_APP_EXCPT, e);
        }
        return null;
    }

    /**
     * 
     * @param xml
     *            报文内容
     * @return org.dom4j.Document
     */
    public static Document parseXmlToDom4jDocument(String xml)
    {
        try
        {
            return DocumentHelper.parseText(xml);
        }
        catch (DocumentException e)
        {
            LOG.error(LogModel.EVENT_APP_EXCPT, e);
        }
        return null;
    }

    /**
     * 此处存在一个bug! 必须约定 如果传入的 报文 本身打算传值, 但是使用了 (此处为空格),无法成功 不能传递以空格为表示的值
     * 
     * @param element
     * @param newElement
     */
    @SuppressWarnings("rawtypes")
    private static void copyElementByDom4j(Element element, Element newElement)
    {
        // 递归方法
        if (!element.elementIterator().hasNext())
        {
            return;
        }
        for (Iterator its = element.elementIterator(); its.hasNext();)
        {
            Element chileEle = (Element) its.next();
            Element newElementChild = newElement.addElement(chileEle.getName());
            // 枚举属性
            for (Iterator ia = chileEle.attributeIterator(); ia.hasNext();)
            {
                Attribute attribute = (Attribute) ia.next();
                newElementChild.addAttribute(new QName(attribute.getName()),
                        attribute.getValue());
            }
            if (!org.apache.commons.lang.StringUtils
                    .isEmpty(chileEle.getText()))
            {
                newElementChild.setText(chileEle.getText());
            }
            copyElementByDom4j(chileEle, newElementChild);
        }
    }

    /**
     * @param path
     *            文件路径
     * @return org.w3c.dom.Document
     */
    public static org.w3c.dom.Document getW3cDocumentByPath(String path)
    {
        if (org.apache.commons.lang.StringUtils.isEmpty(path))
        {
            return null;
        }
        DocumentBuilder builder;
        org.w3c.dom.Document document = null;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try
        {
            factory.setNamespaceAware(true);
            // 注入XML安全处理
            factory.setFeature(
                    "http://javax.xml.XMLConstants/feature/secure-processing",
                    true);
            builder = factory.newDocumentBuilder();
            document = builder.parse(path);
            if (document != null)
            {
                document.normalize(); // 去掉XML文档中空白部分
            }

        }
        catch (ParserConfigurationException e)
        {
            LOG.error(LogModel.EVENT_APP_EXCPT, e);
        }
        catch (SAXException e)
        {
            LOG.error(LogModel.EVENT_APP_EXCPT, e);
        }
        catch (IOException e)
        {
            LOG.error(LogModel.EVENT_APP_EXCPT, e);
        }

        return document;
    }

    /**
     * 将 org.dom4j.Document 转换为 org.w3c.dom.Document
     * 
     * @param doc
     *            org.dom4j.Document
     * @return org.w3c.dom.Document
     */
    public static org.w3c.dom.Document getW3cDocumentByDom4j(Document doc)
    {
        if (doc == null)
        {
            return null;
        }
        DocumentBuilder builder = null;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try
        {
            factory.setNamespaceAware(true);
            // 注入XML安全处理
            builder = factory.newDocumentBuilder();
            return builder
                    .parse(new InputSource(new StringReader(doc.asXML())));
        }
        catch (Exception e)
        {
            throw new BusinessException(
                    9300,
                    "o2p.serviceAgent.transformer.commonXqUtils.dom4jTransformerW3c",
                    null, e);
        }
    }

    /**
     * 将 xml 转为org.w3c.dom.Document
     * 
     * @param xml
     *            传入符合xml格式内容
     * @return org.w3c.dom.Document
     */
    public static org.w3c.dom.Document parseXMLToW3cDocument(String xml)
    {
        if (org.apache.commons.lang.StringUtils.isEmpty(xml))
        {
            return null;
        }
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = null;
        try
        {
            // 注入XML安全处理
            builder = factory.newDocumentBuilder();
            return builder.parse(new InputSource(new StringReader(xml)));
        }
        catch (Exception e)
        {
            String[] msgArgs =
            { xml };
            throw new BusinessException(
                    9146,
                    "o2p.serviceAgent.transformer.commonXqUtils.transformerW3c",
                    msgArgs, e);
        }
    }

    /**
     * @param doc
     *            org.w3c.dom.Document
     * @return org.dom4j.Document
     */
    public static Document getDom4jDocumentByW3c(org.w3c.dom.Document doc)
    {
        if (doc == null)
        {
            return null;
        }
        DOMReader xmlReader = new DOMReader();
        return xmlReader.read(doc);
    }

    /**
     * 插入调用
     * 
     * @param element
     *            org.dom4j.Element 源元素
     * @param srcNode
     *            目标节点
     * @param newElement
     *            遍历新元素
     */
    @SuppressWarnings("rawtypes")
    public static org.w3c.dom.Element getW3cElementByDom4jElement(
            Element element, Node srcNode, org.w3c.dom.Element newElement,
            String type, String location)
    {
        if (element == null)
        {
            return null;
        }
        org.w3c.dom.Element element1 = (newElement == null ? srcNode
                .getOwnerDocument().createElement(element.getName())
                : newElement.getOwnerDocument()
                        .createElement(element.getName()));
        element1.setTextContent(element.getText());
        for (Iterator ia = element.attributeIterator(); ia.hasNext();)
        {
            Attribute attribute = (Attribute) ia.next();
            element1.setAttribute(attribute.getName(), attribute.getValue());
        }
        if (!org.apache.commons.lang.StringUtils.isEmpty(element.getTextTrim()))
        {
            element1.setTextContent(element.getText());
        }
        for (Iterator its = element.elementIterator(); its.hasNext();)
        {
            Element chileEle = (Element) its.next();
            getW3cElementByDom4jElement(chileEle, srcNode, element1, type,
                    location);
        }
        if (newElement == null)
        {
            if (type.equals(CommonXqUtils.O2PProperty.INSERT))
            {
                insertByLocationWithDOM(srcNode, element1, location);
            }
            else if (type.equals(CommonXqUtils.O2PProperty.REPLACE))
            {
                replaceByLocationWithDOM(srcNode, element1, location);
            }
        }
        else
        {
            newElement.appendChild(element1);
        }
        return element1;
    }

    /**
     * 
     * @param node
     *            原节点
     * @param elem
     *            插入元素
     * @param location
     *            位置
     */
    public static void insertByLocationWithDOM(Node node,
            org.w3c.dom.Element elem, String location)
    {
        if (location.equals(CommonXqUtils.XqueryInsertLocation.BEFORE))
        {
            node.getParentNode().insertBefore(elem, node);
        }
        else if (location.equals(CommonXqUtils.XqueryInsertLocation.AFTER))
        {
            node.getParentNode().appendChild(elem);
        }
        else if (location
                .equals(CommonXqUtils.XqueryInsertLocation.AS_FIRST_CHILD_OF))
        {
            node.appendChild(elem);
        }
        else if (location
                .equals(CommonXqUtils.XqueryInsertLocation.AS_LAST_CHILD_OF))
        {
            node.appendChild(elem);
        }
    }

    /**
     * 
     * @param node
     *            原节点
     * @param elem
     *            取代元素
     * @param location
     *            位置
     */
    public static void replaceByLocationWithDOM(Node node,
            org.w3c.dom.Element elem, String location)
    {
        if (location.equals(CommonXqUtils.XqueryReplaceLocation.OWN_NODE))
        {
            node.getParentNode().replaceChild(elem, node);
        }
        else if (location
                .equals(CommonXqUtils.XqueryReplaceLocation.NODE_CONTENT))
        {
            node.removeChild(node.getFirstChild());
            NodeList nodeList = node.getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++)
            {
                node.removeChild(nodeList.item(i));
            }
            node.appendChild(elem);
        }
    }

    /**
     * 根据 name 查看是否为固定参数
     * 
     * @param name
     * @return
     */
    public static boolean isFixedParameter(String name)
    {
        if (name.equals(CommonXqUtils.XPATH_BODY_NAME)
                || name.equals(CommonXqUtils.XPATH_HEADER_NAME))
        {
            return true;
        }
        return false;
    }

    /**
     * @param obj
     *            对象
     * @return org.w3c.dom.Document
     */
    public static org.w3c.dom.Document getDocumentByObject(Object obj)
    {
        if (obj instanceof org.w3c.dom.Document)
        {
            return (org.w3c.dom.Document) obj;
        }
        else if (obj instanceof org.w3c.dom.Element)
        {
            return ((org.w3c.dom.Element) obj).getOwnerDocument();
        }
        else if (obj instanceof Node)
        {
            return ((Node) obj).getOwnerDocument();
        }
        else
        {
            return null;
        }
    }

    /**
     * 对特殊 参数 xPath进行转换
     * 
     * @param xPath
     * @param name
     * @return
     */
    public static String parseXpath(String xPath, String name)
    {
        if (name.equals(CommonXqUtils.XPATH_HEADER_NAME))
        {
            if (xPath.startsWith("."))
            {
                xPath = CommonXqUtils.XPATH_HEADER;
            }
            else if (xPath.startsWith(".."))
            {
                xPath = CommonXqUtils.XPATH_HEADER + "/" + xPath;
            }
        }
        else if (name.equals(CommonXqUtils.XPATH_BODY_NAME))
        {
            if (xPath.startsWith("."))
            {
                xPath = CommonXqUtils.XPATH_BODY;
            }
            else if (xPath.startsWith(".."))
            {
                xPath = CommonXqUtils.XPATH_BODY + "/" + xPath;
            }
        }
        return xPath;
    }

    /**
     * 获得默认 namespace
     * 
     * @return
     */
    public static Map<String, String> getDefaultNamespace()
    {
        Map<String, String> maps = new HashMap<String, String>();
        maps.put("soap", "http://schemas.xmlsoap.org/soap/envelope/");
        maps.put("soapenv", "http://schemas.xmlsoap.org/soap/envelope/");
        maps.put("xsd", "http://www.w3.org/2000/10/XMLSchema");
        maps.put("xsl", "http://www.w3.org/1999/XSL/Transform");
        maps.put("xsi", "http://www.w3.org/2000/10/XMLSchema-instance");
        maps.put("fn", "http://www.w3.org/2004/07/xpath-functions");
        maps.put("saxon", "http://saxon.sf.net/");
        return maps;
    }

    /**
     * XQUERY, 这时候需要传入新 values NORMAL, 可以调用当前保存的全局 variables XSLT, waiting...
     */
    public static final class XQueryProperty
    {
        public static final String NORMAL = "0";
        public static final String XQUERY = "1";
        public static final String XSLT = "2";

        private XQueryProperty()
        {
        }
    }

    /**
     * BEFORE, 当前位置之前 AFTER, 当前位置之后 AS_FIRST_CHILD_OF, 当前位置子节点第一个
     * AS_LAST_CHILD_OF, 当前位置子节点最后一个
     */
    public static final class XqueryInsertLocation
    {
        public static final String BEFORE = "0";
        public static final String AFTER = "1";
        public static final String AS_FIRST_CHILD_OF = "2";
        public static final String AS_LAST_CHILD_OF = "3";

        private XqueryInsertLocation()
        {
        }
    }

    /**
     * OWN_NODE, 替换当前节点 NODE_CONTENT, 替换当前节点的所有子节点
     */
    public static class XqueryReplaceLocation
    {
        public static final String OWN_NODE = "0";
        public static final String NODE_CONTENT = "1";

        private XqueryReplaceLocation()
        {
        }
    }

    /**
     * Assign, 获取一个变量 Insert, 向变量插入对象 Replace,更新变量 Route, 路由变量
     */
    public static final class O2PProperty
    {
        public static final String ASSIGN = "0";
        public static final String INSERT = "1";
        public static final String REPLACE = "2";
        public static final String Assign_Route = "00";
        public static final String Insert_Route = "01";
        public static final String Replace_Route = "02";
        public static final String ROUTE = "10";

        private O2PProperty()
        {
        }
    }

    public static class XQueryParaCount
    {
        public static final int PARAM = 10;
        public static final int NAMESAPCE = 20;

        private XQueryParaCount()
        {
        }
    }
}
