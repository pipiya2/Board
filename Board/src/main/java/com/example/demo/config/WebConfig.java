package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.interceptor.IsLoggedInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer{
//	@Value("${RESOURCEPATH}")
//	private String RESOURCEPATH;
//	
//	private final String UPLOADPATH = "/upload/**";
//	
//	// UPLOADPATH로 경로를 입력하면 RESOURCEPATH 경로에 있는 파일을 찾음.
//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		// TODO Auto-generated method stub
//		registry.addResourceHandler(UPLOADPATH)
//		.addResourceLocations(RESOURCEPATH);
//	}
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// excludePathPatterns ==> 특정 url은 이 인터셉터를 호출하지 않게 한다.
		// addPathPatterns ==> 특정 url만 이 인터셉터를 호출하게 한다.
		
		registry.addInterceptor(new IsLoggedInterceptor())
		.addPathPatterns("/account-info") 	// 회원정보
		.addPathPatterns("/make-class"); 	// 모임만들기
		// 얘네들은 들어올때 로그인이 되어있는지 확인해야함.
	}
}