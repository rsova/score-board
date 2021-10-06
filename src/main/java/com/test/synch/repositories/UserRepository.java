package com.test.synch.repositories;

import com.test.synch.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * The interface User repository.
 */
public interface UserRepository extends CrudRepository<User, Integer> {

    /**
     * Find by name user.
     *
     * @param name the name
     * @return the user
     */
    User findByName(String name);

    /**
     * Find top 10 by order by overall score desc list.
     *
     * @return the list
     */
    List<User> findTop10ByOrderByOverallScoreDesc();

    /**
     * Gets all.
     *
     * @return the all
     */
    List<User> findAllByOrderByName();

    /**
     * The interface Name only.
     */
    interface NameOnly {
        /**
         * Gets name.
         *
         * @return the name
         */
        String getName();
    }
}
