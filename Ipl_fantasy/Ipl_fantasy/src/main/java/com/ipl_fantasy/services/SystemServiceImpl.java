package com.ipl_fantasy.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipl_fantasy.dao.MatchDetailsDao;
import com.ipl_fantasy.dto.MatchStatsDto;
import com.ipl_fantasy.utils.TeamStatsUtils;



@Service
public class SystemServiceImpl implements SystemService {

	@Autowired
	MatchDetailsDao matches;
	@Override
	public List<MatchStatsDto> getTeamStats() {
		List<MatchStatsDto> matchdto = TeamStatsUtils.convertToMatchStatsList(matches.findAll());
		return matchdto.stream().filter(e->e.getStatus().equals("finished")).collect(Collectors.toList());		
	}

}
