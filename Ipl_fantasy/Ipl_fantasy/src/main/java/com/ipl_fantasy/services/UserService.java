package com.ipl_fantasy.services;

import java.util.List;
//import java.util.Optional;

import com.ipl_fantasy.dto.*;
import com.ipl_fantasy.entities.*;
import com.ipl_fantasy.utils.*;



public interface UserService {

	public void userRegistration(UserDTO userdto) throws UserAlreadyExistException,UserNameAlreadyExistException;

	public List<UserDTO> getBidders();

	public List<MatchScheduleDTO> getMatchsScheduled();

	public void userBid(BidDTO biddto);

	public List<MatchDetailsEntity> getMatchsDetails();

	public void cancelBid(Integer b_id);

	public List<TeamPoints> getTeamPoints();

	public List<LeaderBoard> getBidderBoard();

	public UserEntity userlogin(UserCridentials login)throws UsernameNotFoundException,IncorrectPasswordException;
	

}
