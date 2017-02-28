package com.ailk.eaap.integration.o2p.transformer;

import com.ailk.eaap.op2.serviceagent.common.MessageBO;

/**
 * 
 * @author zhuangyq
 * @version 2014-05-20
 *
 */
public interface Transformer {
	public MessageBO<?> transform(MessageBO<?> message);
}
