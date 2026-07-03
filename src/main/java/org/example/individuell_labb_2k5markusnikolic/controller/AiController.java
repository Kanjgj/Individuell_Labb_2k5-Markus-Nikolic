package org.example.individuell_labb_2k5markusnikolic.controller;

import org.example.individuell_labb_2k5markusnikolic.service.AiClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AiController {

    private final AiClientService aiClientService;

    public AiController(AiClientService aiClientService) {
        this.aiClientService = aiClientService;
    }

    @GetMapping("/ask")
    public String askAi(@RequestParam String prompt) {
        return aiClientService.askAi(prompt);
    }
}