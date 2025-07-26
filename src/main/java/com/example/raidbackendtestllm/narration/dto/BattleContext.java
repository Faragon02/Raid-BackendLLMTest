package com.example.raidbackendtestllm.narration.dto;

import java.util.List;

import lombok.Getter;

@Getter
public class BattleContext {
	private String bossName;
	private String bossHp;
	private List<BattleCharacterStatus> party;
	private List<String> recentLogs;
	private String userLine;

	public BattleContext(String bossName, String bossHp, List<BattleCharacterStatus> party,
		List<String> recentLogs, String userLine) {
		this.bossName = bossName;
		this.bossHp = bossHp;
		this.party = party;
		this.recentLogs = recentLogs;
		this.userLine = userLine;
	}
}
