package com.assignment.expressionevaluator.service.impl;

import com.assignment.expressionevaluator.domain.OperatorCount;
import com.assignment.expressionevaluator.service.OperatorService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
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
public class OperatorServiceImpl implements OperatorService {

    private static final String[] OPERATORS_TO_COUNT = {"+", "-", "*", "/"};

    @Override
    public List<OperatorCount> getOperatorCount(String text) {
        List<OperatorCount> operatorCountList = new ArrayList<>();
        for (String operator: OPERATORS_TO_COUNT) {
            operatorCountList.add(new OperatorCount(operator, getCount(text, operator)));
        }
        return operatorCountList;
    }

    @Override
    public List<OperatorCount> addOperatorCount(List<OperatorCount> first, List<OperatorCount> second) {
        if(first == null || first.isEmpty()) {
            return second;
        }

        if(second == null || second.isEmpty()) {
            return first;
        }
        first.addAll(second);
        List<OperatorCount> newOperatorCounts = new ArrayList<>();
        for (String operator: OPERATORS_TO_COUNT) {
            int matchedOperatorCount = first.stream().filter(operatorCount -> operatorCount.getOperator().equals(operator))
                    .mapToInt(OperatorCount::getCount).sum();
            newOperatorCounts.add(new OperatorCount(operator, matchedOperatorCount));
        }
        return newOperatorCounts;
    }

    private int getCount(String text, String s) {
        return StringUtils.countOccurrencesOf(text, s);
    }


}
