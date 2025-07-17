package com.employee.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.demo.dto.UserLogindto;
import com.employee.demo.dto.UserRegisterdto;
import com.employee.demo.repository.UserRepo;
import com.employee.demo.services.UserServicesImpl;
import com.employee.demo.user.entity.Userentity;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class UserController {

	@Autowired
	private UserServicesImpl userService;

	@PostMapping("/register")
	public String registerUser(@RequestBody UserRegisterdto userDto) {
		
		return userService.registerUser(userDto); // Use service method
	}

	//private final String ADMIN_USERNAME = "user";
//	private final String ADMIN_PASSWORD = "user123";

	@PostMapping("/login")
	 public String loginUser(@RequestBody UserLogindto loginDto, HttpSession session) {
		return userService.loginUser(loginDto, session);
		
		
	}

	@PostMapping("/logout")
	public String logoutUser(HttpSession session) {
		session.invalidate();
		return "Logout successful!";
	}
}
