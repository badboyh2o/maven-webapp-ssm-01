package com.nantian.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nantian.common.config.AppConfig;
import com.nantian.common.service.HttpClientService;
import com.nantian.common.vo.ResultVO;
import com.nantian.service.P10DataService;
import com.nantian.util.XstreamUtil;
import com.nantian.vo.P10ReqVO;
import com.nantian.vo.P10ResultDataVO;
import com.nantian.vo.p10.resp.TxRespVO;


@Service
public class P10DataServiceImpl implements P10DataService {
	
	private static Logger log = LoggerFactory.getLogger(P10DataServiceImpl.class);
	@Autowired
	private HttpClientService httpClientService;

	
	/**
	 * 调 总行P10 http接口，获取到数据后，封装为 ResultVO<P10ResultDataVO> 返回
	 */
	@Override
	public ResultVO<P10ResultDataVO> getData(P10ReqVO req) {
		String reqXml = createP10ReqXml(req);
		Map<String, String> header = new HashMap<String, String>();
		header.put("Content-Type", "application/x-www-form-urlencoded; charset=" + AppConfig.A0831D023_ENCODING);
		String respXml = httpClientService.doPost(AppConfig.A0831D023_URL, header, reqXml, AppConfig.A0831D023_ENCODING);
		TxRespVO txRespVO = XstreamUtil.xmlToBean(respXml, TxRespVO.class);
		ResultVO<P10ResultDataVO> p10DataResult = createP10DataResult(txRespVO);
		return p10DataResult;
	}

	
	/**
	 * 解析P10的响应,转换为 ResultVO<P10ResultDataVO>
	 * @param txRespVO
	 * @return
	 */
	private ResultVO<P10ResultDataVO> createP10DataResult(TxRespVO txRespVO) {
		
		
		
		return null;
	}


	/**
	 * 构造 P10 接口xml 报文
	 * @param req
	 * @return
	 */
	private String createP10ReqXml(P10ReqVO req) {
		
		
		
		return null;
	}

}
