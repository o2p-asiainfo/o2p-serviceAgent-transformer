package com.ailk.eaap.integration.o2p.function;


import org.apache.commons.lang.StringUtils;

import com.asiainfo.foundation.exception.BusinessException;
import com.asiainfo.foundation.log.Logger;
import com.greenpineyu.fel.function.CommonFunction;

public class FunctionMultiply extends CommonFunction {

	private static final String STR = ".";
	private static final Logger LOG = Logger.getLog(FunctionMultiply.class);
	
	@Override
	public String getName() {
		return "multiply";
	}

	@Override
	public Object call(Object[] args) {
		
		if (args != null && args.length > 1) {
			
			String p1 = args[0].toString();
			String p2 = args[1].toString();
			
			if(StringUtils.isEmpty(p1)) {
				
				p1 = "1";
				if(LOG.isDebugEnabled()) {
					
					LOG.debug(" function multiply empty param p1 change to: {0}", p1);
				}
			}
			if(StringUtils.isEmpty(p2)) {
				
				p2 = "1";
				if(LOG.isDebugEnabled()) {
					
					LOG.debug(" function multiply empty param p2 change to: {0}", p2);
				}
			}
			if(p1.contains(STR) || p2.contains(STR)) {
				
				return Double.parseDouble(p1)*Double.parseDouble(p2);
			} else {
				
				return Long.parseLong(p1)*Long.parseLong(p2);
			}
			
		} else {
			throw new BusinessException(9999, "multiply get error, param number error");
		}
	}
}