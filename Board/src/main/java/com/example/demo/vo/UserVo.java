package com.example.demo.vo;

import lombok.Data;

@Data
public class UserVo {
	private String userName;
	private String userBirth;
	private String userEmail;
	private String password;
	private String salt;
	private String findPwToken;
	
	public UserVo() {};
	
	public UserVo(String name, String birth,String email, String password, String salt, String findToken) {
		this.userName = name;
		this.userBirth = birth;
		this.userEmail = email;
		this.password = password;
		this.salt = salt;
		this.findPwToken = findToken;
	};
}