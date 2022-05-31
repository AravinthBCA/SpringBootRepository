package SpringCookies;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;


@Controller
@SessionAttributes("obj1")
public class SessionAttribute_Controller {
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("obj1","aravinth");
		model.addAttribute("obj2","ruban");
		return "index";
	}
	
	@ModelAttribute("user")
    public User userRegistrationDto() {
        return new User();
    }
	
	@PostMapping("/registration")
	public String submit(@ModelAttribute("user") User user,Model model1,
						SessionStatus status) {
		status.setComplete();  //destroy the user created object in SessionScope area
		System.out.println("session: "+model1.getAttribute("obj1"));
		model1.addAttribute("firstName","hahahah");
		return "home";
	}


	
}
