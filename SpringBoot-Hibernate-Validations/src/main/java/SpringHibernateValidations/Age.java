package SpringHibernateValidations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = AgeValidator.class)
public @interface Age {
	
	String message() default "{Age.Message}";
	int lower() default 18;
	int upper() default 60;
	
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default{};
	
}
