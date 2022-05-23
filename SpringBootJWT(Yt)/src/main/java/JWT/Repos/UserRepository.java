package JWT.Repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import JWT.Model.UserModel;

public interface UserRepository extends JpaRepository<UserModel,Integer>{

	Optional<UserModel> findByUsername(String username);
	
}
