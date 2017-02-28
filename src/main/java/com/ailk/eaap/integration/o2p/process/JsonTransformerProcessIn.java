package com.ailk.eaap.integration.o2p.process;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.util.Assert;

import com.ailk.eaap.integration.o2p.contractbody.util.ContractBodyUtil;
import com.ailk.eaap.integration.o2p.transformer.MessageTransformationException;
import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.asiainfo.foundation.exception.BusinessException;
import com.asiainfo.foundation.log.LogModel;
import com.asiainfo.foundation.log.Logger;
import com.ailk.eaap.op2.bo.ContractFormat;
import com.ailk.eaap.op2.bo.MessageDesc;
import com.ailk.eaap.op2.bo.NodeDesc;
import com.linkage.rainbow.util.StringUtil;

public class JsonTransformerProcessIn extends AbstractTransformerProcessIn
{

    private static final Logger LOG = Logger
            .getLog(JsonTransformerProcessIn.class);

    @SuppressWarnings(
    { "unchecked" })
    public MessageBO<?> processContent(MessageDesc md, MessageBO<?> bo)
            throws Exception
    {
        Assert.notNull(md, "The Json md is null");
        super.setThreadLocalProcessUtils(new TransformerProcessUtils());
        Map<String, Object> map = super.structuredIntoMap(md);
        if (LOG.isDebugEnabled())
        {
            LOG.debug("Map process : {0}", map.toString());
        }
        MessageBO<JSONObject> tarBO = new MessageBO<JSONObject>();
        if(map.size() > 0) {
			
			JSONObject json = JSONObject.fromObject(map);  
			tarBO.setMsgBody(json);
			
			if (LOG.isDebugEnabled()) {
				LOG.debug("json process : {0}", json.toString());
			}
		}

        Map<String, Object> msgHeadMap = new HashMap<String, Object>();
        msgHeadMap.putAll(md.getHeaders());
        msgHeadMap.putAll(super.msgHeader(md));
        Map<String, Object> msgUrlMap = super.MsgUrl(md);
        if (LOG.isDebugEnabled())
        {
            LOG.debug("JSON Header process : {0}", msgHeadMap.toString());
            LOG.debug("JSON Url process : {0}", msgUrlMap.toString());
        }

        tarBO.setMsgHead(msgHeadMap);
        tarBO.setMessageMap(msgUrlMap);
        tarBO.setTransactionID(bo.getTransactionID());

        return tarBO;
    }

    @Override
    public Object parseNodeValBySrcMsg(MessageBO<?> srcMsg,
            ContractFormat contractFormat, NodeDesc nodeDesc)
    {
        if (StringUtil.isEmpty(srcMsg.toString()))
        {
            if (LOG.isDebugEnabled())
            {
                LOG.debug("The Json MsgBody is null");
            }
        }

        if (nodeDesc != null)
        {
            try
            {
                return ContractBodyUtil.getNodeValByNodeDesc(srcMsg, nodeDesc);
            }
            catch (MessageTransformationException e)
            {
                throw new BusinessException(9143,
                        "o2p.serviceAgent.transformer.jsonPath", null, e);
            }
            catch (Exception e)
            {
                LOG.error(LogModel.EVENT_APP_EXCPT,
                        "Parsing JSONPATH error id : {0}, node_path : {1}",
                        nodeDesc.getNodeDescId(), nodeDesc.getNodePath());
                throw new BusinessException(9143,
                        "o2p.serviceAgent.transformer.jsonPath", null, e);
            }
        }
        return null;
    }

}
