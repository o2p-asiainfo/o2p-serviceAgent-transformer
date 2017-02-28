package com.ailk.eaap.integration.o2p.transformer;

public interface TransformerFactory {
	public void init();
	public void destory();
	public Transformer getTransformer(Integer transformType);
	public Class<?> getObjectType();
	public boolean isSingleton();
}
