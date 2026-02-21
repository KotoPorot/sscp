package com.example.demo.repository;

import com.example.demo.entity.SimpleTestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestEntityRep extends JpaRepository<SimpleTestEntity, Long> {

}
