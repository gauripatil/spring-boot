package com.mylearning.springboot.myfirstwebapp.hello;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

    @RequestMapping("say-hello")
    @ResponseBody
    public String sayHello() {
        return "Hello World!";
    }

    // "/say-helloe-jsp" => sayHello.jsp
    // /src/main/META-INF/resources/WEB-INF/jsp/sayHello.jsp
    // /src/main/META-INF/resources/WEB-INF/jsp/welcome.jsp
    // /src/main/META-INF/resources/WEB-INF/jsp/todos.jsp

    @RequestMapping("say-hello-jsp")
    public String sayHelloJsp() {
        return "sayHello";
    }

}
