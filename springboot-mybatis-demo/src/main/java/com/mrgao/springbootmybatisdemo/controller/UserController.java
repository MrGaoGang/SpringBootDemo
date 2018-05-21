package com.mrgao.springbootmybatisdemo.controller;

import com.mrgao.springbootmybatisdemo.mapper.UserMapper;
import com.mrgao.springbootmybatisdemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public void insert() {
        userMapper.insert("winterchen", "123456", "12345678910");

    }


    @RequestMapping(value = "selectAll", method = RequestMethod.GET)
    @ResponseBody
    public List<User> selectALL() {

        return userMapper.findAll();

    }
}
