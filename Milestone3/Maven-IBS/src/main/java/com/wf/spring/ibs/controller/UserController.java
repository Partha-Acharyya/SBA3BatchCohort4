package com.wf.spring.ibs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.wf.spring.ibs.model.*;


@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping("/home") 
	public String home() {
		return "Account";
	}
	@RequestMapping("/CreditCard") 
	public String CreditCard(Model model) {
		CreditCardEligibility CreditCardEligibility = new CreditCardEligibility();
		
		model.addAttribute("CreditCardEligibility", CreditCardEligibility);
		return "CreditCard";
	}
	@RequestMapping("/DebitCard") 
	public String DebitCard() {
		return "DebitCard";
	}

}
