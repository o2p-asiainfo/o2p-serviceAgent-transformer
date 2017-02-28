package com.ailk.eaap.integration.o2p.message.support;

import java.util.List;

import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.ailk.eaap.op2.bo.NodeDesc;
import com.ailk.eaap.op2.bo.NodeDescMapper;
import com.ailk.eaap.op2.bo.NodeValReq;
import com.ailk.eaap.op2.bo.TransformerRule;



public interface MessageMapperService {
	public  static final String CONST_OPER_TYPE_MOVE = "M";
	public  static final String CONST_OPER_TYPE_ASIGN = "A";
	public  static final String CONST_OPER_TYPE_UPDATE = "U";
	public  static final String CONST_OPER_TYPE_LOGIC = "L";
	public  static final String CONST_OPER_TYPE_REMAIN = "R";
	public  static final String CONST_OPER_TYPE_EXTRACT = "E";
	public  static final String CONST_OPER_TYPE_JOIN = "J";
	public  static final String CONST_OPER_TYPE_ZZH = "Z";
	public  static final String CONST_OPER_TYPE_HZZ = "H";
	public  static final String CONST_OPER_TYPE_REFLECT = "RFT";
	public  static final String CONST_OPER_TYPE_COPY_NODE = "CN";
	public  static final String CONST_OPER_TYPE_DELETE_NODE = "DN";
	public  static final String CONST_MSG_CON_TYPE_XML = "1";
	public  static final String CONST_MSG_CON_TYPE_JSON = "2";
	public  static final String CONST_MSG_CON_TYPE_URLGET = "3";
	public  static final String CONST_MSG_CON_TYPE_TXT = "4";
	public  static final String CONST_MSG_CON_TYPE_TLV = "7";
	public  static final String CONST_MSG_CON_TYPE_XSL = "9";
	public  static final String CONST_MSG_CON_TYPE_HTTPMSG_STYLE_URL = "10";
	public  static final String CONST_MSG_CON_TYPE_CSV = "11";
	public  static final String CONST_NODE_VAL_TYPE_SRC = "1";
	public  static final String CONST_NODE_VAL_TYPE_FIX = "2";
	public  static final String CONST_NODE_VAL_TYPE_MAP = "3";
	public  static final String CONST_NODE_VAL_TYPE_SCRIPT = "4";
	public  static final String CONST_NODE_VAL_TYPE_SPLIT = "5";
	public  static final String CONST_NODE_VAL_TYPE_MERGE = "6";
	public  static final String CONST_NODE_VAL_TYPE_OGNL = "7";
	public  static final String CONST_NODE_VAL_TYPE_CONDITION = "8";
	public  static final String CONST_NODE_VAL_TYPE_REFLECT = "9";
	public  static final String CONST_NODE_TYPE_HEAD = "1";
	public  static final String CONST_NODE_TYPE_BODY = "2";
	public  static final String CONST_NODE_TYPE_URL = "4";
	public  static final String CONST_NODE_TYPE_ATTR = "7";
	
	public static final String XML_PATH_SPLIT = "<XML_SPLIT>";
	public static final String JSON_PATH_SPLIT = "<JSON_SPLIT>";
	public static final String BODY = "$BODY";
	public List<NodeDescMapper> getNodeDescMapperList(Integer transformerRuleId);

	public NodeValReq getNodeValReq(NodeDesc tarNode);

	public Object getNodeVal(NodeDesc tarNode);
	public Object getTarNodeValByMapper(MessageBO<?> message,TransformerRule transformerRule,NodeDescMapper nodeDescMapper);
}
