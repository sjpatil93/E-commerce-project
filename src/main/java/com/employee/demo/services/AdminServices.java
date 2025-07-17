package com.employee.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employee.demo.repository.AdminRepo;
import com.employee.demo.user.entity.AdminEntity;

import jakarta.servlet.http.HttpSession;


@Service
public class AdminServices {
	    @Autowired
	    private AdminRepo adminrepo;
	 
	      public String registeradmin(AdminEntity admin) {
	        AdminEntity existingUser = adminrepo.findByMobile(admin.getMobile());
	        if (existingUser!=null) {
	            return "Admin already registered!";
	        }

	        AdminEntity add = new AdminEntity();
			add.setName(admin.getName());
			add.setUsername(admin.getUsername());
			
			add.setMobile(admin.getMobile());
			add.setAddress(admin.getAddress());
			add.setStorename(admin.getStorename());
			 

	       adminrepo.save(admin);
	        return "Admin registered successfully!";
	    }

	    public String loginAdmin( AdminEntity admin, HttpSession session) {
	        Admin  admin1 = adminrepo.findByMobileAndPassword(admin.getMobile(), admin.getPassword());
	        if (admin1 != null) {
	            session.setAttribute("admin", admin1);
	            return "admin login successful!";
	        } else {
	            return "Invalid mobile number or password!";
	        }
	    }
	    public String logoutAdmin(HttpSession session) {
	        session.invalidate(); // This will remove admin session
	        return "Admin logged out successfully!";
	    }
	  
		
}
