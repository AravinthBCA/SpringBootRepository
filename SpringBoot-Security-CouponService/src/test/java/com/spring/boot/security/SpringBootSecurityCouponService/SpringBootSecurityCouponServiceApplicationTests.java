package com.spring.boot.security.SpringBootSecurityCouponService;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

@SpringBootTest
class SpringBootSecurityCouponServiceApplicationTests {

	@Test
	public void contextLoads() {
//		System.out.println(new Pbkdf2PasswordEncoder("secret", 10000, 128).encode("password"));
//		System.out.println("Doug = "+new SCryptPasswordEncoder().encode("doug"));
		System.out.println("Doug = "+new BCryptPasswordEncoder().encode("password"));
		System.out.println("Doug = "+new BCryptPasswordEncoder().encode("password"));

//		Map<String, PasswordEncoder> encoders = new HashMap<>();
//		encoders.put("bcrypt", new BCryptPasswordEncoder());
//		encoders.put("scrypt", new SCryptPasswordEncoder());
//		encoders.put("pbkdf2", new Pbkdf2PasswordEncoder());
//
//		System.out.println(new DelegatingPasswordEncoder("bcrypt", encoders).encode("doug"));

	}

}
