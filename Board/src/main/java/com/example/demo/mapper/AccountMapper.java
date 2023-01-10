package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.vo.UserVo;

@Mapper
public interface AccountMapper {
	public int insertAccount(UserVo uv);

	public int emailCheck(String userEmail);

	public String getUserSalt(UserVo uv);

	public UserVo signInCheck(UserVo uv);

	public int setFIND_TOKEN(String userEmail, String token);

	public UserVo isExistToken(String token);

	public int changePassword(UserVo uv);
}
