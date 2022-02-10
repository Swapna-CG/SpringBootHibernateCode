package com.mouritech.springbootsecuritythymeleafexample.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.mouritech.springbootsecuritythymeleafexample.controller.dto.UserRegistrationDto;
import com.mouritech.springbootsecuritythymeleafexample.entity.User;

public interface UserService extends UserDetailsService {
	
	User save(UserRegistrationDto registrationDto);

}
