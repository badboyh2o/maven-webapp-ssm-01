package com.nantian.common.servlet.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.nantian.common.config.AppConfig;

/**
 *日志记录 每一个请求的请求体内容
 *      如果是POST请求，则记录请求体内容
 *   TODO 如果是文件上传请求，则不记录？？
 *   TODO 统一的通信编码格式
 *
 * @author badboyh20
 *
 */
public class LogRequestInterceptor implements HandlerInterceptor {

    private static Logger log = LoggerFactory.getLogger(LogRequestInterceptor.class);
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // 记录请求
        StringBuffer reqBuf = new StringBuffer("请求：");
        
        // 如果是post请求
        if(HttpMethod.POST.toString().equals(request.getMethod())) {
            reqBuf.append(request.getServletPath()).append(" - ") .append(IOUtils.toString(request.getInputStream(), AppConfig.SERVER_HTTP_ENCODING));
        } else {
            reqBuf.append(request.getServletPath());
        }
        log.info(reqBuf.toString());
        
        // 放行
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }

}
