package ModelAttribute;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class TestController {

	@GetMapping("/test")
	public String index(@ModelAttribute("websiteInfo") WebsiteInfoDTO website){
		System.out.println("Inside test Controller");
		System.out.println("Name : "+website.getWebsiteName());
		System.out.println("Category : "+website.getWebsiteCategory());
		return "index";
	}
	
}
