package com.test.hadoop.echarts.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
	
	// 控制方法：接收访问url，实现跳转
	@GetMapping("/xyz")
	public String abc() {
		return "test";
	}

}
