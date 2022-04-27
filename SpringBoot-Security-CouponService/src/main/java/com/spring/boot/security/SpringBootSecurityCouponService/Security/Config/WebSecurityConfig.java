package com.spring.boot.security.SpringBootSecurityCouponService.Security.Config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import com.spring.boot.security.SpringBootSecurityCouponService.Security.UserDetailsServiceImpl;

//@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsServiceImpl userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.formLogin();
//		http.authorizeRequests().mvcMatchers(HttpMethod.GET,"/couponapi/coupons/{code:^[A-Z]*$}").hasAnyRole("USER","ADMIN")
		// the above code is regular expession you can set url pattern it allows only alphabet not numeric in above url
		http.authorizeRequests().mvcMatchers(HttpMethod.GET,"/couponapi/coupons/","/index","/showGetCoupon","/getCoupon")
			.hasAnyRole("USER","ADMIN")
			.mvcMatchers(HttpMethod.GET,"/showCreateCoupon","/createCoupon","/createResponse").hasRole("ADMIN")
			.mvcMatchers(HttpMethod.POST,"/getCoupon").hasAnyRole("USER","ADMIN")
			.mvcMatchers(HttpMethod.POST,"/couponapi/coupons","/saveCoupon","/getCoupon","/couponDetails").hasRole("ADMIN")
			.mvcMatchers("/","/login","/showReg","/registerUser").permitAll()
			.anyRequest().denyAll().and().csrf().disable().logout().logoutSuccessUrl("/");
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
}
