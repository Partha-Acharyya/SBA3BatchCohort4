package com.wf.spring.ibs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.wf.spring.ibs.model.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@RequestMapping("/login")
	public String login() {
		return "BankRepLogin";
	}
	@RequestMapping("/home")
	public String home() {
		return "BankRepresentativeHome";
	}
	@RequestMapping("/ApproveDeclineCardRequest")
	public String ApproveDeclineCard() {
		return "ApproveDeclineCardRequest";
	}
	@RequestMapping("/ActivateDeactivateCard")
	public String ActivateDeactivateCard() {
		return "ActivateDeactivateCard";
	}

}
