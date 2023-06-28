package com.mylearning.springboot.myfirstwebapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfiguration {
    // LDAP OR Database
    // In memory

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager() {
        UserDetails userDetails = User.withDefaultPasswordEncoder()
                .username("gauri")
                .password("admin")
                .roles("USER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(userDetails);
    }

}
