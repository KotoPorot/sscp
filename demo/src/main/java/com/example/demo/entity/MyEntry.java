package com.example.demo.entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class MyEntry {
    @NonNull
    private String key;
    private String value;
}
