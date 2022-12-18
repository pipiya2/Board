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
	
	public Map<String,Object> insertAccount(Map<String, Object> responseData,UserVo uv) throws Exception{
		boolean isSuccess = false;
		String errorMessage = "";
		// TODO 
		try {
			// 이메일 중복체크
			int emailCheck = am.emailCheck(uv.getUserEmail());
			if(emailCheck == 0) {
				int response = am.insertAccount(uv);
				if(response != 0) {
					isSuccess = true;
				}else {
					errorMessage = "SYSTEM ERROR";
				}
			}else {
				errorMessage = "email이 중복됩니다.";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		responseData.put("ERRORMESSAGE", errorMessage);
		responseData.put("ISSUCCESS", isSuccess);
		return responseData;
	}
}
