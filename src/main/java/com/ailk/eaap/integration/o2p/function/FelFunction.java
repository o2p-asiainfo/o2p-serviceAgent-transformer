/** 
 * Project Name:o2p-serviceAgent-transformer 
 * File Name:FelFunctionServiceImpl.java 
 * Package Name:com.ailk.eaap.integration.o2p.function.impl 
 * Date:2016年2月4日下午3:37:56 
 * Copyright (c) 2016, www.asiainfo.com All Rights Reserved. 
 * 
*/  
  
package com.ailk.eaap.integration.o2p.function;  

import com.ailk.eaap.o2p.common.cache.ICacheFactory;
import com.asiainfo.foundation.log.Logger;
import com.greenpineyu.fel.FelEngine;
import com.greenpineyu.fel.common.FelBuilder;
import com.greenpineyu.fel.context.FelContext;

/** 
 * ClassName:FelFunctionServiceImpl  
 * Function: TODO ADD FUNCTION.  
 * Reason:   TODO ADD REASON.  
 * Date:     2016年2月4日 下午3:37:56  
 * @author   wuwz 
 * @version   
 * @since    JDK 1.6 
 */
public class FelFunction {
	private static final Logger LOG = Logger.getLog(FelFunction.class);
	private static final String DOUBLE_QUOTATION = "url%e2%en80%9ccode";
	private ICacheFactory<String, Object> cacheFactory;
	FelEngine felEngine = FelBuilder.engine();
	public FelFunction(ICacheFactory<String, Object> cacheFactory) {

		this.cacheFactory = cacheFactory;
		getFelEngine();
	}


	public FelEngine getFelEngine() {
		
		if(LOG.isDebugEnabled()) {
			LOG.debug("====> fel add function start,current time:{0}", System.currentTimeMillis());
		}
		felEngine.addFun(new FunctionConcat());
		felEngine.addFun(new FunctionDateFormat());
		felEngine.addFun(new FunctionLower());
		felEngine.addFun(new FunctionMd5());
		felEngine.addFun(new FunctionSubString());
		felEngine.addFun(new FunctionSysdate());
		felEngine.addFun(new FunctionSplit());
		felEngine.addFun(new FunctionUpper());
		felEngine.addFun(new FunctionCase());
		felEngine.addFun(new FunctionDecode());
		felEngine.addFun(new FunctionCache(cacheFactory));
		felEngine.addFun(new FunctionGetCache(cacheFactory));
		felEngine.addFun(new FunctionSetCache(cacheFactory));
		felEngine.addFun(new FunctionLength());
		felEngine.addFun(new FunctionJWT());
		felEngine.addFun(new FunctionSubtract());
		felEngine.addFun(new FunctionIfElse());
		felEngine.addFun(new FunctionAnd());
		felEngine.addFun(new FunctionComparison());
		felEngine.addFun(new FunctionNot());
		felEngine.addFun(new FunctionOr());
		felEngine.addFun(new FunctionUrlDecode());
		felEngine.addFun(new FunctionUrlEncode());
		felEngine.addFun(new FunctionAdd());
		felEngine.addFun(new FunctionDivide());
		felEngine.addFun(new FunctionModulus());
		felEngine.addFun(new FunctionMultiply());
		felEngine.addFun(new FunctionConstant());
		felEngine.addFun(new FunctionNumberFormat());
		felEngine.addFun(new FunctionGetSequence(cacheFactory));
		felEngine.addFun(new FunctionBase64Encode());
		felEngine.addFun(new FunctionBase64Decode());
		felEngine.addFun(new FunctionArrayToString());
		
		if(LOG.isDebugEnabled()) {
			LOG.debug("====> fel add function end,current time:{0}", System.currentTimeMillis());
		}
		return felEngine;
	}
	
	public Object eval(String express) {
		
		if(LOG.isDebugEnabled()) {
			LOG.debug("====> fel function running start,current time:{0}", System.currentTimeMillis());
		}
		Object obj = felEngine.eval(express);
		String result = "";
		if(obj != null) {
			
			String str = obj.toString();
			result = str.replace(DOUBLE_QUOTATION, "\"");
		}
		if(LOG.isDebugEnabled()) {
			LOG.debug("====> fel function run end,current time:{0}", System.currentTimeMillis());
		}
		return result;
	}
	
	public FelContext getContext() {
		
		return felEngine.getContext();
	}
}
