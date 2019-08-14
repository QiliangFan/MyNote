package com.test.hadoop.hdfs;

import java.io.IOException;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class TestHDFSByFSApi {
	static {
		// Windows 设置环境变量：HADOOP_USER_NAME - icss
		// 使用 代码实现
		System.setProperty("HADOOP_USER_NAME", "icss");
	}
	public static void main(String[] args) throws IOException {
		// 在本机安装配置Hadoop运行环境
		if (System.getProperty("os.name").toLowerCase().indexOf("windows") != -1) {
			// 当前程序运行在 windows 系统下
			System.setProperty("hadoop.home.dir", "C:/Dev/hadoop-3.0.0");
		}
		// 1 - 获取hdfsuri 
		String hdfsURI = "hdfs://master:9000/";
		// 2 - 获取Hadoop的配置文件
		Configuration conf = new Configuration();
		URI uri = URI.create(hdfsURI);
		FileSystem fs = FileSystem.get(uri, conf);
		// Path 
		String coreSiteXml = "hdfs://master:9000/input/core-site.xml";
		Path src = new Path(coreSiteXml);
		Path dst = new Path("src/1.xml");
		fs.copyToLocalFile(src, dst);
		
	}
}
