package com.nantian.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/resources/spring-context.xml",
"file:src/main/resources/spring-mvc.xml" })
public class UserServiceTest {

    @Autowired
    private UserService userService;
    
    @Test
    public void test() {
        userService.findUserByName("1");
    }

}
