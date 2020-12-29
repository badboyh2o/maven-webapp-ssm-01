package com.nantian.common.util;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;

public class HttpHelper {

    /**
     * 获取http 请求体 byte[]
     * 
     * @param httpServletRequest
     * @return
     * @throws IOException
     */
    public static byte[] getByteArray(HttpServletRequest httpServletRequest) throws IOException {
        byte[] byteArray = null;
        InputStream inputStream = null;
        try {
            inputStream = httpServletRequest.getInputStream();
            byteArray = IOUtils.toByteArray(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return byteArray;
    }
}