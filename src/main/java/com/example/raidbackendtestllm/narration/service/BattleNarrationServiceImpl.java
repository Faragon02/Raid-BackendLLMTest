package com.example.raidbackendtestllm.narration.service;

import java.util.Arrays;
import java.util.List;

import com.example.raidbackendtestllm.narration.dto.BattleContext;
import com.example.raidbackendtestllm.narration.llm.OllamaClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BattleNarrationServiceImpl implements BattleNarrationService{

	private final OllamaClient ollamaClient;
	@Override
	public String generateDialogue(BattleContext context) {
		String prompt = buildPrompt(context);
		String llmOutput = callLLM(prompt);

		return llmOutput;
	}

	private String buildPrompt(BattleContext context) {

//		return  "보스 이름은 죽음의 군주, hp는 32000이야. 상대는 탱커, hp가 2000 남았고, 힐러는 hp 1200이고," +
//				"이전 턴에서 유저는 힐러가 회복 마법을 사용했다. 그리고 보스는 보스가 어둠의 칼날을 사용했다.라고 했어." +
//				" 현재 유저 턴이며 딜러가 화염구를 사용한다.라고 한다면 보스는 데미지를 받아야 하는 상황에 맞게 대사만을 출력해줄래?";

		// 보스 상태
		//


		return  "보스 이름은 " +context.getBossName() +
				", hp는" +  context.getBossHp() + "이야. " +
				"상대는" + context.getParty().get(0).getName() +
				", hp가" + context.getParty().get(0).getHp() + " 남았고,"
				+ context.getParty().get(1).getName() +
				", hp가" + context.getParty().get(1).getHp() + "이고," +
				"이전 턴에서 유저는 "+ context.getRecentLogs().get(0) +
				" 그리고 보스는"+ context.getRecentLogs().get(1)
				+"라고 했어." + " 현재 유저의 캐릭터 턴이며" + context.getUserLine() + "라고 했다."
		+ "한국어로 보스의 피격 판정을 받았을때 '*상황 설명* 대사' 이러식으로 출력해줄래?";
	}
	private String callLLM(String prompt) {
		return ollamaClient.generate(prompt);
	}

	private List<String> extractDialogues(String output){
		return Arrays.stream(output.split("\n"))
			.filter(line ->line.startsWith("["))
			.toList();
	}
}
