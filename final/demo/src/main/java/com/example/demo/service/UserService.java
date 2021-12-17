package com.example.demo.service;

import com.example.demo.common.Result;
import com.example.demo.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.UserInfo;

public interface UserService extends IService<User> {

    UserInfo getUserInfo(User user);

    int editUserInfo(UserInfo userInfo);

}
