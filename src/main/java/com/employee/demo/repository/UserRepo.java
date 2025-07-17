package com.employee.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.demo.user.entity.Userentity;
@Repository
public interface UserRepo extends JpaRepository<Userentity, Long> {
	 Userentity findByMobileAndPassword(String mobile, String password);
	    Userentity findByMobile(String mobile);

	}
