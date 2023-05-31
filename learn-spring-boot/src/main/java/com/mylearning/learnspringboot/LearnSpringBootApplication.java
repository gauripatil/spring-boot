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
 IMPORTANT GOALS OF SPRING BOOT
 *
 Help you build PRODUCTION READY apps QUICKLY
 		1. Build QUICKLY
 			1.1 Spring Initialzr
 			1.2 Spring Boot Starter Project
 			1.3 Spring Boot Auto Configuration
 			1.4 Spring Boot DevTools
 		2. Be PRODUCTION READY
 			2.1 Logging
 			2.2 Different Configuration for Different Environments
 				2.2.1 Profiles, ConfigurationProperties
 			2.3 Monitoring (Spring Boot Actuator)
 *
 *
 	Exploring Spring Boot Starter Projects
 	1. I need a lot of frameworks to build web application features:
 		1.1 Build REST API - I need Spring, Spring MVC, TOMCAT, JSON Conversion
 		1.2 Write Unit tests - I need Spring Test, Mockito, JUnit
 	2. How can I group them and make it easy to build web applications?
 		2.1 Starters - Convenient dependency descriptors for diff features.
 	3. Spring Boot provides variety of starter projects:
 		3.1 Web Application & REST API - Spring Boot Starter Web (Spring-webmvc, spring-web,
 			spring-boot-starter-tomcat, spring-boot-starter-json)
 		3.2 Unit Tests - Spring Boot Starter Test
 		3.3 Talk to database using JPA - Spring Boot Starter Data JPA
 		3.4 Talk to database using JDBC - Spring Boot Starter JDBC
 		3.5 Secure your web application or REST API - Spring Boot Starter Security
 *
 *
 	Exploring Spring Boot Auto Configuration
 	1. I need a lot of Configuration to Build a Spring app
 		ex- Component Scan, Dispatcher Servlet, Data Sources, JSON Conversion etc.
 	2. How can I simplify this?
 		1. Auto Configuration: Automated configuration for your app
 			1. Decided based on
 				1. which frameworks are in classpath
 				2. What is existing configuration(Annotations)
	Example - Spring Boot Starter Web
 		1. Dispatcher servlet(DispatcherServeletAutoConfiguration)
 		2. Embedded Servlet Container - Tomcat is default (EmbeddedWebServerFactoryCustomizerAutoConfiguration)
 		3. Default Error Pages - (Error MVC Autoconfiguration)
 		4. Bean <-> JSON (JacksonHttpMessageConvertersConfiguration)

 	Build faster with Spring Boot Devtools
 	1. Increase developer productivity
 	2. Why do you restart the server manually for every code change?
 	3. Remember: for pom.xml dependency changes, you will need to restart the server.

 	Get Production Ready with - Managing App. Configuration using Profiles
 	1. Application have different environments - Dev, QA, Stage, Prod etc
 	2. Different environment needs different configuration -
 		1. Different databases
 		2. Different Web Services
 	3. How can you provide different configuration for different environment:
 		1. Profiles: Environment specific configuration
 	4. Log levels:
 		1. trace
 		2. debug
 		3. info
 		4. warning
 		5. error
 		6. off

 	Get Production Ready with - ConfigurationProperties
 	1. Create Service with @ConfigurationProperties
 	2. To test create simple controller and map to url
 	3. Put all the configurations in application properties for - dev, prod, default etc
 	4. Hit endpoint and see the response

 	Simplify Deployment with Spring Boot Embedded Servers
 	OLD WAY
 	1. How do you deploy your application?
 	 	1. Install Java
 		2. Install Web/Application Server
 			Tomcat/WebSphere/WebLogic etc.
 		3. Deploy the application WAR (Web ARchive)
 			This is OLD WAR approach. Complex setup!
 	NEW WAY
 	2. Embedded Server - Simpler alternative
 		1. Install Java
 		2. Run JAR file
 		NOTE: Make JAR Not WAR
 		3. Embedded Server examples:
 			1. Spring-boot-starter-tomcat
 			2. Spring-boot-starter-jetty

 *
 	]
 */