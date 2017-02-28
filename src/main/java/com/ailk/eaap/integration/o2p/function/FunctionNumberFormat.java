package com.ailk.eaap.integration.o2p.function;


import java.text.NumberFormat;

import com.asiainfo.foundation.exception.BusinessException;
import com.asiainfo.foundation.log.Logger;
import com.greenpineyu.fel.function.CommonFunction;

public class FunctionNumberFormat extends CommonFunction {

	@Override
	public String getName() {
		return "numberFormat";
	}

	@Override
	public Object call(Object[] args) {
		
		if (args != null && args.length == 2) {
			
			String p1 = args[0].toString();
			String p2 = args[1].toString();
			
			NumberFormat nf =NumberFormat.getNumberInstance(); 
			nf.setMaximumFractionDigits(Integer.parseInt(p2)); 
			
			return nf.format(Double.parseDouble(p1.toString())); 
		} else {
			throw new BusinessException(9999, "numberFormat get error, param number error");
		}
	}
}