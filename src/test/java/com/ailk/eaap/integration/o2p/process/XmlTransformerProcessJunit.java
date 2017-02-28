package com.ailk.eaap.integration.o2p.process;

import java.util.List;

import net.sf.json.JSONObject;

import org.apache.commons.io.FileUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.ailk.eaap.integration.o2p.transformer.service.TransformerRuleService;
import com.ailk.eaap.o2p.common.cache.CacheKey;
import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.ailk.eaap.op2.bo.MessageDesc;
import com.ailk.eaap.op2.bo.NodeDesc;
import com.asiainfo.integretion.o2p.serviceagent.cache.CacheServiceImpl;

public class XmlTransformerProcessJunit {
	ApplicationContext ctx;
	private CacheServiceImpl cacheService;

	MessageDesc md = new MessageDesc();

	@SuppressWarnings("unchecked")
	@Test
	public void JsonToXml() {
		cacheService.addByModuleName(CacheKey.MODULE_TRANSFORMER_RULE, null);
		MessageBO<JSONObject> srcMsg = new MessageBO<JSONObject>();
		JSONObject playload = JSONObject.fromObject(json);
		srcMsg.setMsgBody(playload);
		TransformerRuleService transformerRuleService = (TransformerRuleService) ctx
				.getBean("transformerRuleService");
		MessageBO<Document> retmsg = ((MessageBO<Document>) transformerRuleService
				.doTransform(srcMsg, 97));
		System.out.println(retmsg.getMsgBody().asXML());
	}

	@SuppressWarnings("unchecked")
	@Test
	public void bbsJunit() throws Exception {
		String srcDataPath = "com/ailk/eaap/integration/o2p/process/bbs.xml";
		Resource srcDataResource = new ClassPathResource(srcDataPath);
		Document xml = DocumentHelper.parseText(FileUtils
				.readFileToString(srcDataResource.getFile()));
		// System.out.println(xml.asXML());
		String path = "//*[local-name()='TemplateData']";
		List<Element> list = xml.selectNodes(path);
		if (list.size() == 1) {
			Element e = list.get(0);
			// System.out.println(e.asXML());
			if (e.getText().toString().split("\n").length > 1) {
				System.out.println("111");
			}
			System.out.println("text " + e.getText());
		}
	}

	@Test
	public void test() throws Exception {

		JsonTransformerProcessIn jtp = new JsonTransformerProcessIn();
		MessageBO<JSONObject> bo = new MessageBO<JSONObject>();
		bo.setMsgBody(JSONObject.fromObject(xml));
		NodeDesc nd = new NodeDesc();
		// nd.setNodePath("$.customer.birthName");
		// nd.setNodePath("$.customer.callbackAddress");
		// nd.setNodePath("$.customer.document.documentNumber");
		nd.setNodePath("$.tenantId");
		Object o = jtp.parseNodeValBySrcMsg(bo, null, nd);
		System.out.println("jsonpath : " + o);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void Xml() throws DocumentException {
		Document doc = DocumentHelper.parseText(webservice);
		List<Node> list = doc.selectNodes("//RspCode");
		System.out.println(list.size());
		Node node = list.get(0);
		System.out.println(node.getText());

		Node n = doc.selectSingleNode("//RspCode");
		System.out.println("---" + n.getText());
	}

	@SuppressWarnings("unchecked")
	@Test
	public void ser() throws DocumentException {
		Document doc = DocumentHelper.parseText(ser);
		List<Node> list = doc.selectNodes("/SiebelMessage/RetCode");
		System.out.println(list.size());
		Node node = list.get(0);
		System.out.println(node.getText());

	}

	@Before
	public void setUp() throws Exception {
		String[] configLocations = new String[] {
				"classpath:o2p-transform-spring-all.xml",
				"classpath:eaap-op2-memCache-all.xml",
				"classpath:spring/eaap-op2-common-spring.xml" };
		ctx = new ClassPathXmlApplicationContext(configLocations);
		cacheService = (CacheServiceImpl) ctx.getBean("cacheService");
		
	}

	String json = "{" + "\"transactionDateTime\":\"2014-01-01\","
			+ "\"customerId\":\"123456\"," + "\"channel\":\"654321\","
			+ "\"posAgentCode\":\"qweasd\"" + "}";

	String ser = "<SiebelMessage>" + "<RetCode>0000</RetCode>"
			+ "<RetMsg>返回说明</RetMsg>" + "</SiebelMessage>";

	String xml = "{" + "\"tenantId\":\"100\"," + "\"loginName\":\"awarx\","
			+ "\"validateType \":\"1\"," + "\"validateScene \":\"2\","
			+ "\"sendTo\":\"13620003456\"," + "\"accType\":99" + "}";
	// "{\"customer\":{\"birthName\":\"20011015\",\"callbackAddress\":\"福建福州鼓楼区\","
	// + "\"dateOfBirth\":\"20140101\",\"motherName\":\"鼓励\",\"name\":\"福大\","
	// +
	// "\"operatorsGeneratedID\":\"66612312321343435\",\"placeOfBirth\":\"20130000\","
	// +
	// "\"taxNumber\":\"99999\",\"tradeRegisterNumber\":\"88888\",\"username\":\"闽越\","
	// +
	// "\"document\":{\"documentNumber\":\"123123213213\",\"documentType\":\"A\"}}}";

	String webservice = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">"
			+ "<soapenv:Header>"
			+ "<ResponseHead>"
			+ "<TransactionID>1000000083201311020128223874</TransactionID>"
			+ "<RspTime>2014-11-27T16:57:59.198+0800</RspTime>"
			+ "<RspType>1</RspType>"
			+ "<RspCode>9018</RspCode>"
			+ "<RspDesc>"
			+ "<![CDATA["
			+ "易流水号重复 (TransactionID=1000000083201311020128223874)"
			+ "]]>"
			+ "</RspDesc>"
			+ "</ResponseHead>"
			+ "</soapenv:Header>"
			+ "<soapenv:Body/>" + "</soapenv:Envelope>";

}
