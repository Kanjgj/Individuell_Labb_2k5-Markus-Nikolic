package org.example.individuell_labb_2k5markusnikolic.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Map;

@Service
public class AiClientService {

    @Value("${openai.api.key}")
    private String apiKey;

    private RestClient restClient;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @PostConstruct
    public void init() {
        if (apiKey == null || apiKey.isBlank()) {
            throw new IllegalStateException("CRITICAL: API key is missing.");
        }

        restClient = RestClient.builder()
                .baseUrl("https://api.openai.com/v1")
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public String askAi(String prompt) {

        Map<String, Object> body = Map.of(
                "model", "gpt-4.1-mini",
                "input", prompt
        );

        String response = restClient.post()
                .uri("/responses")
                .body(body)
                .retrieve()
                .body(String.class);

        try {
            JsonNode json = objectMapper.readTree(response);
            return json.path("output")
                    .get(0)
                    .path("content")
                    .get(0)
                    .path("text")
                    .asText();
        } catch (Exception e) {
            return "Kunde inte läsa AI-svaret.";
        }
    }
}