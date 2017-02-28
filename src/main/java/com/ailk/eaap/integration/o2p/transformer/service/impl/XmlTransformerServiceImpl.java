/** 
 * Project Name:o2p-serviceAgent-transformer 
 * File Name:XmlTransformerServiceImpl.java 
 * Package Name:com.ailk.eaap.integration.o2p.transformer.service.impl 
 * Date:2016年1月8日上午11:04:23 
 * Copyright (c) 2016, www.asiainfo.com All Rights Reserved. 
 * 
*/  
  
package com.ailk.eaap.integration.o2p.transformer.service.impl;  

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;

import com.ailk.eaap.integration.o2p.message.support.MessageMapperService;
import com.ailk.eaap.integration.o2p.process.Constant;
import com.ailk.eaap.integration.o2p.transformer.service.INodeReflectService;
import com.ailk.eaap.integration.o2p.transformer.service.INodeReqParseService;
import com.ailk.eaap.integration.o2p.transformer.service.ITransformerNodeValueService;
import com.ailk.eaap.integration.o2p.transformer.service.IxmlTransformerService;
import com.ailk.eaap.op2.bo.ContractFormatEx;
import com.ailk.eaap.op2.bo.NodeDesc;
import com.ailk.eaap.op2.bo.NodeDescMapper;
import com.ailk.eaap.op2.bo.NodeValReq;
import com.ailk.eaap.op2.bo.TransformerRule;
import com.ailk.eaap.op2.common.O2pDocumentHelper;
import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.asiainfo.foundation.exception.BusinessException;
import com.asiainfo.foundation.log.Logger;
import com.jayway.jsonpath.JsonPath;

/** 
 * ClassName:XmlTransformerServiceImpl  
 * Function: TODO ADD FUNCTION.  
 * Reason:   TODO ADD REASON.  
 * Date:     2016年1月8日 上午11:04:23  
 * @author   wuwz 
 * @version   
 * @since    JDK 1.6 
 *        
 */
public class XmlTransformerServiceImpl implements IxmlTransformerService {


private static final Logger LOG = Logger.getLog(XmlTransformerServiceImpl.class);
	
	private ITransformerNodeValueService transformerNodeValueService;
	private INodeReqParseService nodeReqParseService;
	private INodeReflectService nodeReflectService;
	
	public void setTransformerNodeValueService(
			ITransformerNodeValueService transformerNodeValueService) {
		this.transformerNodeValueService = transformerNodeValueService;
	}

	public void setNodeReqParseService(INodeReqParseService nodeReqParseService) {
		this.nodeReqParseService = nodeReqParseService;
	}

	public void setNodeReflectService(INodeReflectService nodeReflectService) {
		this.nodeReflectService = nodeReflectService;
	}

	public MessageBO<?>  xmlDoTransform(MessageBO<?> messageBo,
			TransformerRule transformerRule) throws DocumentException {
		
		MessageBO<Document> tarMessageBo = new MessageBO<Document>();
		
		ContractFormatEx contractFormatEx = transformerRule.getTarContractFormatEx();
		Document tarDoc = null;
		if(contractFormatEx.getMsgBody() != null) {
			
			tarDoc = (Document)((Document)contractFormatEx.getMsgBody()).clone();
			if(LOG.isDebugEnabled()) {
				
				LOG.debug("===== target template document is:"+tarDoc.asXML());
			}
		}
		
		List<Object> rootNdList = transformerRule.getRootNodeDescList();
		
		transforXml(messageBo, tarDoc, transformerRule, rootNdList, null, null, null,tarMessageBo);

		if(tarDoc != null) {
			
			addCdataToBody(tarDoc, tarMessageBo);
			tarMessageBo.setMsgBody(tarDoc);
			transformerNodeValueService.setTarContentType(messageBo, "xml", "text/xml;charset=UTF-8");
		} 
		
		if(LOG.isDebugEnabled()) {
			
			LOG.debug("transformer to xml result :"+ tarMessageBo.toString());
		}
		
		return tarMessageBo;
	}


	private void addCdataToBody(Document tarDoc, MessageBO<Document> tarMessageBo) {

		Map<String, Object> cdataMap = tarMessageBo.getSubMsgBodyMap();
		
		Set<Entry<String, Object>> set = cdataMap.entrySet();
		for (Entry<String, Object> entry : set) {
			
			String path = entry.getKey();
			Object cdataDoc = entry.getValue();
			
			Element element = (Element)tarDoc.selectSingleNode(path);
			
			if(cdataDoc instanceof Document) {
				
				element.addCDATA(((Document)cdataDoc).getRootElement().asXML());
			} else if(cdataDoc instanceof JSONObject) {
				
				element.addCDATA(((JSONObject)cdataDoc).toString());
			}
		}
	}

	/**
	 * 
	 * 
	 * @author wuwz 
	 * @param messageBo
	 * @param tarDoc
	 * @param transformerRule
	 * @param rootNdList
	 * @param srcArrayNodeDoc
	 * @param srcJson
	 * @param tarArrayNodeDoc
	 * @param tarMessageBo 
	 * @throws DocumentException 
	 * @since JDK 1.6
	 */
	private void transforXml(MessageBO<?> messageBo, Document tarDoc,
			TransformerRule transformerRule, List<Object> rootNdList, 
			Document srcArrayNodeDoc, JSONObject srcJson, Document tarArrayNodeDoc, MessageBO<Document> tarMessageBo) throws DocumentException {

		for(Object obj : rootNdList) {
			
			Map<Object, Object> parentMap = (Map<Object, Object>)obj;
			Set<Entry<Object, Object>> set = parentMap.entrySet();
			for(Entry<Object, Object> entry : set){
				
				Object keyObj = entry.getKey();
				List<Object> ndList = (List<Object>)entry.getValue();
				if(LOG.isDebugEnabled()) {
					
					LOG.debug("transforXml key :{0}", keyObj);
				}
				if(keyObj instanceof NodeDescMapper) {
					
					NodeDescMapper ndm = (NodeDescMapper)keyObj;
					NodeDesc srcNodeDesc = ndm.getSrcNode();
					NodeDesc tarNodeDesc = ndm.getTarNode();
					MessageBO<?> hisMessageBo = transformerNodeValueService.getMessageBOBySrcNode(messageBo, transformerRule,srcNodeDesc);
					String conType = transformerNodeValueService.getSrcConType(transformerRule, srcNodeDesc);
					
					if(tarDoc != null && tarNodeDesc != null 
							&& (MessageMapperService.CONST_NODE_TYPE_BODY.equals(tarNodeDesc.getNodeType())
									|| MessageMapperService.CONST_NODE_TYPE_ATTR.equals(tarNodeDesc.getNodeType()))) {
						
						String operType = ndm.getOperTypeCd();
						if(MessageMapperService.CONST_OPER_TYPE_REFLECT.equals(operType)) {
							
							reflect(hisMessageBo, tarDoc,transformerRule, ndList, ndm, conType, srcNodeDesc, tarNodeDesc, tarMessageBo);
						} else if(MessageMapperService.CONST_OPER_TYPE_COPY_NODE.equals(operType)){
							
							replaceNode(hisMessageBo, tarDoc,transformerRule, 
									ndm, conType,srcArrayNodeDoc, tarArrayNodeDoc, srcNodeDesc, tarNodeDesc);
							
							transforXml(messageBo, tarDoc, transformerRule, ndList, null, null, null, tarMessageBo);
						} else if(MessageMapperService.CONST_OPER_TYPE_DELETE_NODE.equals(operType)){
							
							deleteNode(hisMessageBo, tarDoc,transformerRule, 
									ndm, conType,srcArrayNodeDoc, tarArrayNodeDoc, srcNodeDesc, tarNodeDesc);
						} else {
							
							otherMapper(hisMessageBo, tarDoc,transformerRule, ndList,
									ndm, conType,srcArrayNodeDoc, srcJson, tarArrayNodeDoc, srcNodeDesc, tarNodeDesc, tarMessageBo);
						}
					} else {
						
						urlHead(hisMessageBo, transformerRule, ndList, ndm, conType,tarNodeDesc, tarMessageBo);
					}
				} else {
					
					transforXml(messageBo, tarDoc, transformerRule, ndList, null, null, null, tarMessageBo);
				}
			}
		}
		
	}
	
	private void deleteNode(MessageBO<?> messageBo, Document tarDoc,
			TransformerRule transformerRule,
			NodeDescMapper ndm, String conType, Document srcArrayNodeDoc,
			Document tarArrayNodeDoc, NodeDesc srcNodeDesc, NodeDesc tarNodeDesc) throws DocumentException {

		NodeValReq nvr = ndm.getTarNodeValReq();
		String express = "";
		if(nvr != null) {
			
			express = nvr.getValueExpress();
		}
			
		if("".equals(express) || 
				"true".equals(nodeReqParseService.parseJson(conType, messageBo, express, srcArrayNodeDoc, null, srcNodeDesc))) {
			
			if(MessageMapperService.BODY.equals(tarNodeDesc.getNodePath())) {
				
				return;
			}
			List<Node> tarListNodes = getTarXml(tarDoc, tarArrayNodeDoc, tarNodeDesc);

			if(tarListNodes != null && tarListNodes.size() > 0) {
				
				for(Node tarNode : tarListNodes) {
					
					Element tarParentE = tarNode.getParent();
					//顶级节点
					if(tarParentE == null) {
						
						tarDoc.remove(tarNode);
					} else {
						
						if(tarNode != null) {
							
							tarParentE.remove(tarNode);
						}
					}
				}
			}
		}
	}

	private void replaceNode(MessageBO<?> messageBo, Document tarDoc,
			TransformerRule transformerRule, 
			NodeDescMapper ndm, String conType, Document srcArrayNodeDoc,
			Document tarArrayNodeDoc, NodeDesc srcNodeDesc,
			NodeDesc tarNodeDesc) throws DocumentException {
		
		NodeValReq nvr = ndm.getTarNodeValReq();
		String express = "";
		if(nvr != null) {
			
			express = nvr.getValueExpress();
		}
			
		if("".equals(express) || 
				"true".equals(nodeReqParseService.parseJson(conType, messageBo, express, srcArrayNodeDoc, null, srcNodeDesc))) {
			
			List<Node> srcListNodes = new ArrayList<Node>();
			//顶级
			if(MessageMapperService.BODY.equals(srcNodeDesc.getNodePath())) {
				
				Element srcTopNode = ((Document)messageBo.getMsgBody()).getRootElement();
				srcListNodes.add(srcTopNode);
			} else {
				
				srcListNodes = transformerNodeValueService.getSrcXml(messageBo, srcArrayNodeDoc, srcNodeDesc);
			}
			
			if(srcListNodes.size() > 0) {
				
				List<Node> tarListNodes = getTarXml(tarDoc, tarArrayNodeDoc, tarNodeDesc);
				int index = 0;
				for(Node srcNode : srcListNodes) {
					Node newNode = (Node) srcNode.clone();
					
					Node tarNode = tarListNodes.get(index);
					index++;
					Element tarParentE = tarNode.getParent();
					//顶级节点
					if(tarParentE == null) {
						tarDoc.remove(tarNode);
						
						tarDoc.add(newNode);
					} else {
						
						if(tarNode != null) {
							
							tarParentE.remove(tarNode);
						}
						tarParentE.add(newNode);
					}
				}
			}
		}
		
	}

	private void urlHead(MessageBO<?> messageBo, 
			TransformerRule transformerRule, List<Object> ndList,
			NodeDescMapper ndm, String conType, NodeDesc tarNodeDesc, MessageBO<Document> tarMessageBo) throws DocumentException {

		transformerNodeValueService.setUrlHeadValue(messageBo, transformerRule, ndm, conType, tarNodeDesc, tarMessageBo);
		
	}

	private void otherMapper(MessageBO<?> messageBo, Document tarDoc,
			TransformerRule transformerRule, List<Object> ndList, NodeDescMapper ndm, 
			String conType, Document srcArrayNodeDoc, JSONObject srcJson, Document tarArrayNodeDoc, 
			NodeDesc srcNodeDesc, NodeDesc tarNodeDesc, MessageBO<Document> tarMessageBo) throws DocumentException {

		if(MessageMapperService.CONST_MSG_CON_TYPE_XML.equals(conType)) {
			
			otherMapperSrcXml(messageBo, tarDoc,transformerRule, ndList, ndm, 
					srcArrayNodeDoc, null, tarArrayNodeDoc, srcNodeDesc, tarNodeDesc,tarMessageBo);
		} else if(MessageMapperService.CONST_MSG_CON_TYPE_JSON.equals(conType)) {
			
			otherMapperSrcJson(messageBo, tarDoc,transformerRule, ndList, 
					ndm, null, srcJson, tarArrayNodeDoc, srcNodeDesc, tarNodeDesc,tarMessageBo);
		}
	}

	private void otherMapperSrcJson(MessageBO<?> messageBo, Document tarDoc,
			TransformerRule transformerRule, List<Object> ndList,
			NodeDescMapper ndm, Document srcArrayNodeDoc, JSONObject srcJson,
			Document tarArrayNodeDoc, NodeDesc srcNodeDesc, NodeDesc tarNodeDesc, MessageBO<Document> tarMessageBo) throws DocumentException {

		//target is array
		if(Constant.NODE_NUMBER_CONS_0_N.equals(tarNodeDesc.getNodeNumberCons())
				|| Constant.NODE_NUMBER_CONS_1_N.equals(tarNodeDesc.getNodeNumberCons())) {
			
			//source
			NodeDesc srcNd = ndm.getSrcNode();
			if(srcNd != null) {
				//src
				JSONArray srcJsonArray = transformerNodeValueService.getSrcJson(messageBo, srcJson, srcNd);
				
				//target
				List<Node> tarNodeList = getTarXml(tarDoc, tarArrayNodeDoc,
						tarNodeDesc);
				
				Node tarArrayNodeDoc2 = tarNodeList.get(0);
				Document tarArrayNodeDocument = O2pDocumentHelper.parseText(tarArrayNodeDoc2.asXML());

				Element arrayParentNode = (Element)tarArrayNodeDoc2.getParent();
				nodeReflectService.deleteArrayNode(arrayParentNode, tarNodeList);
				
				for(Object srcObj : srcJsonArray) {
					//source
					JSONObject srcJson2 = null;
					if(srcObj instanceof String) {
						
						String srcPath = srcNd.getNodePath().substring(srcNd.getNodePath().lastIndexOf(".")+1, srcNd.getNodePath().length());
						srcJson2 = JSONObject.fromObject("{\""+srcPath+"\":\""+srcObj.toString()+"\"}");
					} else if(srcObj instanceof JSONObject) {
						
						srcJson2 = (JSONObject)srcObj;
					}
					
					Document tarArrayNodeDocumentClone = (Document)tarArrayNodeDocument.clone();
					boolean arrayCondition = true;
					if(MessageMapperService.CONST_OPER_TYPE_UPDATE.equals(ndm.getOperTypeCd())) {
						
						arrayCondition = nodeReqParseService.parseJsonCondition(MessageMapperService.CONST_MSG_CON_TYPE_JSON, messageBo, ndm, null, srcJson2, srcNd);
					}
					
					if(arrayCondition) {
						
						transforXml(messageBo, tarDoc, transformerRule, ndList, null, srcJson2, tarArrayNodeDocumentClone, tarMessageBo);
						
						arrayParentNode.add(tarArrayNodeDocumentClone.getRootElement());
					}
				}
			}
			
			//target is leaf
		} else {
			
			if(srcJson != null && tarArrayNodeDoc != null && srcNodeDesc != null) {
				
				String srcPath = srcNodeDesc.getNodePath();
				String subSrcPath = transformerNodeValueService.getSubPath(srcPath);
				Object obj = JsonPath.read(srcJson, subSrcPath);
				//src is leaf
				if(!(obj instanceof JSONObject) && !(obj instanceof JSONArray)) {
					
					//target
					Node node = getNode(tarArrayNodeDoc, tarNodeDesc);
					//source
					if(node != null) {
						
						String nodeValue = transformerNodeValueService.getSrcNodeValue(MessageMapperService.CONST_MSG_CON_TYPE_JSON, 
								transformerRule, messageBo, ndm, null, srcJson);
						
						node.setText(nodeValue);
					}
				} else if(obj instanceof JSONObject){
					
					transforXml(messageBo, tarDoc, transformerRule, ndList, null, (JSONObject)obj, tarArrayNodeDoc, tarMessageBo);
					return;
				}
				
			} else {

				String nodeValue = transformerNodeValueService.getSrcNodeValue(MessageMapperService.CONST_MSG_CON_TYPE_JSON, 
						transformerRule, messageBo, ndm, null, null);
				
				transformerNodeValueService.setXmlBodyValue(messageBo, tarDoc, tarNodeDesc, nodeValue, tarMessageBo);
			}
			
			transforXml(messageBo, tarDoc, transformerRule, ndList, null, null, null, tarMessageBo);
		}
	}

	private Node getNode(Document tarArrayNodeDoc, NodeDesc tarNodeDesc) {
		String tarPath = tarNodeDesc.getNodePath();
		tarPath = "//"+tarPath.substring(tarPath.lastIndexOf("/")+1, tarPath.length());
		Node node = tarArrayNodeDoc.selectSingleNode(tarPath);
		return node;
	}

	private void otherMapperSrcXml(MessageBO<?> messageBo, Document tarDoc,
			TransformerRule transformerRule, List<Object> ndList,
			NodeDescMapper ndm, Document srcArrayNodeDoc, JSONObject srcJson,
			Document tarArrayNodeDoc, NodeDesc srcNodeDesc, NodeDesc tarNodeDesc, MessageBO<Document> tarMessageBo) throws DocumentException {

		//target is array
		if(Constant.NODE_NUMBER_CONS_0_N.equals(tarNodeDesc.getNodeNumberCons())
				|| Constant.NODE_NUMBER_CONS_1_N.equals(tarNodeDesc.getNodeNumberCons())) {
			
			//source
			if(srcNodeDesc != null) {
				//src
				List<Node> srcNodes = transformerNodeValueService.getSrcXml(messageBo, srcArrayNodeDoc,
						srcNodeDesc);
				
				//target
				List<Node> tarNodeList = getTarXml(tarDoc, tarArrayNodeDoc,
						tarNodeDesc);
				
				Node tarArrayNodeDoc2 = tarNodeList.get(0);
				String tarArrayNodeDoc2Str = tarArrayNodeDoc2.asXML();
				boolean tarArrayIsLeaf = transformerNodeValueService.isLeafXml(tarArrayNodeDoc2Str);
				
				Document tarArrayNodeDocument = null;
				if(!tarArrayIsLeaf) {
					tarArrayNodeDocument = O2pDocumentHelper.parseText(tarArrayNodeDoc2Str);
				}

				Element arrayParentNode = (Element)tarArrayNodeDoc2.getParent();
				nodeReflectService.deleteArrayNode(arrayParentNode, tarNodeList);
				
				boolean srcArrayIsLeaf = transformerNodeValueService.isLeafXml(srcNodes.get(0).asXML());
				for(Node srcNode : srcNodes) {
					//source
					Document srcArrayNodeDoc2 = null;
					String srcNodeValue = "";

					if(srcArrayIsLeaf) {

						if(!Constant.NODE_NUMBER_CONS_0_N.equals(srcNodeDesc.getNodeNumberCons())
								&& !Constant.NODE_NUMBER_CONS_1_N.equals(srcNodeDesc.getNodeNumberCons())) {
							
							srcArrayNodeDoc2 = O2pDocumentHelper.parseText(srcNode.getParent().asXML());
						}
						if(MessageMapperService.CONST_OPER_TYPE_MOVE.equals(ndm.getOperTypeCd())) {
							
							srcNodeValue = srcNode.getText();
						} else {
							
							srcNodeValue = transformerNodeValueService.getSrcNodeValue(MessageMapperService.CONST_MSG_CON_TYPE_XML, 
									transformerRule, messageBo, ndm, srcArrayNodeDoc2, null);
						}
						if("".equals(srcNodeValue)) {
							continue;
						}
					} 
					
					if(srcArrayNodeDoc2 == null) {
							
						srcArrayNodeDoc2 = O2pDocumentHelper.parseText(srcNode.asXML());
					}
					Document tarArrayNodeDocumentClone = null;

					if(tarArrayIsLeaf) {
						
						tarArrayNodeDoc2.setText(srcNodeValue);
						tarArrayNodeDocumentClone = O2pDocumentHelper.parseText(tarArrayNodeDoc2.asXML());
					} else {
						
						tarArrayNodeDocumentClone = (Document)tarArrayNodeDocument.clone();
					}
					
					boolean arrayCondition = true;
					if(!srcArrayIsLeaf) {
						
						if(MessageMapperService.CONST_OPER_TYPE_UPDATE.equals(ndm.getOperTypeCd())) {
							
							arrayCondition = nodeReqParseService.parseJsonCondition(MessageMapperService.CONST_MSG_CON_TYPE_XML, messageBo, ndm, srcArrayNodeDoc2, null,srcNodeDesc);
						}
					}
					
					if(arrayCondition) {
						
						transforXml(messageBo, tarDoc, transformerRule, ndList, srcArrayNodeDoc2, null, tarArrayNodeDocumentClone, tarMessageBo);
						
						arrayParentNode.add(tarArrayNodeDocumentClone.getRootElement());
					}
				}
				
				//order by
				if(tarArrayIsLeaf) {
					Element newArrayParentNode = (Element)arrayParentNode.clone();
					List<Element> elist = arrayParentNode.elements();
					for(Element e : elist) {
						
						arrayParentNode.remove(e);
					}
				
					List<Element> newlist = newArrayParentNode.elements();
					for(int j=newlist.size()-1; j>=0; j--) {
						Element eClone = (Element)newlist.get(j).clone();	
						arrayParentNode.add(eClone);
					}
				}
			} else {
				
				throw new BusinessException(9100, "The target node is array,but the source node is null,pls check the mapping config. The target node path:"+tarNodeDesc.getNodePath());
			}
			
			//target is leaf
		} else {
			
			if(srcArrayNodeDoc != null && tarArrayNodeDoc != null && srcNodeDesc != null) {
				
				String srcPath = srcNodeDesc.getNodePath();
				String subSrcPath = transformerNodeValueService.getSubPathXml(srcPath);
				Node srcNode = srcArrayNodeDoc.selectSingleNode(subSrcPath);
				
				//src is leaf
				if(transformerNodeValueService.isLeafXml(srcNode.asXML())) {
					
					//target
					Node tarnode = getNode(tarArrayNodeDoc, tarNodeDesc);
					if(tarnode != null) {
						
						String nodeValue = transformerNodeValueService.getSrcNodeValue(MessageMapperService.CONST_MSG_CON_TYPE_XML, 
								transformerRule, messageBo, ndm, srcArrayNodeDoc, null);
						
						tarnode.setText(nodeValue);
					}
				} else {
					
					transforXml(messageBo, tarDoc, transformerRule, ndList, srcArrayNodeDoc, null, tarArrayNodeDoc, tarMessageBo);
					return;
				}
				
			} else {
				
				String nodeValue = transformerNodeValueService.getSrcNodeValue(MessageMapperService.CONST_MSG_CON_TYPE_XML, 
						transformerRule, messageBo, ndm, null, null);
				
				transformerNodeValueService.setXmlBodyValue(messageBo, tarDoc, tarNodeDesc, nodeValue,tarMessageBo);
			}
			
			transforXml(messageBo, tarDoc, transformerRule, ndList, null, null, null, tarMessageBo);
		}
	}

	private List<Node> getTarXml(Document tarDoc, Document tarArrayNodeDoc,
			NodeDesc tarNodeDesc) {
		Document tarDocument = null;
		String path = tarNodeDesc.getNodePath();
		if(tarArrayNodeDoc != null) {
			
			tarDocument = tarArrayNodeDoc;
			path = transformerNodeValueService.getSubPathXml(path);
		} else {
			
			tarDocument = tarDoc;
		}
		
		List<Node> tarNodeList = tarDocument.selectNodes(path);
		if(tarNodeList.size()<=0) {
			
			throw new BusinessException(9100, "Can not find target node, please check the nodePath. target node path:"+path);
		}
		return tarNodeList;
	}


	private void reflect(MessageBO<?> messageBo, Document tarDoc,
			TransformerRule transformerRule, List<Object> ndList, NodeDescMapper ndm, 
			String conType, NodeDesc srcNodeDesc, NodeDesc tarNodeDesc, MessageBO<Document> tarMessageBo) throws DocumentException {
		
		nodeReflectService.parseReflect(messageBo, tarDoc, null, transformerRule, ndm, conType,
				srcNodeDesc, tarNodeDesc);
		
		transforXml(messageBo, tarDoc, transformerRule, ndList, null, null, null, tarMessageBo);
	}
}