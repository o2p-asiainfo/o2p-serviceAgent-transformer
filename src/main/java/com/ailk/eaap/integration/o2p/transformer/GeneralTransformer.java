/** 
 * Project Name:o2p-serviceAgent-transformer 
 * File Name:GeneralTransformer.java 
 * Package Name:com.ailk.eaap.integration.o2p.transformer 
 * Date:2016年1月7日下午2:21:37 
 * Copyright (c) 2016, www.asiainfo.com All Rights Reserved. 
 * 
*/  
  
package com.ailk.eaap.integration.o2p.transformer;  



import com.ailk.eaap.integration.o2p.message.support.MessageMapperService;
import com.ailk.eaap.integration.o2p.transformer.service.IHttpMsgStyleUrlTransformerService;
import com.ailk.eaap.integration.o2p.transformer.service.IjsonTransformerService;
import com.ailk.eaap.integration.o2p.transformer.service.IxmlTransformerService;
import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.asiainfo.foundation.exception.BusinessException;
import com.asiainfo.foundation.log.Logger;
import com.ailk.eaap.op2.bo.ContractFormatEx;
import com.ailk.eaap.op2.bo.TransformerRule;

/** 
 * ClassName:GeneralTransformer  
 * Function: TODO ADD FUNCTION.  
 * Reason:   TODO ADD REASON.  
 * Date:     2016年1月7日 下午2:21:37  
 * @author   wuwz 
 * @version   
 * @since    JDK 1.6 
 *        
 */
public class GeneralTransformer  extends AbstractTransformer{

	private static final Logger LOG = Logger.getLog(GeneralTransformer.class);
	private IxmlTransformerService xmlTransformerService;
	private IjsonTransformerService jsonTransformerService;
	private IHttpMsgStyleUrlTransformerService httpMsgStyleUrlTransformerService;
	
	@Override
	protected Object beforeTransform(MessageBO<?> message,
			TransformerRule transformerRule) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void setXmlTransformerService(
			IxmlTransformerService xmlTransformerService) {
		this.xmlTransformerService = xmlTransformerService;
	}

	public void setJsonTransformerService(
			IjsonTransformerService jsonTransformerService) {
		this.jsonTransformerService = jsonTransformerService;
	}

	public void setHttpMsgStyleUrlTransformerService(
			IHttpMsgStyleUrlTransformerService httpMsgStyleUrlTransformerService) {
		this.httpMsgStyleUrlTransformerService = httpMsgStyleUrlTransformerService;
	}

	@Override
	protected Object doTransform(MessageBO<?> message,
			TransformerRule transformerRule) throws Exception {
		ContractFormatEx contractFormatEx = transformerRule.getTarContractFormatEx();
		String conType = contractFormatEx.getConType();
		
		MessageBO<?> tarMessageBo = null;
		if(MessageMapperService.CONST_MSG_CON_TYPE_XML.equals(conType)) {
			//target xml
			tarMessageBo = xmlTransformerService.xmlDoTransform(message, transformerRule);
		} else if(MessageMapperService.CONST_MSG_CON_TYPE_JSON.equals(conType)) {
			//target json
			tarMessageBo = jsonTransformerService.jsonDoTransform(message, transformerRule);
		} else if(MessageMapperService.CONST_MSG_CON_TYPE_HTTPMSG_STYLE_URL.equals(conType)) {
			//target urlBody
			tarMessageBo = httpMsgStyleUrlTransformerService.msgUrlDoTransform(message, transformerRule);
		}
		
		if(tarMessageBo == null) {
			
			throw new BusinessException(9100, "The target contract format content type is:"+conType+", not support GeneralTransformer now,only support xml,json,bodyGet.");
		}

		if(LOG.isDebugEnabled()) {
			
			LOG.debug("=====> transformer url param:"+tarMessageBo.getMessageMap().toString());
			LOG.debug("=====> transformer head param:"+tarMessageBo.getMsgHead().toString());
		}
		return tarMessageBo;
	}

	

	@Override
	protected Object afterTransform(MessageBO<?> message,
			TransformerRule transformerRule) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
