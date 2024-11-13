package com.fpoly.java6.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fpoly.java6.entities.Brand;
import com.fpoly.java6.entities.Color;
import com.fpoly.java6.entities.Product;
import com.fpoly.java6.entities.Size;
import com.fpoly.java6.entities.Variant;
import com.fpoly.java6.jpa.BrandJPA;
import com.fpoly.java6.jpa.ColorJPA;
import com.fpoly.java6.jpa.ProductJPA;
import com.fpoly.java6.jpa.SizeJPA;
import com.fpoly.java6.jpa.VariantJPA;
import com.fpoly.java6.model.dto.ProductDto;
import com.fpoly.java6.model.mapper.ProductMapper;

@Service
public class ProductService {

	@Autowired
	private ProductJPA productJPA;

	@Autowired
	private VariantJPA variantJPA;

	@Autowired
	private SizeJPA sizeJPA;

	@Autowired
	private BrandJPA brandJPA;

	@Autowired
	private ColorJPA colorJPA;

	public List<Product> findAllProducts() {
//	        Pageable pageable = PageRequest.of(page, size);  // Tạo Pageable cho phân trang
		return productJPA.findAll(); // Lấy dữ liệu phân trang từ repository
	}

	public Product getProductById(int id) {
		return productJPA.findById(id).orElse(null);
	}

	public List<Variant> getVariantsByProductId(int productId) {
		return variantJPA.findByProductId(productId);
	}

	public List<Size> getSizes() {
		return sizeJPA.findAll();
	}

	public List<Color> getColors() {
		return colorJPA.findAll();
	}

	  public List<ProductDto> getProductsByBrand(String brandName) {
	        // Lấy danh sách sản phẩm theo tên thương hiệu và chuyển sang ProductDto
	        return productJPA.findByBrandName(brandName).stream()
	                .map(ProductMapper::tProductDto)
	                .collect(Collectors.toList());
	    }

	  public List<ProductDto> getAllProduct() {
	        return productJPA.findAll().stream()
	                .map(ProductMapper::tProductDto)
	                .collect(Collectors.toList());
	    }
	 


}
