package com.example.demo.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	// 비밀번호 찾기 이메일전송 api
	@PostMapping("/password/verify")
	public Map<String, Object> passwordVerify(String userEmail){
		Map<String, Object> responseData = new HashMap<String, Object>();
		
		try {
			responseData = as.sendEmail(userEmail,responseData);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			responseData.put("ISSUCCESS", false);
			responseData.put("ERRORMESSAGE", "SYSTEM ERROR");
		}
		return responseData;
	}
	
	// 비밀번호 변경
	@PostMapping("/change")
	public Map<String, Object> changePassword(UserVo uv){
		Map<String, Object>responseData = new HashMap<String, Object>();
		try {
			responseData = as.changePassword(uv,responseData);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			responseData.put("ISSUCCESS", false);
			responseData.put("ERRORMESSAGE", "SYSTEM ERROR 관리자 문의바람");
		}
		return responseData;
	}
}

