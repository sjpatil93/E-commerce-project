package com.employee.demo.dto;
import lombok.Data;

@Data
public class UserRegisterdto {

    private String name;
    private String username;
    private String address;
    private String password;

    // Correct field name: mobile
    private String mobile;
    

   

	// Correct getter and setter
    public String getMobile() {
        return mobile;
    }

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
