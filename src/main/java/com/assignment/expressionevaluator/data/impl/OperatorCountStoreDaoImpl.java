package com.assignment.expressionevaluator.data.impl;

import com.assignment.expressionevaluator.data.OperatorCountStoreDao;
import com.assignment.expressionevaluator.domain.OperatorCount;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project: expression-evaluator
 * Package: com.assignment.expressionevaluator.data.impl
 * <p>
 * User: Rohit Patidar
 * Date: 19-02-2021
 * <p>
 */
@Slf4j
@Service
public class OperatorCountStoreDaoImpl implements OperatorCountStoreDao {

    private final Map<String, List<OperatorCount>> userWiseOperatorCount = new HashMap<>();

    @Override
    public List<OperatorCount> getOperatorCountForUserId(String userId) {
        return userWiseOperatorCount.get(userId);
    }

    @Override
    public boolean setOperatorCountForUserId(String userId, List<OperatorCount> operatorCounts) {
        try {
            userWiseOperatorCount.put(userId, operatorCounts);
            return true;
        } catch (Exception e) {
            log.error("Problem while updating operator count store: ", e);
            return false;
        }
    }
}
