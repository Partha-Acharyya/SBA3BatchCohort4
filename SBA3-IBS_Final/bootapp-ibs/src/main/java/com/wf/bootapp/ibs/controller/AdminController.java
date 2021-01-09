package com.wf.bootapp.ibs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wf.bootapp.ibs.dto.AccountStatementDto;
import com.wf.bootapp.ibs.dto.CardDto;
import com.wf.bootapp.ibs.dto.CardOutputDto;
import com.wf.bootapp.ibs.dto.CardStatementDto;
import com.wf.bootapp.ibs.dto.CreditCardEligibilityOutputDto;
import com.wf.bootapp.ibs.dto.NewUserOutput;
import com.wf.bootapp.ibs.entity.Account;
import com.wf.bootapp.ibs.service.AccountService;
import com.wf.bootapp.ibs.service.CreditCardService;
import com.wf.bootapp.ibs.service.DebitCardService;
import com.wf.bootapp.ibs.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	CreditCardService creditCardService;
	@Autowired
	DebitCardService DebitCardService;
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	UserService userservice;
	
	@RequestMapping("/home")
	private String home() {
		return "account";
	}
	@RequestMapping("/LoanApproval")
	private String LoanApproval() {
		return "LoanApproval";
	}
	@RequestMapping("/PreClosureApproval")
	private String PreClosureApproval() {
		return "PreClosureApproval";
	}
	
	@RequestMapping("/ApproveDeclineCard")
	private String approveDeclineCard(ModelMap model) {
		List<CreditCardEligibilityOutputDto> ccEligibilities= this.creditCardService.getAllCcEligibilities();
		model.put("ccEligibilities", ccEligibilities);
		return "ApproveDeclineCard";
	}
	
	@RequestMapping("/ApproveCardRequest/{id}/{customerId}")
	private String ApproveCardRequest(@PathVariable Long id,@PathVariable Long customerId,Model model) {		
		CreditCardEligibilityOutputDto creditCardEligibilityOutputDto= this.creditCardService.ApproveCardRequest(id,customerId);
		model.addAttribute("creditCardEligibilityOutputDto", creditCardEligibilityOutputDto);
		List<CreditCardEligibilityOutputDto> ccEligibilities= this.creditCardService.getAllCcEligibilities();
		model.addAttribute("ccEligibilities", ccEligibilities);
		return "ApproveDeclineCard";
	}
	@RequestMapping("/DeclineCardRequest/{id}")
	private String DeclineCardRequest(@PathVariable Long id,Model model) {
		CreditCardEligibilityOutputDto creditCardEligibilityOutputDto= this.creditCardService.DeclineCardRequest(id);
		model.addAttribute("creditCardEligibilityOutputDto", creditCardEligibilityOutputDto);
		List<CreditCardEligibilityOutputDto> ccEligibilities= this.creditCardService.getAllCcEligibilities();
		model.addAttribute("ccEligibilities", ccEligibilities);
		return "ApproveDeclineCard";
	}
	@RequestMapping("/ActivateDeactivateCard")
	private String activateDeactivateCard(ModelMap model) {
		List<CardDto> CreditCardList= this.creditCardService.AllCreditCardList();
		List<CardDto> DebitCardList= this.DebitCardService.AllDebitCardList();
		model.put("CreditCardList", CreditCardList);
		model.put("DebitCardList", DebitCardList);
		return "ActivateDeactivateCard";
	}

	@RequestMapping("/ActivateCreditCard/{cardNumber}/{customerId}")
	private String ActivateCreditCard(@PathVariable Long cardNumber,@PathVariable Long customerId,Model model) {		
		CardOutputDto CardOutputDto= this.creditCardService.ActivateCreditCard(cardNumber,customerId);
		model.addAttribute("CardOutputDto", CardOutputDto);
		List<CardDto> CreditCardList= this.creditCardService.AllCreditCardList();
		List<CardDto> DebitCardList= this.DebitCardService.AllDebitCardList();
		model.addAttribute("CreditCardList", CreditCardList);
		model.addAttribute("DebitCardList", DebitCardList);
		return "ActivateDeactivateCard";
	}
	@RequestMapping("/ActivateDebitCard/{cardNumber}/{customerId}")
	private String ActivateDebitCard(@PathVariable Long cardNumber,@PathVariable Long customerId,Model model) {		
		CardOutputDto CardOutputDto= this.DebitCardService.ActivateDebitCard(cardNumber,customerId);
		model.addAttribute("CardOutputDto", CardOutputDto);
		List<CardDto> CreditCardList= this.creditCardService.AllCreditCardList();
		List<CardDto> DebitCardList= this.DebitCardService.AllDebitCardList();
		model.addAttribute("CreditCardList", CreditCardList);
		model.addAttribute("DebitCardList", DebitCardList);
		return "ActivateDeactivateCard";
	}
	@RequestMapping("/DeactivateCreditCard/{cardNumber}/{customerId}")
	private String DeactivateCreditCard(@PathVariable Long cardNumber,@PathVariable Long customerId,Model model) {
		CardOutputDto CardOutputDto= this.creditCardService.DeactivateCreditCard(cardNumber,customerId);
		model.addAttribute("CardOutputDto", CardOutputDto);
		List<CardDto> CreditCardList= this.creditCardService.AllCreditCardList();
		List<CardDto> DebitCardList= this.DebitCardService.AllDebitCardList();
		model.addAttribute("CreditCardList", CreditCardList);
		model.addAttribute("DebitCardList", DebitCardList);
		return "ActivateDeactivateCard";
	}
	@RequestMapping("/DeactivateDebitCard/{cardNumber}/{customerId}")
	private String DeactivateDebitCard(@PathVariable Long cardNumber,@PathVariable Long customerId,Model model) {
		CardOutputDto CardOutputDto= this.DebitCardService.DeactivateDebitCard(cardNumber,customerId);
		model.addAttribute("CardOutputDto", CardOutputDto);
		List<CardDto> CreditCardList= this.creditCardService.AllCreditCardList();
		List<CardDto> DebitCardList= this.DebitCardService.AllDebitCardList();
		model.addAttribute("CreditCardList", CreditCardList);
		model.addAttribute("DebitCardList", DebitCardList);
		return "ActivateDeactivateCard";
	}
	@RequestMapping("/requestPeriodicStatement")
	public String requestPeriodicStatement(Model model) {
		AccountStatementDto AccountStatementDto = new AccountStatementDto();
		model.addAttribute("AccountStatementDto", AccountStatementDto);
		List<Account> account = this.accountService.fetchAllaccounts();
		model.addAttribute("account", account);
		return "adminPeriodicStatement";
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
	@RequestMapping("/AdminRequestDCStatement")
	public String requestDcStatement(Model model) {
		CardStatementDto CardStatementDto = new CardStatementDto();
		model.addAttribute("CardStatementDto", CardStatementDto);
		List<CardDto> CardDto1 = this.DebitCardService.DebitCardListAll();
		model.addAttribute("CardDto1", CardDto1);
		return "AdminRequestDCStatement";
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
	@RequestMapping("/AdminRequestCCStatement")
	public String requestCcStatement(Model model) {
		CardStatementDto CardStatementDto = new CardStatementDto();
		model.addAttribute("CardStatementDto", CardStatementDto);
		List<CardDto> CardDto1 = this.creditCardService.CreditCardListAll();
		model.addAttribute("CardDto1", CardDto1);
		return "AdminRequestCCStatement";
	}

	@RequestMapping("/displayCcStatement")
	public String displayCcStatement(@ModelAttribute CardStatementDto CreditCardStatementDto, ModelMap model) {

		Long creditCardNumber = CreditCardStatementDto.getCardNumber();
		String startDate = CreditCardStatementDto.getStartDate();
		String endDate = CreditCardStatementDto.getEndDate();
		List<CardStatementDto> statements = this.creditCardService.requestCardStatement(creditCardNumber, startDate,
				endDate);
		model.addAttribute("statements", statements);
		return "displayCcStatement";
	}
	@RequestMapping("/ApproveDeclineNewuser")
	private String approvedeclineNewuser(ModelMap model) {
		List<NewUserOutput> newuser= this.userservice.fetchAllCustomers();
		model.put("newuser", newuser);
		return "ApproveDeclineUser";
	}
	@RequestMapping("/ApproveUser/{id}")
	private String ApproveUser(@PathVariable Long id,Model model) {		
		NewUserOutput Newuseroutputdto= this.userservice.updateCustomer(id);
		model.addAttribute("Newuseroutputdto", Newuseroutputdto);
		List<NewUserOutput> newuser= this.userservice.fetchAllCustomers();
		model.addAttribute("newuser", newuser);
		return "ApproveDeclineUser";
	}
	@RequestMapping("/DeclineUser/{id}")
	private String Declineuser(@PathVariable Long id,Model model) {
		NewUserOutput Newuseroutputdto= this.userservice.deleteSingleCustomer(id);
		model.addAttribute("Newuseroutput", Newuseroutputdto);
		List<NewUserOutput> newuser= this.userservice.fetchAllCustomers();
		model.addAttribute("newuser", newuser);
		return "ApproveDeclineUser";
	}
}
