package com.example.demo.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "clients")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyClient {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    @Embedded
    private ClientAddress address;
    private LocalDate date;
    private int age;
}
