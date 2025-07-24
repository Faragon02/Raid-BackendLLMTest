package com.example.raidbackendtestllm.narration.contoller;

import java.util.List;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.raidbackendtestllm.narration.dto.BattleNarrationRequest;
import com.example.raidbackendtestllm.narration.service.BattleNarrationService;

@RestController
@RequestMapping("/narrations")
@RequiredArgsConstructor
public class NarrationController {

	private final BattleNarrationService battleNarrationService;

	@PostMapping
	public List<String> getNarration(@RequestBody BattleNarrationRequest request){
		return battleNarrationService.generateDialogue(request.getContext(), request.getUserLine());
	}
}
