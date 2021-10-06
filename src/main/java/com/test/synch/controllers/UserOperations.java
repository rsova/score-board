package com.test.synch.controllers;

import com.test.synch.entities.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * The interface User operations.
 */
@RequestMapping("api/users")
@CrossOrigin(origins = "http://localhost:4200")
public interface UserOperations {

    /**
     * Find by name user.
     *
     * @param name the name
     * @return the user
     */
    @GetMapping("/getByName")
    User getByName(@RequestParam String name);

    /**
     * Gets names.
     *
     * @return the names
     */
    @GetMapping("/names")
    List<String> getNames();

}
