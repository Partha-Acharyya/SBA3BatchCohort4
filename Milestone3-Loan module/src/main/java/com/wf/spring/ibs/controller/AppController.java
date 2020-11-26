package com.wf.spring.ibs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.wf.spring.ibs.model.LoanDto;

// Shall contain processing logic

// Bean created
// Register with Handler Mapper
@Controller
public class AppController {

	@RequestMapping("/home")
	public String home() {
		return "index";
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
	
	@RequestMapping(value = "/addloantype", method = RequestMethod.GET)
	public ModelAndView addLoanTypes() {
		return new ModelAndView("AddLoanTypes", "command", new LoanDto());
	}
	
	@RequestMapping(value = "/loanapproval", method = RequestMethod.GET)
	public ModelAndView loanApproval() {
		return new ModelAndView("LoanApproval", "command", new LoanDto());
	}
		
	@RequestMapping(value = "/preClosure", method = RequestMethod.GET)
	public ModelAndView preclosure() {
		return new ModelAndView("PreClosureApproval", "command", new LoanDto());
	}

}
