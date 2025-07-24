package com.example.raidbackendtestllm.narration.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import com.example.raidbackendtestllm.narration.dto.BattleContext;

@Service
public class BattleNarrationServiceImpl implements BattleNarrationService{
	@Override
	public List<String> generateDialogue(BattleContext context, String userLine) {
		String prompt = buildPrompt(context, userLine);
		String llmOutput = callLLM(prompt);

		return extractDialogues(llmOutput);
	}

	private String buildPrompt(BattleContext context, String userLine) {
		return "전투 상황: 보스의 이름은 니벨롱겐이라는 마인인데 전사 Paragon이 공격해서 결정타를 내는 상황이야, "
			+ "Test용으로 맛깔나게 아무거나 출력해줘봐~!";
	}
	private String callLLM(String prompt) {
		return prompt;
	}

	private List<String> extractDialogues(String output){
		return Arrays.stream(output.split("\n"))
			.filter(line ->line.startsWith("["))
			.toList();
	}
}
