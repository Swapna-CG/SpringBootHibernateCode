package com.mouritech.springboothibernatedemo.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mouritech.springboothibernatedemo.entity.Product;
import com.mouritech.springboothibernatedemo.entity.Seller;
import com.mouritech.springboothibernatedemo.exception.ProductNameAlreadyExistsException;
import com.mouritech.springboothibernatedemo.exception.ProductNotFoundException;
import com.mouritech.springboothibernatedemo.exception.SellerNotFoundException;
import com.mouritech.springboothibernatedemo.repository.ProductRepository;
import com.mouritech.springboothibernatedemo.repository.SellerRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private SellerRepository sellerRepository;

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


	@Override
	public ResponseEntity<List<Product>> getAllProductsBySellerId(Long sellerId) throws SellerNotFoundException {
		if(!sellerRepository.existsById(sellerId)) {
			throw new SellerNotFoundException("Seller not found with id = "  + sellerId);
		}
		List<Product> products = productRepository.findBySeller(sellerId);
		return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<Product> createProduct(Long sellerId,Product newProduct) throws SellerNotFoundException {
	
		Product product = sellerRepository.findById(sellerId).map(
				seller ->{
					newProduct.setSeller(seller);
					newProduct.setProductId(generateProductId());
					return productRepository.save(newProduct);
				}).orElseThrow(()-> new SellerNotFoundException("Seller not found with id = "  + sellerId));
		return new ResponseEntity<Product>(newProduct,HttpStatus.CREATED);
	}


	@Override
	public Product getProductNameBySeller(Long sellerId,String productname) throws ProductNameAlreadyExistsException {
		return 
				productRepository.findByProductNameAndSeller(sellerId, productname).
				orElseThrow(() -> new ProductNameAlreadyExistsException("Product already exists with the name = " + productname));
	}

}
