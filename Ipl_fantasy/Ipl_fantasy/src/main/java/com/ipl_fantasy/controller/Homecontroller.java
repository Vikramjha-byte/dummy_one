package com.ipl_fantasy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipl_fantasy.entities.AdminEntity;
import com.ipl_fantasy.entities.UserEntity;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class Homecontroller {

	@GetMapping("")
	public String getHomePage() {
		return "home";
		
	}
	@GetMapping("/loginbidder")
	public String getBidderPage(Model model) {
		System.out.println("opening bidder page");
		model.addAttribute("loginData",new UserEntity());
		return "bidder";
		
	}
	
	@GetMapping("/register")
	public String showSignUpForm(Model model) {
		model.addAttribute("bidder",new UserEntity());
		return "register";
	}
	@GetMapping("/aregister")
	public String showAdminSignUpForm(Model model) {
		model.addAttribute("admin",new AdminEntity());
		return "admin_register";
	}
	@GetMapping("/login")
	public String getAdminPage() {
		return "admin";
		
	}
	@GetMapping("/guest")
	public String getGuestPage() {
		return "redirect:home";
		
	}
}
