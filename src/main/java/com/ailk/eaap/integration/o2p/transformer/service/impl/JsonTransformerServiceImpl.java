/** 
 * Project Name:o2p-serviceAgent-transformer 
 * File Name:XmlTransformerServiceImpl.java 
 * Package Name:com.ailk.eaap.integration.o2p.transformer.service.impl 
 * Date:2016年1月8日上午11:04:23 
 * Copyright (c) 2016, www.asiainfo.com All Rights Reserved. 
 * 
*/  
  
package com.ailk.eaap.integration.o2p.transformer.service.impl;  



import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;

import com.ailk.eaap.integration.o2p.message.support.MessageMapperService;
import com.ailk.eaap.integration.o2p.process.Constant;
import com.ailk.eaap.integration.o2p.transformer.service.INodeReflectService;
import com.ailk.eaap.integration.o2p.transformer.service.INodeReqParseService;
import com.ailk.eaap.integration.o2p.transformer.service.ITransformerNodeValueService;
import com.ailk.eaap.integration.o2p.transformer.service.IjsonTransformerService;
import com.ailk.eaap.op2.common.O2pDocumentHelper;
import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.asiainfo.foundation.exception.BusinessException;
import com.asiainfo.foundation.log.Logger;
import com.ailk.eaap.op2.bo.ContractFormatEx;
import com.ailk.eaap.op2.bo.NodeDesc;
import com.ailk.eaap.op2.bo.NodeDescMapper;
import com.ailk.eaap.op2.bo.NodeValReq;
import com.ailk.eaap.op2.bo.TransformerRule;
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
public class JsonTransformerServiceImpl implements IjsonTransformerService {
	

private static final Logger LOG = Logger.getLog(JsonTransformerServiceImpl.class);
	
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

	@Override
	public MessageBO<?> jsonDoTransform(MessageBO<?> messageBo,
			TransformerRule transformerRule) throws DocumentException {
		
		MessageBO<JSONObject> tarMessageBo = new MessageBO<JSONObject>();
		
		ContractFormatEx contractFormatEx = transformerRule.getTarContractFormatEx();
		JSONObject tarJson = null;
		if(contractFormatEx.getMsgBody() != null) {
			
			tarJson = JSONObject.fromObject(contractFormatEx.getMsgBody());
		} 
		
		List<Object> rootNdList = transformerRule.getRootNodeDescList();
		
		transforJson(messageBo, tarJson, transformerRule, rootNdList, null, null, null, tarMessageBo);

		if(tarJson != null) {
			
			tarMessageBo.setMsgBody(tarJson);
			transformerNodeValueService.setTarContentType(tarMessageBo, "json", "text/json;charset=UTF-8");
		}
		
		if(LOG.isDebugEnabled()) {
			
			LOG.debug("transformer to json result :"+ tarMessageBo.toString());
		}
		
		return tarMessageBo;
	}

	private void transforJson(MessageBO<?> messageBo, JSONObject tarJson,
			TransformerRule transformerRule, List<Object> rootNdList, 
			Document srcArrayNodeDoc, JSONObject srcJson, JSONObject tarArrayJson, MessageBO<JSONObject> tarMessageBo) throws DocumentException {

		for(Object obj : rootNdList) {
			
			Map<Object, Object> parentMap = (Map<Object, Object>)obj;
			Set<Entry<Object, Object>> set = parentMap.entrySet();
			for(Entry<Object, Object> entry : set){
				
				Object keyObj = entry.getKey();
				List<Object> ndList = (List<Object>)entry.getValue();
				if(LOG.isDebugEnabled()) {
					
					LOG.debug("transforJson key :{0}", keyObj);
				}
				if(keyObj instanceof NodeDescMapper) {
					
					NodeDescMapper ndm = (NodeDescMapper)keyObj;
					NodeDesc srcNodeDesc = ndm.getSrcNode();
					NodeDesc tarNodeDesc = ndm.getTarNode();
					MessageBO<?> hisMessageBo = transformerNodeValueService.getMessageBOBySrcNode(messageBo, transformerRule,srcNodeDesc);
					String conType = transformerNodeValueService.getSrcConType(transformerRule, srcNodeDesc);
					
					if(tarJson != null && tarNodeDesc != null 
							&& (MessageMapperService.CONST_NODE_TYPE_BODY.equals(tarNodeDesc.getNodeType())
							|| MessageMapperService.CONST_NODE_TYPE_ATTR.equals(tarNodeDesc.getNodeType()))) {
						
						String operType = ndm.getOperTypeCd();
						if(MessageMapperService.CONST_OPER_TYPE_REFLECT.equals(operType)) {
							
							reflect(hisMessageBo, tarJson,transformerRule, ndList, ndm, conType, srcNodeDesc, tarNodeDesc, tarMessageBo);
						} else if(MessageMapperService.CONST_OPER_TYPE_COPY_NODE.equals(operType)){
							
							replaceNode(hisMessageBo, tarJson,transformerRule, 
									ndm, conType,srcArrayNodeDoc, srcJson, tarArrayJson, srcNodeDesc, tarNodeDesc, tarMessageBo);
							transforJson(messageBo, tarJson, transformerRule, ndList, null, null, null, tarMessageBo);
						} else if(MessageMapperService.CONST_OPER_TYPE_DELETE_NODE.equals(operType)){
							
							deleteNode(messageBo, tarJson,transformerRule, 
									ndm, conType,srcArrayNodeDoc, srcJson, tarArrayJson, srcNodeDesc, tarNodeDesc, tarMessageBo);
						} else {
							
							otherMapper(hisMessageBo, tarJson,transformerRule, ndList,
									ndm, conType,srcArrayNodeDoc, srcJson, tarArrayJson, srcNodeDesc, tarNodeDesc, tarMessageBo);
						}
					} else {
						
						urlHead(hisMessageBo, transformerRule, ndList, ndm, conType,tarNodeDesc, tarMessageBo);
					}
				} else {
					
					transforJson(messageBo, tarJson, transformerRule, ndList, null, null, null, tarMessageBo);
				}
			}
		}
	}
	
	private void deleteNode(MessageBO<?> messageBo, JSONObject tarJson,
			TransformerRule transformerRule, 
			NodeDescMapper ndm, String conType, Document srcArrayNodeDoc,
			JSONObject srcJson, JSONObject tarArrayJson, NodeDesc srcNodeDesc,
			NodeDesc tarNodeDesc, MessageBO<JSONObject> tarMessageBo) throws DocumentException {

		NodeValReq nvr = ndm.getTarNodeValReq();
		String express = "";
		if(nvr != null) {
			
			express = nvr.getValueExpress();
		}
			
		if("".equals(express) || 
				"true".equals(nodeReqParseService.parseJson(conType, messageBo, express, null, srcJson, srcNodeDesc))) {
			
			if(MessageMapperService.BODY.equals(tarNodeDesc.getNodePath())) {
				
				return;
			}
			
			String tarNodePath = tarNodeDesc.getNodePath();

			//顶级节点
			if(tarNodePath.lastIndexOf(".") < 2) {
				
				tarJson.remove(tarNodeDesc.getNodeCode());
			} else {
				
				String tarParentPath = tarNodePath.substring(0, tarNodePath.lastIndexOf("."));
				Object tarParentObj = JsonPath.read(tarJson, tarParentPath);
				if(tarParentObj instanceof JSONObject) {
				
					JSONObject tarPJson = (JSONObject)tarParentObj;
					tarPJson.remove(tarNodeDesc.getNodeCode());
				} else if(tarArrayJson != null) {
					
					tarArrayJson.remove(tarNodeDesc.getNodeCode());
				}
			}
		}
	}

	private void replaceNode(MessageBO<?> messageBo, JSONObject tarJson,
			TransformerRule transformerRule, 
			NodeDescMapper ndm, String conType, Document srcArrayNodeDoc,
			JSONObject srcJson, JSONObject tarArrayJson, NodeDesc srcNodeDesc,
			NodeDesc tarNodeDesc, MessageBO<JSONObject> tarMessageBo) throws DocumentException {

		NodeValReq nvr = ndm.getTarNodeValReq();
		String express = "";
		if(nvr != null) {
			
			express = nvr.getValueExpress();
		}
			
		if("".equals(express) || 
				"true".equals(nodeReqParseService.parseJson(conType, messageBo, express, null, srcJson, srcNodeDesc))) {
			
			Object srcObj = transformerNodeValueService.getSrcJsonObj(messageBo, srcJson, srcNodeDesc);
			
			String tarNodePath = tarNodeDesc.getNodePath();

			//顶级节点
			if(tarNodePath.lastIndexOf(".") < 2) {
				
				tarJson.remove(tarNodeDesc.getNodeCode());
				tarJson.put(srcNodeDesc.getNodeCode(), srcObj.toString());
			} else {
				
				String tarParentPath = tarNodePath.substring(0, tarNodePath.lastIndexOf("."));
				Object tarParentObj = JsonPath.read(tarJson, tarParentPath);
				if(tarParentObj instanceof JSONObject) {
				
					JSONObject tarPJson = (JSONObject)tarParentObj;
					tarPJson.remove(tarNodeDesc.getNodeCode());
					tarPJson.put(srcNodeDesc.getNodeCode(), srcObj.toString());
				} else if(tarArrayJson != null) {
					
					tarArrayJson.put(srcNodeDesc.getNodeCode(), srcObj);
				}
			}
		}
	}

	private void urlHead(MessageBO<?> messageBo, 
			TransformerRule transformerRule, List<Object> ndList,
			NodeDescMapper ndm, String conType, NodeDesc tarNodeDesc, MessageBO<JSONObject> tarMessageBo) throws DocumentException {

		transformerNodeValueService.setUrlHeadValue(messageBo, transformerRule, ndm, conType, tarNodeDesc, tarMessageBo);
		
		transforJson(messageBo, null, transformerRule, ndList, null, null, null, tarMessageBo);
	}

	private void reflect(MessageBO<?> messageBo, JSONObject tarJson,
			TransformerRule transformerRule, List<Object> ndList, NodeDescMapper ndm, String conType, NodeDesc srcNodeDesc, NodeDesc tarNodeDesc, MessageBO<JSONObject> tarMessageBo) throws DocumentException {
		
		nodeReflectService.parseReflect(messageBo, null, tarJson, transformerRule, ndm, conType,
				srcNodeDesc, tarNodeDesc);
		
		transforJson(messageBo, tarJson, transformerRule, ndList, null, null, null, tarMessageBo);
	}


	private void otherMapper(MessageBO<?> messageBo, JSONObject tarJson,
			TransformerRule transformerRule, List<Object> ndList, NodeDescMapper ndm, 
			String srcConType, Document srcArrayNodeDoc, JSONObject srcJson,  JSONObject tarArrayJson, 
			NodeDesc srcNodeDesc, NodeDesc tarNodeDesc, MessageBO<JSONObject> tarMessageBo) throws DocumentException {

		if(MessageMapperService.CONST_MSG_CON_TYPE_XML.equals(srcConType)) {
			
			otherMapperSrcXml(messageBo, tarJson,transformerRule, ndList, ndm, 
					srcArrayNodeDoc, null, tarArrayJson, srcNodeDesc, tarNodeDesc, tarMessageBo);
		} else if(MessageMapperService.CONST_MSG_CON_TYPE_JSON.equals(srcConType)) {
			
			otherMapperSrcJson(messageBo, tarJson,transformerRule, ndList, 
					ndm, null, srcJson, tarArrayJson, srcNodeDesc, tarNodeDesc, tarMessageBo);
		}
	}
	

	private void otherMapperSrcJson(MessageBO<?> messageBo, JSONObject tarJson,
			TransformerRule transformerRule, List<Object> ndList,
			NodeDescMapper ndm, Document srcArrayNodeDoc, JSONObject srcJson,
			JSONObject tarArrayJson, NodeDesc srcNodeDesc, NodeDesc tarNodeDesc, MessageBO<JSONObject> tarMessageBo) throws DocumentException {

		//target is array
		if(Constant.NODE_NUMBER_CONS_0_N.equals(tarNodeDesc.getNodeNumberCons())
				|| Constant.NODE_NUMBER_CONS_1_N.equals(tarNodeDesc.getNodeNumberCons())) {
			
			//source
			NodeDesc srcNd = ndm.getSrcNode();
			if(srcNd != null) {
				JSONArray srcJsonArray = transformerNodeValueService.getSrcJson(messageBo, srcJson, srcNd);
				
				JSONArray tarJsonArray = gettarJsonArray(tarJson, tarArrayJson,
						tarNodeDesc);
				
				boolean isLeaf = tarJsonArray.size() == 0;
				
				//first array node
				JSONObject tarArray0 = null;
				if(!isLeaf) {
					
					//first array
					tarArray0 = (JSONObject)tarJsonArray.get(0);
					tarJsonArray.clear();
				}
				
				for(Object srcObj : srcJsonArray) {
					//source
					JSONObject srcJson2 = null;
					String nodeValue = "";
					if(srcObj instanceof String) {
						
						nodeValue = srcObj.toString();
						
						if(MessageMapperService.CONST_OPER_TYPE_MOVE.equals(ndm.getOperTypeCd())) {
							
							tarJsonArray.add(nodeValue);
							continue;
						}
						
						String srcPath = transformerNodeValueService.getSubPath(srcNd.getNodePath());
						srcJson2 = JSONObject.fromObject("{\""+srcPath+"\":\""+srcObj.toString()+"\"}");
					} else if(srcObj instanceof JSONObject) {
						
						srcJson2 = (JSONObject)srcObj;
					}
					
					

					boolean arrayCondition = true;
					if(MessageMapperService.CONST_OPER_TYPE_UPDATE.equals(ndm.getOperTypeCd())) {
						
						arrayCondition = nodeReqParseService.parseJsonCondition(MessageMapperService.CONST_MSG_CON_TYPE_JSON, messageBo, ndm, null, srcJson2, srcNd);
					}
					
					if(arrayCondition) {
						
						if(!isLeaf) {
							
							JSONObject tarArrayClone = JSONObject.fromObject(tarArray0);
							transforJson(messageBo, tarJson, transformerRule, ndList, null, srcJson2, tarArrayClone, tarMessageBo);
							
							tarJsonArray.add(tarArrayClone);
						} else {
							
							nodeValue = transformerNodeValueService.getSrcNodeValue(MessageMapperService.CONST_MSG_CON_TYPE_JSON, 
									transformerRule, messageBo, ndm, null, srcJson2);
							
							tarJsonArray.add(nodeValue);
						}
					}
				}
			}
			
			//target is leaf
		} else {
			
			//target
			String tarPath = tarNodeDesc.getNodePath();
			if(!StringUtils.isEmpty(tarPath)) {
				
				String subTarPath = transformerNodeValueService.getSubPath(tarPath);
				
				//leaf node in array
				if(srcJson != null && tarArrayJson != null && srcNodeDesc != null) {
					
					String srcPath = srcNodeDesc.getNodePath();
					String subSrcPath = transformerNodeValueService.getSubPath(srcPath);
					Object obj = JsonPath.read(srcJson, subSrcPath);
					//src is leaf
					if(!(obj instanceof JSONObject) && !(obj instanceof JSONArray)) {
						
						String nodeValue = transformerNodeValueService.getSrcNodeValue(MessageMapperService.CONST_MSG_CON_TYPE_JSON, 
								transformerRule, messageBo, ndm, null, srcJson);
						Object valueObj = nodeReqParseService.changeValueObj(nodeValue, tarNodeDesc);
						tarArrayJson.put(subTarPath, valueObj);
						//src is object
					} else if(obj instanceof JSONObject) {
						
						Object tarObj = JsonPath.read(tarArrayJson, subTarPath);
						
						if(tarObj instanceof String) {
							transforJson(messageBo, tarJson, transformerRule, ndList, null, (JSONObject)obj, tarArrayJson, tarMessageBo);
							return;
						} else if(tarObj instanceof JSONObject) {
							transforJson(messageBo, tarJson, transformerRule, ndList, null, (JSONObject)obj, (JSONObject)tarObj, tarMessageBo);
							tarArrayJson.put(subTarPath, (JSONObject)tarObj);
							return;
						} 
					} 
					
				} else {
					//normal node
					if(isLeafNode(tarJson, tarPath)) {
						
						String nodeValue = transformerNodeValueService.getSrcNodeValue(MessageMapperService.CONST_MSG_CON_TYPE_JSON, 
								transformerRule, messageBo, ndm, null, null);
						
						transformerNodeValueService.setJsonBodyValue(tarJson, tarNodeDesc, tarPath, subTarPath, nodeValue);
					}
				}
			}
			
			transforJson(messageBo, tarJson, transformerRule, ndList, null, null, null, tarMessageBo);
		}
	}

	

	private void otherMapperSrcXml(MessageBO<?> messageBo, JSONObject tarJson,
			TransformerRule transformerRule, List<Object> ndList,
			NodeDescMapper ndm, Document srcArrayNodeDoc, JSONObject srcJson,
			JSONObject tarArrayJson, NodeDesc srcNodeDesc, NodeDesc tarNodeDesc, MessageBO<JSONObject> tarMessageBo) throws DocumentException {
		
		//target is array
		if(Constant.NODE_NUMBER_CONS_0_N.equals(tarNodeDesc.getNodeNumberCons())
				|| Constant.NODE_NUMBER_CONS_1_N.equals(tarNodeDesc.getNodeNumberCons())) {
			
			//source
			if(srcNodeDesc != null) {
				//src
				List<Node> srcNodes = transformerNodeValueService.getSrcXml(messageBo, srcArrayNodeDoc,
						srcNodeDesc);
				
				//target
				JSONArray tarJsonArray = gettarJsonArray(tarJson, tarArrayJson,
						tarNodeDesc);
				
				boolean isLeaf = tarJsonArray.size() == 0;
				
				//first array node
				JSONObject tarArray0 = null;
				if(!isLeaf) {
					
					tarArray0 = (JSONObject)tarJsonArray.get(0);

					tarJsonArray.clear();
				}
				
				for(Node srcNode : srcNodes) {
					//source
					Document srcArrayNodeDoc2 = O2pDocumentHelper.parseText(srcNode.asXML());
					
					boolean arrayCondition = true;
					if(MessageMapperService.CONST_OPER_TYPE_UPDATE.equals(ndm.getOperTypeCd())) {
						
						arrayCondition = nodeReqParseService.parseJsonCondition(MessageMapperService.CONST_MSG_CON_TYPE_XML, messageBo, ndm, srcArrayNodeDoc2, null,srcNodeDesc);
					}
					
					if(arrayCondition) {
						
						if(!isLeaf) {
							
							JSONObject tarArrayClone = JSONObject.fromObject(tarArray0);
							transforJson(messageBo, tarJson, transformerRule, ndList, srcArrayNodeDoc2, null, tarArrayClone, tarMessageBo);
							
							tarJsonArray.add(tarArrayClone);
						} else {
								
							String nodeValue = transformerNodeValueService.getSrcNodeValue(MessageMapperService.CONST_MSG_CON_TYPE_XML, 
									transformerRule, messageBo, ndm, srcArrayNodeDoc2, null);
							
							tarJsonArray.add(nodeValue);
						}
					}
				}
			} else {
				
				throw new BusinessException(9100, "The target node is array,but the source node is null,pls check the mapping config. The target node path:"+tarNodeDesc.getNodePath());
			}
			
			//target is leaf
		} else {
			
			//target
			if(tarNodeDesc != null) { 
				
				String tarPath = tarNodeDesc.getNodePath();
				if(!StringUtils.isEmpty(tarPath)) {
					
					String subTarPath = transformerNodeValueService.getSubPath(tarPath);
					//in array node
					if(srcArrayNodeDoc != null && tarArrayJson != null && srcNodeDesc != null) {
						
						String srcPath = srcNodeDesc.getNodePath();
						String subSrcPath = transformerNodeValueService.getSubPathXml(srcPath);
						Node srcNode = srcArrayNodeDoc.selectSingleNode(subSrcPath);
						//src is leaf
						if(transformerNodeValueService.isLeafXml(srcNode.asXML())) {
							
							String nodeValue = transformerNodeValueService.getSrcNodeValue(MessageMapperService.CONST_MSG_CON_TYPE_XML, 
									transformerRule, messageBo, ndm, srcArrayNodeDoc, null);
							
							Object valueObj = nodeReqParseService.changeValueObj(nodeValue, tarNodeDesc);
							tarArrayJson.put(subTarPath, valueObj);
						} else {
							
							Object tarObj = JsonPath.read(tarArrayJson, subTarPath);
							
							if(tarObj instanceof String) {
								transforJson(messageBo, tarJson, transformerRule, ndList, O2pDocumentHelper.parseText(srcNode.asXML()), null, tarArrayJson, tarMessageBo);
								return;
							} else if(tarObj instanceof JSONObject) {
								transforJson(messageBo, tarJson, transformerRule, ndList, O2pDocumentHelper.parseText(srcNode.asXML()), null, (JSONObject)tarObj, tarMessageBo);
								tarArrayJson.put(subTarPath, (JSONObject)tarObj);
								return;
							} 
						}
						
						
					} else {
						
						if(isLeafNode(tarJson, tarPath)) {
							
							String nodeValue = transformerNodeValueService.getSrcNodeValue(MessageMapperService.CONST_MSG_CON_TYPE_XML, 
									transformerRule, messageBo, ndm, null, null);
							
							transformerNodeValueService.setJsonBodyValue(tarJson, tarNodeDesc, tarPath, subTarPath,nodeValue);
						}
					}
				}
			}
			
			transforJson(messageBo, tarJson, transformerRule, ndList, null, null, null, tarMessageBo);
		}
	}


	private JSONArray gettarJsonArray(JSONObject tarJson,
			JSONObject tarArrayJson, NodeDesc tarNodeDesc) {
		
		Object tarObj = getTarJsonObj(tarJson, tarArrayJson, tarNodeDesc);
		if(tarObj instanceof JSONArray) {
			
			return (JSONArray)tarObj;
		} else {
			
			throw new BusinessException(9100, "The source node is array,but the target json path is not array,pls check the mapping config. srcource path:"+tarNodeDesc.getNodePath());
		}
	}

	private Object getTarJsonObj(JSONObject tarJson, JSONObject tarArrayJson,
			NodeDesc tarNodeDesc) {
		
		JSONObject tarJsonObj = null;
		String tarParentNodePath = tarNodeDesc.getNodePath();
		if(tarArrayJson != null) {
			
			tarJsonObj = tarArrayJson;
			tarParentNodePath = transformerNodeValueService.getSubPath(tarParentNodePath);
		} else {
			
			tarJsonObj = tarJson;
		}
		Object tarObj = JsonPath.read(tarJsonObj, tarParentNodePath);
		return tarObj;
	}

	private boolean isLeafNode(JSONObject tarJson, String tarPath) {

		Object obj = JsonPath.read(tarJson, tarPath);
		
		return !(obj instanceof JSONObject) && !(obj instanceof JSONArray && ((JSONArray)obj).size()>0);
	}
}