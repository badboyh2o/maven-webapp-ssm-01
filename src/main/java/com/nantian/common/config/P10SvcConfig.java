package com.nantian.common.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

/**
 * P10接口配置
 * 	单例
 * @author badboyh20
 *
 */
public class P10SvcConfig {
	private static Logger log = LoggerFactory.getLogger(P10SvcConfig.class);
	private static ResourceLoader resourceLoader = new DefaultResourceLoader();
	// 当前对象实例
	private static P10SvcConfig P10SvcConfig = null;
	
	/**
	 *  静态工厂方法 获取当前对象实例
	 *  	多线程安全单例模式(使用双重同步锁)
	 */
	public static synchronized P10SvcConfig getInstance() {
		if (P10SvcConfig == null) {
			synchronized (P10SvcConfig.class) {
				if (P10SvcConfig == null)
					P10SvcConfig = new P10SvcConfig();
			}
		}
		return P10SvcConfig;
	}
	// 私有构造函数
	private P10SvcConfig() {
		Map<String, String> svcIdMap = initSvcIdMap(AppConfig.A0831D023_SVC_ID_MAP);
		initSvcIdFldNmsMap(svcIdMap);
	}
	// 保存 服务ID映射
	private Map<String, String> svcIdMap = new HashMap<String, String>();
	// 保存 服务ID-数据库查询字段映射
	private Map<String, String> svcIdFldNmsMap = new HashMap<String, String>();

	public Map<String, String> getSvcIdMap() {
		return svcIdMap;
	}
	public void setSvcIdMap(Map<String, String> svcIdMap) {
		this.svcIdMap = svcIdMap;
	}
	public Map<String, String> getSvcIdFldNmsMap() {
		return svcIdFldNmsMap;
	}
	public void setSvcIdFldNmsMap(Map<String, String> svcIdFldNmsMap) {
		this.svcIdFldNmsMap = svcIdFldNmsMap;
	}
	/**
	 * 	获取服务ID与数据库查询字段的Map
	 * 		示例	：	<"10000", "Data_Dt,Manager_No,Manager_Name">
	 * 
	 * @param svcIdMap 服务码映射,示例 <"10000", "P101Ha02">
	 * @return
	 */
	private Map<String, String> initSvcIdFldNmsMap(Map<String, String> svcIdMap) {
		//  <"10000", "P101Ha02">
		Set<Entry<String, String>> entrySet = svcIdMap.entrySet();
		for (Map.Entry<String, String> entry : entrySet) {
			String fldNms = "";
			String fileLocation = "A0831D023_query_fields/" + entry.getKey();
			InputStream is = null;
			try {
				Resource resource = resourceLoader.getResource(fileLocation);
				is = resource.getInputStream();
				BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				
				String line = null;
				while((line = reader.readLine()) != null) {
					String trimLine = line.trim();
					// 以 # 开始的一行认为是注释, 忽略空行
					if(StringUtils.isBlank(trimLine) || trimLine.startsWith("#")) {
						continue;
					}
					fldNms = fldNms + trimLine + ",";
				}
				// 去掉最后一个 ,
				String fldNmsStr = fldNms.substring(0, fldNms.length() - 1);
				// 保存到结果 Map
				svcIdFldNmsMap.put(entry.getKey(), fldNmsStr);
				
			} catch (IOException ex) {
				log.error("Could not load properties from path:" + fileLocation + ", " + ex.getMessage());
			} finally {
				IOUtils.closeQuietly(is);
			}
		}
		
		return svcIdFldNmsMap;
	}
    
	/**
	 * 将 svcIdMapStr 解析为 Map<String, String>
	 * @param svcIdMapStr
	 * @return
	 */
	private Map<String, String> initSvcIdMap(String svcIdMapStr) {
		String[] entries = svcIdMapStr.split(";");
		for(String entry : entries) {
			if(StringUtils.isBlank(entry)) {
				continue;
			}
			String[] keyVlaue = entry.split(",");
			if(!StringUtils.isBlank(keyVlaue[0])) {
				svcIdMap.put(keyVlaue[0], keyVlaue[1]);
			}
		}
		return svcIdMap;
	}
	
}
