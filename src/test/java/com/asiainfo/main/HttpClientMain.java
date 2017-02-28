/** 
 * Project Name:o2p-serviceAgent-transformer 
 * File Name:HttpClient.java 
 * Package Name:com.asiainfo.main 
 * Date:2015年2月5日下午4:18:39 
 * Copyright (c) 2015, www.asiainfo.com All Rights Reserved. 
 * 
 */

package com.asiainfo.main;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.ByteArrayRequestEntity;
import org.apache.commons.httpclient.methods.EntityEnclosingMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;

/**
 * ClassName:HttpClient 
 * Function: TODO ADD FUNCTION. 
 * Reason: TODO ADD REASON. 
 * Date: 2015年2月5日 下午4:18:39 
 * 
 * @author zhongming
 * @version
 * @since JDK 1.6
 * 
 */
public class HttpClientMain implements Runnable {

	public static void main(String[] args) {
		for(int i = 0 ; i< 50; i++){
			new Thread(new HttpClientMain()).start();
		}
	}

	@Override
	public void run() {
		long time1 = 0;
		// 创建HttpClient实例
		HttpClient httpClient = new HttpClient();
		byte b[] = xml.getBytes();
		RequestEntity requestEntity = new ByteArrayRequestEntity(b);

		EntityEnclosingMethod postMethod = new PostMethod();
		postMethod.setRequestEntity(requestEntity);// 设置数据
		// postMethod
		// .setPath("http://192.168.1.56:18080/serviceAgentWeb/webservice/rechargeBase/gdec");//
		// 设置服务的url
		postMethod
				.setPath("http://10.6.0.155:8080/serviceAgent/webservice/testBase/testec");
		postMethod.setRequestHeader("Content-Type", "text/xml;charset=GBK");// 设置请求头编码

		// 设置连接超时
		httpClient.getHttpConnectionManager().getParams()
				.setConnectionTimeout(600 * 1000);
		// 设置读取超时
		httpClient.getHttpConnectionManager().getParams()
				.setSoTimeout(5 * 1000);

		String responseMsg = "";
		int statusCode = 0;
		try {
			time1 = System.currentTimeMillis();
			statusCode = httpClient.executeMethod(postMethod);// 发送请求
			responseMsg = postMethod.getResponseBodyAsString();// 获取返回值
			System.out.println("return " + responseMsg);
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			postMethod.releaseConnection();// 释放连接
		}

		if (statusCode != HttpStatus.SC_OK) {
			System.out.println("HTTP服务异常" + statusCode);
		}
		long time2 = System.currentTimeMillis();

		System.out.println("time : " + time2 + " - " + time1 + " = "
				+ (time2 - time1));

	}

	static String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
			+ "<ContractRoot>" + "<TcpCont>"
			+ "<TransactionID>1000000083201311020128223844</TransactionID>"
			+ "<AppKey>1005</AppKey>"
			+ "<Method>test.PackageOrder</Method>" 
			+ "<Version>1.0</Version>"
			+ "<Sign>1000000047</Sign>" 
			+ "<ReqTime>20131102102255</ReqTime>"
			+ "</TcpCont>" + "<SvcCont>"
			+ "<ORDER_ID>20140716150600</ORDER_ID>"
			+ "<PHONE_NUM>13331149809</PHONE_NUM>"
			+ "<OFFER_CODE>1001</OFFER_CODE>"
			+ "<OFFER_NAME>10元流量包</OFFER_NAME>"
			+ "<ORDER_DATE>201407161507</ORDER_DATE>" + "</SvcCont>"
			+ "</ContractRoot>";

}
