package com.ailk.eaap.integration.o2p.transformer.xsl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.AttributesImpl;

public class EmployeeReader implements XMLReader{

	public void parse(InputSource source) throws IOException, SAXException {
		InputStream stream = source.getByteStream();
		BufferedReader in = null;
		InputStreamReader isr = null;
		try {
			isr = new InputStreamReader(stream);
			in = new BufferedReader(isr);
			String rootElement = "staff";
			AttributesImpl atts = new AttributesImpl();
	
			if (handler == null)
				throw new SAXException("No content handler");
	
			handler.startDocument();
			handler.startElement("", rootElement, rootElement, atts);
			String line;
			while ((line = in.readLine()) != null) {
				handler.startElement("", "employee", "employee", atts);
				StringTokenizer t = new StringTokenizer(line, "|");
	
				handler.startElement("", "name", "name", atts);
				String s = t.nextToken();
				handler.characters(s.toCharArray(), 0, s.length());
				handler.endElement("", "name", "name");
	
				handler.startElement("", "salary", "salary", atts);
				s = t.nextToken();
				handler.characters(s.toCharArray(), 0, s.length());
				handler.endElement("", "salary", "salary");
	
				atts.addAttribute("", "year", "year", "CDATA", t.nextToken());
				atts.addAttribute("", "month", "month", "CDATA", t.nextToken());
				atts.addAttribute("", "day", "day", "CDATA", t.nextToken());
				handler.startElement("", "hiredate", "hiredate", atts);
				handler.endElement("", "hiredate", "hiredate");
				atts.clear();
	
				handler.endElement("", "employee", "employee");
			}
			handler.endElement("", rootElement, rootElement);
			handler.endDocument();
		} catch (IOException e) {
			throw e;
		} finally {
			if(isr != null) {
				isr.close();
				isr = null;
			}
			if (in != null) {
				in.close();
				in = null;
			}
		}
	}

	public void setContentHandler(ContentHandler newValue) {
		handler = newValue;
	}

	public ContentHandler getContentHandler() {
		return handler;
	}

	// the following methods are just do-nothing implementations
	public void parse(String systemId) throws IOException, SAXException {
	}

	public void setErrorHandler(ErrorHandler handler) {
	}

	public ErrorHandler getErrorHandler() {
		return null;
	}

	public void setDTDHandler(DTDHandler handler) {
	}

	public DTDHandler getDTDHandler() {
		return null;
	}

	public void setEntityResolver(EntityResolver resolver) {
	}

	public EntityResolver getEntityResolver() {
		return null;
	}

	public void setProperty(String name, Object value) {
	}

	public Object getProperty(String name) {
		return null;
	}

	public void setFeature(String name, boolean value) {
	}

	public boolean getFeature(String name) {
		return false;
	}

	private ContentHandler handler;

}
