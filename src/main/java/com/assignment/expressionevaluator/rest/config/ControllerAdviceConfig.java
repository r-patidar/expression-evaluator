package com.assignment.expressionevaluator.rest.config;

import com.assignment.expressionevaluator.exception.InvalidExpressionException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Project: expression-evaluator
 * Package: com.assignment.expressionevaluator.rest.config
 * <p>
 * User: Rohit Patidar
 * Date: 19-02-2021
 * <p>
 */
@ControllerAdvice
public class ControllerAdviceConfig {

    @ExceptionHandler({InvalidExpressionException.class})
    public ResponseEntity handleInvalidExpression(InvalidExpressionException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
