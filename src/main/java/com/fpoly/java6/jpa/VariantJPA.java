package com.fpoly.java6.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fpoly.java6.entities.Variant;


public interface VariantJPA extends JpaRepository<Variant, Integer>{

}
