package com.assignment.expressionevaluator.service;

import com.assignment.expressionevaluator.exception.InvalidExpressionException;

/**
 * Project: expression-evaluator
 * Package: com.assignment.expressionevaluator.service
 * <p>
 * User: Rohit Patidar
 * Date: 19-02-2021
 * <p>
 */
public interface ExpressionEvaluatorService {

    /**
     * Evaluate the given mathematical expression
     * @param expression mathematical expression in string form
     * @return result of the mathematical expression
     */
    Double evaluate(String expression) throws InvalidExpressionException;
}
