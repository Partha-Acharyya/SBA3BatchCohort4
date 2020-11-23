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
	@RequestMapping("/adminlogin") 
	public String bankRepLogin(Model modeladminlogin) {
		Adminuser bankrep= new Adminuser();
		modeladminlogin.addAttribute("AdminUser", bankrep);
		return "BankRepLogin";
	}
	
	@RequestMapping("/newRegister") 
	public String newRegister(Model modelnewregister) {
		NewUser newuser= new NewUser();
		modelnewregister.addAttribute("newuser", newuser);
		return "Register";
	}
	
	@RequestMapping("/registrationcheck") 
	public String registrationcheck(@ModelAttribute NewUser newuser) {
		//Business logic
		return "UnregisteredCust";
	}
	
	@RequestMapping("/adminlogin") 
	public String bankRepLogincheck(@ModelAttribute Adminuser bankrep) {
		//business logic
		return "BankRepresentativeHome";
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
