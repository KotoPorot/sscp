package com.example.demo.service;

import com.example.demo.entity.MyEntry;
import com.example.demo.interfaces.MyConverter;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class SimpleConverter<T> extends MyConverter<T, String> {
    private MyEntryResolver resolver;

    public SimpleConverter(MyEntryResolver<T> resolver) {
        this.resolver = resolver;
    }

    @Override
    public String marshal(T ob, Field[] fields) throws IllegalAccessException {
        for (Field f:fields){
            f.setAccessible(true);
        }
        return resolver.parseString(resolver.collectObEntries(ob,fields));
    }
    public String marshal(List<T> objects, Field[] fields) throws IllegalAccessException {
        for (Field f:fields){
            f.setAccessible(true);
        }
        return resolver.parseString(resolver.collectObEntries(objects, fields));
    }

    public String convertValToUpCase(String s){
        List<MyEntry> entries = resolver.parseEntries(s);
        return resolver.parseString(resolver.valuesToUpCase(entries));
    }

    @Override
    public T unMarshal(String data) {
        return null;
    }



}
