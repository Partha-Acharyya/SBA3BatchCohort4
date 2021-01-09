package com.wf.bootapp.ibs.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.wf.bootapp.ibs.dto.LoanDto;

public class LoanValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return LoanDto.class.isAssignableFrom(clazz);

	}

	@Override
	public void validate(Object target, Errors errors) {
		LoanDto loan = (LoanDto) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName","Enter first name");
	}

}
