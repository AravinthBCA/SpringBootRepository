package JWT;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import JWT.UtilityOwn.JwtUtility;

@Component
public class SecurityFilter extends OncePerRequestFilter{

	@Autowired
	private JwtUtility util;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// read token from Auth head
		String token = request.getHeader("Authorization");
		System.out.println("Token in securityFileter : "+token);
		
//		ArrayList<GrantedAuthority> list = new ArrayList<>();
//		list.add(new SimpleGrantedAuthority("Role_admin"));
//		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken("aravinth","password",list);
//		SecurityContextHolder.getContext().setAuthentication(authToken);
		
		if(token!=null) {
			// do validation
			String username = util.getUsername(token);
			// username should not be empty, context-auth must be empty
			if(username!=null && SecurityContextHolder.getContext().getAuthentication() == null) {
				UserDetails user = userDetailsService.loadUserByUsername(username);
				// validate token
				boolean isValid = util.validateToken(token, user.getUsername());
				if(isValid) {
					UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username,user.getPassword(),user.getAuthorities());
					authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					// final object stored in SecurityContext with UserDetails(username and password)
					System.out.println(authToken.getCredentials()+" -> "+authToken.getDetails());
					SecurityContextHolder.getContext().setAuthentication(authToken);
				}
			}
		}
		filterChain.doFilter(request, response);
	}

}
