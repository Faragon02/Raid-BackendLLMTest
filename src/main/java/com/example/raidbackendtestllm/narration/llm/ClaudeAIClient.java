package com.example.raidbackendtestllm.narration.llm;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ClaudeAIClient implements LLMClient {

	@Value("${claude.api.key}")
	private String apiKey;

	private final WebClient webClient = WebClient.create("https://api.anthropic.com");

	@Override
	public String generate(String prompt) {
		Map<String, Object> request = Map.of(
			"model", "claude-3-sonnet-20240229",
			"max_tokens", 1024,
			"messages", List.of(
				Map.of("role", "user", "content", prompt)
			)
		);

		return webClient.post()
			.uri("/v1/messages")
			.header("x-api-key", apiKey)
			.header("anthropic-version", "2023-06-01")
			.header("Content-Type", "application/json")
			.bodyValue(request)
			.retrieve()
			.bodyToMono(String.class)
			.block();
	}
}
