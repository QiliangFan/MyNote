package com.test.ssm.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.Timestamp;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.test.ssm.domain.po.User;

public class TestUserDao {
	public static void main(String[] args) throws IOException {
		String resource = "mybatis-config.xml";
		Reader reader = Resources.getResourceAsReader(
				TestUserDao.class.getClassLoader(), resource
				);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		UserDao userDao = session.getMapper(UserDao.class);
		
//		Timestamp regtime = new Timestamp(System.currentTimeMillis());
//		User user = new User("王五", 13, 1.3, regtime);
//		int result = userDao.insert(user);
//		User user = userDao.findById(3);
//		user.setAge(100);
//		int result = userDao.update(user);
		User user = new User();
		user.setId(3);
		int result = userDao.delete(user);
		System.out.println(result);
		session.commit();	// 完成事务提交
		session.close();
		
		
	}

}
