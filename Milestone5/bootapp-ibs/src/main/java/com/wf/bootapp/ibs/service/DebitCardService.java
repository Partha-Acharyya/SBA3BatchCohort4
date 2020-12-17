package com.wf.bootapp.ibs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wf.bootapp.ibs.dto.CardDto;
import com.wf.bootapp.ibs.dto.CardOutputDto;



public interface DebitCardService {

	CardOutputDto resetDcPin(CardDto DebitCardDto, Long id);

	List<CardDto> DebitCardList(Long id);

	CardOutputDto dcStatementMismatch(CardDto DebitCardDto, Long id);

	CardOutputDto BlockUnblockCard(CardDto DebitCardDto, Long id);

	CardOutputDto debitCardUpgrade(CardDto DebitCardDto, Long id);

}
