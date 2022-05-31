package ModelAttribute;

import lombok.Data;

@Data
public class WebsiteInfoDTO {

	private String websiteName;
	private String websiteCategory;
	
	WebsiteInfoDTO(){
		System.out.println("Constructor Called....");
	}
	
}
