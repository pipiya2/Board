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
}