package com.mylearning.springboot.myfirstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("yourName")
public class LoginController {

    private Logger logger;

    // "/login" => login.jsp
    // /src/main/META-INF/resources/WEB-INF/jsp/login.jsp
    @RequestMapping(value="/", method= RequestMethod.GET)
    public String goToWelcomePage(ModelMap model) {
        model.put("name", "gauri");
        return "welcome";
    }

}
