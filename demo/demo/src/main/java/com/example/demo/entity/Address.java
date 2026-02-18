package com.example.demo.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    private String city;
    private String street;


    public Address(String city, String street) {
        this.city = city;
        this.street = street;
    }

    public Address(Address address){
        if(address!=null){
        this.city = address.city;
        this.street = address.street;
    }
    }

    public Address() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
