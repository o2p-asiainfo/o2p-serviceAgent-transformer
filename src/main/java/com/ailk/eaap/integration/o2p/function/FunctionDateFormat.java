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
public class FunctionDateFormat extends CommonFunction{
	
	private static final Logger LOG = Logger.getLog(FunctionDateFormat.class);
	private static final String XML = "yyyy-MM-dd'T'HH:mm:ss.SXXX";
	
	@Override
	public String getName() {
		
		return "dateFormat";
	}

	@Override
	public Object call(Object[] args) {

		if(args!= null && args.length == 3){

			String dateStr = args[0].toString();
			String srcDateFormat = args[1].toString();
			String tarDateFormat = args[2].toString();
			
			try {
				
				Date date = null;
				if("xml".equals(srcDateFormat.toLowerCase()) || XML.equals(srcDateFormat)) {
					
					 Calendar c = DatatypeConverter.parseDateTime(dateStr);
					 date = c.getTime();
				} else {
					
					SimpleDateFormat src = new SimpleDateFormat(srcDateFormat);
					date = src.parse(dateStr);
				}
				
				if("xml".equals(tarDateFormat.toLowerCase())) {
					
					Calendar c = Calendar.getInstance();
				    c.setTime(date);
				    return DatatypeConverter.printDateTime(c);
				} else {
					
					SimpleDateFormat tar = new SimpleDateFormat(tarDateFormat);
					return tar.format(date);
				}
				
			} catch (ParseException e) {
				
				LOG.error("dateFormat function parse date error:", e);
				throw new BusinessException(9999,
						"fn:dateFormat function dateFormat function parse date error, "+args.toString(),e);
			}
			
		} else {
			
			throw new BusinessException(9999,
					"fn:dateFormat function format error, "+args.toString());
		}
	}

}
