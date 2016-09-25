package com.smart.task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.smart.share.util.FileUtils;
import com.smart.share.util.UrlDownUtils;

/**
 * 定时访问url持久化股票数据到csv文件
 * 
 * @author liujie
 *
 *         2016年9月15日
 *
 */
public class DownloadJob implements Job {

	private final String[] stockName = { "sh601003", "sh601001" };
	private final String jobName = "";
	private FileUtils fileutil;
	/*
	 * public DownloadJob(String[] stockName, String jobName) { super();
	 * this.stockName = stockName; this.jobName = jobName; }
	 */

	public DownloadJob() {
		this.fileutil = new FileUtils(stockName);
	}

	@Override
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		for (String destination : stockName) {
			String line = UrlDownUtils.getStringFromSina(destination);
			fileutil.writeToFile(destination, line);
		}
	}

}
