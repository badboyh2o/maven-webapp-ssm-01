package maven.webapp.badboyh2o.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import maven.webapp.badboyh2o.domain.User;
import maven.webapp.badboyh2o.service.impl.UserService;

/**
 * 用户控制器
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	private static Logger log = LoggerFactory.getLogger(UserController.class);
	
	
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(User model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        
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
}