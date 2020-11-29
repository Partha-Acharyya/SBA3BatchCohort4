package com.wf.bootapp.ibs.controller;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wf.bootapp.ibs.dto.CreditCardInputDto;
import com.wf.bootapp.ibs.dto.CreditCardOutputDto;
import com.wf.bootapp.ibs.entity.account;

import com.wf.bootapp.ibs.service.accountService;
import com.wf.bootapp.ibs.dto.LoanDto;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private accountService service;
	
	@RequestMapping("/home")
	public String home() {
		return "Account";
	}
	
//	@RequestMapping("/CCApply")
//	public String CreditCard(Model model) {
//		CreditCardInputDto CreditCardInputDto = new CreditCardInputDto();
//		model.addAttribute("CreditCardInputDto", CreditCardInputDto);		
//		
//		return "CCApply";
//	}
//	@RequestMapping("/CCApplysuccess")
//	public String CreditCard(Model model, CreditCardInputDto CreditCardInputDto) {
//		CreditCardInputDto CreditCardInputDto1 = new CreditCardInputDto();
//		model.addAttribute("CreditCardInputDto", CreditCardInputDto1);		
//		CreditCardOutputDto CreditCardOutputDto = this.service.saveCreditCardDetails(CreditCardInputDto1)
//		ResponseEntity<EmployeeOutputDto> response =
//				new ResponseEntity<EmployeeOutputDto>(employeeOutputDto, HttpStatus.OK);
//		return "CCApplysuccess";
//	}
	@RequestMapping(value="/balance-check", method=RequestMethod.GET)
	public String balanceCheck(ModelMap model) {
		model.put("Id", getLoggedInUserName());
		Long ID= Long.parseLong(getLoggedInUserName());
		List <account> accountBalance=this.service.fetchAllaccounts(ID);
		System.out.println(accountBalance);
		model.put("accountBalance", accountBalance);
			return "balance-check";
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
