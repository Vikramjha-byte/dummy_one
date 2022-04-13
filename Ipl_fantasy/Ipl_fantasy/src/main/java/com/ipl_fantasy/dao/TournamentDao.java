package com.ipl_fantasy.dao;

import org.springframework.stereotype.Repository;

import com.ipl_fantasy.entities.Tournament;

import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface TournamentDao extends JpaRepository<Tournament,Integer> {

	
}
