package com.wf.bootapp.ibs.service;

import com.wf.bootapp.ibs.dto.CreditCardEligibilityInputDto;
import com.wf.bootapp.ibs.dto.CreditCardEligibilityOutputDto;

public interface CreditCardService {
	
	public CreditCardEligibilityOutputDto applyCreditCard(CreditCardEligibilityInputDto creditCardEligibilityInputDto);
	

}
