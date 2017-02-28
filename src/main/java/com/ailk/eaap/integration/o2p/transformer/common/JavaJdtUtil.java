package com.ailk.eaap.integration.o2p.transformer.common;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.ImportDeclaration;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.xml.sax.SAXException;

import com.ailk.eaap.op2.serviceagent.common.MessageBO;

import javassist.CannotCompileException;
import javassist.ClassClassPath;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.CtMethod;
import javassist.CtNewMethod;
import javassist.NotFoundException;

/**
 * @author chenqiang
 * @version 2016-04-10
 */
public class JavaJdtUtil {
	
	
	

	public static IScriptDoJavaClass parserJava(String script, int transformerRuleid) throws CannotCompileException, NotFoundException, InstantiationException, IllegalAccessException {

			ASTParser parsert = ASTParser.newParser(AST.JLS3);
			parsert.setSource(script.toString().toCharArray());
			CompilationUnit classz = (CompilationUnit) parsert.createAST(null);
			List types = classz.types();

			// 取得类型声明
			TypeDeclaration typeDec = (TypeDeclaration) types.get(0);

			// ##############获取源代码结构信息#################
			// 引用import
			List importList = classz.imports();

			// 取得函数(Method)声明列表
			MethodDeclaration methodDec[] = typeDec.getMethods();
			// 取得函数(Field)声明列表
			FieldDeclaration fieldDec[] = typeDec.getFields();
			List<String> list = new ArrayList<String>();
			
		
			String className = "com.ailk.eaap.integration.o2p.transformer.common.IScriptDoJavaClass"+ UUID.randomUUID().toString();
			ClassPool pool = ClassPool.getDefault();
			pool.insertClassPath(new ClassClassPath(IScriptDoJavaClass.class));
			pool.importPackage("com.ailk.eaap.integration.o2p.transformer.common.IScriptDoJavaClass");
			pool.importPackage("com.ailk.eaap.integration.o2p.script.jsr223");
			pool.importPackage("com.ailk.eaap.op2.serviceagent.common");
			pool.importPackage("org.apache.log4j");
			pool.importPackage("com.ailk.eaap.o2p.common.cache.ICache");
			pool.importPackage("com.ailk.eaap.op2.serviceagent.deal.service.IMessageBoHisService");
			script = script.replaceAll("return;", "return null;");

			Iterator iter  =  pool.getImportedPackages();
			while(iter.hasNext()){
				String pk = (String)iter.next();
				list.add(pk);
			}
			for (Object obj : importList) {
				ImportDeclaration importDec = (ImportDeclaration) obj;
				String pk = importDec.getName().toString();
				pk = pk.substring(0, pk.lastIndexOf("."));
				if(list.contains(pk)){
					
				}else{
					pool.importPackage(pk);
				}
			}

			CtClass cc = pool.makeClass(className);

			cc.setSuperclass(pool.get("com.ailk.eaap.integration.o2p.transformer.common.IScriptDoJavaClass"));

			for (FieldDeclaration fieldDecEle : fieldDec) {
				CtField f;
				f = CtField.make(fieldDecEle.toString(), cc);
				cc.addField(f);
			}

			for (MethodDeclaration method : methodDec) {
				CtMethod methods;
				methods = CtNewMethod.make(method.toString(), cc);
				cc.addMethod(methods);
			}
//			cc.detach();
			IScriptDoJavaClass doMsg = (IScriptDoJavaClass) cc.toClass().newInstance();
			return doMsg;
	}

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, CannotCompileException, NotFoundException {

		StringBuffer script = new StringBuffer();
		script.append("import java.io.ByteArrayInputStream;\n");
		script.append("import javax.xml.parsers.ParserConfigurationException;\n");
		script.append("import javax.xml.parsers.SAXParser;\n");
		script.append("import javax.xml.parsers.SAXParserFactory;\n");
		script.append("import org.xml.sax.Attributes;\n");
		script.append("import org.xml.sax.SAXException;\n");
		script.append("import org.xml.sax.helpers.DefaultHandler;\n");
		script.append("import java.lang.StringBuffer;\n");
		script.append("public class JavaJdtUtil1 {\n");

		script.append("public Object doMessage(MessageBO messageBO,ICache client ,IMessageBoHisService messageBoHisSer,SAXParser saxParser ) throws Exception {\n");
		script.append(" return null; } \n ");
		
		script.append(" public void endElement(String uri, String localName, String qName) throws SAXException {\n");
	
		script.append("}\n");
		script.append(" public void characters(char ch[], int start, int length) throws SAXException {\n");
			
		script.append(" }\n");
		script.append("public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException { \n");
		script.append("  		System.out.println(\"11111111111111111\");\n");
		script.append(" } \n");
		script.append("}\n");
		
		IScriptDoJavaClass doMsg = null;
		try {
			doMsg= (IScriptDoJavaClass) JavaJdtUtil.parserJava(script.toString(), 111);
			doMsg= (IScriptDoJavaClass) JavaJdtUtil.parserJava(script.toString(), 111);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CannotCompileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MessageBO messageBO = new MessageBO();
		StringBuffer str= new StringBuffer();
		str.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		str.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:cus=\"http://www.jio.ril.com/integration/services/fulfilment/CustomerOrderManagement/\" xmlns:cus1=\"http://www.jio.ril.com/information/CanonicalDataModel/CustomerOrderManagement/\"><soapenv:Header>");
		str.append("<SrcSysCode></SrcSysCode>");
		str.append("<TransactionID></TransactionID>");
		str.append("</soapenv:Header>");
		str.append("<soapenv:Body></soapenv:Body></soapenv:Envelope>");
		
			SAXParser saxParser = null;

			SAXParserFactory factory = SAXParserFactory.newInstance();
			factory.setNamespaceAware(true);
			try {
				saxParser = factory.newSAXParser();
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			try {
//				doMsg.doMessage(messageBO, new MemCache(), new MessageBoHisServiceImpl(), saxParser);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
//		messageBO.setMsgBody(str);
		IScriptDoJavaClass domsg =  JavaJdtUtil.parserJava(script.toString(), 123123);
//		domsg.doMessage(messageBO, new MemCache(), new MessageBoHisServiceImpl(), saxParser, domsg);

	}

}
