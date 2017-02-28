package com.ailk.eaap.integration.o2p.transformer.xml;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import javax.xml.transform.stream.StreamResult;

import com.asiainfo.foundation.log.LogModel;
import com.asiainfo.foundation.log.Logger;

public class StringResult extends StreamResult{
	private static final Logger LOG = Logger.getLog(StringResult.class);
	
    public StringResult() {
        super(new StringWriter());
    }

    /** Returns the written XML as a string. */
    public String toString() {
    	Writer writer = getWriter();
    	String str = writer.toString();
    	try {
			writer.close();
		} catch (IOException e) {
			LOG.error(LogModel.EVENT_APP_EXCPT, e);
		}
        return str;
    }
}
