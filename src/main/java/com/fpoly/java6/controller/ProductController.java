package com.fpoly.java6.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fpoly.java6.entities.Product;
import com.fpoly.java6.entities.Variant;
import com.fpoly.java6.model.dto.ProductDto;
import com.fpoly.java6.model.dto.VariantDto;
import com.fpoly.java6.model.mapper.ProductMapper;
import com.fpoly.java6.model.mapper.VariantMapper;
import com.fpoly.java6.service.ProductService;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8081") 
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getProductsByBrand2(
            @RequestParam(value = "brandName", required = false) String brandName) {
        
        List<ProductDto> products;
        
        if (brandName == null || brandName.isEmpty()) {
            // Nếu không có brandName, lấy tất cả sản phẩm
            products = productService.getAllProduct();
        } else {
            // Nếu có brandName, lấy sản phẩm theo thương hiệu
            products = productService.getProductsByBrand(brandName);
        }
        
        if (products.isEmpty()) {
            return ResponseEntity.noContent().build();  // Trả về 204 nếu không có sản phẩm
        }
        
        return ResponseEntity.ok(products);  // Trả về danh sách sản phẩm
    }
	
    
    
    

    @GetMapping("/brand/{brandName}")
    public ResponseEntity<List<ProductDto>> getProductsByBrand(@PathVariable String brandName) {
        List<ProductDto> products = productService.getProductsByBrand(brandName);
        if (products.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(products);
    }
  
    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDto> getProductDetails(@PathVariable("id") int id) {
        Product product = productService.getProductById(id);
        if (product == null) {
            return ResponseEntity.notFound().build(); 
        }

        // Convert Product entity to ProductDto
        ProductDto productDto = ProductMapper.tProductDto(product);

        return ResponseEntity.ok(productDto); 
    }
    
  
    

    @GetMapping("/variants")
    public ResponseEntity<List<VariantDto>> getVariants(@RequestParam int productId) {
        List<Variant> variants = productService.getVariantsByProductId(productId);
        if (variants.isEmpty()) {
            return ResponseEntity.noContent().build();  // Return 204 if no variants found
        }

        // Convert Variant entities to VariantDto
        List<VariantDto> variantDtos = variants.stream()
                .map(VariantMapper::tVariantDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(variantDtos);  // Return 200 with the list of VariantDto
    }

    @GetMapping("/sizes")
    public ResponseEntity<List<Integer>> getSizes() {
        List<Integer> sizes = productService.getSizes().stream()
                .map(size -> size.getSize())  // Assuming Size entity has a 'getName()' method
                .collect(Collectors.toList());
        if (sizes.isEmpty()) {
            return ResponseEntity.noContent().build();  // Return 204 if no sizes found
        }
        return ResponseEntity.ok(sizes);  // Return 200 with list of sizes
    }

  
    @GetMapping("/colors")
    public ResponseEntity<List<String>> getColors() {
        List<String> colors = productService.getColors().stream()
                .map(color -> color.getColor())  // Assuming Color entity has a 'getName()' method
                .collect(Collectors.toList());
        if (colors.isEmpty()) {
            return ResponseEntity.noContent().build();  // Return 204 if no colors found
        }
        return ResponseEntity.ok(colors);  // Return 200 with list of colors
    }
}
