package com.exampro.controller;

import com.exampro.mapper.UserMapper;
import com.exampro.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class helloController {
    @Autowired
    private UserMapper userMapper;
    @GetMapping("/user")
    public List query(){
        List<User> list = userMapper.find();
        System.out.println(list);
        return list;
    }
}
