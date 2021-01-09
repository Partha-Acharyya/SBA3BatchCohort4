package com.wf.bootapp.ibs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wf.bootapp.ibs.dto.CardDto;
import com.wf.bootapp.ibs.dto.CardOutputDto;
import com.wf.bootapp.ibs.dto.CardStatementDto;



public interface DebitCardService {

	CardOutputDto resetDcPin(CardDto DebitCardDto, Long id);

	List<CardDto> DebitCardList(Long id);

	CardOutputDto dcStatementMismatch(CardDto DebitCardDto, Long id, String fileName);

	CardOutputDto BlockUnblockCard(CardDto DebitCardDto, Long id);

	CardOutputDto debitCardUpgrade(CardDto DebitCardDto, Long id);

	CardOutputDto DeactivateDebitCard(Long cardNumber, Long customerId);

	CardOutputDto ActivateDebitCard(Long cardNumber, Long customerId);

	List<CardDto> AllDebitCardList();

	List<CardStatementDto> requestCardStatement(Long debitCardNumber, String startDate, String endDate);

	List<CardDto> DebitCardListAll();

}
