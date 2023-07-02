package com.mylearning.springboot.myfirstwebapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.function.Function;

@Configuration
public class SpringSecurityConfiguration {
    private String username;
    private String password;
    // LDAP OR Database
    // In memory

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager() {
        UserDetails userDetails1 = getUserDetails("gauri", "admin");
        UserDetails userDetails2 = getUserDetails("gauripatil", "admin123");
        return new InMemoryUserDetailsManager(userDetails1, userDetails2);
    }

    private UserDetails getUserDetails(String username, String password) {
        Function<String, String> passwordEncoder =
                input -> passwordEncoder().encode(input);
        UserDetails userDetails = User.builder()
                                    .passwordEncoder(passwordEncoder)
                                    .username(username)
                                    .password(password)
                                    .roles("USER", "ADMIN")
                                    .build();
        return userDetails;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
