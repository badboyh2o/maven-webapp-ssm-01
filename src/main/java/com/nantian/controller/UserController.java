package com.nantian.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nantian.common.config.AppConfig;
import com.nantian.common.vo.ResultVO;
import com.nantian.entity.User;
import com.nantian.service.UserService;


/**
 * 用户控制器
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	private static Logger log = LoggerFactory.getLogger(UserController.class);
	
	
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@RequestBody User model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
    	log.info("66" + model.toString());
    	User user = userService.findUserByName("11");
    	log.info(user.toString());
    	
    	//session.setAttribute("user", user); // 不生效 ?
    	
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("index");
    	mav.getModel().put("user", user);
    	return mav;
    	
    	/*
        if (user == null || !user.getPassword().equals(model.getPassword())) {
            return new ModelAndView("redirect:/login.jsp");
        } else {
            session.setAttribute("user", user);
            ModelAndView mav = new ModelAndView();
            mav.setViewName("index");
            return mav;
        }
        */
    }
    
    @ResponseBody
    @RequestMapping(value = "/json", method = RequestMethod.POST)
    public ResultVO<Map> json(@RequestBody List<Map<String, Object>> list, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
    	log.info(AppConfig.getConfig("server.port"));
    	log.info("请求：" + list.toString());
    	
    	ResultVO<Map> result = ResultVO.getNewResultVO();
    	Map map = new HashMap<>();
    	map.put("Data_a1_1", "data1");
    	
    	result.setCode("200");
    	result.setMsg("success");
    	result.setData(map);
    	return result;
    	
    }
    
    
    
}