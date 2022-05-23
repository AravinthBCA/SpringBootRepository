package JWT.Service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import JWT.Model.UserModel;

@Service
public interface UserService {
	
	Integer saveUser(UserModel user);
	
	Optional<UserModel> findByUsername(String username);
	
}
