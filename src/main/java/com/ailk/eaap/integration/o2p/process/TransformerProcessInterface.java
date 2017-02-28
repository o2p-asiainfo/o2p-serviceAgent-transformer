package com.ailk.eaap.integration.o2p.process;


import java.util.Map;

import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.ailk.eaap.op2.bo.ContractFormat;
import com.ailk.eaap.op2.bo.MessageDesc;
import com.ailk.eaap.op2.bo.NodeDesc;

public interface TransformerProcessInterface {
	/**
	 * 组织成Map结构
	 * @return
	 */
	public Map<String, Object> structuredIntoMap(MessageDesc md);
	/**
	 * 根据源消息及协议格式定义获取节点值
	 */
	public Object parseNodeValBySrcMsg(MessageBO<?> srcMsg,ContractFormat contractFormat,NodeDesc nodeDesc);
	
}
