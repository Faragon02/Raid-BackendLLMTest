package com.example.raidbackendtestllm.narration.dto;

import lombok.Getter;

@Getter
public class BattleNarrationRequest {
	private BattleContext context;
	private String userLine;
}
