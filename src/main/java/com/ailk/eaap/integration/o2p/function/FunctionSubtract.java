/** 
 * Project Name:o2p-serviceAgent-transformer 
 * File Name:FunctionConcat.java 
 * Package Name:com.ailk.eaap.integration.o2p.function.impl 
 * Date:2016年2月4日下午3:42:33 
 * Copyright (c) 2016, www.asiainfo.com All Rights Reserved. 
 * 
*/  
  
package com.ailk.eaap.integration.o2p.function;  

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.xml.bind.DatatypeConverter;

import com.ailk.eaap.integration.o2p.transformer.service.impl.NodeReqParseServiceImpl;
import com.asiainfo.foundation.exception.BusinessException;
import com.asiainfo.foundation.log.Logger;
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
public class FunctionSubtract extends CommonFunction{
	
	private static final Logger LOG = Logger.getLog(FunctionSubtract.class);
	private static final String STR = ".";
	
	@Override
	public String getName() {
		
		return "subtract";
	}

	@Override
	public Object call(Object[] args) {

		if(args!= null && args.length >1){

			String valueStr1 = args[0].toString();
			long result = 0;
			double resultD = 0;
			if(valueStr1.contains(STR)) {
				
				resultD = Double.parseDouble(valueStr1);
			} else {
				
				result = Long.parseLong(valueStr1);
			}
			
			for(int i=1; i<args.length; i++) {
				
				String param = args[i].toString();
				
				if(LOG.isDebugEnabled()) {
					
					LOG.debug(" function add param is: {0}", param);
				}
				if(param.contains(STR)) {
					
					resultD -= Double.parseDouble(param);
				} else {
					
					result -= Long.parseLong(param);
				}
			}
			
			if(resultD > 0 || resultD < 0) {
				
				return result+resultD;
			} else {
				
				return result;
			}
		} else {
			
			throw new BusinessException(9999,
					"fn:subtract function format error, "+args.toString());
		}
	}

}
