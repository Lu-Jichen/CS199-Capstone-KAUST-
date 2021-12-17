package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.common.Result;
import com.example.demo.entity.LoginDTO;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Result login(LoginDTO loginDTO) {
        if (StringUtils.isEmpty(loginDTO.getUsername())){
            return new Result(400,"账号不能为空","");
        }
        if (StringUtils.isEmpty(loginDTO.getPassword())){
            return new Result(400,"密码不能为空","");
        }
        //通过登录名查询用户
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", loginDTO.getUsername());
        User user= userMapper.selectOne(wrapper);
        //比较密码
        if (user!=null&&user.getPassword().equals(loginDTO.getPassword())){
            return new Result(200,"Login Successfully",user.getUserId());
        }
        return new Result(400,"Login Failed","");
    }

    @Override
    public Result register(LoginDTO loginDTO) {
        if (StringUtils.isEmpty(loginDTO.getUsername())){
            return new Result(400,"Username should not be empty!","");
        }
        if (StringUtils.isEmpty(loginDTO.getPassword())){
            return new Result(400,"Password should not be empty!","");
        }
        //通过登录名查询用户
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", loginDTO.getUsername());
        wrapper.eq("password", loginDTO.getPassword());
        User user= userMapper.selectOne(wrapper);
        if (user != null){
            return new Result(300,"Username exist!",user);
        }else{
            User insertUser = new User();
            insertUser.setUsername(loginDTO.getUsername());
            insertUser.setPassword(loginDTO.getPassword());
            int insertResult = userMapper.insert(insertUser);
            if (insertResult==1){
                return new Result(200,"Register successfully!","");
            }else{
                return new Result(400,"Register failed!","");
            }
        }
    }


}
