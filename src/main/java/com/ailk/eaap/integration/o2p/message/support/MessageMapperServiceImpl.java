package com.ailk.eaap.integration.o2p.message.support;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;
import ognl.OgnlContext;

import org.springframework.scripting.ScriptSource;
import org.springframework.scripting.support.StaticScriptSource;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.wltea.expression.ExpressionEvaluator;
import org.wltea.expression.datameta.Variable;

import com.ailk.eaap.integration.o2p.contractbody.util.ContractBodyUtil;
import com.ailk.eaap.integration.o2p.process.AbstractTransformerProcessIn;
import com.ailk.eaap.integration.o2p.process.factory.TransformerProcessFactory;
import com.ailk.eaap.integration.o2p.script.ScriptExecutor;
import com.ailk.eaap.integration.o2p.script.jsr223.ScriptExecutorFactory;
import com.ailk.eaap.o2p.common.cache.CacheKey;
import com.ailk.eaap.o2p.common.cache.ICache;
import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.ailk.eaap.op2.serviceagent.deal.service.IMessageBoHisService;
import com.ailk.eaap.op2.serviceagent.deal.service.MessageBoHisServiceImpl;
import com.ailk.eaap.op2.serviceagent.validate.service.IProtocolValidateServ;
import com.asiainfo.foundation.exception.BusinessException;
import com.asiainfo.foundation.log.LogModel;
import com.asiainfo.foundation.log.Logger;
import com.ailk.eaap.op2.bo.ContractFormat;
import com.ailk.eaap.op2.bo.ContractFormatEx;
import com.ailk.eaap.op2.bo.NodeDesc;
import com.ailk.eaap.op2.bo.NodeDescMapper;
import com.ailk.eaap.op2.bo.NodeValReq;
import com.ailk.eaap.op2.bo.ParamVarMap;
import com.ailk.eaap.op2.bo.TransformerRule;

public class MessageMapperServiceImpl implements MessageMapperService
{
    private static final Logger LOG = Logger
            .getLog(MessageMapperServiceImpl.class);
    private ICache<String, Object> cache;
    private TransformerProcessFactory transformerProcessFactory = TransformerProcessFactory
            .getInstance();
    // local thread store node value cache
    private ThreadLocal<Map<String, String>> messageNodes = new ThreadLocal<Map<String, String>>();
    private ScriptExecutorFactory scriptExecutorFactory;
    private IMessageBoHisService messageBoHisSer;
    private IProtocolValidateServ protocolValidateSer;

    public IProtocolValidateServ getProtocolValidateSer()
    {
        return protocolValidateSer;
    }

    public void setProtocolValidateSer(IProtocolValidateServ protocolValidateSer)
    {
        this.protocolValidateSer = protocolValidateSer;
    }

    public TransformerProcessFactory getTransformerProcessFactory()
    {
        return transformerProcessFactory;
    }

    public ScriptExecutorFactory getScriptExecutorFactory()
    {
        return scriptExecutorFactory;
    }

    public void setScriptExecutorFactory(
            ScriptExecutorFactory scriptExecutorFactory)
    {
        this.scriptExecutorFactory = scriptExecutorFactory;
    }

    public IMessageBoHisService getMessageBoHisSer()
    {
        return messageBoHisSer;
    }

    public void setMessageBoHisSer(IMessageBoHisService messageBoHisSer)
    {
        this.messageBoHisSer = messageBoHisSer;
    }

    @Override
    public List<NodeDescMapper> getNodeDescMapperList(Integer transformerRuleId)
    {
        // TODO Auto-generated method stub
        return null;
    }

    public ICache<String, Object> getCache()
    {
        return cache;
    }

    public void setCache(ICache<String, Object> cache)
    {
        this.cache = cache;
    }

    @Override
    public NodeValReq getNodeValReq(NodeDesc tarNode)
    {

        return null;
    }

    @Override
    public Object getNodeVal(NodeDesc tarNode)
    {
        return null;
    }

    @SuppressWarnings(
    { "rawtypes" })
    @Override
    public Object getTarNodeValByMapper(MessageBO<?> message,
            TransformerRule transformerRule, NodeDescMapper nodeDescMapper)
    {
        assertGetTarNodeValByMapper(message, transformerRule, nodeDescMapper);
        Object val = null;
        // 1
        String operTypeCd = nodeDescMapper.getOperTypeCd().trim();
        // copy value from source Message Node to target Node
        ContractFormat srcContractFormat = transformerRule
                .getSrcContractFormat();
        NodeDesc srcNodeDesc = nodeDescMapper.getSrcNode();
        String conType = srcContractFormat.getConType().trim();
        // Multi source transformer
        if (null != srcNodeDesc)
        {
            debugSrcNodeDescId(srcNodeDesc);
            int endpointId = 0;
            endpointId = getHisEndpointId(transformerRule, srcNodeDesc,
                    endpointId);
            ContractFormatEx contractFormat = null;
            contractFormat = judgeContractFormat(transformerRule, srcNodeDesc,
                    contractFormat);
            if (0 != endpointId && null != contractFormat)
            {
                debugMulti(endpointId, contractFormat);
                conType = contractFormat.getConType();
                String reqRsp = contractFormat.getReqRsp();
                MessageBO hisMessageBo = null;
                hisMessageBo = reqOrRspMessageBoHis(endpointId, reqRsp,
                		message);
                if (null == hisMessageBo)
                {
                    LOG.error(
                            "serviceAgent-transformer ID get messages through endpoint trajectory is null {0}",
                            endpointId);
                    return val;
                }
                debugMultiBody(hisMessageBo);
                val = getMessageBoHisVal(val, srcNodeDesc, conType,
                        contractFormat, hisMessageBo);
            }
            else
            {
                val = getNodeValFromSrcNode(message, srcContractFormat,
                        srcNodeDesc, conType);
            }
        }

        judgeMessageNodes();
        Map<String, String> nodeCache = messageNodes.get();
        if (srcNodeDesc != null)
        {
            nodeCache.put("node" + srcNodeDesc.getNodeDescId(),
                    ObjectUtils.nullSafeToString(val));
        }
        if (CONST_OPER_TYPE_REMAIN.equals(operTypeCd))
        {
            return null;
        }
        else if (CONST_OPER_TYPE_MOVE.equals(operTypeCd))
        {
            return val;
        }
        else if (CONST_OPER_TYPE_ASIGN.equals(operTypeCd)
                || CONST_OPER_TYPE_UPDATE.equals(operTypeCd))
        {
            val = getAsignOrUpdate2Val(message, nodeDescMapper, val);
            return val;
        }
        else if (CONST_OPER_TYPE_EXTRACT.equals(operTypeCd))
        {
            Assert.notNull(nodeDescMapper.getTarNodeValReq().getValueExpress(),
                    "Extract Value Express is null");
            val = getExtractVal(nodeDescMapper, val);
            return val;
        }
        else if (CONST_OPER_TYPE_JOIN.equals(operTypeCd))
        {
            return val;
        }
        else
        {
            LOG.info(
                    "the nodeMapper id {0},cannot find match operTypeCd : {1}",
                    nodeDescMapper.getId(), operTypeCd);
        }
        debugTypeAndVal(val, conType);
        return val;
    }

    protected ContractFormatEx judgeContractFormat(
            TransformerRule transformerRule, NodeDesc srcNodeDesc,
            ContractFormatEx contractFormat)
    {
        if (null != transformerRule.getNodeDescToContractFormatMap()
                && transformerRule.getNodeDescToContractFormatMap().size() > 0)
        {
            contractFormat = transformerRule
                    .getNodeDescToContractFormatMap().get(
                            srcNodeDesc.getNodeDescId());
        }
        return contractFormat;
    }

    protected void judgeMessageNodes()
    {
        if (messageNodes.get() == null)
        {
            Map<String, String> nodeLocalCache = new HashMap<String, String>();
            messageNodes.set(nodeLocalCache);
        }
    }

    protected void debugSrcNodeDescId(NodeDesc srcNodeDesc)
    {
        if (LOG.isDebugEnabled())
        {
            LOG.debug(
                    "message mapper getTarNodeValByMapper srcNodeDesc {0}",
                    srcNodeDesc.getNodeDescId());
        }
    }

    protected void debugTypeAndVal(Object val, String conType)
    {
        if (LOG.isDebugEnabled())
        {
            LOG.debug("node mapper operation type={0},the val={1}", conType,
                    val);
        }
    }

    @SuppressWarnings("rawtypes")
    protected void debugMultiBody(MessageBO hisMessageBo)
    {
        if (LOG.isDebugEnabled())
        {
            LOG.debug("multi source transformer msgBody {0}",
                    hisMessageBo.toString());
        }
    }

    protected void debugMulti(int endpointId, ContractFormatEx contractFormat)
    {
        if (LOG.isDebugEnabled())
        {
            LOG.debug(
                    "multi source transformer endpointId {0} contractFormat {1} contype {2} reqrsp {3}",
                    endpointId, contractFormat.getTcpCtrFId(),
                    contractFormat.getConType(), contractFormat.getReqRsp());
        }
    }

    protected int getHisEndpointId(TransformerRule transformerRule,
            NodeDesc srcNodeDesc, int endpointId)
    {
        if (null != transformerRule.getNodeDescToEndpointMap()
                && transformerRule.getNodeDescToEndpointMap().size() > 0)
        {
            if (null != transformerRule.getNodeDescToEndpointMap().get(
                    srcNodeDesc.getNodeDescId()))
            {
                endpointId = transformerRule.getNodeDescToEndpointMap().get(
                        srcNodeDesc.getNodeDescId());
            }

        }
        return endpointId;
    }

    protected Object getAsignOrUpdate2Val(MessageBO<?> message,
            NodeDescMapper nodeDescMapper, Object val)
    {
        Assert.notNull(nodeDescMapper.getTarNodeValReq());
        NodeValReq nodeValReq = nodeDescMapper.getTarNodeValReq();
        try
        {
            val = getNodeValFromValReq(message, nodeValReq, val);
        }
        catch (Exception e)
        {
            LOG.error(LogModel.EVENT_APP_EXCPT,
                    "get the node id {0} value exception {1}",
                    nodeValReq.getNodeDescId(), e.getMessage());
            throw new BusinessException(9101,
                    "o2p.serviceAgent.transformer.abstractTransformer", null, e);
        }
        return val;
    }

    protected Object getExtractVal(NodeDescMapper nodeDescMapper, Object val)
    {
        String express = nodeDescMapper.getTarNodeValReq().getValueExpress();
        if (LOG.isDebugEnabled())
        {
            LOG.debug("Extract Value Express is {0} id is {1}", express,
                    nodeDescMapper.getTarNodeValReq().getNodeValReqId());
        }
        int end = express.lastIndexOf("'");
        StringBuffer sbu = new StringBuffer();
        if (-1 != end)
        {
            sbu.append("'").append(val).append(express.substring(end));
            val = ContractBodyUtil.getValue(nodeDescMapper.getTarNodeValReq()
                    .getNodeDescId(), sbu.toString(), "");

        }
        else
        {
            end = express.lastIndexOf("}");
            sbu.append("{").append(val).append(express.substring(end));
            val = ContractBodyUtil.getValue(nodeDescMapper.getTarNodeValReq()
                    .getNodeDescId(), sbu.toString(), "");
        }
        return val;
    }

    @SuppressWarnings(
    { "rawtypes", "unchecked" })
    protected Object getMessageBoHisVal(Object val, NodeDesc srcNodeDesc,
            String conType, ContractFormatEx contractFormat,
            MessageBO hisMessageBo)
    {
        if (null != hisMessageBo.getMsgBody())
        {

            if (hisMessageBo.getMsgBody() instanceof String
                    && hisMessageBo.toString().startsWith("<"))
            {
                hisMessageBo.setMsgBody(protocolValidateSer
                        .getDocument(hisMessageBo.toString()));
            }
            else if (hisMessageBo.getMsgBody() instanceof String
                    && hisMessageBo.toString().startsWith("{"))
            {
                hisMessageBo.setMsgBody(JSONObject.fromObject(hisMessageBo
                        .toString()));
            }

            val = getNodeValFromSrcNode(hisMessageBo, contractFormat,
                    srcNodeDesc, conType);
        }
        return val;
    }

    @SuppressWarnings("rawtypes")
    protected MessageBO reqOrRspMessageBoHis(int endpointId, String reqRsp,
            MessageBO message)
    {
        if (MessageBoHisServiceImpl.REQ.equals(reqRsp))
        {
            return messageBoHisSer.getReqMessageBoByEpId(endpointId, message);

        }
        else if (MessageBoHisServiceImpl.RSP.equals(reqRsp))
        {
        	return messageBoHisSer.getRspMessageBoByEpId(endpointId, message);
        }
        return null;
    }

    protected void assertGetTarNodeValByMapper(MessageBO<?> message,
            TransformerRule transformerRule, NodeDescMapper nodeDescMapper)
    {
        Assert.notNull(message, "message is null");
        Assert.notNull(transformerRule, "transformerRule is null");
        Assert.notNull(nodeDescMapper, "the transformerRule id="
                + transformerRule.getId() + " no found nodeDescMapper!");
        Assert.notNull(nodeDescMapper.getTarNode(), "the nodeDescMapper id="
                + nodeDescMapper.getId() + " no found tarNode!");
    }

    private Object getNodeValFromSrcNode(MessageBO<?> message,
            ContractFormat srcContractFormat, NodeDesc nodeDesc, String conType)
    {
        Object val = null;
        if (nodeDesc == null)
        {
            return val;
        }
        if (message.getContractBody() != null
                && message.getContractBody().getSrcMapVals()
                        .get(nodeDesc.getNodeDescId()) != null)
        {
            val = message.getContractBody().getSrcMapVals()
                    .get(nodeDesc.getNodeDescId());
            return val;
        }
        if (CONST_MSG_CON_TYPE_XML.equals(conType))
        {
            AbstractTransformerProcessIn transformerProcessIn = transformerProcessFactory
                    .getProcess(Integer.valueOf(CONST_MSG_CON_TYPE_XML));
            val = transformerProcessIn.parseNodeValBySrcMsg(message,
                    srcContractFormat, nodeDesc);
            return val;
        }
        else if (CONST_MSG_CON_TYPE_JSON.equals(conType))
        {
            AbstractTransformerProcessIn transformerProcessIn = transformerProcessFactory
                    .getProcess(Integer.valueOf(CONST_MSG_CON_TYPE_JSON));
            val = transformerProcessIn.parseNodeValBySrcMsg(message,
                    srcContractFormat, nodeDesc);
            return val;
        }
        else if (CONST_MSG_CON_TYPE_CSV.equals(conType))
        {
            AbstractTransformerProcessIn transformerProcessIn = transformerProcessFactory
                    .getProcess(Integer.valueOf(CONST_MSG_CON_TYPE_CSV));
            val = transformerProcessIn.parseNodeValBySrcMsg(message,
                    srcContractFormat, nodeDesc);
            return val;
        }
        else if (CONST_MSG_CON_TYPE_TXT.equals(conType))
        {
            AbstractTransformerProcessIn transformerProcessIn = transformerProcessFactory
                    .getProcess(Integer.valueOf(CONST_MSG_CON_TYPE_TXT));
            val = transformerProcessIn.parseNodeValBySrcMsg(message,
                    srcContractFormat, nodeDesc);
            return val;
        }
        else if (CONST_MSG_CON_TYPE_TLV.equals(conType))
        {
            AbstractTransformerProcessIn transformerProcessIn = transformerProcessFactory
                    .getProcess(Integer.valueOf(CONST_MSG_CON_TYPE_TLV));
            val = transformerProcessIn.parseNodeValBySrcMsg(message,
                    srcContractFormat, nodeDesc);
            return val;
        } 
        else if(CONST_MSG_CON_TYPE_HTTPMSG_STYLE_URL.equals(conType)) {
			AbstractTransformerProcessIn transformerProcessIn = transformerProcessFactory
					.getProcess(Integer.valueOf(CONST_MSG_CON_TYPE_HTTPMSG_STYLE_URL));
			val = transformerProcessIn.parseNodeValBySrcMsg(message,
					srcContractFormat, nodeDesc);
			return val;
		}
        return val;
    }

    private Object getNodeValFromValReq(MessageBO<?> message,
            NodeValReq nodeValReq, final Object srcNodeVal)
    {
        Object val = null;
        String valTypeCd = nodeValReq.getNodeValSourceCd().trim();
        String triggerExpress = nodeValReq.getTriggerExpress();
        if (!StringUtils.hasText(triggerExpress))
        {
            LOG.info("no expression configure ,continue get value !");
        }
        else
        {
            List<Variable> variables = new ArrayList<Variable>();
            
            String resultExp = getOtherNodeValExpress(message, triggerExpress);
            
            variables.add(Variable.createVariable("src_node_val", srcNodeVal));
            Object result = ExpressionEvaluator.evaluate(resultExp,
                    variables);
            Boolean flag = Boolean.valueOf(String.valueOf(result));
            // src node not convert and copy to target node
            if (!flag)
            {
                return srcNodeVal;
            }
        }
        if (CONST_NODE_VAL_TYPE_FIX.equals(valTypeCd))
        {
            val = nodeValReq.getValueExpress().trim();
        }
        else if (CONST_NODE_VAL_TYPE_MAP.equals(valTypeCd))
        {
            String key = CacheKey.PARAM_VAR_MAP
                    + nodeValReq.getValueExpress().trim()
                    + srcNodeVal.toString().trim();
            ParamVarMap paramVarMap = (ParamVarMap) cache.getByTenantId(key, message.getTenant().getTenantId() );
            Assert.notNull(
                    paramVarMap,
                    "check your configure,table NODE_VAL_ADAPTER_REQ.VALUE_EXPRESS and table VARIABLE_MAP,the key"
                            + key);
            val = paramVarMap.getVal();

        }
        else if (CONST_NODE_VAL_TYPE_SCRIPT.equals(valTypeCd))
        {
            ScriptExecutor scriptExecutor = scriptExecutorFactory
                    .getScriptExecutor("bsh");
            Assert.notNull(nodeValReq.getScript());
            Map<String, Object> variables = new HashMap<String, Object>();
            variables.put("srcNodeVal", srcNodeVal);
            variables.put("message", message);
            ScriptSource scriptSource = new StaticScriptSource(
                    nodeValReq.getScript());
            Object ret = scriptExecutor.executeScript(scriptSource, variables);
            val = ObjectUtils.nullSafeToString(ret);
        }
        else if (CONST_NODE_VAL_TYPE_OGNL.equals(valTypeCd))
        {
            Assert.notNull(
                    nodeValReq.getValueExpress(),
                    "Ognl expressions cannot be empty id"
                            + nodeValReq.getNodeValReqId());
            String express = nodeValReq.getValueExpress().trim();
            val = ognlParse(message, nodeValReq, srcNodeVal, val, express);
        }
        return val;
    }

    /**
     * 
     * getOtherNodeValExpress:(获取指定的任意节点值).  
     * TODO(这里描述这个方法适用条件 – 可选). 
     * TODO(这里描述这个方法的执行流程 – 可选). 
     * TODO(这里描述这个方法的使用方法 – 可选). 
     * TODO(这里描述这个方法的注意事项 – 可选). 
     * 
     * @author wuwz 
     * @param message
     * @param triggerExpress
     * @return 
     * @since JDK 1.6
     */
    public String getOtherNodeValExpress(MessageBO<?> message,
			String triggerExpress) {
    	
    	LOG.debug("triggerExpress:"+triggerExpress);
    	
    	if(!triggerExpress.contains("('")) {
    		
    		return triggerExpress;
    	}
    	 //表达式可以为ognl\xpath\jsonpath\ik表达式组合
        String[] expresses = triggerExpress.split("\\(\\'");
        
        String resultExp = "";
        for(String express : expresses) {

        	if(!org.apache.commons.lang.StringUtils.isEmpty(express) ) {
        		
        		if( express.contains("')")) {
        			
        			String[] subExpresses = express.split("\\'\\)");
        			
        			LOG.debug("express for contractBodyUtil:"+resultExp);
        			 
            		if(express.startsWith("//") || express.startsWith("/")
            				|| express.startsWith("$.")) {
            			
            			resultExp += ContractBodyUtil.getNodeValBySrcSource(message, subExpresses[0]);
            		} else {
            			
            			resultExp += ContractBodyUtil.getExprVal(message, subExpresses[0]);
            		}
            		
            		resultExp += subExpresses[1];
        		} else {
        			
        			resultExp += express;
        		}
        		
        	}
        }
        
        LOG.debug("final triggerExpress:"+resultExp);
        
        return resultExp;
	}

	protected Object ognlParse(MessageBO<?> message, NodeValReq nodeValReq,
            final Object srcNodeVal, Object val, String express)
    {
        if (express.contains("split"))
        {
            OgnlContext context = new OgnlContext();
            context.put("nodeValue", srcNodeVal);
            context.put("pattern", nodeValReq.getScript());
            val = ContractBodyUtil.getValueByContext(
                    nodeValReq.getNodeDescId(), express, context);
        }
        // else if (express.contains("merge")){}
        else if (express.contains("dateFormatter"))
        {
            OgnlContext context = new OgnlContext();
            context.put("date", srcNodeVal);
            context.put("formatter", nodeValReq.getScript());
            val = ContractBodyUtil.getValueByContext(
                    nodeValReq.getNodeDescId(), express, context);
        }
        else if (express.contains("substring"))
        {
            OgnlContext context = new OgnlContext();
            context.put("nodeValue", srcNodeVal);
            String[] splits = nodeValReq.getScript().split(",");
            if (2 == splits.length)
            {
                context.put("from", Integer.valueOf(splits[0]));
                context.put("to", Integer.valueOf(splits[1]));
                val = ContractBodyUtil.getValueByContext(
                        nodeValReq.getNodeDescId(), express, context);
            }
        }
        else if (express.contains("stringFormatter"))
        {
            OgnlContext context = new OgnlContext();
            context.put("date", srcNodeVal);
            val = ContractBodyUtil.getValueByContext(
                    nodeValReq.getNodeDescId(), express, context);
        }
        else if (express.contains("date2String"))
        {
            OgnlContext context = new OgnlContext();
            context.put("date", srcNodeVal);
            context.put("formatter", nodeValReq.getScript());
            val = ContractBodyUtil.getValueByContext(
                    nodeValReq.getNodeDescId(), express, context);
        }
        else if (express.contains("merge"))
        {
            return srcNodeVal;
        }
        else
        {
            val = ContractBodyUtil.getExprVal(message, nodeValReq
                    .getValueExpress().trim());
        }
        return val;
    }
}
