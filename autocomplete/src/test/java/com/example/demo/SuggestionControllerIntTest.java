package com.example.demo;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(SuggestionController.class)
@TestMethodOrder(OrderAnnotation.class)
class SuggestionControllerIntTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Order(1)
    void listSuggestions() throws Exception {
        mockMvc.perform(get("/suggestions")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content()
                        .string("[\"Mango\",\"Banana\",\"Apple\",\"Lemon\",\"Pomegranate\",\"Avocado\",\"Grapes\"]"));
    }

    @Test
    @Order(2)
    void addSuggestions() throws Exception {
        mockMvc.perform(post("/suggestions")
                .contentType(MediaType.APPLICATION_JSON)
                .content("test")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }
}