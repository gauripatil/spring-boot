package com.mylearning.springboot.myfirstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // "/login" => login.jsp
    // /src/main/META-INF/resources/WEB-INF/jsp/login.jsp
    @RequestMapping("login")
    public String doLogin() {
        return "login";
    }
}
