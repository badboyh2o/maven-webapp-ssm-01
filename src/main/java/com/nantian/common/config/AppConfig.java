package com.nantian.common.config;


/**
 * 映射 application.properties的配置
 * 
 * @author badboyh20
 *
 */
public class AppConfig {

	// A0831D023 服务码对应的url
	public static String A0831D023_URL = Global.getConfig("A0831D023.url");
	// A0831D023 服务通信 encoding
	public static String A0831D023_ENCODING = Global.getConfig("A0831D023.encoding");
}
