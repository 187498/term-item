package com.scu03.text;

import java.io.IOException;

import org.apache.commons.httpclient.Header;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;

import org.apache.commons.httpclient.methods.PostMethod;

 

/**

 * 本实例时利用中国网建提供的接口，可惜每个用户只有免费的五条短信

 * 中国网建提供的SMS平台、申请账号地址：http://sms.webchinese.cn/default.shtml

 * @author Administrator

 *

 */

public class TextSending {
	public static void main(String args[]) throws HttpException, IOException{
		TextSending tx = new TextSending();
		String phone = "17711048381";
		tx.sending(phone);
	}
	public String sending(String phone) throws HttpException, IOException {

 
		
		HttpClient client = new HttpClient();
		int rand = (int)(Math.random()*10000);
		String code = String.valueOf(rand);
		
		String juzi = "您好，您的验证码为"+code+"【资金宝】";

		PostMethod post = new PostMethod("http://utf8.sms.webchinese.cn");

		post.addRequestHeader("Content-Type",

				"application/x-www-form-urlencoded;charset=utf8");// 在头文件中设置转码

		NameValuePair[] data = { new NameValuePair("Uid", "zijinbao1"), // 注册的用户名

				//new NameValuePair("Key", "166985"), // 注册成功后,登录网站使用的密钥

				new NameValuePair("Key", "d41d8cd98f00b204e980"), // 注册成功后,登录网站使用的密钥

				new NameValuePair("smsMob", phone),  // 手机号码

				new NameValuePair("smsText", juzi) };//设置短信内容，

                                                                                                                     //一定要短信后面要加上签名【】

 

		post.setRequestBody(data);

 

		client.executeMethod(post);

		Header[] headers = post.getResponseHeaders();

		int statusCode = post.getStatusCode();

		System.out.println("statusCode:" + statusCode);

		for (Header h : headers) {

			System.out.println(h.toString());

		}

		String result = new String(post.getResponseBodyAsString().getBytes(

				"utf8"));

		System.out.println(result);

		post.releaseConnection();
		
		return code;
	}

}

