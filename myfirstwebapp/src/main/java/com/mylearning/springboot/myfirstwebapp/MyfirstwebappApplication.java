package com.mylearning.springboot.myfirstwebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyfirstwebappApplication {
	public static void main(String[] args) {
		System.out.println("Hi");
		SpringApplication.run(MyfirstwebappApplication.class, args);
	}
}
