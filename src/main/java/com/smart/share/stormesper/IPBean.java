package com.smart.share.stormesper;

import  org.slf4j.Logger;
import  org.slf4j.LoggerFactory;

/**
 * NetWork IP Status bean
 * @author liujie
 *
 * 2016年8月18日
 *
 */
public class IPBean {
	final static Logger logger  =  LoggerFactory.getLogger(IPBean.class );
	private long ID;
	private String ipaddress;
	private String productID;
	private String clientID;
	private String viewID;
	private String appType;
	private String eventType;
	private String deviceType;
	
	public static void main(String...args){
		logger.info( " Temperature has risen above 50 degrees. " );
		logger.error( " Temperature set to {}. Old temperature was {}. " , 1, 2);
}
	
}
