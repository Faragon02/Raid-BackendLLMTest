package com.example.raidbackendtestllm.narration.llm;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class OllamaClient implements LLMClient {
	private final WebClient webClient = WebClient.create("http://localhost:11434");

	@Override
	public String generate(String prompt) {
		Map<String, Object> request = Map.of(
			"model", "mistral",
			"prompt", prompt,
			"stream", false
		);

		return webClient.post()
			.uri("/api/generate")
			.header("Content-Type", "application/json")
			.bodyValue(request)
			.retrieve()
			.bodyToMono(String.class)
			.block();
	}
}
