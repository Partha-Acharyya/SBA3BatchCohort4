package com.wf.bootapp.ibs.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.wf.bootapp.ibs.dto.rdInputDto;
import com.wf.bootapp.ibs.dto.rdOutputDto;
import com.wf.bootapp.ibs.entity.account;
import com.wf.bootapp.ibs.entity.miniStatement;
import com.wf.bootapp.ibs.entity.recurringDeposit;
import com.wf.bootapp.ibs.repository.rdRepository;
import com.wf.bootapp.ibs.repository.transferRepository;
import com.wf.bootapp.ibs.repository.userRepository;
import org.springframework.data.repository.CrudRepository;
import com.wf.bootapp.ibs.repository.miniStatementRepository;
import com.wf.bootapp.ibs.entity.*;


@Service

public class accountServiceImpl implements accountService {
	
	@Autowired
	userRepository Repository;
	
	@Autowired
	rdRepository rdrepository;

	@Override
	//@PostConstruct
	//@Transactional
	public List<account> fetchAllaccounts(Long CustomerId) {
	
		List<account> accounts = this.Repository.findByCustomerId(CustomerId);
		
		return accounts;
	}

	@Override
	public rdOutputDto createRd(rdInputDto rdInputDto) {
		recurringDeposit recurringDeposit = this.convertInputDtoToEntity(rdInputDto);
		recurringDeposit newRd = this.rdrepository.save(recurringDeposit);
		rdOutputDto rdOutputDto =  this.convertEntityToOutputDto(newRd);
		return rdOutputDto;
	}
	private rdOutputDto convertEntityToOutputDto(recurringDeposit recurringDeposit) {
		rdOutputDto rdOutputDto = new rdOutputDto();
		rdOutputDto.setRecurringDepositID(recurringDeposit.getRecurringDepositID());		
		return rdOutputDto;
	}
	
	private recurringDeposit convertInputDtoToEntity(rdInputDto rdInputDto) {
		recurringDeposit recurringDeposit = new recurringDeposit();
		recurringDeposit.setRecurringDepositID(recurringDeposit.getRecurringDepositID());
		recurringDeposit.setAccountNumber(recurringDeposit.getAccountNumber());
		recurringDeposit.setInvestmentAmount(recurringDeposit.getInvestmentAmount());
		recurringDeposit.setMaturityDate(recurringDeposit.getMaturityDate());
		recurringDeposit.setMonthlyDebitDate(recurringDeposit.getMonthlyDebitDate());
		recurringDeposit.setTenure(recurringDeposit.getTenure());	
		return recurringDeposit;
	}
	@Autowired
	miniStatementRepository miniStatementRepository;

	@Override
	public List<miniStatement> fetchAlltransactions(Long CustId) {
		
		List<miniStatement> miniStatement = this.miniStatementRepository.findByCustId(CustId);
		
		return miniStatement;
	}
	@Autowired
	transferRepository transferRepository;
	

	@Override
	public List<Transferfunds> Transferfunds(Long CustomerId) {
		// TODO Auto-generated method stub
		List<Transferfunds> Transferfunds = this.transferRepository.findByCustomerId(CustomerId);
		
		return Transferfunds;
	}
	

}

