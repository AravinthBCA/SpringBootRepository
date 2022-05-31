package SpringHibernateValidations;

import java.math.BigInteger;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, BigInteger>{

	public boolean isValid(BigInteger value, ConstraintValidatorContext context) {
		System.out.println("Value : "+value);
		int length = String.valueOf(value).length();
		if(length == 10) {
			return true;
		}
		return false;
	}
	
}
