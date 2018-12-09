package com.example.demo.resposity;

import com.example.demo.entity.BankCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NkCardRepository extends JpaRepository<BankCard, Long> {

}