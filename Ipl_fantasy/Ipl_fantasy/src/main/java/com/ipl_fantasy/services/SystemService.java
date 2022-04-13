package com.ipl_fantasy.services;

import java.util.List;

import com.ipl_fantasy.dto.MatchStatsDto;



public interface SystemService {

	List<MatchStatsDto> getTeamStats();

	
}
