package com.example.demo.repository;

import com.example.demo.entity.MyClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyClientRep extends JpaRepository<MyClient, Long> {
}
