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

	public BattleContext(String bossName, String bossHpDescription, List<BattleCharacterStatus> party,
		List<String> previousUserLines, List<String> previousBossResponses) {
		this.bossName = bossName;
		this.bossHpDescription = bossHpDescription;
		this.party = party;
		this.previousUserLines = previousUserLines;
		this.previousBossResponses = previousBossResponses;
	}
}
