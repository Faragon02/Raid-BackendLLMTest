package com.example.raidbackendtestllm.narration.dto;

import java.util.List;

import lombok.Getter;

@Getter
public class BattleContext {
	private String bossName;
	private String bossHpDescription;
	private List<BattleCharacterStatus> party;
	private List<String> previousUserLines;
	private List<String> previousBossResponses;
}
