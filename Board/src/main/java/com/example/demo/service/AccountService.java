package com.example.demo.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
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
	
	@Autowired
	MailService ms;
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

	public Map<String,Object> sendEmail(String userEmail,Map<String,Object> responseData) throws Exception {
		String errorMessage = "";
		boolean isSuccess = true;
		
		String token = ss.getSalt();
		
		SimpleDateFormat formatter= new SimpleDateFormat("yyMMddHHmm");
		
		Date date = new Date(System.currentTimeMillis());
		token += "_" + formatter.format(date);
		
		token = token.replaceAll("&", "");
		token = token.replaceAll("\\+", "");
		token = token.replaceAll("=", "");
		token = token.replaceAll("\\/", "");
		
		
		boolean isExistEmail = setFINDPW_TOKEN(userEmail,token) == 1 ? true : false;
		if(!isExistEmail) {
			isSuccess = false;
			errorMessage = "존재하지 않는 이메일 입니다. 이메일을 확인해주세요";
		}else {
			ms.sendEmail_CRTFC_NMBR(userEmail,token);
		}
		
		responseData.put("ISSUCCESS", isSuccess);
		responseData.put("ERRORMESSAGE", errorMessage);
		
		return responseData;
	}

	public int setFINDPW_TOKEN(String userEmail, String token) {
		// TODO Auto-generated method stub
		return am.setFIND_TOKEN(userEmail,token);
	}
	
	public UserVo isExistToken(String token) {
		return am.isExistToken(token);
	}
	
	public boolean expirationCheck(UserVo uv) {
		SimpleDateFormat formatter= new SimpleDateFormat("yyMMddHHmm");
		Date date = new Date(System.currentTimeMillis());
		// 현재시간
		long now = Long.parseLong(formatter.format(date));
		// 토큰을 발급받은 시간
		long exTime = Long.parseLong(uv.getFindPwToken()+"");
		
		if(now - exTime > 10) {
			return false;
		}
		
		return true;
	}

	public void changePassword(UserVo uv) throws Exception{
		uv.setSalt(ss.getSalt());
		uv.setPassword(ss.getEncryptionPw(uv.getPassword(), uv.getSalt()));
		am.changePassword(uv);
	}
}
