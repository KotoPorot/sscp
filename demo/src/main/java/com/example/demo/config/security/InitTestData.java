package com.example.demo.config.security;

import com.example.demo.entity.SimpleTestEntity;
import com.example.demo.repository.TestEntityRep;
import com.example.demo.service.SimpleUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class InitTestData {
    private SimpleUserService userService;
    private TestEntityRep testEntityRep;

    public InitTestData(SimpleUserService userService, TestEntityRep testEntityRep) {
        this.userService = userService;
        this.testEntityRep = testEntityRep;

    }

    @Bean
    public CommandLineRunner comRun(SimpleUserService userService) {
        return args -> {
            System.out.println("start init:");
            String pass = "pass";

            for (int i = 0; i < 5; i++) {
                String login = "user" + (i + 1);
                if (userService.createUser(login, pass)) {
                    System.out.println("Login created:" + login);
                    System.out.println("Password: " + pass);
                }
            }
            for (int i = 0; i < 5; i++) {
                String name = "name" + (i + 1);
                testEntityRep.save(new SimpleTestEntity(name, i + 18, List.of("drinks", "songs", "dogs")));
            }

            System.out.println("init was ended successfully");
        };
    }

}
