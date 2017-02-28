/** 
 * Project Name:o2p-serviceAgent-transformer 
 * File Name:Bsh2JsonPath.java 
 * Package Name:com.ailk.eaap.integration.o2p.process 
 * Date:2015年7月1日下午2:44:23 
 * Copyright (c) 2015, www.asiainfo.com All Rights Reserved. 
 * 
 */

package com.ailk.eaap.integration.o2p.process;

import com.jayway.jsonpath.JsonPath;

/**
 * ClassName:Bsh2JsonPath 
 * Function: TODO ADD FUNCTION. 
 * Reason: TODO ADD REASON. 
 * Date: 2015年7月1日 下午2:44:23 
 * 
 * @author zhongming
 * @version
 * @since JDK 1.6
 * 
 */
public final class Bsh2JsonPath
{
    // 解决Bsh内不能直接解析JsonPath
    public static Object read(String json, String jsonPath)
    {
        Object object = JsonPath.read(json, jsonPath);
        return object;
    }
}
