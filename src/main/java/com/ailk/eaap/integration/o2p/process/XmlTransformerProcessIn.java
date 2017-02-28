package com.ailk.eaap.integration.o2p.process;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.springframework.util.Assert;

import com.ailk.eaap.integration.o2p.contractbody.util.ContractBodyUtil;
import com.ailk.eaap.integration.o2p.transformer.MessageTransformationException;
import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.asiainfo.foundation.exception.BusinessException;
import com.asiainfo.foundation.log.LogModel;
import com.asiainfo.foundation.log.Logger;
import com.ailk.eaap.op2.bo.ContractFormat;
import com.ailk.eaap.op2.bo.MessageDesc;
import com.ailk.eaap.op2.bo.NodeDesc;
import com.linkage.rainbow.util.StringUtil;

public class XmlTransformerProcessIn extends AbstractTransformerProcessIn {

	private static final Logger LOG = Logger
			.getLog(XmlTransformerProcessIn.class);

	@SuppressWarnings({ "unchecked" })
	@Override
	public MessageBO<?> processContent(MessageDesc md, MessageBO<?> bo) throws Exception {
		Assert.notNull(md, "The Xml md is null");
		super.setThreadLocalProcessUtils(new TransformerProcessUtils());
		Map<String, Object> map = super.structuredIntoMap(md);
		if (LOG.isDebugEnabled()) {
			LOG.debug("Map process : {0}", map.toString());
		}
		MessageBO<Document> tarBO = new MessageBO<Document>();
			
		Map<String, String> nameSpaceMap = threadLocalMapBuild.get().getNameSpaceMap();
		Map<String, Object> mapAttr = threadLocalMapBuild.get().getMapAttr();
		Map<String, Object> childNameSpaceMap = threadLocalMapBuild.get().getChildNameSpaceMap();
		threadLocalMapBuild.remove();
		if(map.size() > 0) {
			Document doc = paseMap2Xml(map,nameSpaceMap,mapAttr,childNameSpaceMap);
			tarBO.setMsgBody(doc);
			

			if (LOG.isDebugEnabled()) {
				LOG.debug("doc process : {0}", doc.asXML());
			}
		}
		
		Map<String, Object> msgHeadMap = new HashMap<String, Object>();
		msgHeadMap.putAll(md.getHeaders());
		msgHeadMap.putAll(super.msgHeader(md));
		Map<String, Object> msgUrlMap = super.MsgUrl(md);
		if (LOG.isDebugEnabled()) {
			LOG.debug("XML Header process : {0}", msgHeadMap.toString());
			LOG.debug("XML Url process : {0}", msgUrlMap.toString());
		}

		tarBO.setMsgHead(msgHeadMap);
		tarBO.setMessageMap(msgUrlMap);
		tarBO.setTransactionID(bo.getTransactionID());

		return tarBO;
	}

	@Override
	public Object parseNodeValBySrcMsg(MessageBO<?> srcMsg,
			ContractFormat contractFormat, NodeDesc nodeDesc) {
		if(StringUtil.isEmpty(srcMsg.toString())) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("The Xml MsgBody is null");
			}
		}
		
		if (nodeDesc != null) {
			try {
				Object obj = ContractBodyUtil.getNodeValByNodeDesc(srcMsg, nodeDesc);
				
				if (LOG.isDebugEnabled()) {
					if (obj != null) {
						LOG.debug("nodeDesc id :{0} value : {1}", nodeDesc.getNodeDescId(), obj.toString());
					}
					else {
						LOG.debug("nodeDesc id :{0} value is null", nodeDesc.getNodeDescId());
					}
					
				}
				return obj;
			} catch (MessageTransformationException e) {
				throw new BusinessException(9141,
						"o2p.serviceAgent.transformer.xmlPath", null, e);
			} catch (Exception e) {
				LOG.error(LogModel.EVENT_APP_EXCPT,
						"Parsing XPATH error id : {0}, node_path : {1}",
						nodeDesc.getNodeDescId(), nodeDesc.getNodePath());
				throw new BusinessException(9141,
						"o2p.serviceAgent.transformer.xmlPath", null, e);
			}
		}
		return null;
	}



	public Document paseMap2Xml(Map<String,Object> map, Map<String, String> nameSpaceMap, Map<String, Object> mapAttr, Map<String, Object> childNameSpaceMap) throws DocumentException {
		
		Document document = DocumentHelper.createDocument();
			
		paseMap(map, document, null, nameSpaceMap);
		Document doc = DocumentHelper.parseText(document.asXML());
		addChildNameSpaceOrAttr(doc, childNameSpaceMap, null);
		addChildNameSpaceOrAttr(doc, null, mapAttr);
		
		return doc;
	}
	
	private void addChildNameSpaceOrAttr(Document document, Map<String, Object> childNameSpaceMap, Map<String, Object> mapAttr) {
		if(LOG.isDebugEnabled()) {
			LOG.debug("addChildNameSpace document="+document.asXML());
		}
		Set<Entry<String, Object>> set = null;
		if(childNameSpaceMap != null) {
			
			set = childNameSpaceMap.entrySet();
		} else if(mapAttr != null) {
			
			set = mapAttr.entrySet();
		}

		for (Entry<String, Object> entry : set) {  
			
			String key = entry.getKey();
			Object value = entry.getValue();
			if(value != null && value instanceof List) {
				
				List<Node> list = document.selectNodes(key);
				
				List<String> cList = (List<String>)value;
				for(String nameSpace : cList) {
					
					String[] args = nameSpace.split("=");
					String prefix = "";
					String  uri = "";
					if(args.length == 2) {
						
						prefix = args[0];
						uri = args[1];
					} else {
						
						LOG.error("child nameSpace err. nameSpace==>"+nameSpace);
					}
						
					//正常情况只有一个
					for(Node node : list) {
						
						Element e = (Element)node;
						
						if(childNameSpaceMap != null) {
							
							e.addNamespace(prefix, uri);
						} else if(mapAttr != null) {
							
							e.addAttribute(prefix, uri);
						}
						
					}
				}
			}
		}
	}

	public void  paseMap(Map<String,Object> map, Document doc, Element e, Map<String, String> nameSpaceMap) {
		
		for (String key : map.keySet()) {
			
			Element subElement = null;
			if(doc != null) {
				
				subElement = doc.addElement(key);
				
				addNameSpace(subElement,nameSpaceMap);
			} else {
				
				subElement = e.addElement(key);
			}
			
			Object obj = map.get(key);
			
			if(obj instanceof String) {
				
				subElement.addText(obj.toString());
			} else if(obj instanceof Map) {
				
				paseMap((Map<String,Object>)obj, null, subElement, nameSpaceMap);
			} else if(obj instanceof List) {
				
				parseList((List<Object>)obj, null, subElement);
			}
		}
	}

	private void addNameSpace(Element subElement, Map<String, String> nameSpaceMap) {

		if(nameSpaceMap != null && nameSpaceMap.size()>0) {
			
			for (String key : nameSpaceMap.keySet()) {
				
				if (!StringUtils.isEmpty(key)) {
					subElement.addNamespace(key, nameSpaceMap.get(key)
							.toString());
				}
			}
		}
	}

	private void parseList(List<Object> obj, Document doc, Element e) {

		for(Object o : (List<Object>)obj) {
			
			if(o instanceof Map) {
				
				paseMap((Map<String,Object>)o, doc, e, null);
			} else if(o instanceof List) {
				
				parseList((List<Object>)o, doc, e);
			}
		}
		
	}
}