package JWT.Config;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import JWT.Model.UserModel;
import JWT.Repos.UserRepository;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String username = authentication.getName();
		String password = (String) authentication.getCredentials();
		
		Optional<UserModel> lists = userRepo.findByUsername(username);
		
		if(lists.empty() != null) {
			
			UserModel userModel = lists.get();
			boolean isMatches = passwordEncoder.matches(password, userModel.getPassword());
			
			if(isMatches) {
				return new UsernamePasswordAuthenticationToken(username,password,userModel.getRoles().stream()
						.map(role->new SimpleGrantedAuthority(role))
						.collect(Collectors.toList()));
			}
			else {
				throw new BadCredentialsException("Invalid Username & Password");
			}
		}
		else {
			throw new BadCredentialsException("Invalid Username & Password");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
