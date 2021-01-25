package com.nantian.common.servlet;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import com.nantian.common.util.HttpHelper;

/**
 * 自定义的 http请求包装类，解决 @RequestBdody request.getInputStream() stream close
 * 
 *      实例化时将请求体写入到 body
 *   getInputStream()则从 body 读取 
 *   
 *   
 *   ？ request.getParameter("xx") 为 null ?
 *   
 *
 */
public class RequestWrapper extends HttpServletRequestWrapper {

    // 请求体
    private final byte[] body;

    public RequestWrapper(HttpServletRequest request) throws IOException {
        super(request);
        // 实例化时将请求体写入 body
        body = HttpHelper.getByteArray(request);
    }

    // 重写 getReader()
    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(getInputStream()));
    }

    // 重写 getInputStream()
    @Override
    public ServletInputStream getInputStream() throws IOException {
        final ByteArrayInputStream bais = new ByteArrayInputStream(body);
        return new ServletInputStream() {
            // 重写 read() 从 body读取请求体数据
            @Override
            public int read() throws IOException {
                return bais.read();
            }
            
            @Override
            public boolean isFinished() {
                return false;
            }
            @Override
            public boolean isReady() {
                return false;
            }
            @Override
            public void setReadListener(ReadListener readListener) {
            }
        };
    }

}
