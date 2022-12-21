package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.service.AccountService;
import com.example.demo.vo.UserVo;

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
	
	@GetMapping("/password/{email}/{token}")
	private String findPwRoute(HttpServletRequest request, Model model,@PathVariable String email,@PathVariable String token) {
		UserVo uv = as.isExistToken(token);
		String mainContent = "account/findPw";
		String mainCss = "account/findPw";
		String mainJs = "account/findPw";
		
		if(uv == null || (!as.expirationCheck(uv))) {
			//잘못된 접근
			mainContent = "account/findPw-error";
			mainCss = "account/findPw-error";
			mainJs = "account/findPw-error";
		}
		model.addAttribute("mainContents",mainContent);
		model.addAttribute("mainCss",mainCss);
		model.addAttribute("mainJs",mainJs);
		return "index";
	}
}