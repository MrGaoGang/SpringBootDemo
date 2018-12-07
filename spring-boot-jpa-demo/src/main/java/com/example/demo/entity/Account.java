package com.example.demo.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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

  
}