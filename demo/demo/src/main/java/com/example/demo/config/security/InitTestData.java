package com.example.demo.config.security;

import com.example.demo.entity.Address;
import com.example.demo.entity.Client;
import com.example.demo.repository.ClientsRep;
import com.example.demo.service.SimpleUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class InitTestData {
    private SimpleUserService userService;
    private ClientsRep clientsRep;

    public InitTestData(SimpleUserService userService, ClientsRep clientsRep) {
        this.userService = userService;
        this.clientsRep = clientsRep;

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
                clientsRep.save(new Client("Андрей","Велесов","Владимирович", new Address("Киев","Волошина"),new Date(), 18+i));

            System.out.println("init was ended successfully");


        };
    }

}
