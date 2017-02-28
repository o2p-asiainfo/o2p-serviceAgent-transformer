package com.ailk.eaap.integration.o2p.transformer;

import com.ailk.eaap.integration.o2p.message.MessagingException;
import com.ailk.eaap.op2.serviceagent.common.MessageBO;

@SuppressWarnings("serial")
public class MessageTransformationException extends MessagingException{
	public MessageTransformationException(MessageBO<?> message, String description, Throwable cause) {
		super(message, description, cause);
	}

	public MessageTransformationException(MessageBO<?> message, String description) {
		super(message, description);
	}

	public MessageTransformationException(MessageBO<?> message,int code, String description){
		super(message, code,description);
	}

	public MessageTransformationException(String description, Throwable cause) {
		super(description, cause);
	}

	public MessageTransformationException(String description) {
		super(description);
	}
}
