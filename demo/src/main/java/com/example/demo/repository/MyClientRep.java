package com.example.demo.repository;

import com.example.demo.entity.MyClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyClientRep extends JpaRepository<MyClient, Long> {
}
