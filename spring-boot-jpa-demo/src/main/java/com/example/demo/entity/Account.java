package com.example.demo.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "Account")
@Data
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "age")
    private Integer age;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

    @Column(name = "password")
    private String password;

    @Column(name = "user_name")
    private String userName;


    //此mappingBy时BankCard中的account字段
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<BankCard> bankCardList;

}