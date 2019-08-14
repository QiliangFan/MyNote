package com.test.springboot.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.springboot.biz.UserService;
import com.test.springboot.dao.UserDao;
import com.test.springboot.domain.po.User;

@Service
public class UserServiceimpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	
	@Override
	public User findById(Integer id) {
		return userDao.findById(id);
	}

}
