# IMPORTANT GOALS OF SPRING BOOT

 ## Help you build PRODUCTION READY apps QUICKLY
 		1. Build QUICKLY
 			1.1 Spring Initialzr
 			1.2 Spring Boot Starter Project
 			1.3 Spring Boot Auto Configuration
 			1.4 Spring Boot DevTools
 		2. Be PRODUCTION READY
 			2.1 Logging
 			2.2 Different Configurations for Different Environments
 				2.2.1 Profiles, ConfigurationProperties
 			2.3 Monitoring (Spring Boot Actuator)
 
 # Exploring Spring Boot Starter Projects
 	1. I need a lot of frameworks to build web application features:
 		1.1 Build REST API - I need Spring, Spring MVC, TOMCAT, JSON Conversion
 		1.2 Write Unit tests - I need Spring Test, Mockito, JUnit
 	2. How can I group them and make it easy to build web applications?
 		2.1 Starters - Convenient dependency descriptors for diff features.
 	3. Spring Boot provides a variety of starter projects:
 		3.1 Web Application & REST API - Spring Boot Starter Web (Spring-webmvc, spring-web,
 			spring-boot-starter-tomcat, spring-boot-starter-json)
 		3.2 Unit Tests - Spring Boot Starter Test
 		3.3 Talk to database using JPA - Spring Boot Starter Data JPA
 		3.4 Talk to database using JDBC - Spring Boot Starter JDBC
 		3.5 Secure your web application or REST API - Spring Boot Starter Security
 
# Exploring Spring Boot Auto Configuration
 	1. I need a lot of Configuration to Build a Spring app
 		ex- Component Scan, Dispatcher Servlet, Data Sources, JSON Conversion etc.
 	2. How can I simplify this?
 		1. Auto Configuration: Automated configuration for your app
 			1. Decided based on
 				1. which frameworks are in classpath
 				2. What is the existing configuration(Annotations)
	3. Example - Spring Boot Starter Web
 		1. Dispatcher servlet(DispatcherServeletAutoConfiguration)
 		2. Embedded Servlet Container - Tomcat is default (EmbeddedWebServerFactoryCustomizerAutoConfiguration)
 		3. Default Error Pages - (Error MVC Autoconfiguration)
 		4. Bean <-> JSON (JacksonHttpMessageConvertersConfiguration)
		
# Build faster with Spring Boot Devtools
 	1. Increase developer productivity
 	2. Why do you restart the server manually for every code change?
 	3. Remember: for pom.xml dependency changes, you will need to restart the server.
	
# Managing App. Configuration using Profiles
 	1. Application have different environments - Dev, QA, Stage, Prod etc
 	2. Different environment needs different configuration -
 		1. Different databases
 		2. Different Web Services
 	3. How can you provide different configurations for different environments:
 		1. Profiles: Environment-specific configuration
 	4. Log levels:
 		1. trace
 		2. debug
 		3. info
 		4. warning
 		5. error
 		6. off
	5. Set active profile using - spring.profiles.active=prod in application.properties	
	
# Get Production Ready with - ConfigurationProperties
 	1. Create Service with @ConfigurationProperties
 	2. To test create simple controller and map to url
 	3. Put all the configurations in application properties for - dev, prod, default etc
 	4. Hit the endpoint and see the response
	
# Simplify Deployment with Spring Boot Embedded Servers
### OLD WAY
 	1. How do you deploy your application?
 	 	1. Install Java
 		2. Install Web/Application Server
 			Tomcat/WebSphere/WebLogic etc.
 		3. Deploy the application WAR (Web ARchive)
 			This is OLD WAR approach. Complex setup!
 ### NEW WAY
 	2. Embedded Server - Simpler alternative
 		1. Install Java
 		2. Run JAR file
 		NOTE: Make JAR Not WAR
 		3. Embedded Server examples:
 			1. Spring-boot-starter-tomcat
 			2. Spring-boot-starter-jetty
			
# Monitor Applications using Spring Boot Actuator
 	1. Monitor and manage your application in your production
 	2. Provides number of endpoints:
 		1. beans - Complete list of Spring beans in your application
 		2. health - application health information
 		3. metrics - Application metrics
 		4. mappings - details around Request mappings
		
# Spring VS Spring MVC VS Spring Boot
 	1. Spring Framework: Dependency Injection
 		1. @Component, @Autowired, Component Scan etc..
 		2. Just dependency injection is not sufficient (You need other frameworks to build apps)
 			1. Spring modules & Spring projects: Extend Spring Eco System.
 				- Provide good ecosystem with other frameworks(Hibernate/JPA, JUnit/Mockito)
 	2. Spring MVC (Spring Module) - Simplify building web apps & REST API
 		1. Building web application with Struts was very complex!
 		2. @Controller, @RestController, @RequestMapping("/course")
 	3. Spring Boot (Spring Project) - Build PRODUCTION READY apps QUICKLY
 		1. Starter projects - Make it easy to build variety of applications.
 		2. Auto Configuration - Eliminate configuration to setup Spring, Spring MVC, and other frameworks.
 		3. Enable NFR - Non Functional Requirements
 			1. Actuator - Enables advanced monitoring of the applications
 			2. Embedded Server - No need of separate application server.
 			3. Logging & Error Handling 
 			4. Profiles & ConfigurationProperties
			
# Understanding Logging
	1. Spring boot makes Logging easy: 
		1. spring-boot-starter-logging
	2. Default- LogBack with SLF4J
	
# Understanding DispatcherServelet, Model 1, Model 2, FrontController

## Model 1
![Model1](https://github.com/gauripatil/spring-boot/assets/3206551/96a5dc6d-9d10-4d28-a478-3451bd3c8355)

## Model 2
![Model2](https://github.com/gauripatil/spring-boot/assets/3206551/371950e2-2edd-492e-94f5-f830e5ada72e)

## FrontController
![FrontController](https://github.com/gauripatil/spring-boot/assets/3206551/1a542856-441b-4cf6-930d-5b33c7a7491c)

## Dispatcher Servelet

![DispatcherServelet](https://github.com/gauripatil/spring-boot/assets/3206551/9a425327-85e1-436c-89e2-0a59897d0e2e)
![FlowDispatcherServlet](https://github.com/gauripatil/spring-boot/assets/3206551/55b42feb-740c-4c08-a7a4-36d3162d2d6b)


# Session VS Request Scope
![SessionVsRequestScope](https://github.com/gauripatil/spring-boot/assets/3206551/91f330c0-d49c-4d11-84ad-553bb27f5bdf)


# Validation with Spring Boot
![ValidationWithSpringBoot](https://github.com/gauripatil/spring-boot/assets/3206551/630dadc1-2f47-4c64-a611-27d0ae5d7c01)


# JDBC - Spring JDBC - JPA - Spring JPA
![Screen Shot 2023-07-05 at 3 40 45 PM](https://github.com/gauripatil/spring-boot/assets/3206551/88468847-2de2-4fe3-b3ec-b0f34f402c95)


# Hibernate vs JPA
![Screen Shot 2023-07-07 at 12 58 59 AM](https://github.com/gauripatil/spring-boot/assets/3206551/4a1f1e76-6e36-406c-8f99-1a486749a6fe)


# JDBC vs Spring JDBC vs JPA vs Spring JPA
![Screen Shot 2023-07-09 at 2 25 21 AM](https://github.com/gauripatil/spring-boot/assets/3206551/3531c809-518f-4f2a-b1ae-c4a95b6afcc0)


# JDBC to Spring JDBC
![Screen Shot 2023-07-09 at 2 22 10 AM](https://github.com/gauripatil/spring-boot/assets/3206551/dbe1ab9b-bea4-4d1e-be85-670a6e494966)
![Screen Shot 2023-07-09 at 2 22 47 AM](https://github.com/gauripatil/spring-boot/assets/3206551/f5a09ef0-69e2-493f-a996-80823b9b4761)


# JPA
![Screen Shot 2023-07-09 at 2 23 56 AM](https://github.com/gauripatil/spring-boot/assets/3206551/a0cca27f-61d2-48a6-9713-3bfeaf6ca641)


# Spring JPA
![Screen Shot 2023-07-09 at 2 24 56 AM](https://github.com/gauripatil/spring-boot/assets/3206551/abd0cb43-b41f-439a-97f0-3458496c6eb2)

# Spring Boot Auto configuration magic - Data JPA
![Screen Shot 2023-07-20 at 10 54 39 PM](https://github.com/gauripatil/spring-boot/assets/3206551/01eceb97-11a3-4e6f-9f49-863c37a25b93)
