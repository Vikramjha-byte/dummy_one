package com.ipl_fantasy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.ipl_fantasy.dao.*;
import com.ipl_fantasy.dto.*;
import com.ipl_fantasy.entities.*;
import com.ipl_fantasy.utils.*;


@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	TournamentDao tourrepo;

	@Autowired
	TeamPointsDao pointsrepo;
	@Autowired
	TeamDao teams;
	@Autowired
	MatchScheduleDao matchschedule;
	@Autowired
	BidDetailsDao bids;
	
	@Autowired
	AdminDao adminLogin;
	
	@Autowired
	MatchDetailsDao matchDetailsDao;

	@Override
	public void createTournament(Tournament tournament) {
		tourrepo.save(tournament);
	}

	@Override
	public TeamDetails createTeam(TeamDetails team) {
		TeamDetails save = teams.save(team);
		return save;
	}

	@Override
	public void scheduleMatch(MatchScheduleEntity match) {
		matchschedule.save(match);

	}

	@Override
	public void rescheduleMatch(Integer id) {		
		matchschedule.save(matchschedule.getById(id));		
	}

	@Override
	public void matchResult(TeamPoints points) {
		pointsrepo.save(points);
		
	}

	@Override
	public List<BidEntity> getBiddings() {
		return bids.findAll();
	}

	@Override
	public Boolean loginAdmin(AdminLogin login) throws UsernameNotFoundException, IncorrectPasswordException {
		PasswordEncoder passencoder = new BCryptPasswordEncoder();
		AdminEntity adment = adminLogin.findByUsername(login.getUsername());
		if(adment==null) {
			throw new UsernameNotFoundException("username not found");
		}
		else{			
			if(!passencoder.matches(login.getPassword(), adment.getPassword())){
				throw new IncorrectPasswordException("incorrrect password");
			}
		return null;
	}
	}

	@Override
	public TeamDetails updateTeam(Integer t_id,TeamDetails team) {
		TeamDetails teamDetails = teams.getById(t_id);
		teamDetails.setFull_name(team.getFull_name());
		teamDetails.setCaptain(team.getCaptain());
		teamDetails.setPhotos(team.getPhotos());
		teamDetails.setTeam_name(team.getTeam_name());
		teamDetails.setTeam_players(team.getTeam_players());
		TeamDetails save = teams.save(teamDetails);	
		return save;
	}

	@Override
	public void cancelMatch(Integer match_id) {
		matchschedule.delete(matchschedule.getById(match_id));		
	}

	@Override
	public AdminEntity registerBidder(AdminEntity admin) {
		PasswordEncoder passwordEncoder= new BCryptPasswordEncoder();
		String encode = passwordEncoder.encode(admin.getPassword());
		admin.setPassword(encode);
		if (adminLogin.findByUsername(admin.getUsername()) != null) {
			throw new UserNameAlreadyExistException("Username already Exist!");
		}
		AdminEntity save = adminLogin.save(admin);
		return save;
	}

	@Override
	public List<TeamDetails> getTeams() {
		return teams.findAll();
	}

	@Override
	public TeamDetails getTeamsById( Integer team_id) {
		// TODO Auto-generated method stub
//		System.out.println(teams.getById(team_id));
		return teams.getById(team_id);
	}

	@Override
	public List<MatchDetailsEntity> getMatch() {
		List<MatchDetailsEntity> findAll = matchDetailsDao.findAll();
		return findAll;
	}

}
