package SpringHibernateValidations;

import java.math.BigInteger;
import java.util.Collection;

import javax.validation.constraints.*;

import lombok.Data;

@Data
public class User {
	
	@NotBlank(message = "* Your Name can't be blank")
	@Size(min = 3, max = 15, message = "* Your Name should have char between 3-15")
	private String firstName;
	
	@NotBlank(message = "* Crush Name can't be blank")
	@Size(min = 3, max = 15, message = "* Crush Name should have char between 3-15")
	private String lastName;
	
	@AssertTrue(message = "You have to agree to use our app")
	private boolean termAndCondition;
	
	@Age(lower = 18,upper = 60)
	private Integer age;
	
	@PhoneNumber
	private BigInteger phoneNumber;
}
