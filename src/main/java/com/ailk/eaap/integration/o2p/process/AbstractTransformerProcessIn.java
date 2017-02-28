package com.ailk.eaap.integration.o2p.process;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.asiainfo.foundation.log.Logger;
import com.ailk.eaap.op2.bo.MessageDesc;
import com.ailk.eaap.op2.bo.MessageNode;
import com.ailk.eaap.op2.bo.NodeDesc;

public abstract class AbstractTransformerProcessIn implements
        TransformerProcessInterface
{
    private static final Logger LOG = Logger
            .getLog(AbstractTransformerProcessIn.class);

    private static ThreadLocal<MessageBO<?>> threadLocalMessageBO = new ThreadLocal<MessageBO<?>>();
    private static ThreadLocal<TransformerProcessUtils> threadLocalProcessUtils = new ThreadLocal<TransformerProcessUtils>();
    protected static ThreadLocal<TransformerMapBuild> threadLocalMapBuild = new ThreadLocal<TransformerMapBuild>();
    
    @SuppressWarnings(
    { "unchecked" })
    public Map<String, Object> structuredIntoMap(MessageDesc md)
    {
        if (LOG.isDebugEnabled())
        {
            LOG.debug("Transformer process conType : {0}", md
                    .getContractFormat().getConType());
        }
        

		threadLocalMapBuild.set(new TransformerMapBuild());
			
		Map<String, Object> map = threadLocalMapBuild.get().mapBuild(md, md.getContractFormat().getConType());
		
		return map;
    }

    /**
     * 获取header
     * 
     * @param md
     * @return
     */
    @SuppressWarnings(
    { "rawtypes" })
    public Map<String, Object> msgHeader(MessageDesc md)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        for (MessageNode mn : md.getMessageNodes())
        {
            NodeDesc nd = mn.getNodeDesc();
            if (nd != null && Constant.NODETYPE_HEADER.equals(nd.getNodeType()))
            {
                if (mn.getNodeVal() instanceof List)
                {
                    List list = (List) mn.getNodeVal();
                    map.put(nd.getNodeCode(), list.get(0));
                }
                else
                {
                    map.put(nd.getNodeCode(), mn.getNodeVal());
                }

            }
        }
        return map;
    }

    /**
     * 获取Url map
     * 
     * @param md
     * @return
     */
    @SuppressWarnings(
    { "rawtypes" })
    public Map<String, Object> MsgUrl(MessageDesc md)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        for (MessageNode mn : md.getMessageNodes())
        {
            NodeDesc nd = mn.getNodeDesc();
            if (nd != null && Constant.NODETYPE_URL.equals(nd.getNodeType()))
            {
                if (mn.getNodeVal() instanceof List)
                {
                    List list = (List) mn.getNodeVal();
                    map.put(nd.getNodeCode(), list.get(0));
                }
                else
                {
                    map.put(nd.getNodeCode(), mn.getNodeVal());
                }

            }
        }
        return map;
    }

    public static MessageBO<?> getThreadLocalMessageBO()
    {
        return threadLocalMessageBO.get();
    }

    public static void setThreadLocalMessageBO(MessageBO<?> bo)
    {
        threadLocalMessageBO.set(bo);
    }

    public static TransformerProcessUtils getThreadLocalProcessUtils()
    {
        return threadLocalProcessUtils.get();
    }

    public static void setThreadLocalProcessUtils(
            TransformerProcessUtils transformerProcessUtils)
    {
        threadLocalProcessUtils.set(transformerProcessUtils);
    }

    public static String getEncoding()
    {
        return "utf-8";
    }
    public static void setThreadLocalMapBuild(TransformerMapBuild transformerMapBuild) {

		threadLocalMapBuild.set(transformerMapBuild);
	}

    public abstract MessageBO<?> processContent(MessageDesc md, MessageBO<?> bo)
            throws Exception;

}
