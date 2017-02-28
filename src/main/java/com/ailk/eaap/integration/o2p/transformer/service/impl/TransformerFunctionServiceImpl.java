/** 
 * Project Name:o2p-serviceAgent-transformer 
 * File Name:TransformerServiceImpl.java 
 * Package Name:com.ailk.eaap.integration.o2p.transformer.service.impl 
 * Date:2016年1月14日上午11:29:14 
 * Copyright (c) 2016, www.asiainfo.com All Rights Reserved. 
 * 
*/  
  
package com.ailk.eaap.integration.o2p.transformer.service.impl;  


import com.ailk.eaap.integration.o2p.transformer.service.ITransformerFunctionService;

/** 
 * ClassName:TransformerServiceImpl  
 * Function: TODO ADD FUNCTION.  
 * Reason:   TODO ADD REASON.  
 * Date:     2016年1月14日 上午11:29:14  
 * @author   wuwz 
 * @version   
 * @since    JDK 1.6 
 *        
 */
public class TransformerFunctionServiceImpl implements ITransformerFunctionService {

	/**
	 * 
	 * funcDeal:(函数格式转换 fn:concat($v1, $v2) 转为 $concat(v1, v2)).  
	 * TODO(这里描述这个方法适用条件 – 可选). 
	 * TODO(这里描述这个方法的执行流程 – 可选). 
	 * TODO(这里描述这个方法的使用方法 – 可选). 
	 * TODO(这里描述这个方法的注意事项 – 可选). 
	 * 
	 * @author wuwz 
	 * @param express
	 * @return 
	 * @since JDK 1.6
	 */
	public String funcDeal(String express) {

		express = express.replace("$", "");
		express = express.replace("fn:", "$");
		
		//处理参数长度可变的函数
		express = check(express);
		
		return express;
	}

	private String check(String express) {

		String contact = "$concat";
		
		if(express.startsWith(contact)) {
			
			int begin = express.indexOf("$concat(");
			int end = express.lastIndexOf(")");
			String param = express.substring(begin+8, end);
			String[] strs = param.split(",");
			
			if(strs.length < 10) {
				
				StringBuffer sb = new StringBuffer();
				for(int i=0; i<10-strs.length; i++) {
					
					sb.append(",\"\"");
				}
				
				express = "$concat("+param+sb.toString()+")";
			}
		}
		
		return express;
	}

	
}
