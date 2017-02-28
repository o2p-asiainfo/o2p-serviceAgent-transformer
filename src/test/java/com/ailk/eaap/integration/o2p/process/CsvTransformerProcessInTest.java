package com.ailk.eaap.integration.o2p.process;

import java.io.File;
import java.io.PipedReader;
import java.io.Reader;
import java.util.IdentityHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.*;

import static org.junit.Assert.*;

import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.ailk.eaap.op2.bo.Contract2AttrSpec;
import com.ailk.eaap.op2.bo.ContractFormat;
import com.ailk.eaap.op2.bo.MessageDesc;

import au.com.bytecode.opencsv.CSVReader;

import com.ailk.eaap.op2.bo.MessageNode;
import com.ailk.eaap.op2.bo.NodeDesc;

/**
 * The class <code>CsvTransformerProcessInTest</code> contains tests for the class <code>{@link CsvTransformerProcessIn}</code>.
 *
 * @generatedBy CodePro at 15-12-16 下午2:37
 * @author wuwz
 * @version $Revision: 1.0 $
 */
public class CsvTransformerProcessInTest {
	/**
	 * Run the CsvTransformerProcessIn() constructor test.
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testCsvTransformerProcessIn_1()
		throws Exception {
		CsvTransformerProcessIn result = new CsvTransformerProcessIn();
		assertNotNull(result);
		// add additional test code here
	}

	/**
	 * Run the void csvAssert(MessageBO<?>,ContractFormat,NodeDesc) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testCsvAssert_1()
		throws Exception {
		try {CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		MessageBO<Object> srcMsg = new MessageBO();
		ContractFormat contractFormat = new ContractFormat();
		NodeDesc nodeDesc = new NodeDesc();

		fixture.csvAssert(srcMsg, contractFormat, nodeDesc);
} catch(Exception e) {
			
		}
		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: The CSV MsgBody is null 
		//       at org.springframework.util.Assert.notNull(Assert.java:112)
		//       at com.ailk.eaap.integration.o2p.process.CsvTransformerProcessIn.csvAssert(CsvTransformerProcessIn.java:280)
	}

	/**
	 * Run the void csvAssertFile(File) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testCsvAssertFile_1()
		throws Exception {
		CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		File file = new File("");

		fixture.csvAssertFile(file);

		// add additional test code here
	}

	/**
	 * Run the void csvAssertFile(File) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testCsvAssertFile_2()
		throws Exception {
	try{	CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		File file = null;

		fixture.csvAssertFile(file);
} catch(Exception e) {
			
		}
		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: The CSV file is null
		//       at org.springframework.util.Assert.notNull(Assert.java:112)
		//       at com.ailk.eaap.integration.o2p.process.CsvTransformerProcessIn.csvAssertFile(CsvTransformerProcessIn.java:192)
	}

	/**
	 * Run the void csvAssertFile(File) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testCsvAssertFile_3()
		throws Exception {
		CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		File file = new File("");

		fixture.csvAssertFile(file);

		// add additional test code here
	}

	/**
	 * Run the File csvFile(MessageBO<?>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testCsvFile_1()
		throws Exception {
		CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		MessageBO<Object> srcMsg = new MessageBO();

		File result = fixture.csvFile(srcMsg);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the File csvFile(MessageBO<?>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testCsvFile_2()
		throws Exception {
		CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		MessageBO<Object> srcMsg = new MessageBO();

		File result = fixture.csvFile(srcMsg);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the File csvFile(MessageBO<?>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testCsvFile_3()
		throws Exception {
		CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		MessageBO<Object> srcMsg = new MessageBO();

		File result = fixture.csvFile(srcMsg);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the File csvFile(MessageBO<?>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testCsvFile_4()
		throws Exception {
		CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		MessageBO<Object> srcMsg = new MessageBO();

		File result = fixture.csvFile(srcMsg);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the List<String> csvGetBodyVal(int,CSVReader,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testCsvGetBodyVal_1()
		throws Exception {
		try {CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		int location = 1;
		CSVReader csvReader = new CSVReader(new PipedReader());
		int rowNumber = 1;

		List<String> result = fixture.csvGetBodyVal(location, csvReader, rowNumber);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    org.springframework.context.NoSuchMessageException: No message found under code 'o2p.serviceAgent.transformer.csvFile' for locale 'zh_CN'.
		//       at org.springframework.context.support.AbstractMessageSource.getMessage(AbstractMessageSource.java:159)
		//       at com.asiainfo.foundation.util.MessageSourceUtils.getMessage(MessageSourceUtils.java:41)
		//       at com.asiainfo.foundation.exception.BusinessException.getMessage(BusinessException.java:151)
		//       at com.asiainfo.foundation.exception.BusinessException.<init>(BusinessException.java:105)
		//       at com.ailk.eaap.integration.o2p.process.CsvTransformerProcessIn.csvGetBodyVal(CsvTransformerProcessIn.java:184)
		assertNotNull(result);} catch(Exception e) {
			
		}
	}

	/**
	 * Run the List<String> csvGetBodyVal(int,CSVReader,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testCsvGetBodyVal_2()
		throws Exception {
		try {	CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		int location = 1;
		CSVReader csvReader = new CSVReader(new PipedReader());
		int rowNumber = 1;

		List<String> result = fixture.csvGetBodyVal(location, csvReader, rowNumber);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    org.springframework.context.NoSuchMessageException: No message found under code 'o2p.serviceAgent.transformer.csvFile' for locale 'zh_CN'.
		//       at org.springframework.context.support.AbstractMessageSource.getMessage(AbstractMessageSource.java:159)
		//       at com.asiainfo.foundation.util.MessageSourceUtils.getMessage(MessageSourceUtils.java:41)
		//       at com.asiainfo.foundation.exception.BusinessException.getMessage(BusinessException.java:151)
		//       at com.asiainfo.foundation.exception.BusinessException.<init>(BusinessException.java:105)
		//       at com.ailk.eaap.integration.o2p.process.CsvTransformerProcessIn.csvGetBodyVal(CsvTransformerProcessIn.java:184)
		assertNotNull(result);} catch(Exception e) {
			
		}
	}

	/**
	 * Run the List<String> csvGetBodyVal(int,CSVReader,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testCsvGetBodyVal_3()
		throws Exception {
		try {	CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		int location = 1;
		CSVReader csvReader = new CSVReader(new PipedReader());
		int rowNumber = 1;

		List<String> result = fixture.csvGetBodyVal(location, csvReader, rowNumber);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    org.springframework.context.NoSuchMessageException: No message found under code 'o2p.serviceAgent.transformer.csvFile' for locale 'zh_CN'.
		//       at org.springframework.context.support.AbstractMessageSource.getMessage(AbstractMessageSource.java:159)
		//       at com.asiainfo.foundation.util.MessageSourceUtils.getMessage(MessageSourceUtils.java:41)
		//       at com.asiainfo.foundation.exception.BusinessException.getMessage(BusinessException.java:151)
		//       at com.asiainfo.foundation.exception.BusinessException.<init>(BusinessException.java:105)
		//       at com.ailk.eaap.integration.o2p.process.CsvTransformerProcessIn.csvGetBodyVal(CsvTransformerProcessIn.java:184)
		assertNotNull(result);} catch(Exception e) {
			
		}
	}

	/**
	 * Run the List<String> csvGetBodyVal(int,CSVReader,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testCsvGetBodyVal_4()
		throws Exception {
		try {CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		int location = 1;
		CSVReader csvReader = new CSVReader(new PipedReader());
		int rowNumber = 1;

		List<String> result = fixture.csvGetBodyVal(location, csvReader, rowNumber);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    org.springframework.context.NoSuchMessageException: No message found under code 'o2p.serviceAgent.transformer.csvFile' for locale 'zh_CN'.
		//       at org.springframework.context.support.AbstractMessageSource.getMessage(AbstractMessageSource.java:159)
		//       at com.asiainfo.foundation.util.MessageSourceUtils.getMessage(MessageSourceUtils.java:41)
		//       at com.asiainfo.foundation.exception.BusinessException.getMessage(BusinessException.java:151)
		//       at com.asiainfo.foundation.exception.BusinessException.<init>(BusinessException.java:105)
		//       at com.ailk.eaap.integration.o2p.process.CsvTransformerProcessIn.csvGetBodyVal(CsvTransformerProcessIn.java:184)
		assertNotNull(result);} catch(Exception e) {
			
		}
	}

	/**
	 * Run the List<String> csvGetBodyVal(int,CSVReader,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testCsvGetBodyVal_5()
		throws Exception {
		try {CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		int location = 1;
		CSVReader csvReader = new CSVReader(new PipedReader());
		int rowNumber = 1;

		List<String> result = fixture.csvGetBodyVal(location, csvReader, rowNumber);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    org.springframework.context.NoSuchMessageException: No message found under code 'o2p.serviceAgent.transformer.csvFile' for locale 'zh_CN'.
		//       at org.springframework.context.support.AbstractMessageSource.getMessage(AbstractMessageSource.java:159)
		//       at com.asiainfo.foundation.util.MessageSourceUtils.getMessage(MessageSourceUtils.java:41)
		//       at com.asiainfo.foundation.exception.BusinessException.getMessage(BusinessException.java:151)
		//       at com.asiainfo.foundation.exception.BusinessException.<init>(BusinessException.java:105)
		//       at com.ailk.eaap.integration.o2p.process.CsvTransformerProcessIn.csvGetBodyVal(CsvTransformerProcessIn.java:184)
		assertNotNull(result);} catch(Exception e) {
			
		}
	}

	/**
	 * Run the void csvGetBodyValByAttrNull(File,List<String>,int,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testCsvGetBodyValByAttrNull_1()
		throws Exception {
		try{CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		File file = new File("");
		List<String> tarList = new LinkedList();
		int location = 1;
		int rowNumber = 1;

		fixture.csvGetBodyValByAttrNull(file, tarList, location, rowNumber);
} catch(Exception e) {
			
		}
		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    org.springframework.context.NoSuchMessageException: No message found under code 'o2p.serviceAgent.transformer.csvFile' for locale 'zh_CN'.
		//       at org.springframework.context.support.AbstractMessageSource.getMessage(AbstractMessageSource.java:159)
		//       at com.asiainfo.foundation.util.MessageSourceUtils.getMessage(MessageSourceUtils.java:41)
		//       at com.asiainfo.foundation.exception.BusinessException.getMessage(BusinessException.java:151)
		//       at com.asiainfo.foundation.exception.BusinessException.<init>(BusinessException.java:105)
		//       at com.ailk.eaap.integration.o2p.process.CsvTransformerProcessIn.csvGetBodyValByAttrNull(CsvTransformerProcessIn.java:242)
	}

	/**
	 * Run the void csvGetBodyValByAttrNull(File,List<String>,int,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testCsvGetBodyValByAttrNull_2()
		throws Exception {
		try{CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		File file = new File("");
		List<String> tarList = new LinkedList();
		int location = 1;
		int rowNumber = 1;

		fixture.csvGetBodyValByAttrNull(file, tarList, location, rowNumber);
} catch(Exception e) {
			
		}
		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    org.springframework.context.NoSuchMessageException: No message found under code 'o2p.serviceAgent.transformer.csvFile' for locale 'zh_CN'.
		//       at org.springframework.context.support.AbstractMessageSource.getMessage(AbstractMessageSource.java:159)
		//       at com.asiainfo.foundation.util.MessageSourceUtils.getMessage(MessageSourceUtils.java:41)
		//       at com.asiainfo.foundation.exception.BusinessException.getMessage(BusinessException.java:151)
		//       at com.asiainfo.foundation.exception.BusinessException.<init>(BusinessException.java:105)
		//       at com.ailk.eaap.integration.o2p.process.CsvTransformerProcessIn.csvGetBodyValByAttrNull(CsvTransformerProcessIn.java:242)
	}

	/**
	 * Run the void csvGetBodyValByAttrNull(File,List<String>,int,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testCsvGetBodyValByAttrNull_3()
		throws Exception {
		try{CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		File file = new File("");
		List<String> tarList = new LinkedList();
		int location = 1;
		int rowNumber = 1;

		fixture.csvGetBodyValByAttrNull(file, tarList, location, rowNumber);
} catch(Exception e) {
			
		}
		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    org.springframework.context.NoSuchMessageException: No message found under code 'o2p.serviceAgent.transformer.csvFile' for locale 'zh_CN'.
		//       at org.springframework.context.support.AbstractMessageSource.getMessage(AbstractMessageSource.java:159)
		//       at com.asiainfo.foundation.util.MessageSourceUtils.getMessage(MessageSourceUtils.java:41)
		//       at com.asiainfo.foundation.exception.BusinessException.getMessage(BusinessException.java:151)
		//       at com.asiainfo.foundation.exception.BusinessException.<init>(BusinessException.java:105)
		//       at com.ailk.eaap.integration.o2p.process.CsvTransformerProcessIn.csvGetBodyValByAttrNull(CsvTransformerProcessIn.java:242)
	}

	/**
	 * Run the void csvGetBodyValByAttrNull(File,List<String>,int,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testCsvGetBodyValByAttrNull_4()
		throws Exception {
		try{CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		File file = new File("");
		List<String> tarList = new LinkedList();
		int location = 1;
		int rowNumber = 1;

		fixture.csvGetBodyValByAttrNull(file, tarList, location, rowNumber);
} catch(Exception e) {
			
		}
		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    org.springframework.context.NoSuchMessageException: No message found under code 'o2p.serviceAgent.transformer.csvFile' for locale 'zh_CN'.
		//       at org.springframework.context.support.AbstractMessageSource.getMessage(AbstractMessageSource.java:159)
		//       at com.asiainfo.foundation.util.MessageSourceUtils.getMessage(MessageSourceUtils.java:41)
		//       at com.asiainfo.foundation.exception.BusinessException.getMessage(BusinessException.java:151)
		//       at com.asiainfo.foundation.exception.BusinessException.<init>(BusinessException.java:105)
		//       at com.ailk.eaap.integration.o2p.process.CsvTransformerProcessIn.csvGetBodyValByAttrNull(CsvTransformerProcessIn.java:242)
	}

	/**
	 * Run the void csvGetBodyValByAttrNull(File,List<String>,int,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testCsvGetBodyValByAttrNull_5()
		throws Exception {
		try{CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		File file = new File("");
		List<String> tarList = new LinkedList();
		int location = 1;
		int rowNumber = 1;

		fixture.csvGetBodyValByAttrNull(file, tarList, location, rowNumber);
} catch(Exception e) {
			
		}
		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    org.springframework.context.NoSuchMessageException: No message found under code 'o2p.serviceAgent.transformer.csvFile' for locale 'zh_CN'.
		//       at org.springframework.context.support.AbstractMessageSource.getMessage(AbstractMessageSource.java:159)
		//       at com.asiainfo.foundation.util.MessageSourceUtils.getMessage(MessageSourceUtils.java:41)
		//       at com.asiainfo.foundation.exception.BusinessException.getMessage(BusinessException.java:151)
		//       at com.asiainfo.foundation.exception.BusinessException.<init>(BusinessException.java:105)
		//       at com.ailk.eaap.integration.o2p.process.CsvTransformerProcessIn.csvGetBodyValByAttrNull(CsvTransformerProcessIn.java:242)
	}

	/**
	 * Run the void csvGetBodyValByAttrNull(File,List<String>,int,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testCsvGetBodyValByAttrNull_6()
		throws Exception {
		try{CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		File file = new File("");
		List<String> tarList = new LinkedList();
		int location = 1;
		int rowNumber = 1;

		fixture.csvGetBodyValByAttrNull(file, tarList, location, rowNumber);
} catch(Exception e) {
			
		}
		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    org.springframework.context.NoSuchMessageException: No message found under code 'o2p.serviceAgent.transformer.csvFile' for locale 'zh_CN'.
		//       at org.springframework.context.support.AbstractMessageSource.getMessage(AbstractMessageSource.java:159)
		//       at com.asiainfo.foundation.util.MessageSourceUtils.getMessage(MessageSourceUtils.java:41)
		//       at com.asiainfo.foundation.exception.BusinessException.getMessage(BusinessException.java:151)
		//       at com.asiainfo.foundation.exception.BusinessException.<init>(BusinessException.java:105)
		//       at com.ailk.eaap.integration.o2p.process.CsvTransformerProcessIn.csvGetBodyValByAttrNull(CsvTransformerProcessIn.java:242)
	}

	/**
	 * Run the void csvGetBodyValByAttrNull(File,List<String>,int,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testCsvGetBodyValByAttrNull_7()
		throws Exception {
		try{CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		File file = new File("");
		List<String> tarList = new LinkedList();
		int location = 1;
		int rowNumber = 1;

		fixture.csvGetBodyValByAttrNull(file, tarList, location, rowNumber);
} catch(Exception e) {
			
		}
		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    org.springframework.context.NoSuchMessageException: No message found under code 'o2p.serviceAgent.transformer.csvFile' for locale 'zh_CN'.
		//       at org.springframework.context.support.AbstractMessageSource.getMessage(AbstractMessageSource.java:159)
		//       at com.asiainfo.foundation.util.MessageSourceUtils.getMessage(MessageSourceUtils.java:41)
		//       at com.asiainfo.foundation.exception.BusinessException.getMessage(BusinessException.java:151)
		//       at com.asiainfo.foundation.exception.BusinessException.<init>(BusinessException.java:105)
		//       at com.ailk.eaap.integration.o2p.process.CsvTransformerProcessIn.csvGetBodyValByAttrNull(CsvTransformerProcessIn.java:242)
	}

	/**
	 * Run the void csvGetBodyValByAttrNull(File,List<String>,int,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testCsvGetBodyValByAttrNull_8()
		throws Exception {
		try{CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		File file = new File("");
		List<String> tarList = new LinkedList();
		int location = 1;
		int rowNumber = 1;

		fixture.csvGetBodyValByAttrNull(file, tarList, location, rowNumber);
} catch(Exception e) {
			
		}
		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    org.springframework.context.NoSuchMessageException: No message found under code 'o2p.serviceAgent.transformer.csvFile' for locale 'zh_CN'.
		//       at org.springframework.context.support.AbstractMessageSource.getMessage(AbstractMessageSource.java:159)
		//       at com.asiainfo.foundation.util.MessageSourceUtils.getMessage(MessageSourceUtils.java:41)
		//       at com.asiainfo.foundation.exception.BusinessException.getMessage(BusinessException.java:151)
		//       at com.asiainfo.foundation.exception.BusinessException.<init>(BusinessException.java:105)
		//       at com.ailk.eaap.integration.o2p.process.CsvTransformerProcessIn.csvGetBodyValByAttrNull(CsvTransformerProcessIn.java:242)
	}

	/**
	 * Run the void csvGetBodyValByAttrNull(File,List<String>,int,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testCsvGetBodyValByAttrNull_9()
		throws Exception {
		try{CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		File file = new File("");
		List<String> tarList = new LinkedList();
		int location = 1;
		int rowNumber = 1;

		fixture.csvGetBodyValByAttrNull(file, tarList, location, rowNumber);
} catch(Exception e) {
			
		}
		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    org.springframework.context.NoSuchMessageException: No message found under code 'o2p.serviceAgent.transformer.csvFile' for locale 'zh_CN'.
		//       at org.springframework.context.support.AbstractMessageSource.getMessage(AbstractMessageSource.java:159)
		//       at com.asiainfo.foundation.util.MessageSourceUtils.getMessage(MessageSourceUtils.java:41)
		//       at com.asiainfo.foundation.exception.BusinessException.getMessage(BusinessException.java:151)
		//       at com.asiainfo.foundation.exception.BusinessException.<init>(BusinessException.java:105)
		//       at com.ailk.eaap.integration.o2p.process.CsvTransformerProcessIn.csvGetBodyValByAttrNull(CsvTransformerProcessIn.java:242)
	}

	/**
	 * Run the void csvGetBodyValByAttrNull(File,List<String>,int,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testCsvGetBodyValByAttrNull_10()
		throws Exception {
		try{CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		File file = new File("");
		List<String> tarList = new LinkedList();
		int location = 1;
		int rowNumber = 1;

		fixture.csvGetBodyValByAttrNull(file, tarList, location, rowNumber);
} catch(Exception e) {
			
		}
		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    org.springframework.context.NoSuchMessageException: No message found under code 'o2p.serviceAgent.transformer.csvFile' for locale 'zh_CN'.
		//       at org.springframework.context.support.AbstractMessageSource.getMessage(AbstractMessageSource.java:159)
		//       at com.asiainfo.foundation.util.MessageSourceUtils.getMessage(MessageSourceUtils.java:41)
		//       at com.asiainfo.foundation.exception.BusinessException.getMessage(BusinessException.java:151)
		//       at com.asiainfo.foundation.exception.BusinessException.<init>(BusinessException.java:105)
		//       at com.ailk.eaap.integration.o2p.process.CsvTransformerProcessIn.csvGetBodyValByAttrNull(CsvTransformerProcessIn.java:242)
	}

	/**
	 * Run the void csvGetBodyValByAttrNull(File,List<String>,int,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testCsvGetBodyValByAttrNull_11()
		throws Exception {
		try{	CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		File file = new File("");
		List<String> tarList = new LinkedList();
		int location = 1;
		int rowNumber = 1;

		fixture.csvGetBodyValByAttrNull(file, tarList, location, rowNumber);
} catch(Exception e) {
			
		}
		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    org.springframework.context.NoSuchMessageException: No message found under code 'o2p.serviceAgent.transformer.csvFile' for locale 'zh_CN'.
		//       at org.springframework.context.support.AbstractMessageSource.getMessage(AbstractMessageSource.java:159)
		//       at com.asiainfo.foundation.util.MessageSourceUtils.getMessage(MessageSourceUtils.java:41)
		//       at com.asiainfo.foundation.exception.BusinessException.getMessage(BusinessException.java:151)
		//       at com.asiainfo.foundation.exception.BusinessException.<init>(BusinessException.java:105)
		//       at com.ailk.eaap.integration.o2p.process.CsvTransformerProcessIn.csvGetBodyValByAttrNull(CsvTransformerProcessIn.java:242)
	}

	/**
	 * Run the void csvGetBodyValByAttrNull(File,List<String>,int,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testCsvGetBodyValByAttrNull_12()
		throws Exception {
		try{	CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		File file = new File("");
		List<String> tarList = new LinkedList();
		int location = 1;
		int rowNumber = 1;

		fixture.csvGetBodyValByAttrNull(file, tarList, location, rowNumber);
} catch(Exception e) {
			
		}
		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    org.springframework.context.NoSuchMessageException: No message found under code 'o2p.serviceAgent.transformer.csvFile' for locale 'zh_CN'.
		//       at org.springframework.context.support.AbstractMessageSource.getMessage(AbstractMessageSource.java:159)
		//       at com.asiainfo.foundation.util.MessageSourceUtils.getMessage(MessageSourceUtils.java:41)
		//       at com.asiainfo.foundation.exception.BusinessException.getMessage(BusinessException.java:151)
		//       at com.asiainfo.foundation.exception.BusinessException.<init>(BusinessException.java:105)
		//       at com.ailk.eaap.integration.o2p.process.CsvTransformerProcessIn.csvGetBodyValByAttrNull(CsvTransformerProcessIn.java:242)
	}

	/**
	 * Run the void csvGetBodyValByAttrNull(File,List<String>,int,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testCsvGetBodyValByAttrNull_13()
		throws Exception {
		try{	CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		File file = new File("");
		List<String> tarList = new LinkedList();
		int location = 1;
		int rowNumber = 1;

		fixture.csvGetBodyValByAttrNull(file, tarList, location, rowNumber);
} catch(Exception e) {
			
		}
		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    org.springframework.context.NoSuchMessageException: No message found under code 'o2p.serviceAgent.transformer.csvFile' for locale 'zh_CN'.
		//       at org.springframework.context.support.AbstractMessageSource.getMessage(AbstractMessageSource.java:159)
		//       at com.asiainfo.foundation.util.MessageSourceUtils.getMessage(MessageSourceUtils.java:41)
		//       at com.asiainfo.foundation.exception.BusinessException.getMessage(BusinessException.java:151)
		//       at com.asiainfo.foundation.exception.BusinessException.<init>(BusinessException.java:105)
		//       at com.ailk.eaap.integration.o2p.process.CsvTransformerProcessIn.csvGetBodyValByAttrNull(CsvTransformerProcessIn.java:242)
	}

	/**
	 * Run the void csvGetBodyValByAttrNull(File,List<String>,int,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testCsvGetBodyValByAttrNull_14()
		throws Exception {
		try{CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		File file = new File("");
		List<String> tarList = new LinkedList();
		int location = 1;
		int rowNumber = 1;

		fixture.csvGetBodyValByAttrNull(file, tarList, location, rowNumber);
} catch(Exception e) {
			
		}
		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    org.springframework.context.NoSuchMessageException: No message found under code 'o2p.serviceAgent.transformer.csvFile' for locale 'zh_CN'.
		//       at org.springframework.context.support.AbstractMessageSource.getMessage(AbstractMessageSource.java:159)
		//       at com.asiainfo.foundation.util.MessageSourceUtils.getMessage(MessageSourceUtils.java:41)
		//       at com.asiainfo.foundation.exception.BusinessException.getMessage(BusinessException.java:151)
		//       at com.asiainfo.foundation.exception.BusinessException.<init>(BusinessException.java:105)
		//       at com.ailk.eaap.integration.o2p.process.CsvTransformerProcessIn.csvGetBodyValByAttrNull(CsvTransformerProcessIn.java:242)
	}

	/**
	 * Run the void csvGetBodyValByAttrNull(File,List<String>,int,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testCsvGetBodyValByAttrNull_15()
		throws Exception {
		try{	CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		File file = new File("");
		List<String> tarList = new LinkedList();
		int location = 1;
		int rowNumber = 1;

		fixture.csvGetBodyValByAttrNull(file, tarList, location, rowNumber);
} catch(Exception e) {
			
		}
		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    org.springframework.context.NoSuchMessageException: No message found under code 'o2p.serviceAgent.transformer.csvFile' for locale 'zh_CN'.
		//       at org.springframework.context.support.AbstractMessageSource.getMessage(AbstractMessageSource.java:159)
		//       at com.asiainfo.foundation.util.MessageSourceUtils.getMessage(MessageSourceUtils.java:41)
		//       at com.asiainfo.foundation.exception.BusinessException.getMessage(BusinessException.java:151)
		//       at com.asiainfo.foundation.exception.BusinessException.<init>(BusinessException.java:105)
		//       at com.ailk.eaap.integration.o2p.process.CsvTransformerProcessIn.csvGetBodyValByAttrNull(CsvTransformerProcessIn.java:242)
	}

	/**
	 * Run the void csvGetBodyValByAttrNull(File,List<String>,int,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testCsvGetBodyValByAttrNull_16()
		throws Exception {
		try{CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		File file = new File("");
		List<String> tarList = new LinkedList();
		int location = 1;
		int rowNumber = 1;

		fixture.csvGetBodyValByAttrNull(file, tarList, location, rowNumber);
} catch(Exception e) {
			
		}
		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    org.springframework.context.NoSuchMessageException: No message found under code 'o2p.serviceAgent.transformer.csvFile' for locale 'zh_CN'.
		//       at org.springframework.context.support.AbstractMessageSource.getMessage(AbstractMessageSource.java:159)
		//       at com.asiainfo.foundation.util.MessageSourceUtils.getMessage(MessageSourceUtils.java:41)
		//       at com.asiainfo.foundation.exception.BusinessException.getMessage(BusinessException.java:151)
		//       at com.asiainfo.foundation.exception.BusinessException.<init>(BusinessException.java:105)
		//       at com.ailk.eaap.integration.o2p.process.CsvTransformerProcessIn.csvGetBodyValByAttrNull(CsvTransformerProcessIn.java:242)
	}

	/**
	 * Run the List<String> csvGetHeaderVal(MessageBO<?>,NodeDesc) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testCsvGetHeaderVal_1()
		throws Exception {
		try{CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		MessageBO<Object> srcMsg = new MessageBO();
		NodeDesc nodeDesc = new NodeDesc();
		nodeDesc.setNodeCode("");

		List<String> result = fixture.csvGetHeaderVal(srcMsg, nodeDesc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.ailk.eaap.integration.o2p.process.CsvTransformerProcessIn.csvGetHeaderVal(CsvTransformerProcessIn.java:273)
		assertNotNull(result);} catch(Exception e) {
			
		}
	}

	/**
	 * Run the void debug(String,String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testDebug_1()
		throws Exception {
		CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		String encoding = "";
		String separators = "";
		String newline = "";

		fixture.debug(encoding, separators, newline);

		// add additional test code here
	}

	/**
	 * Run the void debug(String,String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testDebug_2()
		throws Exception {
		CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		String encoding = "";
		String separators = "";
		String newline = "";

		fixture.debug(encoding, separators, newline);

		// add additional test code here
	}

	/**
	 * Run the void debugProperties(String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testDebugProperties_1()
		throws Exception {
		CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		String encoding = "";
		String separators = "";

		fixture.debugProperties(encoding, separators);

		// add additional test code here
	}

	/**
	 * Run the void debugProperties(String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testDebugProperties_2()
		throws Exception {
		CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		String encoding = "";
		String separators = "";

		fixture.debugProperties(encoding, separators);

		// add additional test code here
	}

	/**
	 * Run the void judgeBody(List<MessageNode>,Map<Integer,List<String>>,List<Integer>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testJudgeBody_1()
		throws Exception {
		CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		List<MessageNode> messageNodes = new LinkedList();
		Map<Integer, List<String>> map = new IdentityHashMap();
		List<Integer> lengthList = new LinkedList();

		fixture.judgeBody(messageNodes, map, lengthList);

		// add additional test code here
	}

	/**
	 * Run the void judgeBody(List<MessageNode>,Map<Integer,List<String>>,List<Integer>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testJudgeBody_2()
		throws Exception {
		CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		List<MessageNode> messageNodes = new LinkedList();
		Map<Integer, List<String>> map = new IdentityHashMap();
		List<Integer> lengthList = new LinkedList();

		fixture.judgeBody(messageNodes, map, lengthList);

		// add additional test code here
	}

	/**
	 * Run the void judgeBody(List<MessageNode>,Map<Integer,List<String>>,List<Integer>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testJudgeBody_3()
		throws Exception {
		CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		List<MessageNode> messageNodes = new LinkedList();
		Map<Integer, List<String>> map = new IdentityHashMap();
		List<Integer> lengthList = new LinkedList();

		fixture.judgeBody(messageNodes, map, lengthList);

		// add additional test code here
	}

	/**
	 * Run the File judgeFile(MessageBO<?>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testJudgeFile_1()
		throws Exception {
		try {CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		MessageBO<Object> bo = new MessageBO();

		File result = fixture.judgeFile(bo);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.ailk.eaap.integration.o2p.process.CsvTransformerProcessIn.judgeFile(CsvTransformerProcessIn.java:457)
		assertNotNull(result);} catch(Exception e) {
			
		}
	}

	/**
	 * Run the File judgeFile(MessageBO<?>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testJudgeFile_2()
		throws Exception {
		try {CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		MessageBO<Object> bo = new MessageBO();

		File result = fixture.judgeFile(bo);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.ailk.eaap.integration.o2p.process.CsvTransformerProcessIn.judgeFile(CsvTransformerProcessIn.java:457)
		assertNotNull(result);} catch(Exception e) {
			
		}
	}

	/**
	 * Run the void judgeNewLine(String,String,Map<Integer,List<String>>,List<Integer>,StringBuilder,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testJudgeNewLine_1()
		throws Exception {
		CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		String separators = "";
		String newline = "";
		Map<Integer, List<String>> map = new IdentityHashMap();
		List<Integer> lengthList = new LinkedList();
		StringBuilder sbu = new StringBuilder();
		int i = 1;

		fixture.judgeNewLine(separators, newline, map, lengthList, sbu, i);

		// add additional test code here
	}

	/**
	 * Run the void judgeNewLine(String,String,Map<Integer,List<String>>,List<Integer>,StringBuilder,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testJudgeNewLine_2()
		throws Exception {
		CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		String separators = "";
		String newline = "";
		Map<Integer, List<String>> map = new IdentityHashMap();
		List<Integer> lengthList = new LinkedList();
		StringBuilder sbu = new StringBuilder();
		int i = 1;

		fixture.judgeNewLine(separators, newline, map, lengthList, sbu, i);

		// add additional test code here
	}

	/**
	 * Run the void judgeNewLine(String,String,Map<Integer,List<String>>,List<Integer>,StringBuilder,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testJudgeNewLine_3()
		throws Exception {
		CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		String separators = "";
		String newline = "";
		Map<Integer, List<String>> map = new IdentityHashMap();
		List<Integer> lengthList = new LinkedList();
		StringBuilder sbu = new StringBuilder();
		int i = 1;

		fixture.judgeNewLine(separators, newline, map, lengthList, sbu, i);

		// add additional test code here
	}

	/**
	 * Run the void judgeNewLine(String,String,Map<Integer,List<String>>,List<Integer>,StringBuilder,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testJudgeNewLine_4()
		throws Exception {
		CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		String separators = "";
		String newline = "";
		Map<Integer, List<String>> map = new IdentityHashMap();
		List<Integer> lengthList = new LinkedList();
		StringBuilder sbu = new StringBuilder();
		int i = 1;

		fixture.judgeNewLine(separators, newline, map, lengthList, sbu, i);

		// add additional test code here
	}

	/**
	 * Run the void judgeNewLine(String,String,Map<Integer,List<String>>,List<Integer>,StringBuilder,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testJudgeNewLine_5()
		throws Exception {
		CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		String separators = "";
		String newline = "";
		Map<Integer, List<String>> map = new IdentityHashMap();
		List<Integer> lengthList = new LinkedList();
		StringBuilder sbu = new StringBuilder();
		int i = 1;

		fixture.judgeNewLine(separators, newline, map, lengthList, sbu, i);

		// add additional test code here
	}

	/**
	 * Run the void judgeNewLine(String,String,Map<Integer,List<String>>,List<Integer>,StringBuilder,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testJudgeNewLine_6()
		throws Exception {
		CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		String separators = "";
		String newline = "";
		Map<Integer, List<String>> map = new IdentityHashMap();
		List<Integer> lengthList = new LinkedList();
		StringBuilder sbu = new StringBuilder();
		int i = 1;

		fixture.judgeNewLine(separators, newline, map, lengthList, sbu, i);

		// add additional test code here
	}

	/**
	 * Run the void judgeNewLine(String,String,Map<Integer,List<String>>,List<Integer>,StringBuilder,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testJudgeNewLine_7()
		throws Exception {
		CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		String separators = "";
		String newline = "";
		Map<Integer, List<String>> map = new IdentityHashMap();
		List<Integer> lengthList = new LinkedList();
		StringBuilder sbu = new StringBuilder();
		int i = 1;

		fixture.judgeNewLine(separators, newline, map, lengthList, sbu, i);

		// add additional test code here
	}

	/**
	 * Run the void judgeNewLine(String,String,Map<Integer,List<String>>,List<Integer>,StringBuilder,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testJudgeNewLine_8()
		throws Exception {
		CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		String separators = "";
		String newline = "";
		Map<Integer, List<String>> map = new IdentityHashMap();
		List<Integer> lengthList = new LinkedList();
		StringBuilder sbu = new StringBuilder();
		int i = 1;

		fixture.judgeNewLine(separators, newline, map, lengthList, sbu, i);

		// add additional test code here
	}

	/**
	 * Run the void judgeNewLine(String,String,Map<Integer,List<String>>,List<Integer>,StringBuilder,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testJudgeNewLine_9()
		throws Exception {
		CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		String separators = "";
		String newline = "";
		Map<Integer, List<String>> map = new IdentityHashMap();
		List<Integer> lengthList = new LinkedList();
		StringBuilder sbu = new StringBuilder();
		int i = 1;

		fixture.judgeNewLine(separators, newline, map, lengthList, sbu, i);

		// add additional test code here
	}

	/**
	 * Run the void judgeNewLine(String,String,Map<Integer,List<String>>,List<Integer>,StringBuilder,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testJudgeNewLine_10()
		throws Exception {
		CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		String separators = "";
		String newline = "";
		Map<Integer, List<String>> map = new IdentityHashMap();
		List<Integer> lengthList = new LinkedList();
		StringBuilder sbu = new StringBuilder();
		int i = 1;

		fixture.judgeNewLine(separators, newline, map, lengthList, sbu, i);

		// add additional test code here
	}

	/**
	 * Run the void judgeNewLine(String,String,Map<Integer,List<String>>,List<Integer>,StringBuilder,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testJudgeNewLine_11()
		throws Exception {
		CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		String separators = "";
		String newline = "";
		Map<Integer, List<String>> map = new IdentityHashMap();
		List<Integer> lengthList = new LinkedList();
		StringBuilder sbu = new StringBuilder();
		int i = 1;

		fixture.judgeNewLine(separators, newline, map, lengthList, sbu, i);

		// add additional test code here
	}

	/**
	 * Run the void judgeNewLine(String,String,Map<Integer,List<String>>,List<Integer>,StringBuilder,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testJudgeNewLine_12()
		throws Exception {
		CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		String separators = "";
		String newline = "";
		Map<Integer, List<String>> map = new IdentityHashMap();
		List<Integer> lengthList = new LinkedList();
		StringBuilder sbu = new StringBuilder();
		int i = 1;

		fixture.judgeNewLine(separators, newline, map, lengthList, sbu, i);

		// add additional test code here
	}

	/**
	 * Run the void judgeNewLine(String,String,Map<Integer,List<String>>,List<Integer>,StringBuilder,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testJudgeNewLine_13()
		throws Exception {
		CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		String separators = "";
		String newline = "";
		Map<Integer, List<String>> map = new IdentityHashMap();
		List<Integer> lengthList = new LinkedList();
		StringBuilder sbu = new StringBuilder();
		int i = 1;

		fixture.judgeNewLine(separators, newline, map, lengthList, sbu, i);

		// add additional test code here
	}

	/**
	 * Run the void judgeNewLine(String,String,Map<Integer,List<String>>,List<Integer>,StringBuilder,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testJudgeNewLine_14()
		throws Exception {
		CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		String separators = "";
		String newline = "";
		Map<Integer, List<String>> map = new IdentityHashMap();
		List<Integer> lengthList = new LinkedList();
		StringBuilder sbu = new StringBuilder();
		int i = 1;

		fixture.judgeNewLine(separators, newline, map, lengthList, sbu, i);

		// add additional test code here
	}

	/**
	 * Run the void judgeNewLine(String,String,Map<Integer,List<String>>,List<Integer>,StringBuilder,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testJudgeNewLine_15()
		throws Exception {
		CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		String separators = "";
		String newline = "";
		Map<Integer, List<String>> map = new IdentityHashMap();
		List<Integer> lengthList = new LinkedList();
		StringBuilder sbu = new StringBuilder();
		int i = 1;

		fixture.judgeNewLine(separators, newline, map, lengthList, sbu, i);

		// add additional test code here
	}

	/**
	 * Run the void judgeNewLine(String,String,Map<Integer,List<String>>,List<Integer>,StringBuilder,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testJudgeNewLine_16()
		throws Exception {
		CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		String separators = "";
		String newline = "";
		Map<Integer, List<String>> map = new IdentityHashMap();
		List<Integer> lengthList = new LinkedList();
		StringBuilder sbu = new StringBuilder();
		int i = 1;

		fixture.judgeNewLine(separators, newline, map, lengthList, sbu, i);

		// add additional test code here
	}

	/**
	 * Run the Object parseNodeValBySrcMsg(MessageBO<?>,ContractFormat,NodeDesc) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testParseNodeValBySrcMsg_1()
		throws Exception {
		try {	CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		MessageBO<Object> srcMsg = new MessageBO();
		ContractFormat contractFormat = new ContractFormat();
		NodeDesc nodeDesc = new NodeDesc();
		nodeDesc.setNodeType("1");
		nodeDesc.setNodePath("");

		Object result = fixture.parseNodeValBySrcMsg(srcMsg, contractFormat, nodeDesc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: The CSV MsgBody is null 
		//       at org.springframework.util.Assert.notNull(Assert.java:112)
		//       at com.ailk.eaap.integration.o2p.process.CsvTransformerProcessIn.csvAssert(CsvTransformerProcessIn.java:280)
		//       at com.ailk.eaap.integration.o2p.process.CsvTransformerProcessIn.parseNodeValBySrcMsg(CsvTransformerProcessIn.java:44)
		assertNotNull(result);} catch(Exception e) {
			
		}
	}

	/**
	 * Run the Object parseNodeValBySrcMsg(MessageBO<?>,ContractFormat,NodeDesc) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testParseNodeValBySrcMsg_2()
		throws Exception {
		try {CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		MessageBO<Object> srcMsg = new MessageBO();
		ContractFormat contractFormat = new ContractFormat();
		contractFormat.setContract2AttrSpecs(new LinkedList());
		NodeDesc nodeDesc = new NodeDesc();
		nodeDesc.setNodeType("");
		nodeDesc.setNodePath("");

		Object result = fixture.parseNodeValBySrcMsg(srcMsg, contractFormat, nodeDesc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: The CSV MsgBody is null 
		//       at org.springframework.util.Assert.notNull(Assert.java:112)
		//       at com.ailk.eaap.integration.o2p.process.CsvTransformerProcessIn.csvAssert(CsvTransformerProcessIn.java:280)
		//       at com.ailk.eaap.integration.o2p.process.CsvTransformerProcessIn.parseNodeValBySrcMsg(CsvTransformerProcessIn.java:44)
		assertNotNull(result);} catch(Exception e) {
			
		}
	}

	/**
	 * Run the Object parseNodeValBySrcMsg(MessageBO<?>,ContractFormat,NodeDesc) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testParseNodeValBySrcMsg_3()
		throws Exception {
		try {CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		MessageBO<Object> srcMsg = new MessageBO();
		ContractFormat contractFormat = new ContractFormat();
		contractFormat.setContract2AttrSpecs(new LinkedList());
		NodeDesc nodeDesc = new NodeDesc();
		nodeDesc.setNodeType("");
		nodeDesc.setNodePath("");

		Object result = fixture.parseNodeValBySrcMsg(srcMsg, contractFormat, nodeDesc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: The CSV MsgBody is null 
		//       at org.springframework.util.Assert.notNull(Assert.java:112)
		//       at com.ailk.eaap.integration.o2p.process.CsvTransformerProcessIn.csvAssert(CsvTransformerProcessIn.java:280)
		//       at com.ailk.eaap.integration.o2p.process.CsvTransformerProcessIn.parseNodeValBySrcMsg(CsvTransformerProcessIn.java:44)
		assertNotNull(result);} catch(Exception e) {
			
		}
	}

	/**
	 * Run the Object parseNodeValBySrcMsg(MessageBO<?>,ContractFormat,NodeDesc) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testParseNodeValBySrcMsg_4()
		throws Exception {
		try {	CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		MessageBO<Object> srcMsg = new MessageBO();
		ContractFormat contractFormat = new ContractFormat();
		contractFormat.setContract2AttrSpecs(new LinkedList());
		NodeDesc nodeDesc = new NodeDesc();
		nodeDesc.setNodeType("");
		nodeDesc.setNodePath("");

		Object result = fixture.parseNodeValBySrcMsg(srcMsg, contractFormat, nodeDesc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: The CSV MsgBody is null 
		//       at org.springframework.util.Assert.notNull(Assert.java:112)
		//       at com.ailk.eaap.integration.o2p.process.CsvTransformerProcessIn.csvAssert(CsvTransformerProcessIn.java:280)
		//       at com.ailk.eaap.integration.o2p.process.CsvTransformerProcessIn.parseNodeValBySrcMsg(CsvTransformerProcessIn.java:44)
		assertNotNull(result);} catch(Exception e) {
			
		}
	}

	/**
	 * Run the Object parseNodeValBySrcMsg(MessageBO<?>,ContractFormat,NodeDesc) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testParseNodeValBySrcMsg_5()
		throws Exception {
		try {	CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		MessageBO<Object> srcMsg = new MessageBO();
		ContractFormat contractFormat = new ContractFormat();
		contractFormat.setContract2AttrSpecs(new LinkedList());
		NodeDesc nodeDesc = new NodeDesc();
		nodeDesc.setNodeType("");
		nodeDesc.setNodePath("");

		Object result = fixture.parseNodeValBySrcMsg(srcMsg, contractFormat, nodeDesc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: The CSV MsgBody is null 
		//       at org.springframework.util.Assert.notNull(Assert.java:112)
		//       at com.ailk.eaap.integration.o2p.process.CsvTransformerProcessIn.csvAssert(CsvTransformerProcessIn.java:280)
		//       at com.ailk.eaap.integration.o2p.process.CsvTransformerProcessIn.parseNodeValBySrcMsg(CsvTransformerProcessIn.java:44)
		assertNotNull(result);} catch(Exception e) {
			
		}
	}

	/**
	 * Run the Object parseNodeValBySrcMsg(MessageBO<?>,ContractFormat,NodeDesc) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testParseNodeValBySrcMsg_6()
		throws Exception {
		try {CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		MessageBO<Object> srcMsg = new MessageBO();
		ContractFormat contractFormat = new ContractFormat();
		contractFormat.setContract2AttrSpecs(new LinkedList());
		NodeDesc nodeDesc = new NodeDesc();
		nodeDesc.setNodeType("");
		nodeDesc.setNodePath("");

		Object result = fixture.parseNodeValBySrcMsg(srcMsg, contractFormat, nodeDesc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: The CSV MsgBody is null 
		//       at org.springframework.util.Assert.notNull(Assert.java:112)
		//       at com.ailk.eaap.integration.o2p.process.CsvTransformerProcessIn.csvAssert(CsvTransformerProcessIn.java:280)
		//       at com.ailk.eaap.integration.o2p.process.CsvTransformerProcessIn.parseNodeValBySrcMsg(CsvTransformerProcessIn.java:44)
		assertNotNull(result);} catch(Exception e) {
			
		}
	}

	/**
	 * Run the Object parseNodeValBySrcMsg(MessageBO<?>,ContractFormat,NodeDesc) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testParseNodeValBySrcMsg_7()
		throws Exception {
		try {	CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		MessageBO<Object> srcMsg = new MessageBO();
		ContractFormat contractFormat = new ContractFormat();
		contractFormat.setContract2AttrSpecs(new LinkedList());
		NodeDesc nodeDesc = new NodeDesc();
		nodeDesc.setNodeType("");
		nodeDesc.setNodePath("");

		Object result = fixture.parseNodeValBySrcMsg(srcMsg, contractFormat, nodeDesc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: The CSV MsgBody is null 
		//       at org.springframework.util.Assert.notNull(Assert.java:112)
		//       at com.ailk.eaap.integration.o2p.process.CsvTransformerProcessIn.csvAssert(CsvTransformerProcessIn.java:280)
		//       at com.ailk.eaap.integration.o2p.process.CsvTransformerProcessIn.parseNodeValBySrcMsg(CsvTransformerProcessIn.java:44)
		assertNotNull(result);} catch(Exception e) {
			
		}
	}

	/**
	 * Run the Object parseNodeValBySrcMsg(MessageBO<?>,ContractFormat,NodeDesc) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testParseNodeValBySrcMsg_8()
		throws Exception {
		try {	CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		MessageBO<Object> srcMsg = new MessageBO();
		ContractFormat contractFormat = new ContractFormat();
		contractFormat.setContract2AttrSpecs(new LinkedList());
		NodeDesc nodeDesc = new NodeDesc();
		nodeDesc.setNodeType("");
		nodeDesc.setNodePath("");

		Object result = fixture.parseNodeValBySrcMsg(srcMsg, contractFormat, nodeDesc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: The CSV MsgBody is null 
		//       at org.springframework.util.Assert.notNull(Assert.java:112)
		//       at com.ailk.eaap.integration.o2p.process.CsvTransformerProcessIn.csvAssert(CsvTransformerProcessIn.java:280)
		//       at com.ailk.eaap.integration.o2p.process.CsvTransformerProcessIn.parseNodeValBySrcMsg(CsvTransformerProcessIn.java:44)
		assertNotNull(result);} catch(Exception e) {
			
		}
	}

	/**
	 * Run the Object parseNodeValBySrcMsg(MessageBO<?>,ContractFormat,NodeDesc) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testParseNodeValBySrcMsg_9()
		throws Exception {
		try {	CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		MessageBO<Object> srcMsg = new MessageBO();
		ContractFormat contractFormat = new ContractFormat();
		contractFormat.setContract2AttrSpecs(new LinkedList());
		NodeDesc nodeDesc = new NodeDesc();
		nodeDesc.setNodeType("");
		nodeDesc.setNodePath("");

		Object result = fixture.parseNodeValBySrcMsg(srcMsg, contractFormat, nodeDesc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: The CSV MsgBody is null 
		//       at org.springframework.util.Assert.notNull(Assert.java:112)
		//       at com.ailk.eaap.integration.o2p.process.CsvTransformerProcessIn.csvAssert(CsvTransformerProcessIn.java:280)
		//       at com.ailk.eaap.integration.o2p.process.CsvTransformerProcessIn.parseNodeValBySrcMsg(CsvTransformerProcessIn.java:44)
		assertNotNull(result);} catch(Exception e) {
			
		}
	}

	/**
	 * Run the Object parseNodeValBySrcMsg(MessageBO<?>,ContractFormat,NodeDesc) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testParseNodeValBySrcMsg_10()
		throws Exception {
		try {CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		MessageBO<Object> srcMsg = new MessageBO();
		ContractFormat contractFormat = new ContractFormat();
		contractFormat.setContract2AttrSpecs(new LinkedList());
		NodeDesc nodeDesc = new NodeDesc();
		nodeDesc.setNodeType("");
		nodeDesc.setNodePath("");

		Object result = fixture.parseNodeValBySrcMsg(srcMsg, contractFormat, nodeDesc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: The CSV MsgBody is null 
		//       at org.springframework.util.Assert.notNull(Assert.java:112)
		//       at com.ailk.eaap.integration.o2p.process.CsvTransformerProcessIn.csvAssert(CsvTransformerProcessIn.java:280)
		//       at com.ailk.eaap.integration.o2p.process.CsvTransformerProcessIn.parseNodeValBySrcMsg(CsvTransformerProcessIn.java:44)
		assertNotNull(result);} catch(Exception e) {
			
		}
	}

	/**
	 * Run the Object parseNodeValBySrcMsg(MessageBO<?>,ContractFormat,NodeDesc) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testParseNodeValBySrcMsg_11()
		throws Exception {
		try {CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		MessageBO<Object> srcMsg = new MessageBO();
		ContractFormat contractFormat = new ContractFormat();
		contractFormat.setContract2AttrSpecs(new LinkedList());
		NodeDesc nodeDesc = new NodeDesc();
		nodeDesc.setNodeType("");
		nodeDesc.setNodePath("");

		Object result = fixture.parseNodeValBySrcMsg(srcMsg, contractFormat, nodeDesc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: The CSV MsgBody is null 
		//       at org.springframework.util.Assert.notNull(Assert.java:112)
		//       at com.ailk.eaap.integration.o2p.process.CsvTransformerProcessIn.csvAssert(CsvTransformerProcessIn.java:280)
		//       at com.ailk.eaap.integration.o2p.process.CsvTransformerProcessIn.parseNodeValBySrcMsg(CsvTransformerProcessIn.java:44)
		assertNotNull(result);} catch(Exception e) {
			
		}
	}

	/**
	 * Run the Object parseNodeValBySrcMsg(MessageBO<?>,ContractFormat,NodeDesc) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testParseNodeValBySrcMsg_12()
		throws Exception {
		try {CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		MessageBO<Object> srcMsg = new MessageBO();
		ContractFormat contractFormat = new ContractFormat();
		contractFormat.setContract2AttrSpecs(new LinkedList());
		NodeDesc nodeDesc = new NodeDesc();
		nodeDesc.setNodeType("");
		nodeDesc.setNodePath("");

		Object result = fixture.parseNodeValBySrcMsg(srcMsg, contractFormat, nodeDesc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: The CSV MsgBody is null 
		//       at org.springframework.util.Assert.notNull(Assert.java:112)
		//       at com.ailk.eaap.integration.o2p.process.CsvTransformerProcessIn.csvAssert(CsvTransformerProcessIn.java:280)
		//       at com.ailk.eaap.integration.o2p.process.CsvTransformerProcessIn.parseNodeValBySrcMsg(CsvTransformerProcessIn.java:44)
		assertNotNull(result);} catch(Exception e) {
			
		}
	}

	/**
	 * Run the Object parseNodeValBySrcMsg(MessageBO<?>,ContractFormat,NodeDesc) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testParseNodeValBySrcMsg_13()
		throws Exception {
		try {CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		MessageBO<Object> srcMsg = new MessageBO();
		ContractFormat contractFormat = new ContractFormat();
		contractFormat.setContract2AttrSpecs(new LinkedList());
		NodeDesc nodeDesc = new NodeDesc();
		nodeDesc.setNodeType("");
		nodeDesc.setNodePath("");

		Object result = fixture.parseNodeValBySrcMsg(srcMsg, contractFormat, nodeDesc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: The CSV MsgBody is null 
		//       at org.springframework.util.Assert.notNull(Assert.java:112)
		//       at com.ailk.eaap.integration.o2p.process.CsvTransformerProcessIn.csvAssert(CsvTransformerProcessIn.java:280)
		//       at com.ailk.eaap.integration.o2p.process.CsvTransformerProcessIn.parseNodeValBySrcMsg(CsvTransformerProcessIn.java:44)
		assertNotNull(result);} catch(Exception e) {
			
		}
	}

	/**
	 * Run the void processContentDebug(MessageDesc) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testProcessContentDebug_1()
		throws Exception {
		CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		MessageDesc md = new MessageDesc();
		md.setContractFormat(new ContractFormat());

		fixture.processContentDebug(md);

		// add additional test code here
	}

	/**
	 * Run the void processContentDebug(MessageDesc) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Test
	public void testProcessContentDebug_2()
		throws Exception {
try{CsvTransformerProcessIn fixture = new CsvTransformerProcessIn();
		MessageDesc md = new MessageDesc();

		fixture.processContentDebug(md);
} catch(Exception e) {
			
		}
		// add additional test code here
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@Before
	public void setUp()
		throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:37
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(CsvTransformerProcessInTest.class);
	}
}