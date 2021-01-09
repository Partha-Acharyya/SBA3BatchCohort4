package com.wf.bootapp.ibs.service;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import com.wf.bootapp.ibs.dto.CreditCardEligibilityInputDto;
import com.wf.bootapp.ibs.dto.CreditCardEligibilityOutputDto;
import com.wf.bootapp.ibs.dto.CardDto;
import com.wf.bootapp.ibs.dto.CardOutputDto;
import com.wf.bootapp.ibs.dto.CardStatementDto;

public interface CreditCardService {
	
	public CreditCardEligibilityOutputDto applyCreditCard(CreditCardEligibilityInputDto creditCardEligibilityInputDto,Long id);
	public CardOutputDto resetCcPin(CardDto creditCardInputDto, Long id);
	public CardOutputDto creditCardUpgrade(CardDto creditCardInputDto,Long id);
	public List<CreditCardEligibilityOutputDto> getAllCcEligibilities();
	public CreditCardEligibilityOutputDto ApproveCardRequest(Long id, Long customerId);
	public CreditCardEligibilityOutputDto DeclineCardRequest(Long id);
	public List<CardDto> CreditCardList(Long id);
	public CardOutputDto BlockUnblockCard(CardDto cardDto, Long id);
	public CardOutputDto ccStatementMismatch(@Valid CardDto cardDto, Long id, String fileName);
	public List<CardDto> AllCreditCardList();
	public CardOutputDto ActivateCreditCard(Long cardNumber, Long customerId);
	public CardOutputDto DeactivateCreditCard(Long cardNumber, Long customerId);
	List<CardStatementDto> requestCardStatement(Long creditCardNumber, String startDate, String endDate);
	public List<CardDto> CreditCardListAll();

}
