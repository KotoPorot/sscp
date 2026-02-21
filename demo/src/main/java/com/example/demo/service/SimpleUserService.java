package com.example.demo.service;

import com.example.demo.entity.SimpleUser;
import com.example.demo.repository.SimpleUserRep;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimpleUserService {
    private PasswordEncoder encoder;
    private SimpleUserRep rep;

    public SimpleUserService(PasswordEncoder encoder, SimpleUserRep rep) {
        this.encoder = encoder;
        this.rep = rep;
    }

    public boolean createUser(String login, String password) {
        try {
            String encodedPass = encoder.encode(password);
            rep.save(new SimpleUser(login, encodedPass));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<SimpleUser> getUsers() {
        return rep.findAll();
    }

}
