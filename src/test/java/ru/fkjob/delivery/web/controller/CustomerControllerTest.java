package ru.fkjob.delivery.web.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.fkjob.delivery.config.TestConfig;
import ru.fkjob.delivery.store.repository.CustomerRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = TestConfig.class)
@AutoConfigureMockMvc
class CustomerControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void createUserTest() throws Exception {
        String requestContent = "{\"username\":\"Semen34\",\"password\":\"12345678\",\"email\":\"kek@gmail.com\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/rest/registration")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestContent))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("Semen34"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("kek@gmail.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.password").value("12345678"));
    }
}