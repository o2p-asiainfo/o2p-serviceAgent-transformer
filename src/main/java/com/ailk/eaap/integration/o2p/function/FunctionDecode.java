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
public class FunctionDecode  extends CommonFunction{

	@Override
	public String getName() {

		return "decode";
	}

	@Override
	public Object call(Object[] args) {

		if(args != null && args.length >= 4 && args.length%2 == 0) {
			
			Object value = args[0];
			
			int lastIndex = args.length-1;
			
			int index = 1;
			while(index < lastIndex) {
				
				Object obj = args[index];
				if(obj.toString().equals(value.toString())) {
					
					return args[index+1];
				}
				index += 2;
			}
			
			return args[lastIndex];
			
		} else {
			
			throw new BusinessException(9999,
					"fn:decode function format error, "+args.toString());
		}
	}

}
