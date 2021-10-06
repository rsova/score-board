package com.test.synch.controllers;

import com.test.synch.exception.ScoreBoardBadParameterException;
import com.test.synch.repositories.UserRepository;
import com.test.synch.services.ScoreService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@SpringBootTest
//@AutoConfigureMockMvc
@WebMvcTest(ScoreController.class)
public class ScoreControllerRestTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    UserRepository userRepository;

    @MockBean
    ScoreService scoreService;

    @Test
    public void shouldBeOk() throws Exception {
        this.mockMvc.perform(get("/api/scores/top")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void shouldBeOkWitCategory() throws Exception {
        this.mockMvc.perform(get("/api/scores/top?category=Attack")).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldBeError() throws Exception {
        this.mockMvc.perform(get("/api/scores/top?category=xyz")).andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof ScoreBoardBadParameterException));
    }

}