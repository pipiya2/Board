package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.BoardMapper;
import com.example.demo.vo.BoardVo;
import com.example.demo.vo.UserVo;

@Service
public class BoardService {
	@Autowired
	BoardMapper bm;
	
	@Autowired
	AccountService accountService;
	
	/** column명 , column과 비교할 데이터*/
	public ArrayList<BoardVo> getBoardList(String column,String data) throws Exception{
		return bm.getBoardList(column,data);
	}
	
	// 게시글 등록
	public Map<String, Object> registerPost(HttpServletRequest request, BoardVo boardVo) throws Exception{
		Map<String,Object>responseData = new HashMap<>();
		Object sessionData = accountService.getLoggedUserInfo(request);
		
		boolean isSuccess = true;
		String returnMessage = "";
		String returnUrl = "";
		
		if(sessionData == null) {
			isSuccess = false;
			returnMessage = "로그인후 이용해주세요.";
			returnUrl = "/sign-in";
		}else {
			UserVo userInfo = (UserVo)sessionData; // 유저정보
			String moimNo = setBoardNo(); // 게시판 번호
			boardVo.setUserEmail(userInfo.getUserEmail()); //게시글에 유저정보넣기
			boardVo.setBoardNo(moimNo); // 게시글에 게시판번호 넣기
			returnUrl = "/moim/post/" + moimNo; // 리턴해줄 url
			
			bm.registerPost(boardVo); // 게시글 등록
			returnMessage = "정상 등록 되었습니다";
		}
		
		responseData.put("ISSUCCESS", isSuccess);
		responseData.put("RETURNMESSAGE", returnMessage);
		responseData.put("RETURNURL", returnUrl);
		return responseData;
	}
	
	// 게시글번호
	public String setBoardNo() {
		Random ran = new Random();
		int no = ran.nextInt(99999999) + 1;
		return no+"";
	}
}