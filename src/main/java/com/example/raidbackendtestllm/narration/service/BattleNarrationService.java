package com.example.raidbackendtestllm.narration.service;

import java.util.List;

import com.example.raidbackendtestllm.narration.dto.BattleContext;

public interface BattleNarrationService {
	List<String> generateDialogue(BattleContext context, String userLine);



}
