package com.mylearning.springboot.myfirstwebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyfirstwebappApplication {
	public static void main(String[] args) {

		// http://localhost:8080/h2-console
		SpringApplication.run(MyfirstwebappApplication.class, args);
	}
}
