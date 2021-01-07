package com.wf.bootapp.ibs.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wf.bootapp.ibs.dto.AddBeneficiaryInputDto;
import com.wf.bootapp.ibs.dto.AddBeneficiaryOutputDto;
import com.wf.bootapp.ibs.dto.CardDto;
import com.wf.bootapp.ibs.dto.CardOutputDto;
import com.wf.bootapp.ibs.dto.CreditCardEligibilityInputDto;
import com.wf.bootapp.ibs.dto.CreditCardEligibilityOutputDto;
import com.wf.bootapp.ibs.entity.Account;

import com.wf.bootapp.ibs.service.AccountService;
import com.wf.bootapp.ibs.service.CreditCardService;
import com.wf.bootapp.ibs.service.DebitCardService;
import com.wf.bootapp.ibs.service.UserService;
import com.wf.bootapp.ibs.dto.LoanDto;
import com.wf.bootapp.ibs.dto.Newuser;
import com.wf.bootapp.ibs.dto.Newuseroutput;
import com.wf.bootapp.ibs.dto.RdInputDto;
import com.wf.bootapp.ibs.dto.RdOutputDto;
import com.wf.bootapp.ibs.entity.*;

import org.springframework.web.bind.annotation.RequestMethod;
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
	
	
	
	@RequestMapping("/home")
	public String userhome() {
	
		return "account";
	}

	@RequestMapping("/CreditCard")
	public String CreditCard() {
		return "CreditCard";
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
				.applyCreditCard(creditCardEligibilityInputDto,id);
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
	public String blockUnblockCreditCardsuccess(@Valid @ModelAttribute ("CardDto")CardDto CardDto,BindingResult result,
			 Model model) {
		Long id = Long.parseLong(getLoggedInUserName());
		System.out.println(CardDto.getCardNumber());
		if (result.hasErrors()) {
			List<CardDto> CardDto1 = this.CreditCardService.CreditCardList(Long.parseLong(getLoggedInUserName()));
			model.addAttribute("CardDto1", CardDto1);
			return "BlockCreditCard";
		}
		CardOutputDto CardOutputDto=this.CreditCardService.BlockUnblockCard(CardDto,id);
		model.addAttribute("CardOutputDto",CardOutputDto);
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
	public String ResetPinSuccess(@Valid @ModelAttribute ("CardDto")CardDto CardDto,BindingResult result,
			 Model model) {
		Long id = Long.parseLong(getLoggedInUserName());
		System.out.println(CardDto.getCardNumber());
		if (result.hasErrors()) {
			List<CardDto> CardDto1 = this.CreditCardService.CreditCardList(Long.parseLong(getLoggedInUserName()));
			model.addAttribute("CardDto1", CardDto1);
			return "ResetCCPin";
		}
		CardOutputDto CardOutputDto=this.CreditCardService.resetCcPin(CardDto,id);
		model.addAttribute("CardOutputDto",CardOutputDto);
		return "ResetPinSuccess";	
	}

	@RequestMapping("/requestCcStatement")
	public String requestCcStatement() {
		return "RequestCCStatement";	
	}
	@RequestMapping("/CCStatementMismatch")
	public String CCStatementMismatch(Model model) {
		CardDto CardDto = new CardDto();
		model.addAttribute("CardDto", CardDto);
		List<CardDto> CardDto1 = this.CreditCardService.CreditCardList(Long.parseLong(getLoggedInUserName()));
		model.addAttribute("CardDto1", CardDto1);
		return "CCStatementmismatch";	
	}
	@RequestMapping("/ccStatementMismatch_Success")
	public String ccStatementMismatch_Success(@Valid @ModelAttribute ("CardDto")CardDto CardDto,BindingResult result,
			 Model model) {
		Long id = Long.parseLong(getLoggedInUserName());
		
		if (result.hasErrors()) {
			List<CardDto> CardDto1 = this.CreditCardService.CreditCardList(Long.parseLong(getLoggedInUserName()));
			model.addAttribute("CardDto1", CardDto1);
			return "ccStatementMismatch";
		}
		//String mismatchFile=f.getAbsolutePath();
		CardOutputDto CardOutputDto=this.CreditCardService.ccStatementMismatch(CardDto,id);
		if(!(CardOutputDto.getMismatchFile()).isEmpty())
		model.addAttribute("CardOutputDto",CardOutputDto);
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
	public String CreditCardUpgrade_success(@Valid @ModelAttribute ("CardDto")CardDto CardDto,BindingResult result,
			 Model model) {
		Long id = Long.parseLong(getLoggedInUserName());
		System.out.println(CardDto.getCardNumber());
		if (result.hasErrors()) {
			return "CreditCardUpgrade";
		}
		CardOutputDto CardOutputDto=this.CreditCardService.creditCardUpgrade(CardDto,id);
		model.addAttribute("CardOutputDto",CardOutputDto);
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
	public String blockUnblockDebitCardsuccess(@ModelAttribute ("CardDto")CardDto CardDto,
			 Model model) {
		Long id = Long.parseLong(getLoggedInUserName());
		System.out.println(CardDto.getCardNumber());
		CardOutputDto CardOutputDto=this.DebitCardService.BlockUnblockCard(CardDto,id);
		model.addAttribute("CardOutputDto",CardOutputDto);
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
	public String resetDcPin(@Valid @ModelAttribute ("CardDto")CardDto CardDto,BindingResult result,
			 Model model) {
		Long id = Long.parseLong(getLoggedInUserName());
		System.out.println(CardDto.getCardNumber());
//		if (result.hasErrors()) 
//		{		
//			List<CardDto> CardDto1 = this.DebitCardService.DebitCardList(Long.parseLong(getLoggedInUserName()));
//			model.addAttribute("CardDto1", CardDto1);
//			return "ResetDCPin";
//		}
		CardOutputDto CardOutputDto=this.DebitCardService.resetDcPin(CardDto,id);
		model.addAttribute("CardOutputDto",CardOutputDto);
		return "ResetDcPinSuccess";	
	}

	@RequestMapping("/requestDcStatement")
	public String requestDcStatement(Model model) {
		CardDto CardDto = new CardDto();
		model.addAttribute("CardDto", CardDto);
		List<CardDto> CardDto1 = this.DebitCardService.DebitCardList(Long.parseLong(getLoggedInUserName()));
		model.addAttribute("CardDto1", CardDto1);
		return "RequestDCStatement";	
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
	public String dcStatementMismatch_Success(@Valid @ModelAttribute CardDto CardDto,BindingResult result,
			 Model model) {
		Long id = Long.parseLong(getLoggedInUserName());
		
		if (result.hasErrors()) {
			List<CardDto> CardDto1 = this.DebitCardService.DebitCardList(Long.parseLong(getLoggedInUserName()));
			model.addAttribute("CardDto1", CardDto1);
			return "DCStatementmismatch";
		}
		CardOutputDto CardOutputDto=this.DebitCardService.dcStatementMismatch(CardDto,id);
		if(!(CardOutputDto.getMismatchFile()).isEmpty())
		model.addAttribute("CardOutputDto",CardOutputDto);
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
	public String DebitCardUpgrade_success( @ModelAttribute CardDto CardDto,
			 Model model) {
		Long id = Long.parseLong(getLoggedInUserName());
		System.out.println(CardDto.getCardNumber());
//		if (result.hasErrors()) {
//			return "ResetCCPin";
//		}
		CardOutputDto CardOutputDto=this.DebitCardService.debitCardUpgrade(CardDto,id);
		model.addAttribute("CardOutputDto",CardOutputDto);
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
	public String viewOrDeleteListOfBeneficiaries(@ModelAttribute AddBeneficiaryInputDto addBeneficiaryInputDto,
			Model model) {
		Long customerId = Long.parseLong(getLoggedInUserName());
		/*
		 * if (result.hasErrors()) { return "ViewOrDeleteListOfBeneficiaries"; }
		 */
		AddBeneficiaryOutputDto addBeneficiaryOutputDto = this.accountService.addBeneficiary(addBeneficiaryInputDto,
				customerId);
		model.addAttribute("addBeneficiaryOutputDto", addBeneficiaryOutputDto);
		return "BeneficiaryDeletedSuccessfully";
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

	@RequestMapping(value = "/recurringDeposit", method = RequestMethod.GET)
	public String recurringDeposit(ModelMap model) {
		model.put("Id", getLoggedInUserName());
		Long ID = Long.parseLong(getLoggedInUserName());
		List<Account> accountBalance = this.accountService.fetchAllaccounts(ID);
		model.put("accountBalance", accountBalance);
		RdInputDto rdInputDto = new RdInputDto();
		model.addAttribute("rdInputDto", rdInputDto);
		return "recurringDeposit";
	}

	@RequestMapping(value = "/rd-confirm", method = RequestMethod.GET)
	public String Rd(ModelMap model, RdInputDto rdInputDto) {
		model.put("Id", getLoggedInUserName());
		RdOutputDto rdOutputDto = this.accountService.createRd(rdInputDto);
		model.put("rdOutputDto", rdOutputDto);
		return "rd-confirm";
	}

	@RequestMapping(value = "/mini-statement", method = RequestMethod.GET)
	public String miniStatement(ModelMap model) {
		model.put("custId", getLoggedInUserName());
		Long custId = Long.parseLong(getLoggedInUserName());
		List<MiniStatement> miniStatements = this.accountService.fetchAlltransactions(custId);
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

	@RequestMapping(value = "/trans-form", method = RequestMethod.GET)
	public String transferFunds(ModelMap model, Object amount) {
		model.put("Id", getLoggedInUserName());
		Long ID = Long.parseLong(getLoggedInUserName());
		List<Account> accountBalance = this.accountService.fetchAllaccounts(ID);
		model.put("accountBalance", accountBalance);
		// System.out.println(accountBalance);
		// model.put("transferType", transferFunds(accountBalance, accountBalance));
		return "trans-form";

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


}
