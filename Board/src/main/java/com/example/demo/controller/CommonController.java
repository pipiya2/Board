package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {
	@GetMapping("/")	
	public String home(Model model) {
		model.addAttribute("mainContents","mainHome");
		model.addAttribute("mainCss","mainHome");
		model.addAttribute("mainJs","mainHome");
		return "/index";
	}
	
	@GetMapping("/account")
	public String accountPage(Model model) {
		model.addAttribute("mainContents","account");
		model.addAttribute("mainCss","account_css");
		model.addAttribute("mainJs","account_js");
		return "/index";
	}
}