package com.test.hadoop.echarts.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "users")
public class User implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Date birthday;
	private int age;
	private double salary;
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
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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
	public User(Integer id, String name, Date birthday, int age, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.age = age;
		this.salary = salary;
	}
	public User(String name, Date birthday, int age, double salary) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.age = age;
		this.salary = salary;
	}
	public User() {
		super();
	}
	

}
