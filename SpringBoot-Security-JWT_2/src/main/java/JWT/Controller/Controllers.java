package JWT.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class Controllers {

	@GetMapping("/")
	public ModelAndView accessdenied() {
		return new ModelAndView("accessDenied");
	}
	
}
