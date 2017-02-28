package com.ailk.eaap.integration.o2p.transformer;

import java.util.Map;

import com.asiainfo.foundation.log.Logger;

public class TransformerFactoryProxy implements TransformerFactory{
	private static final Logger LOG = Logger.getLog(TransformerFactoryProxy.class);
	private Map<Integer,Transformer> transformerHolder ;
	private Class<?> objectType = DefaultTransformer.class;

	
	public void setTransformerHolder(Map<Integer, Transformer> transformerHolder) {
		this.transformerHolder = transformerHolder;
	}

	@Override
	public Class<?> getObjectType() {
		return objectType;
	}

	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void init() {
		
		LOG.info("TransformerFactoryProxy init!");
	}

	@Override
	public Transformer getTransformer(Integer transformType) {
        Transformer transformer = null;
        transformer = transformerHolder.get(transformType);
        objectType = transformer.getClass();
		return transformer;
	}

	@Override
	public void destory() {
		// TODO Auto-generated method stub
		LOG.info("TransformerFactoryProxy destory!");
	}

}
