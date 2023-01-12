package com.example.demo.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.vo.BoardVo;

@Mapper
public interface BoardMapper {

	ArrayList<BoardVo> getBoardList(String column, String data);

	public void registerPost(BoardVo boardVo);

}
