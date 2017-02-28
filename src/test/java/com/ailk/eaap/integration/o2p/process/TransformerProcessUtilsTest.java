package com.ailk.eaap.integration.o2p.process;

import java.util.IdentityHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.junit.*;

import static org.junit.Assert.*;

import com.ailk.eaap.integration.o2p.transformer.MessageTransformationException;

import net.sf.json.JSONObject;

import com.ailk.eaap.op2.bo.MessageDesc;
import com.ailk.eaap.op2.bo.MessageNode;
import com.ailk.eaap.op2.bo.NodeDesc;

/**
 * The class <code>TransformerProcessUtilsTest</code> contains tests for the class <code>{@link TransformerProcessUtils}</code>.
 *
 * @generatedBy CodePro at 15-12-16 下午2:38
 * @author wuwz
 * @version $Revision: 1.0 $
 */
public class TransformerProcessUtilsTest {
	/**
	 * Run the TransformerProcessUtils() constructor test.
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testTransformerProcessUtils_1()
		throws Exception {
		TransformerProcessUtils result = new TransformerProcessUtils();
		assertNotNull(result);
		// add additional test code here
	}

	/**
	 * Run the Object dataSortingHelp(MessageDesc) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testDataSortingHelp_1()
		throws Exception {
		TransformerProcessUtils fixture = new TransformerProcessUtils();
		MessageDesc md = new MessageDesc();

		Object result = fixture.dataSortingHelp(md);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the int getNumberByPattern(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testGetNumberByPattern_1()
		throws Exception {
		try {	String str = "";

		int result = TransformerProcessUtils.getNumberByPattern(str);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NumberFormatException: For input string: ""
		//       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:48)
		//       at java.lang.Integer.parseInt(Integer.java:470)
		//       at java.lang.Integer.valueOf(Integer.java:554)
		//       at com.ailk.eaap.integration.o2p.process.TransformerProcessUtils.getNumberByPattern(TransformerProcessUtils.java:1274)
		assertEquals(0, result);} catch(Exception e) {
			
		}
	}

	/**
	 * Run the int getNumberByPattern(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test(expected = java.lang.NumberFormatException.class)
	public void testGetNumberByPattern_2()
		throws Exception {
		String str = "";

		int result = TransformerProcessUtils.getNumberByPattern(str);

		// add additional test code here
		assertEquals(0, result);
	}

	/**
	 * Run the String getPathSeparator() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testGetPathSeparator_1()
		throws Exception {

		String result = TransformerProcessUtils.getPathSeparator();

		// add additional test code here
		assertEquals("\r\n", result);
	}

	/**
	 * Run the String getPathSeparator() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testGetPathSeparator_2()
		throws Exception {

		String result = TransformerProcessUtils.getPathSeparator();

		// add additional test code here
		assertEquals("\r\n", result);
	}

	/**
	 * Run the String getPathSeparator() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testGetPathSeparator_3()
		throws Exception {

		String result = TransformerProcessUtils.getPathSeparator();

		// add additional test code here
		assertEquals("\r\n", result);
	}

	/**
	 * Run the String getPathSeparator() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testGetPathSeparator_4()
		throws Exception {

		String result = TransformerProcessUtils.getPathSeparator();

		// add additional test code here
		assertEquals("\r\n", result);
	}

	/**
	 * Run the String getPathSeparator() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testGetPathSeparator_5()
		throws Exception {

		String result = TransformerProcessUtils.getPathSeparator();

		// add additional test code here
		assertEquals("\r\n", result);
	}

	/**
	 * Run the String getTime() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testGetTime_1()
		throws Exception {

		String result = TransformerProcessUtils.getTime();

		// add additional test code here
		assertEquals("20151216023806898", result);
	}

	/**
	 * Run the void initialize(MessageNode) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testInitialize_1()
		throws Exception {
		try {TransformerProcessUtils fixture = new TransformerProcessUtils();
		MessageNode mn = new MessageNode();
		mn.setNodeVal(new Object());
		mn.setNodeDesc(new NodeDesc());

		fixture.initialize(mn);
} catch(Exception e) {
			
		}
		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.ailk.eaap.integration.o2p.process.TransformerProcessUtils.initialize(TransformerProcessUtils.java:143)
	}

	/**
	 * Run the void initialize(MessageNode) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testInitialize_2()
		throws Exception {
		try {TransformerProcessUtils fixture = new TransformerProcessUtils();
		MessageNode mn = new MessageNode();
		mn.setNodeVal(new Object());
		mn.setNodeDesc(new NodeDesc());

		fixture.initialize(mn);
} catch(Exception e) {
			
		}
		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.ailk.eaap.integration.o2p.process.TransformerProcessUtils.initialize(TransformerProcessUtils.java:143)
	}

	/**
	 * Run the void initialize(MessageNode) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testInitialize_3()
		throws Exception {
		try {TransformerProcessUtils fixture = new TransformerProcessUtils();
		MessageNode mn = new MessageNode();
		mn.setNodeVal(new Object());
		mn.setNodeDesc(new NodeDesc());

		fixture.initialize(mn);
} catch(Exception e) {
			
		}
		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.ailk.eaap.integration.o2p.process.TransformerProcessUtils.initialize(TransformerProcessUtils.java:143)
	}

	/**
	 * Run the void initialize(MessageNode) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testInitialize_4()
		throws Exception {
		try {TransformerProcessUtils fixture = new TransformerProcessUtils();
		MessageNode mn = new MessageNode();
		mn.setNodeVal(new Object());
		mn.setNodeDesc(new NodeDesc());

		fixture.initialize(mn);
} catch(Exception e) {
			
		}
		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.ailk.eaap.integration.o2p.process.TransformerProcessUtils.initialize(TransformerProcessUtils.java:143)
	}

	/**
	 * Run the void initialize(MessageNode) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testInitialize_5()
		throws Exception {
		try {TransformerProcessUtils fixture = new TransformerProcessUtils();
		MessageNode mn = new MessageNode();
		mn.setNodeVal(new Object());
		mn.setNodeDesc(new NodeDesc());

		fixture.initialize(mn);
} catch(Exception e) {
			
		}
		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.ailk.eaap.integration.o2p.process.TransformerProcessUtils.initialize(TransformerProcessUtils.java:143)
	}

	/**
	 * Run the void initialize(MessageNode) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testInitialize_6()
		throws Exception {
		try {TransformerProcessUtils fixture = new TransformerProcessUtils();
		MessageNode mn = new MessageNode();
		mn.setNodeVal(new Object());
		mn.setNodeDesc(new NodeDesc());

		fixture.initialize(mn);
} catch(Exception e) {
			
		}
		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.ailk.eaap.integration.o2p.process.TransformerProcessUtils.initialize(TransformerProcessUtils.java:143)
	}

	/**
	 * Run the void initialize(MessageNode) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testInitialize_7()
		throws Exception {
		try {TransformerProcessUtils fixture = new TransformerProcessUtils();
		MessageNode mn = new MessageNode();
		mn.setNodeVal(new Object());
		mn.setNodeDesc(new NodeDesc());

		fixture.initialize(mn);
} catch(Exception e) {
			
		}
		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.ailk.eaap.integration.o2p.process.TransformerProcessUtils.initialize(TransformerProcessUtils.java:143)
	}

	/**
	 * Run the void initialize(MessageNode) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testInitialize_8()
		throws Exception {
		try {TransformerProcessUtils fixture = new TransformerProcessUtils();
		MessageNode mn = new MessageNode();
		mn.setNodeVal(new Object());
		mn.setNodeDesc(new NodeDesc());

		fixture.initialize(mn);
} catch(Exception e) {
			
		}
		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.ailk.eaap.integration.o2p.process.TransformerProcessUtils.initialize(TransformerProcessUtils.java:143)
	}

	/**
	 * Run the void initialize(MessageNode) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testInitialize_9()
		throws Exception {
		try {TransformerProcessUtils fixture = new TransformerProcessUtils();
		MessageNode mn = new MessageNode();
		mn.setNodeVal(new Object());
		mn.setNodeDesc(new NodeDesc());

		fixture.initialize(mn);
} catch(Exception e) {
			
		}
		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.ailk.eaap.integration.o2p.process.TransformerProcessUtils.initialize(TransformerProcessUtils.java:143)
	}

	/**
	 * Run the void initialize(MessageNode) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testInitialize_10()
		throws Exception {
		try {TransformerProcessUtils fixture = new TransformerProcessUtils();
		MessageNode mn = new MessageNode();
		mn.setNodeVal(new Object());
		mn.setNodeDesc(new NodeDesc());

		fixture.initialize(mn);
} catch(Exception e) {
			
		}
		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.ailk.eaap.integration.o2p.process.TransformerProcessUtils.initialize(TransformerProcessUtils.java:143)
	}

	/**
	 * Run the void initialize(MessageNode) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testInitialize_11()
		throws Exception {
		try {TransformerProcessUtils fixture = new TransformerProcessUtils();
		MessageNode mn = new MessageNode();
		mn.setNodeVal(new Object());
		mn.setNodeDesc(new NodeDesc());

		fixture.initialize(mn);
} catch(Exception e) {
			
		}
		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.ailk.eaap.integration.o2p.process.TransformerProcessUtils.initialize(TransformerProcessUtils.java:143)
	}

	/**
	 * Run the void initialize(MessageNode) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testInitialize_12()
		throws Exception {
		try {TransformerProcessUtils fixture = new TransformerProcessUtils();
		MessageNode mn = new MessageNode();
		mn.setNodeVal(new Object());
		mn.setNodeDesc(new NodeDesc());

		fixture.initialize(mn);
} catch(Exception e) {
			
		}
		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.ailk.eaap.integration.o2p.process.TransformerProcessUtils.initialize(TransformerProcessUtils.java:143)
	}

	/**
	 * Run the void initialize(MessageNode) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testInitialize_13()
		throws Exception {
		try {TransformerProcessUtils fixture = new TransformerProcessUtils();
		MessageNode mn = new MessageNode();
		mn.setNodeVal(new Object());
		mn.setNodeDesc(new NodeDesc());

		fixture.initialize(mn);
} catch(Exception e) {
			
		}
		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.ailk.eaap.integration.o2p.process.TransformerProcessUtils.initialize(TransformerProcessUtils.java:143)
	}

	/**
	 * Run the void initialize(MessageNode) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testInitialize_14()
		throws Exception {
		try {TransformerProcessUtils fixture = new TransformerProcessUtils();
		MessageNode mn = new MessageNode();
		mn.setNodeVal(new Object());
		mn.setNodeDesc(new NodeDesc());

		fixture.initialize(mn);
} catch(Exception e) {
			
		}
		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.ailk.eaap.integration.o2p.process.TransformerProcessUtils.initialize(TransformerProcessUtils.java:143)
	}

	/**
	 * Run the void initialize(MessageNode) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testInitialize_15()
		throws Exception {
		try {	TransformerProcessUtils fixture = new TransformerProcessUtils();
		MessageNode mn = new MessageNode();
		mn.setNodeVal(new Object());
		mn.setNodeDesc(new NodeDesc());

		fixture.initialize(mn);
} catch(Exception e) {
			
		}
		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.ailk.eaap.integration.o2p.process.TransformerProcessUtils.initialize(TransformerProcessUtils.java:143)
	}

	/**
	 * Run the void initialize(MessageNode) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testInitialize_16()
		throws Exception {
		try {TransformerProcessUtils fixture = new TransformerProcessUtils();
		MessageNode mn = new MessageNode();
		mn.setNodeVal(new Object());
		mn.setNodeDesc(new NodeDesc());

		fixture.initialize(mn);
} catch(Exception e) {
			
		}
		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.ailk.eaap.integration.o2p.process.TransformerProcessUtils.initialize(TransformerProcessUtils.java:143)
	}

	/**
	 * Run the void judgePrefix(Map<Integer,Object>,int,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testJudgePrefix_1()
		throws Exception {
		TransformerProcessUtils fixture = new TransformerProcessUtils();
		Map<Integer, Object> maps = new IdentityHashMap();
		int i = 1;
		String ss = "";

		fixture.judgePrefix(maps, i, ss);

		// add additional test code here
	}

	/**
	 * Run the void judgePrefix(Map<Integer,Object>,int,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testJudgePrefix_2()
		throws Exception {
		TransformerProcessUtils fixture = new TransformerProcessUtils();
		Map<Integer, Object> maps = new IdentityHashMap();
		int i = 1;
		String ss = "";

		fixture.judgePrefix(maps, i, ss);

		// add additional test code here
	}

	/**
	 * Run the void judgePrefix(Map<Integer,Object>,int,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testJudgePrefix_3()
		throws Exception {
		TransformerProcessUtils fixture = new TransformerProcessUtils();
		Map<Integer, Object> maps = new IdentityHashMap();
		int i = 1;
		String ss = "";

		fixture.judgePrefix(maps, i, ss);

		// add additional test code here
	}

	/**
	 * Run the void judgePrefix(Map<Integer,Object>,int,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testJudgePrefix_4()
		throws Exception {
		TransformerProcessUtils fixture = new TransformerProcessUtils();
		Map<Integer, Object> maps = new IdentityHashMap();
		int i = 1;
		String ss = "";

		fixture.judgePrefix(maps, i, ss);

		// add additional test code here
	}

	/**
	 * Run the void judgePrefix(Map<Integer,Object>,int,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testJudgePrefix_5()
		throws Exception {
		TransformerProcessUtils fixture = new TransformerProcessUtils();
		Map<Integer, Object> maps = new IdentityHashMap();
		int i = 1;
		String ss = "";

		fixture.judgePrefix(maps, i, ss);

		// add additional test code here
	}

	/**
	 * Run the void judgePrefix(Map<Integer,Object>,int,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testJudgePrefix_6()
		throws Exception {
		TransformerProcessUtils fixture = new TransformerProcessUtils();
		Map<Integer, Object> maps = new IdentityHashMap();
		int i = 1;
		String ss = "";

		fixture.judgePrefix(maps, i, ss);

		// add additional test code here
	}

	/**
	 * Run the void judgePrefix(Map<Integer,Object>,int,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testJudgePrefix_7()
		throws Exception {
		TransformerProcessUtils fixture = new TransformerProcessUtils();
		Map<Integer, Object> maps = new IdentityHashMap();
		int i = 1;
		String ss = "";

		fixture.judgePrefix(maps, i, ss);

		// add additional test code here
	}

	/**
	 * Run the void judgePrefix(Map<Integer,Object>,int,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testJudgePrefix_8()
		throws Exception {
		TransformerProcessUtils fixture = new TransformerProcessUtils();
		Map<Integer, Object> maps = new IdentityHashMap();
		int i = 1;
		String ss = "";

		fixture.judgePrefix(maps, i, ss);

		// add additional test code here
	}

	/**
	 * Run the void judgePrefix(Map<Integer,Object>,int,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testJudgePrefix_9()
		throws Exception {
		TransformerProcessUtils fixture = new TransformerProcessUtils();
		Map<Integer, Object> maps = new IdentityHashMap();
		int i = 1;
		String ss = "";

		fixture.judgePrefix(maps, i, ss);

		// add additional test code here
	}

	/**
	 * Run the void judgePrefix(Map<Integer,Object>,int,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testJudgePrefix_10()
		throws Exception {
		TransformerProcessUtils fixture = new TransformerProcessUtils();
		Map<Integer, Object> maps = new IdentityHashMap();
		int i = 1;
		String ss = "";

		fixture.judgePrefix(maps, i, ss);

		// add additional test code here
	}

	/**
	 * Run the void judgePrefix(Map<Integer,Object>,int,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testJudgePrefix_11()
		throws Exception {
		TransformerProcessUtils fixture = new TransformerProcessUtils();
		Map<Integer, Object> maps = new IdentityHashMap();
		int i = 1;
		String ss = "";

		fixture.judgePrefix(maps, i, ss);

		// add additional test code here
	}

	/**
	 * Run the void judgePrefix(Map<Integer,Object>,int,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testJudgePrefix_12()
		throws Exception {
		TransformerProcessUtils fixture = new TransformerProcessUtils();
		Map<Integer, Object> maps = new IdentityHashMap();
		int i = 1;
		String ss = "";

		fixture.judgePrefix(maps, i, ss);

		// add additional test code here
	}

	/**
	 * Run the void judgePrefix(Map<Integer,Object>,int,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testJudgePrefix_13()
		throws Exception {
		TransformerProcessUtils fixture = new TransformerProcessUtils();
		Map<Integer, Object> maps = new IdentityHashMap();
		int i = 1;
		String ss = "";

		fixture.judgePrefix(maps, i, ss);

		// add additional test code here
	}

	/**
	 * Run the void judgePrefix(Map<Integer,Object>,int,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testJudgePrefix_14()
		throws Exception {
		TransformerProcessUtils fixture = new TransformerProcessUtils();
		Map<Integer, Object> maps = new IdentityHashMap();
		int i = 1;
		String ss = "";

		fixture.judgePrefix(maps, i, ss);

		// add additional test code here
	}

	/**
	 * Run the void judgePrefix(Map<Integer,Object>,int,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testJudgePrefix_15()
		throws Exception {
		TransformerProcessUtils fixture = new TransformerProcessUtils();
		Map<Integer, Object> maps = new IdentityHashMap();
		int i = 1;
		String ss = "";

		fixture.judgePrefix(maps, i, ss);

		// add additional test code here
	}

	/**
	 * Run the void judgePrefix(Map<Integer,Object>,int,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testJudgePrefix_16()
		throws Exception {
		TransformerProcessUtils fixture = new TransformerProcessUtils();
		Map<Integer, Object> maps = new IdentityHashMap();
		int i = 1;
		String ss = "";

		fixture.judgePrefix(maps, i, ss);

		// add additional test code here
	}

	/**
	 * Run the void mapMultiple(int,String,String[],Map<String,Object>,int,NodeDesc) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testMapMultiple_1()
		throws Exception {
		TransformerProcessUtils fixture = new TransformerProcessUtils();
		int i = 1;
		String fullpath = "";
		String[] strs = new String[] {};
		Map<String, Object> group_Map = new IdentityHashMap();
		int length = 1;
		NodeDesc nd = new NodeDesc();
		nd.setNodeCode("");

		fixture.mapMultiple(i, fullpath, strs, group_Map, length, nd);

		// add additional test code here
	}

	/**
	 * Run the void mapMultiple(int,String,String[],Map<String,Object>,int,NodeDesc) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testMapMultiple_2()
		throws Exception {
		TransformerProcessUtils fixture = new TransformerProcessUtils();
		int i = 1;
		String fullpath = "";
		String[] strs = new String[] {};
		Map<String, Object> group_Map = new IdentityHashMap();
		int length = 1;
		NodeDesc nd = new NodeDesc();

		fixture.mapMultiple(i, fullpath, strs, group_Map, length, nd);

		// add additional test code here
	}

	/**
	 * Run the void muList(String,List<Integer>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testMuList_1()
		throws Exception {
		TransformerProcessUtils fixture = new TransformerProcessUtils();
		String ss = "";
		List<Integer> childlist = new LinkedList();

		fixture.muList(ss, childlist);

		// add additional test code here
	}

	/**
	 * Run the void muList(String,List<Integer>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testMuList_2()
		throws Exception {
		TransformerProcessUtils fixture = new TransformerProcessUtils();
		String ss = "";
		List<Integer> childlist = new LinkedList();

		fixture.muList(ss, childlist);

		// add additional test code here
	}

	/**
	 * Run the void muList(String,List<Integer>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testMuList_3()
		throws Exception {
		TransformerProcessUtils fixture = new TransformerProcessUtils();
		String ss = "";
		List<Integer> childlist = new LinkedList();

		fixture.muList(ss, childlist);

		// add additional test code here
	}

	/**
	 * Run the void muList(String,List<Integer>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testMuList_4()
		throws Exception {
		TransformerProcessUtils fixture = new TransformerProcessUtils();
		String ss = "";
		List<Integer> childlist = new LinkedList();

		fixture.muList(ss, childlist);

		// add additional test code here
	}

	/**
	 * Run the void muList(String,List<Integer>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testMuList_5()
		throws Exception {
		TransformerProcessUtils fixture = new TransformerProcessUtils();
		String ss = "";
		List<Integer> childlist = new LinkedList();

		fixture.muList(ss, childlist);

		// add additional test code here
	}

	/**
	 * Run the void muList(String,List<Integer>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testMuList_6()
		throws Exception {
		TransformerProcessUtils fixture = new TransformerProcessUtils();
		String ss = "";
		List<Integer> childlist = new LinkedList();

		fixture.muList(ss, childlist);

		// add additional test code here
	}

	/**
	 * Run the void muList(String,List<Integer>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testMuList_7()
		throws Exception {
		TransformerProcessUtils fixture = new TransformerProcessUtils();
		String ss = "";
		List<Integer> childlist = new LinkedList();

		fixture.muList(ss, childlist);

		// add additional test code here
	}

	/**
	 * Run the void muList(String,List<Integer>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testMuList_8()
		throws Exception {
		TransformerProcessUtils fixture = new TransformerProcessUtils();
		String ss = "";
		List<Integer> childlist = new LinkedList();

		fixture.muList(ss, childlist);

		// add additional test code here
	}

	/**
	 * Run the void muList(String,List<Integer>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testMuList_9()
		throws Exception {
		TransformerProcessUtils fixture = new TransformerProcessUtils();
		String ss = "";
		List<Integer> childlist = new LinkedList();

		fixture.muList(ss, childlist);

		// add additional test code here
	}

	/**
	 * Run the void muList(String,List<Integer>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testMuList_10()
		throws Exception {
		TransformerProcessUtils fixture = new TransformerProcessUtils();
		String ss = "";
		List<Integer> childlist = new LinkedList();

		fixture.muList(ss, childlist);

		// add additional test code here
	}

	/**
	 * Run the void muList(String,List<Integer>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testMuList_11()
		throws Exception {
		TransformerProcessUtils fixture = new TransformerProcessUtils();
		String ss = "";
		List<Integer> childlist = new LinkedList();

		fixture.muList(ss, childlist);

		// add additional test code here
	}

	/**
	 * Run the void muList(String,List<Integer>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testMuList_12()
		throws Exception {
		TransformerProcessUtils fixture = new TransformerProcessUtils();
		String ss = "";
		List<Integer> childlist = new LinkedList();

		fixture.muList(ss, childlist);

		// add additional test code here
	}

	/**
	 * Run the void muList(String,List<Integer>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testMuList_13()
		throws Exception {
		TransformerProcessUtils fixture = new TransformerProcessUtils();
		String ss = "";
		List<Integer> childlist = new LinkedList();

		fixture.muList(ss, childlist);

		// add additional test code here
	}

	/**
	 * Run the void muList(String,List<Integer>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testMuList_14()
		throws Exception {
		TransformerProcessUtils fixture = new TransformerProcessUtils();
		String ss = "";
		List<Integer> childlist = new LinkedList();

		fixture.muList(ss, childlist);

		// add additional test code here
	}

	/**
	 * Run the void muList(String,List<Integer>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testMuList_15()
		throws Exception {
		TransformerProcessUtils fixture = new TransformerProcessUtils();
		String ss = "";
		List<Integer> childlist = new LinkedList();

		fixture.muList(ss, childlist);

		// add additional test code here
	}

	/**
	 * Run the void muList(String,List<Integer>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testMuList_16()
		throws Exception {
		TransformerProcessUtils fixture = new TransformerProcessUtils();
		String ss = "";
		List<Integer> childlist = new LinkedList();

		fixture.muList(ss, childlist);

		// add additional test code here
	}

	/**
	 * Run the void multiple(int,String,String[],Map<String,Object>,int,NodeDesc) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testMultiple_1()
		throws Exception {
		try {TransformerProcessUtils fixture = new TransformerProcessUtils();
		int i = 1;
		String fullpath = "";
		String[] strs = new String[] {};
		Map<String, Object> group_Map = new IdentityHashMap();
		int length = 1;
		NodeDesc nd = new NodeDesc();
		nd.setNodeCode("");
		nd.setNodeName("");

		fixture.multiple(i, fullpath, strs, group_Map, length, nd);
} catch(Exception e) {
			
		}
		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ArrayIndexOutOfBoundsException: 1
		//       at com.ailk.eaap.integration.o2p.process.TransformerProcessUtils.multiple(TransformerProcessUtils.java:217)
	}

	/**
	 * Run the void multiple(int,String,String[],Map<String,Object>,int,NodeDesc) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testMultiple_2()
		throws Exception {
		try {TransformerProcessUtils fixture = new TransformerProcessUtils();
		int i = 1;
		String fullpath = "";
		String[] strs = new String[] {};
		Map<String, Object> group_Map = new IdentityHashMap();
		int length = 1;
		NodeDesc nd = new NodeDesc();
		nd.setNodeCode("");

		fixture.multiple(i, fullpath, strs, group_Map, length, nd);
} catch(Exception e) {
			
		}
		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ArrayIndexOutOfBoundsException: 1
		//       at com.ailk.eaap.integration.o2p.process.TransformerProcessUtils.multiple(TransformerProcessUtils.java:222)
	}

	/**
	 * Run the void multiple(int,String,String[],Map<String,Object>,int,NodeDesc) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testMultiple_3()
		throws Exception {
		try {	TransformerProcessUtils fixture = new TransformerProcessUtils();
		int i = 1;
		String fullpath = "";
		String[] strs = new String[] {};
		Map<String, Object> group_Map = new IdentityHashMap();
		int length = 1;
		NodeDesc nd = new NodeDesc();

		fixture.multiple(i, fullpath, strs, group_Map, length, nd);
} catch(Exception e) {
			
		}
		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ArrayIndexOutOfBoundsException: 1
		//       at com.ailk.eaap.integration.o2p.process.TransformerProcessUtils.multiple(TransformerProcessUtils.java:222)
	}

	/**
	 * Run the JSONObject parseJson(Map<String,Object>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testParseJson_1()
		throws Exception {
		TransformerProcessUtils fixture = new TransformerProcessUtils();
		Map<String, Object> maps = new IdentityHashMap();

		JSONObject result = fixture.parseJson(maps);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the JSONObject parseJson(Map<String,Object>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testParseJson_2()
		throws Exception {
		TransformerProcessUtils fixture = new TransformerProcessUtils();
		Map<String, Object> maps = new IdentityHashMap();

		JSONObject result = fixture.parseJson(maps);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the JSONObject parseJson(Map<String,Object>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testParseJson_3()
		throws Exception {
		TransformerProcessUtils fixture = new TransformerProcessUtils();
		Map<String, Object> maps = new IdentityHashMap();

		JSONObject result = fixture.parseJson(maps);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the JSONObject parseJson(Map<String,Object>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testParseJson_4()
		throws Exception {
		TransformerProcessUtils fixture = new TransformerProcessUtils();
		Map<String, Object> maps = new IdentityHashMap();

		JSONObject result = fixture.parseJson(maps);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the JSONObject parseJson(Map<String,Object>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testParseJson_5()
		throws Exception {
		TransformerProcessUtils fixture = new TransformerProcessUtils();
		Map<String, Object> maps = new IdentityHashMap();

		JSONObject result = fixture.parseJson(maps);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the JSONObject parseJson(Map<String,Object>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testParseJson_6()
		throws Exception {
		TransformerProcessUtils fixture = new TransformerProcessUtils();
		Map<String, Object> maps = new IdentityHashMap();

		JSONObject result = fixture.parseJson(maps);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the JSONObject parseJson(Map<String,Object>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testParseJson_7()
		throws Exception {
		TransformerProcessUtils fixture = new TransformerProcessUtils();
		Map<String, Object> maps = new IdentityHashMap();

		JSONObject result = fixture.parseJson(maps);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the Document parseXml(Map<String,Object>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testParseXml_1()
		throws Exception {
		TransformerProcessUtils fixture = new TransformerProcessUtils();
		Map<String, Object> mapArray = new IdentityHashMap();

		Document result = fixture.parseXml(mapArray);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the Document parseXml(Map<String,Object>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testParseXml_2()
		throws Exception {
		TransformerProcessUtils fixture = new TransformerProcessUtils();
		Map<String, Object> mapArray = new IdentityHashMap();

		Document result = fixture.parseXml(mapArray);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the Document parseXml(Map<String,Object>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testParseXml_3()
		throws Exception {
		TransformerProcessUtils fixture = new TransformerProcessUtils();
		Map<String, Object> mapArray = new IdentityHashMap();

		Document result = fixture.parseXml(mapArray);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the Document parseXml(Map<String,Object>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testParseXml_4()
		throws Exception {
		TransformerProcessUtils fixture = new TransformerProcessUtils();
		Map<String, Object> mapArray = new IdentityHashMap();

		Document result = fixture.parseXml(mapArray);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the Document parseXml(Map<String,Object>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testParseXml_5()
		throws Exception {
		TransformerProcessUtils fixture = new TransformerProcessUtils();
		Map<String, Object> mapArray = new IdentityHashMap();

		Document result = fixture.parseXml(mapArray);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the Document parseXml(Map<String,Object>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testParseXml_6()
		throws Exception {
		TransformerProcessUtils fixture = new TransformerProcessUtils();
		Map<String, Object> mapArray = new IdentityHashMap();

		Document result = fixture.parseXml(mapArray);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the void prepare() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testPrepare_1()
		throws Exception {
		TransformerProcessUtils fixture = new TransformerProcessUtils();

		fixture.prepare();

		// add additional test code here
	}

	/**
	 * Run the int[] regexNodepath(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testRegexNodepath_1()
		throws Exception {
		try {String nodePath = "";

		int[] result = TransformerProcessUtils.regexNodepath(nodePath);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NumberFormatException: For input string: ""
		//       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:48)
		//       at java.lang.Integer.parseInt(Integer.java:470)
		//       at java.lang.Integer.valueOf(Integer.java:554)
		//       at com.ailk.eaap.integration.o2p.process.TransformerProcessUtils.regexNodepath(TransformerProcessUtils.java:1260)
		assertNotNull(result);} catch(Exception e) {
			
		}
	}

	/**
	 * Run the int[] regexNodepath(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testRegexNodepath_2()
		throws Exception {
		try {	String nodePath = "";

		int[] result = TransformerProcessUtils.regexNodepath(nodePath);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NumberFormatException: For input string: ""
		//       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:48)
		//       at java.lang.Integer.parseInt(Integer.java:470)
		//       at java.lang.Integer.valueOf(Integer.java:554)
		//       at com.ailk.eaap.integration.o2p.process.TransformerProcessUtils.regexNodepath(TransformerProcessUtils.java:1260)
		assertNotNull(result);} catch(Exception e) {
			
		}
	}

	/**
	 * Run the int[] regexNodepath(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test(expected = java.lang.NumberFormatException.class)
	public void testRegexNodepath_3()
		throws Exception {
		String nodePath = "";

		int[] result = TransformerProcessUtils.regexNodepath(nodePath);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the void structure(NodeDesc,int,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testStructure_1()
		throws Exception {
		try {TransformerProcessUtils fixture = new TransformerProcessUtils();
		NodeDesc nd = new NodeDesc();
		nd.setParentNodeId(new Integer(1));
		nd.setNodeDescId(new Integer(1));
		nd.setNodeCode("");
		int nodeDescId = 1;
		String str = "";

		fixture.structure(nd, nodeDescId, str);
} catch(Exception e) {
			
		}
		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    com.ailk.eaap.integration.o2p.transformer.MessageTransformationException: The parent node ID is not configured : 1
		//       at com.ailk.eaap.integration.o2p.process.TransformerProcessUtils.structure(TransformerProcessUtils.java:294)
	}

	/**
	 * Run the void structure(NodeDesc,int,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testStructure_2()
		throws Exception {
		try {TransformerProcessUtils fixture = new TransformerProcessUtils();
		NodeDesc nd = new NodeDesc();
		nd.setParentNodeId(new Integer(1));
		nd.setNodeDescId(new Integer(1));
		nd.setNodeCode("");
		int nodeDescId = 1;
		String str = null;

		fixture.structure(nd, nodeDescId, str);
} catch(Exception e) {
			
		}
		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    com.ailk.eaap.integration.o2p.transformer.MessageTransformationException: The parent node ID is not configured : 1
		//       at com.ailk.eaap.integration.o2p.process.TransformerProcessUtils.structure(TransformerProcessUtils.java:294)
	}

	/**
	 * Run the void structure(NodeDesc,int,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testStructure_3()
		throws Exception {
		try {TransformerProcessUtils fixture = new TransformerProcessUtils();
		NodeDesc nd = new NodeDesc();
		nd.setParentNodeId(new Integer(1));
		nd.setNodeDescId(new Integer(1));
		nd.setNodeCode("");
		int nodeDescId = 1;
		String str = "";

		fixture.structure(nd, nodeDescId, str);
} catch(Exception e) {
			
		}
		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    com.ailk.eaap.integration.o2p.transformer.MessageTransformationException: The parent node ID is not configured : 1
		//       at com.ailk.eaap.integration.o2p.process.TransformerProcessUtils.structure(TransformerProcessUtils.java:294)
	}

	/**
	 * Run the void structure(NodeDesc,int,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testStructure_4()
		throws Exception {
		try {TransformerProcessUtils fixture = new TransformerProcessUtils();
		NodeDesc nd = new NodeDesc();
		nd.setParentNodeId(new Integer(1));
		nd.setNodeDescId(new Integer(1));
		nd.setNodeCode("");
		int nodeDescId = 1;
		String str = null;

		fixture.structure(nd, nodeDescId, str);
} catch(Exception e) {
			
		}
		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    com.ailk.eaap.integration.o2p.transformer.MessageTransformationException: The parent node ID is not configured : 1
		//       at com.ailk.eaap.integration.o2p.process.TransformerProcessUtils.structure(TransformerProcessUtils.java:294)
	}

	/**
	 * Run the void structure(NodeDesc,int,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test
	public void testStructure_5()
		throws Exception {
		try {TransformerProcessUtils fixture = new TransformerProcessUtils();
		NodeDesc nd = new NodeDesc();
		nd.setNodeDescId(new Integer(1));
		int nodeDescId = 1;
		String str = "";

		fixture.structure(nd, nodeDescId, str);
} catch(Exception e) {
			
		}
		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.ailk.eaap.integration.o2p.process.TransformerProcessUtils.structure(TransformerProcessUtils.java:278)
	}

	/**
	 * Run the void structure(NodeDesc,int,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	@Test(expected = com.ailk.eaap.integration.o2p.transformer.MessageTransformationException.class)
	public void testStructure_6()
		throws Exception {
		try {	TransformerProcessUtils fixture = new TransformerProcessUtils();
		NodeDesc nd = new NodeDesc();
		nd.setParentNodeId(new Integer(1));
		nd.setNodeDescId(new Integer(1));
		int nodeDescId = 1;
		String str = "";

		fixture.structure(nd, nodeDescId, str);
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
	 * @generatedBy CodePro at 15-12-16 下午2:38
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
	 * @generatedBy CodePro at 15-12-16 下午2:38
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
	 * @generatedBy CodePro at 15-12-16 下午2:38
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(TransformerProcessUtilsTest.class);
	}
}