package com.spring.boot.security.product.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.boot.security.product.Model.User;
import com.spring.boot.security.product.Repos.UserRepo;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByEmail(username);		
		if(user == null) {
			throw new UsernameNotFoundException("User Not Found For Email "+username);
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),user.getRoles());
	}

}
