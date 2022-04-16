package com.springboot.assignment.restapi.AssignmentRestApI.Repository;

import org.springframework.data.repository.CrudRepository;

import com.springboot.assignment.restapi.AssignmentRestApI.Entities.Student;

public interface StudentRepository extends CrudRepository<Student,Integer> {

}
