package com.ailk.eaap.integration.o2p.transformer.service;

import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.ailk.eaap.op2.bo.TransformerRule;

public interface TransformerRuleService {
	public  static final Integer TRANSFORMER_TYPE_COMM_MODEL = 1;
	public  static final Integer TRANSFORMER_TYPE_XSL_XML = 5;
	public  static final Integer TRANSFORMER_TYPE_SCRIPT_JS = 2;
	public  static final Integer TRANSFORMER_TYPE_SCRIPT_BSH = 3;
	public  static final Integer TRANSFORMER_TYPE_SCRIPT_PYTHON = 4;
	public  static final Integer TRANSFORMER_TYPE_STD_XML2JSON = 6;
	public  static final Integer TRANSFORMER_TYPE_STD_JSON2XML = 7;
	public  static final Integer TRANSFORMER_TYPE_STD_CSV2XLS = 8;
	public  static final Integer TRANSFORMER_TYPE_STD_FILE2BYTE = 9;
	
	public void save(TransformerRule obj);
	public MessageBO<?> doTransform(MessageBO<?> message,Integer transformerRuleId);
}
