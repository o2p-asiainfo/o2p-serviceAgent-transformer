package com.ailk.eaap.integration.o2p.function;

import com.ailk.eaap.o2p.common.cache.CacheKey;
import com.ailk.eaap.o2p.common.cache.ICacheFactory;
import com.asiainfo.foundation.exception.BusinessException;
import com.asiainfo.foundation.log.Logger;
import com.greenpineyu.fel.function.CommonFunction;

public class FunctionGetCache extends CommonFunction {

	private static final Logger LOG = Logger.getLog(FunctionGetCache.class);
	private ICacheFactory<String, Object> cacheFactory;

	public FunctionGetCache(ICacheFactory<String, Object> cacheFactory) {

		this.cacheFactory = cacheFactory;
	}

	@Override
	public String getName() {
		return "getCache";
	}

	@Override
	public Object call(Object[] args) {
		
		if (args != null && args.length == 1) {
			
			if(LOG.isDebugEnabled()) {
				
				LOG.debug("=======getCache======>args[0]:"+args[0].toString());
			}
			
			String key = args[0].toString();
			
			if("".equals(key.trim())) {
				
				throw new BusinessException(9999, "getCache error,key can not be empty string!!! " );
			}
			String finalKey = "";
			//缓存的前缀，老的接口使用的是functionCache函数，新配置接口使用functionGetCache函数
			if(key.startsWith(CacheKey.CacheStrategy)) {
				
				finalKey = key;
			} else {
				
				finalKey = "TRANSFORMER_CACHE"+key;
			}
			
			Object obj = cacheFactory.getCacheClient().get(finalKey);
			
			if(obj != null) {
				
				if(LOG.isDebugEnabled()) {
					
					LOG.debug("=============>getCache value:"+obj.toString());
				}
				
				return obj;
			} else {
				
				if(LOG.isDebugEnabled()) {
					
					LOG.debug("=============>getCache value is null!!!key="+finalKey);
				}
				
				return "";
			}
			
		} else {
			throw new BusinessException(9999, "fn:getCache get error,key： " + args.toString());
		}
	}
}