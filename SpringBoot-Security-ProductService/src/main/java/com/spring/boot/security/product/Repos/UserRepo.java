package com.spring.boot.security.product.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.security.product.Model.User;


public interface UserRepo extends JpaRepository<User, Long> {
	
	User findByEmail(String email);
	
}
