package com.ailk.eaap.integration.o2p.transformer;

import java.io.File;

import org.springframework.util.FileCopyUtils;

import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.ailk.eaap.op2.bo.TransformerRule;

public class File2ByteArrayTransformer extends AbstractTransformer{

	@Override
	protected Object beforeTransform(MessageBO<?> message,
			TransformerRule transformerRule) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object doTransform(MessageBO<?> message,
			TransformerRule transformerRule) throws Exception {
		File file = (File) message.getMsgBody();
		byte[] b = FileCopyUtils.copyToByteArray(file);
		MessageBO<byte[]> retMsg = new MessageBO<byte[]>();
		retMsg.setMsgBody(b);
		return retMsg;
	}

	@Override
	protected Object afterTransform(MessageBO<?> message,
			TransformerRule transformerRule) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
