package com.wf.bootapp.ibs.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.wf.bootapp.ibs.dto.AccountStatementDto;
import com.wf.bootapp.ibs.dto.AddBeneficiaryInputDto;
import com.wf.bootapp.ibs.dto.AddBeneficiaryOutputDto;
import com.wf.bootapp.ibs.dto.FdInputDto;
import com.wf.bootapp.ibs.dto.FdOutputDto;
import com.wf.bootapp.ibs.dto.RdInputDto;
import com.wf.bootapp.ibs.dto.RdOutputDto;
import com.wf.bootapp.ibs.dto.UtilityDto;
import com.wf.bootapp.ibs.entity.Account;
import com.wf.bootapp.ibs.entity.AccountStatement;
import com.wf.bootapp.ibs.entity.*;




public interface AccountService {
	public List<Account> fetchAllaccounts(Long CustomerId);
	public List<AccountStatement> fetchAlltransactions(Long custId);
	public List<AddBeneficiary> fetchAllBeneficiaries(Long customerId);
	public AddBeneficiaryOutputDto addBeneficiary(AddBeneficiaryInputDto AddBeneficiaryInputDto,Long id);
	public List<AddBeneficiaryOutputDto> BeneficiaryList(Long id);
	public List<AddBeneficiaryOutputDto> getAllibsBeneficiaries(Long customerId);
	AddBeneficiaryOutputDto modifyBeneficiary(AddBeneficiaryInputDto addBeneficiaryInputDto, Long id);
	AddBeneficiaryOutputDto deleteBeneficiary(AddBeneficiaryInputDto addBeneficiaryInputDto, Long id);
	public AccountStatementDto Transferfunds(AccountStatementDto AccountStatementDto,Long CustomerId);
	public List<AccountStatementDto> requestAccountStatement(Long accountNumber, String startDate, String endDate);
	public List<RdOutputDto> fetchAllRd(Long CustomerId);
	public List<FdOutputDto> fetchAllFd(Long CustomerId);
	public FdOutputDto createFd(FdInputDto fdInputDto, Long accountNumber,Long customerId);
	RdOutputDto createRd(RdInputDto rdInputDto, Long accountNumber, Long customerId);
	public UtilityDto mobileRecharge(UtilityDto utilityDto, Long iD);
	public UtilityDto electricity(UtilityDto utilityDto, Long iD);
	public List<Account> fetchAllaccounts();

}
