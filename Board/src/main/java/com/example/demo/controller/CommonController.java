package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.AccountService;
import com.example.demo.vo.UserVo;

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
	
	@ResponseBody
	@PostMapping("/sign-up")
	public Map<String, Object> signUp(UserVo uv,HttpServletRequest request){
		Map<String, Object> responseData = new HashMap<String, Object>();
		
		try {
			responseData = as.insertAccount(responseData,uv);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			responseData.put("ERRORMESSAGE", "SYSTEM ERROR");
			responseData.put("ISSUCCESS", false);
		}
		
		return responseData;
	}
}