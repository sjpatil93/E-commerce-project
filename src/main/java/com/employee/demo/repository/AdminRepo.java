package com.employee.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.demo.services.Admin;
import com.employee.demo.user.entity.AdminEntity;
@Repository
public interface AdminRepo extends JpaRepository<AdminEntity,Long>{

	AdminEntity findByMobile(String mobile);

	Admin findByMobileAndPassword(String mobile, String password);

}
