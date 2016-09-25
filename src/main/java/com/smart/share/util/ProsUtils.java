package com.smart.share.util;

import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.support.PropertiesLoaderUtils;

public class ProsUtils {
	
	private Properties props = null;
	
	private  void readProps() {
		Properties props = new Properties();
		try {
			props = PropertiesLoaderUtils.loadAllProperties("stocks.properties");

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
