/** 
 * Project Name:o2p-serviceAgent-transformer 
 * File Name:IHttpMsgStyleUrlTransformerService.java 
 * Package Name:com.ailk.eaap.integration.o2p.transformer.service 
 * Date:2016年1月29日上午11:05:29 
 * Copyright (c) 2016, www.asiainfo.com All Rights Reserved. 
 * 
*/  
  
package com.ailk.eaap.integration.o2p.transformer.service;  

import org.dom4j.DocumentException;

import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.ailk.eaap.op2.bo.TransformerRule;

/** 
 * ClassName:IHttpMsgStyleUrlTransformerService  
 * Function: TODO ADD FUNCTION.  
 * Reason:   TODO ADD REASON.  
 * Date:     2016年1月29日 上午11:05:29  
 * @author   wuwz 
 * @version   
 * @since    JDK 1.6 
 *        
 */
public interface IHttpMsgStyleUrlTransformerService {

	MessageBO<?> msgUrlDoTransform(MessageBO<?> message, TransformerRule transformerRule) throws DocumentException;

}
