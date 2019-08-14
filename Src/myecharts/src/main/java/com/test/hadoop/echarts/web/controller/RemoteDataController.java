package com.test.hadoop.echarts.web.controller;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.validator.internal.util.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.std.StaticListSerializerBase;
import com.test.hadoop.echarts.dao.UserDao;
import com.test.hadoop.echarts.entity.MyData;
import com.test.hadoop.echarts.entity.MyData2;
import com.test.hadoop.echarts.entity.User;
import com.test.hadoop.echarts.utils.DatFileUtil;

@RestController
public class RemoteDataController {
	@Autowired
	private UserDao userDao;
	@GetMapping("/testuserdao")
	public User getUser() {
//		User user = new User("zhangsan", new Date(System.currentTimeMillis())
//				, 20, 1.1);
//		userDao.save(user);
		
//		User user2 = userDao.getOne(1);
//		User user2 = userDao.findByName("zhangsan");
		User user2 = userDao.findByAgeGreaterThan(15);
		
		return user2;
	}
	
	
	
	
	// 获取数据
	private MyData fillDatas(String pathname, String filename) throws NumberFormatException, IOException {
		FileReader frFileReader = DatFileUtil.getFileReader(pathname, filename);
		MyData myData = new MyData();
		List<String> categories = new ArrayList<String>();
		List<Integer> data = new ArrayList<Integer>();
		
		if (frFileReader != null) {
			LineNumberReader lineReader = new LineNumberReader(frFileReader);
			String line = "";
			while( (line = lineReader.readLine()) != null) {
				String[] strs = line.split("\t");
				categories.add(strs[0]);
				data.add(Integer.parseInt(strs[1]));
			}
		}
		
		myData.setCategories(categories);
		myData.setData(data);
		frFileReader.close();
		return myData;
	}
	
	@GetMapping("/remotedata")
	public MyData getMyData() throws NumberFormatException, IOException {
//		List<String> categories = new ArrayList<String>();
//		categories.add("aa");
//		categories.add("bb");
//		categories.add("cc");
//		categories.add("dd");
//		categories.add("ee");
//		categories.add("ff");
//		categories.add("gg");
//		List<Integer> data = new ArrayList<Integer>();
//		data.add(1500);
//		data.add(1280);
//		data.add(1386);
//		data.add(1190);
//		data.add(1107);
//		data.add(1207);
//		data.add(1452);
//		MyData myData = new MyData(categories, data);
		MyData myData = this.fillDatas("data", "mydata.dat");
		return myData;

	}

	@GetMapping("/remotedata2")
	public List<MyData2> getMyData2s(){
		List<MyData2> myData2s = new ArrayList<MyData2>();
		myData2s.add(new MyData2("Java", 1200));
		myData2s.add(new MyData2("Tomcat", 1380));
		myData2s.add(new MyData2("C C#", 1366));
		myData2s.add(new MyData2("Linux", 1320));
		myData2s.add(new MyData2("Hadoop", 1300));
		return myData2s;
	}
}
