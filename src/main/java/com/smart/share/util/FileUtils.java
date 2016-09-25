package com.smart.share.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author liujie
 *
 *
 */
public class FileUtils {

	private final String DIR_BASE = "E:\\downloadfile\\";
	private Writer fileWriter = null;
	private Map<String, Writer> fileMaps = null;
	private List<String> stockList = null;

	
	
	
	public FileUtils(String[] stockList) {
		super();
		this.fileMaps = new HashMap<String, Writer>();
		this.stockList = new ArrayList<String>();
		for(String stock : stockList){
			addStock(stock);
		}
	}

	
/*	public void initFileUtils() {
		openAllFile();
	}*/

	/**
	 * Get the file stream Writer
	 * 
	 * @param filename
	 */
	private Writer openFile(String filename) throws IOException {
		BufferedWriter writer = null;
		if (filename != null) {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename,true)));
		}
		return writer;
	}

	
	/**
	 * 添加stock到list
	 * @param stock
	 */
	public void addStock(String stock) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String fileSuffix = sdf.format(date);
		if (null != fileMaps || null != stockList) {
			try {
				checkAndCreateDir(stock);
				Writer openFile = openFile(DIR_BASE + stock + "\\" + stock + "_" + fileSuffix + ".csv");
				fileMaps.put(stock, openFile);
				stockList.add(stock);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void openAllFile(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String fileSuffix = sdf.format(date);
		for(String stock : stockList){
			try {
				Writer openFile = openFile(DIR_BASE + stock + "\\" + stock + "_" + fileSuffix + ".csv");
				fileMaps.put(stock, openFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void closeAll() {
		if (null != fileMaps) {
			for (Writer writer : fileMaps.values()) {
				close(writer);
			}
			fileMaps = null;
		} else {

		}
	}

	public void writeToFile(String stockName, String content) {
		BufferedWriter writer = (BufferedWriter) fileMaps.get(stockName);
		try {
			writer.write(content);
			writer.newLine();
			writer.flush();
			writer = null;
			System.out.println("write a line:" + content);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * close writer
	 */
	private void close(Writer writer) {
		if (null != writer) {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


	private void checkAndCreateDir(String dirname) {

		File file = new File(DIR_BASE + dirname + "\\");
		if (!file.exists()) {
			file.mkdirs();
		}

	}

}
