package com.employee.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.demo.services.AdminServices;
import com.employee.demo.user.entity.AdminEntity;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class AdminController {
	
	@Autowired
	private AdminServices adminservice;
	
	
	@PostMapping("/registeradmin")
	public String registeradmin(@RequestBody AdminEntity admin) {
		
		return adminservice.registeradmin(admin); // Use service method
	}


	@PostMapping("/loginadmin")
	 public String loginAdmin(@RequestBody  AdminEntity admin, HttpSession session) {
		return adminservice.loginAdmin(admin, session);
		
		
	}

	@PostMapping("/logoutadmin")
	public String logoutAdmin(HttpSession session) {
		return adminservice.logoutAdmin(session);
	}
}


