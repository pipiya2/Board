package com.example.demo.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;

public class SecurityService {
	// 비밀번호 암호화 by salt
	public String getEncryptionPw(String password, String salt) throws Exception{
		String result = "";
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		
		md.update((password + salt).getBytes());
		result = String.format("%064x", new BigInteger(1, md.digest()));
		
		return result;
	}
	
	// get new salt
	public String getSalt() throws Exception{
		SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
		byte[] bytes = new byte[16];
		random.nextBytes(bytes);
		String salt = new String(Base64.getEncoder().encode(bytes));
		
		return salt;
	}
}
