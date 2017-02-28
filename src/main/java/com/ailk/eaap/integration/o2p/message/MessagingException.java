package com.ailk.eaap.integration.o2p.message;

import com.ailk.eaap.op2.serviceagent.common.MessageBO;

/**
 * Created by david on 14-8-11.
 */
@SuppressWarnings("serial")
public class MessagingException extends RuntimeException
{
    private volatile MessageBO<?> failedMessage;

    public MessagingException(MessageBO<?> message)
    {
        this.failedMessage = message;
    }

    public MessagingException(String description)
    {
        super(description);
        this.failedMessage = null;
    }

    public MessagingException(String description, Throwable cause)
    {
        super(description, cause);
        this.failedMessage = null;
    }

    public MessagingException(MessageBO<?> message, int code, String description)
    {
        super(description);
        this.failedMessage = message;
    }

    public MessageBO<?> getFailedMessage()
    {
        return this.failedMessage;
    }

    public MessagingException(MessageBO<?> message, String description,
            Throwable cause)
    {
        super(description, cause);
        this.failedMessage = message;
    }

    public MessagingException(MessageBO<?> message, String description)
    {
        super(description);
        this.failedMessage = message;
    }

    public void setFailedMessage(MessageBO<?> message)
    {
        this.failedMessage = message;
    }
}
