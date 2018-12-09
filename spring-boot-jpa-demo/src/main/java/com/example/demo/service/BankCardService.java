package com.example.demo.service;

import com.example.demo.entity.BankCard;
import com.example.demo.resposity.NkCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class BankCardService {

    @Autowired
    NkCardRepository repository;

    public List<BankCard> save(List<BankCard >bankCard){
       return repository.saveAll(bankCard);


    }
}
