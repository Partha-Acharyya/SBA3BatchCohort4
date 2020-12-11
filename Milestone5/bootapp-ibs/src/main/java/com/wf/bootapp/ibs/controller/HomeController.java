package com.wf.bootapp.ibs.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



// Shall contain processing logic

// Bean created
// Register with Handler Mapper
@Controller
public class HomeController {

	
	// to respond to root URL
	@RequestMapping("/")
	public String home(Model model) {
	
		return "account";
	}
	
	// to respond to root URL
	@RequestMapping("/access-denied")
	public String accessDenied() {
		
		return  "error-page";
	}
	@RequestMapping("/Register")
	public String Register() {
		return "Register";
	}
	// to respond to root URL
	@RequestMapping("/login-form")
	public String customLogin() {
				return  "login-form";
	}
	

}
