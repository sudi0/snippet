package com.sudi.study.httpclient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpClientUtil {

	public void demo1() {
		HttpClient httpClient = createHttpClient();
		String domainName = Switcher.domain;
		HttpPost httpPost = new HttpPost(domainName);
		httpPost.addHeader("Content-Type", "application/x-www-form-urlencode;charset=GBK");
		RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(1000).setSocketTimeout(1000)
				.setRedirectsEnabled(true).build();
		httpPost.setConfig(requestConfig);
		ArrayList<BasicNameValuePair> list = new ArrayList<BasicNameValuePair>();
		list.add(new BasicNameValuePair("age", "20"));
		list.add(new BasicNameValuePair("name", "zheng"));
		try {
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, "UTF-8");
			httpPost.setEntity(entity);
			HttpResponse httpResponse = httpClient.execute(httpPost);
			String strResult = "";
			if (httpResponse != null) {
				System.out.println(httpResponse.getStatusLine().getStatusCode());
				if (httpResponse.getStatusLine().getStatusCode() == 200) {
					strResult = EntityUtils.toString(httpResponse.getEntity());
				} else if (httpResponse.getStatusLine().getStatusCode() == 400) {
					strResult = "Error Response: " + httpResponse.getStatusLine().toString();
				} else if (httpResponse.getStatusLine().getStatusCode() == 500) {
					strResult = "Error Response: " + httpResponse.getStatusLine().toString();
				} else {
					strResult = "Error Response: " + httpResponse.getStatusLine().toString();
				}
			}
			System.out.println(strResult);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (httpClient != null) {
				//httpClient.close;
			}
		}

	}

	/**
	 * 3 create httpClient object
	 * 
	 * @return
	 */
	public HttpClient createHttpClient() {
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
		HttpClient httpClient = httpClientBuilder.build();
		return httpClient;
	}
}
