package com.example.demo.service;

import com.example.demo.entity.MyClient;
import com.example.demo.repository.MyClientRep;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MyClientService {
    private MyClientRep rep;


    public List<MyClient> getAllClients (){
        return rep.findAll();
    }
}
