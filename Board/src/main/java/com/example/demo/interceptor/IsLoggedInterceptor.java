package com.example.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class IsLoggedInterceptor implements HandlerInterceptor{
	

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String prevUrl = request.getHeader("referer") != null ? request.getHeader("referer") : ""; // 이전 페이지명
		String requestUrl = request.getRequestURL().toString(); // 요청 페이지명
		
		boolean isLogged = request.getSession().getAttribute("log") == null ? false : true;
		
		// 로그인이 되어있으면 해당페이지로 접속
		if(isLogged) {
			return true;
		}
		
		// 로그인이 안되어있으면서 이전 페이지명이 없다면.. 로그인도 안하고 주소창으로 그냥 마구잡이로 들어온거임. 얜 홈으로
		if(prevUrl == null || prevUrl.equals("")) {
			response.sendRedirect("/");
			return false;
		}
		
		// 여기서 부터는 로그인이 안되어있고 클릭으로 들어온 정상 케이스
		// 세션에 이전 페이지명을 기억시켜주고 로그인 창으로 보내주자. 
		request.getSession().setAttribute("prevUrl", requestUrl);
		response.sendRedirect("/sign-in");
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}
}
