package com.nantian.dao;

import com.nantian.entity.Demo;

/**
 * 要使用持久层，需要取消 spring-context.xml 中的注释 
 * 
 * @author badboyh20
 *
 */
public interface UserDao {
    
    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    public Demo findByUsername(String username);
}
