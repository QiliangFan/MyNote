package com.test.hadoop.echarts.entity;

import java.util.List;

public class MyData {
	List<String> categories;
	List<Integer> data;
	public List<String> getCategories() {
		return categories;
	}
	public void setCategories(List<String> categories) {
		this.categories = categories;
	}
	public List<Integer> getData() {
		return data;
	}
	public void setData(List<Integer> data) {
		this.data = data;
	}
	public MyData(List<String> categories, List<Integer> data) {
		super();
		this.categories = categories;
		this.data = data;
	}
	public MyData() {
		super();
	}

}
