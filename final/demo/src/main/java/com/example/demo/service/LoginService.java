package com.example.demo.service;

import com.example.demo.common.Result;
import com.example.demo.entity.LoginDTO;

public interface LoginService {

    public Result login(LoginDTO loginDTO);

    public Result register(LoginDTO loginDTO);
}
