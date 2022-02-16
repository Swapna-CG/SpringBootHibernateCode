package com.mouritech.springbootsecurityrestexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mouritech.springbootsecurityrestexample.payload.LoginDto;
import com.mouritech.springbootsecurityrestexample.repository.RoleRepository;
import com.mouritech.springbootsecurityrestexample.repository.UserRepository;

@RestController
@RequestMapping("/api/auth")
@SuppressWarnings("unused")
public class AuthController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserRepository userRepository;
	

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/signin")
	public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto){
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginDto.getUsernameorEmail(),
						loginDto.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		return new ResponseEntity<String>("User signed-in successfully!!!!",HttpStatus.OK);
		
	}
	
	@GetMapping("/logout")
	public ResponseEntity<String> logout(){
		/*
		 * Authentication authentication =
		 * SecurityContextHolder.getContext().getAuthentication(); if(authentication !=
		 * null) { new SecurityContextLogoutHandler().logout(request, response,
		 * authentication); }
		 */
		return new ResponseEntity<String>("User signed-out successfully!!!!",HttpStatus.OK);
	}
}
