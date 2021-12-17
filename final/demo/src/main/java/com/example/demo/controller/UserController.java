package com.example.demo.controller;


import com.example.demo.common.Result;
import com.example.demo.entity.LoginDTO;
import com.example.demo.entity.User;
import com.example.demo.entity.UserInfo;
import com.example.demo.service.UserInfoService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import java.util.List;


@RestController
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    UserInfoService userInfoService;

    @GetMapping(value = "/api/user/list")
    @CrossOrigin
    public Result getUserList() {
        List<User> data = userService.list();
        return new Result(200,"Get user list successfully!",data);
    }

    @PostMapping(value = "/api/userInfo")
    @CrossOrigin
    public Result getUserInfo(@RequestBody User user) {
        UserInfo userInfo = userInfoService.getById(user.getUserId());
        userInfo.setGenderDesNew();
        userInfo.setBirthdayNew();
        return new Result(200,"Get user list successfully!",userInfo);
    }

    @PostMapping(value = "/api/userInfo/edit")
    @CrossOrigin
    public Result editUserInfo(@RequestBody UserInfo userInfo) {
        userInfo.setGenderNew();
        userInfoService.updateById(userInfo);
        return new Result(200,"Get user list successfully!","");
    }

}

