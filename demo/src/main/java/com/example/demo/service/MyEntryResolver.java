package com.example.demo.service;

import com.example.demo.entity.MyEntry;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class MyEntryResolver<T> {
    private static final String PATTERN = "^([^=]+)=(.*)$";


    public List<MyEntry> collectObEntries(T ob, Field[] fields) throws IllegalAccessException {
        List<MyEntry> entries = new ArrayList<>();
        String packetPath = ob.getClass().getName();
        for (Field field : fields) {
            String key = packetPath + "." + field.getName();
            String value = String.valueOf(field.get(ob));
            entries.add(new MyEntry(key, value));
        }
        return entries;
    }

    //There is no need for a test as the method is simple
    public List<MyEntry> collectObEntries(List<T> objects, Field[] fields) throws IllegalAccessException {
        List<MyEntry> result = new ArrayList<>();
        for (T ob : objects) {
            result.addAll(collectObEntries(ob, fields));
        }
        return result;
    }

    //парсит строку в ентри
    public MyEntry parseEntry(String s) {
        Pattern pattern = Pattern.compile(PATTERN);
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            if (matcher.group(2).equals("null")) {
                return new MyEntry(matcher.group(1), null);
            }

            return new MyEntry(matcher.group(1), matcher.group(2));
        } else {
            throw new IllegalArgumentException();
        }
    }

    //There is no need for a test as the method is simple
    public List<MyEntry> parseEntries(String s) {
        return s.lines().filter(line -> !line.isBlank()).map(this::parseEntry).toList();
    }

    public String parseString(List<MyEntry> list) {
        StringBuilder builder = new StringBuilder();

        for (MyEntry entry : list) {
            builder.append(entry.getKey()).append("=").append(entry.getValue()).append(System.lineSeparator());
        }
        return builder.toString();
    }

    public List<MyEntry> valuesToUpCase(List<MyEntry> entries) {
        List<MyEntry> result = new ArrayList<>();

        for (MyEntry entry : entries) {
            if (entry.getValue() != null) {
                result.add(new MyEntry(entry.getKey(), entry.getValue().toUpperCase()));
            } else {
                result.add(new MyEntry(entry.getKey(), entry.getValue()));
            }
        }
        return result;
    }


}
