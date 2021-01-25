package com.nantian.dao;

import org.apache.ibatis.annotations.Param;

import com.nantian.entity.Product;

/**
 * 要使用持久层，需要取消 spring-context.xml 中的注释 
 * 
 * @author badboyh20
 *
 */
public interface ProductDao {
    
    public Product find(@Param("id") String id);
}
