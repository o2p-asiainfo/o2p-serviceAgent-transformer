package com.ailk.eaap.integration.o2p.function;

import com.ailk.eaap.o2p.common.cache.ICacheFactory;
import com.asiainfo.foundation.exception.BusinessException;
import com.asiainfo.foundation.log.Logger;
import com.greenpineyu.fel.function.CommonFunction;

public class FunctionCache extends CommonFunction {

	private static final Logger LOG = Logger.getLog(FunctionCache.class);
	private ICacheFactory<String, Object> cacheFactory;

	public FunctionCache(ICacheFactory<String, Object> cacheFactory) {

		this.cacheFactory = cacheFactory;
	}

	@Override
	public String getName() {
		return "cache";
	}

	@Override
	public Object call(Object[] args) {
		
		if(LOG.isDebugEnabled() && cacheFactory != null) {
			
			LOG.debug("=============>cache:"+cacheFactory.toString());
		}
		
		if (args != null && args.length == 1) {
			
			if(LOG.isDebugEnabled()) {
				
				LOG.debug("=============>args:"+args.toString());
				LOG.debug("=============>args[0]:"+args[0]);
			}
			
			String key = args[0].toString();
			Object o = cacheFactory.getCacheClient().get(key);
			
			if(o != null) {
				
				if(LOG.isDebugEnabled()) {
					
					LOG.debug("=============>cache value:"+o.toString());
				}
				
				return o;
			} else {
				
				if(LOG.isDebugEnabled()) {
					
					LOG.debug("=============>cache value is null!!!");
				}
				
				return "";
			}
			
		} else {
			throw new BusinessException(9999, "fn:cache get error,key： " + args.toString());
		}
	}
}