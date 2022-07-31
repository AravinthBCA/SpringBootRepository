package StudentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import StudentManagement.Entity.Student;
import StudentManagement.Repos.StudentRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;


@SpringBootApplication
@OpenAPIDefinition(info=@Info(title="Student API",version="1.0",description="This API is for Students..."))
public class StudentManagementApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepo;
	
	@Override
	public void run(String... args) throws Exception {
//		Student student1 = new Student("Aravinth","Kaliyamoorthy","aravinth@gmail.com");
//		studentRepo.save(student1);
//		Student student2 = new Student("Ruban","Kaliyamoorthy","ruban@gmail.com");
//		studentRepo.save(student2);
//		Student student3 = new Student("Manivel","Appa","manivel@gmail.com");
//		studentRepo.save(student3);
	}

}
