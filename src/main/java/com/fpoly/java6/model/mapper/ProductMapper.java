package com.fpoly.java6.model.mapper;

import com.fpoly.java6.entities.Product;
import com.fpoly.java6.model.dto.ProductDto;

public class ProductMapper {

	public static ProductDto tProductDto(Product product) {
		ProductDto tmp = new ProductDto();
		tmp.setId(product.getId());
		tmp.setName(product.getName());
		tmp.setBrand(product.getBrand());
		tmp.setDate(product.getDate());
		tmp.setDescription(product.getDescription());
		tmp.setFavorites(product.getFavorites());
		tmp.setImage(product.getImage());
		tmp.setStatus(product.getStatus());
		tmp.setType(product.getType());
		tmp.setVariants(product.getVariants());
		
		return tmp;
	}
}
