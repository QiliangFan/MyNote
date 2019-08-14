package com.test.hadoop.echarts.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.hadoop.echarts.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{
	User findByName(String name);
	User findByAgeGreaterThan(int age);
}
