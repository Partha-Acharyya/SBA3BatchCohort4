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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wf.bootapp.ibs.dto.CreditCardEligibilityInputDto;
import com.wf.bootapp.ibs.dto.CreditCardEligibilityOutputDto;
import com.wf.bootapp.ibs.entity.Account;

import com.wf.bootapp.ibs.service.AccountService;
import com.wf.bootapp.ibs.service.CreditCardService;
import com.wf.bootapp.ibs.dto.LoanDto;
import com.wf.bootapp.ibs.dto.RdInputDto;
import com.wf.bootapp.ibs.dto.RdOutputDto;
import com.wf.bootapp.ibs.entity.*;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private AccountService service;
	
	@Autowired
	private CreditCardService CreditCardService;
	
	@RequestMapping("/home")
	public String home() {
		return "Account";
	}
	@RequestMapping("/CreditCard")
	public String CreditCard() {
		return "CreditCard";
	}
	@RequestMapping("/CCApply")
	public String CCApply(Model model) {
		CreditCardEligibilityInputDto creditCardEligibilityInputDto = new CreditCardEligibilityInputDto();
		model.addAttribute("creditCardEligibilityInputDto", creditCardEligibilityInputDto);		
		return "CCApply";
	}

	@RequestMapping("/CCApplysuccess")
	public String CCApplysuccess(@Valid @ModelAttribute CreditCardEligibilityInputDto creditCardEligibilityInputDto,
							  BindingResult result,ModelMap model) {
		if(result.hasErrors()) {
			return "CCApply";
		}
		CreditCardEligibilityOutputDto creditCardEligibilityOutputDto=this.CreditCardService.applyCreditCard(creditCardEligibilityInputDto);
		model.put("creditCardEligibilityOutputDto", creditCardEligibilityOutputDto);
		return "CCEligibility_Success.jsp";
	}

	@RequestMapping(value="/balance-check", method=RequestMethod.GET)
	public String balanceCheck(ModelMap model) {
		model.put("Id", getLoggedInUserName());
		Long ID= Long.parseLong(getLoggedInUserName());
		List <Account> accountBalance=this.service.fetchAllaccounts(ID);
		//System.out.println(accountBalance);
		model.put("accountBalance", accountBalance);
			return "balance-check";
	}
	@RequestMapping(value="/recurringDeposit",method = RequestMethod.GET)
	public String recurringDeposit(ModelMap model) {
		model.put("Id", getLoggedInUserName());
		Long ID = Long.parseLong(getLoggedInUserName());
		List<Account> accountBalance = this.service.fetchAllaccounts(ID);
		model.put("accountBalance", accountBalance);
		RdInputDto rdInputDto = new RdInputDto();
		model.addAttribute("rdInputDto", rdInputDto);
		return "recurringDeposit";
	}
	@RequestMapping(value="/rd-confirm", method=RequestMethod.GET)
	public String Rd(ModelMap model,RdInputDto rdInputDto ) {
		model.put("Id", getLoggedInUserName());
		RdOutputDto rdOutputDto = this.service.createRd(rdInputDto);
		model.put("rdOutputDto", rdOutputDto);
			return "rd-confirm";
	}

	@RequestMapping(value="/mini-statement", method=RequestMethod.GET)
	public String miniStatement(ModelMap model) {
		model.put("custId", getLoggedInUserName());
		Long custId= Long.parseLong(getLoggedInUserName());
		List <MiniStatement> miniStatements=this.service.fetchAlltransactions(custId);
	//	List <miniStatement> sortedmini= miniStatements.sort(Comparator.comparing(miniStatement::getDate));
	//	List <miniStatement> sortedmini= Collections.sort(miniStatements);
	//	miniStatements.sort(Comparator.comparing(User::getCreatedOn).reversed());
	//	Collections.reverse(users);
	//	System.out.println(miniStatements);
		//Collections.sort(miniStatements, Collections.reverseOrder());
		model.put("miniStatement", miniStatements);
			return "mini-statement";
	}
	@RequestMapping(value = "/trans-form", method = RequestMethod.GET)
	public String transferFunds(ModelMap model, Object amount) {
		model.put("Id", getLoggedInUserName());
		Long ID = Long.parseLong(getLoggedInUserName());
		List<Account> accountBalance = this.service.fetchAllaccounts(ID);
		model.put("accountBalance", accountBalance);
		//System.out.println(accountBalance);
		//model.put("transferType", transferFunds(accountBalance, accountBalance));
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
	Object principal= SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	
	if(principal instanceof UserDetails) {
		return ((UserDetails) principal).getUsername();
	}
	return principal.toString();
}

}
