package com.ailk.eaap.integration.o2p.transformer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Document;

import com.ailk.eaap.integration.o2p.transformer.common.CommonXqUtils;
import com.ailk.eaap.integration.o2p.transformer.common.XQueryHelper;
import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.asiainfo.foundation.exception.BusinessException;
import com.ailk.eaap.op2.bo.TransformerRule;

/**
 * Created by david on 14-7-23.
 */
public class XQueryTransformer extends AbstractTransformer {
	@Override
	protected Object beforeTransform(MessageBO<?> message,
			TransformerRule transformerRule) throws Exception {
		return null;
	}

	@Override
	protected Object doTransform(MessageBO<?> message,
			TransformerRule transformerRule) throws Exception {
		XQueryHelper xQueryHelper = null;
		Object msgBody = message.getMsgBody();
			xQueryHelper = new XQueryHelper();
			initXQuery(xQueryHelper, transformerRule);
				if (msgBody instanceof Document) {
					xQueryHelper.setDocument(CommonXqUtils
							.getW3cDocumentByDom4j((Document) msgBody));
				} else if (msgBody instanceof org.w3c.dom.Document) {
					xQueryHelper.setDocument((org.w3c.dom.Document) msgBody);
				} else {
					String[] msgArgs = { message.getTransactionID() };
					throw new BusinessException(9142,
							"o2p.serviceAgent.transformer.xqueryTransformer",
							msgArgs, null);
				}
			xQueryHelper.init();
		Object obj = getReturnMsgBo(xQueryHelper.xQueryExecuteByMethod(
				xQueryHelper, transformerRule), xQueryHelper);
		return obj;
	}

	@Override
	protected Object afterTransform(MessageBO<?> message,
			TransformerRule transformerRule) throws Exception {
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private MessageBO getReturnMsgBo(Object obj, XQueryHelper xQueryHelper) {
		MessageBO retMsg = null;
		if (obj == null) {
			retMsg = new MessageBO<XQueryHelper>();
			retMsg.setMsgBody(xQueryHelper);
		} else if (obj instanceof String) {
			retMsg = new MessageBO<String>();
			retMsg.setMsgBody(obj);
		} else {
			retMsg = new MessageBO<Document>();
			retMsg.setMsgBody(CommonXqUtils.getDom4jDocumentByW3c(CommonXqUtils
					.getDocumentByObject(obj)));
		}
		return retMsg;
	}

	/**
	 * 初始化 xquery必要参数
	 * 
	 * @param xQueryHelper
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initXQuery(XQueryHelper xQueryHelper,
			TransformerRule transformerRule) {
		/**
		 * 初始化namespace
		 */
		String[] namespaces = null;
		for (int i = 0; i < transformerRule.getParamVarMaps().size(); i++) {
			if (transformerRule.getParamVarMaps().get(i).getKey()
					.equals("namespace")) {
				namespaces = transformerRule.getParamVarMaps().get(i).getVal()
						.split(",");
				break;
			}
		}
		Map<String, String> maps = new HashMap<String, String>();
		if (namespaces != null && namespaces.length > 0) {
			for (String name : namespaces) {
				if (name != null && !name.equals("")) {
					maps.put(name.substring(0, name.indexOf("=")),
							name.substring(name.indexOf("=") + 1));
				}
			}
		}
		
		maps.putAll(CommonXqUtils.getDefaultNamespace());
		StringBuffer sbu = new StringBuffer();
		for (Iterator iterator = maps.entrySet().iterator(); iterator.hasNext();) {
			Map.Entry<String, String> entry = (Map.Entry) iterator.next();
			sbu.append("declare namespace ").append(entry.getKey()).append("=\"")
			.append(entry.getValue()).append("\";");
		}
		xQueryHelper.setNamespace(sbu.toString());
		xQueryHelper.setNamespaces(maps);
	}
}
