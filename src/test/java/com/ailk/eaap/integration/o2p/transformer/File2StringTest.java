/** 
 * Project Name:o2p-serviceAgent-transformer 
 * File Name:File2StringTest.java 
 * Package Name:com.ailk.eaap.integration.o2p.transformer 
 * Date:2015年1月8日下午4:19:38 
 * Copyright (c) 2015, www.asiainfo.com All Rights Reserved. 
 * 
*/  
  
package com.ailk.eaap.integration.o2p.transformer;  

import java.io.File;

import com.ailk.eaap.op2.serviceagent.common.MessageBO;

/** 
 * ClassName:File2StringTest  
 * Function: TODO ADD FUNCTION.  
 * Reason:   TODO ADD REASON.  
 * Date:     2015年1月8日 下午4:19:38  
 * @author   wuwz 
 * @version   
 * @since    JDK 1.6 
 *        
 */
public class File2StringTest {

	public static void main(String[] args) throws Exception {
		File2StringTransformer ft = new File2StringTransformer();
		File f = new File("d:/users.txt");
		MessageBO mo = new MessageBO();
		mo.setMsgBody(f);
		System.out.println(ft.doTransform(mo, null));

	}

}
