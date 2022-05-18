package com.spring.jpa.service;

import com.spring.jpa.entity.Users;
import com.spring.jpa.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner {
    private final UserRepository userRepository;

    private static final Logger log = LoggerFactory.getLogger(UserRepositoryCommandLineRunner.class);

    @Autowired
    public UserRepositoryCommandLineRunner(UserRepository userRepository) {
        this.userRepository=userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Users users =new Users("Jill","Admin");

        userRepository.save(users);
        log.info("New user is created : "+ users);

        Optional<Users> id = userRepository.findById(1L);
        log.info("user retrieved : "+ id);

        List<Users> usersList = userRepository.findAll();
        log.info("All users : "+ usersList);
    }
}
