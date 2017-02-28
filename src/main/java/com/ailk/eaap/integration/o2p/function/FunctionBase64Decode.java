package com.ailk.eaap.integration.o2p.function;


import io.jsonwebtoken.impl.TextCodec;


import com.asiainfo.foundation.exception.BusinessException;
import com.asiainfo.foundation.log.Logger;
import com.greenpineyu.fel.function.CommonFunction;

public class FunctionBase64Decode extends CommonFunction {

	private static final Logger LOG = Logger.getLog(FunctionBase64Decode.class);
	
	@Override
	public String getName() {
		return "base64Encode";
	}

	@Override
	public Object call(Object[] args) {
		
		if (args != null && args.length == 1) {
			
			String data = args[0].toString();
			if(LOG.isDebugEnabled()) {
				
				LOG.debug("===> befare base64Encode String is:{0}", data.toString());
			}
			return TextCodec.BASE64.encode(data);
		} else {
			throw new BusinessException(9999, "base64Encode  error, param number error");
		}
	}
}