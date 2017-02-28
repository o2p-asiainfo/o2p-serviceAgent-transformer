package com.ailk.eaap.integration.o2p.transformer.xsl;

import java.io.File;
import java.io.FileInputStream;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.xml.sax.InputSource;

public class TransformTest {
	public static void main(String[] args) throws Exception {
		String filename;
		if (args.length > 0)
			filename = args[0];
		else
			filename = "com/ailk/eaap/integration/o2p/transformer/xsl/makehtml.xsl";
		Resource resource = new ClassPathResource(filename);
		String srcDataPath = "com/ailk/eaap/integration/o2p/transformer/xsl/staff.xml";
		Resource srcDataResource = new ClassPathResource(srcDataPath);
//		File styleSheet = new File(filename);
		File styleSheet = resource.getFile();
		StreamSource styleSource = new StreamSource(styleSheet);
		Transformer t = TransformerFactory.newInstance().newTransformer(
				styleSource);
		StreamSource source = new StreamSource(srcDataResource.getInputStream() ); 
		t.transform(source, new StreamResult(
						System.out));
/*		t.transform(new SAXSource(new EmployeeReader(), new InputSource(
                new FileInputStream("employee.dat"))), new StreamResult(
                System.out));*/
	}
}
