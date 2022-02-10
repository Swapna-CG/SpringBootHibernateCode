package com.mouritech.springboothibernatedemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mouritech.springboothibernatedemo.entity.Product;
import com.mouritech.springboothibernatedemo.exception.ProductNameAlreadyExistsException;
import com.mouritech.springboothibernatedemo.exception.ProductNotFoundException;
import com.mouritech.springboothibernatedemo.exception.SellerNotFoundException;
import com.mouritech.springboothibernatedemo.repository.ProductRepository;
import com.mouritech.springboothibernatedemo.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "CRUD REST API's for Product resources")
@RestController// (@Controller + @ResponseBody)
@RequestMapping("product/api/v1")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	ProductRepository productRepo;
	
	
	@PostMapping("product")
	
	public Product insertProduct(@RequestBody Product newProduct) {
		
		return productService.insertProduct(newProduct);
		
	}
	
	@GetMapping("product")
	public List<Product> showAllProducts(){
		return productService.showAllProducts();
		
	}
	
	@GetMapping("product/{pid}")
	@ApiOperation(value = "Find product by id",
    notes = "Returns a product matched with given id")
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
	

	@GetMapping("/products/{sellerid}")
	public ResponseEntity<List<Product>> getAllProductsBySellerId(@PathVariable("sellerid") Long sellerId) throws SellerNotFoundException {
		return productService. getAllProductsBySellerId(sellerId);
	}
	
	@PostMapping("/products/{sellerid}/seller")
	public ResponseEntity<Product> createProduct(@PathVariable("sellerid") Long sellerId,
			@RequestBody Product newProduct) throws SellerNotFoundException {
		return productService.createProduct(sellerId,newProduct);
		
	}
	
	@GetMapping("/products/{sellerid}/{productname}")
	public Product getProductNameBySeller(@PathVariable("sellerid") Long sellerId,
			@PathVariable("productname") String productname) throws SellerNotFoundException, ProductNameAlreadyExistsException {
		return productService. getProductNameBySeller(sellerId,productname);
	}
	
	
	
}
