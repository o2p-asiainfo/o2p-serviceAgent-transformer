package com.ailk.eaap.integration.o2p.function;


import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Node;

import com.asiainfo.foundation.exception.BusinessException;
import com.asiainfo.foundation.log.Logger;
import com.greenpineyu.fel.function.CommonFunction;

public class FunctionArrayToString extends CommonFunction {

	private static final Logger LOG = Logger.getLog(FunctionArrayToString.class);

	@Override
	public String getName() {
		return "arrayToString";
	}

	@Override
	public Object call(Object[] args) {
		
		if (args != null && args.length >= 2) {
			
			Object obj1 = args[0];
			Object obj2 = args[1];
			Object obj3 = "";
			
			if(args.length == 3) {
				
				obj3 = args[2];
			}
			if(LOG.isDebugEnabled()) {
				
				LOG.debug("====> function arrayToString param1:{0}", obj1.toString());
				LOG.debug("====> function arrayToString param2:{0}", obj2.toString());
				LOG.debug("====> function arrayToString param3:{0}", obj3.toString());
			}
			String path = obj2.toString();
			StringBuffer sb = new StringBuffer();
			String connector = obj3.toString();
			if(obj1 instanceof JSONArray) {
				
				JSONArray array = (JSONArray)obj1;
				path =  path.substring(path.lastIndexOf(".")+1, path.length());
				
				for(Object obj : array) {
					
					jsonAppend(path, sb, connector, obj);
				}
			} else if(obj1 instanceof JSONObject) {
				
				path =  path.substring(path.lastIndexOf(".")+1, path.length());
				jsonAppend(path, sb, connector, obj1);
			} else if(obj1 instanceof List) {
				
				List<Node> nodes = (List<Node>)obj1;
				path = "//"+path.substring(path.lastIndexOf("/")+1, path.length());
				
				for(Node node : nodes) {
					
					xmlAppend(path, sb, connector, node);
				}
			} else if(obj1 instanceof Node) {
				Node node = (Node)obj1;
				path = "//"+path.substring(path.lastIndexOf("/")+1, path.length());
				xmlAppend(path, sb, connector, node);
			}
			String result = sb.toString();
			if(!StringUtils.isEmpty(result)) {
				
				return result.substring(0, result.lastIndexOf(connector));
			}
			
			return "";
		} else {
			throw new BusinessException(9999,
					"fn:arrayToString function format error, "+args.toString());
		}
			
	}

	private void xmlAppend(String path, StringBuffer sb, String connector,
			Node node) {
		Node subNode = node.selectSingleNode(path);
		if(subNode != null) {
			sb.append(subNode.getText());
			sb.append(connector);
		}
	}

	private void jsonAppend(String path, StringBuffer sb, String connector,
			Object obj) {
		JSONObject jsonObj = (JSONObject)obj;
		String value = jsonObj.getString(path);
		sb.append(value);
		sb.append(connector);
	}
}