package com.mouritech.springboottesting.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MessageControllerTest {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	@DisplayName("/testing message controller here.....")
	void testPrintMessageController() {
		String testMessage = "Hello!!!!";
		URI targetUrl = UriComponentsBuilder.fromUriString("/printmsg")
				.queryParam("message", "Hello!!!!")
				.build()
				.encode()
				.toUri();
		
		String testOutputMessage = this.restTemplate.getForObject(targetUrl, String.class);
		assertEquals(testOutputMessage, testMessage);
	}

}
