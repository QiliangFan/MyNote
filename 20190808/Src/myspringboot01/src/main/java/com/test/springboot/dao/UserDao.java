package com.test.springboot.dao;

import org.springframework.stereotype.Repository;

import com.test.springboot.domain.po.User;
@Repository
public interface UserDao {
	User findById(Integer id);

}
