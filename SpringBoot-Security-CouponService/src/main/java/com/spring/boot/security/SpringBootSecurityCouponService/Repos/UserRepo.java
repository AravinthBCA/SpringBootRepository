package com.spring.boot.security.SpringBootSecurityCouponService.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.security.SpringBootSecurityCouponService.Model.User;

public interface UserRepo extends JpaRepository<User, Long> {
	
	User findByEmail(String email);
	
}
