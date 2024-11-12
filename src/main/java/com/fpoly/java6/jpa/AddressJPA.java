package com.fpoly.java6.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fpoly.java6.entities.Address;

public interface AddressJPA extends JpaRepository<Address, Integer>{

}
