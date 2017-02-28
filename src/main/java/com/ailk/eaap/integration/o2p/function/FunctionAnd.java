package com.ailk.eaap.integration.o2p.function;


import com.asiainfo.foundation.exception.BusinessException;
import com.asiainfo.foundation.log.Logger;
import com.greenpineyu.fel.function.CommonFunction;

public class FunctionAnd extends CommonFunction {

	private static final Logger LOG = Logger.getLog(FunctionAnd.class);

	@Override
	public String getName() {
		return "and";
	}

	@Override
	public Object call(Object[] args) {
		
		if (args != null && args.length > 1) {
			
			boolean result = true;
			for(Object obj : args) {
				
				String param = obj.toString();
				
				if(LOG.isDebugEnabled()) {
					
					LOG.debug(" function and param is: {0}", param);
				}
				result = result && Boolean.parseBoolean(param);
			}
			
			return result;
			
		} else {
			throw new BusinessException(9999, "and get error, param number error");
		}
	}
}