package com.spring.boot.RestFileProcessing.SprinBootRestFileProcessing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SprinBootRestFileProcessingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprinBootRestFileProcessingApplication.class, args);
	}

	@Bean
	public RestTemplate restTempalte() {
		return new RestTemplate();
	}
	
}
