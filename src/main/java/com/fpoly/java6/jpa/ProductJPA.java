package com.fpoly.java6.jpa;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fpoly.java6.entities.Brand;
import com.fpoly.java6.entities.Product;

@Repository
public interface ProductJPA extends JpaRepository<Product, Integer>{
	@Query("SELECT p FROM Product p WHERE p.brand.name = :brandName")
	List<Product> findByBrandName(@Param("brandName") String brandName);

	Page<Product> findAll(Pageable pageable);
}
