package com.test.synch.services;

import com.test.synch.dto.UserScore;

import java.util.List;

/**
 * The interface Score board service.
 */
public interface ScoreService {
    /**
     * Gets top by category.
     *
     * @param category the category
     * @return the top by category
     */
    List<UserScore> findTop10ByCategory(String category);


}
