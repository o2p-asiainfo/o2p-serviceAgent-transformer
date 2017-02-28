package com.ailk.eaap.integration.o2p.transformer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.Assert;

import com.ailk.eaap.integration.o2p.contractbody.service.IContractAdapterEndpointService;
import com.ailk.eaap.integration.o2p.contractbody.util.ContractBodyUtil;
import com.ailk.eaap.integration.o2p.message.support.MessageMapperService;
import com.ailk.eaap.integration.o2p.process.AbstractTransformerProcessIn;
import com.ailk.eaap.integration.o2p.process.factory.TransformerProcessFactory;
import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.asiainfo.foundation.log.Logger;
import com.ailk.eaap.op2.bo.ContractFormat;
import com.ailk.eaap.op2.bo.ContractFormatEx;
import com.ailk.eaap.op2.bo.MessageDesc;
import com.ailk.eaap.op2.bo.MessageNode;
import com.ailk.eaap.op2.bo.NodeDesc;
import com.ailk.eaap.op2.bo.NodeDescMapper;
import com.ailk.eaap.op2.bo.NodeValReq;
import com.ailk.eaap.op2.bo.TransformerRule;

public class DefaultTransformer extends AbstractTransformer {
	private static final Logger LOG = Logger.getLog(DefaultTransformer.class);
	private MessageMapperService messageMapperService;
	private IContractAdapterEndpointService contractAdapterEndpointSer;
	private TransformerProcessFactory transformerProcessFactory = TransformerProcessFactory
			.getInstance();
	private VerHorTransformer verHorTransformer;
	
	@Override
	protected Object beforeTransform(MessageBO<?> message,
			TransformerRule transformerRule) throws Exception {
		List<NodeDescMapper> nodeMappers = transformerRule.getNodeDescMappers();
		Assert.notEmpty(nodeMappers, "the transformerRule id="
				+ transformerRule.getId() + " no found nodeMapper!");
		if (LOG.isDebugEnabled()) {
			LOG.debug("msgBody {0}", message.toString());
		}

		List<MessageNode> list = new ArrayList<MessageNode>();
		MessageDesc messageDesc = new MessageDesc();
		messageDesc.setContractFormat(transformerRule.getTarContractFormat());
		messageDesc.setHeaders(message.getMsgHead());
		messageDesc.setSrcConType(transformerRule.getSrcContractFormat()
				.getConType());
		ContractFormatEx contractFormatEx = (ContractFormatEx) transformerRule
				.getTarContractFormat();
		messageDesc.setAttrs(contractFormatEx.getContract2AttrSpecs());
		Map<Integer, NodeDescMapper> mapJoinNodeDescMapper = new HashMap<Integer, NodeDescMapper>();
		Map<Integer, Object> mapJoinValues = new HashMap<Integer, Object>();
		for (NodeDescMapper nodeMapper : nodeMappers) {
			String actionTypeCd = nodeMapper.getOperTypeCd();
			
			if(verHorTransformer.isVer2Hor(actionTypeCd, list, message, 
					nodeMappers, messageDesc, transformerRule,nodeMapper)) {
				
				break;
			}
			
			if(verHorTransformer.isHor2Ver(actionTypeCd, list, message, 
					nodeMappers, messageDesc, transformerRule,nodeMapper)) {
				
				break;
			}
			
			
			NodeDesc tarNode = nodeMapper.getTarNode();
			Object tarNodeVal = messageMapperService.getTarNodeValByMapper(
					message, transformerRule, nodeMapper);
			if (!"J".equals(nodeMapper.getOperTypeCd())) {
				nodeMapper.setTarNodeVal(tarNodeVal);
				MessageNode messageNode = new MessageNode();
				messageNode.setNodeDesc(tarNode);
				messageNode.setNodeVal(tarNodeVal == null ? null : tarNodeVal);
				if (nodeMapper.getSrcNode() != null) {
					MessageNode messageSrcNode = new MessageNode();
					messageSrcNode.setNodeDesc(nodeMapper.getSrcNode());
				}
				list.add(messageNode);
			} else {
				mapJoinNodeDescMapper.put(tarNode.getNodeDescId(), nodeMapper);
				mapJoinValues.put(nodeMapper.getSrcNode().getNodeDescId(),
						tarNodeVal);
			}

		}

		if (mapJoinNodeDescMapper.size() > 0) {
			for (int i : mapJoinNodeDescMapper.keySet()) {
				NodeDescMapper nodeDescMapper = mapJoinNodeDescMapper.get(i);
				NodeValReq nodeValReq = nodeDescMapper.getTarNodeValReq();
				Assert.notNull(nodeValReq);
				Object tarNodeVal = ContractBodyUtil.getValue(nodeDescMapper
						.getTarNodeValReq().getNodeDescId(), nodeValReq
						.getValueExpress(), mapJoinValues);
				nodeDescMapper.setTarNodeVal(tarNodeVal);
				MessageNode messageNode = new MessageNode();
				messageNode.setNodeDesc(nodeDescMapper.getTarNode());
				messageNode.setNodeVal(tarNodeVal == null ? null : tarNodeVal);

				list.add(messageNode);
			}
		}

		messageDesc.setMessageNodes(list);
		messageDesc.setNodeMappers(nodeMappers);
		return messageDesc;
	}

	@Override
	protected Object doTransform(MessageBO<?> message,
			TransformerRule transformerRule) throws Exception {
		// 直接替换为消息轨迹报文
		if (16 == transformerRule.getTransformerType()) {
			message = contractAdapterEndpointSer
					.replaceContractAdapterEndpoint(message, transformerRule);
			if (LOG.isDebugEnabled()) {
				LOG.debug("replace msgBody {0}", message.toString());
			}
			return message;
		}

		long startTime = System.currentTimeMillis();
		MessageDesc messageDescs = (MessageDesc) beforeTransform(message,
				transformerRule);
		long endTime = System.currentTimeMillis();
		if (LOG.isDebugEnabled()) {
			LOG.debug("before transform enpend count:{0}",
					(endTime - startTime) + "ms");
		}
		Assert.notNull(messageDescs);
		ContractFormat contractFormat = transformerRule.getTarContractFormat();
		String conType = contractFormat.getConType();
		return buildMessage(messageDescs, conType, message);
	}

	private MessageBO<?> buildMessage(MessageDesc messageDescs, String conType,
			MessageBO<?> bo) throws Exception {
		MessageBO<?> val;
		if (MessageMapperService.CONST_MSG_CON_TYPE_XML.equals(conType)) {
			AbstractTransformerProcessIn transformerProcessIn = transformerProcessFactory
					.getProcess(Integer
							.valueOf(MessageMapperService.CONST_MSG_CON_TYPE_XML));
			val = transformerProcessIn.processContent(messageDescs, bo);
			return val;
		} else if (MessageMapperService.CONST_MSG_CON_TYPE_JSON.equals(conType)) {
			AbstractTransformerProcessIn transformerProcessIn = transformerProcessFactory
					.getProcess(Integer
							.valueOf(MessageMapperService.CONST_MSG_CON_TYPE_JSON));
			val = transformerProcessIn.processContent(messageDescs, bo);
			return val;
		} else if (MessageMapperService.CONST_MSG_CON_TYPE_CSV.equals(conType)) {
			AbstractTransformerProcessIn transformerProcessIn = transformerProcessFactory
					.getProcess(Integer
							.valueOf(MessageMapperService.CONST_MSG_CON_TYPE_CSV));
			val = transformerProcessIn.processContent(messageDescs, bo);
			return val;
		} else if (MessageMapperService.CONST_MSG_CON_TYPE_TXT.equals(conType)) {
			AbstractTransformerProcessIn transformerProcessIn = transformerProcessFactory
					.getProcess(Integer
							.valueOf(MessageMapperService.CONST_MSG_CON_TYPE_TXT));
			val = transformerProcessIn.processContent(messageDescs, bo);
			return val;
		} else if (MessageMapperService.CONST_MSG_CON_TYPE_TLV.equals(conType)) {
			AbstractTransformerProcessIn transformerProcessIn = transformerProcessFactory
					.getProcess(Integer
							.valueOf(MessageMapperService.CONST_MSG_CON_TYPE_TLV));
			val = transformerProcessIn.processContent(messageDescs, bo);
			return val;
		} else if (MessageMapperService.CONST_MSG_CON_TYPE_HTTPMSG_STYLE_URL.equals(conType)) {
			AbstractTransformerProcessIn transformerProcessIn = transformerProcessFactory
					.getProcess(Integer
							.valueOf(MessageMapperService.CONST_MSG_CON_TYPE_HTTPMSG_STYLE_URL));
			val = transformerProcessIn.processContent(messageDescs, bo);
			return val;
		}
		return null;
	}

	@Override
	protected Object afterTransform(MessageBO<?> message,
			TransformerRule transformerRule) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void setMessageMapperService(
			MessageMapperService messageMapperService) {
		Assert.notNull(messageMapperService);
		this.messageMapperService = messageMapperService;
	}

	public IContractAdapterEndpointService getContractAdapterEndpointSer() {
		return contractAdapterEndpointSer;
	}

	public void setContractAdapterEndpointSer(
			IContractAdapterEndpointService contractAdapterEndpointSer) {
		this.contractAdapterEndpointSer = contractAdapterEndpointSer;
	}

	public void setVerHorTransformer(VerHorTransformer verHorTransformer) {
		this.verHorTransformer = verHorTransformer;
	}
}
