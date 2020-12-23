package maven.webapp.badboyh2o.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(User model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        User user = userService.findUserByName(model.getUsername());
        
        if (user == null || !user.getPassword().equals(model.getPassword())) {
            return new ModelAndView("redirect:/login.jsp");
        } else {
            session.setAttribute("user", user);
            ModelAndView mav = new ModelAndView();
            mav.setViewName("index");
            return mav;
        }
    }
}