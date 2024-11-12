package com.fpoly.java6.jpa;


import org.springframework.data.jpa.repository.JpaRepository;

import com.fpoly.java6.entities.Account;



public interface AccountJPA extends JpaRepository<Account, Integer> {
}
