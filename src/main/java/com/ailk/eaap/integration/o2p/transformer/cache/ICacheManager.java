package com.ailk.eaap.integration.o2p.transformer.cache;

public interface ICacheManager {
	public String getCacheStatus();
	public void initConfigure2Cache();
	public void clearAll();
	public void reloadConfigure2Cache();
}
