package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/suggestions")
public class SuggestionController {

    private List<String> suggestions = List.of("Mango", "Banana", "Apple", "Lemon", "Pomegranate", "Avocado", "Grapes");

    @GetMapping
    public List<String> listSuggestions() {
        return suggestions;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String addSuggestions(
            @RequestBody String item) {
        List<String> copyList = new ArrayList<>(suggestions);
        copyList.add(item);
        suggestions = copyList;
        return item;
    }
}
