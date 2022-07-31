package StudentManagement.Repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import StudentManagement.Entity.Student;

public interface StudentRepository extends MongoRepository<Student, Integer> {

}
