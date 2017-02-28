package com.ailk.eaap.integration.o2p.function;


import com.asiainfo.foundation.exception.BusinessException;
import com.asiainfo.foundation.log.Logger;
import com.greenpineyu.fel.function.CommonFunction;

public class FunctionOr extends CommonFunction {

	private static final Logger LOG = Logger.getLog(FunctionOr.class);

	@Override
	public String getName() {
		return "or";
	}

	@Override
	public Object call(Object[] args) {
		
		if (args != null && args.length > 1) {
			
			boolean result = false;
			for(Object obj : args) {
				
				String param = obj.toString();
				
				if(LOG.isDebugEnabled()) {
					
					LOG.debug(" function and param is: {0}", param);
				}
				result = result || Boolean.parseBoolean(param);
			}
			
			return result;
			
		} else {
			throw new BusinessException(9999, "or get error, param number error");
		}
	}
}