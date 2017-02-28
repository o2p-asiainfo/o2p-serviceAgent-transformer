package com.ailk.eaap.integration.o2p.transformer.common;

public interface IScriptDoMsg {

	public Object doMessage(com.ailk.eaap.op2.serviceagent.common.MessageBO messageBO, com.ailk.eaap.o2p.common.cache.ICache cacheclient ,com.ailk.eaap.op2.serviceagent.deal.service.IMessageBoHisService messageBoHisSer);
}
