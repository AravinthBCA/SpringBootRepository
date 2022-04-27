package com.spring.boot.security.SpringBootSecurity.RestControllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping("/hello")
	public 	String hello(){
		return "Sping Security Rocks!!";
	}
	
	@GetMapping("/bye")
	public 	String bye(){
		return "Sping Security bye!!";
	}

}
