package com.smart.share.util;

import java.io.IOException;
import java.io.Reader;

import com.smart.share.stormesper.IPBean;

/**
 * 
 * @author liujie
 *
 * 2016年8月18日
 *
 */
public class FileReader {

	private IPBean[] beanArray = null;
	private Reader fileReader = null;
	
	
	
	
	/**
	 * Get the file stream Reader
	 * @param filename
	 */
	private void openFile(String filename){
		
	}
	
	public void close(){
		if(null != fileReader){
			try {
				fileReader.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}
	

}
