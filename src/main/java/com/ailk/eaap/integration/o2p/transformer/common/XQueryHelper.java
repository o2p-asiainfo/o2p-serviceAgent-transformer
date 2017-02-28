package com.ailk.eaap.integration.o2p.transformer.common;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import net.sf.saxon.Configuration;
import net.sf.saxon.dom.DocumentWrapper;
import net.sf.saxon.query.DynamicQueryContext;
import net.sf.saxon.query.StaticQueryContext;
import net.sf.saxon.query.XQueryExpression;
import net.sf.saxon.trans.XPathException;

import org.apache.axis.utils.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.ailk.eaap.op2.common.EAAPException;
import com.ailk.eaap.op2.common.EAAPTags;
import com.ailk.eaap.op2.serviceagent.common.ErrorDomain;
import com.asiainfo.foundation.log.LogModel;
import com.asiainfo.foundation.log.Logger;
import com.ailk.eaap.op2.bo.TransformerRule;

/**
 * Created by david on 14-7-23.
 */
public class XQueryHelper
{
    private static final Logger LOG = Logger.getLog(XQueryHelper.class);

    private Configuration configuration = new Configuration();

    private StaticQueryContext context = new StaticQueryContext(configuration);

    private Map<String, Object> variables = new HashMap<String, Object>(); // variables

    private XPathFactory xPathFactory = XPathFactory.newInstance();

    private String namespace = ""; // 存储 string namespaces

    private Map<String, String> namespaces; // 存储 map namespaces

    private Document document;

    private XQueryNamespaceContext xQueryNamespaceContext = new XQueryNamespaceContext();

    private static final String xml_String = "xml";

    public Document getDocument()
    {
        return document;
    }

    public void setDocument(Document document)
    {
        this.document = document;
    }

    public Map<String, Object> getVariables()
    {
        return variables;
    }

    public String getNamespace()
    {
        return namespace;
    }

    public void setNamespace(String namespace)
    {
        this.namespace += namespace;
    }

    public Map<String, String> getNamespaces()
    {
        return namespaces;
    }

    public void setNamespaces(Map<String, String> namespaces)
    {
        this.namespaces = namespaces;
    }

    public XQueryHelper()
    {
    }

    public void init()
    {
        initParameterByXPath(CommonXqUtils.XPATH_HEADER,
                CommonXqUtils.XPATH_HEADER_NAME);
        initParameterByXPath(CommonXqUtils.XPATH_BODY,
                CommonXqUtils.XPATH_BODY_NAME);
    }

    /**
     * 通用
     * 
     * @param xqueryType
     *            选择转换类型[通用类型, xQuery类型, xslt类型]
     * @param expression
     *            xQuery脚本内容
     * @param values
     *            若是带参数,按照 key[参数名],value[参数值]存储
     * @param parameterName
     *            保存为全局变量参数名
     * @param methodType
     *            输出 转换以后 内容格式[xml,text,html,xhtml]
     * @return
     */
    private void assign(String xqueryType, String expression,
            Map<String, Object> values, String parameterName, String methodType)
    {
        executeXQuery(xqueryType, expression, values, parameterName, methodType);
    }

    /**
     * 
     * @param xqueryType
     *            选择转换类型[通用类型, xQuery类型, xslt类型]
     * @param xPath
     *            xPath路径
     * @param expression
     *            xQuery脚本内容, 必须是 Object[Node,Document,Element] 类型 可输入 xQuery
     *            表达式 可输入 已存在 参数名 格式是 @name[不允许 固定参数] 会造成迁移
     * @param values
     *            若是带参数,按照 key[参数名],value[参数值]存储
     * @param location
     *            插入位置
     * @param parameterName
     *            保存为全局变量参数名
     * @return
     */
    private void insert(String xqueryType, String xPath, String expression,
            Map<String, Object> values, String location, String parameterName)
    {
        Element elem = null;
        Node node = ((Node) getNodeByXpath(CommonXqUtils.parseXpath(xPath,
                parameterName),
                CommonXqUtils.getDocumentByObject(this.variables
                        .get(parameterName)), XPathConstants.NODE));
        if (expression.startsWith("@"))
        {
            expression = expression.substring(1);
            if (!CommonXqUtils.isFixedParameter(expression))
            {
                elem = transformerToDocument(CommonXqUtils.O2PProperty.INSERT,
                        expression, node, location);
                this.variables.put(parameterName, elem);
            }
        }
        else
        {
            assign(xqueryType, expression, values, "insert$^$insert",
                    xml_String);
            elem = transformerToDocument(CommonXqUtils.O2PProperty.INSERT,
                    "insert$^$insert", node, location);
            if (!CommonXqUtils.isFixedParameter(parameterName))
            {
                this.variables.put(parameterName, elem);
            }
        }
    }

    /**
     * 
     * @param xqueryType
     *            选择转换类型[通用类型, xQuery类型, xslt类型]
     * @param xPath
     *            xPath路径
     * @param expression
     *            xQuery脚本内容, 必须是 Object[Node,Document,Element] 类型 可输入 xQuery
     *            表达式 可输入 已存在 参数名 格式是 @name[不允许 固定参数] 会造成迁移
     * @param values
     *            若是带参数,按照 key[参数名],value[参数值]存储
     * @param location
     *            插入位置
     * @param parameterName
     *            保存为全局变量参数名
     * @return
     */
    private void replace(String xqueryType, String xPath, String expression,
            Map<String, Object> values, String location, String parameterName)
    {
        Element elem = null;
        Node node = ((Node) getNodeByXpath(CommonXqUtils.parseXpath(xPath,
                parameterName),
                CommonXqUtils.getDocumentByObject(this.variables
                        .get(parameterName)), XPathConstants.NODE));
        if (expression.startsWith("@"))
        {
            expression = expression.substring(1);
            if (!CommonXqUtils.isFixedParameter(expression))
            {
                elem = transformerToDocument(CommonXqUtils.O2PProperty.REPLACE,
                        expression, node, location);
                this.variables.put(parameterName, elem);
            }
        }
        else
        {
            assign(xqueryType, expression, values, "replace$^$replace",
                    xml_String);
            elem = transformerToDocument(CommonXqUtils.O2PProperty.REPLACE,
                    "replace$^$replace", node, location);
            if (!CommonXqUtils.isFixedParameter(parameterName))
            {
                this.variables.put(parameterName, elem);
            }
        }
    }

    /**
     * 执行XQuery
     * 
     * @param xqueryType
     * @param expression
     * @param values
     * @param parameterName
     * @param methodType
     * @return
     */
    private void executeXQuery(String xqueryType, String expression,
            Map<String, Object> values, String parameterName, String methodType)
    {
        XQueryExpression xQueryExpression = null;
        DynamicQueryContext dynamicQueryContext = null;
        StringWriter writer = null;
        StreamResult result = null;
        try
        {
            xQueryExpression = context
                    .compileQuery(this.namespace + expression);
            dynamicQueryContext = new DynamicQueryContext(configuration);
            dynamicQueryContext.setContextItem(new DocumentWrapper(document,
                    null, configuration));
            dynamicQueryContext.clearParameters();
            setParameters(dynamicQueryContext,
                    choiceValuesObject(xqueryType, values));
            Properties properties = new Properties();
            properties
                    .setProperty(OutputKeys.METHOD, (StringUtils
                            .isEmpty(methodType) ? xml_String : methodType));
            properties.setProperty(OutputKeys.INDENT, "yes");
            writer = new StringWriter();
            result = new StreamResult(writer);
            xQueryExpression.run(dynamicQueryContext, result, properties);
            if (!StringUtils.isEmpty(parameterName))
            {
                this.variables.put(parameterName,
                        returnParameterType(writer.toString(), methodType));
            }
        }
        catch (XPathException e)
        {
            LOG.error("XQueryHelper XPathException error", e);
            throw new EAAPException(EAAPTags.SEG_DRAVER_SIGN,
                    ErrorDomain.ERROR_CODE_9999, e.toString());
        }
    }

    /**
     * 实现xQuery方法执行
     * 
     * @param xquery
     * @param rule
     */
    public Object xQueryExecuteByMethod(XQueryHelper xquery,
            TransformerRule rule)
    {
        String[] param = null;
        for (int i = 0; i < rule.getParamVarMaps().size(); i++)
        {
            if (rule.getParamVarMaps().get(i).getKey().equals("param"))
            {
                param = rule.getParamVarMaps().get(i).getVal().split(",");
                break;
            }
        }
        String expression = rule.getScriptContent();
        if (param != null && param[0].equals(CommonXqUtils.O2PProperty.ASSIGN))
        {
            xquery.assign(param[4], expression,
                    param[3].length() > 0 ? new HashMap<String, Object>()
                            : null, param[2], param[1]);
        }
        else if (param != null
                && param[0].equals(CommonXqUtils.O2PProperty.INSERT))
        {
            xquery.insert(param[4], param[5], expression,
                    param[3].length() > 0 ? new HashMap<String, Object>()
                            : null, param[6], param[2]);
        }
        else if (param != null
                && param[0].equals(CommonXqUtils.O2PProperty.REPLACE))
        {
            xquery.replace(param[4], param[5], expression,
                    param[3].length() > 0 ? new HashMap<String, Object>()
                            : null, param[6], param[2]);
        }
        else if (param != null
                && param[0].equals(CommonXqUtils.O2PProperty.Assign_Route))
        {
            xquery.assign(param[4], expression,
                    param[3].length() > 0 ? new HashMap<String, Object>()
                            : null, param[2], param[1]);
            return xquery.variables.get(param[2]);
        }
        else if (param != null
                && param[0].equals(CommonXqUtils.O2PProperty.Insert_Route))
        {
            xquery.insert(param[4], param[5], expression,
                    param[3].length() > 0 ? new HashMap<String, Object>()
                            : null, param[6], param[2]);
            return xquery.variables.get(param[2]);
        }
        else if (param != null
                && param[0].equals(CommonXqUtils.O2PProperty.Replace_Route))
        {
            xquery.replace(param[4], param[5], expression,
                    param[3].length() > 0 ? new HashMap<String, Object>()
                            : null, param[6], param[2]);
            return xquery.variables.get(param[2]);
        }
        else if (param != null
                && param[0].equals(CommonXqUtils.O2PProperty.ROUTE))
        {
            return xquery.variables.get(param[1]);
        }
        return null;
    }

    /**
     * 设置xQuery参数
     * 
     * @param dynamicQueryContext
     *            动态查询上下文
     * @param values
     *            参数列表
     */
    private void setParameters(DynamicQueryContext dynamicQueryContext,
            Map<String, Object> values)
    {
        if (values != null)
        {
            Set<Entry<String, Object>> entrysSet = values.entrySet();
            for (Entry<String, Object> entry : entrysSet)
            {
                dynamicQueryContext.setParameter(entry.getKey(),
                        values.get(entry.getValue()));
            }
        }
    }

    /**
     * 根据类型 选择参数值对象[全局对象, 对应xQuery文件对应参数对象]
     * 
     * @param type
     *            选择类型
     * @param values
     *            传递xQuery文件对应参数对象, 可以为null
     * @return
     */
    private Map<String, Object> choiceValuesObject(String type,
            Map<String, Object> values)
    {
        if (type.equals(CommonXqUtils.XQueryProperty.NORMAL))
        {
            return this.variables;
        }
        else if (type.equals(CommonXqUtils.XQueryProperty.XQUERY))
        {
            return values;
        }
        else if (type.equals(CommonXqUtils.XQueryProperty.XSLT))
        {
            return null;
        }
        else
        {
            return null;
        }
    }

    /**
     * 
     * @param data
     *            输入xml数据
     * @param methodType
     *            输出 转换以后 内容格式[xml,text,html,xhtml]
     * @return
     */
    private Object returnParameterType(String data, String methodType)
    {
        Object obj = null;
        if (methodType.equals(xml_String))
        {
            obj = CommonXqUtils.parseXMLToW3cDocument(data);
            ;
        }
        else if ("html".equals(methodType))
        {
            obj = data;
        }
        else if ("text".equals(methodType))
        {
            obj = data;
        }
        else if ("xhtml".equals(methodType))
        {
            obj = data;
        }
        return obj;
    }

    /**
     * 根据 xPath 初始化参数, 存储在 Map
     * 
     * @param xPath
     * @param name
     *            参数名
     */
    private void initParameterByXPath(String xPath, String name)
    {
        Node node = ((Node) getNodeByXpath(xPath, this.document,
                XPathConstants.NODE));
        if (node == null)
        {
            this.variables.put(name, null);
        }
        else
        {
            this.variables.put(name, node);
        }
    }

    /**
     * 通过xPath 查找Document | Node | NodeList
     * 
     * @param xPath
     *            xPath语句
     * @param document
     *            org.w3c.dom.Document
     * @param returnType
     *            NODE | NODESET
     * @return Document | Node | NodeList
     */
    private Object getNodeByXpath(String xPath, org.w3c.dom.Document document,
            javax.xml.namespace.QName returnType)
    {
        Object obj = null;
        javax.xml.xpath.XPath xPathTmp = xPathFactory.newXPath();
        try
        {
            xPathTmp.setNamespaceContext(xQueryNamespaceContext);
            obj = xPathTmp.evaluate(xPath, document, returnType);
        }
        catch (XPathExpressionException e)
        {
            LOG.error(LogModel.EVENT_APP_EXCPT, e);
        }
        return obj;
    }

    /**
     * 
     * @param expression
     *            表达式
     * @param node
     *            转换根 节点
     * @param location
     *            插入位置
     * @return org.w3c.dom.Document
     */
    private Element transformerToDocument(String type, String expression,
            Node node, String location)
    {
        org.dom4j.Element element = CommonXqUtils.getDom4jDocumentByW3c(
                (Document) this.variables.get(expression)).getRootElement();
        Element elem = CommonXqUtils.getW3cElementByDom4jElement(element, node,
                null, type, location);
        return elem;
    }

    /**
     * xPath命名空间初始化
     */
    private class XQueryNamespaceContext implements NamespaceContext
    {
        @SuppressWarnings(
        { "rawtypes", "unchecked" })
        @Override
        public String getNamespaceURI(String prefix)
        {
            if (prefix == null)
            {
                throw new NullPointerException("Null prefix");
            }
            for (Iterator iterator = namespaces.entrySet().iterator(); iterator
                    .hasNext();)
            {
                Map.Entry<String, String> entry = (Map.Entry) iterator.next();
                if (prefix.equals(entry.getKey()))
                {
                    return entry.getValue();
                }
            }
            return "";
        }

        @Override
        public String getPrefix(String namespaceURI)
        {
            throw new UnsupportedOperationException();
        }

        @SuppressWarnings("rawtypes")
        @Override
        public Iterator getPrefixes(String namespaceURI)
        {
            throw new UnsupportedOperationException();
        }
    }
}
