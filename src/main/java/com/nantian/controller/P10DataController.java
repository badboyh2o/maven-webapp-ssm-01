package com.nantian.controller;

import java.io.InputStream;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nantian.common.servlet.RequestWrapper;
import com.nantian.common.util.HttpHelper;
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
	 * 	@Valid 这里使用了jsr 303 bean valid, 留意 VO 中的 valid 注解
	 *  @Valid , BindingResult result  必须在参数列表中紧挨着 ？
	 * 
	 * @param req
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping(value = "/data",  method = RequestMethod.POST)
	public ResultVO<P10ResultDataVO> getData(@Valid @RequestBody P10ReqVO req, BindingResult result, HttpServletRequest request) throws Exception {
		/*
		if(result.hasErrors()) {
			List<ObjectError> errorList = result.getAllErrors();
			for(ObjectError error : errorList){
				log.info("evtTranceId: " + req.getEvtTraceId());
				log.error(error.getDefaultMessage());
				break;
			}
			
			// TODO
			throw new IllegalArgumentException();
		}
		*/
	    
	    // 使用处理器拦截器记录请求
	    // String body = IOUtils.toString(request.getInputStream());
	    
		return p10DataService.getData(req);
	}

}
