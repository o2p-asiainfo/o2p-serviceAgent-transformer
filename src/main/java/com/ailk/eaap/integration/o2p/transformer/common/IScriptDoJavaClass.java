package com.ailk.eaap.integration.o2p.transformer.common;


import org.codehaus.stax2.XMLInputFactory2;
import com.ailk.eaap.o2p.common.cache.ICache;
import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.ailk.eaap.op2.serviceagent.deal.service.IMessageBoHisService;

public abstract class IScriptDoJavaClass {

	public Object doMessage(MessageBO messageBO, ICache cacheClient, IMessageBoHisService messageBoHisSer,
			XMLInputFactory2 saxParser) throws Exception {

		return null;
	}

	

}
