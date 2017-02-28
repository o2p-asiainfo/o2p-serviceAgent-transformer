package com.ailk.eaap.integration.o2p.model;

import java.io.IOException;
import java.io.PipedReader;
import java.io.Reader;
import java.util.LinkedList;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>BufferedReaderExtTest</code> contains tests for the class <code>{@link BufferedReaderExt}</code>.
 *
 * @generatedBy CodePro at 15-12-16 下午2:35
 * @author wuwz
 * @version $Revision: 1.0 $
 */
public class BufferedReaderExtTest {
	/**
	 * Run the BufferedReaderExt(Reader) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test
	public void testBufferedReaderExt_1()
		throws Exception {
		Reader in = new PipedReader();

		BufferedReaderExt result = new BufferedReaderExt(in);

		// add additional test code here
		assertNotNull(result);
		assertEquals(true, result.markSupported());
		assertEquals('\n', result.getOperator());
		assertEquals('\r', result.getOperator2());
		assertEquals(',', result.getSplit());
	}

	/**
	 * Run the BufferedReaderExt(Reader,char) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test
	public void testBufferedReaderExt_2()
		throws Exception {
		Reader in = new PipedReader();
		char operator = '';

		BufferedReaderExt result = new BufferedReaderExt(in, operator);

		// add additional test code here
		assertNotNull(result);
		assertEquals(true, result.markSupported());
		assertEquals('', result.getOperator());
		assertEquals('\r', result.getOperator2());
		assertEquals(',', result.getSplit());
	}

	/**
	 * Run the BufferedReaderExt(Reader,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test
	public void testBufferedReaderExt_3()
		throws Exception {
		Reader in = new PipedReader();
		int sz = 1;

		BufferedReaderExt result = new BufferedReaderExt(in, sz);

		// add additional test code here
		assertNotNull(result);
		assertEquals(true, result.markSupported());
		assertEquals('\n', result.getOperator());
		assertEquals('\r', result.getOperator2());
		assertEquals(',', result.getSplit());
	}

	/**
	 * Run the BufferedReaderExt(Reader,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testBufferedReaderExt_4()
		throws Exception {
		Reader in = new PipedReader();
		int sz = 0;

		BufferedReaderExt result = new BufferedReaderExt(in, sz);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the BufferedReaderExt(Reader,char,String) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test
	public void testBufferedReaderExt_5()
		throws Exception {
		Reader in = new PipedReader();
		char operator = '';
		String split = "aa";

		BufferedReaderExt result = new BufferedReaderExt(in, operator, split);

		// add additional test code here
		assertNotNull(result);
		assertEquals(true, result.markSupported());
		assertEquals('', result.getOperator());
		assertEquals('\r', result.getOperator2());
		assertEquals('a', result.getSplit());
	}

	/**
	 * Run the boolean beSplitBoolean(List<String>,StringBuffer,int,int,List<String>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test
	public void testBeSplitBoolean_1()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		List<String> list = new LinkedList();
		StringBuffer st = new StringBuffer();
		int i = 1;
		int begin = 1;
		List<String> vals = new LinkedList();

		boolean result = fixture.beSplitBoolean(list, st, i, begin, vals);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean beSplitBoolean(List<String>,StringBuffer,int,int,List<String>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test
	public void testBeSplitBoolean_2()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		List<String> list = new LinkedList();
		StringBuffer st = new StringBuffer();
		int i = 1;
		int begin = 1;
		List<String> vals = new LinkedList();

		boolean result = fixture.beSplitBoolean(list, st, i, begin, vals);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean beSplitBoolean(List<String>,StringBuffer,int,int,List<String>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test
	public void testBeSplitBoolean_3()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		List<String> list = null;
		StringBuffer st = new StringBuffer();
		int i = 1;
		int begin = 1;
		List<String> vals = new LinkedList();

		boolean result = fixture.beSplitBoolean(list, st, i, begin, vals);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean beSplitBoolean3(List<String>,StringBuffer,int,int,List<String>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test
	public void testBeSplitBoolean3_1()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		List<String> list = null;
		StringBuffer st = new StringBuffer();
		int i = 1;
		int begin = 1;
		List<String> vals = new LinkedList();

		boolean result = fixture.beSplitBoolean3(list, st, i, begin, vals);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean beSplitBoolean3(List<String>,StringBuffer,int,int,List<String>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test
	public void testBeSplitBoolean3_2()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		List<String> list = new LinkedList();
		StringBuffer st = new StringBuffer();
		int i = 1;
		int begin = 1;
		List<String> vals = new LinkedList();

		boolean result = fixture.beSplitBoolean3(list, st, i, begin, vals);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean beSplitBoolean3(List<String>,StringBuffer,int,int,List<String>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test
	public void testBeSplitBoolean3_3()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		List<String> list = new LinkedList();
		StringBuffer st = new StringBuffer();
		int i = 1;
		int begin = 1;
		List<String> vals = new LinkedList();

		boolean result = fixture.beSplitBoolean3(list, st, i, begin, vals);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the void close() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test
	public void testClose_1()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt((Reader) null, 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');

		fixture.close();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at java.io.Reader.<init>(Reader.java:61)
		//       at com.ailk.eaap.integration.o2p.model.BufferedReaderExt.<init>(BufferedReaderExt.java:80)
	}

	/**
	 * Run the void close() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test
	public void testClose_2()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');

		fixture.close();

		// add additional test code here
	}

	/**
	 * Run the void close() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test
	public void testClose_3()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');

		fixture.close();

		// add additional test code here
	}

	/**
	 * Run the char getOperator() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test
	public void testGetOperator_1()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');

		char result = fixture.getOperator();

		// add additional test code here
		assertEquals('', result);
	}

	/**
	 * Run the char getOperator2() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test
	public void testGetOperator2_1()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');

		char result = fixture.getOperator2();

		// add additional test code here
		assertEquals('', result);
	}

	/**
	 * Run the char getSplit() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test
	public void testGetSplit_1()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');

		char result = fixture.getSplit();

		// add additional test code here
		assertEquals('', result);
	}

	/**
	 * Run the List<String> judgeList(List<String>,StringBuffer) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test
	public void testJudgeList_1()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		List<String> list = new LinkedList();
		StringBuffer st = new StringBuffer();

		List<String> result = fixture.judgeList(list, st);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the List<String> judgeList(List<String>,StringBuffer) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test
	public void testJudgeList_2()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		List<String> list = null;
		StringBuffer st = new StringBuffer();

		List<String> result = fixture.judgeList(list, st);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the List<String> judgeList(List<String>,StringBuffer) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test
	public void testJudgeList_3()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		List<String> list = new LinkedList();
		StringBuffer st = new StringBuffer();

		List<String> result = fixture.judgeList(list, st);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the void mark(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test
	public void testMark_1()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		int readAheadLimit = 1;

		fixture.mark(readAheadLimit);

		// add additional test code here
	}

	/**
	 * Run the void mark(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test
	public void testMark_2()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		int readAheadLimit = 1;

		fixture.mark(readAheadLimit);

		// add additional test code here
	}

	/**
	 * Run the void mark(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testMark_3()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		int readAheadLimit = -1;

		fixture.mark(readAheadLimit);

		// add additional test code here
	}

	/**
	 * Run the boolean markSupported() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test
	public void testMarkSupported_1()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');

		boolean result = fixture.markSupported();

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the int read() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.io.IOException.class)
	public void testRead_1()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');

		int result = fixture.read();

		// add additional test code here
		assertEquals(0, result);
	}

	/**
	 * Run the int read() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.io.IOException.class)
	public void testRead_2()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');

		int result = fixture.read();

		// add additional test code here
		assertEquals(0, result);
	}

	/**
	 * Run the int read() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.io.IOException.class)
	public void testRead_3()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');

		int result = fixture.read();

		// add additional test code here
		assertEquals(0, result);
	}

	/**
	 * Run the int read() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.io.IOException.class)
	public void testRead_4()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');

		int result = fixture.read();

		// add additional test code here
		assertEquals(0, result);
	}

	/**
	 * Run the int read() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.io.IOException.class)
	public void testRead_5()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');

		int result = fixture.read();

		// add additional test code here
		assertEquals(0, result);
	}

	/**
	 * Run the int read() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.io.IOException.class)
	public void testRead_6()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');

		int result = fixture.read();

		// add additional test code here
		assertEquals(0, result);
	}

	/**
	 * Run the int read() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.io.IOException.class)
	public void testRead_7()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');

		int result = fixture.read();

		// add additional test code here
		assertEquals(0, result);
	}

	/**
	 * Run the int read(char[],int,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test
	public void testRead_8()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		char[] cbuf = new char[] {};
		int off = 1;
		int len = 0;

		int result = fixture.read(cbuf, off, len);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IndexOutOfBoundsException
		//       at com.ailk.eaap.integration.o2p.model.BufferedReaderExt.read(BufferedReaderExt.java:346)
		assertEquals(0, result);
	}

	/**
	 * Run the int read(char[],int,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test
	public void testRead_9()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		char[] cbuf = new char[] {};
		int off = 1;
		int len = 1;

		int result = fixture.read(cbuf, off, len);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IndexOutOfBoundsException
		//       at com.ailk.eaap.integration.o2p.model.BufferedReaderExt.read(BufferedReaderExt.java:346)
		assertEquals(0, result);
	}

	/**
	 * Run the int read(char[],int,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test
	public void testRead_10()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		char[] cbuf = new char[] {};
		int off = 1;
		int len = 1;

		int result = fixture.read(cbuf, off, len);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IndexOutOfBoundsException
		//       at com.ailk.eaap.integration.o2p.model.BufferedReaderExt.read(BufferedReaderExt.java:346)
		assertEquals(0, result);
	}

	/**
	 * Run the int read(char[],int,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test
	public void testRead_11()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		char[] cbuf = new char[] {};
		int off = 1;
		int len = 2;

		int result = fixture.read(cbuf, off, len);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IndexOutOfBoundsException
		//       at com.ailk.eaap.integration.o2p.model.BufferedReaderExt.read(BufferedReaderExt.java:346)
		assertEquals(0, result);
	}

	/**
	 * Run the int read(char[],int,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test
	public void testRead_12()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		char[] cbuf = new char[] {};
		int off = 1;
		int len = 2;

		int result = fixture.read(cbuf, off, len);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IndexOutOfBoundsException
		//       at com.ailk.eaap.integration.o2p.model.BufferedReaderExt.read(BufferedReaderExt.java:346)
		assertEquals(0, result);
	}

	/**
	 * Run the int read(char[],int,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test
	public void testRead_13()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		char[] cbuf = new char[] {};
		int off = 1;
		int len = 2;

		int result = fixture.read(cbuf, off, len);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IndexOutOfBoundsException
		//       at com.ailk.eaap.integration.o2p.model.BufferedReaderExt.read(BufferedReaderExt.java:346)
		assertEquals(0, result);
	}

	/**
	 * Run the int read(char[],int,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test
	public void testRead_14()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		char[] cbuf = new char[] {};
		int off = 1;
		int len = 2;

		int result = fixture.read(cbuf, off, len);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IndexOutOfBoundsException
		//       at com.ailk.eaap.integration.o2p.model.BufferedReaderExt.read(BufferedReaderExt.java:346)
		assertEquals(0, result);
	}

	/**
	 * Run the int read(char[],int,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test
	public void testRead_15()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		char[] cbuf = new char[] {};
		int off = 1;
		int len = 2;

		int result = fixture.read(cbuf, off, len);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IndexOutOfBoundsException
		//       at com.ailk.eaap.integration.o2p.model.BufferedReaderExt.read(BufferedReaderExt.java:346)
		assertEquals(0, result);
	}

	/**
	 * Run the int read(char[],int,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test
	public void testRead_16()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		char[] cbuf = new char[] {};
		int off = 1;
		int len = 1;

		int result = fixture.read(cbuf, off, len);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IndexOutOfBoundsException
		//       at com.ailk.eaap.integration.o2p.model.BufferedReaderExt.read(BufferedReaderExt.java:346)
		assertEquals(0, result);
	}

	/**
	 * Run the int read(char[],int,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test
	public void testRead_17()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		char[] cbuf = new char[] {};
		int off = 1;
		int len = 2;

		int result = fixture.read(cbuf, off, len);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IndexOutOfBoundsException
		//       at com.ailk.eaap.integration.o2p.model.BufferedReaderExt.read(BufferedReaderExt.java:346)
		assertEquals(0, result);
	}

	/**
	 * Run the int read(char[],int,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test
	public void testRead_18()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		char[] cbuf = new char[] {};
		int off = 1;
		int len = 2;

		int result = fixture.read(cbuf, off, len);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IndexOutOfBoundsException
		//       at com.ailk.eaap.integration.o2p.model.BufferedReaderExt.read(BufferedReaderExt.java:346)
		assertEquals(0, result);
	}

	/**
	 * Run the int read(char[],int,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.lang.IndexOutOfBoundsException.class)
	public void testRead_19()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		char[] cbuf = new char[] {};
		int off = -1;
		int len = 1;

		int result = fixture.read(cbuf, off, len);

		// add additional test code here
		assertEquals(0, result);
	}

	/**
	 * Run the int read(char[],int,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.lang.IndexOutOfBoundsException.class)
	public void testRead_20()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		char[] cbuf = new char[] {};
		int off = 1;
		int len = 1;

		int result = fixture.read(cbuf, off, len);

		// add additional test code here
		assertEquals(0, result);
	}

	/**
	 * Run the int read(char[],int,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.lang.IndexOutOfBoundsException.class)
	public void testRead_21()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		char[] cbuf = new char[] {};
		int off = 1;
		int len = -1;

		int result = fixture.read(cbuf, off, len);

		// add additional test code here
		assertEquals(0, result);
	}

	/**
	 * Run the int read(char[],int,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.lang.IndexOutOfBoundsException.class)
	public void testRead_22()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		char[] cbuf = new char[] {};
		int off = 1;
		int len = 1;

		int result = fixture.read(cbuf, off, len);

		// add additional test code here
		assertEquals(0, result);
	}

	/**
	 * Run the int read(char[],int,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.lang.IndexOutOfBoundsException.class)
	public void testRead_23()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		char[] cbuf = new char[] {};
		int off = 1;
		int len = 1;

		int result = fixture.read(cbuf, off, len);

		// add additional test code here
		assertEquals(0, result);
	}

	/**
	 * Run the String readLine() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadLine_1()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');

		String result = fixture.readLine();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the String readLine() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadLine_2()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');

		String result = fixture.readLine();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the String readLine(boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadLine_3()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		boolean ignoreLF = true;

		String result = fixture.readLine(ignoreLF);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the String readLine(boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadLine_4()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		boolean ignoreLF = true;

		String result = fixture.readLine(ignoreLF);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the String readLine(boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadLine_5()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		boolean ignoreLF = false;

		String result = fixture.readLine(ignoreLF);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the String readLine(boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadLine_6()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		boolean ignoreLF = false;

		String result = fixture.readLine(ignoreLF);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the String readLine(boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadLine_7()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		boolean ignoreLF = true;

		String result = fixture.readLine(ignoreLF);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the String readLine(boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadLine_8()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		boolean ignoreLF = true;

		String result = fixture.readLine(ignoreLF);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the String readLine(boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadLine_9()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		boolean ignoreLF = false;

		String result = fixture.readLine(ignoreLF);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the String readLine(boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadLine_10()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		boolean ignoreLF = true;

		String result = fixture.readLine(ignoreLF);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the String readLine(boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadLine_11()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		boolean ignoreLF = false;

		String result = fixture.readLine(ignoreLF);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the String readLine(boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadLine_12()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		boolean ignoreLF = true;

		String result = fixture.readLine(ignoreLF);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the String readLine(boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadLine_13()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		boolean ignoreLF = false;

		String result = fixture.readLine(ignoreLF);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the String readLine(boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadLine_14()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		boolean ignoreLF = true;

		String result = fixture.readLine(ignoreLF);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the String readLine(boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadLine_15()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		boolean ignoreLF = false;

		String result = fixture.readLine(ignoreLF);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the String readLine(boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadLine_16()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		boolean ignoreLF = true;

		String result = fixture.readLine(ignoreLF);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the String readLine(boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadLine_17()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		boolean ignoreLF = false;

		String result = fixture.readLine(ignoreLF);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the String readLine(boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadLine_18()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		boolean ignoreLF = true;

		String result = fixture.readLine(ignoreLF);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the List<String> readLines() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadLines_1()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');

		List<String> result = fixture.readLines();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the List<String> readLines() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadLines_2()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');

		List<String> result = fixture.readLines();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the List<String> readLines(boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadLines_3()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		boolean ignoreLF = true;

		List<String> result = fixture.readLines(ignoreLF);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the List<String> readLines(boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadLines_4()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		boolean ignoreLF = false;

		List<String> result = fixture.readLines(ignoreLF);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the List<String> readLines(boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadLines_5()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		boolean ignoreLF = true;

		List<String> result = fixture.readLines(ignoreLF);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the List<String> readLines(boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadLines_6()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		boolean ignoreLF = false;

		List<String> result = fixture.readLines(ignoreLF);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the List<String> readLines(boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadLines_7()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		boolean ignoreLF = false;

		List<String> result = fixture.readLines(ignoreLF);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the List<String> readLines(boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadLines_8()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		boolean ignoreLF = true;

		List<String> result = fixture.readLines(ignoreLF);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the List<String> readLines(boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadLines_9()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		boolean ignoreLF = false;

		List<String> result = fixture.readLines(ignoreLF);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the List<String> readLines(boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadLines_10()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		boolean ignoreLF = false;

		List<String> result = fixture.readLines(ignoreLF);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the List<String> readLines(boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadLines_11()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		boolean ignoreLF = false;

		List<String> result = fixture.readLines(ignoreLF);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the List<String> readLines(boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadLines_12()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		boolean ignoreLF = true;

		List<String> result = fixture.readLines(ignoreLF);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the List<String> readLines(boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadLines_13()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		boolean ignoreLF = false;

		List<String> result = fixture.readLines(ignoreLF);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the List<String> readLines(boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadLines_14()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		boolean ignoreLF = true;

		List<String> result = fixture.readLines(ignoreLF);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the List<String> readLines(boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadLines_15()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		boolean ignoreLF = false;

		List<String> result = fixture.readLines(ignoreLF);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the List<String> readLines(boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadLines_16()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		boolean ignoreLF = true;

		List<String> result = fixture.readLines(ignoreLF);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the List<String> readLines(boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadLines_17()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		boolean ignoreLF = false;

		List<String> result = fixture.readLines(ignoreLF);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the List<String> readLines(boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.io.IOException.class)
	public void testReadLines_18()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		boolean ignoreLF = true;

		List<String> result = fixture.readLines(ignoreLF);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the boolean ready() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.io.IOException.class)
	public void testReady_1()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');

		boolean result = fixture.ready();

		// add additional test code here
		assertTrue(result);
	}

	/**
	 * Run the boolean ready() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.io.IOException.class)
	public void testReady_2()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');

		boolean result = fixture.ready();

		// add additional test code here
		assertTrue(result);
	}

	/**
	 * Run the boolean ready() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.io.IOException.class)
	public void testReady_3()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');

		boolean result = fixture.ready();

		// add additional test code here
		assertTrue(result);
	}

	/**
	 * Run the boolean ready() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.io.IOException.class)
	public void testReady_4()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');

		boolean result = fixture.ready();

		// add additional test code here
		assertTrue(result);
	}

	/**
	 * Run the boolean ready() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.io.IOException.class)
	public void testReady_5()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');

		boolean result = fixture.ready();

		// add additional test code here
		assertTrue(result);
	}

	/**
	 * Run the boolean ready() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.io.IOException.class)
	public void testReady_6()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');

		boolean result = fixture.ready();

		// add additional test code here
		assertTrue(result);
	}

	/**
	 * Run the boolean ready() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.io.IOException.class)
	public void testReady_7()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');

		boolean result = fixture.ready();

		// add additional test code here
		assertTrue(result);
	}

	/**
	 * Run the void reset() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test
	public void testReset_1()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');

		fixture.reset();

		// add additional test code here
	}

	/**
	 * Run the void reset() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test
	public void testReset_2()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');

		fixture.reset();

		// add additional test code here
	}

	/**
	 * Run the void reset() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test
	public void testReset_3()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');

		fixture.reset();

		// add additional test code here
	}

	/**
	 * Run the void reset() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test
	public void testReset_4()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');

		fixture.reset();

		// add additional test code here
	}

	/**
	 * Run the void setOperator(char) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test
	public void testSetOperator_1()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		char operator = '';

		fixture.setOperator(operator);

		// add additional test code here
	}

	/**
	 * Run the void setOperator2(char) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test
	public void testSetOperator2_1()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		char operator2 = '';

		fixture.setOperator2(operator2);

		// add additional test code here
	}

	/**
	 * Run the void setSplit(char) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test
	public void testSetSplit_1()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		char split = '';

		fixture.setSplit(split);

		// add additional test code here
	}

	/**
	 * Run the long skip(long) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test
	public void testSkip_1()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		long n = 0L;

		long result = fixture.skip(n);

		// add additional test code here
		assertEquals(0L, result);
	}

	/**
	 * Run the long skip(long) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.io.IOException.class)
	public void testSkip_2()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		long n = 1L;

		long result = fixture.skip(n);

		// add additional test code here
		assertEquals(0L, result);
	}

	/**
	 * Run the long skip(long) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.io.IOException.class)
	public void testSkip_3()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		long n = 1L;

		long result = fixture.skip(n);

		// add additional test code here
		assertEquals(0L, result);
	}

	/**
	 * Run the long skip(long) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.io.IOException.class)
	public void testSkip_4()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		long n = 1L;

		long result = fixture.skip(n);

		// add additional test code here
		assertEquals(0L, result);
	}

	/**
	 * Run the long skip(long) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.io.IOException.class)
	public void testSkip_5()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		long n = 1L;

		long result = fixture.skip(n);

		// add additional test code here
		assertEquals(0L, result);
	}

	/**
	 * Run the long skip(long) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.io.IOException.class)
	public void testSkip_6()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		long n = 1L;

		long result = fixture.skip(n);

		// add additional test code here
		assertEquals(0L, result);
	}

	/**
	 * Run the long skip(long) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.io.IOException.class)
	public void testSkip_7()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		long n = 1L;

		long result = fixture.skip(n);

		// add additional test code here
		assertEquals(0L, result);
	}

	/**
	 * Run the long skip(long) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testSkip_8()
		throws Exception {
		BufferedReaderExt fixture = new BufferedReaderExt(new PipedReader(), 1);
		fixture.setOperator2('');
		fixture.setOperator('');
		fixture.mark(1);
		fixture.setSplit('');
		long n = -1L;

		long result = fixture.skip(n);

		// add additional test code here
		assertEquals(0L, result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:35
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
	 * @generatedBy CodePro at 15-12-16 下午2:35
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
	 * @generatedBy CodePro at 15-12-16 下午2:35
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(BufferedReaderExtTest.class);
	}
}