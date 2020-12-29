package com.nantian.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.nantian.common.servlet.RequestWrapper;

/**
 * 过滤器
 * 
 *      包装请求，请求被servlet处理之前，将请求体写入到包装请求的 body 属性中。
 *      疑问：如果请求体是文件，这样内存占用高？
 *
 */
public class ChannelFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("ChannelFilter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        ServletRequest requestWrapper = null;
        
        // ！包装请求，将请求体写入到包装请求的 requestBody中
        if (request instanceof HttpServletRequest) {
            requestWrapper = new RequestWrapper((HttpServletRequest) request);
        }
        
        if (requestWrapper == null) {
            chain.doFilter(request, response);
        } else {
            chain.doFilter(requestWrapper, response);
        }
    }

    @Override
    public void destroy() {
        System.out.println("ChannelFilter destroy");
    }

}
