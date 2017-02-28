package com.ailk.eaap.integration.xslt;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.DocumentSource;
import org.dom4j.io.SAXReader;
import org.junit.Test;
import org.xml.sax.SAXException;

/**
 * Created by david on 14-7-16.
 */
public class XSLTtransfomer {
    @Test
    public void xsltTransfomer() throws TransformerException, IOException, SAXException, DocumentException {
        File f = new File("/install_apps/iso/xslt/staff.xml");
        DocumentSource documentSource = getXmlContent(f);
        javax.xml.transform.Transformer transformer;
        StreamSource streamSource = new StreamSource("/install_apps/iso/xslt/makehtml.xsl");
        transformer = TransformerFactory.newInstance().newTransformer(streamSource);
        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);
        transformer.transform(documentSource, result);
        System.out.println(writer.toString());
    }

    public static DocumentSource getXmlContent(File file) throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(file);
        return new DocumentSource(document);
    }

    @SuppressWarnings("unused")
	private static String getContent(File file) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setFeature("http://javax.xml.XMLConstants/feature/secure-processing", true);
        dbf.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        dbf.setFeature("http://xml.org/sax/features/external-general-entities", false);
        dbf.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
        dbf.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        DocumentBuilder db = dbf.newDocumentBuilder();
        org.w3c.dom.Document doc = db.parse(file);
        if (null != doc) {
        	return doc.getTextContent();
        }
        else {
        	return "";
        }
    }
}
