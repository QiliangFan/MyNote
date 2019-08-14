package com.test.hadoop.echarts.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;

public class DatFileUtil {
	
	public static FileReader getFileReader (String pathname, String filename) {
		String name = pathname + "/" + filename;
		URL url = DatFileUtil.class.getClassLoader().getResource(name);
		//File file = new File(url.getFile());
		File file = new File("d:/mydata.dat");
		FileReader fr = null;
		try {
			fr =new FileReader(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fr;
	}

}
