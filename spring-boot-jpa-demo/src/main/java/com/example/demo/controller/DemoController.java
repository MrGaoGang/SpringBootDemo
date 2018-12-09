package com.example.demo.controller;


import com.alibaba.fastjson.JSON;
import com.example.demo.entity.Account;
import com.example.demo.entity.BankCard;
import com.example.demo.resposity.AcountRepository;
import com.example.demo.service.AccountService;
import com.example.demo.service.BankCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class DemoController {


    @Autowired
    AccountService service;

    @Autowired
    BankCardService bankCardService;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public List<BankCard> getUser(@RequestBody String data) {
        Account account = JSON.parseObject(data, Account.class);
        BankCard bankCard = new BankCard();
        bankCard.setAccount(account);
        bankCard.setPassword("测试的密码1");
        bankCard.setLocaltion("==位置1");


        BankCard bankCard2 = new BankCard();
        bankCard2.setAccount(account);
        bankCard2.setPassword("测试的密码2");
        bankCard2.setLocaltion("==位置2");
        service.saveData(account);
        List<BankCard> list = new ArrayList<>();
        list.add(bankCard);
        list.add(bankCard2);
        return bankCardService.save(list);


    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Account> test() {

        return service.getAllAccount();
    }


    @RequestMapping(value = "/getUserByName", method = RequestMethod.GET)
    public String getUserByName(@RequestParam(name = "name") String na) {

        return  JSON.toJSONString(service.getAccountByName(na));
    }

}
