package com.ailk.eaap.integration.o2p.transformer;

import java.io.File;

import org.apache.commons.io.FileUtils;

import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.asiainfo.foundation.log.Logger;
import com.ailk.eaap.op2.bo.TransformerRule;

public class File2StringTransformer extends AbstractTransformer{
	private static final Logger logger = Logger.getLog(File2StringTransformer.class);
	
	@Override
	protected Object beforeTransform(MessageBO<?> message,
			TransformerRule transformerRule) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object doTransform(MessageBO<?> message,
			TransformerRule transformerRule) throws Exception {

		MessageBO<String> retMsg = new MessageBO<String>();
		
		File file = null;
		Object obj = message.getMsgBody();
			
		if(obj instanceof File) {
			
			file = (File)obj;
		} else if(obj instanceof File[]) {
			
			file = ((File[])obj).length > 0 ? ((File[])obj)[0] : null;
		}
		
		String fileMessage = "";
		if(file != null) {
			if(logger.isDebugEnabled()) {
				logger.debug("File2StringTransformer. file dir="+file.getPath());
			}
			fileMessage = FileUtils.readFileToString(file, "gbk");
		} else {
			if(logger.isDebugEnabled()) {
				logger.debug("File2StringTransformer. file is null.");
			}
		}
		
		retMsg.setMsgBody(fileMessage);
		
		return retMsg;
	}

	@Override
	protected Object afterTransform(MessageBO<?> message,
			TransformerRule transformerRule) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
