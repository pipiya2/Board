package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {
	@GetMapping("/")	
	public String home() {
		return "index";
	}
	
	@GetMapping("/test")
	public String test() {
		return "test";
	}
}