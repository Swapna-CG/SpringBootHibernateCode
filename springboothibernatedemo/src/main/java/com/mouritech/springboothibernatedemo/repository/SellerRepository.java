package com.mouritech.springboothibernatedemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mouritech.springboothibernatedemo.entity.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long> {

	List<Seller> findBySellerId(Long sellerId);

}
