package com.wf.bootapp.ibs.service.impl;

import java.util.List;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wf.bootapp.ibs.dto.CreditCardEligibilityInputDto;
import com.wf.bootapp.ibs.dto.CreditCardEligibilityOutputDto;
import com.wf.bootapp.ibs.dto.CardDto;
import com.wf.bootapp.ibs.dto.CardOutputDto;
import com.wf.bootapp.ibs.dto.CreditCardStatementDto;
import com.wf.bootapp.ibs.entity.Card;
import com.wf.bootapp.ibs.entity.CreditCardEligibility;
import com.wf.bootapp.ibs.entity.DebitCard;
import com.wf.bootapp.ibs.repository.CreditCardEligibilityRepository;
import com.wf.bootapp.ibs.repository.DebitCardRepository;
import com.wf.bootapp.ibs.repository.CardRepository;
import com.wf.bootapp.ibs.service.CreditCardService;

@Service
public class CreditCardServiceImpl implements CreditCardService {

	@Autowired
	private CreditCardEligibilityRepository creditCardEligibilityRepository;
	@Autowired
	private CardRepository CardRepository;
	
//	@Autowired
//	private CreditCardStatementRepository creditCardStatementRepository;

	@Override
	public CreditCardEligibilityOutputDto applyCreditCard(CreditCardEligibilityInputDto creditCardEligibilityInputDto,
			Long id) {
		CreditCardEligibility creditCardEligibility = this.convertCCInputDtoToEntity(creditCardEligibilityInputDto, id);
		CreditCardEligibility newcreditCardEligibility = this.creditCardEligibilityRepository
				.save(creditCardEligibility);
		CreditCardEligibilityOutputDto creditCardEligibilityOutputDto = new CreditCardEligibilityOutputDto();
		creditCardEligibilityOutputDto.setReferenceID(newcreditCardEligibility.getReferenceID());
		return creditCardEligibilityOutputDto;
	}

	private CreditCardEligibility convertCCInputDtoToEntity(CreditCardEligibilityInputDto creditCardEligibilityInputDto,
			Long id) {
		CreditCardEligibility creditCardEligibility = new CreditCardEligibility();
		creditCardEligibility.setCustomerId(id);
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

	@Override
	public List<CardDto> CreditCardList(Long id) {
		List<Card> creditCards = this.CardRepository.findBycustomerId(id);
		List<CardDto> cardDto = creditCards.stream().map(this::ConvertEntityToCreditCardDto)
				.collect(Collectors.toList());
		return cardDto;
	}

	@Override
	public CardOutputDto resetCcPin(CardDto creditCardDto, Long id) {
		Card card = this.CardRepository.findBycardNumber(creditCardDto.getCardNumber());
		if (card.getCardCvv() == creditCardDto.getCardCvv() && card.getCardPin() != creditCardDto.getCardPin()) {

			card.setCardPin(creditCardDto.getCardPin());
			Card newcard = this.CardRepository.save(card);
			CardOutputDto CardOutputDto = this.ConvertEntityToCardOuptuDto(newcard);
			// System.out.println(CardOutputDto);
			return CardOutputDto;
		}
		return null;
	}

	private CardOutputDto ConvertEntityToCardOuptuDto(Card newcard) {
		CardOutputDto CardOutputDto = new CardOutputDto();
		CardOutputDto.setCardNumber(newcard.getCardNumber());
		CardOutputDto.setactionType(newcard.getActionType());
		CardOutputDto.setCardType(newcard.getCcType());
		return CardOutputDto;
	}

	private CardDto ConvertEntityToCreditCardDto(Card creditCards) {
		CardDto CardDto = new CardDto();
		CardDto.setCardNumber(creditCards.getCardNumber());
		CardDto.setCardCvv(creditCards.getCardCvv());
		CardDto.setCardPin(creditCards.getCardPin());
		CardDto.setActionType(creditCards.getActionType());
		CardDto.setBlockingReason(creditCards.getBlockingReason());
		CardDto.setBlockingType(creditCards.getBlockingType());
		CardDto.setMismatchFile(creditCards.getMismatchFile());
		return CardDto;
	}

	@Override
	public List<CreditCardStatementDto> requestCardStatement(CardDto creditCardInputDto, Long id) {
		
		return null;
	}


	@Override
	public CardOutputDto creditCardUpgrade(CardDto creditCardInputDto, Long id) {
		// TODO Auto-generated method stub
		Card card = this.CardRepository.findBycardNumber(creditCardInputDto.getCardNumber());
		card.setCcType(creditCardInputDto.getCardType());
			Card newcard = this.CardRepository.save(card);
			CardOutputDto CardOutputDto = this.ConvertEntityToCardOuptuDto(newcard);

		return CardOutputDto;
	}

	

	@Override
	public CardOutputDto BlockUnblockCard(CardDto cardDto, Long id) {
		Card card = this.CardRepository.findBycardNumber(cardDto.getCardNumber());
		card.setActionType(cardDto.getActionType());
		card.setBlockingReason(cardDto.getBlockingReason());
		card.setBlockingType(cardDto.getBlockingType());
		Card newcard = this.CardRepository.save(card);
		CardOutputDto CardOutputDto = this.ConvertEntityToCardOuptuDto(newcard);
		// System.out.println(CardOutputDto);
		return CardOutputDto;

	}
	@Override
	public List<CreditCardEligibilityOutputDto> getAllCcEligibilities() {
		List<CreditCardEligibility> creditCardEligibilities = this.creditCardEligibilityRepository
				.findByStatus("Pending");
		List<CreditCardEligibilityOutputDto> CreditCardEligibilitiesOutputDto = creditCardEligibilities.stream()
				.map(this::convertEntityToCcOutputDto).collect(Collectors.toList());
		return CreditCardEligibilitiesOutputDto;
	}

	private CreditCardEligibilityOutputDto convertEntityToCcOutputDto(CreditCardEligibility creditCardEligibilities) {
		CreditCardEligibilityOutputDto creditCardEligibilityOutputDto = new CreditCardEligibilityOutputDto();
		creditCardEligibilityOutputDto.setFirstName(creditCardEligibilities.getFirstName());
		creditCardEligibilityOutputDto.setLastName(creditCardEligibilities.getLastName());
		creditCardEligibilityOutputDto.setMobileNumber(creditCardEligibilities.getMobileNumber());
		creditCardEligibilityOutputDto.setReferenceID(creditCardEligibilities.getReferenceID());
		creditCardEligibilityOutputDto.setStatus(creditCardEligibilities.getStatus());
		creditCardEligibilityOutputDto.setTotalIncome(creditCardEligibilities.getTotalIncome());
		creditCardEligibilityOutputDto.setTypeOfEmployment(creditCardEligibilities.getTypeOfEmployment());
		creditCardEligibilityOutputDto.setCustomerId(creditCardEligibilities.getCustomerId());
		return creditCardEligibilityOutputDto;
	}

	@Override
	public CreditCardEligibilityOutputDto ApproveCardRequest(Long id,Long customerId) {
		CreditCardEligibility creditCardEligibility = this.creditCardEligibilityRepository.findById(id).orElse(null);
		creditCardEligibility.setStatus("Approved");
		Random random = new Random(System.nanoTime() % 100000);
		Long cardNumber = Math.round(random.nextFloat() * Math.pow(10,16));
		Card card=new Card();
		card.setCardNumber(cardNumber);
		card.setCustomerId(customerId);
		int cardCvv = random.nextInt(1000);
		card.setCardCvv(cardCvv);
		int cardPin = random.nextInt(10000);
		card.setCardPin(cardPin);
		card.setCcType(creditCardEligibility.getCcType());
		this.CardRepository.save(card);
		CreditCardEligibility newCreditCardEligibility = this.creditCardEligibilityRepository
				.save(creditCardEligibility);
		CreditCardEligibilityOutputDto CreditCardEligibilityOutputDto = this
				.convertEntityToCcOutputDto(newCreditCardEligibility);
		return CreditCardEligibilityOutputDto;
	}

	@Override
	public CreditCardEligibilityOutputDto DeclineCardRequest(Long id) {
		CreditCardEligibility creditCardEligibility = this.creditCardEligibilityRepository.findById(id).orElse(null);
		creditCardEligibility.setStatus("Declined");
		CreditCardEligibility newCreditCardEligibility = this.creditCardEligibilityRepository
				.save(creditCardEligibility);
		CreditCardEligibilityOutputDto CreditCardEligibilityOutputDto = this
				.convertEntityToCcOutputDto(newCreditCardEligibility);
		return CreditCardEligibilityOutputDto;
	}

	@Override
	public CardOutputDto ccStatementMismatch(CardDto cardDto, Long id) {
		Card card = this.CardRepository.findBycardNumber(cardDto.getCardNumber());
		card.setMismatchFile(cardDto.getMismatchFile());
		Card newcard = this.CardRepository.save(card);
		CardOutputDto CardOutputDto = this.ConvertEntityToCardOuptuDto(newcard);
		return CardOutputDto;
		
	}
}
