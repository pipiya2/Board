package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.BoardMapper;
import com.example.demo.vo.BoardVo;

@Service
public class BoardService {
	@Autowired
	BoardMapper bm;
	
	/** column명 , column과 비교할 데이터*/
	public ArrayList<BoardVo> getBoardList(String column,String data) throws Exception{
		return bm.getBoardList(column,data);
	}
}