package com.auth.server.authserver.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.auth.server.authserver.Model.AuthUserDetail;
import com.auth.server.authserver.Model.User;
import com.auth.server.authserver.Repos.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepo.findByUsername(username);
		System.out.println("----------------------------------------------------------------------");
		System.out.println(user.toString());
		user.orElseThrow(()-> new UsernameNotFoundException("username or password wrong"));
		UserDetails userDetails = new AuthUserDetail(user.get());
	    new AccountStatusUserDetailsChecker().check(userDetails);
	    return userDetails;
	}

}
