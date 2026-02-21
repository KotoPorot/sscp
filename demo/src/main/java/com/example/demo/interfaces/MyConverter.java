package com.example.demo.interfaces;

import com.example.demo.entity.MyEntry;

import java.lang.reflect.Field;
import java.util.List;

public abstract class MyConverter<T, R> {
    public abstract R marshal(T ob, Field[] fields) throws IllegalAccessException;
    public abstract T unMarshal (R data);
}
