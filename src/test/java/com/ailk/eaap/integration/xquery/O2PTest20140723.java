//package com.ailk.eaap.integration.xquery;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.w3c.dom.Document;
//
//import com.ailk.eaap.integration.o2p.transformer.XQueryTransformer;
//import com.ailk.eaap.integration.o2p.transformer.common.XQueryHelper;
//import com.ailk.eaap.op2.serviceagent.common.MessageBO;
//import com.ailk.eaap.op2.bo.ParamVarMap;
//import com.ailk.eaap.op2.bo.TransformerRule;
//
///**
// * Created by david on 14-7-23.
// */
//public class O2PTest20140723 {
//    XQueryHelper xquery = new XQueryHelper();
//    MessageBO<Document> messageBO = new MessageBO<Document>();
//
//    @Before
//    public void init() {
////        String path = "/install_apps/iso/xquery/demo1.xml";
////        String path = "/install_apps/iso/xquery/demo2.xml";
//    }
//
//    /**
//     * 测试使用
//     * @param messageBO
//     * @param xquery
//     * @param expression
//     * @param param
//     */
//    private void initParameter(MessageBO messageBO, XQueryHelper xquery, String expression, String param) {
//        String path = "/install_apps/iso/xquery/demo3.xml";
//        messageBO.setMsgBody(CommonXqUtils.getW3cDocumentByPath(path));
//        /**
//         * 保存脚本
//         * 保存具体参数
//         */
//        TransformerRule rule = new TransformerRule();
//        rule.setScriptContent(expression);
//        ParamVarMap paramVarMap = new ParamVarMap();
//        paramVarMap.setKey("param");
//        paramVarMap.setVal(param);
//        ParamVarMap paramVarMapNamespace = new ParamVarMap();
//        paramVarMapNamespace.setKey("namespace");
//        paramVarMapNamespace.setVal("saxon=http://saxon.sf.net/,soa=http://soa.ailk.telenor.com/wsdl/soa,sff=http://10.11.21.195:31033/services/SF4O2P");
//        List<ParamVarMap> list = new ArrayList<ParamVarMap>();
//        list.add(paramVarMap);
//        list.add(paramVarMapNamespace);
//        rule.setParamVarMaps(list);
//        /**
//         * 初始化namespace
//         */
//        String []namespaces = null;
//        for(int i=0; i<rule.getParamVarMaps().size(); i++) {
//            if(rule.getParamVarMaps().get(i).getKey().equals("namespace")) {
//                namespaces = rule.getParamVarMaps().get(i).getVal().split(",");
//                break;
//            }
//        }
//        Map<String, String> maps = new HashMap<String, String>();
//        if (namespaces != null) {
//        	for(String name : namespaces) {
//                maps.put(name.substring(0,name.indexOf("=")),name.substring(name.indexOf("=")+1));
//            }
//        }
//        
//        maps.putAll(com.ailk.eaap.integration.o2p.transformer.common.CommonXqUtils.getDefaultNamespace());
//        String namespace = "";
//        for(Iterator iterator = maps.entrySet().iterator(); iterator.hasNext();) {
//            Map.Entry<String, String> entry = (Map.Entry)iterator.next();
//            namespace += "declare namespace " + entry.getKey() + "=\"" + entry.getValue() + "\";";
//        }
//        xquery.setNamespace(namespace);
//        xquery.setNamespaces(maps);
//        xquery.setDocument((Document) messageBO.getMsgBody());
//        xquery.init();
//
//
//        System.out.println(xquery.xQueryExecuteByMethod(xquery, rule));
//    }
//
//    @Test
//    public void OTPTest1() {
//        String expression = "";
//        String param = "";
//        expression =
//                "data(/req/content/userId)";
//        param = "0,text,userId,,0";
//        initParameter(messageBO, xquery, expression, param);
//        System.out.println(xquery.getVariables().get("userId"));
//
//        expression =
//                "declare variable $userId as xs:string external;" +
//                        "concat('https://apihost/id/users/',$userId,'/accounts')";
//        param = "0,text,restUrl,,0";
//        initParameter(messageBO, xquery, expression, param);
//        System.out.println(xquery.getVariables().get("restUrl"));
//
//        expression =
//                "element req {" +
//                        "element content {" +
//                        "for $data in //content/* " +
//                        "let $name := local-name($data)" +
//                        "return if($name = 'userId') then null " +
//                        "else element {$name} { data($data) }" +
//                        "   }" +
//                        "}";
//        param = "0,xml,newBody,,0";
//        initParameter(messageBO, xquery, expression, param);
//        System.out.println(CommonXqUtils.getDom4jDocumentByW3c((Document) xquery.getVariables().get("newBody")).asXML());
//
//        messageBO.setMsgHead();
//    }
//
//    @Test
//    public void OTPTest2() {
//        String expression = "";
//        String param = "";
//
//        expression =
//                "declare variable $param as xs:string := 'http://ip:port/usermanagement-provisioning/service/telenordkuserprovisioning/createuserandsubscription?';" +
//                        "concat($param," +
//                        "'username=',data(/req/content/msisdn),'&amp;'" +
//                        ",'hashedPassword=',data(/req/content/hashedPassword),'&amp;'" +
//                        ",'customerId=',data(/req/content/customerId),'&amp;'" +
//                        ",'email=',data(/req/content/email),'&amp;'" +
//                        ",'subscriptionProductType=',data(/req/content/subscriptionProductType),'&amp;'" +
//                        ",'partnerKey=',data(/req/content/partnerKey))";
//        param = "0,text,restUrl,,0";
//        //http://ip:port/usermanagement-provisioning/service/telenordkuserprovisioning/createuserandsubscription?
//        // username=<MSISDN>&hashedPassword=&customerId=<BONUS_ID>&email=&registrationType=MSISDN
//        // &subscriptionProductType=<PRODUCT_TYPE>&partnerKey=<PARTNER_KEY>
//        initParameter(messageBO, xquery, expression, param);
//        System.out.println(xquery.getVariables().get("restUrl"));
//    }
//
//    @Test
//    public void OTPTest3() {
//        String expression = "";
//        String param = "";
//
//        long s = System.currentTimeMillis();
//        expression =
//                "element methodCall {" +
//                        "element methodName {" +
//                        "   Execute" +
//                        "}," +
//                        "element params {" +
//                        "   element param {" +
//                        "       element value {" +
//                        "           element struct {" +
//                        "               element member {" +
//                        "                   element name {" +
//                        "                       'Server'" +
//                        "                   }," +
//                        "                   element value {" +
//                        "                       'BM'" +
//                        "                   }" +
//                        "               }," +
//                        "               element member {" +
//                        "                   element name {" +
//                        "                       'Method'" +
//                        "                   }," +
//                        "                   element value {" +
//                        "                       'PlaceOrderAndAuthorize_API'" +
//                        "                   }" +
//                        "               }," +
//                        "               element member {" +
//                        "                   element name {" +
//                        "                       'Params'" +
//                        "                   }," +
//                        "                   element value {" +
//                        "                       element array {" +
//                        "                            element data {" +
//                        "                               comment { ' VendorAccountID ' }," +
//                        "                               element value { element i4 { data(//VendorAccountID) } }," +
//                        "                               comment { ' ProvisioningItemsCounter ' }," +
//                        "                               element value { element i4 { count(//products/product) } }," +
//                        "                               comment { ' ProvisioningDataSlotCounter ' }," +
//                        "                               element value { element i4 { count(//property/value) + count(//products/product) * 2 } }," +
//                        "                               for $data in //products/product " +
//                        "                               let $name := data($data/productType)" +
//                        "                               return if($name = 'host') then " +
//                        "                                  comment { ' ProvisioningItemID #0. ' }," +
//                        "                                  element value { element i4 { 0 } }," +
//                        "                                  comment { ' ProvisioningParametersCounter for the ProvisioningItem #0 ' }," +
//                        "                                  element value { element i4 { count($data/prodProperty/property) } }, " +
//                        "                                  for $cdata in $data/prodProperty/property " +
//                        "                                  return element value { concat(data($cdata/name),'=',data($cdata/value)) }" +
//                        "                               else if($name = 'domain') then " +
//                        "                                  comment { ' ProvisioningItemID #1. ' }," +
//                        "                                  element value { element i4 { 1 } }," +
//                        "                                  comment { ' ProvisioningParametersCounter for the ProvisioningItem #1 ' }," +
//                        "                                  element value { element i4 { count($data/prodProperty/property) } }, " +
//                        "                                  for $cdata in $data/prodProperty/property " +
//                        "                                  return element value { concat(data($cdata/name),'=',data($cdata/value)) }" +
//                        "                               else null ," +
//                        "                               comment { ' ContactDataCounter ' }," +
//                        "                               element value { element i4 { count(//content/ContactData/*) } }," +
//                        "                               for $data in //content/ContactData/* " +
//                        "                               return element value { concat(local-name($data),'=',data($data)) }" +
//                        "                            }" +
//                        "                       }" +
//                        "                   }" +
//                        "               }" +
//                        "           }" +
//                        "       }" +
//                        "   }" +
//                        "}" +
//                "}";
//        param = "0,xml,twoExecute,,0";
//        initParameter(messageBO, xquery, expression, param);
////        expression = "";
////        param = "01,twoExecute";
////        initParameter(messageBO, xquery, expression, param);
//        System.out.println(System.currentTimeMillis() - s);
//        System.out.println(CommonXqUtils.getDom4jDocumentByW3c((Document) xquery.getVariables().get("twoExecute")).asXML());
//
//        messageBO.setMsgHead();
//    }
//
//    @Test
//    public void test1() {
//        System.out.println(null instanceof Object);
//        String ss = "saxon=http://saxon.sf.net/,soa=http://soa.ailk.telenor.com/wsdl/soa,sff=http://10.11.21.195:31033/services/SF4O2P";
//        String []namespaces = null;
//        namespaces = ss.split(",");
//        for(String name : namespaces) {
//            System.out.println(name.substring(0,name.indexOf("=")) + "---" + name.substring(name.indexOf("=")+1));
//        }
//    }
//
//    String exp =
//            "element methodCall {" +
//            "element methodName {" +
//            "   Execute" +
//            "}," +
//            "element params {" +
//            "   element param {" +
//            "       element value {" +
//            "           element struct {" +
//            "               element member {" +
//            "                   element name {" +
//            "                       'Server'" +
//            "                   }," +
//            "                   element value {" +
//            "                       'BM'" +
//            "                   }" +
//            "               }," +
//            "               element member {" +
//            "                   element name {" +
//            "                       'Method'" +
//            "                   }," +
//            "                   element value {" +
//            "                       'PlaceOrderAndAuthorize_API'" +
//            "                   }" +
//            "               }," +
//            "               element member {" +
//            "                   element name {" +
//            "                       'Params'" +
//            "                   }," +
//            "                   element value {" +
//            "                       element array {" +
//            "                            element data {" +
//            "                               comment { ' VendorAccountID ' }," +
//            "                               element value { element i4 { data(//VendorAccountID) } }," +
//            "                               comment { ' ProvisioningItemsCounter ' }," +
//            "                               element value { element i4 { count(//products/product) } }," +
//            "                               comment { ' ProvisioningDataSlotCounter ' }," +
//            "                               element value { element i4 { count(//property/value) + count(//products/product) * 2 } }," +
//            "                               for $data in //products/product " +
//            "                               let $name := data($data/productType)" +
//            "                               return if($name = 'host') then " +
//            "                                  comment { ' ProvisioningItemID #0. ' }," +
//            "                                  element value { element i4 { 0 } }," +
//            "                                  comment { ' ProvisioningParametersCounter for the ProvisioningItem #0 ' }," +
//            "                                  element value { element i4 { count($data/prodProperty/property) } }, " +
//            "                                  for $cdata in $data/prodProperty/property " +
//            "                                  return element value { concat(data($cdata/name),'=',data($cdata/value)) }" +
//            "                               else if($name = 'domain') then " +
//            "                                  comment { ' ProvisioningItemID #1. ' }," +
//            "                                  element value { element i4 { 1 } }," +
//            "                                  comment { ' ProvisioningParametersCounter for the ProvisioningItem #1 ' }," +
//            "                                  element value { element i4 { count($data/prodProperty/property) } }, " +
//            "                                  for $cdata in $data/prodProperty/property " +
//            "                                  return element value { concat(data($cdata/name),'=',data($cdata/value)) }" +
//            "                               else null ," +
//            "                               comment { ' ContactDataCounter ' }," +
//            "                               element value { element i4 { count(//content/ContactData/*) } }," +
//            "                               for $data in //content/ContactData/* " +
//            "                               return element value { concat(local-name($data),'=',data($data)) }" +
//            "                            }" +
//            "                       }" +
//            "                   }" +
//            "               }" +
//            "           }" +
//            "       }" +
//            "   }" +
//            "}" +
//            "}";
//    String param2 = "00,xml,twoExecute,,0";
//
//    @Test
//    public void test2() {
//
//        String path = "/install_apps/iso/xquery/demo3.xml";
//        MessageBO messageBO1 = new MessageBO();
//        org.dom4j.Document document = com.ailk.eaap.integration.o2p.transformer.common.CommonXqUtils.getDom4jDocumentByW3c(CommonXqUtils.getW3cDocumentByPath(path));
//        messageBO1.setMsgBody(document);
//
//        /**
//         * 保存脚本
//         * 保存具体参数
//         */
//        TransformerRule rule = new TransformerRule();
//        exp = "data(/*)";
//        rule.setScriptContent(exp);
//        ParamVarMap paramVarMap = new ParamVarMap();
//        paramVarMap.setKey("param");
//        param2 = "00,text,twoExecute,,0";
//        paramVarMap.setVal(param2);
//        ParamVarMap paramVarMapNamespace = new ParamVarMap();
//        paramVarMapNamespace.setKey("namespace");
//        paramVarMapNamespace.setVal("saxon=http://saxon.sf.net/,soa=http://soa.ailk.telenor.com/wsdl/soa,sff=http://10.11.21.195:31033/services/SF4O2P");
//        List<ParamVarMap> list = new ArrayList<ParamVarMap>();
//        list.add(paramVarMap);
//        list.add(paramVarMapNamespace);
//        rule.setParamVarMaps(list);
//
//        XQueryTransformer xQueryTransformer = new XQueryTransformer();
//        xQueryTransformer.setTransformerRule(rule);
//        MessageBO messageBO2 = new MessageBO();
//        messageBO2 = xQueryTransformer.transform(messageBO1);
//
////        exp = "";
////        param2 = "10,twoExecute";
////        TransformerRule rule2 = new TransformerRule();
////        rule2.setScriptContent(exp);
////        ParamVarMap paramVarMap2 = new ParamVarMap();
////        paramVarMap2.setKey("param");
////        paramVarMap2.setVal(param2);
//////        ParamVarMap paramVarMapNamespace2 = new ParamVarMap();
//////        paramVarMapNamespace2.setKey("namespace");
//////        paramVarMapNamespace2.setVal("saxon=http://saxon.sf.net/,soa=http://soa.ailk.telenor.com/wsdl/soa,sff=http://10.11.21.195:31033/services/SF4O2P");
////        List<ParamVarMap> list2 = new ArrayList<ParamVarMap>();
////        list2.add(paramVarMap2);
//////        list2.add(paramVarMapNamespace2);
////        rule2.setParamVarMaps(list2);
////        xQueryTransformer.setTransformerRule(rule2);
////        MessageBO messageBO3 = new MessageBO();
////        messageBO3 = xQueryTransformer.transform(messageBO2);
////        System.out.println(messageBO3.getMsgBody() instanceof XQueryHelper);
////        System.out.println(messageBO3.getMsgBody() instanceof org.dom4j.Document);
////        System.out.println(((org.dom4j.Document)messageBO3.getMsgBody()).asXML());
////        System.out.println(((org.dom4j.Document)messageBO2.getMsgBody()).asXML());
//        System.out.println((messageBO2.getMsgBody().toString()));
//    }
//
//    @Test
//    public void test3() {
//        String path = "/install_apps/iso/xquery/cd_catalog.xml";
//        MessageBO messageBO1 = new MessageBO<Object>();
//        org.dom4j.Document document = com.ailk.eaap.integration.o2p.transformer.common.CommonXqUtils.getDom4jDocumentByW3c(CommonXqUtils.getW3cDocumentByPath(path));
//        messageBO1.setMsgBody(document);
//
//        XQueryTransformer xQueryTransformer = new XQueryTransformer();
//
//        String expression = "";
//        String param2 = "";
//        /**
//         * 第一步
//         */
//        expression =
//                "substring(local-name(//soap:Body/*),1,(string-length(local-name(//soap:Body/*))-(string-length(\"Request\"))))";
//        param2 = "0,html,interfaceName,,0";
//        TransformerRule rule = initR(expression, param2);
//        xQueryTransformer.setTransformerRule(rule);
//        messageBO1 = xQueryTransformer.transform(messageBO1);
//        /**
//         * 第二步
//         */
////        System.out.println(xquery.getVariables().size());
//        expression =
//                "declare variable $interfaceName as xs:string external;" +
//                        "<BusiCode name=\"123\">{$interfaceName}<C name=\"hello girl.\">321<B/></C></BusiCode>";
//        param2 = "1,xml,header,,0,//soa:RequestHeader,3";
//        rule = initR(expression, param2);
//        xQueryTransformer.setTransformerRule(rule);
//        messageBO1 = xQueryTransformer.transform(messageBO1);
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
//        param2 = "0,xml,sffRequest,,0";
//        rule = initR(expression, param2);
//        xQueryTransformer.setTransformerRule(rule);
//        messageBO1 = xQueryTransformer.transform(messageBO1);
//        /**
//         * 第四步
//         */
//        expression =
//                "@sffRequest";
//        param2 = "02,xml,body,,0,.,0";
//        rule = initR(expression, param2);
//        xQueryTransformer.setTransformerRule(rule);
//        messageBO1 = xQueryTransformer.transform(messageBO1);
////        /**
////         * 获得对象
////         */
////        expression =
////                "";
////        param2 = "01,body";
////        rule = initR(expression, param2);
////        xQueryTransformer.setTransformerRule(rule);
////        messageBO1 = xQueryTransformer.transform(messageBO1);
//
//        System.out.println("-----------------------");
//        System.out.println("-----------------------");
//        System.out.println("-----------------------");
////        p(((org.dom4j.Document)messageBO1.getMsgBody()).asXML());
//
//
//        path = "/install_apps/iso/tt/src.xml";
//        messageBO1 = new MessageBO<Object>();
//        document = com.ailk.eaap.integration.o2p.transformer.common.CommonXqUtils.getDom4jDocumentByW3c(CommonXqUtils.getW3cDocumentByPath(path));
//        messageBO1.setMsgBody(document);
//
////        System.out.println(((org.dom4j.Document)messageBO1.getMsgBody()).asXML());
//        System.out.println("-----------------------");
//        System.out.println("-----------------------");
//        System.out.println("-----------------------");
//        test2();
//    }
//
//    public void p(Object name) {
//        System.out.println(name);
//    }
//
//    public TransformerRule initR(String expression, String param2) {
//        /**
//         * 保存脚本
//         * 保存具体参数
//         */
//        TransformerRule rule = new TransformerRule();
//        rule.setScriptContent(expression);
//        ParamVarMap paramVarMap = new ParamVarMap();
//        paramVarMap.setKey("param");
//        paramVarMap.setVal(param2);
//        ParamVarMap paramVarMapNamespace = new ParamVarMap();
//        paramVarMapNamespace.setKey("namespace");
//        paramVarMapNamespace.setVal("saxon=http://saxon.sf.net/,soa=http://soa.ailk.telenor.com/wsdl/soa,sff=http://10.11.21.195:31033/services/SF4O2P");
//        List<ParamVarMap> list = new ArrayList<ParamVarMap>();
//        list.add(paramVarMap);
//        list.add(paramVarMapNamespace);
//        rule.setParamVarMaps(list);
//        return rule;
//    }
//
//    @Test
//    public void test5() {
//        String path = "/install_apps/iso/tt/src.xml";
//        MessageBO messageBO1 = new MessageBO<Object>();
//        org.dom4j.Document document = com.ailk.eaap.integration.o2p.transformer.common.CommonXqUtils.getDom4jDocumentByW3c(CommonXqUtils.getW3cDocumentByPath(path));
//        messageBO1.setMsgBody(document);
//
//        /**
//         * 保存脚本
//         * 保存具体参数
//         */
//        exp = "element ContractRoot {" +
//                "   element SvcCont {" +
//                "       element AuthenticationQryReq {" +
//                "           //AuthInfo/*" +
//                "       }" +
//                "   }," +
//                "   element TcpCont{" +
//                "   " +
//                "   }" +
//                "}";
//        param2 = "00,xml,twoExecute,,0";
//        TransformerRule rule = new TransformerRule();
//        rule.setScriptContent(exp);
//        ParamVarMap paramVarMap = new ParamVarMap();
//        paramVarMap.setKey("param");
//        paramVarMap.setVal(param2);
//        ParamVarMap paramVarMapNamespace = new ParamVarMap();
//        paramVarMapNamespace.setKey("namespace");
//        paramVarMapNamespace.setVal("saxon=http://saxon.sf.net/,ua=http://www.mbossuac.com.cn/ua");
//        List<ParamVarMap> list = new ArrayList<ParamVarMap>();
//        list.add(paramVarMap);
//        list.add(paramVarMapNamespace);
//        rule.setParamVarMaps(list);
//
//        XQueryTransformer xQueryTransformer = new XQueryTransformer();
//        xQueryTransformer.setTransformerRule(rule);
//        messageBO1 = xQueryTransformer.transform(messageBO1);
//        System.out.println(((org.dom4j.Document)messageBO1.getMsgBody()).asXML());
//    }
//
//    @Test
//    public void test6() {
//        String path = "/install_apps/iso/tt/src2.xml";
//        MessageBO messageBO1 = new MessageBO<Object>();
//        org.dom4j.Document document = com.ailk.eaap.integration.o2p.transformer.common.CommonXqUtils.getDom4jDocumentByW3c(CommonXqUtils.getW3cDocumentByPath(path));
//        messageBO1.setMsgBody(document);
//        messageBO1.setReqorrsp("0");
//
//        /**
//         * 保存脚本
//         * 保存具体参数
//         */
//        exp = "element soap:Envelope {" +
//                "   element soap:Header {" +
//                "       element isSuccess{" +
//                "           1" +
//                "       }" +
//                "   }," +
//                "   element soap:Body{" +
//                "        element newRaaKobberResponse {" +
//                "           /*" +
//                    "       }" +
//                "   }" +
//                "}";
//        param2 = "00,xml,twoExecute,,0";
//        TransformerRule rule = new TransformerRule();
//        rule.setScriptContent(exp);
//        ParamVarMap paramVarMap = new ParamVarMap();
//        paramVarMap.setKey("param");
//        paramVarMap.setVal(param2);
//        ParamVarMap paramVarMapNamespace = new ParamVarMap();
//        paramVarMapNamespace.setKey("namespace");
//        paramVarMapNamespace.setVal("urn=http:www.baidu.com");
//        List<ParamVarMap> list = new ArrayList<ParamVarMap>();
//        list.add(paramVarMap);
//        list.add(paramVarMapNamespace);
//        rule.setParamVarMaps(list);
//
//        XQueryTransformer xQueryTransformer = new XQueryTransformer();
//        xQueryTransformer.setTransformerRule(rule);
//        messageBO1 = xQueryTransformer.transform(messageBO1);
//        System.out.println(((org.dom4j.Document)messageBO1.getMsgBody()).asXML());
//    }
//}
