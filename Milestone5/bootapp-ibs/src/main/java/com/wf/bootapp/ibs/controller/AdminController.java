package com.wf.bootapp.ibs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wf.bootapp.ibs.dto.CreditCardEligibilityOutputDto;
import com.wf.bootapp.ibs.service.CreditCardService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	CreditCardService creditCardService;
	
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
	
	@RequestMapping("/ApproveCardRequest/{id}")
	private String ApproveCardRequest(@PathVariable Long id,Model model) {		
		CreditCardEligibilityOutputDto creditCardEligibilityOutputDto= this.creditCardService.ApproveCardRequest(id);
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
}
