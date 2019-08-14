package com.test.myspringboot.entity;

public class MyData2 {
	private String category;
	private int num;
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public MyData2() {
		super();
	}
	public MyData2(String category, int num) {
		super();
		this.category = category;
		this.num = num;
	}
}
