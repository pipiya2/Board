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
	
	public ArrayList<BoardVo> getBoardList(String column,String data){
		return bm.getBoardList(column,data);
	}
}