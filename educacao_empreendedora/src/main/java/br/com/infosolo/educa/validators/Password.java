package br.com.infosolo.educa.validators;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.com.infosolo.educa.validators.impl.PasswordValidator;

@Target( { METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)
@Documented
public @interface Password {
	
	
	String message() default "Senha deve conter letras min\u00FAsculas, mai\u00FAsculas, conter um n\u00FAmero, possuir no m\u00EDnimo 5 caracteres e no m\u00E1ximo 20.";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
	
	/**
        (?=.*[0-9]) a digit must occur at least once
		(?=.*[a-z]) a lower case letter must occur at least once
		(?=.*[A-Z]) an upper case letter must occur at least once
		(?=.*[@#*=]) a special character must occur at least once
		(?=[\\S]+$) no whitespace allowed in the entire string
		.{5,10} at least 5 to 10 characters
	 */
	String value() default "((?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{5,20})";

}
