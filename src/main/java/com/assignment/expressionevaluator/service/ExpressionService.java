package com.assignment.expressionevaluator.service;

import com.assignment.expressionevaluator.domain.OperatorCount;
import com.assignment.expressionevaluator.exception.InvalidExpressionException;

public interface ExpressionService {

    Double evaluateExpression(String expression, String userId) throws InvalidExpressionException;

    OperatorCount getHighestUsedOperator(String userId);
}
