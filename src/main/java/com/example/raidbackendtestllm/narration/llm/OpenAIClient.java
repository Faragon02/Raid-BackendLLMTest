package com.example.raidbackendtestllm.narration.llm;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class OpenAIClient implements LLMClient{
	@Value("${openai.api.key}")
	private String apiKey;

	private final WebClient webClient = WebClient.create("https://api.openai.com");

	@Override
	public String generate(String prompt) {
		Map<String, Object> request = Map.of(
			"model", "gpt-4o",
			"messages", List.of(Map.of("role", "user", "content", prompt)),
			"temperature", 0.7
		);

		return webClient.post()
			.uri("/v1/chat/completions")
			.header("Authorization", "Bearer " + apiKey)
			.header("Content-Type", "application/json")
			.bodyValue(request)
			.retrieve()
			.bodyToMono(String.class)
			.block();
	}
}
