package com.example.raidbackendtestllm.narration.dto;

import lombok.Getter;

@Getter
public class BattleCharacterStatus {
	private String name;
	private String currentState;
	private int hp;
	private String quote;


	public BattleCharacterStatus(String name, String currentState, int hp, String quote) {
		this.name = name;
		this.currentState = currentState;
		this.hp = hp;
		this.quote = quote;
	}
}
