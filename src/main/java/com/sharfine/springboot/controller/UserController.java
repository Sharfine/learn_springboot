package com.sharfine.springboot.controller;

import com.sharfine.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/mybatisSelect")
    public String getOne(Integer id){
       return userService.selectUser(id).toString();
    }
}
