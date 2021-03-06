package JWT.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import JWT.Model.DAOUser;
import JWT.Model.UserDTO;
import JWT.Repos.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<SimpleGrantedAuthority> roles = null;
		DAOUser user = userRepo.findByUsername(username);
		if(user != null) {
			roles = Arrays.asList(new SimpleGrantedAuthority(user.getRole()));
			return new User(user.getUsername(),user.getPassword(),roles);
		}
		throw new UsernameNotFoundException("User Not Found "+username);
	}
	
	public DAOUser save(UserDTO user) {
		DAOUser obj = new DAOUser();
		obj.setUsername(user.getUsername());
		obj.setPassword(bcryptEncoder.encode(user.getPassword()));
		obj.setRole(user.getRole());
		userRepo.save(obj);
		return obj;
	}

}
