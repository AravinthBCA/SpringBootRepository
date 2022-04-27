package com.spring.boot.security.SpringBootSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.spring.boot.security.SpringBootSecurity.AuthenticationProvider.MyAuthenticationProvider;

@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter{
	
//	@Autowired
//	private PasswordEncoder passwordEncode;
	
	@Autowired
	private MyAuthenticationProvider authenticationProvider;
	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception{	
//		InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
//		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//		UserDetails user = User.withUsername("aravinth").password(passwordEncoder.encode("password")).authorities("read").build(); 
//		userDetailsService.createUser(user);
//		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
//	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{	
		auth.authenticationProvider(authenticationProvider);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
//		http.httpBasic();
		http.formLogin();
		http.authorizeRequests().anyRequest().authenticated(); // any url you want to access you 
// need to login compulsory
//		http.authorizeRequests().antMatchers("/hello").authenticated(); // /hello url only need
// need to login compulsory other url like bye not need login
//		http.authorizeRequests().antMatchers("/hello").authenticated().anyRequest().denyAll(); 
// /hello url need login but other url whenever you logged in or not it not permit any one because
// of denyAll() method.
		http.addFilterBefore(new MySecurityFilter(), BasicAuthenticationFilter.class);
	}
	
//	@Bean
//	public BCryptPasswordEncoder passwordEncode() {
//		return new BCryptPasswordEncoder();
//	}
	
}
