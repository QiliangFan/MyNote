package com.test.springboot.biz;

import com.test.springboot.domain.po.User;

public interface UserService {
	User findById(Integer id);
}
