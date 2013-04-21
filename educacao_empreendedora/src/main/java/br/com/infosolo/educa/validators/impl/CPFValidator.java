package br.com.infosolo.educa.validators.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.infosolo.educa.utils.CPFUtils;
import br.com.infosolo.educa.validators.CPF;

public class CPFValidator implements ConstraintValidator<CPF, String> {

	@Override
	public void initialize(CPF constraintAnnotation) {
	}

	@Override
	public boolean isValid(String cpf, ConstraintValidatorContext context) {
		return CPFUtils.validate(cpf);
	}

}
