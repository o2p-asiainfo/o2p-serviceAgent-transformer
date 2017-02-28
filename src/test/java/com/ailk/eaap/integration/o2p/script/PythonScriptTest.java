//package com.ailk.eaap.integration.o2p.script;
//
//import java.io.IOException;
//
//import junit.framework.Assert;
//
//import org.junit.Test;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.Resource;
//import org.springframework.scripting.ScriptSource;
//import org.springframework.scripting.support.ResourceScriptSource;
//
//import com.ailk.eaap.integration.o2p.script.jsr223.PythonScriptExecutor;
//
//public class PythonScriptTest {
//	@Test
//	public void testPython() throws IOException{
//		ScriptExecutor scriptExecutor = new PythonScriptExecutor();
//		Resource resource = new ClassPathResource("/com/ailk/eaap/integration/o2p/script/hello.py");
//		Assert.assertTrue(resource.exists());
//		ScriptSource scriptSource = new ResourceScriptSource(resource);
//		scriptExecutor.executeScript(scriptSource );
//	}
//	@Test
//	public void test2(){
//		ScriptExecutor scriptExecutor = new PythonScriptExecutor();
//		Resource resource = new ClassPathResource("/com/ailk/eaap/integration/o2p/script/hello2.py");
//		Assert.assertTrue(resource.exists());
//		ScriptSource scriptSource = new ResourceScriptSource(resource);
//		scriptExecutor.executeScript(scriptSource );
//	}
//	@Test
//	public void test3(){
//		
//	}
//}
