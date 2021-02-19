package com.assignment.expressionevaluator.rest.controller;

import com.assignment.expressionevaluator.domain.OperatorCount;
import com.assignment.expressionevaluator.exception.InvalidExpressionException;
import com.assignment.expressionevaluator.rest.dto.ExpressionResultDto;
import com.assignment.expressionevaluator.service.ExpressionService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Project: expression-evaluator
 * Package: com.assignment.expressionevaluator.rest.controller
 * <p>
 * User: Rohit Patidar
 * Date: 19-02-2021
 * <p>
 */
@RestController
@RequestMapping("api/v1/user/")
public class ExpressionController {

    @Autowired
    private ExpressionService expressionService;

    @GetMapping("evaluate")
    @ApiOperation(value = "evaluate the given mathematical expression and return its result", response = ExpressionResultDto.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "User id to which this operation should be associated."),
            @ApiImplicitParam(name = "expression", value = "A mathematical expression to be calculated.")})
    @ApiResponses({
            @ApiResponse(code = 400, message = "if the user id or expression parameter is null or expression is not valid.")
    })
    public ResponseEntity<ExpressionResultDto> evaluateForUser(@RequestParam("userId") String userId,
                                                               @RequestParam("expression") String expression) throws InvalidExpressionException {
        Double result = expressionService.evaluateExpression(expression, userId);
        return ResponseEntity.ok(new ExpressionResultDto(result));
    }

    @GetMapping("get/operator/mostused")
    @ApiOperation(value = "returns an operator and its count which is most used by the user", response = OperatorCount.class)
    @ApiImplicitParam(name = "userId", value = "User id for which the most used operator count is required.")
    public ResponseEntity<OperatorCount> getMostUsedOperatorCount(@RequestParam("userId") String userId) {
        return ResponseEntity.ok(expressionService.getHighestUsedOperator(userId));
    }
}
