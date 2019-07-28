package com.test.ssm.dao;

import java.util.List;

import com.test.ssm.domain.po.User;

public interface UserDao {
	User findById(Integer id);
	List<User> findAll();
	int insert(User user);
	int update(User user);
	int delete(Integer id);
	int delete(User user);
}
