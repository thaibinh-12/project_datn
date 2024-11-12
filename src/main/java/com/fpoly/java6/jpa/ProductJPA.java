package com.fpoly.java6.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fpoly.java6.entities.Brand;
import com.fpoly.java6.entities.Product;

public interface ProductJPA extends JpaRepository<Product, Integer>{
	List<Product> findByBrand(Brand brand);

}
