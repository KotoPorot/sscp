package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "test_entity", schema = "my_app_schema")
public class SimpleTestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;

    @ElementCollection
    @CollectionTable(name = "test_entity_hobby", schema = "my_app_schema", joinColumns = @JoinColumn(name = "test_entity_id"))
    @Column(name = "hobby")
    List<String> hobby;

    public SimpleTestEntity() {
    }

    public SimpleTestEntity(String name, int age, List<String> hobby) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.hobby = hobby;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getHobby() {
        return hobby;
    }

    public void setHobby(List<String> hobby) {
        this.hobby = hobby;
    }
}
