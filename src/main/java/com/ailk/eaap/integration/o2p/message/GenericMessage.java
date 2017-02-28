package com.ailk.eaap.integration.o2p.message;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.Assert;

import com.ailk.eaap.op2.serviceagent.common.MessageBO;

/**
 * 
 * @author zhuangyq
 * 
 * @param <T>
 */
public class GenericMessage<T> extends MessageBO<T>
{
    private static final long serialVersionUID = 3649200745084232821L;
    private final T payload;
    private final Map<String, Object> headers;

    public GenericMessage(T payload, Map<String, Object> headers)
    {
        Assert.notNull(payload, "payload must not be null");
        if (headers == null)
        {
            headers = new HashMap<String, Object>();
        }
        this.headers = headers;
        this.payload = payload;
    }

    public T getPayload()
    {
        return payload;
    }

    public Map<String, Object> getHeaders()
    {
        return headers;
    }

    public String toString()
    {
        return "[Payload=" + this.payload + "][Headers=" + this.headers + "]";
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj != null)
        {
            if (obj instanceof GenericMessage<?>)
            {
                GenericMessage<?> other = (GenericMessage<?>) obj;
                if (!this.getTransactionID().equals(other.getTransactionID()))
                {
                    return false;
                }
                return this.headers.equals(other.headers)
                        && this.payload.equals(other.payload);
            }

        }
        return false;
    }

    public int hashcode(Object obj)
    {
        if (obj == null)
        {
            return 0;
        }
        int h = 1;
        h = 31 * h + obj.hashCode();

        return h;
    }

}
