package com.auth.server.authserver.Repos;

import java.util.Optional;
import java.util.OptionalInt;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auth.server.authserver.Model.User;

public interface UserRepository extends JpaRepository<User,Integer>{

	Optional<User> findByUsername(String username);
	
}
