package com.mylearning.sprintgboot.firstrestapi.helloworld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldResource {

    // hello-world => "Hello World"

    @RequestMapping("/hello-world")
    public String sayHelloWorld() {
        return "Hello World";
    }

    @RequestMapping("/hello-world-bean")
    public HelloWorldResourceBean sayHelloWorldBean() {
        return new HelloWorldResourceBean("Hello World");
    }
}
