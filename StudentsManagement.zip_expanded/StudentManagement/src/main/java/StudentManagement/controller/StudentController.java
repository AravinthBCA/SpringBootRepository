package StudentManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import StudentManagement.entity.Student;
import StudentManagement.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/")
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("index");
	    return mav;
	}
	
	@GetMapping("/student/all")
	public ResponseEntity<List<Student>> getallStudents(Model model){
		model.addAttribute("students",studentService.getAllStudents());
		System.out.println(model.toString());
		return new ResponseEntity<List<Student>>(studentService.getAllStudents(),HttpStatus.OK);
//		return "pages/tables/show_students";
	}
	
	@GetMapping("/student/count")
	public ResponseEntity<List<Integer>> getStudentCount(){
		int stuCount = studentService.getStudentCount();
		System.out.println(stuCount);
		return new ResponseEntity<List<Integer>>(List.of(50,stuCount),HttpStatus.OK);
	}
	
//	@GetMapping("/students/new")
//	public String createStudentForm(Model model) {
//		// create student object to hold student form data
//		model.addAttribute("students",studentService.getAllStudents());
//		System.out.println(model.toString());
//		return "createStudent";
//		
//	} 
	
	@ModelAttribute("student")
    public Student studentRegistrationDto() {
        return new Student();
    }
	
	@PostMapping(path="/saveStudent")
	public ModelAndView saveStudent(@ModelAttribute("student")Student student) {
		System.out.println(student.toString());
		studentService.saveStudent(student);
		ModelAndView mav = new ModelAndView("index");
	    return mav;
	}
	
	@DeleteMapping("/student/delete/{id}")
	public ResponseEntity deleteStudent(@PathVariable("id") int id ) {
		System.out.println("id -> "+id);
		studentService.deleteStudent(id);
		return new ResponseEntity(HttpStatus.OK);
	}
	
}
