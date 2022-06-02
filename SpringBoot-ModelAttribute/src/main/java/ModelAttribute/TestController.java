package ModelAttribute;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class TestController {
	
	@Autowired
	private Info info;

	@GetMapping("/test")
	private String index(@ModelAttribute("websiteInfo") WebsiteInfoDTO website) throws IOException{
		System.out.println("Inside test Controller");
		System.out.println("Name : "+website.getWebsiteName());
		System.out.println("Category : "+website.getWebsiteCategory());
		System.out.println("Server Ip : "+info.getServerIp());
		throw new IOException();
//		return "index";
	}
	
}
