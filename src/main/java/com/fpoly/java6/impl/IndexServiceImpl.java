package com.fpoly.java6.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.fpoly.java6.entities.Brand;
import com.fpoly.java6.entities.Color;
import com.fpoly.java6.entities.Favorite;
import com.fpoly.java6.entities.Product;
import com.fpoly.java6.entities.Size;
import com.fpoly.java6.entities.Type;
import com.fpoly.java6.entities.Variant;
import com.fpoly.java6.model.dto.ProductDto;
import com.fpoly.java6.model.mapper.ProductMapper;
import com.fpoly.java6.service.ProductsService;

@Component
public class IndexServiceImpl implements ProductsService{

	private static ArrayList<Product> products = new ArrayList<>();
	
	static {
//	    // Khởi tạo Type
//	    Type type = new Type();
//	    type.setName("Shoes");
//
//	    // Khởi tạo Brand
//	    Brand brand = new Brand();
//	    brand.setName("Nike");
//
//	    // Tạo Size và Color
//	    Size size = new Size();
//	    size.setSize(22); // Ví dụ về kích cỡ
//
//	    Color color = new Color();
//	    color.setColor("Red"); // Ví dụ về màu sắc
//
//	    // Tạo Variant cho mỗi sản phẩm
//	    Variant variant1 = new Variant();
//	    variant1.setSize(size);
//	    variant1.setColor(color);
//	    variant1.setPrice(100);
//	    variant1.setId(1);
//	    variant1.setQuantity(10);
//
//	    // Tạo Favorite cho sản phẩm
//	    Favorite favorite = new Favorite();
//	    favorite.setId(1);
//	    // Lưu ý: Bạn cần gán đúng thông tin liên quan đến đối tượng Favorite và sản phẩm.
//
//	    // Tạo sản phẩm và thêm vào danh sách
//	    Product product1 = new Product();
//	    product1.setId(43);
//	    product1.setType(type);
//	    product1.setBrand(brand);
//	    product1.setName("Product 1");
//	    product1.setDescription("Description 1");
//	    product1.setDate(new Date());
//	    product1.setImage("abc.jpg");
//	    product1.setStatus(1);
//
//	    if (product1.getVariants() == null) {
//	        product1.setVariants(new ArrayList<>());
//	    }
//
////	    // Now you can safely add elements to the variants list
////	    product.getVariants().add(newVariant);
////	    
//	    // Thêm Variant vào Product
//	    product1.getVariants().add(variant1);
//
//	    // Thêm Favorite vào Product
//	    product1.getFavorites().add(favorite);
//
//	    // Cập nhật lại sản phẩm vào Variant
//	    variant1.setProduct(product1);
//
//	    // Thêm vào danh sách products
//	    products.add(product1);
	}

	
	
	@Override
	public List<ProductDto> getListProducts() {
		List<ProductDto> reDto = new ArrayList<ProductDto>();
		for (Product product : products) {
			reDto.add(ProductMapper.tProductDto(product));
		}
		return reDto;
	}



	@Override
	public ProductDto getProductById(int id) {
		for (Product product : products) {
			if (product.getId() == id) {
				return ProductMapper.tProductDto(product);
			}
		}
		return null;
	}



	@Override
	public List<ProductDto> searchProduct(String keyword) {
		List<ProductDto> reDtos = new ArrayList<>();
		for(Product product: products) {
			if (product.getName().contains(keyword)) {
				reDtos.add(ProductMapper.tProductDto(product));
			}
		}
		return reDtos;
	}
}
