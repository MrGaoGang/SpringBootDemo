package com.example.demo.controller;


import com.alibaba.fastjson.JSON;
import com.example.demo.entity.Account;
import com.example.demo.resposity.AcountRepository;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class DemoController {



    @Autowired
    AccountService service;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public  Account getUser(@RequestBody String data){
        Account account=JSON.parseObject(data,Account.class);
        return  service.saveData(account);
    }

    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public List<Account> test(){

        return service.getAllAccount();
    }



    @RequestMapping(value = "/getUserByName" ,method = RequestMethod.GET)
    public List<Account> getUserByName(@RequestParam(name = "name") String na){
      return   service.getAccountByName(na);
    }

}
