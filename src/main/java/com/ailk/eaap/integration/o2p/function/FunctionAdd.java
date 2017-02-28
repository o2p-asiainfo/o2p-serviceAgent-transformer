package com.ailk.eaap.integration.o2p.function;


import org.apache.commons.lang.StringUtils;

import com.asiainfo.foundation.exception.BusinessException;
import com.asiainfo.foundation.log.Logger;
import com.greenpineyu.fel.function.CommonFunction;

public class FunctionAdd extends CommonFunction {

	private static final Logger LOG = Logger.getLog(FunctionAdd.class);
	private static final String STR = ".";
	
	@Override
	public String getName() {
		return "add";
	}

	@Override
	public Object call(Object[] args) {
		
		if (args != null && args.length > 1) {
			
			long result = 0;
			double resultD = 0;
			for(Object obj : args) {
				
				String param = obj.toString();
				
				if(LOG.isDebugEnabled()) {
					
					LOG.debug(" function add param is: {0}", param);
				}
				
				if(StringUtils.isEmpty(param)) {
					
					param = "0";
					if(LOG.isDebugEnabled()) {
						
						LOG.debug(" function add empty param change to: {0}", param);
					}
				}
				if(param.contains(STR)) {
					
					resultD += Double.parseDouble(param);
				} else {
					
					result += Long.parseLong(param);
				}
			}
			
			if(resultD > 0 || resultD < 0) {
				
				return resultD+result;
			} else {
				
				return result;
			}
			
			
		} else {
			throw new BusinessException(9999, "add get error, param number error");
		}
	}
}