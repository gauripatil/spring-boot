package com.mylearning.learnspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearnSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnSpringBootApplication.class, args);
	}

}


/**
 * IMPORTANT GOALS OF SPRING BOOT
 *
 * Help you build PRODUCTION READY apps QUICKLY
 * 		1. Build QUICKLY
 * 			1.1 Spring Initialzr
 * 			1.2 Spring Boot Starter Project
 * 			1.3 Spring Boot Auto Configuration
 * 			1.4 Spring Boot DevTools
 * 		2. Be PRODUCTION READY
 * 			2.1 Logging
 * 			2.2 Different Configuration for Different Environments
 * 				2.2.1 Profiles, ConfigurationProperties
 * 			2.3 Monitoring (Spring Boot Actuator)
 */