package SpringBoot_Profiles.Beans;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dog")
public class Dog implements Animal{

	@Override
	public void sound() {
		System.out.println("Dog Sound...");
	}

}
