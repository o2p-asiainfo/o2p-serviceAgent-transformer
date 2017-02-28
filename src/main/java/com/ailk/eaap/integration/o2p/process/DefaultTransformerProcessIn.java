package com.ailk.eaap.integration.o2p.process;



import org.apache.poi.hssf.record.formula.functions.T;

import com.ailk.eaap.integration.o2p.message.GenericMessage;
import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.ailk.eaap.op2.bo.ContractFormat;
import com.ailk.eaap.op2.bo.MessageDesc;
import com.ailk.eaap.op2.bo.NodeDesc;

public class DefaultTransformerProcessIn extends
		AbstractTransformerProcessIn {

	@Override
	public MessageBO<?> processContent(MessageDesc md, MessageBO<?> bo) throws Exception {
		GenericMessage<T> gm = new GenericMessage<T>(null, md.getHeaders());
		return gm;
	}

	@Override
	public Object parseNodeValBySrcMsg(MessageBO<?> srcMsg,
			ContractFormat contractFormat, NodeDesc nodeDesc) {
		return null;
	}

}
