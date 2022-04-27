package com.spring.boot.security.SpringBootSecurityCouponService.Controllers;


import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.boot.security.SpringBootSecurityCouponService.Model.RegisterUser;
import com.spring.boot.security.SpringBootSecurityCouponService.Model.Role;
import com.spring.boot.security.SpringBootSecurityCouponService.Model.User;
import com.spring.boot.security.SpringBootSecurityCouponService.Repos.RoleRepo;
import com.spring.boot.security.SpringBootSecurityCouponService.Repos.UserRepo;
import com.spring.boot.security.SpringBootSecurityCouponService.Security.SecurityService;

@Controller
public class UserController {

	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private RoleRepo roleRepo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@GetMapping("/showReg")
	public String showRegistrationPage() {
		return "registerUser";
	}
	
	@PostMapping("/registerUser")
	public String register(RegisterUser regUser) {
		User user = new User(regUser.getFirstName(),regUser.getLastName(),regUser.getEmail(),
				    regUser.getPassword());
		user.setPassword(encoder.encode(user.getPassword()));
		Role role =  new Role(regUser.getRoles());
		Set<Role> roleSet = new HashSet<Role>();
		roleSet.add(role);
		user.setRoles(roleSet);
		System.out.println("Roles : "+regUser.getRoles());
		userRepo.save(user);
		roleRepo.save(role);
		return "login";
	}
	
	@GetMapping("/")
	public String showLoginPage() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(String email, String password) {
		boolean loginResponse = securityService.login(email, password);
		if(loginResponse) {
			return "index";
		}
		return "login";
	}
	
}
