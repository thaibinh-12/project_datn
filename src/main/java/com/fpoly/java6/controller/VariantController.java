package com.fpoly.java6.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fpoly.java6.entities.Variant;
import com.fpoly.java6.jpa.VariantJPA;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8081")
public class VariantController {
	@Autowired
	VariantJPA variantJPA;

//	@GetMapping("/variants")
//	public List<Variant> getAllVariants() {
//		return variantJPA.findAll(); // Trả về danh sách tất cả các variant
//	}
//	@GetMapping("/variants/{id}")
//    public Optional<Variant> getVariantById(@PathVariable int id) {
//        return variantJPA.findById(id); // Trả về Variant với id tương ứng
//    }
}
