/** 
 * Project Name:o2p-serviceAgent-transformer 
 * File Name:MyString.java 
 * Package Name:com.ailk.eaap.integration.o2p.transformer.function 
 * Date:2015年12月28日下午3:17:17 
 * Copyright (c) 2015, www.asiainfo.com All Rights Reserved. 
 * 
*/  
  
package com.ailk.eaap.integration.o2p.transformer.function;  

import java.util.List;

import org.wltea.expression.datameta.Variable;

/** 
 * ClassName:MyString  
 * Function: TODO ADD FUNCTION.  
 * Reason:   TODO ADD REASON.  
 * Date:     2015年12月28日 下午3:17:17  
 * @author   wuwz 
 * @version   
 * @since    JDK 1.6 
 *        
 */
public class MyString {

	public String subString(String str, int start, int end) {
		
		return str.substring(start, end);
	}
	
	
	public static void main(String args[]) {
		
	}

	public String concat(String str1,String str2,String str3,
			String str4,String str5,String str6,String str7,
			String str8,String str9,String str10) {
		
		return str1+str2+str3+str4+str5+str6+str7+str8+str9+str10;
	}
}
