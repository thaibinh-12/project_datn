package com.fpoly.java6.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpoly.java6.entities.Product;
import com.fpoly.java6.jpa.ProductJPA;
import com.fpoly.java6.model.dto.ProductDto;

@Service
public interface ProductsService {
//	@Autowired
//	private ProductJPA productJPA;
//	
//	public default Product saveOrUpdateProduct(Product product) {
//		Optional<Product> extProduct = productJPA.findById(product.getId());
//		if (extProduct.isPresent()) {
//			Product product2 = extProduct.get();
//			
//			product2.setName(product.getName());
//			product2.setBrand(product.getBrand());
//			product2.setDescription(product.getDescription());
//			product2.setType(product.getType());
//			product2.setImage(product.getImage());
//			product2.setStatus(product.getStatus());
//			
//			return productJPA.save(product2);
//		}else {
//			return productJPA.save(product);
//		}
//	}
//
//	public void deleteProduct(int id) {
//		if (productJPA.existsById(id)) {
//			productJPA.deleteById(id);
//		}else {
//			throw new IllegalArgumentException("Product id: "+id+"error");
//		}
//	}
//
//	public Optional<Product> getProductById(int id){
//		return productJPA.findById(id);
//	}
//	public List<Product> getAllProduct(){
//		return productJPA.findAll();
//	}
//	public boolean productExists(int id) {
//		return productJPA.existsById(id);
//	}
	
	public List<ProductDto> getListProducts();
	
	public ProductDto getProductById(int id);
	
	public List<ProductDto> searchProduct(String keyword);
}
