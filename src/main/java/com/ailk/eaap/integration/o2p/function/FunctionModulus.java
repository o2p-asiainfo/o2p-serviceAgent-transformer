package com.ailk.eaap.integration.o2p.function;


import com.asiainfo.foundation.exception.BusinessException;
import com.asiainfo.foundation.log.Logger;
import com.greenpineyu.fel.function.CommonFunction;

public class FunctionModulus extends CommonFunction {

	private static final Logger LOG = Logger.getLog(FunctionModulus.class);
	private static final String STR = ".";
	
	@Override
	public String getName() {
		return "modulus";
	}

	@Override
	public Object call(Object[] args) {
		
		if (args != null && args.length == 2) {
			
			String param1 = args[0].toString();
			String param2 = args[1].toString();
			if(param1.contains(STR) || param2.contains(STR)) {
				
				return Double.parseDouble(param1)%Double.parseDouble(param2);
			} else {
				
				return Long.parseLong(param1)%Long.parseLong(param2);
			}
			
		} else {
			throw new BusinessException(9999, "divide get error, param number error");
		}
	}
}