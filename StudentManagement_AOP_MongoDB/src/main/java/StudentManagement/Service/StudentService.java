package StudentManagement.Service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import StudentManagement.Entity.Student;

@Service
public interface StudentService {
		
	public List<Student> getAllStudents();
	
	Student saveStudent(Student student);
	
	Student getStudentById(Integer id);
	
	Student updateStudent(Student student);
	
	void deleteStudent(Integer id);
	
	public int getSequenceNumber(String sequenceNumber);
	
}
