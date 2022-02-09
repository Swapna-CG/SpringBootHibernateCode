package com.mouritech.springboothibernatedemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mouritech.springboothibernatedemo.entity.Product;
import com.mouritech.springboothibernatedemo.entity.Seller;
import com.mouritech.springboothibernatedemo.repository.SellerRepository;

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
