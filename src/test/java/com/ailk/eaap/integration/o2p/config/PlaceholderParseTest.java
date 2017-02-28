package com.ailk.eaap.integration.o2p.config;

import org.junit.Test;

public class PlaceholderParseTest {
	private String placeholderPrefix = "#{";
	private String placeholderSuffix = "}";
	@Test
	public void test(){
		System.out.println(parseStringValue("#{paramMapType  }"));
	}
	private String parseStringValue(String strVal)
	{
		String retStr = null;

		int startIndex = strVal.indexOf(this.placeholderPrefix);
		int endIndex = strVal.indexOf(this.placeholderSuffix);
		retStr = strVal.substring(startIndex+this.placeholderPrefix.length(), endIndex);
		return retStr.trim();
	}
}
