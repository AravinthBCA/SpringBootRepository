package com.aravinth.spring.boot.SpringBoot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
class ApplicationTests {

	@Autowired
	ApplicationContext context;
	
	@Test
	public void testService() {
		Service service = context.getBean(Service.class);
		service.save();
	}

}
