package com.ailk.eaap.integration.o2p.transformer.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.math.BigDecimal;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.ailk.eaap.integration.o2p.script.jsr223.BshScriptExecutor;
import com.ailk.eaap.op2.common.PropertyLoader;
import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.ailk.eaap.op2.serviceagent.deal.service.MessageBoHisServiceImpl;
import com.asiainfo.foundation.exception.BusinessException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ailk.eaap.integration.o2p.transformer.ScriptExecutorTransformer;

import javassist.CannotCompileException;
import javassist.ClassClassPath;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewMethod;
import javassist.NotFoundException;
import javassist.bytecode.ClassFile;

public class JavassistValidate {
	public static void main(String[] args) throws CannotCompileException, NotFoundException, InstantiationException, IllegalAccessException, HttpException, IOException{
		//String url = PropertyLoader.getProperty("SYSTEM_AUTHENTICATION_URL");
		String address = "http://10.1.242.124:32000/HubCrmServlet?servicecode=3950dc1a-5201-0010-ba3b-a9d9d2299a7d&WEB_HUB_PARAMS=" + URLEncoder.encode("{\"userName\":\"O2P\",\"pwd\":\"123456\"}", "UTF-8") + "&roleType=System&tenant=21";
		HttpClient httpClient = new HttpClient();
		HttpMethod httpMethod = new PostMethod(address);
		int status = httpClient.executeMethod(httpMethod);
		if(200==status){
			JSONObject jo = JSONObject.fromObject(httpMethod.getResponseBodyAsString());
			String token = jo.getString("data");
			System.out.println(token);
		}
		
//		StringBuilder sc = new StringBuilder();
//		File file = new File("D:\\tt.txt");
//		ClassPool pool = ClassPool.getDefault();
//        StringBuffer sb = new StringBuffer();
//        try {
//            InputStreamReader read = new InputStreamReader(
//            new FileInputStream(file),"utf-8");//考虑到编码格式
//            BufferedReader bufferedReader = new BufferedReader(read);
//            String lineTxt = null;
//            while((lineTxt = bufferedReader.readLine()) != null){
//                sb.append(lineTxt+"\n");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        String srcScript = sb.toString();srcScript.contains("s");
////        URL url = pool.find("java/lang/String");
//        String className = "com.ailk.eaap.integration.o2p.transformer.common.ScriptDoMsg";
////        ClassClassPath ccp = new ClassClassPath(Object.class);
////        CtClass bb = pool.get("java/lang/String");
////        CtClass cct = new javassist.CtClass("java.lang.String", pool);
////		URL url = bb.getClass().getResource("");
////		CtMethod[] cms = bb.getDeclaredMethods();
////        ccp.
////		pool
//		pool.importPackage("com.ailk.eaap.integration.o2p.transformer.common.IScriptDoMsg");
//		pool.importPackage("com.ailk.eaap.integration.o2p.script.jsr223");
//		pool.importPackage("com.ailk.eaap.op2.serviceagent.common");
//		pool.importPackage("org.apache.log4j");
//		pool.importPackage("com.ailk.eaap.o2p.common.cache.ICache");
//		pool.importPackage("com.ailk.eaap.op2.serviceagent.deal.service.IMessageBoHisService");
//		String script = srcScript.replaceAll("return;", "return null;");
//		List<String> list = new ArrayList<String>();
//		while(true){
//			Map<String, String> map = ScriptExecutorTransformer.getSubStr(script);
//			if(map==null){
//				break;
//			}else{
//				script = map.get("script");
//				list.add(map.get("method"));
//			}
//		}
//		
//		String[] codeLines = script.split("\n");
//		StringBuffer sbMethod = new StringBuffer();
//
//		sbMethod.append("public Object doMessage(com.ailk.eaap.op2.serviceagent.common.MessageBO messageBO, com.ailk.eaap.o2p.common.cache.ICache cacheClient ,com.ailk.eaap.op2.serviceagent.deal.service.IMessageBoHisService messageBoHisSer) {");
//
//		for(String s:codeLines){
//			if(null==s||"".equals(s.trim())){
//				continue;
//			}
//			s=s.trim();
//			if(s.indexOf("import")>=0){
//				do{
//					String pk = s.substring(s.indexOf("import")+7, s.indexOf(";"));
//					pk = pk.substring(0, pk.lastIndexOf("."));
//					pool.importPackage(pk);
//					s = s.substring(s.indexOf(";") + 1);
//				}while(s.indexOf("import")>=0);
//			}
////			if(s.contains(";")){
////				for(String ss : s.split(";")){
////					ss = codeHandler(ss);
////					sbMethod.append(ss).append("\n");
////				}
////			}else{
////				sbMethod.append(s).append("\n");
////			}
//			sbMethod.append(s).append("\n");
//		}
//		String regEx="^*return\\s.*;\n$"; 
//		Pattern p=Pattern.compile(regEx);
//		Matcher m=p.matcher(sbMethod);
//		if(!m.matches()){
//			sbMethod.append("return null;\n");
//		}
//		sbMethod.append("\n}");
//		CtClass cc = null;
//		try{
//			cc = pool.getCtClass(className);
//			className = "com.ailk.eaap.integration.o2p.transformer.common.ScriptDoMsg" + UUID.randomUUID().toString();
//			cc = pool.makeClass(className);		
//		}catch(NotFoundException nfe){
//			cc = pool.makeClass(className);
//		}
//		CtClass its[] = {pool.get("com.ailk.eaap.integration.o2p.transformer.common.IScriptDoMsg")};
//		cc.setInterfaces(its);
//		if(list!=null && !list.isEmpty()){
//			for(String md : list){
//				CtMethod method = CtNewMethod.make(md,cc);
//				cc.addMethod(method);
//			}
//		}
//		ClassFile cf = cc.getClassFile2();
//		CtMethod md = CtNewMethod.make(sbMethod.toString(),cc);
//		cc.addMethod(md);
//		cc.toClass().newInstance();
//		Integer sum_duration = new Integer(0);
//		System.out.println("------------the script is pass compile by javassist!------------");
	}
	public double mul(Double d1,Double d2){
		
        BigDecimal b1=new BigDecimal(d1.toString());
        BigDecimal b2=new BigDecimal(d2.toString());
        return b1.multiply(b2).doubleValue();
         
    }
	
	public double div(Double d1,Double d2,int scale){
        if(scale<0){
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b1=new BigDecimal(d1.toString());
        BigDecimal b2=new BigDecimal(d2.toString());
        return b1.divide(b2,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
