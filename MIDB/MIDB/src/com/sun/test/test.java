package com.sun.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import com.sun.beans.Movie;
import com.sun.chong.Getdata;

public class test {
  public static void main(String[] args)  {
    String url ="http://www.imdb.cn/imdb250/1";	
    HttpClientBuilder builder = HttpClientBuilder.create();
    HttpClient client =builder.build();
    String uri ="jdbc:mysql://localhost:3306/demo";
    String user ="root";
    String password ="root";
    Connection conn = null;
    try {
    	List<Movie>  all =  Getdata.getdata(url, client);
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(uri, user, password);
	    String sql ="insert into movie (location,name,score) values(?,?,?)";
	    for(Movie movie:all){
	    PreparedStatement ps = conn.prepareStatement(sql);
	     ps.setString(1, movie.getLocation());
	     ps.setString(2, movie.getName());
	     ps.setString(3, movie.getScore());
	     int a = ps.executeUpdate();
	     
	    }
    } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
}
