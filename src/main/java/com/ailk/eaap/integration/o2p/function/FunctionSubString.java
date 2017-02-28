/** 
 * Project Name:o2p-serviceAgent-transformer 
 * File Name:FunctionSubString.java 
 * Package Name:com.ailk.eaap.integration.o2p.function 
 * Date:2016年2月4日下午5:42:35 
 * Copyright (c) 2016, www.asiainfo.com All Rights Reserved. 
 * 
*/  
  
package com.ailk.eaap.integration.o2p.function;  

import com.asiainfo.foundation.exception.BusinessException;
import com.greenpineyu.fel.function.CommonFunction;

/** 
 * ClassName:FunctionSubString  
 * Function: TODO ADD FUNCTION.  
 * Reason:   TODO ADD REASON.  
 * Date:     2016年2月4日 下午5:42:35  
 * @author   wuwz 
 * @version   
 * @since    JDK 1.6 
 *        
 */
public class FunctionSubString  extends CommonFunction{

	@Override
	public String getName() {

		return "substring";
	}

	@Override
	public Object call(Object[] arg) {
		
		if(arg != null && arg.length > 0) {
			
			String str = arg[0].toString();
			int begin = 0;
			int end = 0;
			if(arg.length == 3) {
				
				begin = Integer.parseInt(arg[1].toString());
				end = Integer.parseInt(arg[2].toString());
				if(end > str.length()) {
					
					end = str.length();
				}
				return str.substring(begin, end);
			} else if(arg.length == 2) {
				
				end = Integer.parseInt(arg[1].toString());
				return str.substring(end);
			} else {
				
				throw new BusinessException(9999,
						"fn:substring function format error, "+arg.toString());
			}
		} else {
			
			throw new BusinessException(9999,
					"fn:substring function format error, "+arg.toString());
		}
	}

}
