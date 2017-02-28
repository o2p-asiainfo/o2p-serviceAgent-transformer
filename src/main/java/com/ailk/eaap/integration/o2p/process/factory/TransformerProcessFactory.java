package com.ailk.eaap.integration.o2p.process.factory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import com.ailk.eaap.integration.o2p.process.HttpMsgStyleUrlTransformerProcessIn;
import com.ailk.eaap.integration.o2p.process.AbstractTransformerProcessIn;
import com.ailk.eaap.integration.o2p.process.CsvTransformerProcessIn;
import com.ailk.eaap.integration.o2p.process.DefaultTransformerProcessIn;
import com.ailk.eaap.integration.o2p.process.JsonTransformerProcessIn;
import com.ailk.eaap.integration.o2p.process.TlvTransformerProcessIn;
import com.ailk.eaap.integration.o2p.process.TxtTransformerProcessIn;
import com.ailk.eaap.integration.o2p.process.XmlTransformerProcessIn;
import com.asiainfo.foundation.log.Logger;

public final class TransformerProcessFactory implements Factory {

	private static final Logger LOG = Logger.getLog(TransformerProcessFactory.class);
	private static TransformerProcessFactory transformerProcessFactory = new TransformerProcessFactory();
	private static Map<Integer, AbstractTransformerProcessIn> transformerProcessCache = new ConcurrentHashMap<Integer, AbstractTransformerProcessIn>();

	private TransformerProcessFactory() {
	}

	public static TransformerProcessFactory getInstance() {
		return transformerProcessFactory;
	}

	public AbstractTransformerProcessIn getProcess(int processType) {
		AbstractTransformerProcessIn process = null;
		process = transformerProcessCache.get(processType);
		if (process == null) {
			process = createProcess(processType);
			transformerProcessCache.put(processType, process);
		}
		return process;
	}

	private AbstractTransformerProcessIn createProcess(int processType) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Change Type : {0}", processType);
		}
		switch (processType) {
		case 1:
			return new XmlTransformerProcessIn();
		case 2:
			return new JsonTransformerProcessIn();
		case 4:
			return new TxtTransformerProcessIn();
		case 7:
			return new TlvTransformerProcessIn();
		case 11:
			return new CsvTransformerProcessIn();
		case 10:
			return new HttpMsgStyleUrlTransformerProcessIn();
		default:
			return new DefaultTransformerProcessIn();
		}
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}
