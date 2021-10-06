package com.test.synch.controllers;

import com.test.synch.repositories.ScoreRepository;
import com.test.synch.repositories.UserRepository;
import com.test.synch.services.ScoreService;
import com.test.synch.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.MissingServletRequestParameterException;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
class UserControllerRestTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    UserRepository userRepository;

    @MockBean
    UserService userService;

    @Test
    public void shouldBeOk() throws Exception {
        this.mockMvc.perform(get("/api/users/names")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void shouldBeError() throws Exception {
        this.mockMvc.perform(get("/api/users/getByName")).andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof MissingServletRequestParameterException));
    }
}