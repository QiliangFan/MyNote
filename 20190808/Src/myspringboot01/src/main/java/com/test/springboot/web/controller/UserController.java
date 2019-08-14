package com.test.springboot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.springboot.biz.UserService;
import com.test.springboot.domain.po.User;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/getid")
	@ResponseBody
	public User getId() {
		User user = userService.findById(1);
		return user;
	}

}
