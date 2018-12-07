package com.example.demo.service;

import com.example.demo.entity.Account;
import com.example.demo.resposity.AcountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountService {

    @Autowired
    AcountRepository acountRepository;


    public List<Account> getAllAccount(){
      return   acountRepository.findAll();
    }



    public List<Account> getAccountByName(String name){
        return  acountRepository.findByUserName(name);
    }


    public Account saveData(Account account){
      return   acountRepository.save(account);
    }
}
