package SpringHibernateValidations;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


@Controller
@SessionAttributes("user")
public class ClassController {

	@GetMapping("/")
	public String index() {
		return "index";
	}	
	
	@ModelAttribute("user")
    public User userRegistrationDto() {
		System.out.println("Inside model attribute....");
        return new User();
    }
	
	@GetMapping("/process")
	public String submit(@Valid @ModelAttribute("user") User user,BindingResult result) {
		System.out.println(user.getFirstName());
		if (result.hasErrors()) {
            return "index";
        }
        return "process";
	}
	
	@GetMapping("/process1")
	public String submit1(@ModelAttribute("user") User user) {
		System.out.println("Inside process1....");
		System.out.println(user.getFirstName());
        return "process";
	}
	
}
