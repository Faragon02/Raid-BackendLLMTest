package com.example.raidbackendtestllm.narration.dto;

import lombok.Getter;

@Getter
public class BattleCharacterStatus {
	private String name;
	private String currentState;
	private Integer hp;


	public BattleCharacterStatus(String name, String currentState, Integer hp, String quote) {
		this.name = name;
		this.currentState = currentState;
		this.hp = hp;
	}
}
