//package com.ailk.eaap.integration.o2p.transformer;
//
//import java.io.StringWriter;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;
//import java.util.Properties;
//
//import javax.xml.XMLConstants;
//import javax.xml.namespace.NamespaceContext;
//import javax.xml.transform.OutputKeys;
//import javax.xml.transform.stream.StreamResult;
//import javax.xml.xpath.XPathConstants;
//import javax.xml.xpath.XPathExpressionException;
//import javax.xml.xpath.XPathFactory;
//
//import net.sf.saxon.Configuration;
//import net.sf.saxon.dom.DocumentWrapper;
//import net.sf.saxon.query.DynamicQueryContext;
//import net.sf.saxon.query.StaticQueryContext;
//import net.sf.saxon.query.XQueryExpression;
//import net.sf.saxon.trans.XPathException;
//
//import org.w3c.dom.Document;
//import org.w3c.dom.Element;
//import org.w3c.dom.Node;
//
//import com.ailk.eaap.integration.xquery.CommonXqUtils;
//import com.ailk.eaap.op2.bo.TransformerRule;
//
///**
// * Created by david on 14-7-17.
// */
//public class XQueryTransformerTest {
//
//    private static Configuration configuration = new Configuration();
//
//    private static StaticQueryContext context = new StaticQueryContext(configuration);
//
//    private Map<String, Object> variables = new HashMap<String, Object>();  // 自生使用 variables
//
//    private static XPathFactory xPathFactory = XPathFactory.newInstance();
//
//    private String namespace = "";   // 存储 string namespaces
//
//    private Map<String, String> namespaces; // 存储 map namespaces
//
//    private Document document;
//
//    private XQueryNamespaceContext xQueryNamespaceContext = new XQueryNamespaceContext();
//
//    public Document getDocument() {
//        return document;
//    }
//
//    public void setDocument(Document document) {
//        this.document = document;
//    }
//
//    @Deprecated
//    public Map<String, Object> getVariables() {
//        return variables;
//    }
//
//    public String getNamespace() {
//        return namespace;
//    }
//
//    public void setNamespace(String namespace) {
//        this.namespace += namespace;
//    }
//
//    public Map<String, String> getNamespaces() {
//        return namespaces;
//    }
//
//    public void setNamespaces(Map<String, String> namespaces) {
//        this.namespaces = namespaces;
//    }
//
//    public XQueryTransformerTest() {
//    }
//
//    public void init() {
//        initParameterByXPath(CommonXqUtils.XPATH_HEADER, CommonXqUtils.XPATH_HEADER_NAME);
//        initParameterByXPath(CommonXqUtils.XPATH_BODY, CommonXqUtils.XPATH_BODY_NAME);
//    }
//
//    /**
//     * 通用
//     * @param xqueryType 选择转换类型[通用类型, xQuery类型, xslt类型]
//     * @param expression xQuery脚本内容
//     * @param values 若是带参数,按照 key[参数名],value[参数值]存储
//     * @param parameterName 保存为全局变量参数名
//     * @param methodType 输出 转换以后 内容格式[xml,text,html,xhtml]
//     * @return
//     */
//    public void assign(String xqueryType, String expression, Map<String, Object> values, String parameterName, String methodType) {
//        executeXQuery(xqueryType, expression, values, parameterName, methodType);
//    }
//
//    /**
//     *
//     * @param xqueryType 选择转换类型[通用类型, xQuery类型, xslt类型]
//     * @param xPath xPath路径
//     * @param expression xQuery脚本内容, 必须是 Object[Node,Document,Element] 类型
//     *                   可输入 xQuery 表达式
//     *                   可输入 已存在  参数名 格式是 @name[不允许 固定参数] 会造成迁移
//     * @param values 若是带参数,按照 key[参数名],value[参数值]存储
//     * @param location 插入位置
//     * @param parameterName 保存为全局变量参数名
//     * @param methodType 输出 转换以后 内容格式[xml,text,html,xhtml], 此对象无需使用
//     * @return
//     */
//    public void insert(String xqueryType, String xPath, String expression, Map<String, Object> values, String location, String parameterName, String methodType) {
//        Element elem = null;
//        Node node = ((Node) getNodeByXpath(CommonXqUtils.parseXpath(xPath, parameterName), CommonXqUtils.getDocumentByObject(this.variables.get(parameterName)), XPathConstants.NODE));
//        if(expression.startsWith("@")) {
//            expression = expression.substring(1);
//            if(CommonXqUtils.isFixedParameter(expression)) {
//                  // throws exception
//            } else {
//                elem = transformerToDocument(O2PProperty.Insert, expression, node, location);
//                this.variables.put(parameterName, elem);
//            }
//        } else {
//            assign(xqueryType, expression, values, "insert$^$insert", "xml");
//            elem = transformerToDocument(O2PProperty.Insert, "insert$^$insert", node, location);
//            if(!CommonXqUtils.isFixedParameter(parameterName))
////                this.variables.put(parameterName, elem.getOwnerDocument());
//                this.variables.put(parameterName, elem);
//        }
////        expression = buildInsertByLocation(location, newStr, xPath);
////        newStr = executeXQuery(xqueryValue, expression, values, parameterName, methodType);
//    }
//
//    /**
//     *
//     * @param xqueryType 选择转换类型[通用类型, xQuery类型, xslt类型]
//     * @param xPath xPath路径
//     * @param expression xQuery脚本内容, 必须是 Object[Node,Document,Element] 类型
//     *                   可输入 xQuery 表达式
//     *                   可输入 已存在  参数名 格式是 @name[不允许 固定参数] 会造成迁移
//     * @param values 若是带参数,按照 key[参数名],value[参数值]存储
//     * @param location 插入位置
//     * @param parameterName 保存为全局变量参数名
//     * @param methodType 输出 转换以后 内容格式[xml,text,html,xhtml], 此对象无需使用
//     * @return
//     */
//    public void replace(String xqueryType, String xPath, String expression, Map<String, Object> values, String location, String parameterName, String methodType) {
//        Element elem = null;
//        Node node = ((Node) getNodeByXpath(CommonXqUtils.parseXpath(xPath, parameterName), CommonXqUtils.getDocumentByObject(this.variables.get(parameterName)), XPathConstants.NODE));
//        if(expression.startsWith("@")) {
//            expression = expression.substring(1);
//            if(CommonXqUtils.isFixedParameter(expression)) {
//                // throws exception
//            } else {
//                elem = transformerToDocument(O2PProperty.Replace, expression, node, location);
//                this.variables.put(parameterName, elem);
//            }
//        } else {
//            assign(xqueryType, expression, values, "replace$^$replace", "xml");
//            elem = transformerToDocument(O2PProperty.Replace, "replace$^$replace", node, location);
//            if(!CommonXqUtils.isFixedParameter(parameterName))
////                this.variables.put(parameterName, elem.getOwnerDocument());
//                this.variables.put(parameterName, elem);
//        }
//    }
//
//    /**
//     * 执行XQuery
//     * @param xqueryType
//     * @param expression
//     * @param values
//     * @param parameterName
//     * @param methodType
//     * @return
//     */
//    private void executeXQuery(String xqueryType, String expression, Map<String, Object> values, String parameterName, String methodType) {
//        XQueryExpression xQueryExpression = null;
//        DynamicQueryContext dynamicQueryContext = null;
//        StringWriter writer = null;
//        StreamResult result = null;
//        try {
//            xQueryExpression = context.compileQuery(this.namespace + expression);
//            dynamicQueryContext = new DynamicQueryContext(configuration);
//            dynamicQueryContext.setContextItem(new DocumentWrapper(document, null, configuration));
//            dynamicQueryContext.clearParameters();
//            setParameters(dynamicQueryContext, choiceValuesObject(xqueryType, values));
//            Properties properties = new Properties();
//            properties.setProperty(OutputKeys.METHOD, (methodType == null || methodType == "" ? "xml" : methodType));
//            properties.setProperty(OutputKeys.INDENT, "yes");
//            writer = new StringWriter();
//            result = new StreamResult(writer);
//            xQueryExpression.run(dynamicQueryContext, result, properties);
//            if(null != parameterName && "" != parameterName) {
//                this.variables.put(parameterName, returnParameterType(writer.toString(), methodType));
//            }
//        } catch (XPathException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 实现xQuery方法执行
//     * @param xquery
//     * @param rule
//     */
//    public void xQueryExecuteByMethod(XQueryTransformerTest xquery, TransformerRule rule) {
//        String []tmp = rule.getParamVarMaps().get(0).getVal().split(",");
//        String expression = rule.getScriptContent();
//        if(tmp[0].equals(O2PProperty.Assign)) {
//            xquery.assign(tmp[4], expression, tmp[3].length() > 0 ? new HashMap<String, Object>() : null, tmp[2], tmp[1]);
//        } else if(tmp[0].equals(O2PProperty.Insert)) {
//            xquery.insert(tmp[4], tmp[5],expression, tmp[3].length() > 0? new HashMap<String, Object>() : null, tmp[6], tmp[2], tmp[1]);
//        } else if(tmp[0].equals(O2PProperty.Replace)) {
//            xquery.replace(tmp[4], tmp[5], expression, tmp[3].length() > 0 ? new HashMap<String, Object>() : null, tmp[6], tmp[2], tmp[1]);
//        }
//    }
//
//    /**
//     * 设置xQuery参数
//     * @param dynamicQueryContext 动态查询上下文
//     * @param values 参数列表
//     */
//    private void setParameters(DynamicQueryContext dynamicQueryContext, Map<String, Object> values) {
//        if(values != null) {
//            for(String key : values.keySet()) {
//                dynamicQueryContext.setParameter(key, values.get(key));
//            }
//        }
//    }
//
//    /**
//     * 根据类型 选择参数值对象[全局对象, 对应xQuery文件对应参数对象]
//     * @param type  选择类型
//     * @param values 传递xQuery文件对应参数对象, 可以为null
//     * @return
//     */
//    private Map<String, Object> choiceValuesObject(String type, Map<String, Object> values) {
//        if(type.equals(XQueryProperty.NORMAL))
//            return this.variables;
//        else if(type.equals(XQueryProperty.XQUERY))
//            return values;
//        else if(type.equals(XQueryProperty.XSLT))
//            return null;
//        else {
//            return null;
//        }
//    }
//
//    /**
//     * 插入节点
//     * @param location  插入位置
//     * @param value 插入值
//     * @param xPath 查询路径[declare namespace ...;xPath]
//     * @return
//     */
//    @Deprecated
//    private String buildInsertByLocation(String location, String value, String xPath) {
//        String newStr = this.namespace;
//        String url = xPath;
//        String name = "";
//
//        if(location.equals(XqueryInsertLocation.BEFORE)) {
//            assign(XQueryProperty.NORMAL, newStr + "name(" + url + "/..)", null, "name$^$name", "text");
//            name = this.variables.get("name$^$name").toString();
//            newStr +=
//                    "element " + name +" {" +
//                    "let $c := count(" + url + ") " +
//                    "for $i in (1 to $c) " +
//                    "return if ($i = 1) " +
//                    " then  " + value + ", " + url + "[position()=$i] " +
//                    " else " + url + "[position()=$i] " +
//                    "}";
//        } else if(location.equals(XqueryInsertLocation.AFTER)) {
//            assign(XQueryProperty.NORMAL, newStr + "name(" + url + "/..)", null, "name$^$name", "text");
//            name = this.variables.get("name$^$name").toString();
//            newStr +=
//                    "element " + name +" {" +
//                    "let $c := count(" + url + ") " +
//                    "for $i in (1 to $c) " +
//                    "return if ($i = $c) " +
//                    " then " + url + "[position()=$i], " + value +
//                    " else " + url + "[position()=$i] " +
//                    "}";
//        } else if(location.equals(XqueryInsertLocation.AS_FIRST_CHILD_OF)) {
//            name = url.substring(url.lastIndexOf("/")+1);
//            newStr +=
//                    "element " + name + " { " +
//                    "let $c := count(" + url + "/*) " +
//                    "for $i in (1 to $c) " +
//                    "return if ($i = 1) " +
//                    " then  " + value + ", " + url + "/*[position()=$i] " +
//                    " else " + url + "/*[position()=$i] " +
//                    "}";
//        } else if(location.equals(XqueryInsertLocation.AS_LAST_CHILD_OF)) {
//            name = url.substring(url.lastIndexOf("/")+1);
//            newStr +=
//                    "element " + name + " { " +
//                    "let $c := count(" + url + "/*) " +
//                    "for $i in (1 to $c) " +
//                    "return if ($i = $c) " +
//                    " then " + url + "/*[position()=$i], " + value +
//                    " else " + url + "/*[position()=$i] " +
//                    "}";
//        } else {
//            // ... throws exception
//        }
//        return newStr;
//    }
//
//    /**
//     *
//     * @param data 输入xml数据
//     * @param methodType 输出 转换以后 内容格式[xml,text,html,xhtml]
//     * @return
//     */
//    private Object returnParameterType(String data, String methodType) {
//        Object obj = null;
//        if(methodType.equals("xml")) {
//            obj = CommonXqUtils.parseXMLToW3cDocument(data);;
//        } else if(methodType.equals("html")) {
//            obj = data;
//        } else if(methodType.equals("text")) {
//            obj = data;
//        } else if(methodType.equals("xhtml")) {
//            obj = data;
//        }
//        return obj;
//    }
//
//    /**
//     * 根据 xPath 初始化参数, 存储在 Map
//     * @param xPath
//     * @param name 参数名
//     */
//    private void initParameterByXPath(String xPath, String name) {
//        Node node = ((Node) getNodeByXpath(xPath, this.document, XPathConstants.NODE));
//        if(node == null) {
//            this.variables.put(name, null);
//        } else {
//            this.variables.put(name,node);
//        }
//    }
//
//    /**
//     *
//     * @param node 原节点
//     * @param elem 插入元素
//     * @param location 位置
//     */
//    private void insertByLocationWithDOM(Node node, Element elem, String location) {
//        if(location.equals(XqueryInsertLocation.BEFORE)) {
//            node.getParentNode().insertBefore(elem, node);
//        } else if(location.equals(XqueryInsertLocation.AFTER)) {
//            node.getParentNode().appendChild(elem);
//        } else if(location.equals(XqueryInsertLocation.AS_FIRST_CHILD_OF)) {
//            node.appendChild(elem);
//        } else if(location.equals(XqueryInsertLocation.AS_LAST_CHILD_OF)) {
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
//    private void replaceByLocationWithDOM(Node node, Element elem, String location) {
//        if(location.equals(XqueryReplaceLocation.OWN_NODE)) {
//            node.getParentNode().replaceChild(elem, node);
//        } else if(location.equals(XqueryReplaceLocation.NODE_CONTENT)) {
////            node.removeChild(node.getLastChild());
////            node.replaceChild(elem, node.getFirstChild());
//            node.getParentNode().appendChild(elem.getParentNode());
//        } else {
//            // ... throws exception
//        }
//    }
//
//    /**
//     * 通过xPath 查找Document | Node | NodeList
//     * @param xPath xPath语句
//     * @param document org.w3c.dom.Document
//     * @param returnType NODE | NODESET
//     * @return Document | Node | NodeList
//     */
//    private Object getNodeByXpath(String xPath, org.w3c.dom.Document document, javax.xml.namespace.QName returnType) {
//        Object obj = null;
//        javax.xml.xpath.XPath xPathTmp = xPathFactory.newXPath();
//        try {
//            xPathTmp.setNamespaceContext(xQueryNamespaceContext);
//            obj = xPathTmp.evaluate(xPath, document, returnType);
//        } catch (XPathExpressionException e) {
//            e.printStackTrace();
//        }
//        return obj;
//    }
//
//    /**
//     *
//     * @param expression 表达式
//     * @param node 转换根 节点
//     * @param location 插入位置
//     * @return org.w3c.dom.Document
//     */
//    private Element transformerToDocument(String type, String expression, Node node, String location) {
//        org.dom4j.Element element = CommonXqUtils.getDom4jDocumentByW3c((Document) this.variables.get(expression)).getRootElement();
//        Element elem = CommonXqUtils.getW3cElementByDom4jElement(element, node, null, type, location);
////        if(type.equals(O2PProperty.Insert)) {
////            insertByLocationWithDOM(node, elem, location);
////        } else if(type.equals(O2PProperty.Replace)) {
////            replaceByLocationWithDOM(node, elem, location);
////        }
//        return elem;
//    }
//
//    /**
//     * XQUERY, 这时候需要传入新 values
//     * NORMAL, 可以调用当前保存的全局 variables
//     * XSLT,   waiting...
//     */
//    public class XQueryProperty {
//        public final static String NORMAL = "0";
//        public final static String XQUERY = "1";
//        public final static String XSLT = "2";
//    }
//
//    public class XqueryInsertLocation {
//        public final static String BEFORE = "0";
//        public final static String AFTER = "1";
//        public final static String AS_FIRST_CHILD_OF = "2";
//        public final static String AS_LAST_CHILD_OF = "3";
//    }
//
//    public class XqueryReplaceLocation {
//        public final static String OWN_NODE = "0";
//        public final static String NODE_CONTENT = "1";
//    }
//
//    public class O2PProperty {
//        public final static String Assign = "0";
//        public final static String Insert = "1";
//        public final static String Replace = "2";
//    }
//
//    public class XQueryNamespaceContext implements NamespaceContext {
//        @Override
//        public String getNamespaceURI(String prefix) {
//            if(prefix == null) throw new NullPointerException("Null prefix");
//            Map<String, String> maps = CommonXqUtils.getDefaultNamespace();
//            maps.putAll(namespaces);
//            for(Iterator iterator = maps.entrySet().iterator(); iterator.hasNext();) {
//                Map.Entry<String, String> entry = (Map.Entry)iterator.next();
//                if(prefix.equals(entry.getKey())) {
//                    return entry.getValue();
//                }
//            }
//            return XMLConstants.NULL_NS_URI;
//        }
//
//        @Override
//        public String getPrefix(String namespaceURI) {
//            throw new UnsupportedOperationException();
//        }
//
//        @Override
//        public Iterator getPrefixes(String namespaceURI) {
//            throw new UnsupportedOperationException();
//        }
//    }
//}