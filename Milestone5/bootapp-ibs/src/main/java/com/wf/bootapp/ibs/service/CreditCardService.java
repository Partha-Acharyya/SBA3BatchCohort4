package com.wf.bootapp.ibs.service;

import java.util.List;

import com.wf.bootapp.ibs.dto.CreditCardEligibilityInputDto;
import com.wf.bootapp.ibs.dto.CreditCardEligibilityOutputDto;
import com.wf.bootapp.ibs.dto.CardDto;
import com.wf.bootapp.ibs.dto.CreditCardStatementDto;

public interface CreditCardService {
	
	public CreditCardEligibilityOutputDto applyCreditCard(CreditCardEligibilityInputDto creditCardEligibilityInputDto,Long id);
	public boolean resetCcPin(CardDto creditCardInputDto,Long id);
	public List<CreditCardStatementDto> requestCardStatement(CardDto creditCardInputDto,Long id);
	public boolean statementMismatch(CardDto creditCardInputDto,Long id);
	public boolean creditCardUpgrade(CardDto creditCardInputDto,Long id);
	public List<CreditCardEligibilityOutputDto> getAllCcEligibilities();
	public CreditCardEligibilityOutputDto ApproveCardRequest(Long id);
	public CreditCardEligibilityOutputDto DeclineCardRequest(Long id);
	public List<CardDto> CreditCardList(Long id);
	 

}
