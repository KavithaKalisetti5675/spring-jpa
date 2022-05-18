package com.spring.jpa.service;

import com.spring.jpa.entity.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserDaoServiceCommandLineRunner implements CommandLineRunner {
    private final UserDAoService userDAoService;

    private static final Logger log = LoggerFactory.getLogger(UserDaoServiceCommandLineRunner.class);

    @Autowired
    public UserDaoServiceCommandLineRunner(UserDAoService userDAoService) {
        this.userDAoService=userDAoService;
    }

    @Override
    public void run(String... args) throws Exception {
        Users users =new Users("Jack","Admin");
        long insert = userDAoService.insert(users);
        log.info("New user is created : "+ users);
    }
}
