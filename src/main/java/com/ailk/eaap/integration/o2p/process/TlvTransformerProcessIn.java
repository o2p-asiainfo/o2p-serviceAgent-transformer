package com.ailk.eaap.integration.o2p.process;

import java.util.List;
import java.util.Map;

import org.springframework.util.Assert;

import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.asiainfo.foundation.exception.BusinessException;
import com.asiainfo.foundation.log.LogModel;
import com.asiainfo.foundation.log.Logger;
import com.ailk.eaap.op2.bo.ContractFormat;
import com.ailk.eaap.op2.bo.MessageDesc;
import com.ailk.eaap.op2.bo.MessageNode;
import com.ailk.eaap.op2.bo.NodeDesc;

public class TlvTransformerProcessIn extends AbstractTransformerProcessIn
{

    private static final Logger LOG = Logger
            .getLog(TlvTransformerProcessIn.class);

    @Override
    public Object parseNodeValBySrcMsg(MessageBO<?> srcMsg,
            ContractFormat contractFormat, NodeDesc nodeDesc)
    {
        Assert.notNull(srcMsg.getMsgBody(), "The TLV MsgBody is null ");
        Assert.notNull(contractFormat, "The TLV contractFormat is null");
        Assert.notNull(nodeDesc, "The TLV nodeDesc is null");

        if (nodeDesc.getNodeType().equals(Constant.NODETYPE_HEADER))
        {
            return srcMsg.getMsgHead().get(nodeDesc.getNodeCode());
        }
        String str = srcMsg.getMsgBody().toString();
        int[] iArray = TransformerProcessUtils.regexNodepath(nodeDesc
                .getNodePath());
        String value = str.substring(iArray[0], iArray[1] + 1);

        return value;
    }

    @Override
    public MessageBO<?> processContent(MessageDesc md, MessageBO<?> bo)
            throws Exception
    {
        Assert.notNull(md, "The TLV md is null");
        if (LOG.isDebugEnabled())
        {
            LOG.debug("Tlv process type : {0}", md.getContractFormat()
                    .getConType());
        }
        List<MessageNode> messageNodes = md.getMessageNodes();
        Assert.notNull(messageNodes, "THe TLV messageNodes is null");
        StringBuilder sbu = new StringBuilder();
        for (MessageNode messageNode : messageNodes)
        {
            NodeDesc nd = messageNode.getNodeDesc();
            if (nd.getNodeType().equals(Constant.NODETYPE_BODY))
            {
                String nodePath = nd.getNodePath();
                int[] iArray = TransformerProcessUtils.regexNodepath(nodePath);
                Assert.notNull(iArray, "The TLV get NodePath array is null");
                int length = iArray[1] - iArray[0] + 1;
                // 判断截取的长度是否一致
                if (messageNode.getNodeVal().toString().length() != length)
                {
                    LOG.error(
                            LogModel.EVENT_APP_EXCPT,
                            "serviceAgent-transformer Tlv process content Values do not agree with NodePath length");
                    throw new BusinessException(9143,
                            "o2p.serviceAgent.transformer.tlvLength", null,
                            null);
                }
                sbu.append(messageNode.getNodeVal());
            }

        }
        MessageBO<String> tarBO = new MessageBO<String>();
        tarBO.setMsgBody(sbu.toString());

        Map<String, Object> msgMap = super.msgHeader(md);
        tarBO.setMsgHead(msgMap);

        return tarBO;
    }

}
