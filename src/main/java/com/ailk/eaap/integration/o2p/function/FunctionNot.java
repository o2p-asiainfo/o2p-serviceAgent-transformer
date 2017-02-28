package com.ailk.eaap.integration.o2p.function;


import com.asiainfo.foundation.exception.BusinessException;
import com.greenpineyu.fel.function.CommonFunction;

public class FunctionNot extends CommonFunction {


	@Override
	public String getName() {
		return "not";
	}

	@Override
	public Object call(Object[] args) {
		
		if (args != null && args.length == 1) {
			
			String param = args[0].toString();
			boolean paramBoolean = Boolean.parseBoolean(param);
			return !paramBoolean;
			
		} else {
			throw new BusinessException(9999, "not get error, param number error");
		}
	}
}