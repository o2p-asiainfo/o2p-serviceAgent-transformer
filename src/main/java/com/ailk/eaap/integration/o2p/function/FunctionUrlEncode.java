package com.ailk.eaap.integration.o2p.function;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.asiainfo.foundation.exception.BusinessException;
import com.asiainfo.foundation.log.Logger;
import com.greenpineyu.fel.function.CommonFunction;

public class FunctionUrlEncode extends CommonFunction {

	private static final Logger LOG = Logger.getLog(FunctionUrlEncode.class);


	@Override
	public String getName() {
		return "urlencode";
	}

	@Override
	public Object call(Object[] args) {
		
		if (args != null && args.length == 2) {
			
			String str = args[0].toString();
			String cType = args[1].toString();
			
			try {
				
				String result = URLEncoder.encode(str, cType.toLowerCase());
				return result;
			} catch (UnsupportedEncodingException e) {
				
				LOG.error("==> urlencode error", e);
				throw new BusinessException(9999, e);
			}     
			
		} else {
			throw new BusinessException(9999, "urlencode get error, param number error");
		}
	}
}