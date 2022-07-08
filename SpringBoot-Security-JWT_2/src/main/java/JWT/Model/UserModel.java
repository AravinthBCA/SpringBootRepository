package JWT.Model;

import java.util.*;
import javax.persistence.*;
import lombok.*;

@Data@Entity
@Table(name="user")
public class UserModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="user_name")
	private String username;
	private String password;
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="rolestable",
					joinColumns=@JoinColumn(name="id"))
	@Column(name="role")
	private Set<String> roles;
}
