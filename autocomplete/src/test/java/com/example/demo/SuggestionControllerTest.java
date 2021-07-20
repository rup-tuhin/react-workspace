package com.example.demo;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SuggestionControllerTest {

    @Test
    void listSuggestions() {
        SuggestionController controller = new SuggestionController();
        List<String> values = controller.listSuggestions();
        assertEquals(7, values.size());
        assertEquals("Mango", values.get(0));
        assertEquals("Grapes", values.get(6));
    }

    @Test
    void addSuggestions() {
        SuggestionController controller = new SuggestionController();
        int initialSize = controller.listSuggestions().size();
        String item = controller.addSuggestions("test");
        assertEquals(initialSize + 1, controller.listSuggestions().size());
    }
}