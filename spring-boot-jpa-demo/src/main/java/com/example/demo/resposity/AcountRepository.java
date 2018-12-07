package com.example.demo.resposity;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public interface AcountRepository extends JpaRepository<Account, Integer> {

    @Query(value = "select t from Account t where t.userName like %:name%")
    List<Account> findByUserName(@Param("name") String name);



}