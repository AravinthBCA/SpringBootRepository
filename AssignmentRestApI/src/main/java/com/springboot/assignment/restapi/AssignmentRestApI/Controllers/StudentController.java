package com.springboot.assignment.restapi.AssignmentRestApI.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.assignment.restapi.AssignmentRestApI.Entities.Student;
import com.springboot.assignment.restapi.AssignmentRestApI.Repository.StudentRepository;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	StudentRepository repo;
	
	@RequestMapping(value="/students/",method=RequestMethod.GET)
	public List<Student> select() {
		return (List<Student>) repo.findAll();
	}
	
//	localhost:8080/students/students/1
	@RequestMapping(value="/students/{id}",method=RequestMethod.GET)
	public Student select(@PathVariable("id") Integer id) {
		return repo.findById(id).get();
	}
	
	@RequestMapping(value="/students/",method=RequestMethod.POST)
	public Student insert(@RequestBody Student student) {
		return repo.save(student);
	}
	
	@RequestMapping(value="/students/",method=RequestMethod.PUT)
	public Student update(@RequestBody Student student) {
		return repo.save(student);
	}
	
//	localhost:8080/students/students/1
	@RequestMapping(value="/students/{id}",method=RequestMethod.DELETE)
	public void delete(@PathVariable("id") Integer id) {
		repo.deleteById(id);
	}
	
}
