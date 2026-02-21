package com.example.demo.service.spel;

import org.springframework.expression.spel.support.StandardEvaluationContext;
import tools.jackson.core.JacksonException;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class SpelResolver {
    private File rulePath;

    public SpelResolver(File rulePath) {
        this.rulePath = rulePath;
    }

    public Map<String, String> resolve(Map<String, String> values) {
        Map<String, String> result = new HashMap<>();
        List<SpelRule> rules = collectRules();

        if (rules == null || rules.isEmpty()) {
            return values;
        }

        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setVariables(Collections.unmodifiableMap(values));

        applyRules(rules, values, result);
        return result;
    }

    private void applyRules(List<SpelRule> rules, Map<String, String> values, Map<String, String> result) {
        for (SpelRule rule : rules) {
            String value = values.get(rule.getFromField());
            if (value != null) {
                rule.evaluateExp(values, result);
            }

        }
    }


    private List<SpelRule> collectRules() {
        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.readValue(rulePath, new TypeReference<List<SpelRule>>() {
            });
        } catch (JacksonException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }


}
