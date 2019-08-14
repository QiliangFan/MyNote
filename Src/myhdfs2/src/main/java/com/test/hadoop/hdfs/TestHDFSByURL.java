package com.test.hadoop.hdfs;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;

//hdfs /input/core-site.xml 下载到本地
public class TestHDFSByURL {
	// 0 - 开启|注册 HDFS 协议，让 Java URL 可以识别 hdfs 的地址
	static {	// 静态代码块只是在当前类首次被访问的时候，执行且只执行一次
		URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
	}
	
	
	// 1 - 指明hdfs文件的url
	private static String hdfsURL = "hdfs://master:9000/input/core-site.xml";
	
	// 2 - 下载上述文件到本地
	private  static void copyToLocal(String hdfsURL) throws Exception {
		// 生成URL对象
		URL url = new URL(hdfsURL);
		URLConnection connection = url.openConnection();
		InputStream is = connection.getInputStream();
		//。。。。
	}
	
	public static void main(String[] args) throws Exception {
		
		copyToLocal(hdfsURL);	// 只能获取单向的输入流，
		
	}

}
