package com.wf.bootapp.ibs.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.wf.bootapp.ibs.dto.LoanDto;
import com.wf.bootapp.ibs.dto.PersonalLoanDto;

public class PersonalLoanValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return PersonalLoanDto.class.isAssignableFrom(clazz);

	}

	@Override
	public void validate(Object target, Errors errors) {
		PersonalLoanDto loan = (PersonalLoanDto) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName","Enter first name");
	}

}
