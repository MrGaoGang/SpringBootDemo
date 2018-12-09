package com.example.demo.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "bank_card")
@Data
public class BankCard  implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;

    @Column(name = "card_id")
    String cardID;

    @Column(name = "registe_local")
    String localtion;

    @Column(name = "card_password")
    String password;


    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)//可选属性optional=false,表示account不能为空。删除card，不影响用户
    @JoinColumn(name="account_id")//设置在BankCard表中的关联字段(外键)
    Account account;
}
