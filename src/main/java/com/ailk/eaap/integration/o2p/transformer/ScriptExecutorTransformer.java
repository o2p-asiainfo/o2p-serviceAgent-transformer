package com.ailk.eaap.integration.o2p.transformer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javassist.CannotCompileException;
import javassist.ClassClassPath;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewMethod;
import javassist.NotFoundException;

import org.codehaus.stax2.XMLInputFactory2;
import org.springframework.scripting.ScriptSource;
import org.springframework.scripting.support.StaticScriptSource;
import org.springframework.util.Assert;

import com.ailk.eaap.integration.o2p.script.ScriptExecutor;
import com.ailk.eaap.integration.o2p.script.jsr223.ScriptExecutorFactory;
import com.ailk.eaap.integration.o2p.transformer.common.IScriptDoJavaClass;
import com.ailk.eaap.integration.o2p.transformer.common.IScriptDoMsg;
import com.ailk.eaap.integration.o2p.transformer.common.JavaJdtUtil;
import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.ailk.eaap.op2.serviceagent.deal.service.IMessageBoHisService;
import com.asiainfo.foundation.exception.BusinessException;
import com.asiainfo.foundation.log.Logger;
import com.asiainfo.foundation.spring.SpringContextHolder;
import com.ailk.eaap.op2.bo.TransformerRule;

public class ScriptExecutorTransformer extends AbstractTransformer {
	private static final Logger LOG = Logger.getLog(ScriptExecutorTransformer.class);
	private ScriptExecutorFactory scriptExecutorFactory;
	private static Map<Integer, Object> javassistPool = new ConcurrentHashMap<Integer, Object>();
	private static Map<Integer, Object> javassistclass = new ConcurrentHashMap<Integer, Object>();

	private ThreadLocal<XMLInputFactory2> saxParser = new ThreadLocal<XMLInputFactory2>() {
		protected XMLInputFactory2 initialValue() {
			return (XMLInputFactory2) XMLInputFactory2.newInstance();
		};
	};
			
	public ScriptExecutorFactory getScriptExecutorFactory() {
		return scriptExecutorFactory;
	}

	public void setScriptExecutorFactory(ScriptExecutorFactory scriptExecutorFactory) {
		this.scriptExecutorFactory = scriptExecutorFactory;
	}

	@Override
	protected Object beforeTransform(MessageBO<?> message,
			TransformerRule transformerRule) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object doTransform(MessageBO<?> message, TransformerRule transformerRule) throws Exception {
		ScriptExecutor scriptExecutor = null;
		if(LOG.isDebugEnabled()) {
			LOG.debug("ScriptExecutor's type={0}", transformerRule.getTransformerType());
		}
		
		if(TRANSFORMER_TYPE_JAVASSISTCLASS==transformerRule.getTransformerType().intValue()) {
			Assert.hasText(transformerRule.getScriptContent(),"transformerRule.getScriptContent() must not be null");
			
			if(!javassistclass.containsKey(transformerRule.getId())){
				String[] msgArgs= {String.valueOf(transformerRule.getId())};
				throw new BusinessException(9999,
						"o2p.serviceAgent.transformer.transformerRuleid can't build class ", msgArgs, null);
			}
			
			IScriptDoJavaClass doMsg = (IScriptDoJavaClass) javassistclass.get(transformerRule.getId());
			Object obj = null;
			try{
				XMLInputFactory2 parser = this.saxParser.get();
				parser.setProperty(XMLInputFactory2.IS_REPLACING_ENTITY_REFERENCES, Boolean.FALSE);
				parser.setProperty(XMLInputFactory2.IS_SUPPORTING_EXTERNAL_ENTITIES, Boolean.FALSE);
				parser.setProperty(XMLInputFactory2.IS_COALESCING, Boolean.FALSE);
				parser.configureForLowMemUsage();
				obj =  doMsg.doMessage(message,this.getCacheFactory().getCacheClient(),(IMessageBoHisService)SpringContextHolder.getBean("messageBoHisSer"),parser);
			}catch(Exception e){
				throw new Exception();
			}finally{
				this.saxParser.remove();
			}
			if(null==obj){
				((MessageBO)message).setMsgBody("");
				return message;
			} else if(  obj instanceof MessageBO<?> ){
				return obj;
			}else{
				((MessageBO)message).setMsgBody(obj.toString());
				return message;
			}
			
		}else if(TRANSFORMER_TYPE_JAVASSIST == transformerRule.getTransformerType().intValue()) {
			if(!javassistPool.containsKey(transformerRule.getId()) && transformerRule.getScriptContent()!=null){
//				String[] msgArgs= {String.valueOf(transformerRule.getId())};
				throw new BusinessException(9999, "script can not compile! ruleId=" + transformerRule.getId());
			}
			
			IScriptDoMsg doMsg = (IScriptDoMsg) javassistPool.get(transformerRule.getId());

			Object obj =  doMsg.doMessage(message,this.getCacheFactory().getCacheClient(),(IMessageBoHisService)SpringContextHolder.getBean("messageBoHisSer"));
			if(null==obj){
				((MessageBO)message).setMsgBody("");
				Map<String,String> reqVersionMsg = new HashMap<String,String>();
				return message;
			} else if(  obj instanceof MessageBO<?> ){
				return obj;
			}else{
				((MessageBO)message).setMsgBody(obj.toString());
				return message;
			}
		}
		else if(TRANSFORMER_TYPE_JS == transformerRule.getTransformerType().intValue()) {
			scriptExecutor = scriptExecutorFactory.getScriptExecutor("js");
		}
		else if(TRANSFORMER_TYPE_BSH == transformerRule.getTransformerType().intValue()){
			scriptExecutor = scriptExecutorFactory.getScriptExecutor("bsh");
		}else {
			scriptExecutor = scriptExecutorFactory.getScriptExecutor("bsh");
		}
		
		Map<String, Object> variables = new HashMap<String,Object>();
		variables.put("cacheClient", this.getCacheFactory().getCacheClient());
		
		variables.put("messageBO", message);
		variables.put("messageBoHisSer", SpringContextHolder.getBean("messageBoHisSer"));
		Assert.hasText(transformerRule.getScriptContent(),"transformerRule.getScriptContent() must not be null");		
		ScriptSource scriptSource = new StaticScriptSource(transformerRule.getScriptContent());
		Object obj = scriptExecutor.executeScript(scriptSource,variables  );
		if(  obj instanceof MessageBO<?> ){
			return obj;
		}else{
			((MessageBO)message).setMsgBody(obj.toString());
			return message;
		}
	}

	@Override
	protected Object afterTransform(MessageBO<?> message,
			TransformerRule transformerRule) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	public static String codeHandler(String code){
		String regEx="^String\\s.*=*messageBO.getReqVersionMsg().*"; 
		Pattern p=Pattern.compile(regEx);
		Matcher m=p.matcher(code);
		if(m.matches()){
			code=code.substring(0, code.indexOf("=")+1) + "(String)" + code.substring(code.indexOf("=")+1);
		}
		regEx="^String\\s.*=*messageBO.getMessageMap().*"; 
		p=Pattern.compile(regEx);
		m=p.matcher(code);
		if(m.matches()){
			code=code.substring(0, code.indexOf("=")+1) + "(String)" + code.substring(code.indexOf("=")+1);
		}
		regEx="^String\\s.*=*messageBO.getMsgHead().*"; 
		p=Pattern.compile(regEx);
		m=p.matcher(code);
		if(m.matches()){
			code=code.substring(0, code.indexOf("=")+1) + "(String)" + code.substring(code.indexOf("=")+1);
		}
		regEx="^JSONObject\\s.*=*"; 
		p=Pattern.compile(regEx);
		m=p.matcher(code);
		if(m.matches()){
			code=code.substring(0, code.indexOf("=")+1) + "JSONObject.fromObject(" + code.substring(code.indexOf("=")+1) + ")";
		}
//		code = code + ";";
		return code;
	}

	public static Map<String, String> getSubStr(String script){
		List list = hasMethod(script);
		if(list!=null && !list.isEmpty()){
			String ss = script.substring(Integer.valueOf(list.get(1).toString()));
			Stack<Character> sk = new Stack<Character>();
			int st = ss.indexOf("{");
			sk.push("{".toCharArray()[0]);
			ss = ss.substring(st+1);
			while(true){
				if(!sk.isEmpty()){
					if(ss.indexOf("{")!=-1 && ss.indexOf("{")<ss.indexOf("}")){
						ss = ss.substring(ss.indexOf("{")+1);
						sk.push("{".toCharArray()[0]);
					}else{
						ss = ss.substring(ss.indexOf("}")+1);
						sk.pop();
					}
				}else{
					int ed = script.indexOf(ss);
					String method = script.substring(Integer.valueOf(list.get(1).toString()), ed);
					script = script.substring(0, Integer.valueOf(list.get(1).toString())) + script.substring(ed);
					Map<String, String> map = new HashMap<String, String>();
					map.put("method", method);
					map.put("script", script);
					return map;
				}
			}
		}
		return null;
	}

	private static List hasMethod(String str){
		String[] sarray = {"public ", "protected ", "private ", "final ", "abstract ", "native ", "synchronized "};
		for(String s : sarray){
			if(str.indexOf(s)!=-1){
				List list = new ArrayList();
				list.add(s);
				list.add(str.indexOf(s));
				return list;
			}
		}
		return null;
	}
	
	public IScriptDoMsg compileAsMethod(TransformerRule transformerRule, ClassPool pool) throws NotFoundException, CannotCompileException, InstantiationException, IllegalAccessException{
		String srcScript = transformerRule.getScriptContent();
		if(srcScript==null){
			return null;
		}
		String className = "com.ailk.eaap.integration.o2p.transformer.common.ScriptDoMsg" + transformerRule.getId();
		
		pool.insertClassPath(new ClassClassPath(IScriptDoMsg.class));
		pool.importPackage("com.ailk.eaap.integration.o2p.transformer.common.IScriptDoMsg");
		pool.importPackage("com.ailk.eaap.integration.o2p.script.jsr223");
		pool.importPackage("com.ailk.eaap.op2.serviceagent.common");
		pool.importPackage("org.apache.log4j");
		pool.importPackage("com.ailk.eaap.o2p.common.cache.ICache");
		pool.importPackage("com.ailk.eaap.op2.serviceagent.deal.service.IMessageBoHisService");
		String script = srcScript.replaceAll("return;", "return null;");
		List<String> list = new ArrayList<String>();
		while(true){
			Map<String, String> map = getSubStr(script);
			if(map==null){
				break;
			}else{
				script = map.get("script");
				list.add(map.get("method"));
			}
		}
		
		String[] codeLines = script.split("\n");
		StringBuffer sbMethod = new StringBuffer();

		sbMethod.append("public Object doMessage(com.ailk.eaap.op2.serviceagent.common.MessageBO messageBO, com.ailk.eaap.o2p.common.cache.ICache cacheClient ,com.ailk.eaap.op2.serviceagent.deal.service.IMessageBoHisService messageBoHisSer) {");

		for(String s:codeLines){
			if(null==s||"".equals(s.trim())){
				continue;
			}
			s=s.trim();
			if(s.indexOf("import")>=0){
				do{
					String pk = s.substring(s.indexOf("import")+7, s.indexOf(";"));
					pk = pk.substring(0, pk.lastIndexOf("."));
					pool.importPackage(pk);
					s = s.substring(s.indexOf(";") + 1);
				}while(s.indexOf("import")>=0);
			}
			sbMethod.append(s).append("\n");
		}
		String regEx="^*return\\s.*;\n$"; 
		Pattern p=Pattern.compile(regEx);
		Matcher m=p.matcher(sbMethod);
		if(!m.matches()){
			sbMethod.append("return null;\n");
		}
		sbMethod.append("\n}");
		CtClass cc = null;
		try{
			cc = pool.getCtClass(className);
			className = "com.ailk.eaap.integration.o2p.transformer.common.ScriptDoMsg" + UUID.randomUUID().toString();
			cc = pool.makeClass(className);		
		}catch(NotFoundException nfe){
			cc = pool.makeClass(className);
		}
		CtClass its[] = {pool.get("com.ailk.eaap.integration.o2p.transformer.common.IScriptDoMsg")};
		cc.setInterfaces(its);
		if(list!=null && !list.isEmpty()){
			for(String md : list){
				CtMethod method = CtNewMethod.make(md,cc);
				cc.addMethod(method);
			}
		}
		CtMethod md = CtNewMethod.make(sbMethod.toString(),cc);
		cc.addMethod(md);
		return (IScriptDoMsg) cc.toClass().newInstance();
	}
	
	public void reloadJavassist(TransformerRule transformerRule, ClassPool pool){
		try{
			if(TRANSFORMER_TYPE_JAVASSIST==transformerRule.getTransformerType()){
				IScriptDoMsg doMsg = compileAsMethod(transformerRule, pool);
				javassistPool.put(transformerRule.getId(), doMsg);
			}else if(TRANSFORMER_TYPE_JAVASSISTCLASS==transformerRule.getTransformerType()){
				if(!javassistclass.containsKey(transformerRule.getId())){
					IScriptDoJavaClass domsg = JavaJdtUtil.parserJava(transformerRule.getScriptContent(), transformerRule.getId());
					javassistclass.put(transformerRule.getId(), domsg);
				}
			}
		}catch(javassist.CannotCompileException cce){
			LOG.error("CannotCompileException! ruleId="+transformerRule.getId(), cce);
			throw new BusinessException(9999, "CannotCompileException! ruleId="+transformerRule.getId(), cce.getCause());
		}catch(Exception e){
			LOG.error("build class by javassist error! ruleId="+transformerRule.getId(), e);
			throw new BusinessException(9999, "build class by javassist error! ruleId="+transformerRule.getId(), e.getCause());
		}
	}
	
	public static final int TRANSFORMER_TYPE_BSH = 3;
	public static final int TRANSFORMER_TYPE_JS = 2;
	public static final int TRANSFORMER_TYPE_PYTHON = 4;
	public static final int TRANSFORMER_TYPE_JAVASSIST = 16;
	public static final int TRANSFORMER_TYPE_JAVASSISTCLASS = 17;
	public static final String JAVASSIST_VERSION = "JAVASSIST_VERSION";
}
