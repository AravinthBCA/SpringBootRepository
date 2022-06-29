package SpringBoot_MongoConnection.Repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import SpringBoot_MongoConnection.Models.User;

public interface UserRepository extends MongoRepository<User, String> {

}
