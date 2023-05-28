# IMPORTANT GOALS OF SPRING BOOT

 ## Help you build PRODUCTION READY apps QUICKLY
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
 
 # Exploring Spring Boot Starter Projects
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
 
# Exploring Spring Boot Auto Configuration
 	1. I need a lot of Configuration to Build a Spring app
 		ex- Component Scan, Dispatcher Servlet, Data Sources, JSON Conversion etc.
 	2. How can I simplify this?
 		1. Auto Configuration: Automated configuration for your app
 			1. Decided based on
 				1. which frameworks are in classpath
 				2. What is existing configuration(Annotations)
	3. Example - Spring Boot Starter Web
 		1. Dispatcher servlet(DispatcherServeletAutoConfiguration)
 		2. Embedded Servlet Container - Tomcat is default (EmbeddedWebServerFactoryCustomizerAutoConfiguration)
 		3. Default Error Pages - (Error MVC Autoconfiguration)
 		4. Bean <-> JSON (JacksonHttpMessageConvertersConfiguration)
