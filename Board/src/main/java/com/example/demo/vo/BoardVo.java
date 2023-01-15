package com.example.demo.vo;

import lombok.Data;

@Data
public class BoardVo {
	private String boardNo;
	private String category;
	private String userEmail;
	private String subject;
	private String content;
	private String deadlineDate;
	private String viewCnt;
	private String replyCnt;
	private String likeCnt;
	private String disLikeCnt;
	private String createTime;
}