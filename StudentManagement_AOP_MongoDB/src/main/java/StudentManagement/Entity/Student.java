package StudentManagement.Entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="Student")
public class Student {
	
	@Transient
	public static final String SEQUENCE_NAME="user_sequence";
	
	@Id
	private Integer id;
		
	@Field
	private String firstName;
	
	@Field
	private String lastName;
	
	@Field
	private String email;
	
}
