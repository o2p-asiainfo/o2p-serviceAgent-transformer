package com.ailk.eaap.integration.o2p.function;

import com.ailk.eaap.o2p.common.cache.ICacheFactory;
import com.asiainfo.foundation.exception.BusinessException;
import com.asiainfo.foundation.log.Logger;
import com.greenpineyu.fel.function.CommonFunction;

public class FunctionSetCache extends CommonFunction {

	private static final Logger LOG = Logger.getLog(FunctionSetCache.class);
	private ICacheFactory<String, Object> cacheFactory;

	public FunctionSetCache(ICacheFactory<String, Object> cacheFactory) {

		this.cacheFactory = cacheFactory;
	}

	@Override
	public String getName() {
		return "setCache";
	}

	@Override
	public Object call(Object[] args) {
		
		if (args != null && args.length == 2) {
			
			String key = args[0].toString();
			String value = args[1].toString();
			if("".equals(key.trim()) || "".equals(value.trim())) {
				
				throw new BusinessException(9001, "fn:setCache error,key or value can not be empty string !!!" );
			}
			String prekey = "TRANSFORMER_CACHE"+key;
			
			if(LOG.isDebugEnabled()) {
				
				LOG.debug("=======setCache======>key:"+prekey);
				LOG.debug("=======setCache======>value:"+value);
			}
			cacheFactory.getCacheClient().put(prekey, value);
			
			return value;
		} else {
			throw new BusinessException(9999, "fn:setCache get error,key： " + args.toString());
		}
	}
}