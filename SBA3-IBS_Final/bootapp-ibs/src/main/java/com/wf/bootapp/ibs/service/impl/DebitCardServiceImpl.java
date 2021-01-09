package com.wf.bootapp.ibs.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wf.bootapp.ibs.dto.CardDto;
import com.wf.bootapp.ibs.dto.CardOutputDto;
import com.wf.bootapp.ibs.dto.CardStatementDto;
import com.wf.bootapp.ibs.entity.Card;
import com.wf.bootapp.ibs.entity.CreditCardStatement;
import com.wf.bootapp.ibs.entity.DebitCard;
import com.wf.bootapp.ibs.entity.DebitCardStatement;
import com.wf.bootapp.ibs.exception.IncorrectCVVException;
import com.wf.bootapp.ibs.exception.SameCardPinException;
import com.wf.bootapp.ibs.repository.DebitCardRepository;
import com.wf.bootapp.ibs.repository.DebitCardStatementRepository;
import com.wf.bootapp.ibs.service.DebitCardService;

@Service
public class DebitCardServiceImpl implements DebitCardService {
	@Autowired
	private DebitCardRepository debitCardRepository;

	@Autowired
	private DebitCardStatementRepository DebitCardStatementRepository;

	@Override

	public List<CardDto> DebitCardList(Long id) {
		List<DebitCard> DebitCard = this.debitCardRepository.findBycustomerId(id);
		List<CardDto> cardDto = DebitCard.stream().map(this::ConvertEntityToDebitCardDto).collect(Collectors.toList());
		return cardDto;
	}

	@Override
	public List<CardDto> AllDebitCardList() {
		List<DebitCard> DebitCard = this.debitCardRepository.findAll();
		List<CardDto> cardDto = DebitCard.stream().map(this::ConvertEntityToDebitCardDto).collect(Collectors.toList());
		return cardDto;
	}

	@Override
	public CardOutputDto resetDcPin(CardDto DebitCardDto, Long id) {
		DebitCard DebitCard = this.debitCardRepository.findBycardNumber(DebitCardDto.getCardNumber());
		System.out.println(DebitCard.getCardCvv());
		if (DebitCard.getCardCvv() == DebitCardDto.getCardCvv()) {
			if (DebitCard.getCardPin() != DebitCardDto.getCardPin()) {

				DebitCard.setCardPin(DebitCardDto.getCardPin());
				DebitCard newcard = this.debitCardRepository.save(DebitCard);
				CardOutputDto CardOutputDto = this.ConvertEntityToCardOuptuDto(newcard);
				// System.out.println(CardOutputDto);
				return CardOutputDto;
			}
			throw new SameCardPinException("Card pin is same as previously present card pin");
		}
		throw new IncorrectCVVException("Incorrect CVV entered");
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
		CardDto.setCardStatus(DebitCard.getCardStatus());
		CardDto.setCustomerID(DebitCard.getCustomerId());
		return CardDto;
	}

	@Override
	public CardOutputDto dcStatementMismatch(CardDto DebitCardInputDto, Long id, String file) {
		DebitCard card = this.debitCardRepository.findBycardNumber(DebitCardInputDto.getCardNumber());
		card.setMismatchFile(file);
		DebitCard newcard = this.debitCardRepository.save(card);
		CardOutputDto CardOutputDto = this.ConvertEntityToCardOuptuDto(newcard);
		return CardOutputDto;
	}

	@Override
	public CardOutputDto debitCardUpgrade(CardDto DebitCardInputDto, Long id) {
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
		return CardOutputDto;

	}

	@Override
	public CardOutputDto ActivateDebitCard(Long cardNumber, Long customerId) {
		DebitCard card = this.debitCardRepository.findBycardNumber(cardNumber);
		card.setCardStatus("Active");
		DebitCard newCard = this.debitCardRepository.save(card);
		CardOutputDto cardOutputDto = new CardOutputDto();
		cardOutputDto.setCardStatus(newCard.getCardStatus());
		cardOutputDto.setCardNumber(newCard.getCardNumber());
		cardOutputDto.setCustomerId(newCard.getCustomerId());
		return cardOutputDto;
	}

	@Override
	public CardOutputDto DeactivateDebitCard(Long cardNumber, Long customerId) {
		DebitCard card = this.debitCardRepository.findBycardNumber(cardNumber);
		card.setCardStatus("Deactivate");
		DebitCard newCard = this.debitCardRepository.save(card);
		CardOutputDto cardOutputDto = new CardOutputDto();
		cardOutputDto.setCardStatus(newCard.getCardStatus());
		cardOutputDto.setCardNumber(newCard.getCardNumber());
		cardOutputDto.setCustomerId(newCard.getCustomerId());
		return cardOutputDto;

	}

	@Override
	public List<CardStatementDto> requestCardStatement(Long debitCardNumber, String startDate, String endDate) {
		List<DebitCardStatement> DebitCardStatement = this.DebitCardStatementRepository
				.findByDebitCardNumber(debitCardNumber, startDate, endDate);
		List<CardStatementDto> CardStatementDtos = DebitCardStatement.stream()
				.map(this::convertEntityToDcStatementOutputDto).collect(Collectors.toList());
		return CardStatementDtos;
	}

	private CardStatementDto convertEntityToDcStatementOutputDto(DebitCardStatement DebitCardStatement) {
		CardStatementDto CardStatementDto = new CardStatementDto();
		CardStatementDto.setCardNumber(DebitCardStatement.getDebitCardNumber());
		CardStatementDto.setAmount(DebitCardStatement.getAmount());
		CardStatementDto.setCreateDate(DebitCardStatement.getCreateDate());
		CardStatementDto.setTransactionType(DebitCardStatement.getTransactionType());
		return CardStatementDto;
	}

	@Override
	public List<CardDto> DebitCardListAll() {
		List<DebitCard> DebitCard = this.debitCardRepository.findAll();
		List<CardDto> cardDto = DebitCard.stream().map(this::ConvertEntityToDebitCardDto).collect(Collectors.toList());
		return cardDto;
	}

}
