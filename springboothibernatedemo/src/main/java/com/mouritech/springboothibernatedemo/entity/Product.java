package com.mouritech.springboothibernatedemo.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "product_info")
@EntityListeners(AuditingEntityListener.class)
public class Product {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id",length = 64)
	private String productId;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="product_price")
	private float productPrice;
	
	@Column(name="product_mfg_date")
	@LastModifiedDate
	private Date productMfgDate;
	
	@Column(name="product_exp_date")
	//@LastModifiedDate
	private Date productExpDate;
	
	
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String productName, float productPrice, Date productMfgDate, Date productExpDate) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.productMfgDate = productMfgDate;
		this.productExpDate = productExpDate;
	}

	public Product(String productName, float productPrice) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}

	public Date getProductMfgDate() {
		return productMfgDate;
	}

	public void setProductMfgDate(Date productMfgDate) {
		this.productMfgDate = productMfgDate;
	}

	public Date getProductExpDate() {
		return productExpDate;
	}

	public void setProductExpDate(Date productExpDate) {
		this.productExpDate = productExpDate;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productMfgDate=" + productMfgDate + ", productExpDate=" + productExpDate + "]";
	}
	
	
	

}
