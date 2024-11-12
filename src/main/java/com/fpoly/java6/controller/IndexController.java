package com.fpoly.java6.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fpoly.java6.entities.Brand;
import com.fpoly.java6.entities.Product;
import com.fpoly.java6.entities.Type;
import com.fpoly.java6.jpa.BrandJPA;
import com.fpoly.java6.jpa.ProductJPA;
import com.fpoly.java6.jpa.TypeJPA;
import com.fpoly.java6.model.dto.ProductDto;
import com.fpoly.java6.service.ProductsService;

@RestController
@RequestMapping("/index")
public class IndexController {

	@Autowired
	ProductJPA productJPA;

	@Autowired
	BrandJPA brandJPA;
	
	@Autowired
	ProductsService productsService;

//	@RequestMapping("/index")
//	public String getIndex(Model model) {
//		List<Brand> brands = brandJPA.findAll();
//		
//		Map<String, List<Product>> brandProductMap = new HashMap<>();
//		Map<String, Integer> productCountMap = new HashMap<>();
//		for (Brand brand : brands) {
//			List<Product> products = productJPA.findByBrand(brand);
//			brandProductMap.put(brand.getName(), products.size() > 4 ? products.subList(0, 4) : products);
//			productCountMap.put(brand.getName(), products.size());
//		}
//			model.addAttribute("brands", brands);
//			model.addAttribute("brandProductMap", brandProductMap);
//		model.addAttribute("productCountMap", productCountMap);
//		return "user/index";
//	}
	
	 @GetMapping("")
	    public ResponseEntity<?> getListProduct() {
	        List<ProductDto> products = productsService.getListProducts();
	        return ResponseEntity.ok(products);
	    }

	    // Lấy thông tin sản phẩm theo ID
	    @GetMapping("/{id}")
	    public ResponseEntity<?> getProductById(@PathVariable int id) {
	        ProductDto reDto = productsService.getProductById(id);
	        if (reDto == null) {
	            return ResponseEntity.notFound().build();  // Trả về mã lỗi 404 nếu không tìm thấy sản phẩm
	        }
	        return ResponseEntity.ok(reDto);
	    }

	    // Tìm kiếm sản phẩm theo tên
	    @GetMapping("/search")
	    public ResponseEntity<?> searchProduct(@RequestParam(name = "keyword", required = false, defaultValue = "") String name) {
	        List<ProductDto> product = productsService.searchProduct(name);
	        return ResponseEntity.ok(product);
	    }

}
