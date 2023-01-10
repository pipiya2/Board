package com.example.demo.api;

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
	AccountService accountService;
	
	@Autowired
	SecurityService ss;
	
	@Autowired
	MailService ms;
	
	// 회원가입 api
	@PostMapping("/sign-up")
	public Map<String, Object> signUp(UserVo uv,HttpServletRequest request){
		Map<String, Object> responseData = new HashMap<String, Object>();
		
		try {
			responseData = accountService.insertAccount(responseData,uv);
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
		// client로 보내줄 응답데이터 정의
		Map<String, Object> responseData = new HashMap<String, Object>();
		
		try {
			responseData = accountService.signIn(responseData,uv,request);
			// 로그인이 성공됐으면
			if((boolean)responseData.get("ISSUCCESS")) {
				// 보내줄 url을 설정한다.
				responseData = accountService.setPreUrl(request, responseData);
			}
			request.getSession().removeAttribute("preUrl");
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
			responseData = accountService.sendEmail(userEmail,responseData);
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
			responseData = accountService.changePassword(uv,responseData);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			responseData.put("ISSUCCESS", false);
			responseData.put("ERRORMESSAGE", "SYSTEM ERROR 관리자 문의바람");
		}
		return responseData;
	}
}

