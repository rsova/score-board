package com.test.synch.services;

import com.test.synch.dto.UserScore;
import com.test.synch.entities.Score;
import com.test.synch.entities.User;
import com.test.synch.repositories.ScoreRepository;
import com.test.synch.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ScoreServiceImplTest {
    @Mock
    ScoreRepository scoreRepository;

    @Mock
    UserRepository userRepository;

    @InjectMocks
    ScoreServiceImpl scoreService;

    @BeforeEach
    void before() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void findTop10ByCategory_Overall() {
        List<User> users = Arrays.asList(new User("Bob",Arrays.asList(new Score("Attack",20))));
        users.get(0).setOverallScore(20); // do the jpa work here

        when(userRepository.findTop10ByOrderByOverallScoreDesc()).thenReturn(users);
        // expectations
        List<UserScore> userScores = scoreService.findTop10ByCategory(null);
        assertEquals(new UserScore("Bob", 1, 20), userScores.get(0));
        verify(userRepository, times(1)).findTop10ByOrderByOverallScoreDesc();
    }

    @Test
    void findTop10ByCategory() {
        String category = "Attack";
        List<Score> scores = Arrays.asList(new Score(category,20));
        scores.get(0).setUser(new User("Sam", new ArrayList<>()));

        when(scoreRepository.findTop10ByCategoryOrderByValueDesc(category)).thenReturn(scores);
        // expectations
        List<UserScore> userScores = scoreService.findTop10ByCategory(category);
        assertEquals(new UserScore("Sam", 1, 20), userScores.get(0));
        verify(scoreRepository, times(1)).findTop10ByCategoryOrderByValueDesc(category);
    }
}