package com.ailk.eaap.integration.o2p.expression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.wltea.expression.ExpressionEvaluator;
import org.wltea.expression.datameta.Variable;

import com.ailk.eaap.op2.bo.NodeDesc;

public class ExpressionEvaluatorTest {
	@Test
	public void test(){
		String press = "src_node==null";
		List<Variable> variables = new ArrayList<Variable>();
//		variables.add(Variable.createVariable("src_node", 2));
		Object result=ExpressionEvaluator.evaluate(press, variables );  
		Boolean flag = Boolean.valueOf(String.valueOf(result));
		Assert.assertTrue(flag);
	}
	@Test
	public void testString(){
		NodeDesc a = new NodeDesc();
		a.setNodePath("[1,10]");
		a.setNevlConsValue("davidzhua");
		NodeDesc b = new NodeDesc();
		b.setNodePath("[11,20]");
		b.setNevlConsValue("davidzhua");
		Object[] src = new Object[]{"[30,40]","[20,25]",a.getNodePath(),"[15,20]",b.getNodePath()};
		Arrays.sort(src);
		System.out.println(Arrays.toString(src));
	}
}
