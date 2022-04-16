package com.springboot.assignment.restapi.AssignmentRestApI;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.springboot.assignment.restapi.AssignmentRestApI.Entities.Student;

@SpringBootTest
class AssignmentRestApIApplicationTests {

	@Test
	void testGetProduct() {
		RestTemplate restTemplate = new RestTemplate();
		Student student = restTemplate.getForObject("localhost:8080/students/students/1",Student.class);
		System.out.println(student);
	}
	
	@Test
	void testCreateStudent() {
		RestTemplate restTemplate = new RestTemplate();
		Student stud = new Student();
		stud.setId(1);
		stud.setName("Aravinth");
		stud.setTestscore(100);
		Student student = restTemplate.postForObject("localhost:8080/students/",stud,Student.class);
		System.out.println("Student Name : "+stud.getName());
	}
	
	@Test
	void testUpdateProduct() {
		RestTemplate restTemplate = new RestTemplate();
		Student student = restTemplate.getForObject("localhost:8080/students/students/1",Student.class);
		student.setTestscore(500);
		restTemplate.put("localhost:8080/students/students/1",student);
		System.out.println(student);
	}
	

}
