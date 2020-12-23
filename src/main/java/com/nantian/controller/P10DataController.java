package com.nantian.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nantian.common.vo.ResultVO;
import com.nantian.service.P10DataService;
import com.nantian.vo.P10ReqVO;
import com.nantian.vo.P10ResultDataVO;

/**
 * P10接口数据处理器
 * 	总行P10接口服务码是 A0831D023
 * @author badboyh20
 *
 */
@Controller
@RequestMapping(value = "/A0831D023")
public class P10DataController {
	
	private static Logger log = LoggerFactory.getLogger(P10DataController.class);
	@Autowired
	private P10DataService p10DataService;
	
	/**
	 * 返回P10接口数据
	 * 
	 * @param req
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping(value = "/data",  method = RequestMethod.POST)
	public ResultVO<P10ResultDataVO> getData(@RequestBody P10ReqVO req, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		log.debug("收到请求");
		return p10DataService.getData(req);
	}

}