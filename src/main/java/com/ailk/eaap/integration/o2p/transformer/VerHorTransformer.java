/** 
 * Project Name:o2p-serviceAgent-transformer-1.9.3 
 * File Name:VerHorTransformer.java 
 * Package Name:com.ailk.eaap.integration.o2p.transformer 
 * Date:2015年10月14日上午11:04:51 
 * Copyright (c) 2015, www.asiainfo.com All Rights Reserved. 
 * 
*/  
  
package com.ailk.eaap.integration.o2p.transformer;  

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.wltea.expression.ExpressionEvaluator;
import org.wltea.expression.datameta.Variable;

import com.ailk.eaap.integration.o2p.message.support.MessageMapperService;
import com.ailk.eaap.o2p.common.util.StaxonUtils;
import com.ailk.eaap.op2.common.O2pDocumentHelper;
import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.asiainfo.foundation.log.Logger;
import com.ailk.eaap.op2.bo.ContractFormat;
import com.ailk.eaap.op2.bo.MessageDesc;
import com.ailk.eaap.op2.bo.MessageNode;
import com.ailk.eaap.op2.bo.NodeDesc;
import com.ailk.eaap.op2.bo.NodeDescMapper;
import com.ailk.eaap.op2.bo.NodeValReq;
import com.ailk.eaap.op2.bo.TransformerRule;


/** 
 * ClassName:VerHorTransformer  
 * Function: TODO ADD FUNCTION.  
 * Reason:   TODO ADD REASON.  
 * Date:     2015年10月14日 上午11:04:51  
 * @author   wuwz 
 * @version   
 * @since    JDK 1.6 
 *        
 */
public class VerHorTransformer extends DefaultTransformer {
	private final Logger LOG = Logger.getLog(this.getClass());
	private MessageMapperService messageMapperService;
	
	public boolean isVer2Hor(String actionTypeCd, List<MessageNode> list, MessageBO<?> message, List<NodeDescMapper> nodeMappers, MessageDesc messageDesc, TransformerRule transformerRule, NodeDescMapper nodeMapper) throws DocumentException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
		
		if(LOG.isDebugEnabled()) {
			
			LOG.debug(message.toString());
		}
		//是否纵转横
		boolean isZzh = false;
	
		if(MessageMapperService.CONST_OPER_TYPE_ZZH .equals(actionTypeCd)) {
			
			isZzh = true;
			String arrayNodePath = nodeMapper.getSrcNode().getNodePath();
			list.clear();
			
			List<NodeDescMapper> nMappers = new ArrayList<NodeDescMapper>();
			clone(nMappers, nodeMappers);
			zzhBuild(message, nMappers, messageDesc, arrayNodePath, list,transformerRule);
		}
		return isZzh;
	}

	public boolean isHor2Ver(String actionTypeCd, List<MessageNode> list, MessageBO<?> message, List<NodeDescMapper> nodeMappers, MessageDesc messageDesc, TransformerRule transformerRule, NodeDescMapper nodeMapper) throws DocumentException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {

		if(LOG.isDebugEnabled()) {
			
			LOG.debug(message.toString());
		}
		
		boolean isHzz = false;
		
		if(MessageMapperService.CONST_OPER_TYPE_HZZ.equals(actionTypeCd)) {
			
			isHzz = true;
			list.clear();
			
			String arrayNodePath = nodeMapper.getSrcNode().getNodePath();
			List<NodeDescMapper> nMappers = new ArrayList<NodeDescMapper>();
			clone(nMappers, nodeMappers);
			hzzBuild(message, nMappers, messageDesc, arrayNodePath, list,transformerRule);
		}
		return isHzz;
	}
	
	private void clone(List<NodeDescMapper> nMappers,
			List<NodeDescMapper> nodeMappers) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {

		for(NodeDescMapper ndm :nodeMappers) {
			
			NodeDescMapper ndm2 = new NodeDescMapper();
			ndm2.setCreateDt(ndm.getCreateDt());
			ndm2.setId(ndm.getTransformerId());
			ndm2.setOperTypeCd(ndm.getOperTypeCd());
			NodeDesc tarNode = (NodeDesc)BeanUtils.cloneBean(ndm.getTarNode());
			ndm2.setTarNode(tarNode);
			ndm2.setTarNodeVal(ndm.getTarNodeVal());
			ndm2.setTarNodeValReq(ndm.getTarNodeValReq());
			ndm2.setTransformerId(ndm.getTransformerId());
			ndm2.setSrcNode(ndm.getSrcNode());
			ndm2.setSrcNodeVal(ndm.getSrcNodeVal());
			
			nMappers.add(ndm2);
		}
	}

	private void hzzBuild(MessageBO<?> message,
			List<NodeDescMapper> nodeMappers, MessageDesc messageDesc,
			String arrayNodePath, List<MessageNode> messageNodeList,
			TransformerRule transformerRule) throws DocumentException {

		LOG.debug("ver to hor, path="+arrayNodePath);
		
		Object obj = message.getMsgBody();
		Document doc = getDocument(obj, message);
		
		if(doc != null) {
			
			//配置映射的节点
			List<Integer> nodeIdList = new ArrayList<Integer>();
			//目标叶子节点的节点id
			int nodeDescId = 1000;
			int count = 0;
			for (NodeDescMapper nodeMapper : nodeMappers) {
				String actionTypeCd = nodeMapper.getOperTypeCd();
				if(MessageMapperService.CONST_OPER_TYPE_HZZ.equals(actionTypeCd)) {
					
					NodeDesc srcNode = nodeMapper.getSrcNode();
					NodeDesc tarNode = nodeMapper.getTarNode();
					
					String nodePath = srcNode.getNodePath();
					
					LOG.debug("path= "+nodePath);
					
					if(!StringUtils.isEmpty(nodePath) && nodePath.startsWith("$")) {
						
						nodePath = nodePath.replace("$..", "//").replace("$.", "//").replace(".", "/");
						
						LOG.debug("json change to xml, the result path= "+nodePath);
					}
					Node node = doc.selectSingleNode(nodePath);
					//取值表达式
					NodeValReq nodeValReq = nodeMapper.getTarNodeValReq();
					
					//目标节点path
					String vauleExp = "";
					//触发表达式是否满足条件
					boolean flag = false;		
					if(node != null && nodeValReq != null) {
						
						vauleExp = nodeValReq.getValueExpress();
						
						LOG.debug("Target node value express is:"+vauleExp);
						
						if(!StringUtils.isEmpty(vauleExp)) {
							
							vauleExp = vauleExp.replace("/", "").replace("$", "").replace(".", "");
						}
						
						if(!StringUtils.isEmpty(nodeValReq.getTriggerExpress())) {
							
							LOG.debug("Target node trigger express is:"+nodeValReq.getTriggerExpress());
							
							List<Variable> variables = new ArrayList<Variable>();
							variables.add(Variable.createVariable("src_node_val", node.getText()));
					        Object result = ExpressionEvaluator.evaluate(nodeValReq.getTriggerExpress(),variables);
					        flag = Boolean.valueOf(String.valueOf(result));
					        
					        LOG.debug("Target node trigger express result is:"+flag);
					        
					        nodeIdList.add(tarNode.getNodeDescId());
						}
						
					}
					
					//当触发表达式为空或者满足映射条件
					if(node != null && (nodeValReq == null 
							|| StringUtils.isEmpty(nodeValReq.getTriggerExpress())
							|| flag)) {
						
						//parentNode
						NodeDesc pNode = getParentNode(tarNode, messageDesc);
						
						NodeDesc parentNode = null;
						if(count > 0) {
							
							MessageNode pMessageNode = new MessageNode();
							parentNode = getNewNodeDesc(pNode, ++nodeDescId, null);
							
							pMessageNode.setNodeDesc(parentNode);
							messageNodeList.add(pMessageNode);
							
							LOG.debug("parentNodePath="+parentNode.getNodePath());
							
							nodeIdList.add(parentNode.getNodeDescId());
						}
						
						//tarNode
						MessageNode messageNode = new MessageNode();
						nodeIdList.add(tarNode.getNodeDescId());
						tarNode.setNodeDescId(++nodeDescId);
						if(count > 0) {
							
							tarNode.setParentNodeId(parentNode.getNodeDescId());
						} 
						//propertyName
						messageNode.setNodeDesc(tarNode);
						messageNode.setNodeVal(srcNode.getNodeName());
						
						LOG.debug("<propertyName> tarNodePath="+tarNode.getNodePath()+", tarNodeValue="+srcNode.getNodeName());
						
						messageNodeList.add(messageNode);
						
						//propertyValue
						MessageNode propertyValueNode = new MessageNode();
						NodeDesc propertyValueNodeDesc = getNewNodeDesc(tarNode, ++nodeDescId, vauleExp);
						if(count > 0) {
							
							propertyValueNodeDesc.setParentNodeId(parentNode.getNodeDescId());
						} 
						
						propertyValueNode.setNodeDesc(propertyValueNodeDesc);
						propertyValueNode.setNodeVal(node.getText());
						
						LOG.debug("<propertyValue>  tarNodePath="+propertyValueNodeDesc.getNodePath()+", tarNodeValue="+node.getText());
						
						messageNodeList.add(propertyValueNode);
						
						nodeIdList.add(tarNode.getNodeDescId());
						nodeIdList.add(propertyValueNodeDesc.getNodeDescId());
						
						count++;
						node.detach();
					}
				}
			}
			
			//添加其他映射节点
			addOtherMapper(nodeMappers, message, transformerRule,messageNodeList,nodeIdList);
			//添加未映射节点
			addNoMaperNode(messageDesc, nodeIdList, messageNodeList);
		}
	}


	private Document getDocument(Object obj, MessageBO<?> message) throws DocumentException {

		if(obj instanceof Document) {
			 
			return (Document)message.getMsgBody();
		} else if(obj instanceof JSONObject) {
			
			JSONObject json = (JSONObject)obj;
			String xml = StaxonUtils.jsontoXml(json.toString());
			if(LOG.isDebugEnabled()) {
				LOG.debug("json to xml, result= "+xml);
			}
			
			return O2pDocumentHelper.parseText(xml);
		}
		
		return null;
	}

	private NodeDesc getNewNodeDesc(NodeDesc pNode, int nodeDescId, String vauleExp) {

		NodeDesc node = new NodeDesc();
		
		if(pNode != null) {
			
			node.setNodeName(pNode.getNodeName());
			node.setNodeCode(pNode.getNodeCode());
			node.setNodePath(pNode.getNodePath());
			node.setParentNodeId(pNode.getParentNodeId());
			node.setNodeType(pNode.getNodeType());
			node.setTcpCtrFId(pNode.getTcpCtrFId());
			node.setNodeNumberCons(pNode.getNodeNumberCons());
			node.setNodeTypeCons(pNode.getNodeTypeCons());
			node.setNodeDescId(nodeDescId);
		}
		
		if(!StringUtils.isEmpty(vauleExp)) {
			
			node.setNodeName(vauleExp);
			node.setNodeCode(vauleExp);
			node.setNodePath(vauleExp);
		}
		
		return node;
	}

	private NodeDesc getParentNode(NodeDesc tarNode, MessageDesc messageDesc) {
		
		if(tarNode != null) {
			
			LOG.debug("tarNode != null, result={0}",tarNode != null);
			LOG.debug("tarNode.toString(), result={0}",tarNode.toString());
			LOG.debug("tarParentNodeId",tarNode.getParentNodeId());
			ContractFormat cf = messageDesc.getContractFormat();
			
			if(cf != null) {
				
				int tarParentNodeId = tarNode.getParentNodeId() == null ? -1:(int)tarNode.getParentNodeId();
				
				for(NodeDesc tNode : cf.getNodeDescs()) {
					
					if(tNode.getNodeDescId() == tarParentNodeId) {
						
						return tNode;
					}
				}
			}
		}
		
		return null;
	}

	private void zzhBuild(MessageBO<?> message, List<NodeDescMapper> nodeMappers, 
			MessageDesc messageDesc, String arrayNamePath, List<MessageNode> messageNodeList, TransformerRule transformerRule) throws DocumentException {
		
		LOG.debug("hor to ver, path="+arrayNamePath);
		if(!StringUtils.isEmpty(arrayNamePath)) {
			
			Object obj = message.getMsgBody();
			Document doc = getDocument(obj, message);
			
			//arrayNamePath表达式必须转化为xpath
			if(arrayNamePath.startsWith("$")) {
				
				arrayNamePath = "//"+arrayNamePath.substring(arrayNamePath.lastIndexOf(".")+1, arrayNamePath.length());
			}

			List<Node> list = doc.selectNodes(arrayNamePath);
		
			//配置映射的节点
			List<Integer> nodeIdList = new ArrayList<Integer>();
			//源报文迭代的节点
			for(Node nameNode : list) {
				
				MessageNode messageNode = new MessageNode();
				
				String vauleExp = "";
				String nodeName = nameNode.getText();
				boolean flag = false;
				
				for (NodeDescMapper nodeMapper : nodeMappers) {
					
					NodeDesc tarNode = nodeMapper.getTarNode();
					String actionTypeCd = nodeMapper.getOperTypeCd();
					
					if(!StringUtils.isEmpty(nodeName) && "Z".equals(actionTypeCd)) {
						
						//取值表达式
						NodeValReq nodeValReq = nodeMapper.getTarNodeValReq();
						
						if(nodeValReq != null) {
							
							vauleExp = nodeValReq.getValueExpress();
							
							LOG.debug("Get value express is :"+vauleExp);
							
							//触发表达式不为空，根据触发表达式取源节点，如src_node_val==”CountryCode”，取源节点值为CountryCode的节点
							if(!StringUtils.isEmpty(nodeValReq.getTriggerExpress())) {
								
								LOG.debug("Trigger express is :"+nodeValReq.getTriggerExpress());
								
								List<Variable> variables = new ArrayList<Variable>();
								variables.add(Variable.createVariable("src_node_val", nodeName.trim()));
						        Object result = ExpressionEvaluator.evaluate(nodeValReq.getTriggerExpress(),variables);
						        flag = Boolean.valueOf(String.valueOf(result));
						        
						        LOG.debug("Trigger express result is :"+flag);
						        
						        nodeIdList.add(tarNode.getNodeDescId());
						        //目标节点满足映射条件
						        if(flag) {
						        	messageNode.setNodeDesc(tarNode);
						        	
						        	LOG.debug("Target node path is :"+tarNode.getNodePath());
						        	
						        	//已添加的不再遍历
									nodeMappers.remove(nodeMapper);
									break;
						        }
							}
						}
						
						//当触发表达式为空时,根据目标节点名称取源节点
						if((nodeValReq == null 
								|| StringUtils.isEmpty(nodeValReq.getTriggerExpress()))
								&&  nodeName.equals(tarNode.getNodeName())) {
							 
							messageNode.setNodeDesc(tarNode);
							
							LOG.debug("Target node path is :"+tarNode.getNodePath());
							
							nodeIdList.add(tarNode.getNodeDescId());
							//已添加的不再遍历
							nodeMappers.remove(nodeMapper);
							flag = true;
							break;
						} 
						
					}
				}
				
				if(flag) {
					
					Node parentNode = nameNode.getParent();
					addNodeValue(message, vauleExp, parentNode, messageNode, nodeName);
					
					messageNodeList.add(messageNode);
				}
				
			}
			//添加其他映射节点
			addOtherMapper(nodeMappers, message, transformerRule,messageNodeList,nodeIdList);
			//添加未映射节点
			addNoMaperNode(messageDesc, nodeIdList, messageNodeList);
		} else {
			
			LOG.error("zzh arrayNodePath is null");
		}
		
	}

	private void addOtherMapper(List<NodeDescMapper> nodeMappers, MessageBO<?> message, TransformerRule transformerRule, List<MessageNode> messageNodeList, List<Integer> nodeIdList) {

		for (NodeDescMapper nodeMapper : nodeMappers) {
			String actionTypeCd = nodeMapper.getOperTypeCd();
			if(!MessageMapperService.CONST_OPER_TYPE_HZZ.equals(actionTypeCd)
					&& !MessageMapperService.CONST_OPER_TYPE_ZZH.equals(actionTypeCd)) {
				
				NodeDesc tarNode = nodeMapper.getTarNode();
				Object tarNodeVal = messageMapperService.getTarNodeValByMapper(
						message, transformerRule, nodeMapper);
				
				MessageNode messageNode = new MessageNode();
				messageNode.setNodeDesc(tarNode);
				messageNode.setNodeVal(tarNodeVal);
				messageNodeList.add(messageNode);
				
				nodeIdList.add(tarNode.getNodeDescId());
			}
		}
	}


	private void addNodeValue(MessageBO<?> message,String vauleExp, Node parentNode, MessageNode messageNode, String nodeName) throws DocumentException {

		if(!StringUtils.isEmpty(vauleExp)) {
			
			if(message.getMsgBody() instanceof JSONObject 
					&& vauleExp.startsWith("$")) {
				
				//vauleExp表达式必须转化为xpath
				vauleExp = "//"+vauleExp.substring(vauleExp.lastIndexOf(".")+1, vauleExp.length());
			}
			
			Document doc = O2pDocumentHelper.parseText(parentNode.asXML());
			Node vNode = doc.selectSingleNode(vauleExp);
			String value = vNode.getText();
			
			LOG.debug("Target node name is:"+nodeName+", node value is :"+value);
			
			messageNode.setNodeVal(value);
		} else {
			//没配取值表达式，那么默认取另外一个节点
			String[] nodeValues = parentNode.getStringValue().split("\\\n");
			
			LOG.debug("Target node value express is null, parent node is :"+parentNode.getStringValue());
			
			if(nodeValues.length<=4) {
				
				for(String nodeValue : nodeValues) {
					
					if(!StringUtils.isEmpty(nodeValue) && 
							!nodeValue.equals(nodeName)) {
						
						messageNode.setNodeVal(nodeValue.trim().replace("\\\t", ""));
						
						break;
					}
				}
			} else {
				
				LOG.error("can not find the node value, nodeContent="+parentNode.asXML());
			}
		}
		
	}

	private void addNoMaperNode(MessageDesc messageDesc, List<Integer> nodeIdList, 
			List<MessageNode> messageNodeList) {

		ContractFormat tarCf = messageDesc.getContractFormat();
		if(tarCf != null) {
			
			List<NodeDesc> nodeList = tarCf.getNodeDescs();
			for(NodeDesc node : nodeList) {
				
				if(!nodeIdList.contains(node.getNodeDescId())) {
					
					MessageNode messageNode = new MessageNode();
					messageNode.setNodeDesc(node);
					
					nodeIdList.add(node.getNodeDescId());
					messageNodeList.add(messageNode);
				}
				
			}
		}
		
	}

	public void setMessageMapperService(MessageMapperService messageMapperService) {
		this.messageMapperService = messageMapperService;
	}
	
}