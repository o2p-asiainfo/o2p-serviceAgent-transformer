/** 
 * Project Name:o2p-serviceAgent-transformer 
 * File Name:ValueParseTest.java 
 * Package Name:com.ailk.eaap.integration.o2p.transformer 
 * Date:2015年12月25日上午9:22:49 
 * Copyright (c) 2015, www.asiainfo.com All Rights Reserved. 
 * 
*/  
  
package com.ailk.eaap.integration.o2p.transformer;  

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;
import org.wltea.expression.ExpressionEvaluator;
import org.wltea.expression.datameta.Variable;

import com.ailk.eaap.integration.o2p.transformer.service.impl.TransformerFunctionServiceImpl;
import com.ailk.eaap.op2.serviceagent.common.MessageBO;

/** 
 * ClassName:ValueParseTest  
 * Function: TODO ADD FUNCTION.  
 * Reason:   TODO ADD REASON.  
 * Date:     2015年12月25日 上午9:22:49  
 * @author   wuwz 
 * @version   
 * @since    JDK 1.6 
 *        
 */
public class ValueParseTest {

	public static void main(String[] args) throws DocumentException {

//		contactTest();
		dateTest();
//		subStringTest();
//		
//		String jsonStr = getJsonStr();
//		JSONObject json = JSONObject.fromObject(jsonStr);
//		
//		MessageBO<Document> mb = new MessageBO<Document>();
//		mb.setMsgBody(getDocument());
//		
//		
//		getNodeValue(mb, json);
//		
//		System.out.println(json.toString());
//		System.out.println(getDocument().asXML());
	}


	private static void dateTest() {
		
		//定义表达式       
//		  String expression = "fn:dateFormat(\"2015-09-00\", \"yyyy-mm-dd\",\"yyyy/MM/dd hh:mm:ss\")";  
//		String expression =   "fn:dateFormat(fn:SYSDATE(), \"yyyy-mm-dd\",\"yyyy/MM/dd hh:mm:ss\")";  
//		String expression =   "fn:sysdate(\"yyyy-MM-dd hh:mm:ss\")";  
		String expression =   "fn:sysdate(\"yyyy-MM-dd\")";
		String var ="returytype";
//		String expression ="1 > 1 ";
		TransformerFunctionServiceImpl t = new TransformerFunctionServiceImpl();
		  expression = t.funcDeal(expression);
		  List<Variable> variables = new ArrayList<Variable>();
          variables.add(Variable.createVariable(var, "1"));
		    //执行表达式  
		    Object result = ExpressionEvaluator.evaluate(expression, variables);  
		    System.out.println("SUBSTRING Result = " + result); 
		
	}


	private static void subStringTest() {

		 //定义表达式       
		   String expression = "$SUBSTRING($SUBSTRING(src_node_val,0,2),0,1)";  
		   List<Variable> variables = new ArrayList<Variable>();
           variables.add(Variable.createVariable("src_node_val", "ABCDEFGHI"));
           
		    //执行表达式  
		    Object result = ExpressionEvaluator.evaluate(expression, variables);  
		    System.out.println("SUBSTRING Result = " + result); 
		
	}


	private static void contactTest() {

		
		 //定义表达式       
	   String expression = "fn:concat($a,\"b\",\"23\")";  
	 
	   TransformerFunctionServiceImpl t = new TransformerFunctionServiceImpl();
	   expression = t.funcDeal(expression);
	 
	    //执行表达式  
	    Object result = ExpressionEvaluator.evaluate(expression, null);  
	    System.out.println("contact Result = " + result); 

	}


	private static void getNodeValue(MessageBO<Document> mb, JSONObject json) {

		JSONObject option = json.getJSONObject("option");
		
		String finalVariableName = json.getString("finalVariable");
		List<Variable> finalVariables = new ArrayList<Variable>();
        
		JSONArray finalFunctions = json.getJSONArray("functions");
		
		JSONArray cases = option.getJSONArray("cases");
		for(Object obj : cases) {
			
			JSONObject jobj = (JSONObject)obj;
			JSONObject condition = jobj.getJSONObject("condition");
			
			Object result = getCondition(mb, condition);  
			boolean flag = Boolean.valueOf(String.valueOf(result));
			
			if(flag) {
				
				JSONObject value = jobj.getJSONObject("value");
				String src_node_val = value.getString("src_node_val");
				String variableName = value.getString("variable");
				JSONArray functions = value.getJSONArray("functions");

				String nodeValue = getValue(mb, src_node_val);
				
				List<Variable> variables = new ArrayList<Variable>();
				variables.add(Variable.createVariable(variableName, nodeValue));
				
				String newValue = function(variableName, variables, functions);
				if(!StringUtils.isEmpty(newValue)) {
					
					nodeValue = newValue;
				}
				
				finalVariables.add(Variable.createVariable(variableName, nodeValue));
			}
		}
		
		String finalValue = function(finalVariableName, finalVariables, finalFunctions);
		System.out.println(finalValue);
	}


	private static String function(String variableName, List<Variable> variables, JSONArray functions) {
		
		String newValue = "";
		for(Object functionObj : functions) {
			
			JSONObject function = (JSONObject)functionObj;
			String funcName = function.getString("name");
			if(StringUtils.isEmpty(funcName)) {
				
				break;
			} else if("$CONTACT".equals(funcName)) {
				
//				newValue = MyString.contact(variables);
			} else {
				
				StringBuffer ikExpressSb = new StringBuffer();
				ikExpressSb.append(funcName).append("(");
				
				JSONArray args = function.getJSONArray("args");
				for(Object argObj : args) {
					
					JSONObject arg = (JSONObject)argObj;
					String param = arg.getString("param");
					ikExpressSb.append(param).append(",");
				}
				
				String ikExpress = ikExpressSb.toString().substring(0, ikExpressSb.toString().length()-1)+")";
				
				Object result = ExpressionEvaluator.evaluate(ikExpress, variables);  
				newValue = result.toString();
			}
			
			List<Variable> newVariables = new ArrayList<Variable>();
			variables.add(Variable.createVariable(variableName, newValue));
			variables = newVariables;
		}
		
		return newValue;
	}


	private static Object getCondition(MessageBO<Document> mb,
			JSONObject condition) {
		String unionConditions = condition.getString("unionConditions");
		
		JSONArray subConditions = condition.getJSONArray("subConditions");
		for(Object subObj : subConditions) {
			
			JSONObject subConditionObj = (JSONObject)subObj;
			String src_node_val = subConditionObj.getString("src_node_val");
			String subExpress = subConditionObj.getString("subExpress");
			String variable = subConditionObj.getString("variable");
			
			String nodeValue = getValue(mb, src_node_val);
			String conditionResult = getResult(nodeValue, subExpress);
			
			unionConditions = unionConditions.replace(variable, conditionResult);
		}
		
		Object result=ExpressionEvaluator.evaluate(unionConditions, null);
		return result;
	}


	private static String getResult(String nodeValue, String subExpress) {

		 List<Variable> variables = new ArrayList<Variable>();
         
         variables.add(Variable.createVariable("src_node_val", nodeValue));
         Object result = ExpressionEvaluator.evaluate(subExpress, variables);
         
         return result.toString();
	}


	private static String getValue(MessageBO<Document> mb,
			String src_node_val) {

		Node node = mb.getMsgBody().selectSingleNode(src_node_val);
		if(node != null) {
			
			return node.getText();
		}
		
		return null;
	}


	private static String getJsonStr() {
		
		String jsonStr = "{                                                                                                                                                         "+
				"    \"finalVariable\": \"v\",                                                                                                                                "+
				"    \"functions\": [{                                                                                                                                       "+
				"        \"name\": \"$CONTACT\",                                                                                                                            "+
				"        \"args\": [                                                                                                                                       "+
				"            {                                                                                                                                             "+
				"                \"param\": \"v1\"                                                                                                                         "+
				"            },                                                                                                                                            "+
				"            {                                                                                                                                             "+
				"                \"param\": \"v2\"                                                                                                                         "+
				"            },                                                                                                                                            "+
				"            {                                                                                                                                             "+
				"                \"param\": \"v3\"                                                                                                                         "+
				"            }                                                                                                                                             "+
				"        ]                                                                                                                                                 "+
				"    }],                                                                                                                                                    "+
				"    \"option\": {                                                                                                                                         "+
				"        \"cases\": [                                                                                                                                      "+
				"            {                                                                                                                                             "+
				"                \"condition\": {                                                                                                                          "+
				"                    \"subConditions\": [                                                                                                                  "+
				"                        {                                                                                                                                 "+
				"                            \"src_node_val\": \"/ServiceInfo/ProdInfo/MainProdInfos/MainProdInfo/ProdPrptyInfo[PrptyName='FIRST_NAME']/PrptyName\",       "+
				"                            \"subExpress\": \"src_node_val==\\\"FIRST_NAME\\\"\",                                                                         "+
				"                            \"variable\": \"var1\"                                                                                                        "+
				"                        }                                                                                                                                 "+
				"                    ],                                                                                                                                    "+
				"                    \"unionConditions\": \"var1\"                                                                                                         "+
				"                },                                                                                                                                        "+
				"                \"value\": {                                                                                                                              "+
				"                    \"src_node_val\": \"/ServiceInfo/ProdInfo/MainProdInfos/MainProdInfo/ProdPrptyInfo[PrptyName='FIRST_NAME']/PrptyValue\",              "+
				"                    \"variable\": \"v1\",                                                                                                                 "+
				"                    \"functions\": [{                                                                                                                       "+
				"                        \"name\": \"$SUBSTRING\",                                                                                                                   "+
				"                        \"args\": [                                                                                                                       "+
				"                            {                                                                                                                             "+
				"                                \"param\": \"v1\"},                                                                                                           "+
				"                            {                                                                                                                             "+
				"                                \"param\": \"0\"},                                                                                                           "+
				"                            {                                                                                                                             "+
				"                                \"param\": \"2\"                                                                                                           "+
				"                            }                                                                                                                             "+
				"                        ]                                                                                                                                 "+
				"                    }]                                                                                                                                     "+
				"                }                                                                                                                                         "+
				"            },                                                                                                                                            "+
				"            {                                                                                                                                             "+
				"                \"condition\": {                                                                                                                          "+
				"                    \"subConditions\": [                                                                                                                  "+
				"                        {                                                                                                                                 "+
				"                            \"src_node_val\": \"/ServiceInfo/ProdInfo/MainProdInfos/MainProdInfo/ProdPrptyInfo[PrptyName='MIDDLE_NAME']/PrptyName\",      "+
				"                            \"subExpress\": \"src_node_val==\\\"MIDDLE_NAME\\\"\",                                                                        "+
				"                            \"variable\": \"var2\"                                                                                                        "+
				"                        }                                                                                                                                 "+
				"                    ],                                                                                                                                    "+
				"                    \"unionConditions\": \"var2\"                                                                                                         "+
				"                },                                                                                                                                        "+
				"                \"value\": {                                                                                                                              "+
				"                    \"src_node_val\": \"/ServiceInfo/ProdInfo/MainProdInfos/MainProdInfo/ProdPrptyInfo[PrptyName='MIDDLE_NAME']/PrptyValue\",             "+
				"                    \"variable\": \"v2\",                                                                                                                 "+
				"                    \"functions\": [{                                                                                                                       "+
				"                        \"name\": \"\",                                                                                                                   "+
				"                        \"args\": [                                                                                                                       "+
				"                            {                                                                                                                             "+
				"                                \"param\": \"\"                                                                                                           "+
				"                            }                                                                                                                             "+
				"                        ]                                                                                                                                 "+
				"                    }]                                                                                                                                     "+
				"                }                                                                                                                                         "+
				"            },                                                                                                                                            "+
				"            {                                                                                                                                             "+
				"                \"condition\": {                                                                                                                          "+
				"                    \"subConditions\": [                                                                                                                  "+
				"                        {                                                                                                                                 "+
				"                            \"src_node_val\": \"/ServiceInfo/ProdInfo/MainProdInfos/MainProdInfo/ProdPrptyInfo[PrptyName='LAST_NAME']/PrptyName\",        "+
				"                            \"subExpress\": \"src_node_val==\\\"LAST_NAME\\\"\",                                                                          "+
				"                            \"variable\": \"var3\"                                                                                                        "+
				"                        }                                                                                                                                 "+
				"                    ],                                                                                                                                    "+
				"                    \"unionConditions\": \"var3\"                                                                                                         "+
				"                },                                                                                                                                        "+
				"                \"value\": {                                                                                                                              "+
				"                    \"src_node_val\": \"/ServiceInfo/ProdInfo/MainProdInfos/MainProdInfo/ProdPrptyInfo[PrptyName='LAST_NAME']/PrptyValue\",               "+
				"                    \"variable\": \"v3\",                                                                                                                 "+
				"                    \"functions\": [{                                                                                                                       "+
				"                        \"name\": \"\",                                                                                                                   "+
				"                        \"args\": [                                                                                                                       "+
				"                            {                                                                                                                             "+
				"                                \"param\": \"\"                                                                                                           "+
				"                            }                                                                                                                             "+
				"                        ]                                                                                                                                 "+
				"                    }]                                                                                                                                     "+
				"                }                                                                                                                                         "+
				"            }                                                                                                                                             "+
				"        ],                                                                                                                                                "+
				"        \"default\": {                                                                                                                                    "+
				"            \"value\": \"\",                                                                                                                              "+
				"            \"functions\": [{                                                                                                                               "+
				"                \"name\": \"\",                                                                                                                           "+
				"                \"args\": [                                                                                                                               "+
				"                    {                                                                                                                                     "+
				"                        \"param\": \"\"                                                                                                                   "+
				"                    }                                                                                                                                     "+
				"                ]                                                                                                                                         "+
				"            }]                                                                                                                                             "+
				"        }                                                                                                                                                 "+
				"    }                                                                                                                                                     "+
				"}                                                                                                                                                         ";
		return jsonStr;
	}


	private static Document getDocument() throws DocumentException {
		String docStr = "<ServiceInfo>                                                      "+
				"    <ProdInfo>                                                     "+
				"        <MainProdInfos>                                            "+
				"            <MainProdInfo>                                         "+
				"                <ProdId>1188</ProdId>                              "+
				"                <ProdName>wimp(bundle)</ProdName>                  "+
				"                <ActType>A</ActType>                               "+
				"                <ProdPrptyInfo>                                    "+
				"                    <PrptyName>FIRST_NAME</PrptyName>              "+
				"                    <PrptyValue>FIRST_NAME</PrptyValue>                     "+
				"                    <ActType>A</ActType>                           "+
				"                </ProdPrptyInfo>                                   "+
				"                <ProdPrptyInfo>                                    "+
				"                    <PrptyName>MIDDLE_NAME</PrptyName>             "+
				"                    <PrptyValue>M</PrptyValue>                     "+
				"                    <ActType>A</ActType>                           "+
				"                </ProdPrptyInfo>                                   "+
				"                <ProdPrptyInfo>                                    "+
				"                    <PrptyName>LAST_NAME</PrptyName>               "+
				"                    <PrptyValue>L</PrptyValue>                     "+
				"                    <ActType>A</ActType>                           "+
				"                </ProdPrptyInfo>                                   "+
				"                <ProdPrptyInfo>                                    "+
				"                    <PrptyName>999999990015</PrptyName>            "+
				"                    <PrptyValue>13840001252</PrptyValue>           "+
				"                    <ActType>A</ActType>                           "+
				"                </ProdPrptyInfo>                                   "+
				"            </MainProdInfo>                                        "+
				"        </MainProdInfos>                                           "+
				"    </ProdInfo>                                                    "+
				"</ServiceInfo>                                                     ";
		
		Document doc = DocumentHelper.parseText(docStr);
		return doc;
	}
}
