package com.wf.bootapp.ibs.service.impl;

import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.wf.bootapp.ibs.dto.RdInputDto;
import com.wf.bootapp.ibs.dto.RdOutputDto;
import com.wf.bootapp.ibs.entity.Account;
import com.wf.bootapp.ibs.entity.MiniStatement;
import com.wf.bootapp.ibs.entity.RecurringDeposit;
import com.wf.bootapp.ibs.repository.RdRepository;
import com.wf.bootapp.ibs.repository.TransferRepository;
import com.wf.bootapp.ibs.repository.UserRepository;
import com.wf.bootapp.ibs.service.AccountService;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import com.wf.bootapp.ibs.repository.MiniStatementRepository;
import com.wf.bootapp.ibs.entity.*;


@Service

public class AccountServiceImpl implements AccountService {
	
	@Autowired
	UserRepository Repository;
	
	@Autowired
	RdRepository rdrepository;

	@Override
	//@PostConstruct
	//@Transactional
	public List<Account> fetchAllaccounts(Long CustomerId) {
	
		List<Account> accounts = this.Repository.findByCustomerId(CustomerId);
		
		return accounts;
	}

	@Override
	public RdOutputDto createRd(RdInputDto rdInputDto) {
		RecurringDeposit recurringDeposit = this.convertInputDtoToEntity(rdInputDto);
		RecurringDeposit newRd = this.rdrepository.save(recurringDeposit);
		RdOutputDto rdOutputDto =  this.convertEntityToOutputDto(newRd);
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
		Collections.sort(miniStatement,Collections.reverseOrder());
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
	

}

