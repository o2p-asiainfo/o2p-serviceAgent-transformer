package com.ailk.eaap.integration.o2p.function;

import com.ailk.eaap.o2p.common.cache.ICacheFactory;
import com.asiainfo.foundation.log.Logger;
import com.greenpineyu.fel.function.CommonFunction;

public class FunctionGetSequence extends CommonFunction {

	private static final Logger LOG = Logger.getLog(FunctionGetSequence.class);
	private ICacheFactory<String, Object> cacheFactory;
	private static final String SEQ = "TRANSFORMER_SEQUENCE";
	
	public FunctionGetSequence(ICacheFactory<String, Object> cacheFactory) {

		this.cacheFactory = cacheFactory;
	}

	@Override
	public String getName() {
		return "getSequence";
	}

	@Override
	public Object call(Object[] args) {
		
		if (args != null && args.length > 0) {
			
			if(LOG.isDebugEnabled()) {
				
				LOG.debug("=======getSequence======>args[0]:"+args[0].toString());
			}
			
			String key = SEQ+args[0].toString();
			int digit = 0;
			if(args[1] != null) {
				
				String digitStr = args[1].toString();
				try{
					
					digit = Integer.parseInt(digitStr);
				} catch(NumberFormatException e) {
					
					LOG.warn("getSequence digit NumberFormatException,",e);
				}
				
			}
			
			Object obj = cacheFactory.getCacheClient().get(key);
			
			Long seq = 0l;
			if(obj != null) {
				
				seq = Long.parseLong(obj.toString())+1l;
			} 
			cacheFactory.getCacheClient().put(key, seq);
			String seqStr = seq+"";
			
			StringBuffer sb = new StringBuffer();
			
			for(int i=0; i<digit - seqStr.length(); i++) {
				
				sb.append("0");
			}
			sb.append(seqStr);
			
			return sb.toString();
		} else {
			
			return 0;
		}
		
	}
}