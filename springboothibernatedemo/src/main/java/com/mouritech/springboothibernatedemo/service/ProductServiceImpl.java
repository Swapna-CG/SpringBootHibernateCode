package com.mouritech.springboothibernatedemo.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mouritech.springboothibernatedemo.entity.Product;
import com.mouritech.springboothibernatedemo.exception.ProductNotFoundException;
import com.mouritech.springboothibernatedemo.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product insertProduct(Product newProduct) {
	
		newProduct.setProductId(generateProductId());
		return productRepository.save(newProduct);
	}
	
	
	public String generateProductId() {
		Random rand = new Random(); //instance of random class
	      int upperbound = 255;
	        //generate random values from 0-254
	      Long pId = (long) rand.nextInt(upperbound);
		return "P00" + pId; 
	
	}


	@Override
	public Product showProductById(String productId) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		return productRepository.findByProductId(productId).orElseThrow(() -> new ProductNotFoundException("product not found with id " + productId));
	}


	@Override
	public List<Product> showAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}


	@Override
	public Product updateProductById(String productId,Product product) throws ProductNotFoundException {
		Product existingProduct = productRepository.findByProductId(productId).orElseThrow(() -> new ProductNotFoundException("product not found with id " + productId));
		existingProduct.setProductMfgDate(product.getProductMfgDate());
		existingProduct.setProductExpDate(product.getProductExpDate());
		productRepository.save(existingProduct);
		return existingProduct;
	}


	@Override
	public void deleteProductById(String productId) throws ProductNotFoundException {
		Product existingProduct = productRepository.findByProductId(productId).orElseThrow(() -> new ProductNotFoundException("product not found with id " + productId));
		productRepository.delete(existingProduct);
	}

}
