package com.example.demo.controller;

import com.example.demo.common.Result;
import com.example.demo.entity.LoginDTO;
import com.example.demo.entity.User;
import com.example.demo.service.LoginService;
import com.example.demo.service.UserService;
import com.example.demo.utils.TokenUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    LoginService loginService;

    //    @RequestMapping(value = "/v1/user_name",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @PostMapping(value = "/api/login")
    @CrossOrigin
    public Result login(@RequestBody LoginDTO loginDTO) {
        return loginService.login(loginDTO);
    }


//    @PostMapping(value = "/api/login")
//    @CrossOrigin
//    public Result login(@RequestBody LoginDTO loginDTO){
//        User user = new User();
//        user.setUsername(loginDTO.getUsername());
//        user.setPassword(loginDTO.getPassword());
////        String token= TokenUtil.sign(user);
////        HashMap<String,Object> hs=new HashMap<>();
////        hs.put("token",token);
////        ObjectMapper objectMapper=new ObjectMapper();
//        return new Result(200,"login successfully","objectMapper");
//    }

    @PostMapping(value = "/api/register")
    @CrossOrigin
    public Result register(@RequestBody LoginDTO loginDTO) {
        return loginService.register(loginDTO);
    }
}
