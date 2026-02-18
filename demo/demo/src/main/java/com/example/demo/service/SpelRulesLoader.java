package com.example.demo.service;

import org.springframework.stereotype.Service;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Service
public class SpelRulesLoader {
    private ObjectMapper mapper = new ObjectMapper();
    private Map<String, String> rules = new HashMap<>();
    private long lastMod = 0;


    public Map<String, String> loadJsonRules(){

        File file = new File("spelconfig.json");
        if (!file.exists()) {
            System.err.println("КРИТИЧЕСКАЯ ОШИБКА: Файл " + file.getAbsolutePath() + " не найден!");
        }
        long fileLastMod = file.lastModified();
        if(fileLastMod>lastMod){

        this.rules = mapper.readValue(file, new TypeReference<Map<String, String>>() {
        });

        this.lastMod = fileLastMod;
        }
        return rules;
    }
}
