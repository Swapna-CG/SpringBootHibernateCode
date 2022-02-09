package com.mouritech.springboothibernatedemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mouritech.springboothibernatedemo.entity.Product;
import com.mouritech.springboothibernatedemo.entity.Seller;
import com.mouritech.springboothibernatedemo.repository.SellerRepository;
import com.mouritech.springboothibernatedemo.service.SellerService;

@RestController
@RequestMapping("seller/api/v1")
public class SellerController {
	
	@Autowired
	private SellerService sellerService;
	
	@Autowired
	private SellerRepository sellerRepo;
	
	@GetMapping("/sellers")
	public ResponseEntity<List<Seller>> getAllSellers(){
		return sellerService.getAllSellers();
	}
	
	@PostMapping("/sellers")
	public Seller insertSeller(@RequestBody Seller newSeller) {
		
		return sellerService.insertSeller(newSeller);
		
	}
	
	@GetMapping("/sortedsellers")
	public ResponseEntity<List<Seller>> sortAndShowAllSellers(@RequestParam(defaultValue = "sellerName,asc") String[] sort){
		List<Seller> sortedSellers = null;
		try {
			List<Order> orders = new ArrayList<Order>();
			if(sort[0].contains(",")) {
				//will sort more than 2 columns
				for(String sortOrder : sort) {
					String[] sOrder = sortOrder.split(",");
					orders.add(new Order(getSortDirection(sOrder[1]),sOrder[0]));
				}
			}else {
				orders.add(new Order(getSortDirection(sort[1]),sort[0]));
			}
			sortedSellers = sellerRepo.findAll(Sort.by(orders));
			if(sortedSellers.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<Seller>>(sortedSellers,HttpStatus.OK);
			
		}catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		
		
		
	}
	
	
	private Sort.Direction getSortDirection(String direction){
		if(direction.equals("asc")) {
			return Sort.Direction.ASC;
		}else if(direction.equals("desc")) {
			return Sort.Direction.DESC;
		}
		return Sort.Direction.ASC;
	}

}
