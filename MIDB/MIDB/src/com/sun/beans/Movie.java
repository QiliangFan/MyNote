package com.sun.beans;

public class Movie {
  private String location;
  private String name;
  private String score;
  //��������
@Override
public String toString() {
	return "Movie [location=" + location + ", name=" + name + ", score=" + score + "]";
}
//GET SET ����    ���ã����Ը����Խ��и�ֵ��ȡ�����Ե�ֵ��
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
