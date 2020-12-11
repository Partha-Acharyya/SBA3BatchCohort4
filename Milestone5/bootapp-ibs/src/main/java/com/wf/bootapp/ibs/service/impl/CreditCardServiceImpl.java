package com.wf.bootapp.ibs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wf.bootapp.ibs.dto.CreditCardEligibilityInputDto;
import com.wf.bootapp.ibs.dto.CreditCardEligibilityOutputDto;
import com.wf.bootapp.ibs.entity.CreditCardEligibility;
import com.wf.bootapp.ibs.repository.CreditCardEligibilityRepository;
import com.wf.bootapp.ibs.service.CreditCardService;

@Service
public class CreditCardServiceImpl implements CreditCardService {

	@Autowired
	private CreditCardEligibilityRepository creditCardEligibilityRepository;
	
	@Override
	public CreditCardEligibilityOutputDto applyCreditCard(CreditCardEligibilityInputDto creditCardEligibilityInputDto) {
		CreditCardEligibility creditCardEligibility=this.convertCCInputDtoToEntity(creditCardEligibilityInputDto);
		CreditCardEligibility newcreditCardEligibility=this.creditCardEligibilityRepository.save(creditCardEligibility);
		CreditCardEligibilityOutputDto creditCardEligibilityOutputDto =new CreditCardEligibilityOutputDto();
		creditCardEligibilityOutputDto.setReferenceID(newcreditCardEligibility.getReferenceID());	
		return creditCardEligibilityOutputDto;
	}

	private CreditCardEligibility convertCCInputDtoToEntity(
			CreditCardEligibilityInputDto creditCardEligibilityInputDto) {
		CreditCardEligibility creditCardEligibility =new CreditCardEligibility();
		creditCardEligibility.setBirthday(creditCardEligibilityInputDto.getBirthday());
		creditCardEligibility.setCcType(creditCardEligibilityInputDto.getCcType());
		creditCardEligibility.setEmail(creditCardEligibilityInputDto.getEmail());
		creditCardEligibility.setFirstName(creditCardEligibilityInputDto.getFirstName());
		creditCardEligibility.setLastName(creditCardEligibilityInputDto.getLastName());
		creditCardEligibility.setMobileNumber(creditCardEligibilityInputDto.getMobileNumber());
		creditCardEligibility.setTotalIncome(creditCardEligibilityInputDto.getTotalIncome());
		creditCardEligibility.setTypeOfEmployment(creditCardEligibilityInputDto.getTypeOfEmployment());
		creditCardEligibility.setStatus("Pending");
		return creditCardEligibility;
	}

}
