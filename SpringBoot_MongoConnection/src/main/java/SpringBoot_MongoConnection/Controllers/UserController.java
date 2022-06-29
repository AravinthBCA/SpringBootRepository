package SpringBoot_MongoConnection.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import SpringBoot_MongoConnection.Models.User;
import SpringBoot_MongoConnection.Repos.UserRepository;

@RestController
public class UserController {
	
	private final UserRepository userRepo;
	
	@Autowired
	public UserController(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	@GetMapping("/users")
	public List<User> getUsers(){
		return userRepo.findAll();
	}
}
