package com.example.raidbackendtestllm.narration.dto;

import lombok.Getter;

@Getter
public class BattleCharacterStatus {
	private String name;
	private String currentState;
	private int hp;
	private String quote;
}
