package br.com.infosolo.educa.utils;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class ValidateUtils {

	/**
	 * bean validator programatically
	 * 
	 * @param obj
	 */
	public void validate(Object obj) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		Set<ConstraintViolation<Object>> constraintViolations = validator
				.validate(obj);
	}

}
