package com.ailk.eaap.integration.o2p.transformer;

import org.dom4j.Document;
import org.springframework.util.Assert;

import com.ailk.eaap.o2p.common.util.StaxonUtils;
import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.asiainfo.foundation.log.Logger;
import com.ailk.eaap.op2.bo.DataType;
import com.ailk.eaap.op2.bo.TransformerRule;

/**
 * 
 * @author 颖勤
 * 
 */
public class Xml2JsonTransformer extends AbstractTransformer
{
    private  static final Logger LOG = Logger.getLog(Xml2JsonTransformer.class);

    @Override
    protected Object beforeTransform(MessageBO<?> message,
            TransformerRule transformerRule) throws Exception
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected Object doTransform(MessageBO<?> message,
            TransformerRule transformerRule) throws Exception
    {
        Object msgBody = message.getMsgBody();
        Assert.notNull(msgBody,
                "the message transId=" + message.getTransactionID()
                        + ",msgBody must not be null!");
        MessageBO retMsg = new MessageBO();
        LOG.info("standard XML convert to JSON");
        if (msgBody instanceof String)
        {
            String retBody = StaxonUtils.xml2json(msgBody.toString());
            retMsg.setDataType(DataType.JSON);
            retMsg.setMsgBody(retBody);
        }
        else if (msgBody instanceof Document)
        {
            Document doc = (Document) msgBody;
            String retBody = StaxonUtils.xml2json(doc.asXML());
            retMsg.setDataType(DataType.JSON);
            retMsg.setMsgBody(retBody);
        }
        LOG.info("standard XML convert to JSON {0}", retMsg.toString());
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
