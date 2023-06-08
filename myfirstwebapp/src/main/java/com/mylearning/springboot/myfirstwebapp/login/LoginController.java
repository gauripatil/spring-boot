package com.mylearning.springboot.myfirstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // "/login" => login.jsp
    // /src/main/META-INF/resources/WEB-INF/jsp/login.jsp
    @RequestMapping(value="login", method= RequestMethod.GET)
    public String doLogin() {
        return "login";
    }

    @RequestMapping(value="login", method= RequestMethod.POST)
    public String goToWelcome(@RequestParam String name, @RequestParam String password,
                              ModelMap model) {
        model.put("yourName", name);
        model.put("yourPassword", password);
        return "welcome";
    }
}
