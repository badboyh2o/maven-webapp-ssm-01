package com.nantian.dao;

import com.nantian.entity.User;

public interface UserDao {
    
    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    public User findByUsername(String username);
}
