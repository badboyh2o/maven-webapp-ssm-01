package com.nantian.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/resources/spring-context.xml",
"file:src/main/resources/spring-mvc.xml" })
@WebAppConfiguration
public class UserServiceTest {

    // mockMvc对象
    private MockMvc mockMvc;
    @Autowired
    protected WebApplicationContext wac;
    
    @Autowired
    private UserService userService;
    
    // 这个方法在每个test方法执行之前都会执行一遍,初始化MockMvc对象
    @Before()
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }
    
    // 测试 web接口
    @Test
    public void webTest() throws Exception {
        // perform : 执行请求
        // MockMvcRequestBuilders.get("/url") ： 构造一个get请求
        mockMvc.perform(MockMvcRequestBuilders.get("/user/text")
                .contentType(MediaType.APPLICATION_JSON))
                // 期望的结果状态 200
                .andExpect(MockMvcResultMatchers.status().isOk())
                // 期望的返回结果集合有2个元素 ， $: 返回结果
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3));
    }
    
    // 测试业务层
    @Test
    public void test() {
        userService.findUserByName("1");
    }

}
