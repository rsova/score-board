package com.test.synch.services;

import com.test.synch.entities.User;
import com.test.synch.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * The type User server.
 */
@Service
public class UserServerImpl implements UserService {

    /**
     * The User service.
     */
    @Autowired
    UserRepository userRepository;

    @Override
    public User getByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    @Cacheable("user-names")
    public List<String> getNames() {
        return userRepository.findAllByOrderByName().stream().map(User::getName).collect(toList());
    }
}

