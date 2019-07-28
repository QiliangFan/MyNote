package com.sun.chong;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sun.beans.Movie;

public class Getdata {
	private static int i = 1;
	private static List<Movie> all = new ArrayList<>();
  public static List<Movie> getdata(String url,HttpClient client) throws Exception {
	  String UserAgent ="Mozilla/5.0 (Windows NT 6.2; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.87 Safari/537.36";
	  HttpGet get = new HttpGet(url);
	  get.setHeader("UserAgent", UserAgent);
	  HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1, HttpStatus.SC_OK, "ok");
	  response = client.execute(get); 
	  int status =  response.getStatusLine().getStatusCode();
	  if(status==200){
		  String html = EntityUtils.toString(response.getEntity(),"utf-8");
		  Document doc = Jsoup.parse(html);
		  Elements elements =doc.select("div[class=honghe]");
		  for(Element element:elements){
			  String location =String.valueOf(i++);
			  String name  =element.select("p[class=bb]").text();
			  String score =element.select("div[class=honghe-2]").select("span").select("i").text();
			  Movie movie = new Movie();
			  movie.setLocation(location);
			  movie.setName(name);
			  movie.setScore(score);
			  all.add(movie);
		  }
		  String page = doc.select("div[class=page-1 clear]").select("a").eq(1).attr("href");
		  String nexturl ="http://www.imdb.cn";
		  if(!"µÚÒ»Ò³".equals(doc.select("div[class=page-1 clear]").select("a").eq(1).text())){
			  nexturl=nexturl+page;
			  System.out.println(nexturl);
			  getdata(nexturl, client);
		  }
		  EntityUtils.consume(response.getEntity());
	  }else{
		  EntityUtils.consume(response.getEntity());
	  }
	  return  all;
}
}
