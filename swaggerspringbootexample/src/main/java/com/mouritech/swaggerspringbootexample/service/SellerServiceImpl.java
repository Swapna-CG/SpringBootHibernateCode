package com.mouritech.swaggerspringbootexample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mouritech.swaggerspringbootexample.entity.Seller;
import com.mouritech.swaggerspringbootexample.repository.SellerRepository;



@Service
public class SellerServiceImpl implements SellerService {
	
	@Autowired
	SellerRepository sellerRepository;

	@Override
	public ResponseEntity<List<Seller>> getAllSellers() {
		List<Seller> sellers = sellerRepository.findAll();
		if(sellers.isEmpty()) {
			return new ResponseEntity<List<Seller>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Seller>>(sellers,HttpStatus.OK); 
		
	}

	@Override
	public Seller insertSeller(Seller newSeller) {
		// TODO Auto-generated method stub
		return sellerRepository.save(newSeller);
	}
}
