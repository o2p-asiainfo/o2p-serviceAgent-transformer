package com.ailk.eaap.integration.o2p.transformer;

import javax.xml.transform.TransformerFactory;

import org.dom4j.Document;
import org.springframework.util.Assert;

import com.ailk.eaap.integration.o2p.transformer.xml.StringResult;
import com.ailk.eaap.integration.o2p.transformer.xml.StringSource;
import com.ailk.eaap.integration.o2p.transformer.xml.TransformerHelper;
import com.ailk.eaap.op2.common.O2pDocumentHelper;
import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.ailk.eaap.op2.bo.TransformerRule;

public class XSLTransformer extends AbstractTransformer
{
    private TransformerHelper transformerHelper;

    @Override
    protected Object beforeTransform(MessageBO<?> message,
            TransformerRule transformerRule) throws Exception
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected Object doTransform(MessageBO<?> message, TransformerRule transformerRule) throws Exception {
    	String reqMsg = message.toString();
		Assert.hasText(transformerRule.getScriptContent(),"the transformerRule id="+transformerRule.getId()+",must be configured ScriptContent and the style request XSL");
		StringSource styleSource = new StringSource(transformerRule.getScriptContent());
		javax.xml.transform.Transformer xslTransformer = TransformerFactory.newInstance().newTransformer(styleSource);
		StringSource source = new StringSource(reqMsg);
		StringResult retStr = new StringResult();
		xslTransformer.transform(source, retStr);
		String retXml = retStr.toString();
		Document retDoc = O2pDocumentHelper.parseText(retXml);
		MessageBO<Document> retMsg = new MessageBO<Document>();
		retMsg.setMsgBody(retDoc);
		return retMsg;
    }

    protected String msgbodyNull(MessageBO<?> message, Object msgBody)
    {
        String reqMsg;
        if (null == msgBody)
        {
            throw new MessageTransformationException("the message ,transId="
                    + message.getTransactionID()
                    + ",msgBody==null||!(msgBody instanceof Document)");
        }
        Document reqXml = (Document) msgBody;
        reqMsg = reqXml.asXML();
        return reqMsg;
    }

    @Override
    protected Object afterTransform(MessageBO<?> message,
            TransformerRule transformerRule) throws Exception
    {
        // TODO Auto-generated method stub
        return null;
    }

    public TransformerHelper getTransformerHelper()
    {
        return transformerHelper;
    }

    public void setTransformerHelper(TransformerHelper transformerHelper)
    {
        this.transformerHelper = transformerHelper;
    }

}
