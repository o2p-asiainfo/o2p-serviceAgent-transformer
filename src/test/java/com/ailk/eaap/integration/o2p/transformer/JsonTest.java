/** 
 * Project Name:o2p-serviceAgent-transformer 
 * File Name:JsonTest.java 
 * Package Name:com.ailk.eaap.integration.o2p.transformer 
 * Date:2016年1月15日下午10:47:36 
 * Copyright (c) 2016, www.asiainfo.com All Rights Reserved. 
 * 
*/  
  
package com.ailk.eaap.integration.o2p.transformer;  

import java.util.Iterator;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import com.jayway.jsonpath.JsonPath;

/** 
 * ClassName:JsonTest  
 * Function: TODO ADD FUNCTION.  
 * Reason:   TODO ADD REASON.  
 * Date:     2016年1月15日 下午10:47:36  
 * @author   wuwz 
 * @version   
 * @since    JDK 1.6 
 *        
 */
public class JsonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String json = "{\"a\":\"1\"}";
		JSONObject obj = JSONObject.fromObject(json);
		JSONObject obj1 = obj.getJSONObject("b");
		if(obj1 == null || obj1.isNullObject()) {
			System.out.print("it ok");
		}
	}

	@Test
	public void testjson()
		throws Exception {
		
		String jsonStr = "{                             "+
		"  \"MainProdInfo\": [{           "+
		"    \"subscriber_id\": \"1\",     "+
		"    \"offer_code\": \"2\",        "+
		"    \"start_date\": \"3\",        "+
		"    \"end_date\": \"4\"           "+
		"  }]                           "+
		"}                             ";
		
		
		JSONObject json = JSONObject.fromObject(jsonStr);
		Object MainProdInfo = JsonPath.read(json, "$.MainProdInfo");
		if(MainProdInfo instanceof JSONArray) {
			
			JSONArray array = (JSONArray)MainProdInfo;
			JSONObject tarArray0 = (JSONObject)array.get(0);
			for(Object obj : array) {
				
				JSONObject o = (JSONObject)obj;
				o.put("a", "1");
			}
			array.clear();
			System.out.println(tarArray0.toString());
		}
		System.out.println(MainProdInfo.toString());
		
//		jsonTemplateBuild(json, "$.MainProdInfo.end_date","2005-01-01");
//		json.remove("MainProdInfo");
		System.out.print(json.toString());
	}
	
	private void jsonTemplateBuild(Object jsonObject,
			String jsonPath, String value) {
		if(jsonObject != null) {
//			log.debug(jsonObject.toString());
		}
		if(!StringUtils.isEmpty(jsonPath)) {
			
			String[] paths = jsonPath.split("\\.");
			
			String lastKey = paths[paths.length-1];
			
			getObject(jsonObject, paths, 1, lastKey, value);
		}
	}
	
	private void getObject(Object object, String[] paths, int i,
			String lastKey, String lastValue) {
		
		/*if(object instanceof JSONObject) {
			
			if(((JSONObject)object).containsKey(lastKey)) {
				((JSONObject)object).remove(lastKey);
				((JSONObject)object).put(lastKey, lastValue);

				return;
			} else {
				
				getObject(((JSONObject)object).get(paths[i]),paths,i+1,lastKey, lastValue);
			}
		
		} else if (object instanceof JSONArray) {
			Iterator it = ((JSONArray)object).iterator();
			while(it.hasNext()) {
				Object subObj = it.next();
				getObject(subObj,paths,i+1,lastKey, lastValue);
			}
		}*/
		if(i==paths.length-1){
			JSONObject json = (JSONObject)object;
			json.put(lastKey, lastValue);
		}else{
			String path = paths[i];
			int seq = 0;
			if(path.contains("[")){
				String numberStr = path.substring(path.indexOf("[")+1, path.indexOf("]"));
				path = path.substring(0, path.indexOf("["));
				seq = Integer.parseInt(numberStr);
			}
			
			JSONObject json = (JSONObject)object;
			object = json.get(path);
			
			if(object instanceof JSONArray){
				JSONArray ja = (JSONArray)object;
				object = ja.get(seq);
			}
			
			getObject(object, paths, i+1,
					lastKey, lastValue) ;
		}
		
		
		
	}
	
	@Test
	public void testJsonClear(){
		
		String jsonStr = getJson();
		JSONObject json = JSONObject.fromObject(jsonStr);
		System.out.println("before=============>"+json.toString());
		clearJsonValue(json);
		System.out.println("after=============>"+json.toString());
	}
	
	public void clearJsonValue(JSONObject json) {
		Iterator<String> keys = json.keys();
		
		while (keys.hasNext()) {
			
			String key = keys.next();
			Object obj = json.get(key);
			
			if (obj instanceof String) {
				
				json.put(key, "");
			} else if (obj instanceof JSONObject) {
				
				JSONObject jsonObj = (JSONObject) obj;
				clearJsonValue(jsonObj);
			} else if(obj instanceof JSONArray) {
				
				JSONArray jsonArray = (JSONArray) obj;
				for(Object o : jsonArray) {
					
					JSONObject jsonObj = (JSONObject)o;
					clearJsonValue(jsonObj);
				}
			}
		}
	}

	private String getJson() {

		String str = "{                                                                        "+
				"    \"ServiceInfo\": {                                                   "+
				"        \"ProdInfo\": {                                                  "+
				"            \"MainProdInfos\": {                                         "+
				"                \"MainProdInfo\": {                                      "+
				"                    \"ProdId\": \"2102574\",                             "+
				"                    \"ProdName\": \"WIMP\",                              "+
				"                    \"UserId\": \"42101110075021\",                      "+
				"                    \"ActType\": \"M\",                                  "+
				"                    \"ProdPrptyInfo\": [                                 "+
				"                        {                                                "+
				"                            \"PrptyName\": \"subscriber_id\",            "+
				"                            \"PrptyValue\": \"+33612345678\",            "+
				"                            \"ActType\": \"M\"                           "+
				"                        },                                               "+
				"                        {                                                "+
				"                            \"PrptyName\": \"offer_code\",               "+
				"                            \"PrptyValue\": \"1201\",                    "+
				"                            \"ActType\": \"M\"                           "+
				"                        },                                               "+
				"                        {                                                "+
				"                            \"PrptyName\": \"start_date\",               "+
				"                            \"PrptyValue\": \"2099-12-31\",              "+
				"                            \"ActType\": \"M\"                           "+
				"                        },                                               "+
				"                        {                                                "+
				"                            \"PrptyName\": \"end_date\",                 "+
				"                            \"PrptyValue\": \"2099-12-31+23:59:59\",     "+
				"                            \"ActType\": \"M\"                           "+
				"                        }                                                "+
				"                    ]                                                    "+
				"                }                                                        "+
				"            }                                                            "+
				"        }                                                                "+
				"    }                                                                    "+
				"}                                                                        ";

		return str;
	}
}
