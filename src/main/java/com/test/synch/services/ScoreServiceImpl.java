package com.test.synch.services;

import com.test.synch.dto.UserScore;
import com.test.synch.repositories.ScoreRepository;
import com.test.synch.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.stream.Collectors.toList;

/**
 * The type Score board service.
 */
@Service
public class ScoreServiceImpl implements ScoreService {

    /**
     * The User repository.
     */
    @Autowired
    public UserRepository userRepository;

    /**
     * The Score repository.
     */
    @Autowired
    public ScoreRepository scoreRepository;

    @Override
    public List<UserScore> findTop10ByCategory(final String category) {
        AtomicInteger idx = new AtomicInteger(1);
        if (category != null) {
            return scoreRepository.findTop10ByCategoryOrderByValueDesc(category).stream()
                    .map(s -> new UserScore(s.getUser().getName(), idx.getAndIncrement(), s.getValue()))
                    .collect(toList());
        } else {
            return userRepository.findTop10ByOrderByOverallScoreDesc().stream()
                    .map(s -> new UserScore(s.getName(), idx.getAndIncrement(), s.getOverallScore()))
                    .collect(toList());
        }
    }

}

