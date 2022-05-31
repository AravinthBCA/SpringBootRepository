package ModelAttribute;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller

@ControllerAdvice //will apply to all classes that use the @Controller annotation
//@ControllerAdvice(assignableTypes = TestController.class) // single class declaration
//@ControllerAdvice(assignableTypes = {TestController.class,TestController.class})// multiclass declare
//@ControllerAdvice(basePackages = "ModelAttribute") // single package declare
//@ControllerAdvice(basePackages = {"ModelAttribute","ModelAttribute"}) // multi package declare

@SessionAttributes("websiteInfo")
public class ClassController {
	
	@ModelAttribute("websiteInfo")
	WebsiteInfoDTO createObject() {
		System.out.println("inside model object create.....");
		WebsiteInfoDTO website = new WebsiteInfoDTO();
		website.setWebsiteName("javadeveloper.com");
		website.setWebsiteCategory("Education");
		return website;
	}

//	parameter is optional whenever you want to perform business logic based on the @ModelAttribute
// to get that data using Model( like Model model ) or ModelAttribute( like @ModelAttribute("websiteIn
//	fo") WebSiteInfoDTO website){} then perform you business logic.
	
	@GetMapping("/")
	public String index(Model model) {
//		WebsiteInfoDTO website = (WebsiteInfoDTO) model.getAttribute("websiteInfo");
		System.out.println("WebSite Name : "+model.getAttribute("websiteInfo"));
		return "index";
	}	
	
	@GetMapping("/show")
	public String showCompany(@ModelAttribute("websiteInfo") WebsiteInfoDTO website) {
		System.out.println("Website Category : "+website.getWebsiteCategory());
		return "index";
	}	

	
}
