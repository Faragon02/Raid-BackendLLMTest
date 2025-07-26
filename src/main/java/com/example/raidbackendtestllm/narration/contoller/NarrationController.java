package com.example.raidbackendtestllm.narration.contoller;

import java.util.List;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.raidbackendtestllm.narration.dto.BattleNarrationRequest;
import com.example.raidbackendtestllm.narration.service.BattleNarrationService;

@RestController
@RequestMapping("/llm/narrations")
@RequiredArgsConstructor
public class NarrationController {

	private final BattleNarrationService battleNarrationService;


	@PostMapping
	public ResponseEntity<String> getNarration(@RequestBody BattleNarrationRequest request){
		return  ResponseEntity.ok(battleNarrationService.generateDialogue(request.getContext()));
	}
}
