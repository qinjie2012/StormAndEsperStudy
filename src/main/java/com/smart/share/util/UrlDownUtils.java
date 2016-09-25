package com.smart.share.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlDownUtils {
	
	private static final String SINAURL = "http://hq.sinajs.cn/list=";
	
	
	private static String explain(String line){
		
		
		return line;
	}
	
	public static String getStringFromSina(String destination) {
		String content = null;
		try {
			URL sinaUrl = new URL("http://hq.sinajs.cn/list=" + destination);
			HttpURLConnection connection = (HttpURLConnection) sinaUrl.openConnection();
			InputStream input = connection.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(input,"GB2312"));
			content = reader.readLine();
			input.close();
			reader.close();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			
		}
		return explain(content);
	}
}
