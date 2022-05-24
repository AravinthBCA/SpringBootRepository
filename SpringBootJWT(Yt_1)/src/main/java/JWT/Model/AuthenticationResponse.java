package JWT.Model;

import lombok.*;

@Data
@AllArgsConstructor
public class AuthenticationResponse {

	private final String jwt;
	private String username;
	
}
