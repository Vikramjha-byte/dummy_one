package com.ipl_fantasy.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ipl_fantasy.entities.TeamPoints;


@Repository
public interface TeamPointsDao extends JpaRepository<TeamPoints, Integer> {

}
