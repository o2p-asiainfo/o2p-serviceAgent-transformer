package com.ailk.eaap.integration.o2p.function;


import com.asiainfo.foundation.exception.BusinessException;
import com.asiainfo.foundation.log.Logger;
import com.greenpineyu.fel.function.CommonFunction;

public class FunctionComparison extends CommonFunction {

	private static final Logger LOG = Logger.getLog(FunctionComparison.class);
	private static final String EQUALS="=";
	private static final String NOT_EQUALS="!=";
	private static final String GREATER=">";
	private static final String LESS="<";
	private static final String GREATER_EQUALS=">=";
	private static final String LESS_EQUALS="<=";
	

	@Override
	public String getName() {
		return "comparison";
	}

	@Override
	public Object call(Object[] args) {
		
		if (args != null && args.length == 3) {
			
			String value1 = args[0].toString();
			String compareStr = args[1].toString();
			String value2 = args[2].toString();
			
			if(LOG.isDebugEnabled()) {
				
				LOG.debug("comparison param1="+value1+", param2="+compareStr+", param3="+value2);
			}
			
			if(EQUALS.equals(compareStr)) {
				
				return value1.equals(value2);
			} else if(NOT_EQUALS.equals(compareStr)) {
				
				return !value1.equals(value2);
			} else  {
				
				try {
					
					Double valueD1 = Double.parseDouble(value1);
					Double valueD2 = Double.parseDouble(value2);
					
					if(GREATER.equals(compareStr)) {
						
						return valueD1 - valueD2 > 0;
					} else if(LESS.equals(compareStr)) {
						
						return valueD1 - valueD2 < 0;
					} else if(GREATER_EQUALS.equals(compareStr)) {
						
						return valueD1 - valueD2 >= 0;
					} else if(LESS_EQUALS.equals(compareStr)) {
						
						return valueD1 - valueD2 <= 0;
					}
				} catch(NumberFormatException e) {
					
					throw new BusinessException(9999, "comparison error, the parameter must be number format. param1:'"+value1+"', param2:'"+compareStr+"', param2:'"+value2+"'", e);
				}
				
			}
			
			throw new BusinessException(9999, "comparison error, the parameter must be number format. param1:'"+value1+"', param2:'"+compareStr+"', param2:'"+value2+"'");
		} else {
			throw new BusinessException(9999, "comparison get error, param number error");
		}
	}
}