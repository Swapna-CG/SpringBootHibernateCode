package com.mouritech.springboottesting.service;

import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService{

	public String printMessage(String message) {
		
		return message;
	}

}
