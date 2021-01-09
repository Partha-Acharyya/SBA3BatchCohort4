package com.wf.bootapp.ibs.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.wf.bootapp.ibs.dto.HomeLoanDto;
import com.wf.bootapp.ibs.dto.LoanDto;
import com.wf.bootapp.ibs.dto.PersonalLoanDto;

public class HomeLoanValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return HomeLoanDto.class.isAssignableFrom(clazz);

	}

	@Override
	public void validate(Object target, Errors errors) {
		HomeLoanDto loan = (HomeLoanDto) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName","Enter first name");
	}

}
