/** 
 * Project Name:o2p-serviceAgent-transformer 
 * File Name:FunctionConcat.java 
 * Package Name:com.ailk.eaap.integration.o2p.function.impl 
 * Date:2016年2月4日下午3:42:33 
 * Copyright (c) 2016, www.asiainfo.com All Rights Reserved. 
 * 
*/  
  
package com.ailk.eaap.integration.o2p.function;  

import com.asiainfo.foundation.exception.BusinessException;
import com.greenpineyu.fel.function.CommonFunction;

/** 
 * ClassName:FunctionConcat  
 * Function: TODO ADD FUNCTION.  
 * Reason:   TODO ADD REASON.  
 * Date:     2016年2月4日 下午3:42:33  
 * @author   wuwz 
 * @version   
 * @since    JDK 1.6 
 *        
 */
public class FunctionConcat extends CommonFunction{

	@Override
	public String getName() {
		
		return "concat";
	}

	@Override
	public Object call(Object[] args) {

		StringBuffer sb = new StringBuffer();
		if(args!= null && args.length > 0){
			for(Object arg : args) {
				
				sb.append(arg.toString());
			}
			
			return sb.toString();
		} else {
			
			throw new BusinessException(9999,
					"fn:concat function format error, "+args.toString());
		}
	}

}
