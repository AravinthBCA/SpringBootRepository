package JWT.Model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

	private String token;
	private String message;
	
}
