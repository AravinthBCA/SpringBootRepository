package SpringBoot_Profiles.Beans;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("cat")
public class Cat implements Animal{

	@Override
	public void sound() {
		System.out.println("Cat Sound...");
	}

}
