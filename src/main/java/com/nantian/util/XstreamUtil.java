package com.nantian.util;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
/**
 * XStream-1.4.9
 *
 */
public class XstreamUtil {
	
	public static String beanToXml(Object bean, String encoding){
		// new DomDriver()
		//XStream xstream = new XStream(new DomDriver());
		
	    // 解决字段带有下划线时序列化输出两个下划线的问题
        XStream xstream = new XStream(new DomDriver(encoding, new XmlFriendlyNameCoder("_-", "_")));
        
		
		xstream.autodetectAnnotations(true);
		String xml = xstream.toXML(bean);
		return xml;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T xmlToBean(String xml, Class<T> clazz){
		// new DomDriver()
		XStream xstream = new XStream(new DomDriver());
		xstream.autodetectAnnotations(true);
		// ? set class -- xstream-1.3.1.jar; 1.4 no necessary
		xstream.processAnnotations(clazz);
		// 1.4.9 ignoreUnknowElements
		xstream.ignoreUnknownElements();
		T bean = (T)xstream.fromXML(xml);
		return bean;
	}
	
}
