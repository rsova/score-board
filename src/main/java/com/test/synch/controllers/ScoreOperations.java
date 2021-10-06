package com.test.synch.controllers;

import com.test.synch.dto.UserScore;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * The interface Score board operations.
 */
@RequestMapping("api/scores")
@CrossOrigin(origins = "http://localhost:4200")
public interface ScoreOperations {

    /**
     * Gets top scores.
     *
     * @param category the category
     * @return the top scores
     */
    @GetMapping("/top")
    List<UserScore> getTopScores(String category);
}
