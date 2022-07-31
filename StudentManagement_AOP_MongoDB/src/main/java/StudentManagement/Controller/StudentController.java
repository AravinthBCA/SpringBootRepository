package StudentManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import StudentManagement.Service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import StudentManagement.Entity.Student;

@Controller
@Tag(name="Student Rest Endpoint")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
		
	// handler method to handle list of students and return model and view
	@GetMapping("/students")
	@Operation(summary="Returns all Students",description="Students List")
	public String listStudents(Model model) {
		model.addAttribute("students",studentService.getAllStudents());
		return "students";
	}
	
	// It redirect into Save Student Card
	@GetMapping("/students/add")
	public String createStudent(Model model) {
		Student student = new Student();
		model.addAttribute("student",student);
		return "create_student";
	}

	// Save the Student Card details and return into Home UI
	@PostMapping("/students")
	@Operation(summary="Save New Student",description="Save Student")
//	public String saveStudent(@ModelAttribute("student")Student student) {
	public String saveStudent(Student student) {
		student.setId(studentService.getSequenceNumber(student.SEQUENCE_NAME));
		studentService.saveStudent(student);
		return "redirect:/students";
	}
	
	// Show Student Update Card based on Student Id, Id is get from Home UI
	@GetMapping("/students/edit/{id}")
	@Operation(summary="Get Student By Id",description="Get Student By Id")
	public String editStudent(@PathVariable Integer id,Model model) {
		model.addAttribute("student",studentService.getStudentById(id));
		return "edit_student";
	}
	
	// Update Student Card details and return into Home UI
	@PostMapping("/students/{id}")
	@Operation(summary="Update Student By Id",description="Update Student By Id")
	public String updateStudent(@PathVariable Integer id, @ModelAttribute("student") Student student,  Model model) {
		// get student from database based on student id
		Student existingStudent = studentService.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		
		// save the updated student object
		studentService.updateStudent(existingStudent);
		return "redirect:/students";
	}
	
	
	// Delete Student By Id, Id is get from Home UI and it show Home UI
	@GetMapping("/students/{id}")
	@Operation(summary="Delete Student By Id",description="Delete Student By Id")
	public String deleteStudent(@PathVariable Integer id) {	
		studentService.deleteStudent(id);
		return "redirect:/students";
	}
	
}
