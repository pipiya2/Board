package com.example.demo.api;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mapper.BoardMapper;
import com.example.demo.service.BoardService;
import com.example.demo.vo.BoardVo;
import com.example.demo.vo.UserVo;

@RestController
public class BoardAPI {

	@Autowired
	BoardService boardService;
	
	// 게시물 등록
	@PostMapping("/make-class")
	public Map<String,Object> registerPost(HttpServletRequest request, BoardVo boardVo) {
		Map<String,Object> responseData = null;
		try {
			responseData = boardService.registerPost(request,boardVo);
		} catch (Exception e) {
			e.printStackTrace();
			responseData.put("ERRORMESSAGE", "SYSTEM ERROR");
			responseData.put("ISSUCCESS", false);
		}
		
		return responseData;
	}

}
