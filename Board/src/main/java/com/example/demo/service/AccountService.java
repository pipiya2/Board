package com.example.demo.service;

import java.util.Map;
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
}
