package com.test.synch.services;

import com.test.synch.entities.User;
import com.test.synch.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServerImplTest {
    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserServerImpl userService;

    @BeforeEach
    void before() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getByName() {
        when(userRepository.findByName("Bob")).thenReturn(new User("Bob", new ArrayList<>()));

        User user = userService.getByName("Bob");

        assertEquals("Bob", user.getName());
        verify(userRepository, times(1)).findByName("Bob");
    }

    @Test
    void getNames() {
        when(userRepository.findAllByOrderByName()).thenReturn(Arrays.asList(new User("Bob", new ArrayList<>())));

        List<String> names = userService.getNames();
        assertEquals(1, names.size());
        assertEquals("Bob", names.get(0));

        verify(userRepository, times(1)).findAllByOrderByName();
    }
}