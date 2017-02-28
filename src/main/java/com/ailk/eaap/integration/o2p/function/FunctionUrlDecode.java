package com.ailk.eaap.integration.o2p.function;

import java.io.UnsupportedEncodingException;

import com.asiainfo.foundation.exception.BusinessException;
import com.asiainfo.foundation.log.Logger;
import com.greenpineyu.fel.function.CommonFunction;

public class FunctionUrlDecode extends CommonFunction {

	private static final Logger LOG = Logger.getLog(FunctionUrlDecode.class);


	@Override
	public String getName() {
		return "urldecode";
	}

	@Override
	public Object call(Object[] args) {
		
		if (args != null && args.length == 2) {
			
			String str = args[0].toString();
			String cType = args[1].toString();
			
			try {
				
				return java.net.URLDecoder.decode(str, cType.toLowerCase());
			} catch (UnsupportedEncodingException e) {
				
				LOG.error("==> urldecode error", e);
				throw new BusinessException(9999, e);
			}     
			
		} else {
			
			throw new BusinessException(9999, "urldecode get error, param number error");
		}
	}
}