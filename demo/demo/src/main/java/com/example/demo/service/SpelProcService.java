package com.example.demo.service;

import com.example.demo.entity.Client;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SpelProcService {
    private SpelExpressionParser parser = new SpelExpressionParser();
    private SpelRulesLoader rulesLoader;

    public SpelProcService(SpelRulesLoader rulesLoader) {
        this.rulesLoader = rulesLoader;
    }

    public List<Client> createPresentationList(List<Client> list) {
        Map<String, String> rules = rulesLoader.loadJsonRules();

        if (rules == null || rules.isEmpty()) {
            return list;
        }
        return list.stream().map(Client::new)
                .peek(newClient->applyRulles(newClient, rules))
                .collect(Collectors.toList());
    }

    private void applyRulles(Client client, Map<String, String> rules) {

        StandardEvaluationContext context = new StandardEvaluationContext(client);

        rules.forEach((fieldName, exp)->{
            try {
                Expression expression = parser.parseExpression(exp);
                Object newValue = expression.getValue(context);
                parser.parseExpression(fieldName).setValue(context,newValue);
            } catch (Exception e) {
                System.out.println("wrong expression exeption: ");
                System.out.println("expression: " + exp);
                System.out.println("fieldName: " + fieldName);
            }
        });


    }
}
