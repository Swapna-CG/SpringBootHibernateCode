package com.mouritech.springboothibernatedemo.exception;

public class SellerNotFoundException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SellerNotFoundException(String message) {
		super(message);
	}

}
