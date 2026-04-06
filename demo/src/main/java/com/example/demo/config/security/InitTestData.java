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
}
