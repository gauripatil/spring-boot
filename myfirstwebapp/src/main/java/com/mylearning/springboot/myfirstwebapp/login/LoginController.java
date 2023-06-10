package com.mylearning.springboot.myfirstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("yourName")
public class LoginController {

    AuthenticationService authenticationService;
    private Logger logger;
    public LoginController(AuthenticationService authenticationService) {
        super();
        this.logger = LoggerFactory.getLogger(this.getClass());
        this.authenticationService = authenticationService;

    }



    // "/login" => login.jsp
    // /src/main/META-INF/resources/WEB-INF/jsp/login.jsp
    @RequestMapping(value="login", method= RequestMethod.GET)
    public String doLogin() {
        return "login";
    }

    @RequestMapping(value="login", method= RequestMethod.POST)
    public String goToWelcome(@RequestParam String name, @RequestParam String password,
                              ModelMap model) {

        if(authenticationService.authenticate(name, password)) {
            System.out.println("Welcome Page");

            model.put("yourName", name);
            model.put("yourPassword", password);
            return "welcome";
        }

        model.put("errorMsg", "Invalid Credentials!!!");
        return "login";

    }

}
