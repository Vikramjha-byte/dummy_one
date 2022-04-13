package com.ipl_fantasy.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ipl_fantasy.entities.UserEntity;



@Repository
public interface UserDao extends  JpaRepository<UserEntity,Integer> {
	public UserEntity findByEmail(String email);
	UserEntity findByUsername(String username);
}
