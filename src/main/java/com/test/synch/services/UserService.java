package com.test.synch.services;

import com.test.synch.entities.User;

import java.util.List;

/**
 * The interface User service.
 */
public interface UserService {
    /**
     * Gets user by name.
     *
     * @param name the name
     * @return the user
     */
    User getByName(String name);

    /**
     * Gets names.
     *
     * @return the names
     */
    List<String> getNames();
}
