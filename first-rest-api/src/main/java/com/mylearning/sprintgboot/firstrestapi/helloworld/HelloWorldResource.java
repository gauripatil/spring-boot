package com.mylearning.sprintgboot.firstrestapi.helloworld;

import org.springframework.web.bind.annotation.PathVariable;
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

    // Path Variables or Path params
    // /user/Ranga/todos/1
    @RequestMapping("/hello-world-path-param/{name}")
    public HelloWorldResourceBean sayHelloWorldPathParams(@PathVariable String name) {
        return new HelloWorldResourceBean("Hello World, " + name);
    }

    @RequestMapping("/hello-world-path-param/{name}/message/{message}")
    public HelloWorldResourceBean sayHelloWorldMultiplePathParams(@PathVariable String name,
                              @PathVariable String message) {
        return new HelloWorldResourceBean("Hello World, " + name + ", " + message);
    }
}
