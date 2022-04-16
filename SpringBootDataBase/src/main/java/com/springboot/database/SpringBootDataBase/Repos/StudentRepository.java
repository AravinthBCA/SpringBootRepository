package com.springboot.database.SpringBootDataBase.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.database.SpringBootDataBase.Entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
