package com.itkedu.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.itkedu.model.User;
import com.itkedu.service.UserService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    
    @Test
    void shouldReturnUsersWithoutOrdersInSummaryView() throws Exception {

        User user = new User();
        user.setId(1L);
        user.setName("obul");
        user.setEmail("obul@gmail.com");

        when(userService.getAllUsers()).thenReturn(List.of(user));

        mockMvc.perform(get("/users"))
                .andExpect(status().isOk())

                
                .andExpect(jsonPath("$[0].orders").doesNotExist())

                .andExpect(jsonPath("$[0].name").value("obul"));
    }


    // Test UserDetails View
    @Test
    void shouldReturnUserWithOrdersInDetailsView() throws Exception {

        User user = new User();
        user.setId(1L);
        user.setName("obul");
        user.setEmail("obul@gmail.com");

        when(userService.getUserById(1L)).thenReturn(user);

        mockMvc.perform(get("/users/1"))
                .andExpect(status().isOk())

                /
                .andExpect(jsonPath("$.orders").exists())

                .andExpect(jsonPath("$.name").value("obul"));
    }
}