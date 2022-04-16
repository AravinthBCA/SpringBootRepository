package com.springboot.assignment.restapi.AssignmentRestApI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.springboot.assignment.restapi.AssignmentRestApI.Entities.Student;

@SpringBootTest
class AssignmentRestApIApplicationTests {

	@Value("${studentapi.services.url}")
	String baseUrl;
	
	
	@Test
	void testGetStudent() {
		System.out.println(baseUrl);
		RestTemplate restTemplate = new RestTemplate();
		Student student = restTemplate.getForObject(baseUrl+"/students/1",Student.class);
		System.out.println("-----------------------------------------------");
		System.out.println("Get Method : "+student);
		System.out.println("-----------------------------------------------");
	}
	
	@Test
	void testCreateStudent() {
		RestTemplate restTemplate = new RestTemplate();
		Student stud = new Student();
		stud.setId(2);
		stud.setName("Aravinth");
		stud.setTestscore(100);
		Student student = restTemplate.postForObject(baseUrl,stud,Student.class);
		System.out.println("Create Method Student Name : "+stud.getName());
		System.out.println("-----------------------------------------------");
	}
	
	@Test
	void testUpdateStudent() {
		RestTemplate restTemplate = new RestTemplate();
		Student student = restTemplate.getForObject(baseUrl+"students/1",Student.class);
		student.setTestscore(500);
		restTemplate.put(baseUrl,student);
		System.out.println("-----------------------------------------------");
		System.out.println("Update Method Student Name : "+student.getName());
	}
	
	@Test
	void testDeleteStudent() {
		RestTemplate restTemplate = new RestTemplate();
		Student student = restTemplate.getForObject(baseUrl+"/students/1",Student.class);
		restTemplate.delete(baseUrl,student);
		System.out.println("Delete Method : "+student);
		System.out.println("-----------------------------------------------");
	}
}
