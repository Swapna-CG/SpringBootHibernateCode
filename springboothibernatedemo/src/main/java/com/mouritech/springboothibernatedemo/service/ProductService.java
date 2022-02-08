package com.mouritech.springboothibernatedemo.service;

import java.util.List;

import com.mouritech.springboothibernatedemo.entity.Product;
import com.mouritech.springboothibernatedemo.exception.ProductNotFoundException;

public interface ProductService {

	Product insertProduct(Product newProduct);

	Product showProductById(String productId) throws ProductNotFoundException;

	List<Product> showAllProducts();



	Product updateProductById(String productId, Product product) throws ProductNotFoundException;

	void deleteProductById(String productId) throws ProductNotFoundException;

}
