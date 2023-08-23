package com.mylearning.sprintgboot.firstrestapi.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDetailsCommandLineRunner implements CommandLineRunner {


    private UserDetailsRepository repository;
    private Logger logger= LoggerFactory.getLogger(getClass());

    public UserDetailsCommandLineRunner() {
    }

    public UserDetailsCommandLineRunner(UserDetailsRepository repository) {
        super();
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        repository.save(new UserDetails("Gauri", "Admin"));
        repository.save(new UserDetails("Abhigya", "Admin"));
        repository.save(new UserDetails("Pranav", "Admin"));

        List<UserDetails> users = repository.findAll();
        users.forEach(userDetails -> logger.info(userDetails.toString()));
    }
}