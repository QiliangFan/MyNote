package com.test.ssm.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.test.ssm.domain.po.User;

public class TestDaoByMyBatis {
	public static void main(String[] args) throws IOException {
		// 0. 获取 MyBatis 系统|全局配置文件的信息
		String resource = "mybatis-config.xml";
		Reader reader = Resources.getResourceAsReader(
				TestDaoByMyBatis.class.getClassLoader(), resource
				);
		// 1. 生成 SessionFactory 
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		// 2. 生成 session 
		SqlSession session = sessionFactory.openSession();
		// 3. 借助 session 实现数据库的CRUD 
//		User user = (User)session.selectOne("my.mybatis.dao.findById", 2);
//		System.out.println(user);
//		List<User> users = session.selectList("my.mybatis.dao.findAll");
//		for (User user : users)
//			System.out.println(user);
		// 3.2 借助 session 使用 接口绑定的方式实现数据库操作
		UserDao userDao = session.getMapper(UserDao.class);
//		User user  = userDao.findById(1);
//		System.out.println(user);
		List<User> users = userDao.findAll();
		for(User user : users)
			System.out.println(user);
		// 4. 关闭释放资源
		session.close();
		
	}
}
