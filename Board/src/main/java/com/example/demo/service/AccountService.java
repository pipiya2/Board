package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.mapper.AccountMapper;
import com.example.demo.vo.UserVo;

@Service
public class AccountService {
	
	@Autowired
	AccountMapper am;
	
	@Autowired
	SecurityService ss;
	
	// 회원가입
	public Map<String,Object> insertAccount(Map<String, Object> responseData,UserVo uv) throws Exception{
		boolean isSuccess = false;
		String errorMessage = "";
		// TODO 
		try {
			// 이메일 중복체크
			int emailCheck = am.emailCheck(uv.getUserEmail());
			
			if(emailCheck != 0) {
				errorMessage = "email이 중복됩니다.";
			}else {
				String salt = ss.getSalt();
				String newPw = ss.getEncryptionPw(uv.getPassword(), salt);
				uv.setPassword(newPw);
				uv.setSalt(salt);
				isSuccess = am.insertAccount(uv) == 1 ? true : false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			errorMessage = "SYSTEM ERROR";
		}
		
		
		responseData.put("ERRORMESSAGE", errorMessage);
		responseData.put("ISSUCCESS", isSuccess);
		return responseData;
	}

	// 로그인
	public Map<String, Object> signIn(Map<String, Object> responseData, UserVo uv,HttpServletRequest request) {
		boolean isSuccess = true;
		String errorMessage = "";
		String preUrl = "";
		try {
			String salt = am.getUserSalt(uv);
			String password = ss.getEncryptionPw(uv.getPassword(), salt);
			uv.setPassword(password);
			int signInCheck = am.signInCheck(uv);
			if(signInCheck != 1) {
				errorMessage = "이메일 혹은 암호를 잘못입력하셨습니다.\n 이메일 혹은 암호를 다시 입력해주세요";
				isSuccess = false;
			}else {
				preUrl = "/";
				uv = new UserVo(
						uv.getUserName(),
						"",
						uv.getUserEmail(),
						"",
						"",
						""
				);
				request.getSession().setAttribute("log", uv);
			}
		} catch (Exception e) {
			e.printStackTrace();
			errorMessage = "SYSTEM ERROR";
		}
		responseData.put("ISSUCCESS", isSuccess);
		responseData.put("ERRORMESSAGE", errorMessage);
		responseData.put("PREURL", preUrl);
		return responseData;
	}
}
