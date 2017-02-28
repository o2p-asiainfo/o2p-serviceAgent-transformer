package com.ailk.eaap.integration.o2p.transformer;

import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.ailk.eaap.op2.bo.ContractAdapter2AttrSpec;
import com.ailk.eaap.op2.bo.TransformerRule;

/**
 * Created by david on 14-8-13.
 */
public class Byte2StringTransformer extends AbstractTransformer {
    @Override
    protected Object beforeTransform(MessageBO<?> message, TransformerRule transformerRule) throws Exception {
        return null;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
    protected Object doTransform(MessageBO<?> message, TransformerRule transformerRule) throws Exception {
        byte[] bytes = (byte[]) message.getMsgBody();
        String encoding = "UTF-8";
        for(ContractAdapter2AttrSpec adapter2AttrSpec : transformerRule.getContractAdapter2AttrSpecs()) {
            if("encoding".equals(adapter2AttrSpec.getAttrSpec().getAttrSpecCode())) {
                encoding = adapter2AttrSpec.getValue();
            }
        }
        String str = new String(bytes, encoding);
        MessageBO messageBO = new MessageBO();
        messageBO.setMsgBody(str);
        return messageBO;
    }

    @Override
    protected Object afterTransform(MessageBO<?> message, TransformerRule transformerRule) throws Exception {
        return null;
    }
}
