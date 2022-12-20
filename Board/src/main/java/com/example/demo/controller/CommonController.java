package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.AccountService;

@Controller
public class CommonController {
	
	@Autowired
	AccountService as;
	
	// 메인 페이지
	@GetMapping("/")
	public String home(Model model,HttpServletRequest request) {
		model.addAttribute("mainContents","mainHome");
		model.addAttribute("mainCss","mainHome");
		model.addAttribute("mainJs","mainHome");
		return "index";
	}
	
	// 회원가입 페이지
	@GetMapping("/account")
	public String accountPage(Model model) {
		model.addAttribute("mainContents","account/account");
		model.addAttribute("mainCss","account/account");
		model.addAttribute("mainJs","account/account");
		return "index";
	}
	
	// 로그인 페이지
	@GetMapping("/sign-in")
	public String signIn(Model model) {
		model.addAttribute("mainContents","account/sign-in");
		model.addAttribute("mainCss","account/sign-in");
		model.addAttribute("mainJs","account/sign-in");
		return "index";
	}
	
	// 회원정보 페이지
	@GetMapping("/account-info")
	public String accountInfo(Model model) {
		model.addAttribute("mainContents","account/account-info");
		model.addAttribute("mainCss","account/account-info");
		model.addAttribute("mainJs","account/account-info");
		return "index";
	}
}