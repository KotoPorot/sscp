package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
@Entity
@Table(name = "Clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String middleName;

    @Embedded
    private Address address;

    private Date dateOfBirth;
    private int age;

    public Client() {
    }

    public Client(Client client) {
    this.id = client.id;
    this.age = client.age;
    this.dateOfBirth = client.dateOfBirth;
    this.firstName=client.firstName;
    this.lastName = client.lastName;
    this.middleName = client.middleName;
    this.address = (client.address!=null)?new Address(client.address):null;
    }

    public Client(String firstName, String lastName, String middleName, Address address, Date dateOfBirth, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
