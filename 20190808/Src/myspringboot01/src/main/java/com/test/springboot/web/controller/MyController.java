package com.test.springboot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
	
	@GetMapping("/test")
	public String index() {
		return "abc";
	}

	
	@GetMapping("/myjsp")
	public String myjsp() {
		return "myjsp";
	}
}
