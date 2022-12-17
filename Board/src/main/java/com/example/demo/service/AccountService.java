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
		System.out.println(uv.getUserEmail());
		System.out.println(uv.getPassword());
		System.out.println(uv.getUserBirth());
		System.out.println(uv.getUserName());
		// TODO 
		try {
			int response = am.insertAccount(uv);
			if(response != 0) {
				isSuccess = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		responseData.put("ERRORMESSAGE", errorMessage);
		responseData.put("ISSUCCESS", isSuccess);
		return responseData;
	}
}
