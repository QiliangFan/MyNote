package com.test.myspringboot.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;

public class DatFileUtil {
	public static FileReader getFileReader(String pathname, String filename) {
		String name = pathname + "/" + filename;
		URL url = DatFileUtil.class.getClassLoader().getResource(name);
		File file = new File(url.getFile());
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileReader;
	}

}
