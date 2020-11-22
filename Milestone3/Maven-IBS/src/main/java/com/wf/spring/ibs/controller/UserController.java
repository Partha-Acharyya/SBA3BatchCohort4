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
	@RequestMapping("/DebitCard")
	public String DebitCard() {
		return "DebitCard";
	}
	@RequestMapping("/CreditCard")
	public String CreditCard() {
		return "CreditCard";
	}
	@RequestMapping("/CCApply")
	public String CreditCard(Model model) {
		CreditCard CreditCard = new CreditCard();

		model.addAttribute("CreditCard", CreditCard);
		return "CCApply";
	}


	@RequestMapping("/BlockDebitCard")
	public String BlockDebitCard(Model model) {
		DebitCard DebitCard = new DebitCard();

		model.addAttribute("DebitCard", DebitCard);
		return "BlockDebitCard";
	}

	@RequestMapping("/ResetDCPin")
	public String ResetDCPin(Model model) {
		DebitCard DebitCard = new DebitCard();
		model.addAttribute("DebitCard", DebitCard);
		return "ResetDCPin";
	}

	@RequestMapping("/RequestDCStatement")
	public String RequestDCStatement(Model model) {
		DebitCard DebitCard = new DebitCard();

		model.addAttribute("DebitCard", DebitCard);
		return "RequestDCStatement";
	}
	@RequestMapping("/DebitCardUpgrade")
	public String DebitCardUpgrade(Model model) {
		DebitCard DebitCard = new DebitCard();

		model.addAttribute("DebitCard", DebitCard);
		return "DebitCardUpgrade";
	}
	@RequestMapping("/DCStatementmismatch")
	public String DCStatementmismatch(Model model) {
		DebitCard DebitCard = new DebitCard();

		model.addAttribute("DebitCard", DebitCard);
		return "DCStatementmismatch";
	}
	@RequestMapping("/BlockCreditCard")
	public String BlockCreditCard(Model model) {
		CreditCard CreditCard = new CreditCard();

		model.addAttribute("CreditCard", CreditCard);
		return "BlockCreditCard";
	}

	@RequestMapping("/ResetCCPin")
	public String ResetCCPin(Model model) {
		CreditCard CreditCard = new CreditCard();
		model.addAttribute("CreditCard", CreditCard);
		return "ResetCCPin";
	}

	@RequestMapping("/RequestCCStatement")
	public String RequestCCStatement(Model model) {
		CreditCard CreditCard = new CreditCard();

		model.addAttribute("CreditCard", CreditCard);
		return "RequestCCStatement";
	}
	@RequestMapping("/CreditCardUpgrade")
	public String CreditCardUpgrade(Model model) {
		CreditCard CreditCard = new CreditCard();

		model.addAttribute("CreditCard", CreditCard);
		return "CreditCardUpgrade";
	}
	@RequestMapping("/CCStatementmismatch")
	public String CCStatementmismatch(Model model) {
		CreditCard CreditCard = new CreditCard();

		model.addAttribute("CreditCard", CreditCard);
		return "CCStatementmismatch";
	}
	@RequestMapping("/AddIBSBeneficiary") 
	public String AddIBSBeneficiary(Model model) {
		Beneficiary Beneficiary = new Beneficiary();
		
		model.addAttribute("Beneficiary",Beneficiary);
		return "AddIBSBeneficiary";
	}
	@RequestMapping("/AddnonIBSBeneficiary") 
	public String AddNonIBSBeneficiary(Model model) {
		Beneficiary Beneficiary = new Beneficiary();
		
		model.addAttribute("Beneficiary",Beneficiary);
		return "AddNonIBSBeneficiary";
	}
	@RequestMapping("/ViewOrDeleteListOfBeneficiaries") 
	public String ViewOrDeleteListOfBeneficiaries() {
		return "ViewOrDeleteListOfBeneficiaries";
	}


}
