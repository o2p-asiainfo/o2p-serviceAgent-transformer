package com.ailk.eaap.integration.o2p.message.support;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.Assert;

import com.ailk.eaap.integration.o2p.message.GenericMessage;
import com.ailk.eaap.op2.serviceagent.common.MessageBO;

public final class MessageBuilder<T>
{
    private final T payload;

    private final Map<String, Object> headers = new HashMap<String, Object>();

    @SuppressWarnings("unused")
    private final MessageBO<T> originalMessage;

    private MessageBuilder(T payload, MessageBO<T> originalMessage)
    {
        Assert.notNull(payload, "payload must not be null");
        this.payload = payload;
        this.originalMessage = originalMessage;
    }

    public static <T> MessageBuilder<T> fromMessage(MessageBO<T> message)
    {
        Assert.notNull(message, "message must not be null");
        verifyType(message.getMsgHead());
        MessageBuilder<T> builder = new MessageBuilder<T>(message.getMsgBody(),
                message);
        return builder;
    }

    private static void verifyType(Map<String, Object> msgHead)
    {
        // verify base contract from header
        Assert.notNull(msgHead, "message header must not be null");
    }

    public MessageBO<T> build()
    {

        return new GenericMessage<T>(this.payload, this.headers);
    }
}
