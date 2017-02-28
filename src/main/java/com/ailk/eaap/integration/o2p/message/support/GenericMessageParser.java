package com.ailk.eaap.integration.o2p.message.support;

import org.apache.poi.hssf.record.formula.functions.T;

import com.ailk.eaap.integration.o2p.message.GenericMessage;
import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.ailk.eaap.op2.bo.ContractVersion;

/**
 * 
 * @author zhuangyq
 *
 */
public class GenericMessageParser implements MessageParser<T> {
	
	@SuppressWarnings("rawtypes")
	public GenericMessage<T> parse(ContractVersion contractVersion,
			MessageBO originalMessage) {
		
		return null;
	}

}
