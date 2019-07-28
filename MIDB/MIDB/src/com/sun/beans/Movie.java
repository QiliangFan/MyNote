package com.sun.beans;

public class Movie {
  private String location;
  private String name;
  private String score;
  //用于输入
@Override
public String toString() {
	return "Movie [location=" + location + ", name=" + name + ", score=" + score + "]";
}
//GET SET 方法    作用：可以给属性进行赋值或取得属性的值。
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getScore() {
	return score;
}
public void setScore(String score) {
	this.score = score;
}
}
