package com.ailk.eaap.integration.o2p.transformer.service;

import org.springframework.util.Assert;

import com.ailk.eaap.integration.o2p.transformer.AbstractTransformer;
import com.ailk.eaap.integration.o2p.transformer.TransformerFactory;
import com.ailk.eaap.o2p.common.cache.ICache;
import com.ailk.eaap.o2p.common.cache.ICacheFactory;
import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.asiainfo.foundation.log.Logger;
import com.ailk.eaap.op2.bo.TransformerRule;

public class TransformerRuleServiceImpl implements TransformerRuleService{
	private  static final Logger LOG = Logger.getLog(TransformerRuleServiceImpl.class);
	private AbstractTransformer transformer;
	private TransformerFactory transformerFactory;
	private ICache<String, Object> cache;
	private ICacheFactory<String, Object> cacheFactory;
	
	
	
	public void setCacheFactory(ICacheFactory<String, Object> cacheFactory) {
		this.cacheFactory = cacheFactory;
	}


	public void setCache(ICache<String, Object> cache) {
		this.cache = cache;
	}

	
	public void setTransformerFactory(TransformerFactory transformerFactory) {
		this.transformerFactory = transformerFactory;
	}


	public AbstractTransformer getTransformer(Integer transformerType) {
		return (AbstractTransformer) transformerFactory.getTransformer(transformerType);
	}


	@Override
	public void save(TransformerRule obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MessageBO<?> doTransform(MessageBO<?> message,
			Integer transformerRuleId) {
		String key = "transformerRule"+transformerRuleId;
		TransformerRule transformerRule = (TransformerRule) cache.getByTenantId(key,message.getTenant().getTenantId());
			if(LOG.isDebugEnabled()) {
				LOG.debug("get transformerRule Object from cache,the key={0}", key);
			}
		Assert.notNull(transformerRule,"TransformerRule key="+key+",cannot find the instance");
		transformer = getTransformer(transformerRule.getTransformerType());
		transformer.setCacheFactory(cacheFactory);
		return transformer.transform(message,transformerRule);
	}

}
