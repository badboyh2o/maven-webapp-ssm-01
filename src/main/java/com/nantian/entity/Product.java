package com.nantian.entity;

import java.math.BigDecimal;

public class Product {
    private String id;
    private String name;
    private BigDecimal price;

    // 构造函数
    public Product() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void BigDecimal(BigDecimal price) {
        this.price = price;
    }
    
}
