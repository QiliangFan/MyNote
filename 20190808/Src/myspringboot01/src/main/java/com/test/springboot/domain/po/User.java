package com.test.springboot.domain.po;

import java.io.Serializable;
import java.sql.Timestamp;

@SuppressWarnings("serial")
public class User implements Serializable{
	private Integer id;
	private String name;
	private int age;
	private double salary;
	private Timestamp regtime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Timestamp getRegtime() {
		return regtime;
	}
	public void setRegtime(Timestamp regtime) {
		this.regtime = regtime;
	}
	public User() {
		super();
	}
	public User(Integer id, String name, int age, double salary, Timestamp regtime) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.regtime = regtime;
	}
	public User(String name, int age, double salary, Timestamp regtime) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.regtime = regtime;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + ", regtime=" + regtime
				+ "]";
	}
	
}
