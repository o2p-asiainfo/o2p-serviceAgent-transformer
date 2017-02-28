package com.ailk.eaap.integration.o2p.transformer;

import com.ailk.eaap.o2p.common.cache.CacheKey;
import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.asiainfo.foundation.exception.BusinessException;
import com.asiainfo.foundation.log.Logger;
import com.ailk.eaap.op2.bo.Endpoint;
import com.ailk.eaap.op2.bo.EndpointAttr;
import com.ailk.eaap.op2.bo.TechImpl;
import com.ailk.eaap.op2.bo.TransformerRule;
import com.asiainfo.integretion.o2p.serviceagent.cache.IMemcacheManageServ;

public class Message2FileTransformer extends AbstractTransformer {
	
	private static final Logger logger = Logger.getLog(Message2FileTransformer.class);
	
	private IMemcacheManageServ cacheService;
	
    public void setCacheService(IMemcacheManageServ cacheService) {
		this.cacheService = cacheService;
	}

	@Override
    protected Object beforeTransform(MessageBO<?> message, TransformerRule transformerRule) throws Exception {
        return null;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
    protected Object doTransform(MessageBO message, TransformerRule transformerRule) throws Exception {
    	/*obtain techimpl object*/
    	Endpoint endpoint = message.getCurrryRouteEndpoint().getCurrentEndpoint();
		Object obj = endpoint.getAttrMap().get(EndpointAttr.ServiceTechId);
		TechImpl tech = null;
		if (obj == null) {
			throw new BusinessException(9066,"o2p-serviceagent-core.9066", new String[] { "EndpointAttr=" + EndpointAttr.ServiceTechId },null);
		} else {
			String serTechId = obj.toString();
			tech = (TechImpl) cacheService.getKey(CacheKey.techImpl+ serTechId, message.getTenant().getTenantId());
			if (logger.isDebugEnabled()) {
				logger.debug("serTechId=" + serTechId);
			}
			if (tech == null) {
				throw new BusinessException(9067, "o2p-serviceagent-core.9067", new String[] { "serTechId=" + serTechId }, null);
			}
		}
    	/*translate to ES data format*/
    	FileUtils.message2File(tech, message.getMsgBody(), "json");
    	message.setMsgBody("Device information synchronization complete!");
        return message;
    }

    @Override
    protected Object afterTransform(MessageBO<?> message, TransformerRule transformerRule) throws Exception {
        return null;
    }

}
