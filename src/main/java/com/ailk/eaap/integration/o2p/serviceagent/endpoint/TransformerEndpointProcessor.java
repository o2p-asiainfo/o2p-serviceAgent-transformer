package com.ailk.eaap.integration.o2p.serviceagent.endpoint;

import com.ailk.eaap.integration.o2p.transformer.service.TransformerRuleService;
import com.ailk.eaap.op2.common.EAAPException;
import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.ailk.eaap.op2.serviceagent.route.service.EndpointProcessor;
import com.asiainfo.foundation.exception.BusinessException;
import com.asiainfo.foundation.log.LogModel;
import com.asiainfo.foundation.log.Logger;
import com.ailk.eaap.op2.bo.Endpoint;
import com.ailk.eaap.op2.bo.EndpointAttr;

/**
 * 
 * @author 颖勤
 *
 */
public class TransformerEndpointProcessor implements EndpointProcessor{
	private static final Logger logger = Logger.getLog(TransformerEndpointProcessor.class);
	
	private TransformerRuleService transformerRuleService;
	
	public void setTransformerRuleService(
			TransformerRuleService transformerRuleService) {
		this.transformerRuleService = transformerRuleService;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public MessageBO process(Endpoint endpoint, MessageBO msg)
			throws EAAPException {
		Object obj = endpoint.getAttrMap().get(EndpointAttr.TRANSFORMER_RULE_ID);
		String exceptionMsg = "serviceAgent-transformer the endpoint id="+endpoint.getEndpointId()+",attribute spec TRANSFORMER_RULE_ID configure error";
		if(obj==null || "".equals(obj)){
			logger.error(LogModel.EVENT_BIZ_EXCPT, exceptionMsg);
			String[] msgArgs= {String.valueOf(endpoint.getEndpointId())};
			throw new BusinessException(9999,
					"o2p.serviceAgent.transformer.transformeRuleErrorMessage", msgArgs, null);
		}
		transformerRuleService.doTransform(msg, Integer.valueOf(obj.toString()));
		return msg;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void subtraThreadNum(String servId) throws EAAPException {
		// TODO Auto-generated method stub
		
	}

}
