package StudentManagement.Service.Impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

import StudentManagement.Entity.DbSequence;
import StudentManagement.Entity.Student;
import StudentManagement.Repos.StudentRepository;
import StudentManagement.Service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private MongoOperations mongoOperations;
	
	@Autowired
	private StudentRepository studentRepo;
	
	@Override
	public int getSequenceNumber(String sequenceNumber) {
		// get sequence no
		Query query = new Query(Criteria.where("id").is(sequenceNumber));
		
		// update the sequence no
		Update update = new Update().inc("seq",1);
		
		// modify in document
		DbSequence counter = mongoOperations.findAndModify(query, update,
							options().returnNew(true).upsert(true),DbSequence.class);
		
		return !Objects.isNull(counter) ? counter.getSeq() : 1;
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepo.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepo.save(student);
	}

	@Override
	public Student getStudentById(Integer id) {
		return studentRepo.findById(id).get();
	}

	@Override
	public Student updateStudent(Student student) {
		return studentRepo.save(student);
	}

	@Override
	public void deleteStudent(Integer id) {
		studentRepo.deleteById(id);;
	}

}
