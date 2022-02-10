package com.mouritech.springbootsecuritythymeleafexample.controller.dto;

public class UserRegistrationDto {
	
	private String userFName;
	private String userLName;
	private String userEmail;
	private String userPassword;
	
	public UserRegistrationDto() {
		// TODO Auto-generated constructor stub
	}

	public UserRegistrationDto(String userFName, String userLName, String userEmail, String userPassword) {
		super();
		this.userFName = userFName;
		this.userLName = userLName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
	}

	public String getUserFName() {
		return userFName;
	}

	public void setUserFName(String userFName) {
		this.userFName = userFName;
	}

	public String getUserLName() {
		return userLName;
	}

	public void setUserLName(String userLName) {
		this.userLName = userLName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	

}
