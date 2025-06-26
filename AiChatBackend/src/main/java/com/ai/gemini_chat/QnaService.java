package com.ai.gemini_chat;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;

//@Service
//public class QnaService {
//    // Access to the api key and url
//    @Value("${gemini.api.url}")
//    private String geminiApiUrl;
//
//    @Value("${gemini.api.key}")
//    private String geminiApiKey;
//
//    private WebClient webClient;
//
//
//
//    public QnaService(WebClient.Builder webClientBuilder) {
//        this.webClient = webClientBuilder.build();
//    }
//
//
//    public String getAnswer(String question) {
//        // Constructing the request payload
//        Map<String,Object> requestBody = Map.of(
//                "content",new Object[]{
//                        Map.of(
//                                "parts",new Object[] {
//                                        Map.of("text",question)
//                                }
//                        )
//                }
//        );
//
//
//
//        // Make the api call
//        String response = webClient.post()
//                .uri(geminiApiUrl + geminiApiKey)
//                .header("Content-Type","application/json")
//                .bodyValue(requestBody)
//                .retrieve()
//                .bodyToMono(String.class)
//                .block();
//
//        // Return the response of the question
//        return response;
//    }
//}
//
//


//    public String getAnswer(String question) {
//        // Correct structure expected by Gemini API
//        Map<String, Object> requestBody = Map.of(
//                "contents", List.of(
//                        Map.of(
//                                "parts", List.of(
//                                        Map.of("text", question)
//                                )
//                        )
//                )
//        );
//
//        // Make the API call
//        String response = webClient.post()
//                .uri(uriBuilder -> uriBuilder
//                        .path("/v1beta/models/gemini-2.0-flash:generateContent")
//                        .queryParam("key", geminiApiKey)
//                        .build())
//                .header("Content-Type", "application/json")
//                .bodyValue(requestBody)
//                .retrieve()
//                .bodyToMono(String.class)
//                .block();
//
//        return response;
//    }
//}

//
//
//
//
@Service
public class QnaService {

    @Value("${gemini.api.key}")
    private String geminiApiKey;

    private final WebClient webClient;

    public QnaService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
                .baseUrl("https://generativelanguage.googleapis.com") // 🔥 Base URL must be correct
                .build();
    }

    public String getAnswer(String question) {
        Map<String, Object> requestBody = Map.of(
                "contents", List.of(
                        Map.of(
                                "parts", List.of(
                                        Map.of("text", question)
                                )
                        )
                )
        );

        return webClient.post()
                .uri(uriBuilder -> uriBuilder
                        .path("/v1beta/models/gemini-2.0-flash:generateContent")
                        .queryParam("key", geminiApiKey)
                        .build())
                .header("Content-Type", "application/json")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
