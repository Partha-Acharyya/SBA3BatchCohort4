package com.wf.bootapp.ibs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wf.bootapp.ibs.dto.CreditCardEligibilityOutputDto;
import com.wf.bootapp.ibs.dto.Newuseroutput;
import com.wf.bootapp.ibs.service.CreditCardService;
import com.wf.bootapp.ibs.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	CreditCardService creditCardService;
	
	@Autowired
	UserService userservice;
	
	@RequestMapping("/home")
	private String home() {
		return "BankRepresentativeHome";
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
	
	@RequestMapping("/ApproveNewuser")
	private String approveNewuser(ModelMap model) {
		List<Newuseroutput> newuser= this.userservice.fetchAllCustomers();
		model.put("newuser", newuser);
		return "ApproveDeclineUser";
	}
	
	@RequestMapping("/DeclineUser/{id}")
	private String Declineuser(@PathVariable Long id,Model model) {
		Newuseroutput Newuseroutputdto= this.userservice.deleteSingleCustomer(id);
		model.addAttribute("Newuseroutput", Newuseroutputdto);
		List<Newuseroutput> newuser= this.userservice.fetchAllCustomers();
		model.addAttribute("newuser", newuser);
		return "ApproveDeclineCard";
	}
}
