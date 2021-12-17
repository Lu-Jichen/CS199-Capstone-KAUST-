package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserInfoService;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class UserTests {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserService userService;

    @Autowired
    UserInfoService userInfoService;



    @Test
    @DisplayName("Select by id")
    public void testSelectById(){
        User user=userMapper.selectById(1);
        System.out.println(user.toString());
    }

    @Test
    @DisplayName("Create user")
    public void createNewUser(){
        User user = new User();
        user.setUsername("tester2");
        user.setPassword("123");
        int insertResult = userMapper.insert(user);
        System.out.println(insertResult);
    }

    @Test
    @DisplayName("Create user")
    public void getUserList(){
        List<User> data = userService.list();
        System.out.println(data);
    }

    @Test
    @DisplayName("Create user")
    public void userInfoTest(){
        System.out.println(userInfoService.getById(1));
    }

}
