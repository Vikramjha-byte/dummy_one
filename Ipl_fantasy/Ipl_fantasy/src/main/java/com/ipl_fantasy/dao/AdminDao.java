package com.ipl_fantasy.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ipl_fantasy.entities.AdminEntity;


@Repository
public interface AdminDao extends JpaRepository<AdminEntity, Integer> {
       public AdminEntity findByUsername(String user_name);
}
