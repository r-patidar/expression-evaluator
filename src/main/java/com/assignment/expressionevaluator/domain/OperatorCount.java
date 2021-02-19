package com.assignment.expressionevaluator.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Project: expression-evaluator
 * Package: com.assignment.expressionevaluator.domain
 * <p>
 * User: Rohit Patidar
 * Date: 19-02-2021
 * <p>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperatorCount {

    private String operator;

    private int count;

}
