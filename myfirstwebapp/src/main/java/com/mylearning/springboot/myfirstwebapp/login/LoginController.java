package com.mylearning.springboot.myfirstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // "/login" => login.jsp
    // /src/main/META-INF/resources/WEB-INF/jsp/login.jsp
    @RequestMapping("login")
    public String doLogin(@RequestParam String name, ModelMap model) {
        model.put("name", name);
        logger.debug("I want this to be printed at debug level");
        logger.info("I want this to be printed at info level");
        logger.warn("I want this to be printed at warn level");
        System.out.println("Request Param : " + name);
        return "login";
    }
}
