package com.assignment.expressionevaluator.service;

import com.assignment.expressionevaluator.domain.OperatorCount;

import java.util.List;

public interface OperatorService {

    /**
     * Count occurrence of each arithmetic operator in given string
     * @param text
     * @return
     */
    List<OperatorCount> getOperatorCount(String text);

    /**
     * add one list of operator to another based on the operator
     * @param first
     * @param second
     * @return updated list
     */
    List<OperatorCount> addOperatorCount(List<OperatorCount> first, List<OperatorCount> second);
}
