package com.test.synch.controllers;

import com.test.synch.dto.UserScore;
import com.test.synch.exception.ScoreBoardBadParameterException;
import com.test.synch.services.ScoreService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.test.synch.App.CATEGORIES;
import static com.test.synch.App.OVERALL;

@RestController
public class ScoreController implements ScoreOperations {

    /**
     * The  log.
     */
    private static final Log log = LogFactory.getLog(ScoreController.class);

    @Autowired
    private ScoreService scoreService;

    @Override
    public List<UserScore> getTopScores(@RequestParam(required = false) final String category) {
        log.info("Operation: getTopScores, category : " + (category != null ? category : OVERALL));
        if (category != null && !CATEGORIES.contains(category)) {
            log.error("Error condition: Bad Parameter" + category);
            throw new ScoreBoardBadParameterException();
        }
        return scoreService.findTop10ByCategory(category);
    }
}
