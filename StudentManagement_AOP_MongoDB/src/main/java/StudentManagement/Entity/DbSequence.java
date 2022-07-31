package StudentManagement.Entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.*;

@Document(collection="db_sequence")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DbSequence {

	private String id;
	private int seq;
}
