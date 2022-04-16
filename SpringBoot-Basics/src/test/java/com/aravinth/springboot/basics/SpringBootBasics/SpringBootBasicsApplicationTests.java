package com.aravinth.springboot.basics.SpringBootBasics;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.aravinth.springboot.basics.SpringBootBasics.Service.PaymentService;
import com.aravinth.springboot.basics.SpringBootBasics.Service.PaymentServiceImpl;
import com.aravinth.springboot.basics.SpringBootBasics.sample.AddTwoNumber;

@SpringBootTest
class SpringBootBasicsApplicationTests {

	@Autowired
	PaymentServiceImpl service;
	 
	@Autowired
	AddTwoNumber obj;
	
	@Test
	public void testDependencyInjection() {
		System.out.println(service.getDao());
		System.out.println(obj.sumOfTwoNumber(5,5));
	}

}
