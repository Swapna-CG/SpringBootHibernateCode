package com.mouritech.springboottesting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mouritech.springboottesting.service.MessageService;

@RestController
public class MessageController {
	@Autowired
	private MessageService msgService;
	
	@GetMapping("/printmsg")
	public String printMessage(@RequestParam("message") String message) {
		return msgService.printMessage(message);
		
	}

}
