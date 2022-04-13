package com.ipl_fantasy.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ipl_fantasy.entities.MatchDetailsEntity;


@Repository
public interface MatchDetailsDao extends JpaRepository<MatchDetailsEntity, Integer> {

}
