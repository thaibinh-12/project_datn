package com.fpoly.java6.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fpoly.java6.entities.Color;
import com.fpoly.java6.entities.Variant;
import com.fpoly.java6.jpa.ColorJPA;
import com.fpoly.java6.jpa.VariantJPA;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8081")
public class ColorController {
	@Autowired
	ColorJPA colorJPA;

//	@GetMapping("/colors")
//	public List<Color> getAllColor() {
//		return colorJPA.findAll(); 
//	}
//	
//	@GetMapping("/colors/{id}")
//    public Optional<Color> getColorById(@PathVariable int id) {
//        return colorJPA.findById(id); // Trả về Variant với id tương ứng
//    }
}
