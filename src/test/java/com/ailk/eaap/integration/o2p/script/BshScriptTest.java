//package com.ailk.eaap.integration.o2p.script;
//
//import java.io.IOException;
//
//import junit.framework.Assert;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.junit.Test;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.Resource;
//import org.springframework.scripting.ScriptSource;
//import org.springframework.scripting.bsh.BshScriptFactory;
//import org.springframework.scripting.support.ResourceScriptSource;
//
//public class BshScriptTest {
//	protected final Log logger = LogFactory.getLog(this.getClass());
//	@Test
//	public void test() throws IOException{
//		Resource resource = new ClassPathResource("/com/ailk/eaap/integration/o2p/script/hello.bsh");
//		Assert.assertTrue(resource.exists());
//		String scriptSourceLocator = resource.getFile().getAbsolutePath();
//		logger.info("the resource file path="+scriptSourceLocator);
//		BshScriptFactory bshFac = new BshScriptFactory(scriptSourceLocator );
//		ScriptSource scriptSource = new ResourceScriptSource(resource);
//		Object obj = bshFac.getScriptedObject(scriptSource , new Class[]{bsh.This.class});
//	}
//}
