package com.test.synch.controllers;

import com.test.synch.entities.User;
import com.test.synch.services.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController implements UserOperations {

    /**
     * The  log.
     */
    private static final Log log = LogFactory.getLog(UserController.class);

    @Autowired
    private UserService userService;

    @Override
    public User getByName(@RequestParam final String name) {
        log.info("Operation: findByName, name: " + name);
        return userService.getByName(name);
    }

    @Override
    public List<String> getNames() {
        log.info("Operation: getNames");
        return userService.getNames();
    }
}
