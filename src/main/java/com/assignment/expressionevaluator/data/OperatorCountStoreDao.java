package com.assignment.expressionevaluator.data;

import com.assignment.expressionevaluator.domain.OperatorCount;

import java.util.List;

public interface OperatorCountStoreDao {

    /**
     * get operator count {@link OperatorCount} for given user id
     * @param userId user id for which operator count is required
     * @return an {@link OperatorCount} object if exist or null
     */
    List<OperatorCount> getOperatorCountForUserId(String userId);

    /**
     * set or update the {@link OperatorCount} for given user id
     * @param userId user id for which the {@link OperatorCount} should be set or updated
     * @param operatorCounts
     * @return true if the operation was successful otherwise false
     */
    boolean setOperatorCountForUserId(String userId, List<OperatorCount> operatorCounts);
}
