package com.springboot.database.SpringBootDataBase;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.database.SpringBootDataBase.Entities.Student;
import com.springboot.database.SpringBootDataBase.Repos.StudentRepository;

@SpringBootTest
class SpringBootDataBaseApplicationTests {

	@Autowired
	private StudentRepository repository;
	
	@Test
	void testSaveStudent() {
		Student entity = new Student();
		entity.setId(1l);entity.setName("Aravinth");entity.setTestScore(100);
		repository.save(entity);
		
		Student obj = repository.findById(1L).get();
		System.out.println("Select : "+obj);
		
		entity.setId(1l);entity.setTestScore(200);
		repository.save(entity); //the id already exists so it will be update the row
		
		entity.setId(1l);
	    repository.delete(entity);
	}

}
