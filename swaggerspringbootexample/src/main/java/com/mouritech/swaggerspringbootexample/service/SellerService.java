package com.mouritech.swaggerspringbootexample.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.mouritech.swaggerspringbootexample.entity.Seller;



public interface SellerService {

	ResponseEntity<List<Seller>> getAllSellers();

	Seller insertSeller(Seller newSeller);

}
