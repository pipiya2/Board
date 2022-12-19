package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.AccountService;
import com.example.demo.service.MailService;
import com.example.demo.service.SecurityService;
import com.example.demo.vo.UserVo;

@RestController
public class AccountAPI {
	
	@Autowired
	AccountService as;
	
	@Autowired
	SecurityService ss;
	
	@Autowired
	MailService ms;
	
	// 회원가입 api
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
	
	// 로그인 api
	@PostMapping("/sign-in")
	public Map<String, Object>signIn(HttpServletRequest request,UserVo uv){
		Map<String, Object> responseData = new HashMap<String, Object>();
		try {
			responseData = as.signIn(responseData,uv,request);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return responseData;
	}
}
