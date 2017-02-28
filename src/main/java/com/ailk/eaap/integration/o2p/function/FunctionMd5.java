/** 
 * Project Name:o2p-serviceAgent-transformer 
 * File Name:FunctionConcat.java 
 * Package Name:com.ailk.eaap.integration.o2p.function.impl 
 * Date:2016年2月4日下午3:42:33 
 * Copyright (c) 2016, www.asiainfo.com All Rights Reserved. 
 * 
*/  
  
package com.ailk.eaap.integration.o2p.function;  

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
public class FunctionMd5 extends CommonFunction{

	private static final Logger LOG = Logger.getLog(FunctionMd5.class);
	
	@Override
	public String getName() {
		
		return "md5";
	}

	@Override
	public Object call(Object[] args) {

		if(args!= null && args.length > 0){
			
			StringBuffer input = new StringBuffer("");
			for(Object obj : args) {
				
				if(obj != null) {
					
					input.append(obj.toString());
				}
			}
			StringBuffer result = new StringBuffer("");
			MessageDigest md = null;
			try {
				md = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException e) {

				LOG.error("md5 change fail,", e);
			}
			md.update(input.toString().getBytes());
			byte b[] = md.digest();
			int i = 0;
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					result.append("0");
				result.append(Integer.toHexString(i));
			}
			return result.toString();
		} else {
			
			throw new BusinessException(9999,
					"fn:md5 function format error, "+args.toString());
		}
	}

}
