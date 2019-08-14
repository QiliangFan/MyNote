package com.test.hadoop.echarts.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EChartsController {
	
	@GetMapping("/embed")
	public String embed() {
		return "echartsembed";
	}
	
	@GetMapping("/embed2")
	public String embed2() {
		return "echartsembed2";
	}
	
	@RequestMapping("/local")
	public String local() {
		return "echartslocal";
	}
	
	@RequestMapping("/local2")
	public String local2() {
		return "echartslocal2";
	}
	
	@RequestMapping(value = "/remote", method = RequestMethod.GET)
	public String remote() {
		return "echartsremote";
	}
	
	@RequestMapping(value = "/remote2", method = RequestMethod.GET)
	public String remote2() {
		return "echartsremote2";
	}
}
