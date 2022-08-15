//package StudentManagement.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
////@Configuration
//public class WebSecurityConfig {
////	 @Bean
////	 public UserDetailsService userDetailsService() {
////	      return new ShopmeUserDetailsService();
////	 }
//	 
//	@Bean
//	public AuthenticationManager authenticationManager(
//	        AuthenticationConfiguration authConfig) throws Exception {
//	    return authConfig.getAuthenticationManager();
//	}
//	
////	 @Bean
////	 public BCryptPasswordEncoder passwordEncoder() {
////	      return new BCryptPasswordEncoder();
////	 }
//	 
//	 @Bean
//	 public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//	     
//	        http.authorizeRequests().antMatchers("/login").permitAll()
//	                .anyRequest().authenticated()
//	                .and()
//	                .formLogin()
//	                .loginPage("/pages/samples/login.html")
//	                .and()
//	                .logout().permitAll();
//	 
//	 
//	        return http.build();
//	   }
//	 
////	  @Bean
////	  public WebSecurityCustomizer webSecurityCustomizer() {
////	      return (web) -> web.ignoring().antMatchers("/images/**", "/js/**", "/webjars/**");
////	  }
//	 
//}
