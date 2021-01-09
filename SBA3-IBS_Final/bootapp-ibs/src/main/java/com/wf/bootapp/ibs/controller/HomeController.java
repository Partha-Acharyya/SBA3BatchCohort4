package com.wf.bootapp.ibs.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wf.bootapp.ibs.dto.CreditCardEligibilityInputDto;
import com.wf.bootapp.ibs.dto.CreditCardEligibilityOutputDto;
import com.wf.bootapp.ibs.dto.NewUser;
import com.wf.bootapp.ibs.dto.NewUserOutput;
import com.wf.bootapp.ibs.service.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService Userservice;
	@RequestMapping("/")
	public String home(Model model) {
	
		return "account";
	}
	
	// to respond to root URL
	@RequestMapping("/access-denied")
	public String accessDenied() {
		
		return  "error-page";
	}
	 @RequestMapping(value = "/error")
	    public String error() {
	        return "Error";
	    }
	// to respond to root URL
	@RequestMapping("/login-form")
	public String customLogin() {
			
				return  "login-form";
	}

	@RequestMapping("/newregistration")
	public String newregistration(Model model) {
		NewUser Newuser = new NewUser();
		model.addAttribute("Newuser", Newuser);
		return "Register";
	}

	@RequestMapping("/UnregisteredCust")
	public String UnregisteredCust(@Valid @ModelAttribute ("Newuser")NewUser Newuser,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "Register";
		}
		NewUserOutput newuseroutput= this.Userservice.saveCustomer(Newuser);
		model.addAttribute("newuseroutputdto", newuseroutput);
		return "UnregisteredCust";
	}

}
