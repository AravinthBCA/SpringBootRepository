package SpringBoot_Profiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import SpringBoot_Profiles.Beans.Animal;

@SpringBootApplication
public class SpringBootProfileApplication implements CommandLineRunner{

	@Autowired
	Animal animal;
	
	@Value("${current.username}")
	String username;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootProfileApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(animal);
		System.out.println("Current Username : "+username);
		animal.sound();
	}
}
