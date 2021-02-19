package com.assignment.expressionevaluator.service.impl;

import com.assignment.expressionevaluator.data.OperatorCountStoreDao;
import com.assignment.expressionevaluator.domain.OperatorCount;
import com.assignment.expressionevaluator.exception.InvalidExpressionException;
import com.assignment.expressionevaluator.service.ExpressionEvaluatorService;
import com.assignment.expressionevaluator.service.ExpressionService;
import com.assignment.expressionevaluator.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

/**
 * Project: expression-evaluator
 * Package: com.assignment.expressionevaluator.service.impl
 * <p>
 * User: Rohit Patidar
 * Date: 19-02-2021
 * <p>
 */
@Service
public class ExpressionServiceImpl implements ExpressionService {

    @Autowired
    private ExpressionEvaluatorService expressionEvaluatorService;

    @Autowired
    private OperatorService operatorService;

    @Autowired
    private OperatorCountStoreDao operatorCountStoreDao;

    @Override
    public Double evaluateExpression(String expression, String userId) throws InvalidExpressionException {
        Double result = expressionEvaluatorService.evaluate(expression);
        List<OperatorCount> operatorCounts = operatorService.getOperatorCount(expression);
        // get existing operator count for user
        List<OperatorCount> existingOperatorCounts = operatorCountStoreDao.getOperatorCountForUserId(userId);
        // add existing and new operator count
        List<OperatorCount> updateOperatorCounts = operatorService.addOperatorCount(existingOperatorCounts, operatorCounts);
        operatorCountStoreDao.setOperatorCountForUserId(userId, updateOperatorCounts);
        return result;
    }

    @Override
    public OperatorCount getHighestUsedOperator(String userId) {
        List<OperatorCount> operatorCountList = operatorCountStoreDao.getOperatorCountForUserId(userId);
        if(operatorCountList == null || operatorCountList.isEmpty()) {
            return new OperatorCount();
        }
        return operatorCountList.stream().max(Comparator.comparingInt(OperatorCount::getCount)).orElse(new OperatorCount());
    }


}
