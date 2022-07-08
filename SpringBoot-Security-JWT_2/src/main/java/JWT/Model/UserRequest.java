package JWT.Model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

	private String username;
	private String password;
	
}
