package com.wf.bootapp.ibs.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wf.bootapp.ibs.dto.CardDto;
import com.wf.bootapp.ibs.dto.CardOutputDto;
import com.wf.bootapp.ibs.entity.DebitCard;
import com.wf.bootapp.ibs.repository.DebitCardRepository;
import com.wf.bootapp.ibs.service.DebitCardService;

@Service
public class DebitCardServiceImpl implements DebitCardService {
	@Autowired
	private DebitCardRepository debitCardRepository;

	@Override

	public List<CardDto> DebitCardList(Long id) {
		List<DebitCard> DebitCard = this.debitCardRepository.findBycustomerId(id);
		List<CardDto> cardDto = DebitCard.stream().map(this::ConvertEntityToDebitCardDto).collect(Collectors.toList());
		return cardDto;
	}

	@Override
	public CardOutputDto resetDcPin(CardDto DebitCardDto, Long id) {
		DebitCard DebitCard = this.debitCardRepository.findBycardNumber(DebitCardDto.getCardNumber());
		System.out.println(DebitCard.getCardCvv());
		if (DebitCard.getCardCvv() == DebitCardDto.getCardCvv()
				&& DebitCard.getCardPin() != DebitCardDto.getCardPin()) {

			DebitCard.setCardPin(DebitCardDto.getCardPin());
			DebitCard newcard = this.debitCardRepository.save(DebitCard);
			CardOutputDto CardOutputDto = this.ConvertEntityToCardOuptuDto(newcard);
			// System.out.println(CardOutputDto);
			return CardOutputDto;
		}
		return null;
	}

	private CardOutputDto ConvertEntityToCardOuptuDto(DebitCard newcard) {
		CardOutputDto CardOutputDto = new CardOutputDto();
		CardOutputDto.setCardNumber(newcard.getCardNumber());
		CardOutputDto.setactionType(newcard.getActionType());
		CardOutputDto.setCardType(newcard.getDcType());
		return CardOutputDto;
	}

	private CardDto ConvertEntityToDebitCardDto(DebitCard DebitCard) {
		CardDto CardDto = new CardDto();
		CardDto.setCardNumber(DebitCard.getCardNumber());
		CardDto.setCardCvv(DebitCard.getCardCvv());
		CardDto.setCardPin(DebitCard.getCardPin());
		CardDto.setActionType(DebitCard.getActionType());
		CardDto.setBlockingReason(DebitCard.getBlockingReason());
		CardDto.setBlockingType(DebitCard.getBlockingType());
		CardDto.setMismatchFile(DebitCard.getMismatchFile());
		return CardDto;
	}

//	@Override
//	public List<CreditCardStatementDto> requestCardStatement(CardDto DebitCardInputDto, Long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public CardOutputDto dcStatementMismatch(CardDto DebitCardInputDto, Long id) {
		// TODO Auto-generated method stub
		DebitCard card = this.debitCardRepository.findBycardNumber(DebitCardInputDto.getCardNumber());
		card.setMismatchFile(DebitCardInputDto.getMismatchFile());
		DebitCard newcard = this.debitCardRepository.save(card);
		CardOutputDto CardOutputDto = this.ConvertEntityToCardOuptuDto(newcard);
		
		return CardOutputDto;
	}

	@Override
	public CardOutputDto debitCardUpgrade(CardDto DebitCardInputDto, Long id) {
		// TODO Auto-generated method stub
		DebitCard card = this.debitCardRepository.findBycardNumber(DebitCardInputDto.getCardNumber());
		card.setDcType(DebitCardInputDto.getCardType());
		DebitCard newcard = this.debitCardRepository.save(card);
		CardOutputDto CardOutputDto = this.ConvertEntityToCardOuptuDto(newcard);

		return CardOutputDto;
	}

	@Override
	public CardOutputDto BlockUnblockCard(CardDto DebitCardInputDto, Long id) {
		DebitCard card = this.debitCardRepository.findBycardNumber(DebitCardInputDto.getCardNumber());
		card.setActionType(DebitCardInputDto.getActionType());
		card.setBlockingReason(DebitCardInputDto.getBlockingReason());
		card.setBlockingType(DebitCardInputDto.getBlockingType());
		DebitCard newcard = this.debitCardRepository.save(card);
		CardOutputDto CardOutputDto = this.ConvertEntityToCardOuptuDto(newcard);
		// System.out.println(CardOutputDto);
		return CardOutputDto;

	}

}
