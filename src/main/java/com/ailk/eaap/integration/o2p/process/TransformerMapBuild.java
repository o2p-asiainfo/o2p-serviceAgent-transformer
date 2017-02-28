package com.ailk.eaap.integration.o2p.process;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.asiainfo.foundation.log.Logger;
import com.ailk.eaap.op2.bo.MessageDesc;
import com.ailk.eaap.op2.bo.MessageNode;
import com.ailk.eaap.op2.bo.NodeDesc;

public class TransformerMapBuild {
	private static final Logger LOG = Logger
			.getLog(TransformerMapBuild.class);
	private  Map<String, String> nameSpaceMap = new HashMap<String, String>();
	private  Map<String, Object> mapAttr = new HashMap<String, Object>();
	private  Map<String, Object> childNameSpaceMap = new HashMap<String, Object>();
	
	public Map<String, Object> mapBuild(MessageDesc md, String contentType) {
		
		List<MessageNode> mNodeList =  md.getMessageNodes();
		
		Map<String, Object> map = new HashMap<String, Object>();
		//根节点
		boolean hasRootId = false;
		for(MessageNode mNode : mNodeList) {
			
			NodeDesc node = mNode.getNodeDesc();
			
			//父节点为空的节点对于xml是根节点，对于json可能没有根节点即多个根节点
			if(node != null && Constant.NODETYPE_BODY.equals(node.getNodeType())&&
					(node.getParentNodeId() == null || node.getParentNodeId() <=0)) {
				
				if(Constant.CONTENT_TYPE_XML.equals(contentType)) {
					
					for(MessageNode sNode : mNodeList) {
						
						NodeDesc n = sNode.getNodeDesc();
						int pid = n.getParentNodeId() == null ? -1:(int)n.getParentNodeId();
						int nid = node.getNodeDescId() == null ? -2:(int)node.getNodeDescId();
						//有子节点的节点
						if(pid == nid) {
							
							hasRootId = true;
							
							break;
						}
						
					}
					
					if(hasRootId) {
						
						buildHasRootMap(node, map, mNodeList, contentType);
						
						break;
					}
				} else if(Constant.CONTENT_TYPE_JSON.equals(contentType)) {
					
					hasRootId = false;
					for(MessageNode sNode : mNodeList) {
						
						NodeDesc n = sNode.getNodeDesc();
						int pid = n.getParentNodeId() == null ? -1:(int)n.getParentNodeId();
						int nid = node.getNodeDescId() == null ? -2:(int)node.getNodeDescId();
						//有子节点的节点
						if(pid == nid) {
							
							hasRootId = true;
							
							buildHasRootMap(node, map, mNodeList, contentType);
						
							break;
						} 
					}
					
					if(!hasRootId) {
						
						String val = mNode.getNodeVal() == null ? "":mNode.getNodeVal().toString();
						map.put(node.getNodeName(), val);
					}
					
				}
				
			}
			
		}
		
		if(LOG.isDebugEnabled()) {
			
			LOG.debug(map.toString());
		}
		
		return map;
	}


	private void buildHasRootMap(NodeDesc node, Map<String, Object> map, List<MessageNode> mNodeList, String contentType) {

		int rootNodeId = node.getNodeDescId();
		
		Map<String, Object> contentMap = new HashMap<String, Object>();
		
		map.put(node.getNodeName(), contentMap);
		
		buildMap(map, node.getNodeName(), rootNodeId, node.getNodePath(), contentMap, mNodeList, null, contentType);
		
	}


	private void buildMap(Map<String, Object> parentMap, String parentKey, int parentId, String parentPath,
			Map<String, Object> subMap, List<MessageNode> mNodeList, List<Object> parentList, String contentType) {
		
		//存放数组节点
		List<Object> list = null;
		
		for(MessageNode mNode : mNodeList) {
			
			NodeDesc node = mNode.getNodeDesc();
			
			if(node.getParentNodeId() != null && (int)node.getParentNodeId() == parentId) {
				
				//body节点
				if(Constant.NODETYPE_BODY.equals(node.getNodeType())) {
					
					Object nodeVal = mNode.getNodeVal();
					
					//需要封装成数组，对应NODE_NUMBER_CONS=5的情况
					if(subMap == null) {
						
						subMap = new HashMap<String, Object>();
						
						if(parentList != null) {
							
							parentList.add(subMap);
						}
					}
					
					//非叶子节点
					if(nodeVal == null) {
						
						if(Constant.NODE_NUMBER_CONS_0_N.equals(node.getNodeNumberCons()) || 
								Constant.NODE_NUMBER_CONS_1_N.equals(node.getNodeNumberCons())) {
							//针对xml数组
							if(Constant.CONTENT_TYPE_XML.equals(contentType)) {
								
								if(list == null) {
									list = new ArrayList<Object>();
									
								}
								
								parentMap.put(parentKey, list);
								
								Map<String, Object> subCMap = new HashMap<String, Object>();
								list.add(subCMap);
								Map<String, Object> subSMap = new HashMap<String, Object>();
								subCMap.put(node.getNodeName(), subSMap);
								
								buildMap(subCMap, node.getNodeName(), node.getNodeDescId(), node.getNodePath(), subSMap, mNodeList, null,contentType);
							//json数组,json数组外层带一个标识
							} else if(Constant.CONTENT_TYPE_JSON.equals(contentType)) {

								List<Object> arrList = new ArrayList<Object>();
								subMap.put(node.getNodeName(), arrList);
							
								buildMap(subMap, node.getNodeName(), node.getNodeDescId(), node.getNodePath(), null, mNodeList, arrList,contentType);
							}
							
						} else {
							//普通节点
							if(subMap.get(node.getNodeName()) == null) {
								
								Map<String, Object> subCMap = new HashMap<String, Object>();
								subMap.put(node.getNodeName(), subCMap);
								
								buildMap(subMap,node.getNodeName(), node.getNodeDescId(), node.getNodePath(),subCMap, mNodeList, null,contentType);
							}
						}
						
					} else {
						//叶子节点
						subMap.put(node.getNodeName(), nodeVal.toString());
						
					}
					
				} else {
					
					addNameSpaceOrAttr(node, parentPath, contentType);
				}
				
			} else {
				
				addNameSpace(node, contentType);
			}
		}
		
	}
	
	private void addNameSpace(NodeDesc node, String contentType) {

		//命名空间属性
		if(Constant.CONTENT_TYPE_XML.equals(contentType)
				&& Constant.NODETYPE_NAMESPACE.equals(node.getNodeType())) {
			
			String[] kv = node.getNodeCode().split("=");
			if(!nameSpaceMap.containsKey(kv[0])) {
				
				nameSpaceMap.put(kv[0], kv[1]);
			}
			
		}
	}

	private void addNameSpaceOrAttr(NodeDesc node, String parentPath, String contentType) {

		if(Constant.CONTENT_TYPE_XML.equals(contentType)) {
			
			//子命名空间
			if(Constant.NODETYPE_CHILD_NAMESPACE.equals(node.getNodeType())
					&& !StringUtils.isEmpty(parentPath)) {
				
				addChildNameSpace(node, parentPath);
			}
			//节点属性
			else if(Constant.NODETYPE_ATTR.equals(node.getNodeType())
					&& !StringUtils.isEmpty(parentPath)) {

				addAttr(node, parentPath);
			}
		}
		
	}

	private void addAttr(NodeDesc node, String parentPath) {

		Object obj = mapAttr.get(parentPath);
		
		if(obj != null) {
			
			List<String> cList = (List<String>)obj;
			cList.add(node.getNodeCode());
		} else {
			
			List<String> cList = new ArrayList<String>();
			cList.add(node.getNodeCode());
			mapAttr.put(parentPath, cList);
		}
	}

	private void addChildNameSpace(NodeDesc node, String parentPath) {

		Object obj = childNameSpaceMap.get(parentPath);
		
		if(obj != null) {
			
			List<String> cList = (List<String>)obj;
			cList.add(node.getNodeCode());
		} else {
			
			List<String> cList = new ArrayList<String>();
			cList.add(node.getNodeCode());
			childNameSpaceMap.put(parentPath, cList);
		}
		
	}



	public  Map<String, String> getNameSpaceMap() {
		return nameSpaceMap;
	}

	public  Map<String, Object> getMapAttr() {
		return mapAttr;
	}

	public  Map<String, Object> getChildNameSpaceMap() {
		return childNameSpaceMap;
	}
	
	
}