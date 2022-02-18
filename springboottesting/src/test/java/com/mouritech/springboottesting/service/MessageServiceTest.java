package com.mouritech.springboottesting.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mouritech.springboottesting.service.MessageService;

@SpringBootTest
public class MessageServiceTest {
	
	@Autowired
	private MessageService messageService;
	
	@Test
	@DisplayName("message is retrieved here....")
	void testPrintMessage() {
		String testMessage = "How r u!!!!";
		String testOutput = messageService.printMessage(testMessage);
		assertEquals(testMessage,testOutput);
	}

}
