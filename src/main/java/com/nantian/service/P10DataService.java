package com.nantian.service;

import com.nantian.common.vo.ResultVO;
import com.nantian.vo.P10ReqVO;
import com.nantian.vo.P10ResultDataVO;

/**
 * P10 接口
 * 	接口代码	A0831D023
 * 
 * @author badboyh20
 *
 */
public interface P10DataService {

	/**
	 * 调P10 http接口获取数据
	 * @param reqXml	请求xml报文
	 * @return
	 */
	ResultVO<P10ResultDataVO> getData(P10ReqVO req);
}
