package com.nantian.common.config;

/**
 * 映射 application.properties的配置
 * 
 * @author badboyh20
 *
 */
public class AppConfig {
    // 本系统的http服务的编码格式
    public static String SERVER_HTTP_ENCODING = Global.getConfig("server.http.encoding");
    
	// A0831D023 服务码对应的url
	public static String A0831D023_URL = Global.getConfig("A0831D023.url");
	// A0831D023 服务通信 encoding
	public static String A0831D023_ENCODING = Global.getConfig("A0831D023.encoding");
	// 服务编号映射， 如 <10000, P101Ha02>
	public static String A0831D023_SVC_ID_MAP = Global.getConfig("A0831D023.svcIdMap");
	
}
