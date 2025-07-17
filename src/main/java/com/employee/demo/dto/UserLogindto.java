package com.employee.demo.dto;
import lombok.Data;
//UserLoginDto.java
@Data
public class UserLogindto {
	  
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
		private String mobile;
	    private String password;
		
	}



