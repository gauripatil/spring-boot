package com.mylearning.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    public boolean authenticate(String username, String password) {
        boolean isValidUsername = username.equalsIgnoreCase("admin");
        boolean isValidPassword = password.equalsIgnoreCase("admin123");

        System.out.println(isValidUsername);
        System.out.println(isValidPassword);

        return  isValidUsername && isValidPassword;
    }
}
