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
public class FunctionLower  extends CommonFunction{

	@Override
	public String getName() {

		return "lower";
	}

	@Override
	public Object call(Object[] args) {
		
		if(args != null && args.length > 0) {
			
			return args[0].toString().toLowerCase();
		} else {
			
			throw new BusinessException(9999,
					"fn:lower function format error, "+args.toString());
		}
	}

}
