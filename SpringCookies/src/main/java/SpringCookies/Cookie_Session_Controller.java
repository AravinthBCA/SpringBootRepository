package SpringCookies;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("user")
public class Cookie_Session_Controller {
	
//  we have two ways to send and receive cookies, HttpServlet and SpringAnnotations.
	
//	below method perform, create cookie and insert some data into that cookie also how to retrive data from cookie
//	@GetMapping("/")
//	public String home(HttpServletResponse response,HttpServletRequest request,Model model) {
//		Cookie cookie = new Cookie("username","aravinth");
//		cookie.setMaxAge(60 * 60 * 24);
//		response.addCookie(cookie);
//		
//		Cookie[] cookies = request.getCookies();
//		for(Cookie temp : cookies) {
//			if("username".equals(temp.getName())) {
//				String username = temp.getValue();
//				model.addAttribute("firstName",username);
//			}
//		}
//		return "index";
//	}

//	below method using spring cookie annotation to retrieve the cookie data and insert into model
//	Spring Annotation Cookie
//	@GetMapping("/")
//	public String springCookie(@CookieValue("username") String username,Model model) {
//			model.addAttribute("firstName",username);
//			return "index";
//	}
	
//	@GetMapping("/")
	public String springSession() {
			return "index";
	}

	@ModelAttribute("user")
    public User userRegistrationDto() {
        return new User();
    }
	
//	using session, retrieve the current session object and insert some data into the session object you can use that
//	@PostMapping("/registration")
//	public String submit(@ModelAttribute("user") User user,HttpServletRequest request) {
//		System.out.println("formsubmit");
//		HttpSession session = request.getSession();
//		session.setAttribute("firstName",user.getFirstName());
//		session.setMaxInactiveInterval(15);
//		System.out.println(request.toString());
//		return "home";
//	}
	
//	using @SessionAttributes in Spring annotation without this you need to create an object and set 
//	model data into the session object
//	@PostMapping("/registration")
	public String submit(@ModelAttribute("user") User user) {
		System.out.println("formsubmit");
		return "home";
	}
	
}
