package com.mouritech.springboothibernatedemo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.mouritech.springboothibernatedemo.entity.Product;
import com.mouritech.springboothibernatedemo.entity.Seller;

public interface SellerService {

	ResponseEntity<List<Seller>> getAllSellers();

	Seller insertSeller(Seller newSeller);

}
