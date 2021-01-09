package com.wf.bootapp.ibs.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wf.bootapp.ibs.dto.AccountStatementDto;
import com.wf.bootapp.ibs.dto.AddBeneficiaryInputDto;
import com.wf.bootapp.ibs.dto.AddBeneficiaryOutputDto;
import com.wf.bootapp.ibs.dto.CardDto;
import com.wf.bootapp.ibs.dto.CardOutputDto;
import com.wf.bootapp.ibs.dto.CreditCardEligibilityInputDto;
import com.wf.bootapp.ibs.dto.CreditCardEligibilityOutputDto;
import com.wf.bootapp.ibs.dto.FdInputDto;
import com.wf.bootapp.ibs.dto.FdOutputDto;
import com.wf.bootapp.ibs.dto.HomeLoanDto;
import com.wf.bootapp.ibs.dto.CardStatementDto;
import com.wf.bootapp.ibs.entity.Account;
import com.wf.bootapp.ibs.exception.InsufficientFundsException;
import com.wf.bootapp.ibs.exception.InvalidTransactionPasswordException;
import com.wf.bootapp.ibs.exception.SameCardPinException;
import com.wf.bootapp.ibs.exception.IncorrectCVVException;
import com.wf.bootapp.ibs.repository.EducationLoanRepository;
import com.wf.bootapp.ibs.repository.HomeLoanRepository;
import com.wf.bootapp.ibs.repository.PersonalLoanRepository;
import com.wf.bootapp.ibs.repository.VehicleLoanRepository;
import com.wf.bootapp.ibs.service.AccountService;
import com.wf.bootapp.ibs.service.CreditCardService;
import com.wf.bootapp.ibs.service.DebitCardService;
import com.wf.bootapp.ibs.service.UserService;
import com.wf.bootapp.ibs.validators.LoanValidator;
import com.wf.bootapp.ibs.validators.PersonalLoanValidator;
import com.wf.bootapp.ibs.validators.VehicleLoanValidator;
import com.wf.bootapp.ibs.validators.HomeLoanValidator;
import com.wf.bootapp.ibs.dto.LoanDto;
import com.wf.bootapp.ibs.dto.PersonalLoanDto;
import com.wf.bootapp.ibs.dto.RdInputDto;
import com.wf.bootapp.ibs.dto.RdOutputDto;
import com.wf.bootapp.ibs.dto.UtilityDto;
import com.wf.bootapp.ibs.dto.VehicleLoanDto;
import com.wf.bootapp.ibs.entity.*;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private CreditCardService CreditCardService;

	@Autowired
	private DebitCardService DebitCardService;
	@Autowired
	ServletContext context;

	@RequestMapping("/home")
	public String userhome() {

		return "account";
	}
	
	

	@RequestMapping("/CreditCard")
	public String CreditCard() {
		return "CreditCard";
	}

	@RequestMapping("/serviceProvider")
	public String serviceProvider() {
		return "serviceprovider";
	}

	@RequestMapping("/DebitCard")
	public String DebitCard(Model model) {
		CardDto CardDto = new CardDto();
		model.addAttribute("CardDto", CardDto);
		List<CardDto> CardDto1 = this.DebitCardService.DebitCardList(Long.parseLong(getLoggedInUserName()));
		model.addAttribute("CardDto1", CardDto1);
		return "DebitCard";
	}

	@RequestMapping("/CCApply")
	public String ccApply(Model model) {
		CreditCardEligibilityInputDto creditCardEligibilityinputDto = new CreditCardEligibilityInputDto();
		model.addAttribute("creditCardEligibilityInputDto", creditCardEligibilityinputDto);
		return "CCApply";
	}

	@RequestMapping("/CCApplysuccess")
	public String ccApplysuccess(@Valid @ModelAttribute CreditCardEligibilityInputDto creditCardEligibilityInputDto,
			BindingResult result, Model model) {
		Long id = Long.parseLong(getLoggedInUserName());
		if (result.hasErrors()) {
			return "CCApply";
		}
		CreditCardEligibilityOutputDto creditCardEligibilityOutputDto = this.CreditCardService
				.applyCreditCard(creditCardEligibilityInputDto, id);
		model.addAttribute("creditCardEligibilityOutputDto", creditCardEligibilityOutputDto);
		return "CCEligibility_Success";
	}

	@RequestMapping("/blockUnblockCreditCard")
	public String blockUnblockCreditCard(Model model) {
		CardDto CardDto = new CardDto();
		model.addAttribute("CardDto", CardDto);
		List<CardDto> CardDto1 = this.CreditCardService.CreditCardList(Long.parseLong(getLoggedInUserName()));
		model.addAttribute("CardDto1", CardDto1);
		return "BlockCreditCard";

	}

	@RequestMapping("/blockUnblockCreditCardsuccess")
	public String blockUnblockCreditCardsuccess(@Valid @ModelAttribute("CardDto") CardDto CardDto, BindingResult result,
			Model model) {
		Long id = Long.parseLong(getLoggedInUserName());
		System.out.println(CardDto.getCardNumber());
		if (result.hasErrors()) {
			List<CardDto> CardDto1 = this.CreditCardService.CreditCardList(Long.parseLong(getLoggedInUserName()));
			model.addAttribute("CardDto1", CardDto1);
			return "BlockCreditCard";
		}
		CardOutputDto CardOutputDto = this.CreditCardService.BlockUnblockCard(CardDto, id);
		model.addAttribute("CardOutputDto", CardOutputDto);
		return "blockUnblockCreditCardsuccess";
	}

	@RequestMapping("/ResetCCPin")
	public String ResetCCPin(Model model) {
		CardDto CardDto = new CardDto();
		model.addAttribute("CardDto", CardDto);
		List<CardDto> CardDto1 = this.CreditCardService.CreditCardList(Long.parseLong(getLoggedInUserName()));
		model.addAttribute("CardDto1", CardDto1);
		return "ResetCCPin";

	}

	@RequestMapping("/ResetPinSuccess")
	public String ResetPinSuccess(@Valid @ModelAttribute("CardDto") CardDto CardDto, BindingResult result,
			Model model) {
		Long id = Long.parseLong(getLoggedInUserName());
		if (result.hasErrors()) {
			List<CardDto> CardDto1 = this.CreditCardService.CreditCardList(Long.parseLong(getLoggedInUserName()));
			model.addAttribute("CardDto1", CardDto1);
			return "ResetCCPin";
		}
		CardOutputDto CardOutputDto = this.CreditCardService.resetCcPin(CardDto, id);
		model.addAttribute("CardOutputDto", CardOutputDto);
		return "ResetPinSuccess";
	}

	@RequestMapping("/requestCcStatement")
	public String requestCcStatement(Model model) {
		CardStatementDto CardStatementDto = new CardStatementDto();
		model.addAttribute("CardStatementDto", CardStatementDto);
		List<CardDto> CardDto1 = this.CreditCardService.CreditCardList(Long.parseLong(getLoggedInUserName()));
		model.addAttribute("CardDto1", CardDto1);
		return "RequestCCStatement";
	}

	@RequestMapping("/displayCcStatement")
	public String displayCcStatement(@ModelAttribute CardStatementDto CreditCardStatementDto, ModelMap model) {

		Long creditCardNumber = CreditCardStatementDto.getCardNumber();
		String startDate = CreditCardStatementDto.getStartDate();
		String endDate = CreditCardStatementDto.getEndDate();
		List<CardStatementDto> statements = this.CreditCardService.requestCardStatement(creditCardNumber, startDate,
				endDate);
		model.addAttribute("statements", statements);
		return "displayCcStatement";
	}

	@RequestMapping("/CCStatementMismatch")
	public String CCStatementMismatch(Model model) {
		CardDto CardDto = new CardDto();
		model.addAttribute("CardDto", CardDto);
		List<CardDto> CardDto1 = this.CreditCardService.CreditCardList(Long.parseLong(getLoggedInUserName()));
		model.addAttribute("CardDto1", CardDto1);
		return "CCStatementmismatch";
	}

	@RequestMapping("/CCStatementMismatch_Success")
	public String ccStatementMismatch_Success(@ModelAttribute("CardDto") CardDto CardDto, Model model)
			throws IOException {
		Long id = Long.parseLong(getLoggedInUserName());
		MultipartFile multipartFile = CardDto.getFile();
		String uploadPath = context.getRealPath("") + File.separator + "temp" + File.separator;
		FileCopyUtils.copy(CardDto.getFile().getBytes(),
				new File(uploadPath + CardDto.getFile().getOriginalFilename()));
		String fileName = multipartFile.getOriginalFilename();
		CardOutputDto CardOutputDto = this.CreditCardService.ccStatementMismatch(CardDto, id, fileName);
		model.addAttribute("CardOutputDto", CardOutputDto);
		return "CCStatementMismatch_Success";
	}

	@RequestMapping("CreditCardUpgrade")
	public String CreditCardUpgrade(Model model) {
		CardDto CardDto = new CardDto();
		model.addAttribute("CardDto", CardDto);
		List<CardDto> CardDto1 = this.CreditCardService.CreditCardList(Long.parseLong(getLoggedInUserName()));
		model.addAttribute("CardDto1", CardDto1);
		return "CreditCardUpgrade";

	}

	@RequestMapping("/CreditCardUpgrade_success")
	public String CreditCardUpgrade_success(@Valid @ModelAttribute("CardDto") CardDto CardDto, BindingResult result,
			Model model) {
		Long id = Long.parseLong(getLoggedInUserName());
		System.out.println(CardDto.getCardNumber());
		CardOutputDto CardOutputDto = this.CreditCardService.creditCardUpgrade(CardDto, id);
		model.addAttribute("CardOutputDto", CardOutputDto);
		return "CreditCardUpgrade_success";
	}

	@RequestMapping("/blockUnblockDebitCard")
	public String blockUnblockDebitCard(Model model) {
		CardDto CardDto = new CardDto();
		model.addAttribute("CardDto", CardDto);
		List<CardDto> CardDto1 = this.DebitCardService.DebitCardList(Long.parseLong(getLoggedInUserName()));
		model.addAttribute("CardDto1", CardDto1);
		return "BlockDebitCard";

	}

	@RequestMapping("/blockUnblockDebitCardsuccess")
	public String blockUnblockDebitCardsuccess(@Valid @ModelAttribute("CardDto") CardDto CardDto, Model model,
			BindingResult result) {
		Long id = Long.parseLong(getLoggedInUserName());
		if (result.hasErrors()) {
			List<CardDto> CardDto1 = this.DebitCardService.DebitCardList(Long.parseLong(getLoggedInUserName()));
			model.addAttribute("CardDto1", CardDto1);
			return "BlockDebitCard";
		}
		CardOutputDto CardOutputDto = this.DebitCardService.BlockUnblockCard(CardDto, id);
		model.addAttribute("CardOutputDto", CardOutputDto);
		return "blockUnblockDebitCardsuccess";
	}

	@RequestMapping("/ResetDcPin")
	public String ResetDCPin(Model model) {
		CardDto CardDto = new CardDto();
		model.addAttribute("CardDto", CardDto);
		List<CardDto> CardDto1 = this.DebitCardService.DebitCardList(Long.parseLong(getLoggedInUserName()));
		model.addAttribute("CardDto1", CardDto1);
		return "ResetDCPin";

	}

	@RequestMapping("/ResetDcPinSuccess")
	public String ResetDcPinSuccess(@Valid @ModelAttribute("CardDto") CardDto CardDto, BindingResult result,
			Model model) {
		Long id = Long.parseLong(getLoggedInUserName());
		if (result.hasErrors()) {
			List<CardDto> CardDto1 = this.DebitCardService.DebitCardList(Long.parseLong(getLoggedInUserName()));
			model.addAttribute("CardDto1", CardDto1);
			return "ResetDCPin";
		}
		CardOutputDto CardOutputDto = this.DebitCardService.resetDcPin(CardDto, id);
		model.addAttribute("CardOutputDto", CardOutputDto);
		return "ResetDcPinSuccess";
	}

	@RequestMapping("/requestDcStatement")
	public String requestDcStatement(Model model) {
		CardStatementDto CardStatementDto = new CardStatementDto();
		model.addAttribute("CardStatementDto", CardStatementDto);
		List<CardDto> CardDto1 = this.DebitCardService.DebitCardList(Long.parseLong(getLoggedInUserName()));
		model.addAttribute("CardDto1", CardDto1);
		return "RequestDCStatement";
	}

	@RequestMapping("/displayDcStatement")
	public String displayDcStatement(@ModelAttribute CardStatementDto CreditCardStatementDto, ModelMap model) {

		Long debitCardNumber = CreditCardStatementDto.getCardNumber();
		String startDate = CreditCardStatementDto.getStartDate();
		String endDate = CreditCardStatementDto.getEndDate();
		List<CardStatementDto> statements = this.DebitCardService.requestCardStatement(debitCardNumber, startDate,
				endDate);
		model.addAttribute("statements", statements);
		return "displayDcStatement";
	}

	@RequestMapping("/dcStatementMismatch")
	public String DCStatementMismatch(Model model) {
		CardDto CardDto = new CardDto();
		model.addAttribute("CardDto", CardDto);
		List<CardDto> CardDto1 = this.DebitCardService.DebitCardList(Long.parseLong(getLoggedInUserName()));
		model.addAttribute("CardDto1", CardDto1);
		return "DCStatementmismatch";
	}

	@RequestMapping("/DCStatementMismatch_Success")
	public String dcStatementMismatch_Success(@ModelAttribute("CardDto") CardDto CardDto, Model model)
			throws IOException {
		Long id = Long.parseLong(getLoggedInUserName());
		MultipartFile multipartFile = CardDto.getFile();
		String uploadPath = context.getRealPath("") + File.separator + "temp" + File.separator;
		FileCopyUtils.copy(CardDto.getFile().getBytes(),
				new File(uploadPath + CardDto.getFile().getOriginalFilename()));
		String fileName = multipartFile.getOriginalFilename();
		CardOutputDto CardOutputDto = this.DebitCardService.dcStatementMismatch(CardDto, id, fileName);
		model.addAttribute("CardOutputDto", CardOutputDto);
		return "DCStatementMismatch_Success";
	}

	@RequestMapping("DebitCardUpgrade")
	public String DebitCardUpgrade(Model model) {
		CardDto CardDto = new CardDto();
		model.addAttribute("CardDto", CardDto);
		List<CardDto> CardDto1 = this.DebitCardService.DebitCardList(Long.parseLong(getLoggedInUserName()));
		model.addAttribute("CardDto1", CardDto1);
		return "DebitCardUpgrade";

	}

	@RequestMapping("/DebitCardUpgrade_success")
	public String DebitCardUpgrade_success(@ModelAttribute CardDto CardDto, Model model) {
		Long id = Long.parseLong(getLoggedInUserName());
		CardOutputDto CardOutputDto = this.DebitCardService.debitCardUpgrade(CardDto, id);
		model.addAttribute("CardOutputDto", CardOutputDto);
		return "DebitCardUpgrade_success";
	}

	@RequestMapping("/AddBeneficiary")
	public String addIBSBeneficiary(Model model) {
		Long customerId = Long.parseLong(getLoggedInUserName());
		AddBeneficiaryInputDto addBeneficiaryInputDto = new AddBeneficiaryInputDto();
		model.addAttribute("AddBeneficiaryInputDto", addBeneficiaryInputDto);
		List<AddBeneficiaryOutputDto> ibsBeneficiaries = this.accountService.getAllibsBeneficiaries(customerId);
		model.addAttribute("ibsBeneficiaries", ibsBeneficiaries);
		return "AddBeneficiary";
	}

	@RequestMapping("/BeneficiaryAddedSuccessfully")
	public String addIBSBeneficiary(@ModelAttribute AddBeneficiaryInputDto addBeneficiaryInputDto, Model model) {
		Long customerId = Long.parseLong(getLoggedInUserName());
		/*
		 * if (result.hasErrors()) { return "AddBeneficiary"; }
		 */
		AddBeneficiaryOutputDto addBeneficiaryOutputDto = this.accountService.addBeneficiary(addBeneficiaryInputDto,
				customerId);
		model.addAttribute("addBeneficiaryOutputDto", addBeneficiaryOutputDto);
		return "BeneficiaryAddedSuccessfully";
	}

	@RequestMapping("/AddNonIBSBeneficiary")
	public String addNonIBSBeneficiary(Model model) {
		AddBeneficiaryInputDto addBeneficiaryInputDto = new AddBeneficiaryInputDto();
		model.addAttribute("AddBeneficiaryInputDto", addBeneficiaryInputDto);
		return "AddNonIBSBeneficiary";
	}

	@RequestMapping("/NonIBSBeneficiaryAddedSuccessfully")
	public String addNonIBSBeneficiary(@ModelAttribute AddBeneficiaryInputDto addBeneficiaryInputDto, Model model) {
		Long customerId = Long.parseLong(getLoggedInUserName());
		/*
		 * if (result.hasErrors()) { return "AddBeneficiary"; }
		 */
		AddBeneficiaryOutputDto addBeneficiaryOutputDto = this.accountService.addBeneficiary(addBeneficiaryInputDto,
				customerId);
		model.addAttribute("addBeneficiaryOutputDto", addBeneficiaryOutputDto);
		return "NonIBSBeneficiaryAddedSuccessfully";
	}

	@RequestMapping(value = "/balance-check", method = RequestMethod.GET)
	public String balanceCheck(ModelMap model) {
		model.put("Id", getLoggedInUserName());
		Long ID = Long.parseLong(getLoggedInUserName());
		List<Account> accountBalance = this.accountService.fetchAllaccounts(ID);
		// System.out.println(accountBalance);
		model.put("accountBalance", accountBalance);
		return "balance-check";
	}

	@RequestMapping("/recurringDeposit")
	public String recurringDeposit(ModelMap model) {
		model.put("Id", getLoggedInUserName());
		Long ID = Long.parseLong(getLoggedInUserName());
		List<RdOutputDto> RdOutputDto = this.accountService.fetchAllRd(ID);
		model.put("RdOutputDto", RdOutputDto);
		List<Account> accountBalance = this.accountService.fetchAllaccounts(ID);
		model.put("accountBalance", accountBalance);
		RdInputDto rdInputDto = new RdInputDto();
		model.addAttribute("rdInputDto", rdInputDto);
		return "recurringDeposit";
	}

	@RequestMapping("/rd-confirm")
	public String Rd(ModelMap model, RdInputDto rdInputDto) {
		model.put("Id", getLoggedInUserName());
		Long accountNumber = rdInputDto.getAccountNumber();
		Long ID = Long.parseLong(getLoggedInUserName());
		RdOutputDto rdOutputDto = this.accountService.createRd(rdInputDto, accountNumber, ID);
		model.put("rdOutputDto", rdOutputDto);
		return "rd-confirm";
	}

	@RequestMapping("/fixedDeposit")
	public String fixedDeposit(ModelMap model) {
		model.put("Id", getLoggedInUserName());
		Long ID = Long.parseLong(getLoggedInUserName());
		List<FdOutputDto> FdOutputDto = this.accountService.fetchAllFd(ID);
		model.put("FdOutputDto", FdOutputDto);
		List<Account> accountBalance = this.accountService.fetchAllaccounts(ID);
		model.put("accountBalance", accountBalance);
		FdInputDto fdInputDto = new FdInputDto();
		model.addAttribute("fdInputDto", fdInputDto);
		return "fixedDeposit";
	}

	@RequestMapping("/fd-confirm")
	public String Fd(ModelMap model, FdInputDto fdInputDto) {
		model.put("Id", getLoggedInUserName());
		Long ID = Long.parseLong(getLoggedInUserName());
		Long accountNumber = fdInputDto.getAccountNumber();
		FdOutputDto fdOutputDto = this.accountService.createFd(fdInputDto, accountNumber, ID);
		model.put("fdOutputDto", fdOutputDto);
		return "fd-confirm";
	}

	@RequestMapping(value = "/mini-statement", method = RequestMethod.GET)
	public String miniStatement(ModelMap model) {
		model.put("custId", getLoggedInUserName());
		Long custId = Long.parseLong(getLoggedInUserName());
		List<AccountStatement> miniStatements = this.accountService.fetchAlltransactions(custId);
		// List <miniStatement> sortedmini=
		// miniStatements.sort(Comparator.comparing(miniStatement::getDate));
		// List <miniStatement> sortedmini= Collections.sort(miniStatements);
		// miniStatements.sort(Comparator.comparing(User::getCreatedOn).reversed());
		// Collections.reverse(users);
		// System.out.println(miniStatements);
		// Collections.sort(miniStatements, Collections.reverseOrder());
		model.put("miniStatement", miniStatements);
		return "mini-statement";
	}

	@RequestMapping("/trans-form")
	public String transferFunds(Model model) {
		model.addAttribute("Id", getLoggedInUserName());
		Long ID = Long.parseLong(getLoggedInUserName());
		AccountStatementDto AccountStatementDto = new AccountStatementDto();
		model.addAttribute("AccountStatementDto", AccountStatementDto);
		List<Account> accountBalance = this.accountService.fetchAllaccounts(ID);
		model.addAttribute("accountBalance", accountBalance);
		List<AddBeneficiaryOutputDto> ibsBeneficiaries = this.accountService.getAllibsBeneficiaries(ID);
		model.addAttribute("ibsBeneficiaries", ibsBeneficiaries);
		return "trans-form";
	}

	@RequestMapping("/TransferFunds_Success")
	public String TranferFunds_Success(
			@Valid @ModelAttribute("AccountStatementDto") AccountStatementDto AccountStatementDto, BindingResult result,
			Model model) {
		Long ID = Long.parseLong(getLoggedInUserName());
		if (result.hasErrors()) {
			model.addAttribute("Id", getLoggedInUserName());
			List<Account> accountBalance = this.accountService.fetchAllaccounts(ID);
			model.addAttribute("accountBalance", accountBalance);
			List<AddBeneficiaryOutputDto> ibsBeneficiaries = this.accountService.getAllibsBeneficiaries(ID);
			model.addAttribute("ibsBeneficiaries", ibsBeneficiaries);
			return "trans-form";
		}
		AccountStatementDto AccountStatementOutputDto = this.accountService.Transferfunds(AccountStatementDto, ID);
		model.addAttribute("AccountStatementOutputDto", AccountStatementOutputDto);
		return "TransferFunds_Success";
	}

	@RequestMapping("/requestPeriodicStatement")
	public String requestPeriodicStatement(Model model) {
		Long ID = Long.parseLong(getLoggedInUserName());
		AccountStatementDto AccountStatementDto = new AccountStatementDto();
		model.addAttribute("AccountStatementDto", AccountStatementDto);
		List<Account> account = this.accountService.fetchAllaccounts(ID);
		model.addAttribute("account", account);
		return "periodicStatement";
	}

	@RequestMapping("/displayPeriodicStatement")
	public String displayPeriodicStatement(@ModelAttribute AccountStatementDto AccountStatementDto, ModelMap model) {

		Long accountNumber = AccountStatementDto.getAccountNumber();
		String startDate = AccountStatementDto.getStartDate();
		String endDate = AccountStatementDto.getEndDate();
		List<AccountStatementDto> statements = this.accountService.requestAccountStatement(accountNumber, startDate,
				endDate);
		model.addAttribute("statements", statements);
		return "displayPeriodicStatement";
	}

	@RequestMapping("/mobileRecharge")
	public String mobileRecharge(Model model) {
		UtilityDto UtilityDto = new UtilityDto();
		model.addAttribute("UtilityDto", UtilityDto);
		model.addAttribute("Id", getLoggedInUserName());
		Long ID = Long.parseLong(getLoggedInUserName());
		AccountStatementDto AccountStatementDto = new AccountStatementDto();
		model.addAttribute("AccountStatementDto", AccountStatementDto);
		List<Account> accountBalance = this.accountService.fetchAllaccounts(ID);
		model.addAttribute("accountBalance", accountBalance);
		return "MobileRecharge";
	}

	@RequestMapping("/mobileRecharge_success")
	public String mobileRecharge_success(@Valid @ModelAttribute("UtilityDto") UtilityDto UtilityDto,
			BindingResult result, Model model) {
		Long ID = Long.parseLong(getLoggedInUserName());
		if (result.hasErrors()) {
			AccountStatementDto AccountStatementDto = new AccountStatementDto();
			model.addAttribute("AccountStatementDto", AccountStatementDto);
			List<Account> accountBalance = this.accountService.fetchAllaccounts(ID);
			model.addAttribute("accountBalance", accountBalance);
			return "MobileRecharge";
		}
		UtilityDto UtilityOutputDto = this.accountService.mobileRecharge(UtilityDto, ID);
		model.addAttribute("UtilityOutputDto", UtilityOutputDto);
		return "mobileRecharge_success";
	}

	@RequestMapping("/electricity")
	public String electricity(Model model) {
		UtilityDto UtilityDto = new UtilityDto();
		model.addAttribute("UtilityDto", UtilityDto);
		model.addAttribute("Id", getLoggedInUserName());
		Long ID = Long.parseLong(getLoggedInUserName());
		AccountStatementDto AccountStatementDto = new AccountStatementDto();
		model.addAttribute("AccountStatementDto", AccountStatementDto);
		List<Account> accountBalance = this.accountService.fetchAllaccounts(ID);
		model.addAttribute("accountBalance", accountBalance);
		return "Electricity";
	}

	@RequestMapping("/electricity_success")
	public String electricity_success(@ModelAttribute("UtilityDto") UtilityDto UtilityDto, Model model) {
		Long ID = Long.parseLong(getLoggedInUserName());
		UtilityDto UtilityOutputDto = this.accountService.electricity(UtilityDto, ID);
		model.addAttribute("UtilityOutputDto", UtilityOutputDto);
		return "electricity_success";
	}

	@RequestMapping("/payutilitybills")
	public String payutilitybills() {
		return "payutilitybills";
	}

	@RequestMapping(value = "/loans", method = RequestMethod.GET)
	public ModelAndView loans() {
		return new ModelAndView("OpenLoan", "command", new LoanDto());
	}

	@RequestMapping(value = "/payemi", method = RequestMethod.GET)
	public ModelAndView emi() {
		return new ModelAndView("PayEMI", "command", new LoanDto());
	}

	@RequestMapping(value = "/generateStatement", method = RequestMethod.GET)
	public ModelAndView generateStatement() {
		return new ModelAndView("GenerateStatement", "command", new LoanDto());
	}

	@RequestMapping(value = "/precolosure", method = RequestMethod.GET)
	public ModelAndView preClosureRequest() {
		return new ModelAndView("PreClosureRequest", "command", new LoanDto());
	}

	private String getLoggedInUserName() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}
		return principal.toString();
	}

	@RequestMapping("/BeneficiaryModifiedSuccessfully")
	public String modifyBeneficiaries(@ModelAttribute AddBeneficiaryInputDto addBeneficiaryInputDto, Model model) {
		Long customerId = Long.parseLong(getLoggedInUserName());
		/*
		 * if (result.hasErrors()) { return "ViewOrDeleteListOfBeneficiaries"; }
		 */
		AddBeneficiaryOutputDto modifyBeneficiaryOutputDto = this.accountService
				.modifyBeneficiary(addBeneficiaryInputDto, customerId);
		model.addAttribute("modifyBeneficiaryOutputDto", modifyBeneficiaryOutputDto);
		return "BeneficiaryModifiedSuccessfully";
	}

	@RequestMapping("/ViewOrDeleteListOfBeneficiaries")
	public String viewOrDeleteListOfBeneficiaries(Model model) {
		Long customerId = Long.parseLong(getLoggedInUserName());
		AddBeneficiaryInputDto addBeneficiaryInputDto = new AddBeneficiaryInputDto();
		model.addAttribute("AddBeneficiaryInputDto", addBeneficiaryInputDto);
		List<AddBeneficiaryOutputDto> ibsBeneficiaries = this.accountService.getAllibsBeneficiaries(customerId);
		model.addAttribute("ibsBeneficiaries", ibsBeneficiaries);
		return "ViewOrDeleteListOfBeneficiaries";
	}

	@RequestMapping("/BeneficiaryDeletedSuccessfully")
	public String BeneficiaryDeletedSuccessfully(
			@ModelAttribute("addBeneficiaryInputDto") AddBeneficiaryInputDto addBeneficiaryInputDto, Model model) {

		// if (result.hasErrors()) { return "ViewOrDeleteListOfBeneficiaries"; }
		Long customerId = Long.parseLong(getLoggedInUserName());
		AddBeneficiaryOutputDto addBeneficiaryOutputDto = this.accountService.deleteBeneficiary(addBeneficiaryInputDto,
				customerId);
		model.addAttribute("addBeneficiaryOutputDto", addBeneficiaryOutputDto);
		return "BeneficiaryDeletedSuccessfully";
	}

	@Autowired
	EducationLoanRepository loanRepository;

	@RequestMapping("/AddEducationLoan")
	public String addEducationLoan(@Valid @ModelAttribute LoanDto loanDto, BindingResult errors, Model model) {
		String result = "OpenLoan";

		LoanValidator validator = new LoanValidator();
		validator.validate(loanDto, errors);

		if (errors.hasErrors()) {
			result = "OpenLoan";
		} else {
			loanRepository.save(loanDto);
		}

		model.addAttribute("command", loanDto);

		return result;
	}

	@Autowired
	HomeLoanRepository homeloanRepository;

	@RequestMapping("/AddHomeLoan")
	public String addHomeLoan(@Valid @ModelAttribute HomeLoanDto HomeloanDto, BindingResult errors, Model model) {
		String result = "OpenLoan";

		HomeLoanValidator validator = new HomeLoanValidator();
		validator.validate(HomeloanDto, errors);

		if (errors.hasErrors()) {
			result = "OpenLoan";
		} else {
			homeloanRepository.save(HomeloanDto);
		}

		model.addAttribute("command", HomeloanDto);

		return result;
	}

	@Autowired
	PersonalLoanRepository PersonalloanRepository;

	@RequestMapping("/addPersonalLoan")
	public String addPersonalLoan(@Valid @ModelAttribute PersonalLoanDto PersonalLoanDto, BindingResult errors,
			Model model) {
		String result = "OpenLoan";

		PersonalLoanValidator validator = new PersonalLoanValidator();
		validator.validate(PersonalLoanDto, errors);

		if (errors.hasErrors()) {
			result = "OpenLoan";
		} else {
			PersonalloanRepository.save(PersonalLoanDto);
		}

		model.addAttribute("command", PersonalLoanDto);

		return result;
	}

	@Autowired
	VehicleLoanRepository vehicleLoanRepository;

	@RequestMapping("/AddVehicleLoan")
	public String addVehicleLoan(@Valid @ModelAttribute VehicleLoanDto VehicleloanDto, BindingResult errors,
			Model model) {
		String result = "OpenLoan";

		VehicleLoanValidator validator = new VehicleLoanValidator();
		validator.validate(VehicleloanDto, errors);

		if (errors.hasErrors()) {
			result = "OpenLoan";
		} else {
			vehicleLoanRepository.save(VehicleloanDto);
		}

		model.addAttribute("command", VehicleloanDto);

		return result;
	}

	@ExceptionHandler(InvalidTransactionPasswordException.class)
	public ModelAndView InvalidTransactionPasswordException(InvalidTransactionPasswordException ex) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("error");
		modelAndView.addObject("message", ex.getMessage());
		return modelAndView;
	}
	@ExceptionHandler(InsufficientFundsException.class)
	public ModelAndView InsufficientFundsException(InsufficientFundsException ex) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("error");
		modelAndView.addObject("message", ex.getMessage());
		return modelAndView;
	}
	@ExceptionHandler(SameCardPinException.class)
	public ModelAndView SameCardPinException(SameCardPinException ex) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("error");
		modelAndView.addObject("message", ex.getMessage());
		return modelAndView;
	}
	@ExceptionHandler(IncorrectCVVException.class)
	public ModelAndView IncorrectCVVException(IncorrectCVVException ex) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("error");
		modelAndView.addObject("message", ex.getMessage());
		return modelAndView;
	}

}
