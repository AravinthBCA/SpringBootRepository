package JWT.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class Controllers {

	@RequestMapping("/accessDenied")
	public ModelAndView accessdenied() {
		return new ModelAndView("accessDenied");
	}
	
}
