package com.example.raidbackendtestllm.narration.contoller;

import com.example.raidbackendtestllm.narration.dto.OllamaTestRequestDto;
import com.example.raidbackendtestllm.narration.llm.OllamaClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/llm")
@RequiredArgsConstructor
public class OllamaTestController {
    private final OllamaClient ollamaClient;

    @PostMapping
    public ResponseEntity<String> narration(@RequestBody OllamaTestRequestDto requestDto){

        String response = ollamaClient.generate(requestDto.getPrompt());
        return ResponseEntity.ok(response);
    }

}
