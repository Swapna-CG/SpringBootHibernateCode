package com.mouritech.springboothibernatedemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mouritech.springboothibernatedemo.entity.Product;
import com.mouritech.springboothibernatedemo.exception.ProductNotFoundException;
import com.mouritech.springboothibernatedemo.service.ProductService;

@RestController// (@Controller + @ResponseBody)
@RequestMapping("product/api/v1")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping("product")
	public Product insertProduct(@RequestBody Product newProduct) {
		
		return productService.insertProduct(newProduct);
		
	}
	
	@GetMapping("product")
	public List<Product> showAllProducts(){
		return productService.showAllProducts();
		
	}
	
	@GetMapping("product/{pid}")
	public Product showProductById(@PathVariable("pid") String productId) throws ProductNotFoundException{
		return productService.showProductById(productId);
		
	}
	
	@PutMapping("product/{pid}")
	public Product updateProductById(@PathVariable("pid") String productId,@RequestBody Product product) throws ProductNotFoundException{
		return productService.updateProductById(productId,product);
		
	}
	
	@DeleteMapping("product/{pid}")
	public String deleteProductById(@PathVariable("pid") String productId) throws ProductNotFoundException{
		 productService.deleteProductById(productId);
		 return "deleted the product";
		
	}
	

	
	
}
