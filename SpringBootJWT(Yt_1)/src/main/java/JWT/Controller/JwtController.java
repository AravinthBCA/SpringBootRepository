package JWT.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import JWT.JwtUtil;
import JWT.Model.AuthenticationRequest;
import JWT.Model.AuthenticationResponse;
import JWT.Model.DAOUser;
import JWT.Model.UserDTO;
import JWT.Service.MyUserDetailsService;

@RestController  // RestController it return the data
				 // Controller it return the view it search it template folder
public class JwtController {
	
	@Autowired
	private AuthenticationManager manager;
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@RequestMapping("/")
	public String hello() {
		System.out.println("hello........");
		return "Hello World";
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> create(@RequestBody AuthenticationRequest request) throws Exception{
		try {
			manager.authenticate( new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
		} catch (BadCredentialsException e) {
			// TODO Auto-generated catch block
			throw new Exception("Incorrect Username or Password",e);
		}
		final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
		
		final String jwt = jwtUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt,"Token created successfull for "+request.getUsername()));
	}
	
	@PostMapping("/saveUser")
	public String saveUser(@RequestBody UserDTO user){
		if(userDetailsService.save(user) != null) {
			return "User saved Successfully "+user.getUsername();
		}
		else {
			return "User Not Saved...";
		}
	}
}
