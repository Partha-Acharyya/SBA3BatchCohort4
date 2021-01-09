package com.wf.bootapp.ibs.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.wf.bootapp.ibs.dto.AccountStatementDto;
import com.wf.bootapp.ibs.dto.AddBeneficiaryInputDto;
import com.wf.bootapp.ibs.dto.AddBeneficiaryOutputDto;
import com.wf.bootapp.ibs.dto.FdInputDto;
import com.wf.bootapp.ibs.dto.FdOutputDto;
import com.wf.bootapp.ibs.dto.RdInputDto;
import com.wf.bootapp.ibs.dto.RdOutputDto;
import com.wf.bootapp.ibs.dto.UtilityDto;
import com.wf.bootapp.ibs.repository.RdRepository;
import com.wf.bootapp.ibs.repository.UserRepository;
import com.wf.bootapp.ibs.repository.AccountRepository;
import com.wf.bootapp.ibs.service.AccountService;
import com.wf.bootapp.ibs.repository.AddBeneficiaryRepository;
import com.wf.bootapp.ibs.repository.FdRepository;
import com.wf.bootapp.ibs.repository.AccountStatementRepository;
import com.wf.bootapp.ibs.entity.*;
import com.wf.bootapp.ibs.exception.InsufficientFundsException;
import com.wf.bootapp.ibs.exception.InvalidTransactionPasswordException;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository Repository;

	@Autowired
	RdRepository rdrepository;
	@Autowired
	FdRepository fdrepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	AddBeneficiaryRepository addBeneficiaryRepository;

	@Autowired
	AccountStatementRepository AccountStatementRepository;

	@Override
	public List<Account> fetchAllaccounts(Long CustomerId) {

		List<Account> accounts = this.Repository.findByCustomerId(CustomerId);

		return accounts;
	}

	@Override
	public List<RdOutputDto> fetchAllRd(Long CustomerId) {

		List<RecurringDeposit> RecurringDeposit = this.rdrepository.findByCustomerId(CustomerId);
		List<RdOutputDto> RdOutputDto = RecurringDeposit.stream().map(this::convertEntityToRdOutputDto)
				.collect(Collectors.toList());
		return RdOutputDto;
	}

	@Override
	public List<FdOutputDto> fetchAllFd(Long CustomerId) {

		List<FixedDeposit> FixedDeposit = this.fdrepository.findByCustomerId(CustomerId);
		List<FdOutputDto> FdOutputDto = FixedDeposit.stream().map(this::convertEntityToFdOutputDto)
				.collect(Collectors.toList());
		return FdOutputDto;
	}

	private FdOutputDto convertEntityToFdOutputDto(FixedDeposit FixedDeposit) {
		FdOutputDto FdOutputDto = new FdOutputDto();
		FdOutputDto.setAccountNumber(FixedDeposit.getAccountNumber());
		FdOutputDto.setInvestmentAmount(FixedDeposit.getInvestmentAmount());
		FdOutputDto.setMaturityDate(FixedDeposit.getMaturityDate());
		FdOutputDto.setFixedDepositID(FixedDeposit.getFixedDepositID());
		FdOutputDto.setTenure(FixedDeposit.getTenure());
		return FdOutputDto;

	}

	private RdOutputDto convertEntityToRdOutputDto(RecurringDeposit recurringDeposit) {
		RdOutputDto RdOutputDto = new RdOutputDto();
		RdOutputDto.setAccountNumber(recurringDeposit.getAccountNumber());
		RdOutputDto.setInvestmentAmount(recurringDeposit.getInvestmentAmount());
		RdOutputDto.setMaturityDate(recurringDeposit.getMaturityDate());
		RdOutputDto.setMonthlyDebitDate(recurringDeposit.getMonthlyDebitDate());
		RdOutputDto.setRecurringDepositID(recurringDeposit.getRecurringDepositID());
		RdOutputDto.setTenure(recurringDeposit.getTenure());
		return RdOutputDto;

	}

	@Override
	public RdOutputDto createRd(RdInputDto rdInputDto, Long accountNumber, Long customerId) {
		RecurringDeposit recurringDeposit = this.convertInputDtoToEntity(rdInputDto, accountNumber, customerId);
		Account account = this.Repository.findByAccountNumber(accountNumber);
		if ((account.getBalance()) > (rdInputDto.getInvestmentAmount())) {
			RecurringDeposit newRd = this.rdrepository.save(recurringDeposit);
			account.setBalance((account.getBalance()) - (rdInputDto.getInvestmentAmount()));
			this.Repository.save(account);
			RdOutputDto rdOutputDto = this.convertEntityToOutputDto(newRd);
			return rdOutputDto;
		}
		throw new InsufficientFundsException("InSufficient Funds");
	}

	@Override
	public FdOutputDto createFd(FdInputDto fdInputDto, Long accountNumber, Long customerId) {
		FixedDeposit FixedDeposit = this.convertInputFdDtoToEntity(fdInputDto, accountNumber, customerId);
		Account account = this.Repository.findByAccountNumber(accountNumber);
		if ((account.getBalance()) > (fdInputDto.getInvestmentAmount())) {
			FixedDeposit newFd = this.fdrepository.save(FixedDeposit);
			account.setBalance((account.getBalance()) - (fdInputDto.getInvestmentAmount()));
			this.Repository.save(account);
			FdOutputDto FdOutputDto = this.convertEntityToOutputFdDto(newFd);
			return FdOutputDto;
		}
		throw new InsufficientFundsException("InSufficient Funds");
	}

	private FdOutputDto convertEntityToOutputFdDto(FixedDeposit FixedDeposit) {
		FdOutputDto FdOutputDto = new FdOutputDto();
		FdOutputDto.setFixedDepositID(FixedDeposit.getFixedDepositID());
		FdOutputDto.setMaturityDate(FixedDeposit.getMaturityDate());
		return FdOutputDto;
	}

	private RdOutputDto convertEntityToOutputDto(RecurringDeposit recurringDeposit) {
		RdOutputDto rdOutputDto = new RdOutputDto();
		rdOutputDto.setRecurringDepositID(recurringDeposit.getRecurringDepositID());
		rdOutputDto.setMaturityDate(recurringDeposit.getMaturityDate());
		return rdOutputDto;
	}

	private FixedDeposit convertInputFdDtoToEntity(FdInputDto fdInputDto, Long accountNumber, Long customerId) {
		FixedDeposit FixedDeposit = new FixedDeposit();
		FixedDeposit.setAccountNumber(accountNumber);
		FixedDeposit.setInvestmentAmount(fdInputDto.getInvestmentAmount());
		FixedDeposit.setCustomerId(customerId);
		int tenure = fdInputDto.getTenure();
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, tenure);
		Date maturitydate = c.getTime();
		FixedDeposit.setMaturityDate(maturitydate);
		FixedDeposit.setTenure(fdInputDto.getTenure());
		return FixedDeposit;
	}

	private RecurringDeposit convertInputDtoToEntity(RdInputDto rdInputDto, Long accountNumber, Long customerId) {
		RecurringDeposit recurringDeposit = new RecurringDeposit();
		recurringDeposit.setAccountNumber(accountNumber);
		recurringDeposit.setInvestmentAmount(rdInputDto.getInvestmentAmount());
		recurringDeposit.setCustomerId(customerId);
		int tenure = rdInputDto.getTenure();
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, tenure);
		Date maturitydate = c.getTime();
		recurringDeposit.setMaturityDate(maturitydate);
		recurringDeposit.setMonthlyDebitDate(rdInputDto.getMonthlyDebitDate());
		recurringDeposit.setTenure(rdInputDto.getTenure());
		return recurringDeposit;
	}

	@Override
	public List<AccountStatement> fetchAlltransactions(Long customerId) {
		List<AccountStatement> miniStatement = this.AccountStatementRepository.findByCustomerId(customerId);
		return miniStatement;
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
		addBeneficiaryOutputDto.setBeneficiaryAccountType(AddBeneficiary.getBeneficiaryAccountType());
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
	public AddBeneficiaryOutputDto modifyBeneficiary(AddBeneficiaryInputDto addBeneficiaryInputDto, Long id) {
		AddBeneficiary modifyBeneficiary = this.addBeneficiaryRepository
				.findByBeneficiaryAccountNo(addBeneficiaryInputDto.getBeneficiaryAccountNo());
		if ((modifyBeneficiary.getBeneficiaryAccountNo()).equals(addBeneficiaryInputDto.getBeneficiaryAccountNo())
				&& (modifyBeneficiary.getCustomerId()).equals(id)) {
			modifyBeneficiary.setBeneficiaryAccountType(addBeneficiaryInputDto.getBeneficiaryAccountType());
			modifyBeneficiary.setBeneficiaryName(addBeneficiaryInputDto.getBeneficiaryName());
			modifyBeneficiary.setIfscCode(addBeneficiaryInputDto.getIfscCode());
			AddBeneficiary newModifyBeneficiary = this.addBeneficiaryRepository.save(modifyBeneficiary);
			AddBeneficiaryOutputDto addBeneficiaryOutputDto = new AddBeneficiaryOutputDto();
			addBeneficiaryOutputDto.setBeneficiaryAccountNo(newModifyBeneficiary.getBeneficiaryAccountNo());
			return addBeneficiaryOutputDto;
		}
		return null;

	}

	@Override
	public AddBeneficiaryOutputDto deleteBeneficiary(AddBeneficiaryInputDto addBeneficiaryInputDto, Long id) {
		Long BeneficiaryNo = addBeneficiaryInputDto.getBeneficiaryAccountNo();
		if (this.addBeneficiaryRepository.existsByBeneficiaryAccountNo(BeneficiaryNo)) {
			this.addBeneficiaryRepository.deleteByBeneficiaryAccountNo(BeneficiaryNo);
			AddBeneficiaryOutputDto addBeneficiaryOutputDto = new AddBeneficiaryOutputDto();
			addBeneficiaryOutputDto.setBeneficiaryAccountNo(addBeneficiaryInputDto.getBeneficiaryAccountNo());
			return addBeneficiaryOutputDto;
		}
		return null;
	}

	@Override
	public AccountStatementDto Transferfunds(AccountStatementDto AccountStatementDto, Long CustomerId) {
		Account account = this.Repository.findByAccountNumber(AccountStatementDto.getAccountNumber());
		Users user = this.userRepository.findByUsername(CustomerId);
		if (((account.getBalance()) > AccountStatementDto.getAmount())) {
			if ((user.getTransactionPassword()).equals(AccountStatementDto.getTransactionPassword())) {

				AccountStatement AccountStatement = this.convertAccountDtoToEntity(AccountStatementDto, CustomerId);
				AccountStatement newaccountStatement = this.AccountStatementRepository.save(AccountStatement);
				AccountStatementDto newAccountStatementDto = this.convertEntityToAccountDto(newaccountStatement);
				Double Balance = account.getBalance() - AccountStatementDto.getAmount();
				account.setBalance(Balance);
				return newAccountStatementDto;
			}
			throw new InvalidTransactionPasswordException("Invalid Transaction password ");
		}
		throw new InsufficientFundsException("InSufficient Funds");
	}

	private AccountStatementDto convertEntityToAccountDto(AccountStatement newaccountStatement) {

		AccountStatementDto AccountStatementDto = new AccountStatementDto();
		AccountStatementDto.setCreateDate(newaccountStatement.getCreateDate());
		AccountStatementDto.setBeneficiaryAccountNumber(newaccountStatement.getBeneficiaryAccountNumber());
		AccountStatementDto.setAccountNumber(newaccountStatement.getAccountNumber());
		return AccountStatementDto;
	}

	private AccountStatement convertAccountDtoToEntity(AccountStatementDto accountStatementDto, Long CustomerId) {
		AccountStatement AccountStatement = new AccountStatement();
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String strDate = dateFormat.format(date);
		AccountStatement.setCreateDate(strDate);
		AccountStatement.setAccountNumber(accountStatementDto.getAccountNumber());
		AccountStatement.setAmount(accountStatementDto.getAmount());
		AccountStatement.setBeneficiaryAccountNumber(accountStatementDto.getBeneficiaryAccountNumber());
		AccountStatement.setCustomerId(CustomerId);
		AccountStatement.setMessage(accountStatementDto.getMessage());
		AccountStatement.setTransactionType('D');
		return AccountStatement;
	}

	@Override
	public List<AccountStatementDto> requestAccountStatement(Long accountNumber, String startDate, String endDate) {
		List<AccountStatement> AccountStatement = this.AccountStatementRepository.findByAccountNumber(accountNumber,
				startDate, endDate);
		List<AccountStatementDto> AccountStatementDto = AccountStatement.stream()
				.map(this::convertEntityToAccountStatementOutputDto).collect(Collectors.toList());
		return AccountStatementDto;
	}

	private AccountStatementDto convertEntityToAccountStatementOutputDto(AccountStatement AccountStatement) {
		AccountStatementDto AccountStatementDto = new AccountStatementDto();
		AccountStatementDto.setBeneficiaryAccountNumber(AccountStatement.getBeneficiaryAccountNumber());
		AccountStatementDto.setAmount(AccountStatement.getAmount());
		AccountStatementDto.setCreateDate(AccountStatement.getCreateDate());
		AccountStatementDto.setMessage(AccountStatement.getMessage());
		AccountStatementDto.setTransactionType(AccountStatement.getTransactionType());
		return AccountStatementDto;

	}

	@Override
	public UtilityDto mobileRecharge(UtilityDto utilityDto, Long CustomerId) {
		Account account = this.Repository.findByAccountNumber(utilityDto.getAccountNumber());
		Users user = this.userRepository.findByUsername(CustomerId);
		if (((account.getBalance()) > utilityDto.getAmount())) {
			if ((user.getTransactionPassword()).equals(utilityDto.getTransactionPassword())) {

				AccountStatement AccountStatement = this.convertUtilityDtoToEntity(utilityDto, CustomerId);
				AccountStatement newaccountStatement = this.AccountStatementRepository.save(AccountStatement);
				Double Balance = account.getBalance() - utilityDto.getAmount();
				account.setBalance(Balance);
				UtilityDto UtilityDto = new UtilityDto();
				UtilityDto.setMessage(newaccountStatement.getMessage());
				return UtilityDto;
			}
			throw new InvalidTransactionPasswordException("Invalid Transaction password ");
		}
		throw new InsufficientFundsException("InSufficient Funds");
	}

	private AccountStatement convertUtilityDtoToEntity(UtilityDto utilityDto, Long customerId) {
		AccountStatement AccountStatement = new AccountStatement();
		AccountStatement.setAccountNumber(utilityDto.getAccountNumber());
		AccountStatement.setAmount(utilityDto.getAmount());
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String strDate = dateFormat.format(date);
		AccountStatement.setCreateDate(strDate);
		AccountStatement.setCustomerId(customerId);
		AccountStatement.setTransactionType('D');
		AccountStatement
				.setMessage("mobile -" + utilityDto.getMobileNumber() + " operator- " + utilityDto.getOperator());
		return AccountStatement;
	}

	@Override
	public UtilityDto electricity(UtilityDto utilityDto, Long CustomerId) {
		Account account = this.Repository.findByAccountNumber(utilityDto.getAccountNumber());
		Users user = this.userRepository.findByUsername(CustomerId);
		if (((account.getBalance()) > utilityDto.getAmount())) {
			if ((user.getTransactionPassword()).equals(utilityDto.getTransactionPassword())) {
			AccountStatement AccountStatement = this.convertUtilityElectDtoToEntity(utilityDto, CustomerId);
			AccountStatement newaccountStatement = this.AccountStatementRepository.save(AccountStatement);
			Double Balance = account.getBalance() - utilityDto.getAmount();
			account.setBalance(Balance);
			UtilityDto UtilityDto = new UtilityDto();
			UtilityDto.setMessage(newaccountStatement.getMessage());
			return UtilityDto;
		}
		throw new InvalidTransactionPasswordException("Invalid Transaction password ");
		}
	throw new InsufficientFundsException("InSufficient Funds");
	}

	private AccountStatement convertUtilityElectDtoToEntity(UtilityDto utilityDto, Long customerId) {
		AccountStatement AccountStatement = new AccountStatement();
		AccountStatement.setAccountNumber(utilityDto.getAccountNumber());
		AccountStatement.setAmount(utilityDto.getAmount());
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String strDate = dateFormat.format(date);
		AccountStatement.setCreateDate(strDate);
		AccountStatement.setCustomerId(customerId);
		AccountStatement.setTransactionType('D');
		AccountStatement.setMessage("USCNo -" + utilityDto.getUSCNo());
		return AccountStatement;
	}

	@Override
	public List<Account> fetchAllaccounts() {
		List<Account> accounts = this.Repository.findAll();
		return accounts;
	}

}
