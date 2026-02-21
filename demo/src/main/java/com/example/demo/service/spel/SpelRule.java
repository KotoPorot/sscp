package com.example.demo.service.spel;

import lombok.Data;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.MapAccessor;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.Map;

@Data
public class SpelRule {
    private String fromField;
    private String toField;
    private String exp;

    public void evaluateExp(Map<String, String> values, Map<String, String> result) {
        SpelExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext(values);
        context.addPropertyAccessor(new MapAccessor());
        Expression expression = parser.parseExpression(exp);

        String evaluatedVal = expression.getValue(context, String.class);

        result.put(toField, evaluatedVal);
    }
}
