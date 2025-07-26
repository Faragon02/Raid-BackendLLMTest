package com.example.raidbackendtestllm.narration.llm;

import java.util.Map;

import com.example.raidbackendtestllm.narration.dto.OllamaTestResponseDto;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class OllamaClient implements LLMClient {
	private final WebClient webClient = WebClient.create("http://localhost:11434");

	@Override
	public String  generate(String prompt) {
		Map<String, Object> request = Map.of(
			"model", "mistral",
			"prompt", prompt,
			"stream", false
		);

		return webClient.post()
				.uri("/api/generate")
				.contentType(MediaType.APPLICATION_JSON)
				.bodyValue(request)
				.retrieve()
				.bodyToMono(OllamaTestResponseDto.class)
				.map(OllamaTestResponseDto::response)
				.block();

	}

}
