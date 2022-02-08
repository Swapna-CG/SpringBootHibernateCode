package com.mouritech.springboothibernatedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringboothibernatedemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringboothibernatedemoApplication.class, args);
	}

}
