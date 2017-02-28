//package com.ailk.eaap.integration.xquery;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//
//import org.dom4j.Attribute;
//import org.dom4j.Element;
//import org.junit.Test;
//import org.w3c.dom.Document;
//
//import com.ailk.eaap.integration.o2p.transformer.XQueryTransformerTest;
//import com.ailk.eaap.op2.serviceagent.common.MessageBO;
//import com.ailk.eaap.op2.bo.ParamVarMap;
//import com.ailk.eaap.op2.bo.TransformerRule;
//
///**
// * Created by david on 14-7-21.
// */
//public class XQueryTest {
//    @Test
//    public void test1() {
//        XQueryTransformerTest test = new XQueryTransformerTest();
//        String path = "/install_apps/iso/xquery/cd_catalog.xml";
//        test.setDocument(CommonXqUtils.getW3cDocumentByPath(path));
//        String str = null;
//        String query = CommonXqUtils.xq_namespace + "substring(local-name(//soapenv:Body/*),1,(string-length(local-name(//soapenv:Body/*))-(string-length(\"Request\"))))";
//        test.assign(XQueryTransformerTest.XQueryProperty.NORMAL, query, null, "interfaceName", "text");
//    }
//
//    /**
//     * 切记, xPath 路径一定要带 namespace
//     * 若 xQuery 是 function, 配置为 XQueryProperty.XQUERY, 这时候需要传入新 values
//     * 若 xQuery 是 普通脚本, 配置为 XQueryProperty.NORMAL, 可以调用当前保存的全局 variables
//     *
//     * 若 只想拿到 标签内的值, 配置为 text
//     * 若 想拿到 标签和值, 配置为 html
//     * 若 想拿到xml格式的内容, 配置为 xml
//     */
//    @Test
//    public void test2() {
//        XQueryTransformerTest test = new XQueryTransformerTest();
//        String path = "/install_apps/iso/xquery/cd_catalog.xml";
//        test.setDocument(CommonXqUtils.getW3cDocumentByPath(path));
//        String query = CommonXqUtils.xq_namespace + "substring(local-name(//soapenv:Body/*),1,(string-length(local-name(//soapenv:Body/*))-(string-length(\"Request\"))))";
//        test.assign(XQueryTransformerTest.XQueryProperty.NORMAL, query, null, "interfaceName", "text");
//        System.out.println(test.getVariables().get("interfaceName"));
//    }
//
//    @Test
//    public void test3() {
//        XQueryTransformerTest test = new XQueryTransformerTest();
//        String path = "/install_apps/iso/xquery/cd_catalog.xml";
////        test.setDocument(CommonXqUtils.getW3cDocumentByDom4j(CommonXqUtils.getDom4jDocument(path)));
//        test.setDocument(CommonXqUtils.getW3cDocumentByPath(path));
//
//        // 第一个 message
//        String query = CommonXqUtils.xq_namespace + "substring(local-name(//soap:Body/*),1,(string-length(local-name(//soap:Body/*))-(string-length(\"Request\"))))";
//        test.assign(XQueryTransformerTest.XQueryProperty.NORMAL, query, null, "interfaceName", "html");
//        // 第二个 message
//        String query2 = CommonXqUtils.xq_namespace +
//                "declare variable $interfaceName as xs:string external;" +
//                "<BusiCode>{$interfaceName}</BusiCode>";
////        test.insert(XQueryTransformerTest.XQueryProperty.NORMAL, "declare namespace www=\"http://soa.ailk.telenor.com/wsdl/soa\";//www:RequestHeader", query2, null, "3", "header", "xml");
//        test.insert(XQueryTransformerTest.XQueryProperty.NORMAL, "declare namespace www=\"http://soa.ailk.telenor.com/wsdl/soa\";//www:RequestHeader", query2, null, "2", "header", "xml");
////        System.out.println(test.insert(XQueryProperty.NORMAL, "//RequestHeader", query2, null, 1, "header", "html").toString());
////        System.out.println(test.insert(XQueryProperty.NORMAL, "//RequestHeader", query2, null, 2, "header", "html").toString());
//
//        // 第三个 message
//        String query3 = CommonXqUtils.xq_namespace +
//                "declare namespace sff = \"http://10.11.21.195:31033/services/SF4O2P\";" +
//                "declare namespace saxon=\"http://saxon.sf.net/\";" +
//                "declare variable $header as node()* external;" +
//                "let $d := " +
//                "           element ContractRoot{ " +
//                "               element RequestHead{ " +
//                "                   for $var in $header/*/* " +
//                "                   return element {data(local-name($var))} { " +
//                "                   data($var)" +
//                "                   } " +
//                "               }," +
//                "               //soap:Body/*/*" +
//                "           }" +
//                "return element sff:HandlerO2p { " +
//                "   element sXml { " +
//                "       saxon:serialize(" +
//                "           $d, 'html'" +
//                "       )" +
//                "   }" +
//                "}";
//        test.assign(XQueryTransformerTest.XQueryProperty.NORMAL, query3, null, "sffRequest", "xml");
//
//        // 第四个 message
//        String query4 = CommonXqUtils.xq_namespace +
//                "declare variable $sffRequest as node()* external;" +
//                "element soap:Envelope { " +
//                "   element soap:Header {" +
//                "   }, " +
//                "   element soap:Body {" +
//                "       $sffRequest" +
//                "   }" +
//                "}";
//        test.assign(XQueryTransformerTest.XQueryProperty.NORMAL, query4, null, "sffRequestEnd", "xml");
//
//        // 验证
//        org.dom4j.Document doc = CommonXqUtils.getDom4jDocumentByW3c((Document) test.getVariables().get("sffRequestEnd"));
//        System.out.println(doc.asXML());
//        Element element = doc.getRootElement();
//        tt(element);
//    }
//
//    @Test
//    public void test4() {
//        XQueryTransformerTest test = new XQueryTransformerTest();
//        String path = "/install_apps/iso/xquery/cd_catalog.xml";
//        test.setDocument(CommonXqUtils.getW3cDocumentByPath(path));
//        String xPath = "//RequestHeader";
//        String query = CommonXqUtils.xq_namespace +
//                "declare namespace saxon=\"http://saxon.sf.net/\";" +
//                "declare namespace cc=\"http://soa.ailk.telenor.com/wsdl/soa\";" +
//                "local-name(//cc:RequestHeader/..)";
//        test.assign(XQueryTransformerTest.XQueryProperty.NORMAL, query, null, null, "html");
//    }
//
//    @Test
//    public void test5() {
//        MessageBO<Document> messageBO = new MessageBO<Document>();
//        XQueryTransformerTest xquery = new XQueryTransformerTest();
//        String path = "/install_apps/iso/xquery/cd_catalog.xml";
//        messageBO.setMsgBody(CommonXqUtils.getW3cDocumentByPath(path));
//
//        String expression =
//                "substring(local-name(//soap:Body/*),1,(string-length(local-name(//soap:Body/*))-(string-length(\"Request\"))))";
//        String param = "0,html,interfaceName,,0";
//        initParameter(messageBO, xquery, expression, param);
//
//        expression =
//                "declare variable $interfaceName as xs:string external;" +
//                        "<BusiCode>{$interfaceName}</BusiCode>";
//        param = "1,xml,header,,0,//soa:RequestHeader,0";
//        initParameter(messageBO, xquery, expression, param);
//
//        expression =
//                "declare variable $header as node()* external;" +
//                "let $d := " +
//                "           element ContractRoot{ " +
//                "               element RequestHead{ " +
//                "                      $header/*/* " +
////                        "                   for $var in $header/*/* " +
////                        "                   return element {data(local-name($var))} { " +
////                        "                   data($var)" +
////                        "                   } " +
//                "               }," +
//                "               //soap:Body/*/*" +
//                "           }" +
//                "return element sff:HandlerO2p { " +
//                "   element sXml { " +
//                "       saxon:serialize(" +
//                "           $d, 'html'" +
//                "       )" +
//                "   }" +
//                "}";
//        param = "0,xml,sffRequest,,0";
//        initParameter(messageBO, xquery, expression, param);
//
//        expression =
//                "declare variable $sffRequest as node()* external;" +
//                        "element soap:Envelope { " +
//                        "   element soap:Header {" +
//                        "   }, " +
//                        "   element soap:Body {" +
//                        "       $sffRequest" +
//                        "   }" +
//                        "}";
//        param = "0,xml,sffRequestEnd,,0";
//        initParameter(messageBO, xquery, expression, param);
//
//        System.out.println(xquery.getVariables().get("interfaceName"));
//        System.out.println(CommonXqUtils.getDom4jDocumentByW3c((Document)xquery.getVariables().get("header")).asXML());
//        System.out.println(CommonXqUtils.getDom4jDocumentByW3c((Document)xquery.getVariables().get("sffRequest")).asXML());
//        System.out.println(CommonXqUtils.getDom4jDocumentByW3c((Document) xquery.getVariables().get("sffRequestEnd")).asXML());
//    }
//
//    @Test
//    public void test6() {
//        MessageBO<Document> messageBO = new MessageBO<Document>();
//        XQueryTransformerTest xquery = new XQueryTransformerTest();
//        String path = "/install_apps/iso/xquery/cd_catalog.xml";
//        messageBO.setMsgBody(CommonXqUtils.getW3cDocumentByPath(path));
//        String expression = "";
//        String param = "";
//
//        expression =
//                "declare variable $interfaceName as xs:string external;" +
//                        "<BusiCode>{$interfaceName}</BusiCode>";
//        param = "1,xml,header,,0,declare namespace www=\"http://soa.ailk.telenor.com/wsdl/soa\";//www:RequestHeader,0";
//        initParameter(messageBO, xquery, expression, param);
//    }
//
//    /**
//     * header, body 是固定参数
//     * parameter 可选
//     * 如果 assign[0] 返回是带格式的 string 类型, 标识为 html | 返回是 Object[Node,Document,Element] 类型, 标识为 xml
//     *               返回不带格式的 string 类型, 标识为 text
//     * 如果 insert[1] 返回是 Object[Node,Document,Element] 类型, 无需标识[默认是 xml], 标识无效
//     *               location 有 Before[0], After[1], AS_FIRST_CHILD_OF[2], AS_LAST_CHILD_OF[3]
//     *               xPath 必须是完整的带 prefix 的路径
//     *               expression 必须是Object[Node,Document,Element] 类型
//     *               parameter 不允许不存在, 且必须为 Object[Node,Document,Element] 类型
//     * 如果 replace[2]
//     */
//    @Test
//    public void test7() {
//        MessageBO<Document> messageBO = new MessageBO<Document>();
//        XQueryTransformerTest xquery = new XQueryTransformerTest();
//        String path = "/install_apps/iso/xquery/cd_catalog.xml";
//        messageBO.setMsgBody(CommonXqUtils.getW3cDocumentByPath(path));
//        /**
//         * 初始化namespace
//         */
//        Map<String, String> namespaces = new HashMap<String, String>();
//        namespaces.put("saxon","http://saxon.sf.net/");
//        namespaces.put("soa","http://soa.ailk.telenor.com/wsdl/soa");
//        namespaces.put("sff","http://10.11.21.195:31033/services/SF4O2P");
//        String namespace = CommonXqUtils.xq_namespace;
//        for(Iterator iterator = namespaces.entrySet().iterator(); iterator.hasNext();) {
//            Map.Entry<String, String> entry = (Map.Entry)iterator.next();
//            namespace += "declare namespace " + entry.getKey() + "=\"" + entry.getValue() + "\";";
//        }
//        xquery.setNamespace(namespace);
//        xquery.setNamespaces(namespaces);
//        xquery.setDocument((Document)messageBO.getMsgBody());
//        xquery.init();
//
//        long x = System.currentTimeMillis();
//        /**
//         * 第一步
//         */
//        String expression =
//                "substring(local-name(//soap:Body/*),1,(string-length(local-name(//soap:Body/*))-(string-length(\"Request\"))))";
//        String param = "0,html,interfaceName,,0";
//        initParameter(messageBO, xquery, expression, param);
//
//        /**
//         * 第二步
//         */
////        System.out.println(xquery.getVariables().size());
//        expression =
//                "declare variable $interfaceName as xs:string external;" +
//                        "<BusiCode name=\"123\">{$interfaceName}<C name=\"hello girl.\">321<B/></C></BusiCode>";
//        param = "1,xml,header,,0,//soa:RequestHeader,2";
//        initParameter(messageBO, xquery, expression, param);
//
////        expression =
////                "declare variable $interfaceName as xs:string external;" +
////                        "<BusiCode name=\"123\">{$interfaceName}<C name=\"hello girl.\">321<B/></C></BusiCode>";
////        param = "1,xml,sss,,0,//soa:RequestHeader,0";
////        initParameter(messageBO, xquery, expression, param);
////        System.out.println(xquery.getVariables().size());
//
////        expression =
////                "declare variable $header as element()* external;" +
////                        "element cc { $header/* }";
////        param = "0,xml,cc,,0";
////        initParameter(messageBO, xquery, expression, param);
//
//        /**
//         * 第三步
//         */
//        expression =
//                "declare variable $header as node()* external;" +
//                        "let $d := " +
//                        "           element ContractRoot{ " +
//                        "               element RequestHead{ " +
//                        "                      $header/* " +
////                        "                   for $var in $header/*/* " +
////                        "                   return element {data(local-name($var))} { " +
////                        "                   data($var)" +
////                        "                   } " +
//                        "               }," +
//                        "               //soap:Body/*/*" +
//                        "           }" +
//                        "return element sff:HandlerO2p { " +
//                        "   element sXml { " +
//                        "       saxon:serialize(" +
//                        "           $d, 'html'" +
//                        "       )" +
//                        "   }" +
//                        "}";
//        // 第一个表示 assgin 或者 insert等
//        // 第二个表示 存储为 String 还是 Document
//        // 第三个表示 存储对象名
//        // 第四个表示 函数输入参数对应id
//        // 第五个表示 是使用 对象参数[0] 还是 传入临时函数参数[1]
//        param = "0,xml,sffRequest,,0";
//        initParameter(messageBO, xquery, expression, param);
//
//        expression =
//                "declare variable $sffRequest as node()* external;" +
//                "declare variable $header as node()* external;" +
//                        "element soap:Envelope { " +
//                        "   element soap:Header {" +
//                        "   }, " +
//                        "   element soap:Body {" +
//                        "       $sffRequest" +
//                        "   }" +
//                        "}";
//        param = "0,xml,sffRequestEnd,,0";
//        initParameter(messageBO, xquery, expression, param);
//
////        System.out.println(CommonXqUtils.getDom4jDocumentByW3c((Document)xquery.getVariables().get("sffRequest")).asXML());
//        System.out.println(CommonXqUtils.getDom4jDocumentByW3c((Document)xquery.getVariables().get("sffRequestEnd")).asXML());
//    }
//
//    @Test
//    public void test8() {
//        MessageBO<Document> messageBO = new MessageBO<Document>();
//        XQueryTransformerTest xquery = new XQueryTransformerTest();
//        String path = "/install_apps/iso/xquery/cd_catalog.xml";
//        messageBO.setMsgBody(CommonXqUtils.getW3cDocumentByPath(path));
//        /**
//         * 初始化namespace
//         */
//        Map<String, String> namespaces = new HashMap<String, String>();
//        namespaces.put("saxon","http://saxon.sf.net/");
//        namespaces.put("soa","http://soa.ailk.telenor.com/wsdl/soa");
//        namespaces.put("sff","http://10.11.21.195:31033/services/SF4O2P");
//        String namespace = CommonXqUtils.xq_namespace;
//        for(Iterator iterator = namespaces.entrySet().iterator(); iterator.hasNext();) {
//            Map.Entry<String, String> entry = (Map.Entry)iterator.next();
//            namespace += "declare namespace " + entry.getKey() + "=\"" + entry.getValue() + "\";";
//        }
//        xquery.setNamespace(namespace);
//        xquery.setNamespaces(namespaces);
//        xquery.setDocument((Document)messageBO.getMsgBody());
//        xquery.init();
//
////        System.out.println(CommonXqUtils.getDom4jDocumentByW3c(CommonXqUtils.getDocumentByObject(xquery.getVariables().get("header"))).asXML());
//        /**
//         * 第一步
//         */
//        String expression =
//                "declare variable $body as node()* external;" +
//                        "element cc { element zz { element sa { 1 }, element sb { 2 }} }";
//        String param = "0,xml,cc,,0";
//        initParameter(messageBO, xquery, expression, param);
//
//        expression =
//                "declare variable $body as node()* external;" +
//                        "element bb { element zz { element sa { 1 }, element sb { 2 }} }";
//        param = "0,xml,ff,,0";
//        initParameter(messageBO, xquery, expression, param);
//
//        expression =
//                "declare variable $body as node()* external;" +
//                        "comment { abc }, element bb { element zz { element sa { 1 }, element sb { 2 }} }";
//        param = "0,xml,hh,,0";
//        initParameter(messageBO, xquery, expression, param);
//
//
//        expression =
//                "@ff";
//        param = "1,xml,cc,,0,./*,2";
//        initParameter(messageBO, xquery, expression, param);
//
//        expression =
//                "@ff";
//        param = "1,xml,header,,0,//soa:RequestHeader,2";
//        initParameter(messageBO, xquery, expression, param);
//
//        expression =
//                "@ff";
//        param = "2,xml,cc,,0,./*,0";
//        initParameter(messageBO, xquery, expression, param);
//        System.out.println(CommonXqUtils.getDom4jDocumentByW3c(CommonXqUtils.getDocumentByObject(xquery.getVariables().get("cc"))).asXML());
////        expression =
////                "declare variable $cc as node()* external;" +
////                        "element cc { $cc }";
////        param = "0,xml,ss,,0";
////        initParameter(messageBO, xquery, expression, param);
//
////        System.out.println(CommonXqUtils.getDom4jDocumentByW3c(xquery.getDocument()).asXML());
//        System.out.println("-----------------------");
//        System.out.println("-----------------------");
//        System.out.println("-----------------------");
////        System.out.println(CommonXqUtils.getDom4jDocumentByW3c((Document) xquery.getVariables().get("cc")).asXML());
//        System.out.println("-----------------------");
//        System.out.println("-----------------------");
//        System.out.println("-----------------------");
////        System.out.println(CommonXqUtils.getDom4jDocumentByW3c((Document) xquery.getVariables().get("zz")).asXML());
//    }
//
//    /**
//     * 测试使用
//     * @param messageBO
//     * @param xquery
//     * @param expression
//     * @param param
//     */
//    private void initParameter(MessageBO messageBO, XQueryTransformerTest xquery, String expression, String param) {
//        /**
//         * 保存脚本
//         * 保存具体参数
//         */
//        TransformerRule rule = new TransformerRule();
//        rule.setScriptContent(expression);
//        ParamVarMap paramVarMap = new ParamVarMap();
//        paramVarMap.setKey("param");
//        paramVarMap.setVal(param);
//        List<ParamVarMap> list = new ArrayList<ParamVarMap>();
//        list.add(paramVarMap);
//        rule.setParamVarMaps(list);
//
//        xquery.xQueryExecuteByMethod(xquery, rule);
//    }
//
//    @Test
//    public void test9() {
//        MessageBO<Document> messageBO = new MessageBO<Document>();
//        XQueryTransformerTest xquery = new XQueryTransformerTest();
//        String path = "/install_apps/iso/xquery/cd_catalog.xml";
//        messageBO.setMsgBody(CommonXqUtils.getW3cDocumentByPath(path));
//        /**
//         * 初始化namespace
//         */
//        Map<String, String> namespaces = new HashMap<String, String>();
//        namespaces.put("saxon","http://saxon.sf.net/");
//        namespaces.put("soa","http://soa.ailk.telenor.com/wsdl/soa");
//        namespaces.put("sff","http://10.11.21.195:31033/services/SF4O2P");
//        String namespace = CommonXqUtils.xq_namespace;
//        for(Iterator iterator = namespaces.entrySet().iterator(); iterator.hasNext();) {
//            Map.Entry<String, String> entry = (Map.Entry)iterator.next();
//            namespace += "declare namespace " + entry.getKey() + "=\"" + entry.getValue() + "\";";
//        }
//        xquery.setNamespace(namespace);
//        xquery.setNamespaces(namespaces);
//        xquery.setDocument((Document)messageBO.getMsgBody());
//        xquery.init();
//
//        /**
//         * 第一步
//         */
//        String expression =
//                "substring(local-name(//soap:Body/*),1,(string-length(local-name(//soap:Body/*))-(string-length(\"Request\"))))";
//        String param = "0,html,interfaceName,,0";
//        initParameter(messageBO, xquery, expression, param);
//
//        /**
//         * 第二步
//         */
////        System.out.println(xquery.getVariables().size());
//        expression =
//                "declare variable $interfaceName as xs:string external;" +
//                        "<BusiCode name=\"123\">{$interfaceName}<C name=\"hello girl.\">321<B/></C></BusiCode>";
//        param = "1,xml,header,,0,//soa:RequestHeader,3";
//        initParameter(messageBO, xquery, expression, param);
//
//        /**
//         * 第三步
//         */
//        expression =
//                "declare variable $header as node()* external;" +
//                        "let $d := " +
//                        "           element ContractRoot{ " +
//                        "               element RequestHead{ " +
//                        "                      $header/* " +
//                        "               }," +
//                        "               //soap:Body/*/*" +
//                        "           }" +
//                        "return element sff:HandlerO2p { " +
//                        "   element sXml { " +
//                        "       saxon:serialize(" +
//                        "           $d, 'html'" +
//                        "       )" +
//                        "   }" +
//                        "}";
//        param = "0,xml,sffRequest,,0";
//        initParameter(messageBO, xquery, expression, param);
//        /**
//         * 第四步
//         */
//        expression =
//                "@sffRequest";
//        param = "2,xml,body,,0,.,0";
//        initParameter(messageBO, xquery, expression, param);
//        System.out.println("-----------------------");
//        System.out.println("-----------------------");
//        System.out.println("-----------------------");
//        System.out.println(CommonXqUtils.getDom4jDocumentByW3c(xquery.getDocument()).asXML());
//    }
//
//    private void tt(Element element) {
//        for(Iterator its =  element.elementIterator();its.hasNext();) {
//            Element chileEle = (Element)its.next();
//            System.out.println(chileEle.getName());
//            // 枚举属性
//            for (Iterator ia = chileEle.attributeIterator(); ia.hasNext();) {
//                Attribute attribute = (Attribute) ia.next();
//                System.out.println(attribute.getName() + "=" + attribute.getValue());
//            }
//            if(!chileEle.getTextTrim().equals("") && !chileEle.getTextTrim().equals(null)) {
//                System.out.println(chileEle.getText());
//            }
//            tt(chileEle);
//        }
//    }
//
//    @Test
//    public void t() {
//        String name ="@para";
//        System.out.println(name.startsWith("@@"));
//        System.out.println(name.substring(1));
////        String path = "/install_apps/iso/xquery/cd_catalog.xml";
////        XQueryTransformerTest test = new XQueryTransformerTest();
////        test.setDocument(CommonXqUtils.getW3cDocumentByPath(path));
////        /**
////         * 初始化namespace
////         */
////        Map<String, String> namespaces = new HashMap<String, String>();
////        namespaces.put("saxon","http://saxon.sf.net/");
////        namespaces.put("soa","http://soa.ailk.telenor.com/wsdl/soa");
////        namespaces.put("sff","http://10.11.21.195:31033/services/SF4O2P");
////        String namespace = CommonXqUtils.xq_namespace;
////        for(Iterator iterator = namespaces.entrySet().iterator(); iterator.hasNext();) {
////            Map.Entry<String, String> entry = (Map.Entry)iterator.next();
////            namespace += "declare namespace " + entry.getKey() + "=\"" + entry.getValue() + "\";";
////        }
////        test.setNamespace(namespace);
////        test.setNamespaces(namespaces);
////        test.init();
////        System.out.println(((Node) test.variables.get("header")).getNodeName());
////        System.out.println(((Node) test.variables.get("body")).getNodeName());
//    }
//}
