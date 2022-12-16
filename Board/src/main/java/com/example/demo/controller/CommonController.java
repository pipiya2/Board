package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {
	@GetMapping("/")	
	public String home(Model model) {
		model.addAttribute("mainContents","defaultContents");
		return "/index";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "/index";
	}
}