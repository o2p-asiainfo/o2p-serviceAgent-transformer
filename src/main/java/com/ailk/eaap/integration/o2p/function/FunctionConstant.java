package com.ailk.eaap.integration.o2p.function;


import com.asiainfo.foundation.log.Logger;
import com.greenpineyu.fel.function.CommonFunction;

public class FunctionConstant extends CommonFunction {

	private static final Logger LOG = Logger.getLog(FunctionConstant.class);

	@Override
	public String getName() {
		return "constant";
	}

	@Override
	public Object call(Object[] args) {
		
		if (args != null && args.length == 1 && args[0] != null) {
			
			return args[0].toString();
		}
			
		if(LOG.isDebugEnabled()) {
			
			LOG.debug(" function constant empty param,return \"\" ");
		}
		return "";
	}
}