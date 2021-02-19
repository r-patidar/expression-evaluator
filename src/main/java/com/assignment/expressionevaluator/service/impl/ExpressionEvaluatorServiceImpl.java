package com.assignment.expressionevaluator.service.impl;

import com.assignment.expressionevaluator.exception.InvalidExpressionException;
import com.assignment.expressionevaluator.service.ExpressionEvaluatorService;
import lombok.extern.slf4j.Slf4j;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.springframework.stereotype.Service;

/**
 * Project: expression-evaluator
 * Package: com.assignment.expressionevaluator.service.impl
 * <p>
 * User: Rohit Patidar
 * Date: 19-02-2021
 * <p>
 */
@Slf4j
@Service
public class ExpressionEvaluatorServiceImpl implements ExpressionEvaluatorService {

    @Override
    public Double evaluate(String expression) throws InvalidExpressionException {
        try {
            Expression e = new ExpressionBuilder(expression).build();
            // validate if the expression is valid or not
            if (e.validate().isValid()) {
                return e.evaluate();
            }
        } catch (IllegalArgumentException e) {
            log.error("Error while building expression from string: ", e);
        }
        throw new InvalidExpressionException("Provided expression is not a valid mathematical expression.");
    }
}
