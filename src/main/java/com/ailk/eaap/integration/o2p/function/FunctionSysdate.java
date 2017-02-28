/** 
 * Project Name:o2p-serviceAgent-transformer 
 * File Name:FunctionConcat.java 
 * Package Name:com.ailk.eaap.integration.o2p.function.impl 
 * Date:2016年2月4日下午3:42:33 
 * Copyright (c) 2016, www.asiainfo.com All Rights Reserved. 
 * 
*/  
  
package com.ailk.eaap.integration.o2p.function;  

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.xml.bind.DatatypeConverter;

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
public class FunctionSysdate extends CommonFunction{

	@Override
	public String getName() {
		
		return "sysdate";
	}

	@Override
	public Object call(Object[] args) {

		if(args!= null && args.length == 1){
			
			Date date = new Date();
			String dateFormat = args[0].toString();
			if("xml".equals(dateFormat.toLowerCase())) {
				
			    Calendar c = Calendar.getInstance();
			    c.setTime(date);
			    return  DatatypeConverter.printDateTime(c);
			} else {
				
				SimpleDateFormat format = new SimpleDateFormat(dateFormat);
				return format.format(date);
			}
			
		} else {
			throw new BusinessException(9999,
					"fn:sysdate function format error, "+args.toString());
		}
	}

}
