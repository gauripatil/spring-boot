package com.mylearning.sprintgboot.firstrestapi.helloworld;

public class HelloWorldResourceBean {
    private String message;

    public HelloWorldResourceBean(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "HelloWorldResourceBean{" +
                "message='" + message + '\'' +
                '}';
    }
}
