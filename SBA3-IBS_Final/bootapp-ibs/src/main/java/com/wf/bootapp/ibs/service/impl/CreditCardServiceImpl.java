package com.wf.bootapp.ibs.service.impl;

import java.util.Date;
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
import com.wf.bootapp.ibs.dto.CardStatementDto;
import com.wf.bootapp.ibs.entity.Card;
import com.wf.bootapp.ibs.entity.CreditCardEligibility;
import com.wf.bootapp.ibs.entity.CreditCardStatement;
import com.wf.bootapp.ibs.entity.DebitCard;
import com.wf.bootapp.ibs.exception.IncorrectCVVException;
import com.wf.bootapp.ibs.exception.SameCardPinException;
import com.wf.bootapp.ibs.repository.CreditCardEligibilityRepository;
import com.wf.bootapp.ibs.repository.CreditCardStatementRepository;
import com.wf.bootapp.ibs.repository.DebitCardRepository;
import com.wf.bootapp.ibs.repository.CardRepository;
import com.wf.bootapp.ibs.service.CreditCardService;

@Service
public class CreditCardServiceImpl implements CreditCardService {

	@Autowired
	private CreditCardEligibilityRepository creditCardEligibilityRepository;
	@Autowired
	private CardRepository CardRepository;
	
	@Autowired
	private CreditCardStatementRepository creditCardStatementRepository;

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
	public List<CardDto> AllCreditCardList() {
		List<Card> creditCards = this.CardRepository.findAll();
		List<CardDto> cardDto = creditCards.stream().map(this::ConvertEntityToCreditCardDto)
				.collect(Collectors.toList());
		return cardDto;
	}


	@Override
	public CardOutputDto resetCcPin(CardDto creditCardDto, Long id) {
		Card card = this.CardRepository.findBycardNumber(creditCardDto.getCardNumber());
		if ((card.getCardCvv()) == creditCardDto.getCardCvv())
		{
		int	CardPin=	creditCardDto.getCardPin();
				if(card.getCardPin() != creditCardDto.getCardPin()){
			card.setCardPin(creditCardDto.getCardPin());
			Card newcard = this.CardRepository.save(card);
			CardOutputDto CardOutputDto = this.ConvertEntityToCardOuptuDto(newcard);
			return CardOutputDto;
		}
				throw new SameCardPinException("Card pin is same as previously present card pin");
		}
		throw new IncorrectCVVException("Incorrect CVV entered");
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
		CardDto.setCardStatus(creditCards.getCardStatus());
		CardDto.setCustomerID(creditCards.getCustomerId());
		return CardDto;
	}

	@Override
	public List<CardStatementDto> requestCardStatement(Long creditCardNumber,String startDate, String endDate) {
		List<CreditCardStatement> CreditCardStatement=this.creditCardStatementRepository.findByCreditCardNumber(creditCardNumber,startDate,endDate);
		List<CardStatementDto> CreditCardStatementDtos = CreditCardStatement.stream()
				.map(this::convertEntityToCcStatementOutputDto).collect(Collectors.toList());
		return CreditCardStatementDtos;
	}
	
	private CardStatementDto convertEntityToCcStatementOutputDto(CreditCardStatement CreditCardStatement) {
		CardStatementDto CreditCardStatementDto=new CardStatementDto();
		CreditCardStatementDto.setCardNumber(CreditCardStatement.getCreditCardNumber());
		CreditCardStatementDto.setAmount(CreditCardStatement.getAmount());
		CreditCardStatementDto.setCreateDate(CreditCardStatement.getCreateDate());
		CreditCardStatementDto.setTransactionType(CreditCardStatement.getTransactionType());
		return CreditCardStatementDto;
	}


	@Override
	public CardOutputDto creditCardUpgrade(CardDto creditCardInputDto, Long id) {
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
	public CardOutputDto ccStatementMismatch(CardDto cardDto, Long id,String fileName) {
		Card card = this.CardRepository.findBycardNumber(cardDto.getCardNumber());
		card.setMismatchFile(fileName);
		System.out.println(fileName);
		Card newcard = this.CardRepository.save(card);
		CardOutputDto CardOutputDto = this.ConvertEntityToCardOuptuDto(newcard);
		return CardOutputDto;
		
	}

	@Override
	public CardOutputDto ActivateCreditCard(Long cardNumber, Long customerId) {
		Card card= this.CardRepository.findBycardNumber(cardNumber);
		card.setCardStatus("Active");
		Card newCard=this.CardRepository.save(card);
		CardOutputDto cardOutputDto =new CardOutputDto();
		cardOutputDto.setCardStatus(newCard.getCardStatus());
		cardOutputDto.setCardNumber(newCard.getCardNumber());
		cardOutputDto.setCustomerId(newCard.getCustomerId());
		return cardOutputDto;
	}

	@Override
	public CardOutputDto DeactivateCreditCard(Long cardNumber, Long customerId) {
		Card card= this.CardRepository.findBycardNumber(cardNumber);
		card.setCardStatus("Deactivate");
		Card newCard=this.CardRepository.save(card);
		CardOutputDto cardOutputDto =new CardOutputDto();
		cardOutputDto.setCardStatus(newCard.getCardStatus());
		cardOutputDto.setCardNumber(newCard.getCardNumber());
		cardOutputDto.setCustomerId(newCard.getCustomerId());
		return cardOutputDto;
		
	}

	@Override
	public List<CardDto> CreditCardListAll() {
		List<Card> creditCards = this.CardRepository.findAll();
		List<CardDto> cardDto = creditCards.stream().map(this::ConvertEntityToCreditCardDto)
				.collect(Collectors.toList());
		return cardDto;
	}
}
