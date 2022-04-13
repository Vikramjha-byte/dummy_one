package com.ipl_fantasy.services;

import java.util.List;

import com.ipl_fantasy.dto.AdminLogin;
import com.ipl_fantasy.entities.*;
import com.ipl_fantasy.utils.*;



public interface AdminService {

	void createTournament(Tournament tournament);

	TeamDetails createTeam(TeamDetails team);

	void scheduleMatch(MatchScheduleEntity match);

	void rescheduleMatch(Integer match_id);

	void matchResult(TeamPoints points);

	List<BidEntity> getBiddings();

	Boolean loginAdmin(AdminLogin login) throws UsernameNotFoundException ,IncorrectPasswordException;

	TeamDetails updateTeam(Integer t_id,TeamDetails team);

	void cancelMatch(Integer match_id);

	AdminEntity registerBidder(AdminEntity admin);

	List<TeamDetails> getTeams();

	TeamDetails getTeamsById(Integer team_id);

	List<MatchDetailsEntity> getMatch();

}
