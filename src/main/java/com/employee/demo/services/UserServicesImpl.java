package com.employee.demo.services;

import com.employee.demo.dto.UserLogindto;
import com.employee.demo.dto.UserRegisterdto;
import com.employee.demo.repository.UserRepo;
import com.employee.demo.user.entity.Userentity;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class UserServicesImpl implements UserServices {

    @Autowired
    private UserRepo userRepository;

    public String registerUser(UserRegisterdto userDto) {
        Userentity existingUser = userRepository.findByMobile(userDto.getMobile());
        if (existingUser!=null) {
            return "Username already registered!";
        }

        Userentity user = new Userentity();
		
		  user.setName(userDto.getName()); 
		  user.setUsername(userDto.getUsername());
		  user.setAddress(userDto.getAddress());
		  user.setPassword(userDto.getPassword());
		 user.setUsername(userDto.getUsername());
           user.setMobile(userDto.getMobile()); 

        userRepository.save(user);
        return "User registered successfully!";
    }

    public String loginUser( UserLogindto loginDto, HttpSession session) {
        Userentity user = userRepository.findByMobileAndPassword(loginDto.getMobile(), loginDto.getPassword());
        if (user != null) {
            session.setAttribute("user", user);
            return "User login successful!";
        } else {
            return "Invalid mobile number or password!";
        }
    }

	
	

	
	}

