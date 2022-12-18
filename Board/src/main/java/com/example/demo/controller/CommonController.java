package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.AccountService;

@Controller
public class CommonController {
	
	@Autowired
	AccountService as;
	
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("mainContents","mainHome");
		model.addAttribute("mainCss","mainHome");
		model.addAttribute("mainJs","mainHome");
		model.addAttribute("logInfo",null);
		return "index";
	}
	
	@GetMapping("/account")
	public String accountPage(Model model) {
		model.addAttribute("mainContents","account/account");
		model.addAttribute("mainCss","account/account");
		model.addAttribute("mainJs","account/account");
		return "index";
	}
	
	@GetMapping("/sign-in")
	public String signIn(Model model) {
		model.addAttribute("mainContents","account/sign-in");
		model.addAttribute("mainCss","account/sign-in");
		model.addAttribute("mainJs","account/sign-in");
		return "index";
	}
}