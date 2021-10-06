package com.test.synch.repositories;

import com.test.synch.entities.Score;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * The interface Score repository.
 */
public interface ScoreRepository extends CrudRepository<Score, Integer> {


    /**
     * Find top 10 by category order by value desc list.
     *
     * @param category the category
     * @return the list
     */
    List<Score> findTop10ByCategoryOrderByValueDesc(String category);

}
