package com.ipl_fantasy.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Team_details")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class TeamDetails {

	@Override
	public String toString() {
		return "TeamDetails [team_id=" + team_id + ", team_name=" + team_name + ", full_name=" + full_name
				+ ", home_ground=" + home_ground + ", team_players=" + team_players + ", captain=" + captain
				+ ", photos=" + photos + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer team_id;
	@Size(max = 50)
	private String team_name;
	private String full_name;

	

	@Size(max = 50)
	private String home_ground;
	@Size(max = 256)
	private String team_players;
	@Size(max = 50)
	private String captain;
	@Column(nullable = true, length = 64)
	private String photos;
	
	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getPhotos() {
		return photos;
	}

	public void setPhotos(String photos) {
		this.photos = photos;
	}

	public Integer getTeam_id() {
		return team_id;
	}

	public void setTeam_id(Integer team_id) {
		this.team_id = team_id;
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	public String getHome_ground() {
		return home_ground;
	}

	public void setHome_ground(String home_ground) {
		this.home_ground = home_ground;
	}

	public String getTeam_players() {
		return team_players;
	}

	public void setTeam_players(String team_players) {
		this.team_players = team_players;
	}

	public String getCaptain() {
		return captain;
	}

	public void setCaptain(String captain) {
		this.captain = captain;
	}
}
