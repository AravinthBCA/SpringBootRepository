package JWT.UtilityOwn;

import java.security.Principal;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtility {

	@Value("${app.secret}")
	private String secret;
	
	// Generate Token
	public String generateToken(String subject) {
		return Jwts.builder()
				.setSubject(subject)
				.setIssuer("Aravinth")
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(15)))
				.signWith(SignatureAlgorithm.HS512,secret.getBytes())
				.compact();
	}
	
	// Read Claims
	public Claims getClaims(String token) {
		return Jwts.parser().setSigningKey(secret.getBytes())
				.parseClaimsJws(token)
				.getBody();
	}
	
	// Read Exp Date
	public Date getExpDate(String token) {
		return getClaims(token).getExpiration();
	}
	
	// Read Subject / UserName
	public String getUsername(String token) {
		return getClaims(token).getSubject();
	}
	
	// Validate Exp Date
	public boolean isTokenExp(String token) {
		Date expDate = getExpDate(token);
		return expDate.before(new Date(System.currentTimeMillis()));
	}
	
	// Validate UserName in Token and Database, ExpDate
	public boolean validateToken(String token,String username) {
		String tokenUserName = getUsername(token);
		return (username.equals(tokenUserName) && !isTokenExp(token));
	}
	
}
