package com.ipl_fantasy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipl_fantasy.dto.MatchStatsDto;
import com.ipl_fantasy.services.SystemService;


@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class SystemController {

	@Autowired
	SystemService systemService;
	
	@GetMapping("/home")
	public ResponseEntity<List<MatchStatsDto>> getMatchStats(){
		return new ResponseEntity<>(systemService.getTeamStats(),HttpStatus.OK);
	}	

}
