package com.ailk.eaap.integration.o2p.message.support;

import com.ailk.eaap.integration.o2p.message.GenericMessage;
import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.ailk.eaap.op2.bo.ContractVersion;

public interface MessageParser<T> {
	public GenericMessage<T> parse(ContractVersion contractVersion,MessageBO originalMessage);
}
