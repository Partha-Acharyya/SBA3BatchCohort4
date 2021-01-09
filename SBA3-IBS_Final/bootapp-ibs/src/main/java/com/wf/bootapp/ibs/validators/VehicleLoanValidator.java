package com.wf.bootapp.ibs.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.wf.bootapp.ibs.dto.LoanDto;
import com.wf.bootapp.ibs.dto.PersonalLoanDto;
import com.wf.bootapp.ibs.dto.VehicleLoanDto;

public class VehicleLoanValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return VehicleLoanDto.class.isAssignableFrom(clazz);

	}

	@Override
	public void validate(Object target, Errors errors) {
		VehicleLoanDto loan = (VehicleLoanDto) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName","Enter first name");
	}

}
