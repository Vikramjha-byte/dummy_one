package com.ipl_fantasy.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.ipl_fantasy.dao.AdminDao;
import com.ipl_fantasy.dto.AdminLogin;
import com.ipl_fantasy.entities.*;
import com.ipl_fantasy.services.*;
import com.ipl_fantasy.utils.*;



@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired 
	AdminService adminservice;
	@Autowired
	AdminDao ad;
	@PostMapping("/register")
	public ResponseEntity<String> registerBidder(@RequestBody AdminEntity admin) {
		System.out.println(admin);
		AdminEntity registerBidder = adminservice.registerBidder(admin);
		
		return new ResponseEntity<>("Admin registered successfully!",HttpStatus.OK);
	}
	@PostMapping("/login")
    public ResponseEntity<String> loginAdmin(@RequestBody AdminLogin login) 
		throws UsernameNotFoundException ,IncorrectPasswordException{
		adminservice.loginAdmin(login);
		return new ResponseEntity<String>("logged in",HttpStatus.OK);
	}
	@GetMapping("/details")
	public List<AdminEntity> getde() {
		return ad.findAll();
	}
	
	@PostMapping("/create-tournament")
	public ResponseEntity<String> createTournament(@RequestBody Tournament tournament){
		adminservice.createTournament(tournament);
		return new ResponseEntity<String>("Tournament Created Successfully!!!",HttpStatus.OK);		
	}
	
	@PostMapping("/create-team")
	public ResponseEntity<String> createTeam(@RequestBody TeamDetails team, @RequestParam("image") MultipartFile multipartFile) throws IOException{
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		team.setPhotos(fileName);
		TeamDetails createTeam = adminservice.createTeam(team);
		String uploadDir = "team-photos/" + createTeam.getTeam_id();
		 
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
		return new ResponseEntity<String>("Team Created Successfully!!!",HttpStatus.OK);		
	}
	
	@PostMapping("/match-schedule")
	public ResponseEntity<String> schedulematch(@RequestBody MatchScheduleEntity match){
		adminservice.scheduleMatch(match);
		return new ResponseEntity<String>("Match Scheduled Successfully!!!",HttpStatus.OK);		
	}
	
	@PutMapping("/match-reschedule/{match_id}")
	public ResponseEntity<String> reschedulematch(@PathVariable Integer match_id){
		adminservice.rescheduleMatch(match_id);
		return new ResponseEntity<String>("Match Rescheduled Successfully!!!",HttpStatus.OK);		
	}
	
	@PutMapping("/update-team/{t_id}")
	public ResponseEntity<String> updateTeams(@PathVariable Integer t_id ,@RequestParam("image") MultipartFile file, @RequestBody TeamDetails team ) throws IOException{
		String fileName=StringUtils.cleanPath(file.getOriginalFilename());
		team.setPhotos(fileName);
		TeamDetails updateTeam = adminservice.updateTeam(t_id,team);
		String uploadDir="team-photos/"+ team.getTeam_id();
		FileUploadUtil.saveFile(uploadDir, fileName, file);
		return new ResponseEntity<String>("Team updated Successfully!!!",HttpStatus.OK);		
	}
	
	@DeleteMapping("/update-team/{match_id}")
	public ResponseEntity<String> CancelMatch(@PathVariable Integer match_id  ){
		adminservice.cancelMatch(match_id);
		return new ResponseEntity<>("Match canceled!!!",HttpStatus.OK);		
	}
	
	@PostMapping("/result")
	public ResponseEntity<String> matchResult(@RequestBody TeamPoints points){
		adminservice.matchResult(points);
		return new ResponseEntity<String>("Result Added Successfully!!!",HttpStatus.OK);		
	}
	@GetMapping("/biddings")
	public ResponseEntity<?> getBiddings(){
		return new ResponseEntity<>(adminservice.getBiddings(),HttpStatus.OK);
	}
	@GetMapping("/teams")
	public ResponseEntity<?> getTeams(){
		return new ResponseEntity<>(adminservice.getTeams(),HttpStatus.OK);
	}
	@GetMapping("/teams/{team_id}")
	public ResponseEntity<?> getTeamById(@PathVariable Integer team_id){
		System.out.println(adminservice.getTeamsById(team_id).getPhotos());
		return new ResponseEntity<>(adminservice.getTeamsById(team_id),HttpStatus.OK);
	}
	
	@GetMapping("/matches")
	public ResponseEntity<?> getMatch(){
		return new ResponseEntity<>(adminservice.getMatch(),HttpStatus.OK);
	}
}
