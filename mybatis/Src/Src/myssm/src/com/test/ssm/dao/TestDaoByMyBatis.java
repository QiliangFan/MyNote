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
		// 0. ��ȡ MyBatis ϵͳ|ȫ�������ļ�����Ϣ
		String resource = "mybatis-config.xml";
		Reader reader = Resources.getResourceAsReader(
				TestDaoByMyBatis.class.getClassLoader(), resource
				);
		// 1. ���� SessionFactory 
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		// 2. ���� session 
		SqlSession session = sessionFactory.openSession();
		// 3. ���� session ʵ�����ݿ��CRUD 
//		User user = (User)session.selectOne("my.mybatis.dao.findById", 2);
//		System.out.println(user);
//		List<User> users = session.selectList("my.mybatis.dao.findAll");
//		for (User user : users)
//			System.out.println(user);
		// 3.2 ���� session ʹ�� �ӿڰ󶨵ķ�ʽʵ�����ݿ����
		UserDao userDao = session.getMapper(UserDao.class);
//		User user  = userDao.findById(1);
//		System.out.println(user);
		List<User> users = userDao.findAll();
		for(User user : users)
			System.out.println(user);
		// 4. �ر��ͷ���Դ
		session.close();
		
	}
}
