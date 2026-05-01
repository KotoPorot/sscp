package com.example.demo.entity;


import lombok.NonNull;

public class MyEntry {
    @NonNull
    private String key;
    private String value;

    public MyEntry(@NonNull String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "MyEntry{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
