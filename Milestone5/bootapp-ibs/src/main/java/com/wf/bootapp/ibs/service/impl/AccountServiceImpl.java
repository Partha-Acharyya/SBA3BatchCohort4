package com.wf.bootapp.ibs.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wf.bootapp.ibs.dto.AddBeneficiaryInputDto;
import com.wf.bootapp.ibs.dto.AddBeneficiaryOutputDto;
import com.wf.bootapp.ibs.dto.RdInputDto;
import com.wf.bootapp.ibs.dto.RdOutputDto;
import com.wf.bootapp.ibs.entity.Account;
import com.wf.bootapp.ibs.entity.MiniStatement;
import com.wf.bootapp.ibs.entity.RecurringDeposit;
import com.wf.bootapp.ibs.repository.RdRepository;
import com.wf.bootapp.ibs.repository.TransferRepository;
import com.wf.bootapp.ibs.repository.UserRepository;
import com.wf.bootapp.ibs.service.AccountService;

import com.wf.bootapp.ibs.repository.AddBeneficiaryRepository;
import com.wf.bootapp.ibs.repository.MiniStatementRepository;
import com.wf.bootapp.ibs.entity.*;

@Service

public class AccountServiceImpl implements AccountService {

	@Autowired
	UserRepository Repository;

	@Autowired
	RdRepository rdrepository;

	@Autowired
	AddBeneficiaryRepository addBeneficiaryRepository;

	@Override
	// @PostConstruct
	// @Transactional
	public List<Account> fetchAllaccounts(Long CustomerId) {

		List<Account> accounts = this.Repository.findByCustomerId(CustomerId);

		return accounts;
	}

	@Override
	public RdOutputDto createRd(RdInputDto rdInputDto) {
		RecurringDeposit recurringDeposit = this.convertInputDtoToEntity(rdInputDto);
		RecurringDeposit newRd = this.rdrepository.save(recurringDeposit);
		RdOutputDto rdOutputDto = this.convertEntityToOutputDto(newRd);
		return rdOutputDto;
	}

	private RdOutputDto convertEntityToOutputDto(RecurringDeposit recurringDeposit) {
		RdOutputDto rdOutputDto = new RdOutputDto();
		rdOutputDto.setRecurringDepositID(recurringDeposit.getRecurringDepositID());
		return rdOutputDto;
	}

	private RecurringDeposit convertInputDtoToEntity(RdInputDto rdInputDto) {
		RecurringDeposit recurringDeposit = new RecurringDeposit();
		recurringDeposit.setRecurringDepositID(recurringDeposit.getRecurringDepositID());
		recurringDeposit.setAccountNumber(recurringDeposit.getAccountNumber());
		recurringDeposit.setInvestmentAmount(recurringDeposit.getInvestmentAmount());
		recurringDeposit.setMaturityDate(recurringDeposit.getMaturityDate());
		recurringDeposit.setMonthlyDebitDate(recurringDeposit.getMonthlyDebitDate());
		recurringDeposit.setTenure(recurringDeposit.getTenure());
		return recurringDeposit;
	}

	@Autowired
	MiniStatementRepository miniStatementRepository;

	@Override
	public List<MiniStatement> fetchAlltransactions(Long CustId) {
		List<MiniStatement> miniStatement = this.miniStatementRepository.findByCustId(CustId);

		// Collections.sort(miniStatement,Collections.reverseOrder());
		return miniStatement;
	}

	@Autowired
	TransferRepository transferRepository;

	@Override
	public List<Transferfunds> Transferfunds(Long CustomerId) {
		// TODO Auto-generated method stub
		List<Transferfunds> Transferfunds = this.transferRepository.findByCustomerId(CustomerId);

		return Transferfunds;
	}


	@Override
	public List<AddBeneficiary> fetchAllBeneficiaries(Long customerId) {

		List<AddBeneficiary> addIBSBeneficiary = this.addBeneficiaryRepository.findByCustomerId(customerId);

		return addIBSBeneficiary;
	}



	@Override
	public AddBeneficiaryOutputDto addBeneficiary(AddBeneficiaryInputDto addBeneficiaryInputDto, Long id) {
		AddBeneficiary addBeneficiary = this.convertAddBeneficiaryInputDtoToEntity(addBeneficiaryInputDto, id);
		AddBeneficiary newAddBeneficiary = this.addBeneficiaryRepository.save(addBeneficiary);
		AddBeneficiaryOutputDto addBeneficiaryOutputDto = new AddBeneficiaryOutputDto();
		addBeneficiaryOutputDto.setBeneficiaryAccountNo(newAddBeneficiary.getBeneficiaryAccountNo());
		addBeneficiaryOutputDto.setStatus(newAddBeneficiary.getStatus());
		return addBeneficiaryOutputDto;
	}

	private AddBeneficiary convertAddBeneficiaryInputDtoToEntity(AddBeneficiaryInputDto addBeneficiaryInputDto,
			Long id) {
		AddBeneficiary addBeneficiary = new AddBeneficiary();
		addBeneficiary.setCustomerId(id);
		addBeneficiary.setBeneficiaryAccountNo(addBeneficiaryInputDto.getBeneficiaryAccountNo());
		addBeneficiary.setBeneficiaryAccountType(addBeneficiaryInputDto.getBeneficiaryAccountType());
		addBeneficiary.setBeneficiaryName(addBeneficiaryInputDto.getBeneficiaryName());
		addBeneficiary.setIfscCode(addBeneficiaryInputDto.getIfscCode());
		addBeneficiary.setStatus("Pending");
		return addBeneficiary;
	}

	@Override
	public List<AddBeneficiaryOutputDto> BeneficiaryList(Long customerId) {
		List<AddBeneficiary> beneficiaryList = this.addBeneficiaryRepository.findByCustomerId(customerId);
		List<AddBeneficiaryOutputDto> AddBeneficiaryOutputDto = beneficiaryList.stream()
				.map(this::convertAddBeneficiaryEntityToOutputDto).collect(Collectors.toList());

		return AddBeneficiaryOutputDto;
	}

	private AddBeneficiaryOutputDto convertAddBeneficiaryEntityToOutputDto(AddBeneficiary AddBeneficiary) {
		AddBeneficiaryOutputDto addBeneficiaryOutputDto = new AddBeneficiaryOutputDto();
		addBeneficiaryOutputDto.setBeneficiaryAccountNo(AddBeneficiary.getBeneficiaryAccountNo());
		addBeneficiaryOutputDto.setStatus(AddBeneficiary.getStatus());
		return addBeneficiaryOutputDto;
	}

	@Override
	public List<AddBeneficiaryOutputDto> getAllibsBeneficiaries(Long customerId) {
		List<AddBeneficiary> ibsBeneficiaries = this.addBeneficiaryRepository.findByCustomerId(customerId);
		List<AddBeneficiaryOutputDto> AddBeneficiaryOutputDto = ibsBeneficiaries.stream()
				.map(this::convertAddBeneficiaryEntityToOutputDto).collect(Collectors.toList());
		return AddBeneficiaryOutputDto;
	}

	@Override
	public AddBeneficiaryOutputDto ViewOrDeleteListOfBeneficiariesAdded(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
