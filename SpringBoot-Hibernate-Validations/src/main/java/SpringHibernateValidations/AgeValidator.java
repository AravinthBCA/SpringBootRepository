package SpringHibernateValidations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<Age, Integer>{

	private int lower;
	private int upper;
	
//	I can write the post construct work right here, it executes once at the time of initialize only
	@Override
	public void initialize(Age age) {
		this.lower = age.lower();
		this.upper = age.upper();
	}
	
	// i need to write my logic here
	@Override
	public boolean isValid(Integer age, ConstraintValidatorContext context) {
		if(age ==  null) {
			return false;
		}
		if(age < lower || age > upper) {
			return false;
		}
		return true;
	}

}
