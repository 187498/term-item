package com.scu03.text;

import java.io.IOException;

import org.apache.commons.httpclient.Header;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;

import org.apache.commons.httpclient.methods.PostMethod;

 

/**

 * ��ʵ��ʱ�����й������ṩ�Ľӿڣ���ϧÿ���û�ֻ����ѵ���������

 * �й������ṩ��SMSƽ̨�������˺ŵ�ַ��http://sms.webchinese.cn/default.shtml

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
		
		String juzi = "���ã�������֤��Ϊ"+code+"���ʽ𱦡�";

		PostMethod post = new PostMethod("http://utf8.sms.webchinese.cn");

		post.addRequestHeader("Content-Type",

				"application/x-www-form-urlencoded;charset=utf8");// ��ͷ�ļ�������ת��

		NameValuePair[] data = { new NameValuePair("Uid", "zijinbao1"), // ע����û���

				//new NameValuePair("Key", "166985"), // ע��ɹ���,��¼��վʹ�õ���Կ

				new NameValuePair("Key", "d41d8cd98f00b204e980"), // ע��ɹ���,��¼��վʹ�õ���Կ

				new NameValuePair("smsMob", phone),  // �ֻ�����

				new NameValuePair("smsText", juzi) };//���ö������ݣ�

                                                                                                                     //һ��Ҫ���ź���Ҫ����ǩ������

 

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

