package com.example.demo.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.vo.BoardVo;

@RestController
public class BoardAPI {
	
	@PostMapping("/make-class")
	public BoardVo aaa(BoardVo boardVo) {
		return boardVo;
	}

}
