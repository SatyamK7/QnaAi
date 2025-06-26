package com.ai.gemini_chat;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/qna")
//@AllArgsConstructor
public class AIController {
    private final QnaService qnaService;


    public AIController(QnaService qnaService) {
        this.qnaService = qnaService;
    }

    @PostMapping
    public ResponseEntity<String> askQuestion(@RequestBody Map<String,String> payload) {
        String question = payload.get("question");
        String answer = qnaService.getAnswer(question);
        return ResponseEntity.ok(answer);
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

}
