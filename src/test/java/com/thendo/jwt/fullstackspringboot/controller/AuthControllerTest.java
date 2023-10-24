package com.thendo.jwt.fullstackspringboot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thendo.jwt.fullstackspringboot.service.implementation.UserServiceImpl;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
public class AuthControllerTest {

    // helps to make HHTP requests
    public MockMvc mockMvc;

    @Autowired
    public AuthController authController;

    @MockBean
    public UserServiceImpl userServiceImpl;

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(authController).build();
    }

    @SneakyThrows
    @Test
    void testSignUp() {
        //  given (initialise values, input parameters and the state of the system)
//        SignUpDTO signUpDTO = new SignUpDTO("Thendo", "Ramashia", "thendo", "123456".toCharArray());
//                .firstName("Thendo")
//                .lastName("Ramashia")
//                .login("thendo")
//                .password("123456".toCharArray())
//                .build();

//        when(userService.register(any()))
//                .thenReturn(
//                        UserDTO.builder().id(1L)
//                        .firstName("Thendo")
//                        .lastName("Ramashia")
//                        .login("thendo")
//                        .token("token")
//                        .build());

        // when (call methods to be tested)
//        mockMvc.perform(post("/register")
//                .contentType(MediaType.APPLICATION_JSON_VALUE)
//                .content(objectMapper.writeValueAsBytes(signUpDTO)))
//                .andExpect(status().is(201))
//                .andExpect((ResultMatcher) jsonPath("$.token", is("token")));

        // then (check results of the test)
    }

}
