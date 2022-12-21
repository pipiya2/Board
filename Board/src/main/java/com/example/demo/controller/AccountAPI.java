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
	
	// 비밀번호 찾기 api
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
	
	@PostMapping("/change")
	public Map<String, Object> changePassword(UserVo uv){
		Map<String, Object>responseData = new HashMap<String, Object>();
		String pw = uv.getPassword();
		String token = uv.getFindPwToken();
		uv = as.isExistToken(token);
		
		if(uv == null) {
			responseData.put("ISSUCCESS", false);
			responseData.put("EXCEPTIONMESSAGE","잘못된 요청입니다.");
			responseData.put("TYPE","bad url");
			return responseData;
		}
		
		// expiration recheck
		if(!as.expirationCheck(uv)) {
			responseData.put("ISSUCCESS", false);
			responseData.put("EXCEPTIONMESSAGE","비밀번호 찾기 요청 시간이 만료되었습니다.");
			responseData.put("TYPE","expiration");
			return responseData;
		}
		
		try {
			as.changePassword(uv);
			responseData.put("ISSUCCESS", true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			responseData.put("ISSUCCESS", false);
			responseData.put("EXCEPTIONMESSAGE", "변경중 오류");
			responseData.put("TYPE", "error");
		}
		return responseData;
	}
}
