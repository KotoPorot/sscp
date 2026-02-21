package com.example.demo.config.security;

import com.example.demo.entity.MyEntry;
import com.example.demo.entity.SimpleTestEntity;
import com.example.demo.entity.SimpleUser;
import com.example.demo.repository.TestEntityRep;
import com.example.demo.service.MyEntryResolver;
import com.example.demo.service.SimpleConverter;
import com.example.demo.service.SimpleUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.List;

@Configuration
public class InitTestData {
    private SimpleUserService userService;
    private TestEntityRep testEntityRep;

    public InitTestData(SimpleUserService userService, TestEntityRep testEntityRep) {
        this.userService = userService;
        this.testEntityRep=testEntityRep;

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
            for (int i = 0; i<5; i++){
                String name = "name"+(i+1);
                testEntityRep.save(new SimpleTestEntity(name, i+18,List.of("drinks", "songs", "dogs") ));
            }

            System.out.println("init was ended successfully");

//            Field[] fields = SimpleUser.class.getDeclaredFields();
//
//            converter.marshal(userService.getUsers(), fields);
//            System.out.println("test parse String");
//            String testData = """
//com.example.demo.entity.SimpleUser.id=1
//com.example.demo.entity.SimpleUser.userName=user1
//com.example.demo.entity.SimpleUser.password=$2a$10$AWuY3I0hyXhvtYVYIkXuUu.qHq6Aiw0TzAWtaYGSImbsdgo2OAcRS
//com.example.demo.entity.SimpleUser.id=2
//com.example.demo.entity.SimpleUser.userName=user2
//com.example.demo.entity.SimpleUser.password=$2a$10$yHFccDAIBidBANleXc4Gl..Zv2TNw3nqyBfioDyuTfcC1ijdQDew6
//com.example.demo.entity.SimpleUser.id=3
//com.example.demo.entity.SimpleUser.userName=user3
//com.example.demo.entity.SimpleUser.password=$2a$10$i0GEbH0DY5KmOyp3nIU19eyWg0u896xCkVGN6L9zQaBdQhrlgG1ZO
//com.example.demo.entity.SimpleUser.id=4
//com.example.demo.entity.SimpleUser.userName=user4
//com.example.demo.entity.SimpleUser.password=$2a$10$Sx0O9MOwCcUMzY7DQXA/4ucq5hPCTXrqlSMS9YGLdQ2orlDCDo3cu
//com.example.demo.entity.SimpleUser.id=5
//com.example.demo.entity.SimpleUser.userName=user5
//com.example.demo.entity.SimpleUser.password=$2a$10$VENjHj1qX/Zt0HpuWx4kWuzknV6xEgJDjWoCPjgPt5PoGDPuDEm1a
//                    """;
//           List<MyEntry> entries = resolver.parseEntries(testData);
//           for (MyEntry e :entries){
//               System.out.println(e);
//           }
//            System.out.println("try to UpCase:");
//
//            System.out.println(converter.convertValToUpCase(testData));


        };
    }

}
