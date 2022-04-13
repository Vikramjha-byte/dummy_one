package com.gaur.Foodies_Rest;

import java.util.List;

public class Foodies {
	private int id;
	private String name;
	private List<Restaurant> res;
	private List<String> branches;
	public Foodies(int id, String name, List<Restaurant> res, List<String> branches) {
		super();
		this.id = id;
		this.name = name;
		this.res = res;
		this.branches = branches;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Restaurant> getRes() {
		return res;
	}
	public void setRes(List<Restaurant> res) {
		this.res = res;
	}
	public List<String> getBranches() {
		return branches;
	}
	public void setBranches(List<String> branches) {
		this.branches = branches;
	}

}
