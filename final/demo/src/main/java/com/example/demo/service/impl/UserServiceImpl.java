package com.example.demo.service.impl;

import com.example.demo.common.Result;
import com.example.demo.entity.User;
import com.example.demo.entity.UserInfo;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public UserInfo getUserInfo(User user) {
        return userMapper.getUserInfo(user);
    }

    @Override
    public int editUserInfo(UserInfo userInfo) {
        return 0;
    }
}
