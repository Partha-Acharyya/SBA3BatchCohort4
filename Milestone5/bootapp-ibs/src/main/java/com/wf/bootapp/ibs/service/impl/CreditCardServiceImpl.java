package com.wf.bootapp.ibs.service.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wf.bootapp.ibs.dto.CreditCardEligibilityInputDto;
import com.wf.bootapp.ibs.dto.CreditCardEligibilityOutputDto;
import com.wf.bootapp.ibs.dto.CardDto;
import com.wf.bootapp.ibs.dto.CreditCardStatementDto;
import com.wf.bootapp.ibs.entity.CreditCard;
import com.wf.bootapp.ibs.entity.CreditCardEligibility;
import com.wf.bootapp.ibs.repository.CreditCardEligibilityRepository;
import com.wf.bootapp.ibs.repository.CreditCardRepository;
import com.wf.bootapp.ibs.service.CreditCardService;

@Service
public class CreditCardServiceImpl implements CreditCardService {

	@Autowired
	private CreditCardEligibilityRepository creditCardEligibilityRepository;
	@Autowired
	private CreditCardRepository creditCardRepository;
//	@Autowired
//	private CreditCardStatementRepository creditCardStatementRepository;

	
	@Override
	public CreditCardEligibilityOutputDto applyCreditCard(CreditCardEligibilityInputDto creditCardEligibilityInputDto,Long id) {
		CreditCardEligibility creditCardEligibility=this.convertCCInputDtoToEntity(creditCardEligibilityInputDto,id);
		CreditCardEligibility newcreditCardEligibility=this.creditCardEligibilityRepository.save(creditCardEligibility);
		CreditCardEligibilityOutputDto creditCardEligibilityOutputDto =new CreditCardEligibilityOutputDto();
		creditCardEligibilityOutputDto.setReferenceID(newcreditCardEligibility.getReferenceID());	
		return creditCardEligibilityOutputDto;
	}

	private CreditCardEligibility convertCCInputDtoToEntity(
			CreditCardEligibilityInputDto creditCardEligibilityInputDto,Long id) {
		CreditCardEligibility creditCardEligibility =new CreditCardEligibility();
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
		List<CreditCard> creditCards=this.creditCardRepository.findBycustomerId(id);
		List<CardDto> cardDto= creditCards.stream().map(this::ConvertEntityToCreditCardDto).collect(Collectors.toList());	
		
		return cardDto;
	}
	@Override
	public boolean resetCcPin(CardDto creditCardInputDto, Long id) {
		
		return false;
	}
	

	private CardDto ConvertEntityToCreditCardDto(CreditCard creditCards) {
		CardDto CreditCardDto=new CardDto();
		CreditCardDto.setCardNumber(creditCards.getCcNumber());
		return CreditCardDto;
	}

	@Override
	public List<CreditCardStatementDto> requestCardStatement(CardDto creditCardInputDto, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean statementMismatch(CardDto creditCardInputDto, Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean creditCardUpgrade(CardDto creditCardInputDto, Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<CreditCardEligibilityOutputDto> getAllCcEligibilities() {
		List<CreditCardEligibility> creditCardEligibilities=this.creditCardEligibilityRepository.findByStatus("Pending");
		List<CreditCardEligibilityOutputDto> CreditCardEligibilitiesOutputDto=creditCardEligibilities.stream()
				.map(this::convertEntityToCcOutputDto).collect(Collectors.toList());
		return CreditCardEligibilitiesOutputDto;
	}

	private CreditCardEligibilityOutputDto convertEntityToCcOutputDto(
			CreditCardEligibility creditCardEligibilities) {
		CreditCardEligibilityOutputDto creditCardEligibilityOutputDto=new CreditCardEligibilityOutputDto();
		creditCardEligibilityOutputDto.setFirstName(creditCardEligibilities.getFirstName());
		creditCardEligibilityOutputDto.setLastName(creditCardEligibilities.getLastName());
		creditCardEligibilityOutputDto.setMobileNumber(creditCardEligibilities.getMobileNumber());
		creditCardEligibilityOutputDto.setReferenceID(creditCardEligibilities.getReferenceID());
		creditCardEligibilityOutputDto.setStatus(creditCardEligibilities.getStatus());
		creditCardEligibilityOutputDto.setTotalIncome(creditCardEligibilities.getTotalIncome());
		creditCardEligibilityOutputDto.setTypeOfEmployment(creditCardEligibilities.getTypeOfEmployment());
		return creditCardEligibilityOutputDto;
	}

	@Override
	public CreditCardEligibilityOutputDto ApproveCardRequest(Long id) {
		CreditCardEligibility creditCardEligibility=this.creditCardEligibilityRepository.findById(id).orElse(null);
		creditCardEligibility.setStatus("Approved");
		CreditCardEligibility newCreditCardEligibility=this.creditCardEligibilityRepository.save(creditCardEligibility);
		CreditCardEligibilityOutputDto CreditCardEligibilityOutputDto=this.convertEntityToCcOutputDto(newCreditCardEligibility);	
		return CreditCardEligibilityOutputDto;
	}
	@Override
	public CreditCardEligibilityOutputDto DeclineCardRequest(Long id) {
		CreditCardEligibility creditCardEligibility=this.creditCardEligibilityRepository.findById(id).orElse(null);
		creditCardEligibility.setStatus("Declined");
		CreditCardEligibility newCreditCardEligibility=this.creditCardEligibilityRepository.save(creditCardEligibility);
		CreditCardEligibilityOutputDto CreditCardEligibilityOutputDto=this.convertEntityToCcOutputDto(newCreditCardEligibility);	
		return CreditCardEligibilityOutputDto;
	}

	

}
