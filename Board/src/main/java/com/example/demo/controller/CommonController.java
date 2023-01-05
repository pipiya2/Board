package com.example.demo.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.service.AccountService;
import com.example.demo.service.BoardService;
import com.example.demo.vo.BoardVo;
import com.example.demo.vo.UserVo;

@Controller
public class CommonController {
	
	@Autowired
	AccountService as; 
	
	@Autowired
	BoardService bs;
	
	// 메인 페이지
	@GetMapping("/")
	public String home() {
		return "redirect:/moim/all";
	}
	
	// 회원가입 페이지
	@GetMapping("/account")
	public String accountPage(Model model) {
		setModelAttribute(model,"account/account", "account/account", "account/account");
		return "index";
	}
	
	// 로그인 페이지
	@GetMapping("/sign-in")
	public String signIn(Model model,HttpServletRequest request) {
		model.addAttribute("headerInfo",request.getHeader("referer"));
		
		setModelAttribute(model,"account/sign-in", "account/sign-in", "account/sign-in");
		return "index";
	}
	
	// 회원정보 페이지
	@GetMapping("/account-info")
	public String accountInfo(Model model) {
		setModelAttribute(model, "account/account-info", "account/account-info", "account/account-info");
		return "index";
	}
	
	// 비밀번호 변경
	@GetMapping("/password/{email}/{token}")
	public String findPwRoute(HttpServletRequest request, Model model,@PathVariable String email,@PathVariable String token) {
		UserVo uv = as.isExistToken(token);
		String mainContent = "account/findPw";
		String mainCss = "account/findPw";
		String mainJs = "account/findPw";
		
		if(uv == null || (!as.expirationCheck(uv))) {
			//잘못된 접근
			mainContent = "account/findPw-error";
			mainCss = "account/findPw-error";
			mainJs = "account/findPw-error";
		}
		setModelAttribute(model, mainContent, mainCss, mainJs);
		return "index";
	}
	
	// 모임
	@GetMapping("/moim/{pageType}")
	public String moim(HttpServletRequest request, Model model,@PathVariable String pageType){
		// 공통 param
		setModelAttribute(model, "moimFrame/commonFrame", "moim/common", "moim/common");
		
		
		String pageName = "";
		switch (pageType) {
			case "all": pageName = "모든모임"; break;
			case "study": pageName = "스터디"; break;
			case "health": pageName = "운동"; break;
			case "meal": pageName = "식사"; break;
			case "alcohol": pageName = "술자리"; break;
			default : pageName = "error";
		}
		
		// 오류
		if(pageName.equals("error")) return "error page";
		
		// 해당하는 페이지명에 따른 게시글을 가져와야함.
		ArrayList<BoardVo> boardList = null;
		try {
			boardList = bs.getBoardList("CATEGORY", pageType);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 넘겨줄 param
		model.addAttribute("pageName",pageName);
		model.addAttribute("boardList",boardList);
		return "index";
	}
	
	// 로그아웃
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().removeAttribute("log");
		return "redirect:/";
	}
	
	
	
	
	/**contentsPath, cssPath , jsPath*/ 
	private void setModelAttribute (Model model,String contentPath,String cssPath,String jsPath) {
		model.addAttribute("mainContents",contentPath);
		model.addAttribute("mainCss",cssPath);
		model.addAttribute("mainJs",jsPath);
	}
}