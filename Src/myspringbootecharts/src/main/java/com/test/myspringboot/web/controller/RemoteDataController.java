package com.test.myspringboot.web.controller;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.myspringboot.entity.MyData;
import com.test.myspringboot.entity.MyData2;
import com.test.myspringboot.utils.DatFileUtil;

@RestController
public class RemoteDataController {

	private MyData fillDatas(String pathname, String filename) throws IOException {
		MyData myData = new MyData();
		List<String> categories = new ArrayList<String>();
		List<Integer> data = new ArrayList<Integer>();
		
		FileReader reader = DatFileUtil.getFileReader(pathname, filename);
		if (reader != null) {
			LineNumberReader lineReader = new LineNumberReader(reader);
			String line = "";

			while ((line = lineReader.readLine()) != null) {
				String[] strs = line.split("\t");
				categories.add(strs[0]);
				data.add(Integer.parseInt(strs[1]));
			}
			
		}
		
		myData.setCategories(categories);
		myData.setData(data);
		return myData;
	}
	
	@GetMapping("/remotedata")
	public MyData getMyData() throws IOException {
//		MyData myData = new MyData();
//		List<String> categories = new ArrayList<String>();
//		categories.add("aa");
//		categories.add("bb");
//		categories.add("cc");
//		categories.add("dd");
//		categories.add("ee");
//		categories.add("ff");
//		categories.add("gg");
//		myData.setCategories(categories);
//		List<Integer> data = new ArrayList<Integer>();
//		data.add(1500);
//		data.add(1280);
//		data.add(1386);
//		data.add(1190);
//		data.add(1107);
//		data.add(1207);
//		data.add(1452);
//		myData.setData(data);
		MyData myData = this.fillDatas("data", "mydata.dat");
		return myData;
	}

	@GetMapping("/remotedata2")
	public List<MyData2> getMyData2(){
		List<MyData2> myData2s = new ArrayList<MyData2>();
		myData2s.add(new MyData2("Java", 1200));
		myData2s.add(new MyData2("Tomcat", 1380));
		myData2s.add(new MyData2("C C#", 1366));  
		myData2s.add(new MyData2("Linux", 1320));
		myData2s.add(new MyData2("Hadoop", 1300));
		return myData2s;
	}
}
