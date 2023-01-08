package com.example.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class LoggerInterceptor implements HandlerInterceptor{
	

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(request.getSession().getAttribute("log") == null) {
			response.sendRedirect("/");
		}
		// TODO Auto-generated method stub
//		String headerUrl = request.getHeader("referer");
//		//System.out.println(this.url);
//		String requestUrl = request.getRequestURL().toString();
//		boolean isLogged = request.getSession().getAttribute("log") == null ? false : true;
//		switch (requestUrl) {
//			case "http://localhost:8080/account-info": 
//				if(!isLogged) {
//					response.sendRedirect("/");
//					return false;
//				}
//				break;
//			case "http://localhost:8080/sign-in" :
//				if(isLogged) {
//					response.sendRedirect("/");
//					return false;
//				}
//				
//				String defaultPreUrl = "/";
//				if(headerUrl != null && !headerUrl.contains("account")) {
//					defaultPreUrl = headerUrl;
//				}
//				request.getSession().setAttribute("preUrl", defaultPreUrl);
//				break;
//			case "http://localhost:8080/account" :
//				if(isLogged) {
//					response.sendRedirect("/");
//					return false;
//				}
//				break;
//		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}
}
