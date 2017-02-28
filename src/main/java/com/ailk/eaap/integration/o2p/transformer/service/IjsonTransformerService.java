/** 
 * Project Name:o2p-serviceAgent-transformer 
 * File Name:IxmlTransformerService.java 
 * Package Name:com.ailk.eaap.integration.o2p.transformer.service 
 * Date:2016年1月8日上午11:03:34 
 * Copyright (c) 2016, www.asiainfo.com All Rights Reserved. 
 * 
*/  
  
package com.ailk.eaap.integration.o2p.transformer.service;  

import org.dom4j.DocumentException;

import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.ailk.eaap.op2.bo.TransformerRule;

/** 
 * ClassName:IxmlTransformerService  
 * Function: TODO ADD FUNCTION.  
 * Reason:   TODO ADD REASON.  
 * Date:     2016年1月8日 上午11:03:34  
 * @author   wuwz 
 * @version   
 * @since    JDK 1.6 
 *        
 */
public interface IjsonTransformerService {

	MessageBO<?> jsonDoTransform(MessageBO<?> message, TransformerRule transformerRule) throws DocumentException;
}
