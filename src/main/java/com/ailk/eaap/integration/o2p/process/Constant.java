package com.ailk.eaap.integration.o2p.process;

public final class Constant {
	
	private Constant() {}
	
	// 分隔符
	public static final String SEPARATORS = "separators";
	// 换行符
	public static final String NEWLINE = "newline";
	// 字符编码
	public static final String ENCODING = "encoding";
	// Win换行符
	public static final String WLine_Delimiter = "\r\n";
	// Unxi换行符
	public static final String ULine_Delimiter = "\n";
	// Max
	public static final String Mline_Delimiter = "\r";
	// 字符分隔符
	public static final String ASCII_SEPARATORS = "ascii_separators";
	// 字符换行符
	public static final String ASCII_NEWLINE = "ascii_newline";
	
	public static final String NODETYPE_HEADER = "1";
	public static final String NODETYPE_BODY = "2";
	public static final String NODETYPE_TAIL = "3";
	public static final String NODETYPE_URL = "4";
	public static final String NODETYPE_NAMESPACE = "6";
	public static final String NODETYPE_ATTR = "7";
	public static final String NODETYPE_CHILD_NAMESPACE = "8";
	
	public static final String TXT = "txt";
	public static final String CSV = "csv";


	public static final String CONTENT_TYPE_XML = "1";
	public static final String CONTENT_TYPE_JSON = "2";
	
	public static final String NODE_NUMBER_CONS_1="1";
	public static final String NODE_NUMBER_CONS_1_N="2";
	public static final String NODE_NUMBER_CONS_0_1="3";
	public static final String NODE_NUMBER_CONS_0_N="4";
	
	public static final String NODE_TYPE_CONS_STRING="1";
	public static final String NODE_TYPE_CONS_NUMBER="2";
	public static final String NODE_TYPE_CONS_OBJECT="3";
	public static final String NODE_TYPE_CONS_DATE="4";
	public static final String NODE_TYPE_CONS_DATETIME="5";
	public static final String NODE_TYPE_CONS_TIME="6";
	public static final String NODE_TYPE_CONS_BOOLEAN="7";
	public static final String NODE_TYPE_CONS_LONG="8";
	public static final String NODE_TYPE_CONS_DOUBLE="9";
}
