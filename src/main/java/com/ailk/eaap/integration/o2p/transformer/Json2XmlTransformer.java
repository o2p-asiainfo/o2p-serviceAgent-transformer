package com.ailk.eaap.integration.o2p.transformer;

import org.dom4j.Document;
import org.springframework.util.Assert;

import com.ailk.eaap.o2p.common.util.StaxonUtils;
import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.asiainfo.foundation.log.Logger;
import com.ailk.eaap.op2.bo.DataType;
import com.ailk.eaap.op2.bo.TransformerRule;

public class Json2XmlTransformer extends AbstractTransformer
{
    private  static final Logger LOG = Logger.getLog(Json2XmlTransformer.class);

    @Override
    protected Object beforeTransform(MessageBO<?> message,
            TransformerRule transformerRule) throws Exception
    {
        // TODO Auto-generated method stub
        return null;
    }

    @SuppressWarnings(
    { "unchecked", "rawtypes" })
    @Override
    protected Object doTransform(MessageBO<?> message,
            TransformerRule transformerRule) throws Exception
    {
        Object msgBody = message.getMsgBody();
        Assert.notNull(msgBody,
                "the message transId=" + message.getTransactionID()
                        + ",msgBody must not be null!");
        LOG.info("standard JSON convert to XML");
        MessageBO retMsg = new MessageBO();
        if (msgBody instanceof String)
        {
            String retBody = StaxonUtils.jsontoXml(msgBody.toString());
            retMsg.setDataType(DataType.XML);
            retMsg.setMsgBody(retBody);
        }
        else if (msgBody instanceof Document)
        {
            Document doc = (Document) msgBody;
            String retBody = StaxonUtils.jsontoXml(doc.asXML());
            retMsg.setDataType(DataType.XML);
            retMsg.setMsgBody(retBody);
        }
        else
        {
            String retBody = StaxonUtils.jsontoXml(msgBody.toString());
            retMsg.setDataType(DataType.XML);
            retMsg.setMsgBody(retBody);
        }
        LOG.info("standard JSON convert to XML {0}", retMsg.toString());
        return retMsg;
    }

    @Override
    protected Object afterTransform(MessageBO<?> message,
            TransformerRule transformerRule) throws Exception
    {
        // TODO Auto-generated method stub
        return null;
    }

}
