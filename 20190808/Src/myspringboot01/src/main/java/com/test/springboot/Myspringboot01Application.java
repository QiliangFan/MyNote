package com.test.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
@MapperScan("com.test.springboot.dao")
public class Myspringboot01Application {

	public static void main(String[] args) {
		SpringApplication.run(Myspringboot01Application.class, args);
	}

}
