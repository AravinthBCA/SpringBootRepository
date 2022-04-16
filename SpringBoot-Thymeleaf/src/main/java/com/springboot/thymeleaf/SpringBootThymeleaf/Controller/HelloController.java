package com.springboot.thymeleaf.SpringBootThymeleaf.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.thymeleaf.SpringBootThymeleaf.Model.Student;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@RequestMapping("/sendData")
	public ModelAndView sendData() {
		ModelAndView mav = new ModelAndView("data");
		mav.addObject("message","Take up one idea and make it your life");
		return mav;
	}
	
	@RequestMapping("/student")
	public ModelAndView getStudent() {
		ModelAndView mav = new ModelAndView("student");
		Student stud = new Student();
		stud.setName("Aravinth");
		stud.setScore(90);
		mav.addObject("student",stud);
		return mav;
	}
	
	@RequestMapping("/students")
	public ModelAndView getStudents() {
		ModelAndView mav = new ModelAndView("studentList");
		Student stud1 = new Student();
		stud1.setName("Aravinth");
		stud1.setScore(90);
		Student stud2 = new Student();
		stud2.setName("Aravinth");
		stud2.setScore(90);
		List<Student> studList = Arrays.asList(stud1,stud2);
		mav.addObject("student",studList);
		return mav;
	}
	
	@RequestMapping("/studentForm")
	public ModelAndView displayStudentForm() {
		ModelAndView mav = new ModelAndView("studentForm");
		Student stud2 = new Student();
		stud2.setName("Aravinth");
		stud2.setScore(90);
		mav.addObject("student",stud2);
		return mav;
	}
	
	@RequestMapping("/saveStudent")
	public ModelAndView saveStudent(@ModelAttribute Student student) {
		ModelAndView mav = new ModelAndView("result");
		System.out.println("Name : "+student.getName());
		System.out.println("Name : "+student.getScore());
		return mav;
	}
}
