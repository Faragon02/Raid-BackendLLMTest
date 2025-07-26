package com.example.raidbackendtestllm.narration.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record OllamaTestResponseDto(
        String model,
        @JsonProperty("created_at") String createdAt,
        String response,
        boolean done
) {}