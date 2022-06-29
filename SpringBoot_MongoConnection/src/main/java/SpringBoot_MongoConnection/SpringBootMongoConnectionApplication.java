package SpringBoot_MongoConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import SpringBoot_MongoConnection.Models.User;
import SpringBoot_MongoConnection.Repos.UserRepository;

@SpringBootApplication
public class SpringBootMongoConnectionApplication implements CommandLineRunner{

	private final UserRepository userRepos;
	
	@Autowired
	public SpringBootMongoConnectionApplication(UserRepository userRepos) {
		this.userRepos = userRepos;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootMongoConnectionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if(userRepos.findAll().isEmpty()) {
			userRepos.save(new User("aravinth","kaliyamoorthy"));
			userRepos.save(new User("Ruban","kaliyamoorthy"));
		}
		for(User user : userRepos.findAll()) {
			System.out.println(user);
		}
	}

}
