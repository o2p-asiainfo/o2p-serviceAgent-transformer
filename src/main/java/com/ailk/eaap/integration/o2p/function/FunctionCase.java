/** 
 * Project Name:o2p-serviceAgent-transformer 
 * File Name:FunctionCase.java 
 * Package Name:com.ailk.eaap.integration.o2p.function 
 * Date:2016年2月5日上午10:48:05 
 * Copyright (c) 2016, www.asiainfo.com All Rights Reserved. 
 * 
*/  
  
package com.ailk.eaap.integration.o2p.function;  

import com.asiainfo.foundation.exception.BusinessException;
import com.greenpineyu.fel.FelEngine;
import com.greenpineyu.fel.common.FelBuilder;
import com.greenpineyu.fel.function.CommonFunction;

/** 
 * ClassName:FunctionCase  
 * Function: TODO ADD FUNCTION.  
 * Reason:   TODO ADD REASON.  
 * Date:     2016年2月5日 上午10:48:05  
 * @author   wuwz 
 * @version   
 * @since    JDK 1.6 
 *        
 */
public class FunctionCase  extends CommonFunction{

	@Override
	public String getName() {

		return "case";
	}

	@Override
	public Object call(Object[] args) {

		if(args != null && args.length >= 2) {
			
			if(args.length == 2) {
				
				Object obj = args[0];
				Boolean b = Boolean.parseBoolean(obj.toString());
				if(b) {
					
					return args[1];
				}
			} else {
				
				int lastIndex = args.length-1;
				
				for(int i=0; i<lastIndex; i++) {
					
					Object obj = args[i];
					
					if("true".equals(obj.toString())) {
						
						return "";
					}
				}
				
				return args[lastIndex];
			}
			
			return "";
		} else {
			
			throw new BusinessException(9999,
					"fn:case function format error, "+args.toString());
		}
	}

}
