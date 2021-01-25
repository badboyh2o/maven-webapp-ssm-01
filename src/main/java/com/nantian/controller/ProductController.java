package com.nantian.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.ClientProtocolException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nantian.common.service.HttpClientService;
import com.nantian.common.vo.ResultVO;
import com.nantian.entity.Product;
import com.nantian.service.ProductService;
import com.nantian.vo.ProductVO;


/**
 * 用户控制器
 */
@Controller
@RequestMapping(value = "/prod")
public class ProductController {
	
	private static Logger log = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private HttpClientService httpClientService;
	
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public ModelAndView update(@PathVariable("id") String id, @RequestBody ProductVO productVO, HttpServletRequest request, HttpServletResponse response) {
    	ModelAndView mav = new ModelAndView();
    	Product p = productService.find(id);
    	mav.setViewName("index");
    	mav.getModel().put("prod", p);
    	return mav;
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView get(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        Product p = productService.find(id);
        mav.setViewName("index");
        mav.getModel().put("prod", p);
        return mav;
    }
    
    
    
    
    
    
    
    
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void text(HttpServletRequest request, HttpServletResponse response) throws ClientProtocolException, IOException {
    
    	log.info(httpClientService.doGet("http://www.baidu.com/"));
    	
    }
    
    
    @ResponseBody
    @RequestMapping(value = "/json", method = RequestMethod.POST)
    public ResultVO<Map> json(@RequestBody List<Map<String, Object>> list, HttpServletRequest request, HttpServletResponse response) {
    	log.info("请求：" + list.toString());
    	
    	ResultVO<Map> result = ResultVO.getNewResultVO();
    	Map map = new HashMap<>();
    	map.put("Data_a1_1", "data1");
    	
    	result.setCode("200");
    	result.setMsg("success");
    	result.setResult(map);
    	return result;
    	
    }
    
    
    
}