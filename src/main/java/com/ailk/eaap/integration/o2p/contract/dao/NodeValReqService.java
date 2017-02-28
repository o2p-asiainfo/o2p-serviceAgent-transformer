package com.ailk.eaap.integration.o2p.contract.dao;

import com.ailk.eaap.op2.bo.NodeDesc;
import com.ailk.eaap.op2.bo.NodeValReq;

public interface NodeValReqService {
	public NodeValReq getNodeValReqByNodeDesc(NodeDesc tarNode);
}
