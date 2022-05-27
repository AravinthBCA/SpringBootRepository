package JWT.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import JWT.Model.UserModel;
import JWT.Repos.UserRepository;

@Service
public class UserServiceImple implements UserService,UserDetailsService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private BCryptPasswordEncoder pwdEncoder;
	
	// Save Method
	@Override
	public Integer saveUser(UserModel user) {
		user.setPassword(pwdEncoder.encode(user.getPassword()));
		return userRepo.save(user).getId();
	}
	
	// Get User by username
	@Override
	public Optional<UserModel> findByUsername(String username) {
		return userRepo.findByUsername(username);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		Optional<UserModel> opt = findByUsername(username);
		System.out.println("User value : "+opt.toString());
		if(opt.isEmpty()) {
			System.out.println("username : "+username);
			throw new UsernameNotFoundException("UserName not Exists....");
		}
		UserModel user = opt.get();
		
		// you can use this one or below one 
		UserDetails userDetail = User.withUsername(user.getUsername())
									.password(user.getPassword())
									.roles("admin").build();	
		return userDetail;
		
		
//		return new org.springframework.security.core.userdetails.User(username, 
//				user.getPassword(),
//				user.getRoles().stream()
//				.map(role->new SimpleGrantedAuthority(role))
//				.collect(Collectors.toList())
//				);
	}
	
}
